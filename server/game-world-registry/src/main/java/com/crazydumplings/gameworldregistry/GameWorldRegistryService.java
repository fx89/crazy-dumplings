package com.crazydumplings.gameworldregistry;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.crazydumplings.gameworldregistry.exception.CrazyDumplingsGameWorldRegistryException;
import com.crazydumplings.gameworldregistry.helper.GameWorldRegistrySerializationHelper;
import com.crazydumplings.gameworldregistry.model.GameAssetsRepository;
import com.crazydumplings.gameworldregistry.model.GameAssetsRepositoryOwner;
import com.crazydumplings.gameworldregistry.model.GameObjectType;
import com.crazydumplings.gameworldregistry.model.GameObjectTypeClass;
import com.crazydumplings.gameworldregistry.model.GameObjectTypeProperty;

/**
 * Defines the main service interface for accessing the game world registry. Data source can be injected.
 */
@Service
public class GameWorldRegistryService {
    private GameWorldRegistryDataService dataService;

    private GameWorldRegistrySerializationHelper serializationHelper = new GameWorldRegistrySerializationHelper();

    public GameWorldRegistrySerializationHelper getSerializationHelper() {
        return serializationHelper;
    }

    public void setSerializationHelper(GameWorldRegistrySerializationHelper serializationHelper) {
        this.serializationHelper = serializationHelper;
    }

    public GameWorldRegistryDataService getDataService() {
        return dataService;
    }

    public void setDataService(GameWorldRegistryDataService dataService) {
        this.dataService = dataService;
    }

    public GameWorldRegistryService() {

    }







    public List<GameAssetsRepository> getAllRepositories() {
        return dataService.findAllGameAssetsRepositories();
    }

    public GameAssetsRepository setPictureForGameAssetsRepository(String repositoryUniqueName, String pictureHash) {
        GameAssetsRepository rep = dataService.findGameAssetsRepositoryByUniqueName(repositoryUniqueName);
        rep.setPictureHash(pictureHash);
        return dataService.saveGameAssetsRepository(rep);
    }

    public void deleteGameAssetsRepository(Long repoId) {
        GameAssetsRepository rep = dataService.findGameAssetsRepository(repoId);

        dataService.deleteGameAssetsRepositoryOwnersByGameAssetsRepository(rep);

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

     // IF the repository is new, then grant the current user access rights to the newly created repository
        if (repoId == null || repoId <= 0) {
            GameAssetsRepositoryOwner repOwner = dataService.newGameAssetsRepositoryOwner(rep, currentUserId);
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
        return dataService.findAllGameObjectTypesByGameAssetsRepository(getRepositoryOrThrow(repostoryId))
                        .stream().map(asset ->cleanupGameobjectType(asset))
                        .collect(Collectors.toList());
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
            gameObjectType.setGameAssetsRepository(getRepositoryOrThrow(repositoryId));
        }

     // Regardless of whether or not the game object type already exists, the attributes must be set
     // Attributes should be set only if provided
        if (gameObjectTypeClassId != null) gameObjectType.setGameObjectTypeClass(getGameObjectTypeClassyOrThrow(gameObjectTypeClassId));
        if (uniqueName            != null) gameObjectType.setUniqueName         (uniqueName);
                                           gameObjectType.setIsExperimental     (experimental);
        if (description           != null) gameObjectType.setDescription        (description);

     // Then the type must be saved into the repository
     // The saved instance should be returned to the caller for eventual future reference
        return cleanupGameobjectType(dataService.saveGameObjectType(gameObjectType));
    }

    public void deleteGameObjectType(Long repositoryId, Long gameObjectTypeId) {
        GameObjectType gameObjectType = getGameObjectTypeOrThrow(repositoryId, gameObjectTypeId);
        dataService.deleteGameObjectTypePropertiesByGameObjectType(gameObjectType);
        dataService.deleteGameObjectType(gameObjectType);
    }

    // TODO: remove this garbage workaround after the picture hash has been moved into a different entity
    private static GameObjectType cleanupGameobjectType(GameObjectType gameObjectType) {
        gameObjectType.getGameAssetsRepository().setPictureHash("removed");
        gameObjectType.getGameAssetsRepository().setDescription("removed");

        return gameObjectType;
    }

    private GameObjectType getGameObjectTypeOrThrow(Long repoId, Long assetId) throws CrazyDumplingsGameWorldRegistryException {
        GameObjectType gameObjectType = dataService.findGameObjectType(assetId);

        if (gameObjectType == null) {
            throw new CrazyDumplingsGameWorldRegistryException("A game object type having the id [" + assetId + "] does not exist in the registry");
        }

        if (gameObjectType.getGameAssetsRepository().getId() != repoId) {
            throw new CrazyDumplingsGameWorldRegistryException("The referenced game object type is not part of the referenced repository");
        }

        return gameObjectType;
    }







