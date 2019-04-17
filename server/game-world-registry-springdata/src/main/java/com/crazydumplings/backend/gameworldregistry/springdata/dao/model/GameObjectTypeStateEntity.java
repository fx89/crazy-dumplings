// package com.crazydumplings.gameregistry.gameassetmanager.dao.model;
package com.crazydumplings.backend.gameworldregistry.springdata.dao.model;

// import com.crazydumplings.gameregistry.gameassetmanager.model.GameObjectTypeState;
import com.crazydumplings.gameworldregistry.model.GameObjectTypeState;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.annotation.Generated;

import javax.validation.constraints.Size;


@Entity
@Table(name = "GAME_OBJECT_TYPE_STATE")
@Generated(value="fx.codegen.builder version 1.0.0")
public class GameObjectTypeStateEntity implements GameObjectTypeState {
	@Id
	@Column(name = "ID_GAME_OBJECT_TYPE_STATE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public GameObjectTypeStateEntity() {
		
	}

	public GameObjectTypeStateEntity(Long id) {
		this.id = id;
	}

	private void copyAttributesFromEntity(GameObjectTypeState gameObjectTypeState) {
		this.gameObjectTypeId = gameObjectTypeState.getGameObjectTypeId();
		this.name = gameObjectTypeState.getName();
	}

	public GameObjectTypeStateEntity(GameObjectTypeStateEntity entity, Long id) {
		this.copyAttributesFromEntity(entity);
		this.id = id;
	}

	public GameObjectTypeStateEntity(GameObjectTypeStateEntity entity) {
		this.copyAttributesFromEntity(entity);
	}

	public GameObjectTypeStateEntity(GameObjectTypeState gameObjectTypeState) {
		this.copyAttributesFromEntity(gameObjectTypeState);
	}

	@Column(name = "GAME_OBJECT_TYPE_ID")
	private Long gameObjectTypeId;

	@Column(name = "NAME")
	@Size(max = 250)
	private String name;

	public Long getGameObjectTypeId() {
		return gameObjectTypeId;
	}

	public void setGameObjectTypeId(Long gameObjectTypeId) {
		this.gameObjectTypeId = gameObjectTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof GameObjectTypeStateEntity)) {
			return false;
		}

		GameObjectTypeStateEntity other = (GameObjectTypeStateEntity) obj;

		return Objects.equals(this.getId(), other.getId());
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).build();
	}

	public int compareTo(GameObjectTypeState obj) {
		if (obj == this) {
			return 0;
		}

		if (!(obj instanceof GameObjectTypeStateEntity)) {
			return -1;
		}

		GameObjectTypeStateEntity other = (GameObjectTypeStateEntity) obj;

		if (this.getName() == null) {
			return 1;
		}

		if (other.getName() == null) {
			return -1;
		}

		return this.getName().compareTo(other.getName());
	}
}