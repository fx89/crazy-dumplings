// package com.crazydumplings.gameregistry.gameassetmanager.dao.model;
package com.crazydumplings.backend.gameworldregistry.springdata.dao.model;

// import com.crazydumplings.gameregistry.gameassetmanager.model.GameWorldCellType;
import com.crazydumplings.gameworldregistry.model.GameWorldCellType;

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
@Table(name = "GAME_WORLD_CELL_TYPE")
@Generated(value="fx.codegen.builder version 1.0.0")
public class GameWorldCellTypeEntity implements GameWorldCellType {
	@Id
	@Column(name = "ID_GAME_WORLD_CELL_TYPE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public GameWorldCellTypeEntity() {
		
	}

	public GameWorldCellTypeEntity(Long id) {
		this.id = id;
	}

	public GameWorldCellTypeEntity(GameWorldCellTypeEntity entity, Long id) {
		this.id = id;
		this.uniqueName = entity.uniqueName;
		this.gameObjectTypeId = entity.gameObjectTypeId;
	}

	@Column(name = "UNIQUE_NAME")
	@Size(max = 250)
	private String uniqueName;

	@Column(name = "GAME_OBJECT_TYPE_ID")
	private Long gameObjectTypeId;

	public String getUniqueName() {
		return uniqueName;
	}

	public void setUniqueName(String uniqueName) {
		this.uniqueName = uniqueName;
	}

	public Long getGameObjectTypeId() {
		return gameObjectTypeId;
	}

	public void setGameObjectTypeId(Long gameObjectTypeId) {
		this.gameObjectTypeId = gameObjectTypeId;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof GameWorldCellTypeEntity)) {
			return false;
		}

		GameWorldCellTypeEntity other = (GameWorldCellTypeEntity) obj;

		return Objects.equals(this.getId(), other.getId());
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).build();
	}

	public int compareTo(GameWorldCellType obj) {
		if (obj == this) {
			return 0;
		}

		if (!(obj instanceof GameWorldCellTypeEntity)) {
			return -1;
		}

		GameWorldCellTypeEntity other = (GameWorldCellTypeEntity) obj;

		if (this.getUniqueName() == null) {
			return 1;
		}

		if (other.getUniqueName() == null) {
			return -1;
		}

		return this.getUniqueName().compareTo(other.getUniqueName());
	}
}