package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface GameClientType extends Serializable, Comparable<GameClientType> {
    Long getId();

    String getUniqueName();

    void setUniqueName(String uniqueName);

}