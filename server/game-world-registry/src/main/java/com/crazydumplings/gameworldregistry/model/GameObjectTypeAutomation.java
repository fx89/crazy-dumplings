package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface GameObjectTypeAutomation extends Serializable, Comparable<GameObjectTypeAutomation> {
    public Long getId();

    public GameObjectType getGameObjectType();

    public void setGameObjectType(GameObjectType gameObjectType);

    public AutomationObjectProvider getAutomationObjectProvider();

    public void setAutomationObjectProvider(AutomationObjectProvider automationObjectProvider);

}