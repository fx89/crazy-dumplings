package com.crazydumplings.gameworldregistry.model;



import javax.annotation.Generated;



import com.crazydumplings.gameworldregistry.model.generic.IdentifiableGameAsset;

@Generated(value="fx.codegen.builder version 1.0.0")
public interface GameObjectTypeClass extends IdentifiableGameAsset, Comparable<GameObjectTypeClass> {

	String getName();

	void setName(String name);

}