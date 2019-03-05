package com.crazydumplings.gameworldregistry.model;

import com.crazydumplings.gameworldregistry.model.generic.IdentifiableGameAsset;
import com.crazydumplings.gameworldregistry.model.generic.ParentableGameAsset;

public interface GameAssetsRepositoryPicture extends ParentableGameAsset {
	GameAssetsRepository getGameAssetsRepository();

	void setGameAssetsRepository(GameAssetsRepository gameAssetsRepository);

	String getHash();

	void setHash(String hash);

	default IdentifiableGameAsset getParent() {
		return getGameAssetsRepository();
	};

	default void setParent(IdentifiableGameAsset parent) {
		setGameAssetsRepository((GameAssetsRepository) parent);
	};
}
