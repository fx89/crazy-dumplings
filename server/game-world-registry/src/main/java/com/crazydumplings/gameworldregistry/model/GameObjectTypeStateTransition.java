package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface GameObjectTypeStateTransition extends Serializable, Comparable<GameObjectTypeStateTransition> {
    public Long getId();

    public GameObjectTypeState getSourceGameObjectTypeState();

    public void setSourceGameObjectTypeState(GameObjectTypeState sourceGameObjectTypeState);

    public GameObjectTypeState getTargetGameObjectTypeState();

    public void setTargetGameObjectTypeState(GameObjectTypeState targetGameObjectTypeState);

    public Boolean getIsAutomatic();

    public void setIsAutomatic(Boolean isAutomatic);

    public Action getTriggerAction();

    public void setTriggerAction(Action triggerAction);

}