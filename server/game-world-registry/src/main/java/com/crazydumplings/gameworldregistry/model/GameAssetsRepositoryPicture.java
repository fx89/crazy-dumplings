package com.crazydumplings.gameworldregistry.model;



import javax.annotation.Generated;


import com.crazydumplings.gameworldregistry.model.generic.IdentifiableGameAsset;

@Generated(value="fx.codegen.builder version 1.0.0")
public interface GameAssetsRepositoryPicture extends IdentifiableGameAsset, Comparable<GameAssetsRepositoryPicture> {

	Long getGameAssetsRepositoryId();

	void setGameAssetsRepositoryId(Long gameAssetsRepositoryId);

	String getPictureHash();

	void setPictureHash(String pictureHash);

}