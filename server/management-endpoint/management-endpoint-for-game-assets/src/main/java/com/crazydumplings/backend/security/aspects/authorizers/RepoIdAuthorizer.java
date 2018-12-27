package com.crazydumplings.backend.security.aspects.authorizers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crazydumplings.backend.security.annotations.AssetType;
import com.crazydumplings.backend.security.aspects.AssetTypeAuthorizer;
import com.crazydumplings.gameworldregistry.GameWorldRegistrySecurityService;

/**
 * Checks if the user with the provided userId has access to the repository having the provided userId, represented by the given assetRef
 */
@Component
public class RepoIdAuthorizer implements AssetTypeAuthorizer {
    @Autowired
    private GameWorldRegistrySecurityService securityService;

    @Override
    public AssetType getAssetType() {
        return AssetType.REPO_ID;
    }

    @Override
    public Class<?> getAssetTypeClass() {
        return Long.class;
    }

    @Override
    public boolean authorize(Object assetRef, Long userId) {
        Long repoId = (Long) assetRef;
        return securityService.isRepositoryAccessibleByUser(repoId, userId);
    }
}
