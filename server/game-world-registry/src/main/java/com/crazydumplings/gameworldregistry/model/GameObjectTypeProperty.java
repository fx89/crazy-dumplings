package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface GameObjectTypeProperty extends Serializable, Comparable<GameObjectTypeProperty> {
    Long getId();

    GameObjectType getGameObjectType();

    void setGameObjectType(GameObjectType gameObjectType);

    String getPropertyName();

    void setPropertyName(String propertyName);

    Double getPropertyDefaultValue();

    void setPropertyDefaultValue(Double propertyDefaultValue);

    Double getPropertyMinValue();

    void setPropertyMinValue(Double propertyMinValue);

    Double getPropertyMaxValue();

    void setPropertyMaxValue(Double propertyMaxValue);

}