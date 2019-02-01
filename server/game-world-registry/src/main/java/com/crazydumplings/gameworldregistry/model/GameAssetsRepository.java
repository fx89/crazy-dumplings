package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface GameAssetsRepository extends Serializable, Comparable<GameAssetsRepository> {
    Long getId();

    String getUniqueName();

    void setUniqueName(String uniqueName);

    String getDescription();

    void setDescription(String description);

    String getPictureHash();

    void setPictureHash(String pictureHash);
}