package com.crazydumplings.backend.rest.model;

public class GameAssetsRepositoryRequest {
    public String uniqueName;
    public String description;
    public String pictureHash;

    public String getUniqueName() {
        return uniqueName;
    }

    public void setUniqueName(String uniqueNamel) {
        this.uniqueName = uniqueNamel;
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
