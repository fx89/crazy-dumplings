package com.crazydumplings.backend.rest.model;

/**
 * Used as a data transfer object. Allows the caller of the API to provide the
 * request in a simplified manner.
 */
public class GameObjectTypeRequest {
	public String uniqueName;
	public boolean experimental;
	public String description;
	public Long gameObjectTypeClassId;

	public String getUniqueName() {
		return uniqueName;
	}

	public void setUniqueName(String uniqueName) {
		this.uniqueName = uniqueName;
	}

	public boolean isExperimental() {
		return experimental;
	}

	public void setExperimental(boolean experimental) {
		this.experimental = experimental;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getGameObjectTypeClassId() {
		return gameObjectTypeClassId;
	}

	public void setGameObjectTypeClassId(Long gameObjectTypeClassId) {
		this.gameObjectTypeClassId = gameObjectTypeClassId;
	}

}
