package com.crazydumplings.gameworldregistry.model;

import com.crazydumplings.gameworldregistry.model.generic.IdentifiableGameAsset;

public interface PlayableCharacterType extends IdentifiableGameAsset, Comparable<PlayableCharacterType> {
    Long getId();

    String getUniqueCharacterTypeName();

    void setUniqueCharacterTypeName(String uniqueCharacterTypeName);

    GameObjectType getGameObjectType();

    void setGameObjectType(GameObjectType gameObjectType);

}