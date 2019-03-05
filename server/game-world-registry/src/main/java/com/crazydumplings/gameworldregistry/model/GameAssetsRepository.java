package com.crazydumplings.gameworldregistry.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.crazydumplings.gameworldregistry.model.generic.IdentifiableGameAsset;

public interface GameAssetsRepository extends IdentifiableGameAsset, Comparable<GameAssetsRepository> {
    Long getId();

    @NotNull
    @Size(min=3, max=60)
    String getUniqueName();

    void setUniqueName(String uniqueName);

    String getDescription();

    void setDescription(String description);
}