    public List<GameObjectTypeProperty> getGameObjectTypeProperties(Long repositoryId, Long gameObjectTypeId) {
        GameObjectType gameObjectType = getGameObjectTypeOrThrow(repositoryId, gameObjectTypeId);

        List<GameObjectTypeProperty> ret = dataService.findAllGameObjectTypePropertiesByGameObjectType(gameObjectType);

        ret.forEach(prop -> { prop.setGameObjectType(cleanupGameobjectType(prop.getGameObjectType())); } );

        return ret;
    }

    /**
     * Update or create a game object type property depending on the presence of a valid gameObjectTypePropertyId
     */
    public GameObjectTypeProperty saveGameObjectTypeProperty(
            Long repositoryId, Long gameObjectTypeId, Long gameObjectTypePropertyId,
            String propertyName, Double propertyDefaultValue, Double propertyMinValue, Double propertyMaxValue
    ) throws CrazyDumplingsGameWorldRegistryException {
        GameObjectTypeProperty gameObjectTypeProperty = createGameObjectTypePropertyInstance(
                                                                gameObjectTypeId, gameObjectTypePropertyId,
                                                                propertyName, propertyDefaultValue, propertyMinValue, propertyMaxValue
                                                            );
        return bulkSaveGameObjectTypeProperties(repositoryId, gameObjectTypeId, List.of(gameObjectTypeProperty))
                    .stream()
                    .findFirst()
                    .orElseThrow(
                        () -> new CrazyDumplingsGameWorldRegistryException("There was an error while attempting to save the game object type property. Please report this as a bug. ") 
                     )
        ;
    }

    /**
     * Create a new game object type property instance having the given properties
     */
    public GameObjectTypeProperty createGameObjectTypePropertyInstance(
        Long gameObjectTypeId, Long gameObjectTypePropertyId,
        String propertyName, Double propertyDefaultValue, Double propertyMinValue, Double propertyMaxValue
    ) {
        GameObjectTypeProperty ret = dataService.newGameObjectTypeProperty(gameObjectTypePropertyId);

        ret.setGameObjectType(dataService.newGameObjectType(gameObjectTypeId));
        ret.setPropertyName(propertyName);
        ret.setPropertyDefaultValue(propertyDefaultValue);
        ret.setPropertyMinValue(propertyMinValue);
        ret.setPropertyMaxValue(propertyMaxValue);

        return ret;
    }

    /**
     * Add or update each of the game object type properties in the given list while performing a minimum amount of database operations
     */
    public List<GameObjectTypeProperty> bulkSaveGameObjectTypeProperties(Long repositoryId, Long gameObjectTypeId, List<GameObjectTypeProperty> gameObjectTypeProperties) {
     // Get the referenced parent game object type from the registry or throw an error if the reference is invalid
        GameObjectType gameObjectType = getGameObjectTypeOrThrow(repositoryId, gameObjectTypeId);

     // If the game object type reference is correct, then split the input into two separate lists: 
        List<GameObjectTypeProperty> toBeUpdated = new ArrayList<>(); // one for properties that have to be updated and
        List<GameObjectTypeProperty> toBeAdded   = new ArrayList<>(); // one for newly updated properties that have to be added to the registry
        splitGameObjectTypePropertiesList(gameObjectTypeProperties, toBeUpdated, toBeAdded);

     // This list will combine the results of the following two operations
        List<GameObjectTypeProperty> ret = new ArrayList<>();

     // The list of game object type properties to be updated needs to be treated differently than that of game object type properties to be added:
        ret.addAll(bulkUpdateGameObjectTypeProperties(gameObjectType, toBeUpdated)); // Properties to be updated need to be verified to make sure they are mapped in the registry to the same game object types that the caller states they are mapped to
        ret.addAll(bulkAddGameObjectTypeProperties   (gameObjectType, toBeAdded  )); // Properties to be added can just be inserted into the database since they will get new id's and there is no risk to update the wrong properties by mistake

        return ret.stream().map(prop -> cleanupGameObjectTypeProperty(prop)).collect(Collectors.toList());
    }

