// package com.crazydumplings.gameregistry.gameassetmanager.dao.model;
package com.crazydumplings.backend.gameworldregistry.springdata.dao.model;

// import com.crazydumplings.gameregistry.gameassetmanager.model.GameObjectTypeStatePropertyModifier;
import com.crazydumplings.gameworldregistry.model.GameObjectTypeStatePropertyModifier;

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
@Table(name = "GAME_OBJECT_TYPE_STATE_PROPERTY_MODIFIER")
@Generated(value="fx.codegen.builder version 1.0.0")
public class GameObjectTypeStatePropertyModifierEntity implements GameObjectTypeStatePropertyModifier {
	@Id
	@Column(name = "ID_GAME_OBJECT_TYPE_STATE_PROPERTY_MODIFIER")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public GameObjectTypeStatePropertyModifierEntity() {
		
	}

	public GameObjectTypeStatePropertyModifierEntity(Long id) {
		this.id = id;
	}

	private void copyAttributesFromEntity(GameObjectTypeStatePropertyModifier gameObjectTypeStatePropertyModifier) {
		this.gameObjectTypeStateId = gameObjectTypeStatePropertyModifier.getGameObjectTypeStateId();
		this.gameObjectTypePropertyId = gameObjectTypeStatePropertyModifier.getGameObjectTypePropertyId();
		this.propertyActualValue = gameObjectTypeStatePropertyModifier.getPropertyActualValue();
	}

	public GameObjectTypeStatePropertyModifierEntity(GameObjectTypeStatePropertyModifierEntity entity, Long id) {
		this.copyAttributesFromEntity(entity);
		this.id = id;
	}

	public GameObjectTypeStatePropertyModifierEntity(GameObjectTypeStatePropertyModifierEntity entity) {
		this.copyAttributesFromEntity(entity);
	}

	public GameObjectTypeStatePropertyModifierEntity(GameObjectTypeStatePropertyModifier gameObjectTypeStatePropertyModifier) {
		this.copyAttributesFromEntity(gameObjectTypeStatePropertyModifier);
	}

	@Column(name = "GAME_OBJECT_TYPE_STATE_ID")
	private Long gameObjectTypeStateId;

	@Column(name = "GAME_OBJECT_TYPE_PROPERTY_ID")
	private Long gameObjectTypePropertyId;

	@Column(name = "PROPERTY_ACTUAL_VALUE")
	private Double propertyActualValue;

	public Long getGameObjectTypeStateId() {
		return gameObjectTypeStateId;
	}

	public void setGameObjectTypeStateId(Long gameObjectTypeStateId) {
		this.gameObjectTypeStateId = gameObjectTypeStateId;
	}

	public Long getGameObjectTypePropertyId() {
		return gameObjectTypePropertyId;
	}

	public void setGameObjectTypePropertyId(Long gameObjectTypePropertyId) {
		this.gameObjectTypePropertyId = gameObjectTypePropertyId;
	}

	public Double getPropertyActualValue() {
		return propertyActualValue;
	}

	public void setPropertyActualValue(Double propertyActualValue) {
		this.propertyActualValue = propertyActualValue;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof GameObjectTypeStatePropertyModifierEntity)) {
			return false;
		}

		GameObjectTypeStatePropertyModifierEntity other = (GameObjectTypeStatePropertyModifierEntity) obj;

		return Objects.equals(this.getId(), other.getId());
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).build();
	}

	public int compareTo(GameObjectTypeStatePropertyModifier obj) {
		if (obj == this) {
			return 0;
		}

		if (!(obj instanceof GameObjectTypeStatePropertyModifierEntity)) {
			return -1;
		}

		GameObjectTypeStatePropertyModifierEntity other = (GameObjectTypeStatePropertyModifierEntity) obj;

		if (this.getId() == null) {
			return 1;
		}

		if (other.getId() == null) {
			return -1;
		}

		return this.getId().compareTo(other.getId());
	}
}