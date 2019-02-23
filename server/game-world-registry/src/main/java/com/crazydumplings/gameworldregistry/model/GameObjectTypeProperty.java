package com.crazydumplings.gameworldregistry.model;

import com.crazydumplings.gameworldregistry.model.generic.IdentifiableGameAsset;
import com.crazydumplings.gameworldregistry.model.generic.ParentableGameAsset;

public interface GameObjectTypeProperty extends ParentableGameAsset, Comparable<GameObjectTypeProperty> {
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

    default IdentifiableGameAsset getParent() {
        return getGameObjectType();
    };

    default void setParent(IdentifiableGameAsset parent) {
        setGameObjectType((GameObjectType) parent);
    };
}