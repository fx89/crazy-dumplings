package com.crazydumplings.backend.gameworldregistry.springdata.dao;

import java.util.List;

import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.ActionEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeStateEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeStateTransitionEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Repository specification for the GameObjectTypeStateTransition entity")
public interface GameObjectTypeStateTransitionsRepository {
    List<GameObjectTypeStateTransitionEntity> findAll();

    GameObjectTypeStateTransitionEntity findOneById(Long id);

    List<GameObjectTypeStateTransitionEntity> findAllBySourceGameObjectTypeState(GameObjectTypeStateEntity sourceGameObjectTypeState);

    List<GameObjectTypeStateTransitionEntity> findAllByTargetGameObjectTypeState(GameObjectTypeStateEntity targetGameObjectTypeState);

    List<GameObjectTypeStateTransitionEntity> findAllByTriggerAction(ActionEntity triggerAction);

    List<GameObjectTypeStateTransitionEntity> findAllByAnyTextFieldContaining(String content);

    List<GameObjectTypeStateTransitionEntity> findAllByExample(GameObjectTypeStateEntity sourceGameObjectTypeState,
            GameObjectTypeStateEntity targetGameObjectTypeState, Boolean isAutomatic, ActionEntity triggerAction);

    GameObjectTypeStateTransitionEntity save(GameObjectTypeStateTransitionEntity gameObjectTypeStateTransition);

    void delete(GameObjectTypeStateTransitionEntity gameObjectTypeStateTransition);
}