package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface GameObjectTypeStateTransition extends Serializable, Comparable<GameObjectTypeStateTransition> {
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