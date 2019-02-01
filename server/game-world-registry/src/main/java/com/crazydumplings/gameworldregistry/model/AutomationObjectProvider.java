package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface AutomationObjectProvider extends Serializable, Comparable<AutomationObjectProvider> {
    Long getId();

    String getName();

    void setName(String name);

}