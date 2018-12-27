package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface GameObjectTypeStatePropertyModifier extends Serializable, Comparable<GameObjectTypeStatePropertyModifier> {
    public Long getId();

    public GameObjectTypeState getGameObjectTypeState();

    public void setGameObjectTypeState(GameObjectTypeState gameObjectTypeState);

    public GameObjectTypeProperty getGameObjectTypeProperty();

    public void setGameObjectTypeProperty(GameObjectTypeProperty gameObjectTypeProperty);

    public Double getPropertyActualValue();

    public void setPropertyActualValue(Double propertyActualValue);

}