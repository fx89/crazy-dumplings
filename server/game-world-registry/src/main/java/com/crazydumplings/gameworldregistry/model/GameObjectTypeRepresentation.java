package com.crazydumplings.gameworldregistry.model;

import com.crazydumplings.gameworldregistry.model.generic.IdentifiableGameAsset;

public interface GameObjectTypeRepresentation extends IdentifiableGameAsset, Comparable<GameObjectTypeRepresentation> {
    Long getId();

    GameObjectType getGameObjectType();

    void setGameObjectType(GameObjectType gameObjectType);

    GameClientType getGameClientType();

    void setGameClientType(GameClientType gameClientType);

    String getObjectHash();

    void setObjectHash(String objectHash);

}