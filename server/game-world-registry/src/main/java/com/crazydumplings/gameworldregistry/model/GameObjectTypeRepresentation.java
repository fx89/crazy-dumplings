package com.crazydumplings.gameworldregistry.model;



import javax.annotation.Generated;


import com.crazydumplings.gameworldregistry.model.generic.ParentableGameAsset;

@Generated(value="fx.codegen.builder version 1.0.0")
public interface GameObjectTypeRepresentation extends ParentableGameAsset, Comparable<GameObjectTypeRepresentation> {

	Long getGameObjectTypeId();

	void setGameObjectTypeId(Long gameObjectTypeId);

	Long getGameClientTypeId();

	void setGameClientTypeId(Long gameClientTypeId);

	String getObjectHash();

	void setObjectHash(String objectHash);


	default Long getParentId() {
		return getGameObjectTypeId();
	}

	default void setParentId(Long parentId) {
		setGameObjectTypeId(parentId);
	}

}