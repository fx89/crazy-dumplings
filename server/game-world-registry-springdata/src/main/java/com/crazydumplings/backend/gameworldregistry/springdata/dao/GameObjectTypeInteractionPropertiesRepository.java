package com.crazydumplings.backend.gameworldregistry.springdata.dao;

import java.util.List;

import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeInteractionEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeInteractionPropertyEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypePropertyEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Repository specification for the GameObjectTypeInteractionProperty entity")
public interface GameObjectTypeInteractionPropertiesRepository {
    List<GameObjectTypeInteractionPropertyEntity> findAll();

    GameObjectTypeInteractionPropertyEntity findOneById(Long id);

    List<GameObjectTypeInteractionPropertyEntity> findAllByGameObjectTypeInteraction(GameObjectTypeInteractionEntity gameObjectTypeInteraction);

    List<GameObjectTypeInteractionPropertyEntity> findAllByDonatingGameObjectTypeProperty(
            GameObjectTypePropertyEntity donatingGameObjectTypeProperty);

    List<GameObjectTypeInteractionPropertyEntity> findAllByReceivingGameObjectTypeProperty(
            GameObjectTypePropertyEntity receivingGameObjectTypeProperty);

    List<GameObjectTypeInteractionPropertyEntity> findAllByOverflowGameObjectTypeProperty(
            GameObjectTypePropertyEntity overflowGameObjectTypeProperty);

    List<GameObjectTypeInteractionPropertyEntity> findAllByAnyTextFieldContaining(String content);

    List<GameObjectTypeInteractionPropertyEntity> findAllByExample(GameObjectTypeInteractionEntity gameObjectTypeInteraction,
            GameObjectTypePropertyEntity donatingGameObjectTypeProperty, GameObjectTypePropertyEntity receivingGameObjectTypeProperty,
            GameObjectTypePropertyEntity overflowGameObjectTypeProperty, Boolean isIncremental, Boolean isInverted);

    GameObjectTypeInteractionPropertyEntity save(GameObjectTypeInteractionPropertyEntity gameObjectTypeInteractionProperty);

    void delete(GameObjectTypeInteractionPropertyEntity gameObjectTypeInteractionProperty);
}