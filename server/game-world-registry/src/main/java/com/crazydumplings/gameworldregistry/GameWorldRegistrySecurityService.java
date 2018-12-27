package com.crazydumplings.gameworldregistry;

import org.springframework.stereotype.Service;

/**
 * Provides functionality required by the {@link com.crazydumplings.gameworldregistry.security.aspects security aspects}
 */
@Service
public class GameWorldRegistrySecurityService {
    private GameWorldRegistryDataService dataService;

    public GameWorldRegistryDataService getDataService() {
        return dataService;
    }

    public void setDataService(GameWorldRegistryDataService dataService) {
        this.dataService = dataService;
    }

    public boolean isRepositoryAccessibleByUser(Long repoId, Long userId) {
        return dataService.findGameAssetsRepositoryOwnerByGameAssetsRepositoryIdAndOwnerId(repoId, userId) != null;
    }
}
