package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface GameObjectTypeClass extends Serializable, Comparable<GameObjectTypeClass> {
    Long getId();

    String getName();

    void setName(String name);

}