package com.crazydumplings.gameworldregistry.model;



import javax.annotation.Generated;


import com.crazydumplings.gameworldregistry.model.generic.ParentableGameAsset;

@Generated(value="fx.codegen.builder version 1.0.0")
public interface GameWorldCellProperty extends ParentableGameAsset, Comparable<GameWorldCellProperty> {

	Long getGameWorldCellId();

	void setGameWorldCellId(Long gameWorldCellId);

	Long getGameObjectTypePropertyId();

	void setGameObjectTypePropertyId(Long gameObjectTypePropertyId);

	Double getPropertyActualValue();

	void setPropertyActualValue(Double propertyActualValue);


	default Long getParentId() {
		return getGameWorldCellId();
	}

	default void setParentId(Long parentId) {
		setGameWorldCellId(parentId);
	}

}