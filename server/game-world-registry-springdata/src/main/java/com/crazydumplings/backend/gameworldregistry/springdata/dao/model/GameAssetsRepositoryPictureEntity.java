package com.crazydumplings.backend.gameworldregistry.springdata.dao.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.crazydumplings.gameworldregistry.model.GameAssetsRepository;
import com.crazydumplings.gameworldregistry.model.GameAssetsRepositoryPicture;

@Entity
@Table(name = "GAME_ASSETS_REPOSITORY_PICTURE")
public class GameAssetsRepositoryPictureEntity implements GameAssetsRepositoryPicture {
	@Id
	@Column(name = "ID_GAME_ASSETS_REPOSITORY_PICTURE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "GAME_ASSETS_REPOSITORY_ID")
	private GameAssetsRepositoryEntity gameAssetsRepository;

	@Column(name = "PICTURE")
	private String hash;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public GameAssetsRepository getGameAssetsRepository() {
		return gameAssetsRepository;
	}

	@Override
	public void setGameAssetsRepository(GameAssetsRepository gameAssetsRepository) {
		this.gameAssetsRepository = (GameAssetsRepositoryEntity) gameAssetsRepository;
	}

	@Override
	public String getHash() {
		return hash;
	}

	@Override
	public void setHash(String hash) {
		this.hash = hash;
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
}
