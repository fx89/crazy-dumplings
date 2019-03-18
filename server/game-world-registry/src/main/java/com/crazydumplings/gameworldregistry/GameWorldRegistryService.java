package com.crazydumplings.gameworldregistry;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.crazydumplings.gameworldregistry.exception.CrazyDumplingsGameWorldRegistryException;
import com.crazydumplings.gameworldregistry.model.GameAssetsRepository;
import com.crazydumplings.gameworldregistry.model.GameAssetsRepositoryOwner;
import com.crazydumplings.gameworldregistry.model.GameObjectType;
import com.crazydumplings.gameworldregistry.model.GameObjectTypeClass;
import com.crazydumplings.gameworldregistry.model.GameObjectTypeProperty;
import com.crazydumplings.gameworldregistry.model.GameObjectTypeState;
import com.crazydumplings.gameworldregistry.model.generic.IdentifiableGameAsset;
import com.crazydumplings.gameworldregistry.model.generic.ParentableGameAsset;

/**
 * Defines the main service interface for accessing the game world registry. Data source can be injected.
 */
@Service
public class GameWorldRegistryService {
    private GameWorldRegistryDataService dataService;


    private GenericOperationsDelegate<GameObjectTypeProperty> gameObjectTypePropertiesOperationsDelegate;
    private GenericOperationsDelegate<GameObjectTypeState> gameObjectTypeStatesOperationsDelegate;




    public GameWorldRegistryDataService getDataService() {
        return dataService;
    }

    public void setDataService(GameWorldRegistryDataService dataService) {
        this.dataService = dataService;
    }

    public GameWorldRegistryService() {

    }


    @PostConstruct
    public void init() {
        gameObjectTypePropertiesOperationsDelegate = new GenericOperationsDelegate<>(
             // Bulk save operation
                (assets) -> dataService.saveGameObjectTypeProperties(assets), // Bulk save operation

             // Bulk search operation
                (parentAsset, childAssetIds) -> dataService.findAllGameObjectTypePropertiesByGameObjectTypeIdAndIds(parentAsset.getId(), childAssetIds),

             // Parent search operation
                (repoId, parentAssetId) -> getGameObjectTypeOrThrow(repoId, parentAssetId),

             // Search by parent function
                (parentAsset) -> dataService.findAllGameObjectTypePropertiesByGameObjectTypeId(parentAsset.getId()),

             // Properties update operation (inputData = what comes from the front end, registeredAsset = what's in the registry)
                (inputData, registeredAsset) -> {
                    if (inputData.getPropertyName()         != null) registeredAsset.setPropertyName        (inputData.getPropertyName());
                    if (inputData.getPropertyDefaultValue() != null) registeredAsset.setPropertyDefaultValue(inputData.getPropertyDefaultValue());
                    if (inputData.getPropertyMinValue()     != null) registeredAsset.setPropertyMinValue    (inputData.getPropertyMinValue());
                    if (inputData.getPropertyMaxValue()     != null) registeredAsset.setPropertyMaxValue    (inputData.getPropertyMaxValue());
                },

             // Bulk delete operation
                (assetIds) -> dataService.deleteGameObjectTypePropertiesByIds(assetIds)
        );

        gameObjectTypeStatesOperationsDelegate = new GenericOperationsDelegate<GameObjectTypeState>(
             // Bulk save operation -- There is no bulk save operation for game object type states
                (assets) -> assets.stream().map(asset -> dataService.saveGameObjectTypeState((GameObjectTypeState)asset)).collect(Collectors.toList()) ,

             // Bulk search operation -- There is no bulk search operation for game object type states
                (parentAsset, childAssetIds) -> dataService.findAllGameObjectTypeStatesByGameObjectTypeIdAndIds(parentAsset.getId(), childAssetIds),

             // Parent search operation
                (repoId, parentAssetId) -> getGameObjectTypeOrThrow(repoId, parentAssetId),

             // Search by parent function
                (parentAsset) -> dataService.findAllGameObjectTypeStatesByGameObjectTypeId(parentAsset.getId()),

             // Properties update operation (inputData = what comes from the front end, registeredAsset = what's in the registry)
                (inputData, registeredAsset) -> {
                    if (inputData.getName() != null) registeredAsset.setName(inputData.getName());
                },

             // Bulk delete operation
                (assetIds) -> dataService.deleteGameObjectTypeStatesByIds(assetIds)
        );
    }





