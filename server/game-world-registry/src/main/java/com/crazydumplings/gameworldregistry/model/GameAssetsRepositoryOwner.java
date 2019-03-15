package com.crazydumplings.gameworldregistry.model;

public interface GameAssetsRepositoryOwner {
	void setGameAssetsRepositoryId(Long gameAssetsRepositoryId);

	Long getGameAssetsRepositoryId();

	Long getOwnerUserId();

	void setOwnerUserId(Long ownerUserId);
}
