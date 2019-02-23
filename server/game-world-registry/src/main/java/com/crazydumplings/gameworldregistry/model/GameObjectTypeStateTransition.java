package com.crazydumplings.gameworldregistry.model;

import com.crazydumplings.gameworldregistry.model.generic.IdentifiableGameAsset;

public interface GameObjectTypeStateTransition extends IdentifiableGameAsset, Comparable<GameObjectTypeStateTransition> {
    Long getId();

    GameObjectTypeState getSourceGameObjectTypeState();

    void setSourceGameObjectTypeState(GameObjectTypeState sourceGameObjectTypeState);

    GameObjectTypeState getTargetGameObjectTypeState();

    void setTargetGameObjectTypeState(GameObjectTypeState targetGameObjectTypeState);

    Boolean getIsAutomatic();

    void setIsAutomatic(Boolean isAutomatic);

    Action getTriggerAction();

    void setTriggerAction(Action triggerAction);

}