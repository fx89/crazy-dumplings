package com.crazydumplings.gameworldregistry.model;



import javax.annotation.Generated;

import com.crazydumplings.gameworldregistry.model.generic.ParentableGameAsset;

@Generated(value="fx.codegen.builder version 1.0.0")
public interface GameObjectTypeProperty extends ParentableGameAsset, Comparable<GameObjectTypeProperty> {

	Long getGameObjectTypeId();

	void setGameObjectTypeId(Long gameObjectTypeId);

	String getPropertyName();

	void setPropertyName(String propertyName);

	Double getPropertyDefaultValue();

	void setPropertyDefaultValue(Double propertyDefaultValue);

	Double getPropertyMinValue();

	void setPropertyMinValue(Double propertyMinValue);

	Double getPropertyMaxValue();

	void setPropertyMaxValue(Double propertyMaxValue);

	default Long getParentId() {
		return getGameObjectTypeId();
	}

	default void setParentId(Long parentId) {
		setGameObjectTypeId(parentId);
	}

}