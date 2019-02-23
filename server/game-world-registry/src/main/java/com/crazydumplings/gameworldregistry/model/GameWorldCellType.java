package com.crazydumplings.gameworldregistry.model;

import com.crazydumplings.gameworldregistry.model.generic.IdentifiableGameAsset;

public interface GameWorldCellType extends IdentifiableGameAsset, Comparable<GameWorldCellType> {
    Long getId();

    String getUniqueName();

    void setUniqueName(String uniqueName);

    GameObjectType getGameObjectType();

    void setGameObjectType(GameObjectType gameObjectType);

}