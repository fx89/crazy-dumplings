package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface GameAssetsRepository extends Serializable, Comparable<GameAssetsRepository> {
    public Long getId();

    public String getUniqueName();

    public void setUniqueName(String uniqueName);

    public String getDescription();

    public void setDescription(String description);

    public String getPictureHash();

    public void setPictureHash(String pictureHash);
}