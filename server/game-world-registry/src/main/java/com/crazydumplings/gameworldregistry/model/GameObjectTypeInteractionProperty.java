package com.crazydumplings.gameworldregistry.model;

import com.crazydumplings.gameworldregistry.model.generic.IdentifiableGameAsset;

public interface GameObjectTypeInteractionProperty extends IdentifiableGameAsset, Comparable<GameObjectTypeInteractionProperty> {
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