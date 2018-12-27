package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameObjectTypeStateTransitionsRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.ActionEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeStateEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeStateTransitionEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Spring/JPA implementation of the specification of repository for the GameObjectTypeStateTransition entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaGameObjectTypeStateTransitionsRepository
        extends GameObjectTypeStateTransitionsRepository, CrudRepository<GameObjectTypeStateTransitionEntity, Long> {
    @Query("select distinct gameObjectTypeStateTransition from GameObjectTypeStateTransitionEntity gameObjectTypeStateTransition left join fetch gameObjectTypeStateTransition.sourceGameObjectTypeState left join fetch gameObjectTypeStateTransition.targetGameObjectTypeState left join fetch gameObjectTypeStateTransition.triggerAction")
    List<GameObjectTypeStateTransitionEntity> findAll();

    @Query("select distinct gameObjectTypeStateTransition from GameObjectTypeStateTransitionEntity gameObjectTypeStateTransition left join fetch gameObjectTypeStateTransition.sourceGameObjectTypeState left join fetch gameObjectTypeStateTransition.targetGameObjectTypeState left join fetch gameObjectTypeStateTransition.triggerAction where gameObjectTypeStateTransition.id = ?1")
    GameObjectTypeStateTransitionEntity findOneById(Long id);

    @Query("select distinct gameObjectTypeStateTransition from GameObjectTypeStateTransitionEntity gameObjectTypeStateTransition left join fetch gameObjectTypeStateTransition.sourceGameObjectTypeState left join fetch gameObjectTypeStateTransition.targetGameObjectTypeState left join fetch gameObjectTypeStateTransition.triggerAction where gameObjectTypeStateTransition.sourceGameObjectTypeState = ?1")
    List<GameObjectTypeStateTransitionEntity> findAllBySourceGameObjectTypeState(GameObjectTypeStateEntity sourceGameObjectTypeState);

    @Query("select distinct gameObjectTypeStateTransition from GameObjectTypeStateTransitionEntity gameObjectTypeStateTransition left join fetch gameObjectTypeStateTransition.sourceGameObjectTypeState left join fetch gameObjectTypeStateTransition.targetGameObjectTypeState left join fetch gameObjectTypeStateTransition.triggerAction where gameObjectTypeStateTransition.targetGameObjectTypeState = ?1")
    List<GameObjectTypeStateTransitionEntity> findAllByTargetGameObjectTypeState(GameObjectTypeStateEntity targetGameObjectTypeState);

    @Query("select distinct gameObjectTypeStateTransition from GameObjectTypeStateTransitionEntity gameObjectTypeStateTransition left join fetch gameObjectTypeStateTransition.sourceGameObjectTypeState left join fetch gameObjectTypeStateTransition.targetGameObjectTypeState left join fetch gameObjectTypeStateTransition.triggerAction where gameObjectTypeStateTransition.triggerAction = ?1")
    List<GameObjectTypeStateTransitionEntity> findAllByTriggerAction(ActionEntity triggerAction);

    @Query("select distinct gameObjectTypeStateTransition from GameObjectTypeStateTransitionEntity gameObjectTypeStateTransition left join fetch gameObjectTypeStateTransition.sourceGameObjectTypeState left join fetch gameObjectTypeStateTransition.targetGameObjectTypeState left join fetch gameObjectTypeStateTransition.triggerAction "
            + "where " + "gameObjectTypeStateTransition.sourceGameObjectTypeState.name like '%' + ?1 + '%' or "
            + "gameObjectTypeStateTransition.targetGameObjectTypeState.name like '%' + ?1 + '%' or "
            + "gameObjectTypeStateTransition.triggerAction.uniqueName like '%' + ?1 + '%' ")
    List<GameObjectTypeStateTransitionEntity> findAllByAnyTextFieldContaining(String content);

    @Query("select distinct gameObjectTypeStateTransition from GameObjectTypeStateTransitionEntity gameObjectTypeStateTransition left join fetch gameObjectTypeStateTransition.sourceGameObjectTypeState left join fetch gameObjectTypeStateTransition.targetGameObjectTypeState left join fetch gameObjectTypeStateTransition.triggerAction "
            + "where "
            + "(:sourceGameObjectTypeState is null or gameObjectTypeStateTransition.sourceGameObjectTypeState = :sourceGameObjectTypeState) and"
            + "(:targetGameObjectTypeState is null or gameObjectTypeStateTransition.targetGameObjectTypeState = :targetGameObjectTypeState) and"
            + "(:isAutomatic is null or gameObjectTypeStateTransition.isAutomatic = :isAutomatic) and"
            + "(:triggerAction is null or gameObjectTypeStateTransition.triggerAction = :triggerAction)")
    List<GameObjectTypeStateTransitionEntity> findAllByExample(GameObjectTypeStateEntity sourceGameObjectTypeState,
            GameObjectTypeStateEntity targetGameObjectTypeState, Boolean isAutomatic, ActionEntity triggerAction);
}