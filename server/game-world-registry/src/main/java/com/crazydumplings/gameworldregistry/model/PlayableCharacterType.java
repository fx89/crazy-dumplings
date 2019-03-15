package com.crazydumplings.gameworldregistry.model;



import javax.annotation.Generated;



import com.crazydumplings.gameworldregistry.model.generic.IdentifiableGameAsset;

@Generated(value="fx.codegen.builder version 1.0.0")
public interface PlayableCharacterType extends IdentifiableGameAsset, Comparable<PlayableCharacterType> {

	String getUniqueCharacterTypeName();

	void setUniqueCharacterTypeName(String uniqueCharacterTypeName);

	Long getGameObjectTypeId();

	void setGameObjectTypeId(Long gameObjectTypeId);

}