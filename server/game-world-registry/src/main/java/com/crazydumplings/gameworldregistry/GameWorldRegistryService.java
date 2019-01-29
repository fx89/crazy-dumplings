package com.crazydumplings.gameworldregistry;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crazydumplings.gameworldregistry.exception.CrazyDumplingsGameWorldRegistryException;
import com.crazydumplings.gameworldregistry.helper.GameWorldRegistrySerializationHelper;
import com.crazydumplings.gameworldregistry.model.GameAssetsRepository;
import com.crazydumplings.gameworldregistry.model.GameAssetsRepositoryOwner;

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
        GameAssetsRepository rep = dataService.findGameAssetsRepository(repoId);

        if (rep == null)
            throw new CrazyDumplingsGameWorldRegistryException("A repository having the id [" + repoId + "] does not exist in the registry");

        if (uniqueName  != null) rep.setUniqueName (uniqueName );
        if (description != null) rep.setDescription(description);
        if (pictureHash != null) rep.setPictureHash(pictureHash);

        dataService.saveGameAssetsRepository(rep);
    }
}
