package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface GameObjectTypeRepresentation extends Serializable, Comparable<GameObjectTypeRepresentation> {
    Long getId();

    GameObjectType getGameObjectType();

    void setGameObjectType(GameObjectType gameObjectType);

    GameClientType getGameClientType();

    void setGameClientType(GameClientType gameClientType);

    String getObjectHash();

    void setObjectHash(String objectHash);

}