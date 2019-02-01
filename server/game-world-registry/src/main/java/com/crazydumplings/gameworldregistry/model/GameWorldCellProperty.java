package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface GameWorldCellProperty extends Serializable, Comparable<GameWorldCellProperty> {
    Long getId();

    GameWorldCell getGameWorldCell();

    void setGameWorldCell(GameWorldCell gameWorldCell);

    GameObjectTypeProperty getGameObjectTypeProperty();

    void setGameObjectTypeProperty(GameObjectTypeProperty gameObjectTypeProperty);

    Double getPropertyActualValue();

    void setPropertyActualValue(Double propertyActualValue);

}