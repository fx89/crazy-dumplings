package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface GameObjectTypeInteractionProperty extends Serializable, Comparable<GameObjectTypeInteractionProperty> {
    Long getId();

    GameObjectTypeInteraction getGameObjectTypeInteraction();

    void setGameObjectTypeInteraction(GameObjectTypeInteraction gameObjectTypeInteraction);

    GameObjectTypeProperty getDonatingGameObjectTypeProperty();

    void setDonatingGameObjectTypeProperty(GameObjectTypeProperty donatingGameObjectTypeProperty);

    GameObjectTypeProperty getReceivingGameObjectTypeProperty();

    void setReceivingGameObjectTypeProperty(GameObjectTypeProperty receivingGameObjectTypeProperty);

    GameObjectTypeProperty getOverflowGameObjectTypeProperty();

    void setOverflowGameObjectTypeProperty(GameObjectTypeProperty overflowGameObjectTypeProperty);

    Boolean getIsIncremental();

    void setIsIncremental(Boolean isIncremental);

    Boolean getIsInverted();

    void setIsInverted(Boolean isInverted);

}