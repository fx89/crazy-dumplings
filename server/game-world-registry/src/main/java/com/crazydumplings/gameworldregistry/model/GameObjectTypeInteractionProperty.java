package com.crazydumplings.gameworldregistry.model;



import javax.annotation.Generated;


import com.crazydumplings.gameworldregistry.model.generic.ParentableGameAsset;

@Generated(value="fx.codegen.builder version 1.0.0")
public interface GameObjectTypeInteractionProperty extends ParentableGameAsset, Comparable<GameObjectTypeInteractionProperty> {

	Long getGameObjectTypeInteractionId();

	void setGameObjectTypeInteractionId(Long gameObjectTypeInteractionId);

	Long getDonatingGameObjectTypePropertyId();

	void setDonatingGameObjectTypePropertyId(Long donatingGameObjectTypePropertyId);

	Long getReceivingGameObjectTypePropertyId();

	void setReceivingGameObjectTypePropertyId(Long receivingGameObjectTypePropertyId);

	Long getOverflowGameObjectTypePropertyId();

	void setOverflowGameObjectTypePropertyId(Long overflowGameObjectTypePropertyId);

	Boolean getIsIncremental();

	void setIsIncremental(Boolean isIncremental);

	Boolean getIsInverted();

	void setIsInverted(Boolean isInverted);


	default Long getParentId() {
		return getGameObjectTypeInteractionId();
	}

	default void setParentId(Long parentId) {
		setGameObjectTypeInteractionId(parentId);
	}

}