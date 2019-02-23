package com.crazydumplings.gameworldregistry.model;

import com.crazydumplings.gameworldregistry.model.generic.IdentifiableGameAsset;

public interface GameAddonInteractionReceivingPropertyModifier extends IdentifiableGameAsset, Comparable<GameAddonInteractionReceivingPropertyModifier> {
    Long getId();

    GameObjectTypeAllowedAddonType getGameObjectTypeAllowedAddonType();

    void setGameObjectTypeAllowedAddonType(GameObjectTypeAllowedAddonType gameObjectTypeAllowedAddonType);

    GameObjectTypeProperty getAffectedGameObjectTypeProperty();

    void setAffectedGameObjectTypeProperty(GameObjectTypeProperty affectedGameObjectTypeProperty);

    Double getAppliedPropertyValueMultiplier();

    void setAppliedPropertyValueMultiplier(Double appliedPropertyValueMultiplier);

}