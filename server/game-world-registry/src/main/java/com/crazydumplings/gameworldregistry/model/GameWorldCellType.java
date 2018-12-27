package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface GameWorldCellType extends Serializable, Comparable<GameWorldCellType> {
    public Long getId();

    public String getUniqueName();

    public void setUniqueName(String uniqueName);

    public GameObjectType getGameObjectType();

    public void setGameObjectType(GameObjectType gameObjectType);

}