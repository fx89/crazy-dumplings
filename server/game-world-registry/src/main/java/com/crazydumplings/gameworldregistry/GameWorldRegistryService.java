package com.crazydumplings.gameworldregistry;

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

    public List<GameObjectTypeClass> getGameObjectTypeClasses() {
        return dataService.findAllGameObjectTypeClasses();
    }

    public GameObjectTypeClass addGameObjectTypeClass(String name) {
        GameObjectTypeClass typeClass = dataService.newGameObjectTypeClass();
        typeClass.setName(name);
        return dataService.saveGameObjectTypeClass(typeClass);
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
        dataService.deleteGameObjectType(gameObjectType);
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
    ) {
        GameObjectTypeProperty gameObjectTypeProperty;

     // If the caller supplies a valid id for the game object type property, then the property must be updated.
     // Since the property must be updated, it must first be retrieved from the repository so that it can be confirmed that the property is child to the given object type
     // If, however, the provided game object type property id is not valid, then a new game object type property must be created for the given game object type
        if (gameObjectTypePropertyId != null && gameObjectTypePropertyId > 0) {
            gameObjectTypeProperty = getGameObjectTypePropertyOrThrow(repositoryId, gameObjectTypeId, gameObjectTypePropertyId);
        } else {
            gameObjectTypeProperty = dataService.newGameObjectTypeProperty();
            gameObjectTypeProperty.setGameObjectType(getGameObjectTypeOrThrow(repositoryId, gameObjectTypeId));
        }

     // Regardless of whether or not the game object type property already exists, the attributes must be set
     // Attributes should be set only if provided
        if (propertyName         != null) gameObjectTypeProperty.setPropertyName        (propertyName);
        if (propertyDefaultValue != null) gameObjectTypeProperty.setPropertyDefaultValue(propertyDefaultValue);
        if (propertyMinValue     != null) gameObjectTypeProperty.setPropertyMinValue    (propertyMinValue);
        if (propertyMaxValue     != null) gameObjectTypeProperty.setPropertyMaxValue    (propertyMaxValue);

     // Then the property must be saved into the repository
        gameObjectTypeProperty = dataService.saveGameObjectTypeProperty(gameObjectTypeProperty);
        gameObjectTypeProperty.setGameObjectType(cleanupGameobjectType(gameObjectTypeProperty.getGameObjectType())); // TODO: remove this garbage workaround after the picture hash has been moved into a different entity 

     // The saved instance should be returned to the caller for eventual future reference
        return gameObjectTypeProperty;
    }

    public void deleteGameObjectTypeProperty(Long repositoryId, Long gameObjectTypeId, Long gameObjectTypePropertyId) {
        GameObjectTypeProperty gameObjectTypeProperty = getGameObjectTypePropertyOrThrow(repositoryId, gameObjectTypeId, gameObjectTypePropertyId);
        dataService.deleteGameObjectTypeProperty(gameObjectTypeProperty);
    }

    private GameObjectTypeProperty getGameObjectTypePropertyOrThrow(Long repositoryId, Long gameObjectTypeId, Long gameObjectTypePropertyId) throws CrazyDumplingsGameWorldRegistryException {
        GameObjectType gameObjectType = getGameObjectTypeOrThrow(repositoryId, gameObjectTypeId);
        GameObjectTypeProperty gameObjectTypeProperty = dataService.findGameObjectTypeProperty(gameObjectTypePropertyId);

        if (gameObjectTypeProperty == null || !(gameObjectTypeProperty.getGameObjectType().equals(gameObjectType))) {
            throw new CrazyDumplingsGameWorldRegistryException("The game object type [" + gameObjectType.getUniqueName() + "] does not contain the referenced property");
        }

        return gameObjectTypeProperty;
    }

    private GameAssetsRepository getRepositoryOrThrow(Long repoId) throws CrazyDumplingsGameWorldRegistryException {
        GameAssetsRepository rep = dataService.findGameAssetsRepository(repoId);

        if (rep == null)
            throw new CrazyDumplingsGameWorldRegistryException("A repository having the id [" + repoId + "] does not exist in the registry");

        return rep;
    }

    private GameObjectTypeClass getGameObjectTypeClassyOrThrow(Long classId) throws CrazyDumplingsGameWorldRegistryException {
    	GameObjectTypeClass cls = dataService.findGameObjectTypeClass(classId);

        if (cls == null)
            throw new CrazyDumplingsGameWorldRegistryException("A game object type class having the id [" + classId + "] does not exist in the registry");

        return cls;
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

 // TODO: remove this garbage workaround after the picture hash has been moved into a different entity
    private GameObjectType cleanupGameobjectType(GameObjectType gameObjectType) {
        gameObjectType.getGameAssetsRepository().setPictureHash("removed");
        gameObjectType.getGameAssetsRepository().setDescription("removed");

        return gameObjectType;
    }
}
