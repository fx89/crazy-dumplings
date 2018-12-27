package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface GameObjectTypeInteractionProperty extends Serializable, Comparable<GameObjectTypeInteractionProperty> {
    public Long getId();

    public GameObjectTypeInteraction getGameObjectTypeInteraction();

    public void setGameObjectTypeInteraction(GameObjectTypeInteraction gameObjectTypeInteraction);

    public GameObjectTypeProperty getDonatingGameObjectTypeProperty();

    public void setDonatingGameObjectTypeProperty(GameObjectTypeProperty donatingGameObjectTypeProperty);

    public GameObjectTypeProperty getReceivingGameObjectTypeProperty();

    public void setReceivingGameObjectTypeProperty(GameObjectTypeProperty receivingGameObjectTypeProperty);

    public GameObjectTypeProperty getOverflowGameObjectTypeProperty();

    public void setOverflowGameObjectTypeProperty(GameObjectTypeProperty overflowGameObjectTypeProperty);

    public Boolean getIsIncremental();

    public void setIsIncremental(Boolean isIncremental);

    public Boolean getIsInverted();

    public void setIsInverted(Boolean isInverted);

}