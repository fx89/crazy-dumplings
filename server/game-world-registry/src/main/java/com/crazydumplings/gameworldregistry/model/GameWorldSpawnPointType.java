package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface GameWorldSpawnPointType extends Serializable, Comparable<GameWorldSpawnPointType> {
    Long getId();

    GameObjectType getSpawnPointGameObjectType();

    void setSpawnPointGameObjectType(GameObjectType spawnPointGameObjectType);

    GameObjectType getSpawnedGameObjectType();

    void setSpawnedGameObjectType(GameObjectType spawnedGameObjectType);

}