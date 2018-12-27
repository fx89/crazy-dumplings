package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface GameWorldCell extends Serializable, Comparable<GameWorldCell> {
    public Long getId();

    public GameWorld getGameWorld();

    public void setGameWorld(GameWorld gameWorld);

    public GameWorldCellType getGameWorldCellType();

    public void setGameWorldCellType(GameWorldCellType gameWorldCellType);

    public Integer getXIndex();

    public void setXIndex(Integer xIndex);

    public Integer getYIndex();

    public void setYIndex(Integer yIndex);

    public GameWorldSpawnPointType getAttachedGameWorldSpawnPointType();

    public void setAttachedGameWorldSpawnPointType(GameWorldSpawnPointType attachedGameWorldSpawnPointType);

}