// package com.crazydumplings.gameregistry.gameassetmanager.dao.model;
package com.crazydumplings.backend.gameworldregistry.springdata.dao.model;

// import com.crazydumplings.gameregistry.gameassetmanager.model.GameObjectType;
import com.crazydumplings.gameworldregistry.model.GameObjectType;

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
@Table(name = "GAME_OBJECT_TYPE")
@Generated(value="fx.codegen.builder version 1.0.0")
public class GameObjectTypeEntity implements GameObjectType {
	@Id
	@Column(name = "ID_GAME_OBJECT_TYPE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public GameObjectTypeEntity() {
		
	}

	public GameObjectTypeEntity(Long id) {
		this.id = id;
	}

	private void copyAttributesFromEntity(GameObjectType gameObjectType) {
		this.ancestorGameObjectTypeId = gameObjectType.getAncestorGameObjectTypeId();
		this.gameAssetsRepositoryId = gameObjectType.getGameAssetsRepositoryId();
		this.gameObjectTypeClassId = gameObjectType.getGameObjectTypeClassId();
		this.uniqueName = gameObjectType.getUniqueName();
		this.description = gameObjectType.getDescription();
		this.isExperimental = gameObjectType.getIsExperimental();
	}

	public GameObjectTypeEntity(GameObjectTypeEntity entity, Long id) {
		this.copyAttributesFromEntity(entity);
		this.id = id;
	}

	public GameObjectTypeEntity(GameObjectTypeEntity entity) {
		this.copyAttributesFromEntity(entity);
	}

	public GameObjectTypeEntity(GameObjectType gameObjectType) {
		this.copyAttributesFromEntity(gameObjectType);
	}

	@Column(name = "ANCESTOR_GAME_OBJECT_TYPE_ID")
	private Long ancestorGameObjectTypeId;

	@Column(name = "GAME_ASSETS_REPOSITORY_ID")
	private Long gameAssetsRepositoryId;

	@Column(name = "GAME_OBJECT_TYPE_CLASS_ID")
	private Long gameObjectTypeClassId;

	@Column(name = "UNIQUE_NAME")
	@Size(max = 250)
	private String uniqueName;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "IS_EXPERIMENTAL")
	private Boolean isExperimental;

	public Long getAncestorGameObjectTypeId() {
		return ancestorGameObjectTypeId;
	}

	public void setAncestorGameObjectTypeId(Long ancestorGameObjectTypeId) {
		this.ancestorGameObjectTypeId = ancestorGameObjectTypeId;
	}

	public Long getGameAssetsRepositoryId() {
		return gameAssetsRepositoryId;
	}

	public void setGameAssetsRepositoryId(Long gameAssetsRepositoryId) {
		this.gameAssetsRepositoryId = gameAssetsRepositoryId;
	}

	public Long getGameObjectTypeClassId() {
		return gameObjectTypeClassId;
	}

	public void setGameObjectTypeClassId(Long gameObjectTypeClassId) {
		this.gameObjectTypeClassId = gameObjectTypeClassId;
	}

	public String getUniqueName() {
		return uniqueName;
	}

	public void setUniqueName(String uniqueName) {
		this.uniqueName = uniqueName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsExperimental() {
		return isExperimental;
	}

	public void setIsExperimental(Boolean isExperimental) {
		this.isExperimental = isExperimental;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof GameObjectTypeEntity)) {
			return false;
		}

		GameObjectTypeEntity other = (GameObjectTypeEntity) obj;

		return Objects.equals(this.getId(), other.getId());
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).build();
	}

	public int compareTo(GameObjectType obj) {
		if (obj == this) {
			return 0;
		}

		if (!(obj instanceof GameObjectTypeEntity)) {
			return -1;
		}

		GameObjectTypeEntity other = (GameObjectTypeEntity) obj;

		if (this.getUniqueName() == null) {
			return 1;
		}

		if (other.getUniqueName() == null) {
			return -1;
		}

		return this.getUniqueName().compareTo(other.getUniqueName());
	}
}