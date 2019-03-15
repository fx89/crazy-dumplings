package com.crazydumplings.gameworldregistry.model;



import javax.annotation.Generated;


import com.crazydumplings.gameworldregistry.model.generic.IdentifiableGameAsset;

@Generated(value="fx.codegen.builder version 1.0.0")
public interface GameObjectTypeRepresentation extends IdentifiableGameAsset, Comparable<GameObjectTypeRepresentation> {

	Long getGameObjectTypeId();

	void setGameObjectTypeId(Long gameObjectTypeId);

	Long getGameClientTypeId();

	void setGameClientTypeId(Long gameClientTypeId);

	Boolean getObjectHash();

	void setObjectHash(Boolean objectHash);

}