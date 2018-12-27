package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface GameObjectType extends Serializable, Comparable<GameObjectType> {
    public Long getId();

    public GameAssetsRepository getGameAssetsRepository();

    public void setGameAssetsRepository(GameAssetsRepository gameAssetsRepository);

    public GameObjectTypeClass getGameObjectTypeClass();

    public void setGameObjectTypeClass(GameObjectTypeClass gameObjectTypeClass);

    public String getUniqueName();

    public void setUniqueName(String uniqueName);

    public Boolean getIsExperimental();

    public void setIsExperimental(Boolean isExperimental);

}