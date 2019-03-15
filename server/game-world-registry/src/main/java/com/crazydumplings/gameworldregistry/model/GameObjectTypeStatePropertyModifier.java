package com.crazydumplings.gameworldregistry.model;



import javax.annotation.Generated;


import com.crazydumplings.gameworldregistry.model.generic.IdentifiableGameAsset;

@Generated(value="fx.codegen.builder version 1.0.0")
public interface GameObjectTypeStatePropertyModifier extends IdentifiableGameAsset, Comparable<GameObjectTypeStatePropertyModifier> {

	Long getGameObjectTypeStateId();

	void setGameObjectTypeStateId(Long gameObjectTypeStateId);

	Long getGameObjectTypePropertyId();

	void setGameObjectTypePropertyId(Long gameObjectTypePropertyId);

	Double getPropertyActualValue();

	void setPropertyActualValue(Double propertyActualValue);

}