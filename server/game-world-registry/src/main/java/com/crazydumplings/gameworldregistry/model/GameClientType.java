package com.crazydumplings.gameworldregistry.model;

import com.crazydumplings.gameworldregistry.model.generic.IdentifiableGameAsset;

public interface GameClientType extends IdentifiableGameAsset, Comparable<GameClientType> {
    Long getId();

    String getUniqueName();

    void setUniqueName(String uniqueName);

}