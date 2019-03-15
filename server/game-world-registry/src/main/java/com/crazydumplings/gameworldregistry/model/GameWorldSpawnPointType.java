package com.crazydumplings.gameworldregistry.model;



import javax.annotation.Generated;


import com.crazydumplings.gameworldregistry.model.generic.IdentifiableGameAsset;

@Generated(value="fx.codegen.builder version 1.0.0")
public interface GameWorldSpawnPointType extends IdentifiableGameAsset, Comparable<GameWorldSpawnPointType> {

	Long getSpawnPointGameObjectTypeId();

	void setSpawnPointGameObjectTypeId(Long spawnPointGameObjectTypeId);

	Long getSpawnedGameObjectTypeId();

	void setSpawnedGameObjectTypeId(Long spawnedGameObjectTypeId);

}