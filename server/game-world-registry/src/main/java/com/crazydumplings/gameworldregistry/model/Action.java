package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface Action extends Serializable, Comparable<Action> {
    Long getId();

    String getUniqueName();

    void setUniqueName(String uniqueName);

}