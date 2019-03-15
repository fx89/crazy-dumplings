package com.crazydumplings.gameworldregistry.model;



import javax.annotation.Generated;



import com.crazydumplings.gameworldregistry.model.generic.IdentifiableGameAsset;

@Generated(value="fx.codegen.builder version 1.0.0")
public interface GameWorldCellType extends IdentifiableGameAsset, Comparable<GameWorldCellType> {

	String getUniqueName();

	void setUniqueName(String uniqueName);

	Long getGameObjectTypeId();

	void setGameObjectTypeId(Long gameObjectTypeId);

}