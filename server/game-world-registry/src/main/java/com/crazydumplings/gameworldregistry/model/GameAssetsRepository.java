package com.crazydumplings.gameworldregistry.model;



import javax.annotation.Generated;



import com.crazydumplings.gameworldregistry.model.generic.IdentifiableGameAsset;

@Generated(value="fx.codegen.builder version 1.0.0")
public interface GameAssetsRepository extends IdentifiableGameAsset, Comparable<GameAssetsRepository> {

	String getUniqueName();

	void setUniqueName(String uniqueName);

	String getDescription();

	void setDescription(String description);

	String getPictureHash();

	void setPictureHash(String pictureHash);


}