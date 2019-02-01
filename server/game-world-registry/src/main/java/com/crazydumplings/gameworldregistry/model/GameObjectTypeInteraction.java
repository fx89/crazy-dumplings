package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface GameObjectTypeInteraction extends Serializable, Comparable<GameObjectTypeInteraction> {
    Long getId();

    GameObjectType getDonatingGameObjectType();

    void setDonatingGameObjectType(GameObjectType donatingGameObjectType);

    GameObjectType getReceivingGameObjectType();

    void setReceivingGameObjectType(GameObjectType receivingGameObjectType);

    Integer getRadius();

    void setRadius(Integer radius);

}