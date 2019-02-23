package com.crazydumplings.gameworldregistry.model;

import com.crazydumplings.gameworldregistry.model.generic.IdentifiableGameAsset;

public interface GameWorldSpawnPointType extends IdentifiableGameAsset, Comparable<GameWorldSpawnPointType> {
    Long getId();

    GameObjectType getSpawnPointGameObjectType();

    void setSpawnPointGameObjectType(GameObjectType spawnPointGameObjectType);

    GameObjectType getSpawnedGameObjectType();

    void setSpawnedGameObjectType(GameObjectType spawnedGameObjectType);

}