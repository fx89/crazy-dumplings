package com.crazydumplings.gameworldregistry.model;



import javax.annotation.Generated;


import com.crazydumplings.gameworldregistry.model.generic.IdentifiableGameAsset;

@Generated(value="fx.codegen.builder version 1.0.0")
public interface GameObjectTypeInteraction extends IdentifiableGameAsset, Comparable<GameObjectTypeInteraction> {

	Long getDonatingGameObjectTypeId();

	void setDonatingGameObjectTypeId(Long donatingGameObjectTypeId);

	Long getReceivingGameObjectTypeId();

	void setReceivingGameObjectTypeId(Long receivingGameObjectTypeId);

	Integer getRadius();

	void setRadius(Integer radius);


}