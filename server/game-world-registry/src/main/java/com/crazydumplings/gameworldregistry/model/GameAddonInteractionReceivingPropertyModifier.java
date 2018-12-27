package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface GameAddonInteractionReceivingPropertyModifier extends Serializable, Comparable<GameAddonInteractionReceivingPropertyModifier> {
    public Long getId();

    public GameObjectTypeAllowedAddonType getGameObjectTypeAllowedAddonType();

    public void setGameObjectTypeAllowedAddonType(GameObjectTypeAllowedAddonType gameObjectTypeAllowedAddonType);

    public GameObjectTypeProperty getAffectedGameObjectTypeProperty();

    public void setAffectedGameObjectTypeProperty(GameObjectTypeProperty affectedGameObjectTypeProperty);

    public Double getAppliedPropertyValueMultiplier();

    public void setAppliedPropertyValueMultiplier(Double appliedPropertyValueMultiplier);

}