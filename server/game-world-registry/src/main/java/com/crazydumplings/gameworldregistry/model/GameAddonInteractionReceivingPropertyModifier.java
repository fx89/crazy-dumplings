package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface GameAddonInteractionReceivingPropertyModifier extends Serializable, Comparable<GameAddonInteractionReceivingPropertyModifier> {
    Long getId();

    GameObjectTypeAllowedAddonType getGameObjectTypeAllowedAddonType();

    void setGameObjectTypeAllowedAddonType(GameObjectTypeAllowedAddonType gameObjectTypeAllowedAddonType);

    GameObjectTypeProperty getAffectedGameObjectTypeProperty();

    void setAffectedGameObjectTypeProperty(GameObjectTypeProperty affectedGameObjectTypeProperty);

    Double getAppliedPropertyValueMultiplier();

    void setAppliedPropertyValueMultiplier(Double appliedPropertyValueMultiplier);

}