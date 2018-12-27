package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface GameWorldCellProperty extends Serializable, Comparable<GameWorldCellProperty> {
    public Long getId();

    public GameWorldCell getGameWorldCell();

    public void setGameWorldCell(GameWorldCell gameWorldCell);

    public GameObjectTypeProperty getGameObjectTypeProperty();

    public void setGameObjectTypeProperty(GameObjectTypeProperty gameObjectTypeProperty);

    public Double getPropertyActualValue();

    public void setPropertyActualValue(Double propertyActualValue);

}