package com.crazydumplings.gameworldregistry.model;

import com.crazydumplings.gameworldregistry.model.generic.IdentifiableGameAsset;

public interface GameWorldCellProperty extends IdentifiableGameAsset, Comparable<GameWorldCellProperty> {
    Long getId();

    GameWorldCell getGameWorldCell();

    void setGameWorldCell(GameWorldCell gameWorldCell);

    GameObjectTypeProperty getGameObjectTypeProperty();

    void setGameObjectTypeProperty(GameObjectTypeProperty gameObjectTypeProperty);

    Double getPropertyActualValue();

    void setPropertyActualValue(Double propertyActualValue);

}