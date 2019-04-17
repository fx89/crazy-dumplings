package com.crazydumplings.gameworldregistry.model;



import javax.annotation.Generated;



import com.crazydumplings.gameworldregistry.model.generic.IdentifiableGameAsset;

@Generated(value="fx.codegen.builder version 1.0.0")
public interface GameObjectType extends IdentifiableGameAsset, Comparable<GameObjectType> {

	Long getAncestorGameObjectTypeId();

	void setAncestorGameObjectTypeId(Long ancestorGameObjectTypeId);

	Long getGameAssetsRepositoryId();

	void setGameAssetsRepositoryId(Long gameAssetsRepositoryId);

	Long getGameObjectTypeClassId();

	void setGameObjectTypeClassId(Long gameObjectTypeClassId);

	String getUniqueName();

	void setUniqueName(String uniqueName);

	String getDescription();

	void setDescription(String description);

	Boolean getIsExperimental();

	void setIsExperimental(Boolean isExperimental);


}