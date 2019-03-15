package com.crazydumplings.gameworldregistry.model;



import javax.annotation.Generated;


import com.crazydumplings.gameworldregistry.model.generic.IdentifiableGameAsset;

@Generated(value="fx.codegen.builder version 1.0.0")
public interface GameObjectTypeAutomation extends IdentifiableGameAsset, Comparable<GameObjectTypeAutomation> {

	Long getGameObjectTypeId();

	void setGameObjectTypeId(Long gameObjectTypeId);

	Long getAutomationObjectProviderId();

	void setAutomationObjectProviderId(Long automationObjectProviderId);

}