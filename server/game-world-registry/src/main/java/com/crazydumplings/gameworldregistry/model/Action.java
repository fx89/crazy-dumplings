package com.crazydumplings.gameworldregistry.model;



import javax.annotation.Generated;



import com.crazydumplings.gameworldregistry.model.generic.IdentifiableGameAsset;

@Generated(value="fx.codegen.builder version 1.0.0")
public interface Action extends IdentifiableGameAsset, Comparable<Action> {

	String getUniqueName();

	void setUniqueName(String uniqueName);


}