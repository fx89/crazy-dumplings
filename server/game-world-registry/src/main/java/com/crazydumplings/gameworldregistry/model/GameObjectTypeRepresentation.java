package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface GameObjectTypeRepresentation extends Serializable, Comparable<GameObjectTypeRepresentation> {
    public Long getId();

    public GameObjectType getGameObjectType();

    public void setGameObjectType(GameObjectType gameObjectType);

    public GameClientType getGameClientType();

    public void setGameClientType(GameClientType gameClientType);

    public String getObjectHash();

    public void setObjectHash(String objectHash);

}