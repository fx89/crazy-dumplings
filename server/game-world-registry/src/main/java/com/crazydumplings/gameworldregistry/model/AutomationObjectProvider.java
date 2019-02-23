package com.crazydumplings.gameworldregistry.model;

import com.crazydumplings.gameworldregistry.model.generic.IdentifiableGameAsset;

public interface AutomationObjectProvider extends IdentifiableGameAsset, Comparable<AutomationObjectProvider> {
    Long getId();

    String getName();

    void setName(String name);

}