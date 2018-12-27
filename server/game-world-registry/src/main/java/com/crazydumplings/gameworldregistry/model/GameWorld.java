package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface GameWorld extends Serializable, Comparable<GameWorld> {
    public Long getId();

    public String getUniqueName();

    public void setUniqueName(String uniqueName);

    public String getDescription();

    public void setDescription(String description);

    public String getPictureRefPath();

    public void setPictureRefPath(String pictureRefPath);

    public Integer getWidth();

    public void setWidth(Integer width);

    public Integer getHeight();

    public void setHeight(Integer height);

}