package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface GameObjectTypeProperty extends Serializable, Comparable<GameObjectTypeProperty> {
    public Long getId();

    public GameObjectType getGameObjectType();

    public void setGameObjectType(GameObjectType gameObjectType);

    public String getPropertyName();

    public void setPropertyName(String propertyName);

    public Double getPropertyDefaultValue();

    public void setPropertyDefaultValue(Double propertyDefaultValue);

    public Double getPropertyMinValue();

    public void setPropertyMinValue(Double propertyMinValue);

    public Double getPropertyMaxValue();

    public void setPropertyMaxValue(Double propertyMaxValue);

}