    public List<GameAssetsRepository> getAllGameAssetsRepositories() {
    	return dataService.findAllGameAssetsRepositories();
    }

    public void deleteGameAssetsRepository(Long repoId) {
        GameAssetsRepository rep = dataService.findGameAssetsRepository(repoId);

        dataService.deleteGameAssetsRepositoryOwnersByGameAssetsRepositoryId(rep.getId());

        dataService.deleteGameAssetsRepository(rep);
    }

    public GameAssetsRepository saveGameAssetsRepository(Long repoId, String uniqueName, String description, String pictureHash, Long currentUserId) {
        GameAssetsRepository rep;

     // If the caller supplies a valid id for the repository, then the repository must be updated.
     // Since the repository must be updated, it must first be retrieved from the registry so that it can be confirmed that it exists
     // If, however, the provided repository id is not valid, then a new repository must be created
        if (repoId != null && repoId > 0) {
            rep = getRepositoryOrThrow(repoId);
        } else {
            rep = dataService.newGameAssetsRepository();
        }

     // Regardless of whether or not the repository already exists, the attributes must be set
     // Attributes should be set only if provided
        if (uniqueName  != null) rep.setUniqueName (uniqueName );
        if (description != null) rep.setDescription(description);
        if (pictureHash != null) rep.setPictureHash(pictureHash);

        rep = dataService.saveGameAssetsRepository(rep);

     // If the repository is new, then grant the current user access rights to the newly created repository
        if (repoId == null || repoId <= 0) {
            GameAssetsRepositoryOwner repOwner = dataService.newGameAssetsRepositoryOwner(rep.getId(), currentUserId);
            dataService.saveGameAssetsRepositoryOwner(repOwner);
        }

     // Return a reference to the newly created repository
        return rep;
    }

    private GameAssetsRepository getRepositoryOrThrow(Long repoId) throws CrazyDumplingsGameWorldRegistryException {
        GameAssetsRepository rep = dataService.findGameAssetsRepository(repoId);

        if (rep == null)
            throw new CrazyDumplingsGameWorldRegistryException("A repository having the id [" + repoId + "] does not exist in the registry");

        return rep;
    }







    public List<GameObjectTypeClass> getGameObjectTypeClasses() {
        return dataService.findAllGameObjectTypeClasses();
    }

    public GameObjectTypeClass addGameObjectTypeClass(String name) {
        GameObjectTypeClass typeClass = dataService.newGameObjectTypeClass();
        typeClass.setName(name);
        return dataService.saveGameObjectTypeClass(typeClass);
    }

    private GameObjectTypeClass getGameObjectTypeClassyOrThrow(Long classId) throws CrazyDumplingsGameWorldRegistryException {
        GameObjectTypeClass cls = dataService.findGameObjectTypeClass(classId);

        if (cls == null)
            throw new CrazyDumplingsGameWorldRegistryException("A game object type class having the id [" + classId + "] does not exist in the registry");

        return cls;
    }







    public List<GameObjectType> getGameObjectTypes(Long repostoryId) {
    	getRepositoryOrThrow(repostoryId);
        return dataService.findAllGameObjectTypesByGameAssetsRepositoryId(repostoryId);
    }

    /**
     * Update or create a game object type depending on the presence of a valid gameObjectTypeId
     */
    public GameObjectType saveGameObjectType(Long repositoryId, Long gameObjectTypeId, Long gameObjectTypeClassId, String uniqueName, String description, boolean experimental) {
        GameObjectType gameObjectType;

     // If the caller supplies a valid id for the game object type , then the type must be updated.
     // Since the type must be updated, it must first be retrieved from the repository so that it can be confirmed that the type is child to the given repository
     // If, however, the provided game object type id is not valid, then a new game object type must be created for the given repository
        if (gameObjectTypeId != null && gameObjectTypeId > 0) {
            gameObjectType = getGameObjectTypeOrThrow(repositoryId, gameObjectTypeId);
        } else {
            gameObjectType = dataService.newGameObjectType();
            getRepositoryOrThrow(repositoryId);
            gameObjectType.setGameAssetsRepositoryId(repositoryId);
        }

     // Regardless of whether or not the game object type already exists, the attributes must be set
     // Attributes should be set only if provided
        getGameObjectTypeClassyOrThrow(gameObjectTypeClassId);
        if (gameObjectTypeClassId != null) gameObjectType.setGameObjectTypeClassId(gameObjectTypeClassId);
        if (uniqueName            != null) gameObjectType.setUniqueName         (uniqueName);
                                           gameObjectType.setIsExperimental     (experimental);
        if (description           != null) gameObjectType.setDescription        (description);

     // Then the type must be saved into the repository
     // The saved instance should be returned to the caller for eventual future reference
        return dataService.saveGameObjectType(gameObjectType);
    }

