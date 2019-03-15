package com.crazydumplings.gameworldregistry.model;



import javax.annotation.Generated;



import com.crazydumplings.gameworldregistry.model.generic.IdentifiableGameAsset;

@Generated(value="fx.codegen.builder version 1.0.0")
public interface GameWorld extends IdentifiableGameAsset, Comparable<GameWorld> {

	String getUniqueName();

	void setUniqueName(String uniqueName);

	String getDescription();

	void setDescription(String description);

	String getPictureRefPath();

	void setPictureRefPath(String pictureRefPath);

	Integer getWidth();

	void setWidth(Integer width);

	Integer getHeight();

	void setHeight(Integer height);

}