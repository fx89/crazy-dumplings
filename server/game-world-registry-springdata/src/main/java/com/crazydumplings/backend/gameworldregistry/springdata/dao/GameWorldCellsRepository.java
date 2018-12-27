package com.crazydumplings.backend.gameworldregistry.springdata.dao;

import java.util.List;

import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameWorldCellEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameWorldCellTypeEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameWorldEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameWorldSpawnPointTypeEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Repository specification for the GameWorldCell entity")
public interface GameWorldCellsRepository {
    List<GameWorldCellEntity> findAll();

    GameWorldCellEntity findOneById(Long id);

    List<GameWorldCellEntity> findAllByGameWorld(GameWorldEntity gameWorld);

    List<GameWorldCellEntity> findAllByGameWorldCellType(GameWorldCellTypeEntity gameWorldCellType);

    List<GameWorldCellEntity> findAllByAttachedGameWorldSpawnPointType(GameWorldSpawnPointTypeEntity attachedGameWorldSpawnPointType);

    // List<GameWorldCell> findAllByXIndexLessThanEqualAndYIndexGreaterThanEqual(Integer targetSmallnumber, Integer targetSmallnumber);

    List<GameWorldCellEntity> findAllHavingTargetSmallnumberBetweenXIndexAndYIndex(Integer targetSmallnumber);

    List<GameWorldCellEntity> findAllByAnyTextFieldContaining(String content);

    List<GameWorldCellEntity> findAllByExample(GameWorldEntity gameWorld, GameWorldCellTypeEntity gameWorldCellType, Integer xIndex,
            Integer yIndex, GameWorldSpawnPointTypeEntity attachedGameWorldSpawnPointType);

    GameWorldCellEntity save(GameWorldCellEntity gameWorldCell);

    void delete(GameWorldCellEntity gameWorldCell);
}