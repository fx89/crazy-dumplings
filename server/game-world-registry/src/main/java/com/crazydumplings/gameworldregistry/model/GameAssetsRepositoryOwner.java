package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface GameAssetsRepositoryOwner extends Serializable, Comparable<GameAssetsRepositoryOwner> {
    Long getId();

    GameAssetsRepository getGameAssetsRepository();

    void setGameAssetsRepository(GameAssetsRepository gameAssetsRepository);

    Long getOwnerUserId();

    void setOwnerUserId(Long ownerUserId);
}
