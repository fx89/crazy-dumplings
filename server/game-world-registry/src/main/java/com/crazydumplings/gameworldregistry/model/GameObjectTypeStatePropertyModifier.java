package com.crazydumplings.gameworldregistry.model;



import javax.annotation.Generated;


import com.crazydumplings.gameworldregistry.model.generic.ParentableGameAsset;

@Generated(value="fx.codegen.builder version 1.0.0")
public interface GameObjectTypeStatePropertyModifier extends ParentableGameAsset, Comparable<GameObjectTypeStatePropertyModifier> {

	Long getGameObjectTypeStateId();

	void setGameObjectTypeStateId(Long gameObjectTypeStateId);

	Long getGameObjectTypePropertyId();

	void setGameObjectTypePropertyId(Long gameObjectTypePropertyId);

	Double getPropertyActualValue();

	void setPropertyActualValue(Double propertyActualValue);


	default Long getParentId() {
		return getGameObjectTypeStateId();
	}

	default void setParentId(Long parentId) {
		setGameObjectTypeStateId(parentId);
	}

}