    private List<GameObjectTypeProperty> bulkUpdateGameObjectTypeProperties(GameObjectType gameObjectType, List<GameObjectTypeProperty> gameObjectTypeProperties) throws CrazyDumplingsGameWorldRegistryException {
        List<Long> assetIds = gameObjectTypeProperties.stream().map(prop -> prop.getId()).collect(Collectors.toList());

     // Query the registry for the game object type properties of the given game object type having the given ids
        List<GameObjectTypeProperty> registeredProperties = dataService.findAllGameObjectTypePropertiesByGameObjectTypeAndIds(gameObjectType, assetIds);

     // Check that all the given properties have been found in the registry for the referenced game object type
        gameObjectTypeProperties.forEach(givenProperty -> {
            if (false == registeredProperties.stream().anyMatch(registeredProperty -> givenProperty.getId().equals(registeredProperty.getId()))) {
                throw new CrazyDumplingsGameWorldRegistryException("The given game object type properties mapping is not consistent with that in the registry. The registry may have been modified prior to the current operation. ");
            }
        });

     // If the consistency check was successful, the only thing left to do is update the registry
        registeredProperties.forEach(registeredProperty -> {
        // Find the input data - OK, this could have been done with less loops, but in this day and age it's better to not mix up different scopes in the same loop
           GameObjectTypeProperty inputData = gameObjectTypeProperties.stream()
                                                    .filter(property -> property.getId().equals(registeredProperty.getId()))
                                                    .findFirst()
                                                    .orElse(null);

        // The input data should always be found unless the registry contains more properties than given by the caller
           if (inputData != null) {
             // One or more attributes may be missing in the input data
             // This indicates that the caller requires only certain attributes to be updated while the others should be left alone
                if (inputData.getPropertyName()         != null) registeredProperty.setPropertyName        (inputData.getPropertyName());
                if (inputData.getPropertyDefaultValue() != null) registeredProperty.setPropertyDefaultValue(inputData.getPropertyDefaultValue());
                if (inputData.getPropertyMinValue()     != null) registeredProperty.setPropertyMinValue    (inputData.getPropertyMinValue());
                if (inputData.getPropertyMaxValue()     != null) registeredProperty.setPropertyMaxValue    (inputData.getPropertyMaxValue());
           }
        });

     // Finally, save the data
        return dataService.saveGameObjectTypeProperties(registeredProperties);
    }

    private List<GameObjectTypeProperty> bulkAddGameObjectTypeProperties(GameObjectType gameObjectType, List<GameObjectTypeProperty> gameObjectTypeProperties) {
        gameObjectTypeProperties.forEach(gameObjectTypeProperty -> {
            gameObjectTypeProperty.setGameObjectType(gameObjectType);
        });

        return dataService.saveGameObjectTypeProperties(gameObjectTypeProperties);
    }

    private static void splitGameObjectTypePropertiesList(List<GameObjectTypeProperty> source, List<GameObjectTypeProperty> toBeUpdated, List<GameObjectTypeProperty> toBeAdded) {
        source.forEach(property -> { 
            if (property.getId() == null) {
                toBeAdded.add(property);
            } else {
                toBeUpdated.add(property);
            }
        });
    }

    public void deleteGameObjectTypeProperty(Long repositoryId, Long gameObjectTypeId, Long gameObjectTypePropertyId) {
        GameObjectTypeProperty gameObjectTypeProperty = getGameObjectTypePropertyOrThrow(repositoryId, gameObjectTypeId, gameObjectTypePropertyId);
        dataService.deleteGameObjectTypeProperty(gameObjectTypeProperty);
    }

    public void bulkDeleteGameObjectTypeProperties(Long repositoryId, Long gameObjectTypeId, List<Long> gameObjectTypePropertyIds) {
     // Get the game object type from the registry
        GameObjectType gameObjectType = getGameObjectTypeOrThrow(repositoryId, gameObjectTypeId);

     // Get the list of properties for the game object type having the given ids
        List<GameObjectTypeProperty> registeredProperties = dataService.findAllGameObjectTypePropertiesByGameObjectTypeAndIds(gameObjectType, gameObjectTypePropertyIds);

     // Consistency check
        gameObjectTypePropertyIds.forEach(propertyId -> {
            if (false == registeredProperties.stream().anyMatch(prop -> prop.getId() == propertyId)) {
                throw new CrazyDumplingsGameWorldRegistryException("The given game object type properties mapping is not consistent with that in the registry. The registry may have been modified prior to the current operation. ");
            }
        });

     // Bulk delete
        dataService.deleteGameObjectTypePropertiesByIds(gameObjectTypePropertyIds);
    }

    private GameObjectTypeProperty getGameObjectTypePropertyOrThrow(Long repositoryId, Long gameObjectTypeId, Long gameObjectTypePropertyId) throws CrazyDumplingsGameWorldRegistryException {
        GameObjectType gameObjectType = getGameObjectTypeOrThrow(repositoryId, gameObjectTypeId);
        GameObjectTypeProperty gameObjectTypeProperty = dataService.findGameObjectTypeProperty(gameObjectTypePropertyId);

        if (gameObjectTypeProperty == null || !(gameObjectTypeProperty.getGameObjectType().equals(gameObjectType))) {
            throw new CrazyDumplingsGameWorldRegistryException("The game object type [" + gameObjectType.getUniqueName() + "] does not contain the referenced property");
        }

        return gameObjectTypeProperty;
    }

 // TODO: remove this garbage workaround after the picture hash has been moved into a different entity
    private static GameObjectTypeProperty cleanupGameObjectTypeProperty(GameObjectTypeProperty gameObjectTypeProperty) {
        gameObjectTypeProperty.setGameObjectType(cleanupGameobjectType(gameObjectTypeProperty.getGameObjectType()));
        return gameObjectTypeProperty;
    }

}
