package com.crazydumplings.backend.gameworldregistry.springdata.dao;

import java.util.List;

import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeInteractionEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Repository specification for the GameObjectTypeInteraction entity")
public interface GameObjectTypeInteractionsRepository {
    List<GameObjectTypeInteractionEntity> findAll();

    GameObjectTypeInteractionEntity findOneById(Long id);

    List<GameObjectTypeInteractionEntity> findAllByDonatingGameObjectType(GameObjectTypeEntity donatingGameObjectType);

    List<GameObjectTypeInteractionEntity> findAllByReceivingGameObjectType(GameObjectTypeEntity receivingGameObjectType);

    List<GameObjectTypeInteractionEntity> findAllByAnyTextFieldContaining(String content);

    List<GameObjectTypeInteractionEntity> findAllByExample(GameObjectTypeEntity donatingGameObjectType,
            GameObjectTypeEntity receivingGameObjectType, Integer radius);

    GameObjectTypeInteractionEntity save(GameObjectTypeInteractionEntity gameObjectTypeInteraction);

    void delete(GameObjectTypeInteractionEntity gameObjectTypeInteraction);
}