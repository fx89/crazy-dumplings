package com.crazydumplings.gameworldregistry.model;



import javax.annotation.Generated;


import com.crazydumplings.gameworldregistry.model.generic.IdentifiableGameAsset;

@Generated(value="fx.codegen.builder version 1.0.0")
public interface GameObjectTypeStateTransition extends IdentifiableGameAsset, Comparable<GameObjectTypeStateTransition> {

	Long getSourceGameObjectTypeStateId();

	void setSourceGameObjectTypeStateId(Long sourceGameObjectTypeStateId);

	Long getTargetGameObjectTypeStateId();

	void setTargetGameObjectTypeStateId(Long targetGameObjectTypeStateId);

	Boolean getIsAutomatic();

	void setIsAutomatic(Boolean isAutomatic);

	Long getTriggerActionId();

	void setTriggerActionId(Long triggerActionId);

}