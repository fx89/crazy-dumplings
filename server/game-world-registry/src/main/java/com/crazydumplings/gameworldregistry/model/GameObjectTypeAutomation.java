package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface GameObjectTypeAutomation extends Serializable, Comparable<GameObjectTypeAutomation> {
    Long getId();

    GameObjectType getGameObjectType();

    void setGameObjectType(GameObjectType gameObjectType);

    AutomationObjectProvider getAutomationObjectProvider();

    void setAutomationObjectProvider(AutomationObjectProvider automationObjectProvider);

}