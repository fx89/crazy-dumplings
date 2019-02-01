package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface GameObjectType extends Serializable, Comparable<GameObjectType> {
    Long getId();

    GameAssetsRepository getGameAssetsRepository();

    void setGameAssetsRepository(GameAssetsRepository gameAssetsRepository);

    GameObjectTypeClass getGameObjectTypeClass();

    void setGameObjectTypeClass(GameObjectTypeClass gameObjectTypeClass);

    String getUniqueName();

    void setUniqueName(String uniqueName);

    Boolean getIsExperimental();

    void setIsExperimental(Boolean isExperimental);

    String getDescription();

    void setDescription(String description);

}