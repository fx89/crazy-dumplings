package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface GameObjectTypeStatePropertyModifier extends Serializable, Comparable<GameObjectTypeStatePropertyModifier> {
    Long getId();

    GameObjectTypeState getGameObjectTypeState();

    void setGameObjectTypeState(GameObjectTypeState gameObjectTypeState);

    GameObjectTypeProperty getGameObjectTypeProperty();

    void setGameObjectTypeProperty(GameObjectTypeProperty gameObjectTypeProperty);

    Double getPropertyActualValue();

    void setPropertyActualValue(Double propertyActualValue);

}