package com.crazydumplings.gameworldregistry.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.crazydumplings.gameworldregistry.model.generic.IdentifiableGameAsset;

public interface GameObjectTypeClass extends IdentifiableGameAsset, Comparable<GameObjectTypeClass> {
    Long getId();

    @NotNull
    @Size(min=3, max=60)
    String getName();

    void setName(String name);

}