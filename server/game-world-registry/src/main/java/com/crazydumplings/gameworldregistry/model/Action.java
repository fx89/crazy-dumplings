package com.crazydumplings.gameworldregistry.model;

import com.crazydumplings.gameworldregistry.model.generic.IdentifiableGameAsset;

public interface Action extends IdentifiableGameAsset, Comparable<Action> {
    Long getId();

    String getUniqueName();

    void setUniqueName(String uniqueName);

}