    public void deleteGameObjectType(Long repositoryId, Long gameObjectTypeId) {
        GameObjectType gameObjectType = getGameObjectTypeOrThrow(repositoryId, gameObjectTypeId);
        dataService.deleteGameObjectTypePropertiesByGameObjectTypeId(gameObjectType.getId());
        dataService.deleteGameObjectType(gameObjectType);
    }

    private GameObjectType getGameObjectTypeOrThrow(Long repoId, Long assetId) throws CrazyDumplingsGameWorldRegistryException {
        GameObjectType gameObjectType = dataService.findGameObjectType(assetId);

        if (gameObjectType == null) {
            throw new CrazyDumplingsGameWorldRegistryException("A game object type having the id [" + assetId + "] does not exist in the registry");
        }

        if (gameObjectType.getGameAssetsRepositoryId() != repoId) {
            throw new CrazyDumplingsGameWorldRegistryException("The referenced game object type is not part of the referenced repository");
        }

        return gameObjectType;
    }







    /**
     * List the properties of the referenced game object type
     */
    public List<GameObjectTypeProperty> getGameObjectTypeProperties(Long repositoryId, Long gameObjectTypeId) {
        return gameObjectTypePropertiesOperationsDelegate.getByParentId(repositoryId, gameObjectTypeId);
    }

    /**
     * Update or create a game object type property depending on the presence of a valid gameObjectTypePropertyId
     */
    public GameObjectTypeProperty saveGameObjectTypeProperty(Long repositoryId, Long gameObjectTypeId, Long gameObjectTypePropertyId, String propertyName, Double propertyDefaultValue, Double propertyMinValue, Double propertyMaxValue) throws CrazyDumplingsGameWorldRegistryException {
        GameObjectTypeProperty gameObjectTypeProperty = createGameObjectTypePropertyInstance(
        		gameObjectTypeId, gameObjectTypePropertyId, propertyName, propertyDefaultValue, propertyMinValue, propertyMaxValue
        );

        return bulkSaveGameObjectTypeProperties(repositoryId, gameObjectTypeId, List.of(gameObjectTypeProperty)).get(0);
    }

    /**
     * Update or save one or more game object properties
     */
    public List<GameObjectTypeProperty> bulkSaveGameObjectTypeProperties(Long repositoryId, Long gameObjectTypeId, List<GameObjectTypeProperty> gameObjectTypeProperties) {
        return gameObjectTypePropertiesOperationsDelegate.bulkSaveGameAssets(repositoryId, gameObjectTypeId, gameObjectTypeProperties);
    }

    /**
     * Delete one or more game object properties
     */
    public void bulkDeleteGameObjectTypeProperties(Long repositoryId, Long gameObjectTypeId, List<Long> gameObjectTypePropertyIds) {
        gameObjectTypePropertiesOperationsDelegate.bulkDeleteGameAssets(repositoryId, gameObjectTypeId, gameObjectTypePropertyIds);
    }

    /**
     * Delete a game object property
     */
    public void deleteGameObjectTypeProperty(Long repositoryId, Long gameObjectTypeId, Long gameObjectTypePropertyId) {
        bulkDeleteGameObjectTypeProperties(repositoryId, gameObjectTypeId, List.of(gameObjectTypePropertyId));
    }

    /**
     * Create a new game object type property in memory and without saving it into the registry
     */
    public GameObjectTypeProperty createGameObjectTypePropertyInstance(
            Long gameObjectTypeId, Long gameObjectTypePropertyId,
            String propertyName, Double propertyDefaultValue, Double propertyMinValue, Double propertyMaxValue
    ) {
        GameObjectTypeProperty ret = dataService.newGameObjectTypeProperty(gameObjectTypePropertyId);

        ret.setGameObjectTypeId(gameObjectTypeId);
        ret.setPropertyName(propertyName);
        ret.setPropertyDefaultValue(propertyDefaultValue);
        ret.setPropertyMinValue(propertyMinValue);
        ret.setPropertyMaxValue(propertyMaxValue);

        return ret;
    }












