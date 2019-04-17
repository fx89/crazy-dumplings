package com.crazydumplings.gameworldregistry.model;



import javax.annotation.Generated;


import com.crazydumplings.gameworldregistry.model.generic.ParentableGameAsset;

@Generated(value="fx.codegen.builder version 1.0.0")
public interface GameObjectTypeAutomation extends ParentableGameAsset, Comparable<GameObjectTypeAutomation> {

	Long getGameObjectTypeId();

	void setGameObjectTypeId(Long gameObjectTypeId);

	Long getAutomationObjectProviderId();

	void setAutomationObjectProviderId(Long automationObjectProviderId);


	default Long getParentId() {
		return getGameObjectTypeId();
	}

	default void setParentId(Long parentId) {
		setGameObjectTypeId(parentId);
	}

}