package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface GameAssetsRepository extends Serializable, Comparable<GameAssetsRepository> {
    Long getId();

    String getUniqueName();

    void setUniqueName(String uniqueName);

    String getDescription();

    void setDescription(String description);

    // TODO: move the picture hash in a different entity so that it does not get downloaded when not needed
    String getPictureHash();

    void setPictureHash(String pictureHash);
}