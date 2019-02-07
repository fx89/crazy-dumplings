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

    public GameAssetsRepository addRepository(String uniqueName, String description, String pictureHash, Long currentUserId) {
     // Create the repository
        GameAssetsRepository rep = dataService.newGameAssetsRepository();
        rep.setUniqueName(uniqueName);
        rep.setDescription(description);
        rep.setPictureHash(pictureHash);
        rep = dataService.saveGameAssetsRepository(rep);

     // Grant the current user access rights to the newly created repository
        GameAssetsRepositoryOwner repOwner = dataService.newGameAssetsRepositoryOwner(rep, currentUserId);
        dataService.saveGameAssetsRepositoryOwner(repOwner);

     // Return a reference to the newly created repository
        return rep;
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

    public void updateGameAssetsRepository(Long repoId, String uniqueName, String description, String pictureHash) {
        GameAssetsRepository rep = getRepositoryOrThrow(repoId);

        if (uniqueName  != null) rep.setUniqueName (uniqueName );
        if (description != null) rep.setDescription(description);
        if (pictureHash != null) rep.setPictureHash(pictureHash);

        dataService.saveGameAssetsRepository(rep);
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

    public GameObjectType addGameObjectType(Long repositoryId, Long gameObjectTypeClassId, String uniqueName, String description, boolean experimental) {
        GameAssetsRepository repository = getRepositoryOrThrow(repositoryId);
        GameObjectTypeClass typeClass = getGameObjectTypeClassyOrThrow(gameObjectTypeClassId);

        GameObjectType newGameObjectType = dataService.newGameObjectType();
        newGameObjectType.setGameAssetsRepository(repository);
        newGameObjectType.setGameObjectTypeClass(typeClass);
        newGameObjectType.setUniqueName(uniqueName);
        newGameObjectType.setIsExperimental(experimental);
        newGameObjectType.setDescription(description);

        return cleanupGameobjectType(dataService.saveGameObjectType(newGameObjectType));
    }

    public GameObjectType updateGameObjectType(Long repositoryId, Long gameObjectTypeId, Long gameObjectTypeClassId, String uniqueName, String description, boolean experimental) {
        GameObjectType gameObjectType = getGameObjectTypeOrThrow(repositoryId, gameObjectTypeId);
        GameObjectTypeClass typeClass = getGameObjectTypeClassyOrThrow(gameObjectTypeClassId);

        gameObjectType.setGameObjectTypeClass(typeClass);
        gameObjectType.setUniqueName(uniqueName);
        gameObjectType.setDescription(description);
        gameObjectType.setIsExperimental(experimental);

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

    public GameObjectTypeProperty addGameObjectTypeProperty(Long repositoryId, Long gameObjectTypeId, String propertyName, Double propertyDefaultValue, Double propertyMinValue, Double propertyMaxValue) {
        GameObjectType gameObjectType = getGameObjectTypeOrThrow(repositoryId, gameObjectTypeId);

        GameObjectTypeProperty gameObjectTypeProperty = dataService.newGameObjectTypeProperty();
        gameObjectTypeProperty.setPropertyName(propertyName);
        gameObjectTypeProperty.setGameObjectType(gameObjectType);
        gameObjectTypeProperty.setPropertyDefaultValue(propertyDefaultValue);
        gameObjectTypeProperty.setPropertyMinValue(propertyMinValue);
        gameObjectTypeProperty.setPropertyMaxValue(propertyMaxValue);

        gameObjectTypeProperty = dataService.saveGameObjectTypeProperty(gameObjectTypeProperty);
        gameObjectTypeProperty.setGameObjectType(cleanupGameobjectType(gameObjectTypeProperty.getGameObjectType())); // TODO: remove this garbage workaround after the picture hash has been moved into a different entity 

        return gameObjectTypeProperty;
    }

    public GameObjectTypeProperty updateGameObjectTypeProperty(Long repositoryId, Long gameObjectTypeId, Long gameObjectTypePropertyId, Double propertyDefaultValue, Double propertyMinValue, Double propertyMaxValue) {
        GameObjectTypeProperty gameObjectTypeProperty = getGameObjectTypePropertyOrThrow(repositoryId, gameObjectTypeId, gameObjectTypePropertyId);

        gameObjectTypeProperty.setPropertyDefaultValue(propertyDefaultValue);
        gameObjectTypeProperty.setPropertyMinValue(propertyMinValue);
        gameObjectTypeProperty.setPropertyMaxValue(propertyMaxValue);

        gameObjectTypeProperty = dataService.saveGameObjectTypeProperty(gameObjectTypeProperty);
        gameObjectTypeProperty.setGameObjectType(cleanupGameobjectType(gameObjectTypeProperty.getGameObjectType())); // TODO: remove this garbage workaround after the picture hash has been moved into a different entity 

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
