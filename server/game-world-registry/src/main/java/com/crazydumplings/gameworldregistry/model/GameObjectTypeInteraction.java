package com.crazydumplings.gameworldregistry.model;

import com.crazydumplings.gameworldregistry.model.generic.IdentifiableGameAsset;

public interface GameObjectTypeInteraction extends IdentifiableGameAsset, Comparable<GameObjectTypeInteraction> {
    Long getId();

    GameObjectType getDonatingGameObjectType();

    void setDonatingGameObjectType(GameObjectType donatingGameObjectType);

    GameObjectType getReceivingGameObjectType();

    void setReceivingGameObjectType(GameObjectType receivingGameObjectType);

    Integer getRadius();

    void setRadius(Integer radius);

}