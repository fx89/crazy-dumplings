package com.crazydumplings.backend.security.aspects;

import com.crazydumplings.backend.security.annotations.AssetType;

public interface AssetTypeAuthorizer {
    AssetType getAssetType();

    Class<?> getAssetTypeClass();

    boolean authorize(Object assetRef, Long userId);
}
