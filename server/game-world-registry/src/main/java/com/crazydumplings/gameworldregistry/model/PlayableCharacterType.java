package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface PlayableCharacterType extends Serializable, Comparable<PlayableCharacterType> {
    public Long getId();

    public String getUniqueCharacterTypeName();

    public void setUniqueCharacterTypeName(String uniqueCharacterTypeName);

    public GameObjectType getGameObjectType();

    public void setGameObjectType(GameObjectType gameObjectType);

}