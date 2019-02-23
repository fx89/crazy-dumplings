package com.crazydumplings.gameworldregistry.model;

import com.crazydumplings.gameworldregistry.model.generic.IdentifiableGameAsset;

public interface GameAssetsRepositoryOwner extends IdentifiableGameAsset, Comparable<GameAssetsRepositoryOwner> {
    Long getId();

    GameAssetsRepository getGameAssetsRepository();

    void setGameAssetsRepository(GameAssetsRepository gameAssetsRepository);

    Long getOwnerUserId();

    void setOwnerUserId(Long ownerUserId);
}
