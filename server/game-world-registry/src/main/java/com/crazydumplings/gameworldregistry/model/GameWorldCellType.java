package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface GameWorldCellType extends Serializable, Comparable<GameWorldCellType> {
    Long getId();

    String getUniqueName();

    void setUniqueName(String uniqueName);

    GameObjectType getGameObjectType();

    void setGameObjectType(GameObjectType gameObjectType);

}