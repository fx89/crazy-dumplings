package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface GameObjectTypeClass extends Serializable, Comparable<GameObjectTypeClass> {
    public Long getId();

    public String getName();

    public void setName(String name);

}