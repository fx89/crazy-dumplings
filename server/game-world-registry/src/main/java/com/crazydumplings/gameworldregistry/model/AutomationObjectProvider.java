package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface AutomationObjectProvider extends Serializable, Comparable<AutomationObjectProvider> {
    public Long getId();

    public String getName();

    public void setName(String name);

}