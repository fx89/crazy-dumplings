// package com.crazydumplings.gameregistry.gameassetmanager.dao.model;
package com.crazydumplings.backend.gameworldregistry.springdata.dao.model;

// import com.crazydumplings.gameregistry.gameassetmanager.model.GameAssetsRepositoryPicture;
import com.crazydumplings.gameworldregistry.model.GameAssetsRepositoryPicture;

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
@Table(name = "GAME_ASSETS_REPOSITORY_PICTURE")
@Generated(value="fx.codegen.builder version 1.0.0")
public class GameAssetsRepositoryPictureEntity implements GameAssetsRepositoryPicture {
	@Id
	@Column(name = "ID_GAME_ASSETS_REPOSITORY_PICTURE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public GameAssetsRepositoryPictureEntity() {
		
	}

	public GameAssetsRepositoryPictureEntity(Long id) {
		this.id = id;
	}

	public GameAssetsRepositoryPictureEntity(GameAssetsRepositoryPictureEntity entity, Long id) {
		this.id = id;
		this.gameAssetsRepositoryId = entity.gameAssetsRepositoryId;
		this.pictureHash = entity.pictureHash;
	}

	@Column(name = "GAME_ASSETS_REPOSITORY_ID")
	private Long gameAssetsRepositoryId;

	@Column(name = "PICTURE_HASH")
	private String pictureHash;

	public Long getGameAssetsRepositoryId() {
		return gameAssetsRepositoryId;
	}

	public void setGameAssetsRepositoryId(Long gameAssetsRepositoryId) {
		this.gameAssetsRepositoryId = gameAssetsRepositoryId;
	}

	public String getPictureHash() {
		return pictureHash;
	}

	public void setPictureHash(String pictureHash) {
		this.pictureHash = pictureHash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof GameAssetsRepositoryPictureEntity)) {
			return false;
		}

		GameAssetsRepositoryPictureEntity other = (GameAssetsRepositoryPictureEntity) obj;

		return Objects.equals(this.getId(), other.getId());
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).build();
	}

	public int compareTo(GameAssetsRepositoryPicture obj) {
		if (obj == this) {
			return 0;
		}

		if (!(obj instanceof GameAssetsRepositoryPictureEntity)) {
			return -1;
		}

		GameAssetsRepositoryPictureEntity other = (GameAssetsRepositoryPictureEntity) obj;

		if (this.getId() == null) {
			return 1;
		}

		if (other.getId() == null) {
			return -1;
		}

		return this.getId().compareTo(other.getId());
	}
}