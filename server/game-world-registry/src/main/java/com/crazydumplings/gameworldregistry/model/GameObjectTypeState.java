package com.crazydumplings.gameworldregistry.model;

import com.crazydumplings.gameworldregistry.model.generic.IdentifiableGameAsset;

public interface GameObjectTypeState extends IdentifiableGameAsset, Comparable<GameObjectTypeState> {
    Long getId();

    GameObjectType getGameObjectType();

    void setGameObjectType(GameObjectType gameObjectType);

    String getName();

    void setName(String name);

}