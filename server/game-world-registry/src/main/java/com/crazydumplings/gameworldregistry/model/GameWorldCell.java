package com.crazydumplings.gameworldregistry.model;



import javax.annotation.Generated;


import com.crazydumplings.gameworldregistry.model.generic.ParentableGameAsset;

@Generated(value="fx.codegen.builder version 1.0.0")
public interface GameWorldCell extends ParentableGameAsset, Comparable<GameWorldCell> {

	Long getGameWorldId();

	void setGameWorldId(Long gameWorldId);

	Long getGameWorldCellTypeId();

	void setGameWorldCellTypeId(Long gameWorldCellTypeId);

	Integer getXIndex();

	void setXIndex(Integer xIndex);

	Integer getYIndex();

	void setYIndex(Integer yIndex);

	Long getAttachedGameWorldSpawnPointTypeId();

	void setAttachedGameWorldSpawnPointTypeId(Long attachedGameWorldSpawnPointTypeId);


	default Long getParentId() {
		return getGameWorldId();
	}

	default void setParentId(Long parentId) {
		setGameWorldId(parentId);
	}

}