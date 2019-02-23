package com.crazydumplings.gameworldregistry.model;

import com.crazydumplings.gameworldregistry.model.generic.IdentifiableGameAsset;

public interface GameObjectTypeStatePropertyModifier extends IdentifiableGameAsset, Comparable<GameObjectTypeStatePropertyModifier> {
    Long getId();

    GameObjectTypeState getGameObjectTypeState();

    void setGameObjectTypeState(GameObjectTypeState gameObjectTypeState);

    GameObjectTypeProperty getGameObjectTypeProperty();

    void setGameObjectTypeProperty(GameObjectTypeProperty gameObjectTypeProperty);

    Double getPropertyActualValue();

    void setPropertyActualValue(Double propertyActualValue);

}