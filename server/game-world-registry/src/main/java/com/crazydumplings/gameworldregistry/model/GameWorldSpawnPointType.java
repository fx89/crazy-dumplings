package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface GameWorldSpawnPointType extends Serializable, Comparable<GameWorldSpawnPointType> {
    public Long getId();

    public GameObjectType getSpawnPointGameObjectType();

    public void setSpawnPointGameObjectType(GameObjectType spawnPointGameObjectType);

    public GameObjectType getSpawnedGameObjectType();

    public void setSpawnedGameObjectType(GameObjectType spawnedGameObjectType);

}