package com.crazydumplings.gameworldregistry.model;



import javax.annotation.Generated;


import com.crazydumplings.gameworldregistry.model.generic.ParentableGameAsset;

@Generated(value="fx.codegen.builder version 1.0.0")
public interface GameAssetsRepositoryOwner extends ParentableGameAsset, Comparable<GameAssetsRepositoryOwner> {

	Long getGameAssetsRepositoryId();

	void setGameAssetsRepositoryId(Long gameAssetsRepositoryId);

	Long getOwnerUserId();

	void setOwnerUserId(Long ownerUserId);


	default Long getParentId() {
		return getGameAssetsRepositoryId();
	}

	default void setParentId(Long parentId) {
		setGameAssetsRepositoryId(parentId);
	}

}