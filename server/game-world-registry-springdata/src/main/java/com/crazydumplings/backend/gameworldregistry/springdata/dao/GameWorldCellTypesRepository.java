package com.crazydumplings.backend.gameworldregistry.springdata.dao;

import java.util.List;

import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameWorldCellTypeEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Repository specification for the GameWorldCellType entity")
public interface GameWorldCellTypesRepository {
    List<GameWorldCellTypeEntity> findAll();

    GameWorldCellTypeEntity findOneById(Long id);

    GameWorldCellTypeEntity findOneByUniqueName(String uniqueName);

    List<GameWorldCellTypeEntity> findAllByGameObjectType(GameObjectTypeEntity gameObjectType);

    List<GameWorldCellTypeEntity> findAllByAnyTextFieldContaining(String content);

    List<GameWorldCellTypeEntity> findAllByExample(String uniqueName, GameObjectTypeEntity gameObjectType);

    GameWorldCellTypeEntity save(GameWorldCellTypeEntity gameWorldCellType);

    void delete(GameWorldCellTypeEntity gameWorldCellType);
}