// package com.crazydumplings.gameregistry.gameassetmanager.dao.model;
package com.crazydumplings.backend.gameworldregistry.springdata.dao.model;

// import com.crazydumplings.gameregistry.gameassetmanager.model.GameObjectTypePropertyInstance;
import com.crazydumplings.gameworldregistry.model.GameObjectTypePropertyInstance;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.annotation.Generated;


@Entity
@Table(name = "GAME_OBJECT_TYPE_PROPERTY_INSTANCE")
@Generated(value="fx.codegen.builder version 1.0.0")
public class GameObjectTypePropertyInstanceEntity implements GameObjectTypePropertyInstance {
	@Id
	@Column(name = "ID_GAME_OBJECT_TYPE_PROPERTY_INSTANCE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public GameObjectTypePropertyInstanceEntity() {
		
	}

	public GameObjectTypePropertyInstanceEntity(Long id) {
		this.id = id;
	}

	private void copyAttributesFromEntity(GameObjectTypePropertyInstance gameObjectTypePropertyInstance) {
		this.gameObjectTypeId = gameObjectTypePropertyInstance.getGameObjectTypeId();
		this.gameObjectTypePropertyId = gameObjectTypePropertyInstance.getGameObjectTypePropertyId();
		this.propertyDefaultValue = gameObjectTypePropertyInstance.getPropertyDefaultValue();
		this.propertyMinValue = gameObjectTypePropertyInstance.getPropertyMinValue();
		this.propertyMaxValue = gameObjectTypePropertyInstance.getPropertyMaxValue();
	}

	public GameObjectTypePropertyInstanceEntity(GameObjectTypePropertyInstanceEntity entity, Long id) {
		this.copyAttributesFromEntity(entity);
		this.id = id;
	}

	public GameObjectTypePropertyInstanceEntity(GameObjectTypePropertyInstanceEntity entity) {
		this.copyAttributesFromEntity(entity);
	}

	public GameObjectTypePropertyInstanceEntity(GameObjectTypePropertyInstance gameObjectTypePropertyInstance) {
		this.copyAttributesFromEntity(gameObjectTypePropertyInstance);
	}

	@Column(name = "GAME_OBJECT_TYPE_ID")
	private Long gameObjectTypeId;

	@Column(name = "GAME_OBJECT_TYPE_PROPERTY_ID")
	private Long gameObjectTypePropertyId;

	@Column(name = "PROPERTY_DEFAULT_VALUE")
	private Double propertyDefaultValue;

	@Column(name = "PROPERTY_MIN_VALUE")
	private Double propertyMinValue;

	@Column(name = "PROPERTY_MAX_VALUE")
	private Double propertyMaxValue;

	public Long getGameObjectTypeId() {
		return gameObjectTypeId;
	}

	public void setGameObjectTypeId(Long gameObjectTypeId) {
		this.gameObjectTypeId = gameObjectTypeId;
	}

	public Long getGameObjectTypePropertyId() {
		return gameObjectTypePropertyId;
	}

	public void setGameObjectTypePropertyId(Long gameObjectTypePropertyId) {
		this.gameObjectTypePropertyId = gameObjectTypePropertyId;
	}

	public Double getPropertyDefaultValue() {
		return propertyDefaultValue;
	}

	public void setPropertyDefaultValue(Double propertyDefaultValue) {
		this.propertyDefaultValue = propertyDefaultValue;
	}

	public Double getPropertyMinValue() {
		return propertyMinValue;
	}

	public void setPropertyMinValue(Double propertyMinValue) {
		this.propertyMinValue = propertyMinValue;
	}

	public Double getPropertyMaxValue() {
		return propertyMaxValue;
	}

	public void setPropertyMaxValue(Double propertyMaxValue) {
		this.propertyMaxValue = propertyMaxValue;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof GameObjectTypePropertyInstanceEntity)) {
			return false;
		}

		GameObjectTypePropertyInstanceEntity other = (GameObjectTypePropertyInstanceEntity) obj;

		return Objects.equals(this.getId(), other.getId());
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).build();
	}

	public int compareTo(GameObjectTypePropertyInstance obj) {
		if (obj == this) {
			return 0;
		}

		if (!(obj instanceof GameObjectTypePropertyInstanceEntity)) {
			return -1;
		}

		GameObjectTypePropertyInstanceEntity other = (GameObjectTypePropertyInstanceEntity) obj;

		if (this.getId() == null) {
			return 1;
		}

		if (other.getId() == null) {
			return -1;
		}

		return this.getId().compareTo(other.getId());
	}
}