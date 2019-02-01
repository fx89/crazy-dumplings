package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface GameObjectTypeState extends Serializable, Comparable<GameObjectTypeState> {
    Long getId();

    GameObjectType getGameObjectType();

    void setGameObjectType(GameObjectType gameObjectType);

    String getName();

    void setName(String name);

}