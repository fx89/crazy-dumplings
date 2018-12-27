package com.crazydumplings.backend.gameworldregistry.springdata.dao;

import java.util.List;

import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameClientTypeEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeRepresentationEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Repository specification for the GameObjectTypeRepresentation entity")
public interface GameObjectTypeRepresentationsRepository {
    List<GameObjectTypeRepresentationEntity> findAll();

    GameObjectTypeRepresentationEntity findOneById(Long id);

    List<GameObjectTypeRepresentationEntity> findAllByGameObjectType(GameObjectTypeEntity gameObjectType);

    List<GameObjectTypeRepresentationEntity> findAllByGameClientType(GameClientTypeEntity gameClientType);

    List<GameObjectTypeRepresentationEntity> findAllByAnyTextFieldContaining(String content);

    List<GameObjectTypeRepresentationEntity> findAllByExample(GameObjectTypeEntity gameObjectType, GameClientTypeEntity gameClientType);

    GameObjectTypeRepresentationEntity save(GameObjectTypeRepresentationEntity gameObjectTypeRepresentation);

    void delete(GameObjectTypeRepresentationEntity gameObjectTypeRepresentation);
}