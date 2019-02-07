package com.crazydumplings.backend.rest.model;

public class GameObjectTypePropertyRequest {
	public String propertyName;
	public Double propertyDefaultValue;
	public double propertyMinValue;
	public double propertyMaxValue;

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public Double getPropertyDefaultValue() {
		return propertyDefaultValue;
	}

	public void setPropertyDefaultValue(Double propertyDefaultValue) {
		this.propertyDefaultValue = propertyDefaultValue;
	}

	public double getPropertyMinValue() {
		return propertyMinValue;
	}

	public void setPropertyMinValue(double propertyMinValue) {
		this.propertyMinValue = propertyMinValue;
	}

	public double getPropertyMaxValue() {
		return propertyMaxValue;
	}

	public void setPropertyMaxValue(double propertyMaxValue) {
		this.propertyMaxValue = propertyMaxValue;
	}

}
