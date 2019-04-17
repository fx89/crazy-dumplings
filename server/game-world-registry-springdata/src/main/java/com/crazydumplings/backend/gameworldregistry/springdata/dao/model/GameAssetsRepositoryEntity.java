// package com.crazydumplings.gameregistry.gameassetmanager.dao.model;
package com.crazydumplings.backend.gameworldregistry.springdata.dao.model;

// import com.crazydumplings.gameregistry.gameassetmanager.model.GameAssetsRepository;
import com.crazydumplings.gameworldregistry.model.GameAssetsRepository;

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
@Table(name = "GAME_ASSETS_REPOSITORY")
@Generated(value="fx.codegen.builder version 1.0.0")
public class GameAssetsRepositoryEntity implements GameAssetsRepository {
	@Id
	@Column(name = "ID_GAME_ASSETS_REPOSITORY")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public GameAssetsRepositoryEntity() {
		
	}

	public GameAssetsRepositoryEntity(Long id) {
		this.id = id;
	}

	private void copyAttributesFromEntity(GameAssetsRepository gameAssetsRepository) {
		this.uniqueName = gameAssetsRepository.getUniqueName();
		this.description = gameAssetsRepository.getDescription();
		this.pictureHash = gameAssetsRepository.getPictureHash();
	}

	public GameAssetsRepositoryEntity(GameAssetsRepositoryEntity entity, Long id) {
		this.copyAttributesFromEntity(entity);
		this.id = id;
	}

	public GameAssetsRepositoryEntity(GameAssetsRepositoryEntity entity) {
		this.copyAttributesFromEntity(entity);
	}

	public GameAssetsRepositoryEntity(GameAssetsRepository gameAssetsRepository) {
		this.copyAttributesFromEntity(gameAssetsRepository);
	}

	@Column(name = "UNIQUE_NAME")
	@Size(max = 250)
	private String uniqueName;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "PICTURE_HASH")
	private String pictureHash;

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

		if (!(obj instanceof GameAssetsRepositoryEntity)) {
			return false;
		}

		GameAssetsRepositoryEntity other = (GameAssetsRepositoryEntity) obj;

		return Objects.equals(this.getId(), other.getId());
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).build();
	}

	public int compareTo(GameAssetsRepository obj) {
		if (obj == this) {
			return 0;
		}

		if (!(obj instanceof GameAssetsRepositoryEntity)) {
			return -1;
		}

		GameAssetsRepositoryEntity other = (GameAssetsRepositoryEntity) obj;

		if (this.getUniqueName() == null) {
			return 1;
		}

		if (other.getUniqueName() == null) {
			return -1;
		}

		return this.getUniqueName().compareTo(other.getUniqueName());
	}
}