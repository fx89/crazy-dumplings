package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public interface GameObjectTypeClass extends Serializable, Comparable<GameObjectTypeClass> {
    Long getId();

    @NotNull
    @Size(min=3, max=60)
    String getName();

    void setName(String name);

}