// package com.crazydumplings.gameregistry.gameassetmanager.dao.model;
package com.crazydumplings.backend.gameworldregistry.springdata.dao.model;

// import com.crazydumplings.gameregistry.gameassetmanager.model.GameObjectTypeRepresentation;
import com.crazydumplings.gameworldregistry.model.GameObjectTypeRepresentation;

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
@Table(name = "GAME_OBJECT_TYPE_REPRESENTATION")
@Generated(value="fx.codegen.builder version 1.0.0")
public class GameObjectTypeRepresentationEntity implements GameObjectTypeRepresentation {
	@Id
	@Column(name = "ID_GAME_OBJECT_TYPE_REPRESENTATION")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public GameObjectTypeRepresentationEntity() {
		
	}

	public GameObjectTypeRepresentationEntity(Long id) {
		this.id = id;
	}

	public GameObjectTypeRepresentationEntity(GameObjectTypeRepresentationEntity entity, Long id) {
		this.id = id;
		this.gameObjectTypeId = entity.gameObjectTypeId;
		this.gameClientTypeId = entity.gameClientTypeId;
		this.objectHash = entity.objectHash;
	}

	@Column(name = "GAME_OBJECT_TYPE_ID")
	private Long gameObjectTypeId;

	@Column(name = "GAME_CLIENT_TYPE_ID")
	private Long gameClientTypeId;

	@Column(name = "OBJECT_HASH")
	private Boolean objectHash;

	public Long getGameObjectTypeId() {
		return gameObjectTypeId;
	}

	public void setGameObjectTypeId(Long gameObjectTypeId) {
		this.gameObjectTypeId = gameObjectTypeId;
	}

	public Long getGameClientTypeId() {
		return gameClientTypeId;
	}

	public void setGameClientTypeId(Long gameClientTypeId) {
		this.gameClientTypeId = gameClientTypeId;
	}

	public Boolean getObjectHash() {
		return objectHash;
	}

	public void setObjectHash(Boolean objectHash) {
		this.objectHash = objectHash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof GameObjectTypeRepresentationEntity)) {
			return false;
		}

		GameObjectTypeRepresentationEntity other = (GameObjectTypeRepresentationEntity) obj;

		return Objects.equals(this.getId(), other.getId());
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).build();
	}

	public int compareTo(GameObjectTypeRepresentation obj) {
		if (obj == this) {
			return 0;
		}

		if (!(obj instanceof GameObjectTypeRepresentationEntity)) {
			return -1;
		}

		GameObjectTypeRepresentationEntity other = (GameObjectTypeRepresentationEntity) obj;

		if (this.getId() == null) {
			return 1;
		}

		if (other.getId() == null) {
			return -1;
		}

		return this.getId().compareTo(other.getId());
	}
}