    /**
     * List the states of the referenced game object type
     */
    public List<GameObjectTypeState> getGameObjectTypeStates(Long repositoryId, Long gameObjectTypeId) {
        return gameObjectTypeStatesOperationsDelegate.getByParentId(repositoryId, gameObjectTypeId);
    }

    /**
     * Update or create a game object type state depending on the presence of a valid gameObjectTypePropertyId
     */
    public GameObjectTypeState saveGameObjectTypeState(Long repositoryId, Long gameObjectTypeId, String name) throws CrazyDumplingsGameWorldRegistryException {
        GameObjectTypeState gameObjectTypeState = createGameObjectTypeStateInstance(gameObjectTypeId, name);
        return gameObjectTypeStatesOperationsDelegate.bulkSaveGameAssets(repositoryId, gameObjectTypeId, List.of(gameObjectTypeState)).get(0);
    }

    /**
     * Delete one or more game object states
     */
    public void bulkDeleteGameObjectTypeStates(Long repositoryId, Long gameObjectTypeId, List<Long> gameObjectTypeStateIds) {
        gameObjectTypeStatesOperationsDelegate.bulkDeleteGameAssets(repositoryId, gameObjectTypeId, gameObjectTypeStateIds);
    }

    /**
     * Delete a game object state
     */
    public void deleteGameObjectTypeState(Long repositoryId, Long gameObjectTypeId, Long gameObjectTypeStateId) {
    	bulkDeleteGameObjectTypeStates(repositoryId, gameObjectTypeId, List.of(gameObjectTypeStateId));
    }

    /**
     * Create a new game object type state in memory and without saving it into the registry
     */
    public GameObjectTypeState createGameObjectTypeStateInstance(Long gameObjectTypeId, String name) {
        GameObjectTypeState ret = dataService.newGameObjectTypeState();

        ret.setGameObjectTypeId(gameObjectTypeId);
        ret.setName(name);

        return ret;
    }















    /**
     * Performs database operations while verifying consistency
     */
    private static class GenericOperationsDelegate <T extends ParentableGameAsset> {
        private UnaryOperator<List<T>> bulkSaveOperation;
        private BiFunction<IdentifiableGameAsset,List<Long>,List<T>> searchFunction;
        private BiFunction<Long,Long, IdentifiableGameAsset> parentSearchOperation;
        Function<IdentifiableGameAsset,List<T>> searchByParentFunction;
        private BiConsumer<T,T> propertyMergingConsumer;
        private Consumer<List<Long>> bulkDeleteConsumer;

        public GenericOperationsDelegate(
            UnaryOperator<List<T>> bulkSaveOperation,
            BiFunction<IdentifiableGameAsset,List<Long>,List<T>> searchFunction,
            BiFunction<Long,Long, IdentifiableGameAsset> parentSearchOperation,
            Function<IdentifiableGameAsset,List<T>> searchByParentFunction,
            BiConsumer<T,T> propertyMergingConsumer,
            Consumer<List<Long>> bulkDeleteConsumer
        ) {
            this.bulkSaveOperation = bulkSaveOperation;
            this.searchFunction = searchFunction;
            this.parentSearchOperation = parentSearchOperation;
            this.searchByParentFunction = searchByParentFunction;
            this.propertyMergingConsumer = propertyMergingConsumer;
            this.bulkDeleteConsumer = bulkDeleteConsumer;
        }

        /**
         * Get a list of all the children of the referenced parent game asset
         */
        public List<T> getByParentId(Long repositoryId, Long parentId) {
            IdentifiableGameAsset parent = parentSearchOperation.apply(repositoryId, parentId);
            return searchByParentFunction.apply(parent);
        }

