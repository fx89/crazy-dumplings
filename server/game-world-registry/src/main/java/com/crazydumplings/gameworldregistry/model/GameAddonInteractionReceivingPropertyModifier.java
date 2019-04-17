package com.crazydumplings.gameworldregistry.model;



import javax.annotation.Generated;


import com.crazydumplings.gameworldregistry.model.generic.IdentifiableGameAsset;

@Generated(value="fx.codegen.builder version 1.0.0")
public interface GameAddonInteractionReceivingPropertyModifier extends IdentifiableGameAsset, Comparable<GameAddonInteractionReceivingPropertyModifier> {

	Long getGameObjectTypeAllowedAddonTypeId();

	void setGameObjectTypeAllowedAddonTypeId(Long gameObjectTypeAllowedAddonTypeId);

	Long getAffectedGameObjectTypePropertyId();

	void setAffectedGameObjectTypePropertyId(Long affectedGameObjectTypePropertyId);

	Double getAppliedPropertyValueMultiplier();

	void setAppliedPropertyValueMultiplier(Double appliedPropertyValueMultiplier);


}