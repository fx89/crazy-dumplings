package com.crazydumplings.gameworldregistry.model;



import javax.annotation.Generated;



import com.crazydumplings.gameworldregistry.model.generic.ParentableGameAsset;

@Generated(value="fx.codegen.builder version 1.0.0")
public interface GameObjectTypeState extends ParentableGameAsset, Comparable<GameObjectTypeState> {

	Long getGameObjectTypeId();

	void setGameObjectTypeId(Long gameObjectTypeId);

	String getName();

	void setName(String name);


	default Long getParentId() {
		return getGameObjectTypeId();
	}

	default void setParentId(Long parentId) {
		setGameObjectTypeId(parentId);
	}

}