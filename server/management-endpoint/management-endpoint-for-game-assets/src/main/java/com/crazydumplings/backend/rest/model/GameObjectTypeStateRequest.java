package com.crazydumplings.backend.rest.model;

import com.crazydumplings.gameworldregistry.model.GameObjectTypeState;

public class GameObjectTypeStateRequest implements GameObjectTypeState {
	String name;

	Long gameObjectTypeId;

	Long id;

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int compareTo(GameObjectTypeState o) {
		return this.id == null ? -1 : (o == null || o.getId() == null ? 1 : this.id.compareTo(o.getId()));
	}

	@Override
	public Long getGameObjectTypeId() {
		return gameObjectTypeId;
	}

	@Override
	public void setGameObjectTypeId(Long gameObjectTypeId) {
		this.gameObjectTypeId = gameObjectTypeId;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

}
