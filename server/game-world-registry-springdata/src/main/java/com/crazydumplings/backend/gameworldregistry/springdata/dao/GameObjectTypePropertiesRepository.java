package com.crazydumplings.backend.gameworldregistry.springdata.dao;

import java.util.List;

import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypePropertyEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Repository specification for the GameObjectTypeProperty entity")
public interface GameObjectTypePropertiesRepository {
    List<GameObjectTypePropertyEntity> findAll();

    GameObjectTypePropertyEntity findOneById(Long id);

    List<GameObjectTypePropertyEntity> findAllByGameObjectType(GameObjectTypeEntity gameObjectType);

    List<GameObjectTypePropertyEntity> findAllByGameObjectTypeAndIds(GameObjectTypeEntity gameObjectType, List<Long> ids);

    GameObjectTypePropertyEntity findOneByPropertyName(String propertyName);

    List<GameObjectTypePropertyEntity> findAllByAnyTextFieldContaining(String content);

    List<GameObjectTypePropertyEntity> findAllByExample(GameObjectTypeEntity gameObjectType, String propertyName, Double propertyDefaultValue,
            Double propertyMinValue, Double propertyMaxValue);

    GameObjectTypePropertyEntity save(GameObjectTypePropertyEntity gameObjectTypeProperty);

    Iterable<GameObjectTypePropertyEntity> bulkSave(Iterable<GameObjectTypePropertyEntity> gameObjectTypeProperties);

    void delete(GameObjectTypePropertyEntity gameObjectTypeProperty);

    void bulkDelete(List<Long> gameObjectTypePropertyIds);

    void deleteByGameObjectType(GameObjectTypeEntity gameObjectType);
}