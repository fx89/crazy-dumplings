package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface Action extends Serializable, Comparable<Action> {
    public Long getId();

    public String getUniqueName();

    public void setUniqueName(String uniqueName);

}