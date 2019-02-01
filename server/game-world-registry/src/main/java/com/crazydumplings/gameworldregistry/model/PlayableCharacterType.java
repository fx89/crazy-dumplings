package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface PlayableCharacterType extends Serializable, Comparable<PlayableCharacterType> {
    Long getId();

    String getUniqueCharacterTypeName();

    void setUniqueCharacterTypeName(String uniqueCharacterTypeName);

    GameObjectType getGameObjectType();

    void setGameObjectType(GameObjectType gameObjectType);

}