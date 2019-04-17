// package com.crazydumplings.gameregistry.gameassetmanager.dao.model;
package com.crazydumplings.backend.gameworldregistry.springdata.dao.model;

// import com.crazydumplings.gameregistry.gameassetmanager.model.GameAssetsRepositoryOwner;
import com.crazydumplings.gameworldregistry.model.GameAssetsRepositoryOwner;

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
@Table(name = "GAME_ASSETS_REPOSITORY_OWNER")
@Generated(value="fx.codegen.builder version 1.0.0")
public class GameAssetsRepositoryOwnerEntity implements GameAssetsRepositoryOwner {
	@Id
	@Column(name = "ID_GAME_ASSETS_REPOSITORY_OWNER")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public GameAssetsRepositoryOwnerEntity() {
		
	}

	public GameAssetsRepositoryOwnerEntity(Long id) {
		this.id = id;
	}

	private void copyAttributesFromEntity(GameAssetsRepositoryOwner gameAssetsRepositoryOwner) {
		this.gameAssetsRepositoryId = gameAssetsRepositoryOwner.getGameAssetsRepositoryId();
		this.ownerUserId = gameAssetsRepositoryOwner.getOwnerUserId();
	}

	public GameAssetsRepositoryOwnerEntity(GameAssetsRepositoryOwnerEntity entity, Long id) {
		this.copyAttributesFromEntity(entity);
		this.id = id;
	}

	public GameAssetsRepositoryOwnerEntity(GameAssetsRepositoryOwnerEntity entity) {
		this.copyAttributesFromEntity(entity);
	}

	public GameAssetsRepositoryOwnerEntity(GameAssetsRepositoryOwner gameAssetsRepositoryOwner) {
		this.copyAttributesFromEntity(gameAssetsRepositoryOwner);
	}

	@Column(name = "GAME_ASSETS_REPOSITORY_ID")
	private Long gameAssetsRepositoryId;

	@Column(name = "OWNER_USER_ID")
	private Long ownerUserId;

	public Long getGameAssetsRepositoryId() {
		return gameAssetsRepositoryId;
	}

	public void setGameAssetsRepositoryId(Long gameAssetsRepositoryId) {
		this.gameAssetsRepositoryId = gameAssetsRepositoryId;
	}

	public Long getOwnerUserId() {
		return ownerUserId;
	}

	public void setOwnerUserId(Long ownerUserId) {
		this.ownerUserId = ownerUserId;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof GameAssetsRepositoryOwnerEntity)) {
			return false;
		}

		GameAssetsRepositoryOwnerEntity other = (GameAssetsRepositoryOwnerEntity) obj;

		return Objects.equals(this.getId(), other.getId());
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).build();
	}

	public int compareTo(GameAssetsRepositoryOwner obj) {
		if (obj == this) {
			return 0;
		}

		if (!(obj instanceof GameAssetsRepositoryOwnerEntity)) {
			return -1;
		}

		GameAssetsRepositoryOwnerEntity other = (GameAssetsRepositoryOwnerEntity) obj;

		if (this.getId() == null) {
			return 1;
		}

		if (other.getId() == null) {
			return -1;
		}

		return this.getId().compareTo(other.getId());
	}
}