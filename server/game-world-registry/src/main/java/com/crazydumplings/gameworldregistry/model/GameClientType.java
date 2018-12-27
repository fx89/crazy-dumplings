package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface GameClientType extends Serializable, Comparable<GameClientType> {
    public Long getId();

    public String getUniqueName();

    public void setUniqueName(String uniqueName);

}