package com.crazydumplings.backend.gameworldregistry.springdata.dao;

import java.util.List;

import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeClassEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Repository specification for the GameObjectTypeClass entity")
public interface GameObjectTypeClassesRepository {
    List<GameObjectTypeClassEntity> findAll();

    GameObjectTypeClassEntity findOneById(Long id);

    GameObjectTypeClassEntity findOneByName(String name);

    List<GameObjectTypeClassEntity> findAllByAnyTextFieldContaining(String content);

    List<GameObjectTypeClassEntity> findAllByExample(String name);

    GameObjectTypeClassEntity save(GameObjectTypeClassEntity gameObjectTypeClass);

    void delete(GameObjectTypeClassEntity gameObjectTypeClass);
}