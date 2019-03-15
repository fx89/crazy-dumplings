// package com.crazydumplings.gameregistry.gameassetmanager.dao.model;
package com.crazydumplings.backend.gameworldregistry.springdata.dao.model;

// import com.crazydumplings.gameregistry.gameassetmanager.model.GameWorldCell;
import com.crazydumplings.gameworldregistry.model.GameWorldCell;

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
@Table(name = "GAME_WORLD_CELL")
@Generated(value="fx.codegen.builder version 1.0.0")
public class GameWorldCellEntity implements GameWorldCell {
	@Id
	@Column(name = "ID_GAME_WORLD_CELL")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public GameWorldCellEntity() {
		
	}

	public GameWorldCellEntity(Long id) {
		this.id = id;
	}

	public GameWorldCellEntity(GameWorldCellEntity entity, Long id) {
		this.id = id;
		this.gameWorldId = entity.gameWorldId;
		this.gameWorldCellTypeId = entity.gameWorldCellTypeId;
		this.xIndex = entity.xIndex;
		this.yIndex = entity.yIndex;
		this.attachedGameWorldSpawnPointTypeId = entity.attachedGameWorldSpawnPointTypeId;
	}

	@Column(name = "GAME_WORLD_ID")
	private Long gameWorldId;

	@Column(name = "GAME_WORLD_CELL_TYPE_ID")
	private Long gameWorldCellTypeId;

	@Column(name = "X_INDEX")
	private Integer xIndex;

	@Column(name = "Y_INDEX")
	private Integer yIndex;

	@Column(name = "ATTACHED_GAME_WORLD_SPAWN_POINT_TYPE_ID")
	private Long attachedGameWorldSpawnPointTypeId;

	public Long getGameWorldId() {
		return gameWorldId;
	}

	public void setGameWorldId(Long gameWorldId) {
		this.gameWorldId = gameWorldId;
	}

	public Long getGameWorldCellTypeId() {
		return gameWorldCellTypeId;
	}

	public void setGameWorldCellTypeId(Long gameWorldCellTypeId) {
		this.gameWorldCellTypeId = gameWorldCellTypeId;
	}

	public Integer getXIndex() {
		return xIndex;
	}

	public void setXIndex(Integer xIndex) {
		this.xIndex = xIndex;
	}

	public Integer getYIndex() {
		return yIndex;
	}

	public void setYIndex(Integer yIndex) {
		this.yIndex = yIndex;
	}

	public Long getAttachedGameWorldSpawnPointTypeId() {
		return attachedGameWorldSpawnPointTypeId;
	}

	public void setAttachedGameWorldSpawnPointTypeId(Long attachedGameWorldSpawnPointTypeId) {
		this.attachedGameWorldSpawnPointTypeId = attachedGameWorldSpawnPointTypeId;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof GameWorldCellEntity)) {
			return false;
		}

		GameWorldCellEntity other = (GameWorldCellEntity) obj;

		return Objects.equals(this.getId(), other.getId());
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).build();
	}

	public int compareTo(GameWorldCell obj) {
		if (obj == this) {
			return 0;
		}

		if (!(obj instanceof GameWorldCellEntity)) {
			return -1;
		}

		GameWorldCellEntity other = (GameWorldCellEntity) obj;

		if (this.getId() == null) {
			return 1;
		}

		if (other.getId() == null) {
			return -1;
		}

		return this.getId().compareTo(other.getId());
	}
}