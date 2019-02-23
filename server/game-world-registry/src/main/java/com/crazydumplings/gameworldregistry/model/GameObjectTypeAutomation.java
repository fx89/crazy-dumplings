package com.crazydumplings.gameworldregistry.model;

import com.crazydumplings.gameworldregistry.model.generic.IdentifiableGameAsset;

public interface GameObjectTypeAutomation extends IdentifiableGameAsset, Comparable<GameObjectTypeAutomation> {
    Long getId();

    GameObjectType getGameObjectType();

    void setGameObjectType(GameObjectType gameObjectType);

    AutomationObjectProvider getAutomationObjectProvider();

    void setAutomationObjectProvider(AutomationObjectProvider automationObjectProvider);

}