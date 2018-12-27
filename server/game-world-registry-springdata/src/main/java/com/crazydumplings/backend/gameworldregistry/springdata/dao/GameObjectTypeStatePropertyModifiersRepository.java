package com.crazydumplings.backend.gameworldregistry.springdata.dao;

import java.util.List;

import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypePropertyEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeStateEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeStatePropertyModifierEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Repository specification for the GameObjectTypeStatePropertyModifier entity")
public interface GameObjectTypeStatePropertyModifiersRepository {
    List<GameObjectTypeStatePropertyModifierEntity> findAll();

    GameObjectTypeStatePropertyModifierEntity findOneById(Long id);

    List<GameObjectTypeStatePropertyModifierEntity> findAllByGameObjectTypeState(GameObjectTypeStateEntity gameObjectTypeState);

    List<GameObjectTypeStatePropertyModifierEntity> findAllByGameObjectTypeProperty(GameObjectTypePropertyEntity gameObjectTypeProperty);

    List<GameObjectTypeStatePropertyModifierEntity> findAllByAnyTextFieldContaining(String content);

    List<GameObjectTypeStatePropertyModifierEntity> findAllByExample(GameObjectTypeStateEntity gameObjectTypeState,
            GameObjectTypePropertyEntity gameObjectTypeProperty, Double propertyActualValue);

    GameObjectTypeStatePropertyModifierEntity save(GameObjectTypeStatePropertyModifierEntity gameObjectTypeStatePropertyModifier);

    void delete(GameObjectTypeStatePropertyModifierEntity gameObjectTypeStatePropertyModifier);
}