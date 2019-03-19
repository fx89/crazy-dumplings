package com.crazydumplings.backend.rest.model;

import com.crazydumplings.gameworldregistry.model.GameObjectTypeProperty;

public class GameObjectTypePropertyRequest implements GameObjectTypeProperty {
	private Long id;
	private Long gameObjectTypeId;
	public String propertyName;
	public Double propertyDefaultValue;
	public double propertyMinValue;
	public double propertyMaxValue;

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int compareTo(GameObjectTypeProperty o) {
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
	public String getPropertyName() {
		return propertyName;
	}

	@Override
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	@Override
	public Double getPropertyDefaultValue() {
		return propertyDefaultValue;
	}

	@Override
	public void setPropertyDefaultValue(Double propertyDefaultValue) {
		this.propertyDefaultValue = propertyDefaultValue;
	}

	@Override
	public Double getPropertyMinValue() {
		return propertyMinValue;
	}

	@Override
	public void setPropertyMinValue(Double propertyMinValue) {
		this.propertyMinValue = propertyMinValue;
	}

	@Override
	public Double getPropertyMaxValue() {
		return propertyMaxValue;
	}

	@Override
	public void setPropertyMaxValue(Double propertyMaxValue) {
		this.propertyMaxValue = propertyMaxValue;
	}

}
