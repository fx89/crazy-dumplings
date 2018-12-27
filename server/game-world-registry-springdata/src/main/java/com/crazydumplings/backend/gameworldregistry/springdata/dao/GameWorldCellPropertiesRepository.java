package com.crazydumplings.backend.gameworldregistry.springdata.dao;

import java.util.List;

import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypePropertyEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameWorldCellEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameWorldCellPropertyEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Repository specification for the GameWorldCellProperty entity")
public interface GameWorldCellPropertiesRepository {
    List<GameWorldCellPropertyEntity> findAll();

    GameWorldCellPropertyEntity findOneById(Long id);

    List<GameWorldCellPropertyEntity> findAllByGameWorldCell(GameWorldCellEntity gameWorldCell);

    List<GameWorldCellPropertyEntity> findAllByGameObjectTypeProperty(GameObjectTypePropertyEntity gameObjectTypeProperty);

    List<GameWorldCellPropertyEntity> findAllByAnyTextFieldContaining(String content);

    List<GameWorldCellPropertyEntity> findAllByExample(GameWorldCellEntity gameWorldCell, GameObjectTypePropertyEntity gameObjectTypeProperty,
            Double propertyActualValue);

    GameWorldCellPropertyEntity save(GameWorldCellPropertyEntity gameWorldCellProperty);

    void delete(GameWorldCellPropertyEntity gameWorldCellProperty);
}