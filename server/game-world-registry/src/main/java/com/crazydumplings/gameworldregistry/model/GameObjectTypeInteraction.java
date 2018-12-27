package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface GameObjectTypeInteraction extends Serializable, Comparable<GameObjectTypeInteraction> {
    public Long getId();

    public GameObjectType getDonatingGameObjectType();

    public void setDonatingGameObjectType(GameObjectType donatingGameObjectType);

    public GameObjectType getReceivingGameObjectType();

    public void setReceivingGameObjectType(GameObjectType receivingGameObjectType);

    public Integer getRadius();

    public void setRadius(Integer radius);

}