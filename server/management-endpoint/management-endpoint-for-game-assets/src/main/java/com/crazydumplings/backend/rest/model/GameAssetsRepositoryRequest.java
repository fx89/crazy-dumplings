package com.crazydumplings.backend.rest.model;

import com.crazydumplings.gameworldregistry.model.GameAssetsRepository;

public class GameAssetsRepositoryRequest implements GameAssetsRepository {
	private Long id;

	private String uniqueName;

	private String description;

	private String pictureHash;

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int compareTo(GameAssetsRepository o) {
		return this.id == null ? -1 : this.id.compareTo(o.getId());
	}

	@Override
	public String getUniqueName() {
		return uniqueName;
	}

	@Override
	public void setUniqueName(String uniqueName) {
		this.uniqueName = uniqueName;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String getPictureHash() {
		return pictureHash;
	}

	@Override
	public void setPictureHash(String pictureHash) {
		this.pictureHash = pictureHash;
	}

}