        /**
         * Add or update each of the game assets in the given list using a minimum amount of database operations
         * while also performing consistency checks
         */
        public List<T> bulkSaveGameAssets(Long repositoryId, Long parentAssetId, List<T> childAssets) {
         // Fail-safe in case garbage data is provided
            if (childAssets == null || childAssets.size() == 0) {
                return childAssets;
            }

         // Get the referenced parent game asset from the registry or throw an error if the reference is invalid
            IdentifiableGameAsset parentAsset = parentSearchOperation.apply(repositoryId, parentAssetId);

         // If the parent reference is correct, then split the input into two separate lists: 
            List<T> toBeUpdated = new ArrayList<>(); // one for child assets that have to be updated and
            List<T> toBeAdded   = new ArrayList<>(); // one for newly updated child assets that have to be added to the registry
            splitAssetsList(childAssets, toBeUpdated, toBeAdded);

         // This list will combine the results of the following two operations
            List<T> ret = new ArrayList<>();

         // The list of assets to be updated needs to be treated differently than that of assets to be added:
            if (toBeUpdated.size() > 0) ret.addAll(bulkUpdateGameAssets(parentAsset, toBeUpdated)); // Assets to be updated need to be verified to make sure they are mapped in the registry to the same parent that the caller states they are mapped to
            if (toBeAdded  .size() > 0) ret.addAll(bulkAddGameAssets   (parentAsset, toBeAdded  )); // Assets to be added can just be inserted into the database since they will get new id's and there is no risk to update the wrong assets by mistake

         // return ret.stream().map(prop -> cleanupGameObjectTypeProperty(prop)).collect(Collectors.toList());
            return ret;
        }

        private List<T> bulkUpdateGameAssets(IdentifiableGameAsset parentAsset, List<T> childAssets) throws CrazyDumplingsGameWorldRegistryException {
            List<Long> assetIds = childAssets.stream().map(prop -> prop.getId()).collect(Collectors.toList());

         // Query the registry for the child assets of the given parent asset having the given ids
            List<T> registeredAssets = searchFunction.apply(parentAsset, assetIds);

         // Check that all the given child assets have been found in the registry for the referenced parent asset
            childAssets.forEach(givenChildAsset -> {
                if (false == registeredAssets.stream().anyMatch(registeredChildAsset -> givenChildAsset.getId().equals(registeredChildAsset.getId()))) {
                    throw new CrazyDumplingsGameWorldRegistryException("The given assets mapping is not consistent with that in the registry. The registry may have been modified prior to the current operation. ");
                }
            });

         // If the consistency check was successful, the only thing left to do is update the registry
            registeredAssets.forEach(registeredAsset -> {
            // Find the input data - OK, this could have been done with less loops, but in this day and age it's better to not mix up different scopes in the same loop
               T inputData = childAssets.stream()
                                            .filter(property -> property.getId().equals(registeredAsset.getId()))
                                            .findFirst()
                                            .orElse(null);

            // The input data should always be found unless the registry contains more properties than given by the caller
               if (inputData != null) {
                 // One or more attributes may be missing in the input data
                 // This indicates that the caller requires only certain attributes to be updated while the others should be left alone
                 // This is context specific and, as such, it has to be handled by the caller
                    propertyMergingConsumer.accept(inputData, registeredAsset);
               }
            });

         // Finally, save the data
            return bulkSaveOperation.apply(registeredAssets);
        }

        private List<T> bulkAddGameAssets(IdentifiableGameAsset parent, List<T> assets) {
            assets.forEach(asset -> { asset.setParentId(parent.getId()); });
            return bulkSaveOperation.apply(assets);
        }

        private static <T extends IdentifiableGameAsset> void splitAssetsList(List<T> source, List<T> toBeUpdated, List<T> toBeAdded) {
            source.forEach(property -> { 
                if (property.getId() == null) {
                    toBeAdded.add(property);
                } else {
                    toBeUpdated.add(property);
                }
            });
        }

        /**
         * Deletes a list of items with a minimum amount of database operations while also verifying consistency
         */
        public void bulkDeleteGameAssets(Long repositoryId, Long parentAssetId, List<Long> childAssetIds) {
            if (childAssetIds != null && childAssetIds.size() > 0) {
                // Get the parent asset from the registry
                   IdentifiableGameAsset parentAsset = parentSearchOperation.apply(repositoryId, parentAssetId);

                // Get the list of child assets having the given ids
                   List<T> registeredAssets = searchFunction.apply(parentAsset, childAssetIds);

                // Consistency check
                   childAssetIds.forEach(assetId -> {
                       if (false == registeredAssets.stream().anyMatch(asset -> asset.getId() == assetId)) {
                           throw new CrazyDumplingsGameWorldRegistryException("The given game assets mapping is not consistent with that in the registry. The registry may have been modified prior to the current operation. ");
                       }
                   });

                // Bulk delete
                   bulkDeleteConsumer.accept(childAssetIds);
           }
        }
    }



}
