package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface GameWorld extends Serializable, Comparable<GameWorld> {
    Long getId();

    String getUniqueName();

    void setUniqueName(String uniqueName);

    String getDescription();

    void setDescription(String description);

    String getPictureRefPath();

    void setPictureRefPath(String pictureRefPath);

    Integer getWidth();

    void setWidth(Integer width);

    Integer getHeight();

    void setHeight(Integer height);

}