package com.crazydumplings.backend.rest.model;

import com.crazydumplings.gameworldregistry.model.GameObjectType;

/**
 * Used as a data transfer object. Allows the caller of the API to provide the
 * request in a simplified manner.
 */
public class GameObjectTypeRequest implements GameObjectType {
	private Long id;
	private Long gameAssetsRepositoryId;
	private Long gameObjectTypeClassId;
	private String uniqueName;
	private Boolean isExperimental;
	private String description;

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int compareTo(GameObjectType o) {
		return id == null ? -1 : (o == null || o.getId() == null ? 1 : id.compareTo(o.getId()));
	}

	@Override
	public Long getGameAssetsRepositoryId() {
		return gameAssetsRepositoryId;
	}

	@Override
	public void setGameAssetsRepositoryId(Long gameAssetsRepositoryId) {
		this.gameAssetsRepositoryId = gameAssetsRepositoryId;
	}

	@Override
	public Long getGameObjectTypeClassId() {
		return gameObjectTypeClassId;
	}

	@Override
	public void setGameObjectTypeClassId(Long gameObjectTypeClassId) {
		this.gameObjectTypeClassId = gameObjectTypeClassId;
	}

	@Override
	public String getUniqueName() {
		return uniqueName;
	}

	@Override
	public void setUniqueName(String uniqueName) {
		this.uniqueName = uniqueName;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public Boolean getIsExperimental() {
		return isExperimental;
	}

	@Override
	public void setIsExperimental(Boolean isExperimental) {
		this.isExperimental = isExperimental;
	}

}
