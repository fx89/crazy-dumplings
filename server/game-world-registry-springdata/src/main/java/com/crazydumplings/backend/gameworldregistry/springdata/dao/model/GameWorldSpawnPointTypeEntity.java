// package com.crazydumplings.gameregistry.gameassetmanager.dao.model;
package com.crazydumplings.backend.gameworldregistry.springdata.dao.model;

// import com.crazydumplings.gameregistry.gameassetmanager.model.GameWorldSpawnPointType;
import com.crazydumplings.gameworldregistry.model.GameWorldSpawnPointType;

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
@Table(name = "GAME_WORLD_SPAWN_POINT_TYPE")
@Generated(value="fx.codegen.builder version 1.0.0")
public class GameWorldSpawnPointTypeEntity implements GameWorldSpawnPointType {
	@Id
	@Column(name = "ID_GAME_WORLD_SPAWN_POINT_TYPE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public GameWorldSpawnPointTypeEntity() {
		
	}

	public GameWorldSpawnPointTypeEntity(Long id) {
		this.id = id;
	}

	private void copyAttributesFromEntity(GameWorldSpawnPointType gameWorldSpawnPointType) {
		this.spawnPointGameObjectTypeId = gameWorldSpawnPointType.getSpawnPointGameObjectTypeId();
		this.spawnedGameObjectTypeId = gameWorldSpawnPointType.getSpawnedGameObjectTypeId();
	}

	public GameWorldSpawnPointTypeEntity(GameWorldSpawnPointTypeEntity entity, Long id) {
		this.copyAttributesFromEntity(entity);
		this.id = id;
	}

	public GameWorldSpawnPointTypeEntity(GameWorldSpawnPointTypeEntity entity) {
		this.copyAttributesFromEntity(entity);
	}

	public GameWorldSpawnPointTypeEntity(GameWorldSpawnPointType gameWorldSpawnPointType) {
		this.copyAttributesFromEntity(gameWorldSpawnPointType);
	}

	@Column(name = "SPAWN_POINT_GAME_OBJECT_TYPE_ID")
	private Long spawnPointGameObjectTypeId;

	@Column(name = "SPAWNED_GAME_OBJECT_TYPE_ID")
	private Long spawnedGameObjectTypeId;

	public Long getSpawnPointGameObjectTypeId() {
		return spawnPointGameObjectTypeId;
	}

	public void setSpawnPointGameObjectTypeId(Long spawnPointGameObjectTypeId) {
		this.spawnPointGameObjectTypeId = spawnPointGameObjectTypeId;
	}

	public Long getSpawnedGameObjectTypeId() {
		return spawnedGameObjectTypeId;
	}

	public void setSpawnedGameObjectTypeId(Long spawnedGameObjectTypeId) {
		this.spawnedGameObjectTypeId = spawnedGameObjectTypeId;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof GameWorldSpawnPointTypeEntity)) {
			return false;
		}

		GameWorldSpawnPointTypeEntity other = (GameWorldSpawnPointTypeEntity) obj;

		return Objects.equals(this.getId(), other.getId());
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).build();
	}

	public int compareTo(GameWorldSpawnPointType obj) {
		if (obj == this) {
			return 0;
		}

		if (!(obj instanceof GameWorldSpawnPointTypeEntity)) {
			return -1;
		}

		GameWorldSpawnPointTypeEntity other = (GameWorldSpawnPointTypeEntity) obj;

		if (this.getId() == null) {
			return 1;
		}

		if (other.getId() == null) {
			return -1;
		}

		return this.getId().compareTo(other.getId());
	}
}