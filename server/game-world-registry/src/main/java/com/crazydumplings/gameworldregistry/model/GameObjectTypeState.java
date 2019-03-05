package com.crazydumplings.gameworldregistry.model;

import com.crazydumplings.gameworldregistry.model.generic.IdentifiableGameAsset;
import com.crazydumplings.gameworldregistry.model.generic.ParentableGameAsset;

public interface GameObjectTypeState extends ParentableGameAsset, Comparable<GameObjectTypeState> {
 // TODO: Turn parent references into ID's - we don't want to carry redundant game object type descriptions and stuff through all the layers
	GameObjectType getGameObjectType();

	void setGameObjectType(GameObjectType gameObjectType);

	String getName();

	void setName(String name);

	default IdentifiableGameAsset getParent() {
		return getGameObjectType();
	}

	default void setParent(IdentifiableGameAsset parent) {
		setGameObjectType((GameObjectType) parent);
	}

}