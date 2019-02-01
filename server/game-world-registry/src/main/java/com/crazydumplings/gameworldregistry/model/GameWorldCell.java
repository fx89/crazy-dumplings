package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface GameWorldCell extends Serializable, Comparable<GameWorldCell> {
    Long getId();

    GameWorld getGameWorld();

    void setGameWorld(GameWorld gameWorld);

    GameWorldCellType getGameWorldCellType();

    void setGameWorldCellType(GameWorldCellType gameWorldCellType);

    Integer getXIndex();

    void setXIndex(Integer xIndex);

    Integer getYIndex();

    void setYIndex(Integer yIndex);

    GameWorldSpawnPointType getAttachedGameWorldSpawnPointType();

    void setAttachedGameWorldSpawnPointType(GameWorldSpawnPointType attachedGameWorldSpawnPointType);

}