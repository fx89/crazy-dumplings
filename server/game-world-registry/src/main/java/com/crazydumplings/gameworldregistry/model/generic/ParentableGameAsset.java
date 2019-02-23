package com.crazydumplings.gameworldregistry.model.generic;

/**
 * The parentable game asset is a {@link com.crazydumplings.gameworldregistry.model.generic.IdentifiableGameAsset
 * identifiable game asset} which has another identifiable game asset as a parent. This helps with generics.
 */
public interface ParentableGameAsset extends IdentifiableGameAsset {
	IdentifiableGameAsset getParent();

	void setParent(IdentifiableGameAsset parent);
}
