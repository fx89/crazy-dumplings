package com.crazydumplings.backend.rest.model;

public class BulkAssetRequestItem<T> {
	public Long assetId;
	public T assetRequest;

	public Long getAssetId() {
		return assetId;
	}

	public void setAssetId(Long assetId) {
		this.assetId = assetId;
	}

	public T getAssetRequest() {
		return assetRequest;
	}

	public void setAssetRequest(T assetRequest) {
		this.assetRequest = assetRequest;
	}

}
