package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface GameObjectTypeState extends Serializable, Comparable<GameObjectTypeState> {
    public Long getId();

    public GameObjectType getGameObjectType();

    public void setGameObjectType(GameObjectType gameObjectType);

    public String getName();

    public void setName(String name);

}