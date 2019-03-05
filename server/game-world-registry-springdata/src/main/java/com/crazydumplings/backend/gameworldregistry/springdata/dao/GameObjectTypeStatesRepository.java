package com.crazydumplings.backend.gameworldregistry.springdata.dao;

import java.util.List;

import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeStateEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Repository specification for the GameObjectTypeState entity")
public interface GameObjectTypeStatesRepository {
    List<GameObjectTypeStateEntity> findAll();

    GameObjectTypeStateEntity findOneById(Long id);

    List<GameObjectTypeStateEntity> findAllByGameObjectType(GameObjectTypeEntity gameObjectType);

    GameObjectTypeStateEntity findOneByName(String name);

    List<GameObjectTypeStateEntity> findAllByAnyTextFieldContaining(String content);

    List<GameObjectTypeStateEntity> findAllByExample(GameObjectTypeEntity gameObjectType, String name);

    GameObjectTypeStateEntity save(GameObjectTypeStateEntity gameObjectTypeState);

    void delete(GameObjectTypeStateEntity gameObjectTypeState);

    void bulkDelete(List<Long> gameObjectTypeStateIds);

    List<GameObjectTypeStateEntity> findAllByGameObjectTypeAndIds(GameObjectTypeEntity gameObjectType, List<Long> ids);
}