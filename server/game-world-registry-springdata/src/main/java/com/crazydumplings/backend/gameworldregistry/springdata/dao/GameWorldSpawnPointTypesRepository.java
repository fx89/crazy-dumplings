package com.crazydumplings.backend.gameworldregistry.springdata.dao;

import java.util.List;

import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameWorldSpawnPointTypeEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Repository specification for the GameWorldSpawnPointType entity")
public interface GameWorldSpawnPointTypesRepository {
    List<GameWorldSpawnPointTypeEntity> findAll();

    GameWorldSpawnPointTypeEntity findOneById(Long id);

    List<GameWorldSpawnPointTypeEntity> findAllBySpawnPointGameObjectType(GameObjectTypeEntity spawnPointGameObjectType);

    List<GameWorldSpawnPointTypeEntity> findAllBySpawnedGameObjectType(GameObjectTypeEntity spawnedGameObjectType);

    List<GameWorldSpawnPointTypeEntity> findAllByAnyTextFieldContaining(String content);

    List<GameWorldSpawnPointTypeEntity> findAllByExample(GameObjectTypeEntity spawnPointGameObjectType,
            GameObjectTypeEntity spawnedGameObjectType);

    GameWorldSpawnPointTypeEntity save(GameWorldSpawnPointTypeEntity gameWorldSpawnPointType);

    void delete(GameWorldSpawnPointTypeEntity gameWorldSpawnPointType);
}