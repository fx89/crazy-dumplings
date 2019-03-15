package com.crazydumplings.gameworldregistry.model.generic;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The parentable game asset is a {@link com.crazydumplings.gameworldregistry.model.generic.IdentifiableGameAsset
 * identifiable game asset} which has another identifiable game asset as a parent. This helps with generics.
 */
public interface ParentableGameAsset extends IdentifiableGameAsset {
	// TODO: Reevaluate the dependency on Jackson at this point - the game world registry should not have anything to do with DTOs and JSONs

	@JsonIgnore
	Long getParentId();

	@JsonIgnore
	void setParentId(Long parentId);
}
