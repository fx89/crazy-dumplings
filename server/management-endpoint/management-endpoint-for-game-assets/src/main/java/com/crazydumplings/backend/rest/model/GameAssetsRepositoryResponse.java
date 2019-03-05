package com.crazydumplings.backend.rest.model;

import java.io.Serializable;

public class GameAssetsRepositoryResponse implements Serializable {
	Long id;
	String uniqueName;
	String description;
	String pictureHash;

	public GameAssetsRepositoryResponse(Long id, String uniqueName, String description, String pictureHash) {
		this.id = id;
		this.uniqueName = uniqueName;
		this.description = description;
		this.pictureHash = pictureHash;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPictureHash() {
		return pictureHash;
	}

	public void setPictureHash(String pictureHash) {
		this.pictureHash = pictureHash;
	}

}
