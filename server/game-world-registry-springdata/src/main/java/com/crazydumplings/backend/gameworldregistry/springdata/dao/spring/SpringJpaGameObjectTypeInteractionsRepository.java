package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameObjectTypeInteractionsRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeInteractionEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Spring/JPA implementation of the specification of repository for the GameObjectTypeInteraction entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaGameObjectTypeInteractionsRepository
        extends GameObjectTypeInteractionsRepository, CrudRepository<GameObjectTypeInteractionEntity, Long> {
    @Query("select distinct gameObjectTypeInteraction from GameObjectTypeInteractionEntity gameObjectTypeInteraction left join fetch gameObjectTypeInteraction.donatingGameObjectType left join fetch gameObjectTypeInteraction.receivingGameObjectType")
    List<GameObjectTypeInteractionEntity> findAll();

    @Query("select distinct gameObjectTypeInteraction from GameObjectTypeInteractionEntity gameObjectTypeInteraction left join fetch gameObjectTypeInteraction.donatingGameObjectType left join fetch gameObjectTypeInteraction.receivingGameObjectType where gameObjectTypeInteraction.id = ?1")
    GameObjectTypeInteractionEntity findOneById(Long id);

    @Query("select distinct gameObjectTypeInteraction from GameObjectTypeInteractionEntity gameObjectTypeInteraction left join fetch gameObjectTypeInteraction.donatingGameObjectType left join fetch gameObjectTypeInteraction.receivingGameObjectType where gameObjectTypeInteraction.donatingGameObjectType = ?1")
    List<GameObjectTypeInteractionEntity> findAllByDonatingGameObjectType(GameObjectTypeEntity donatingGameObjectType);

    @Query("select distinct gameObjectTypeInteraction from GameObjectTypeInteractionEntity gameObjectTypeInteraction left join fetch gameObjectTypeInteraction.donatingGameObjectType left join fetch gameObjectTypeInteraction.receivingGameObjectType where gameObjectTypeInteraction.receivingGameObjectType = ?1")
    List<GameObjectTypeInteractionEntity> findAllByReceivingGameObjectType(GameObjectTypeEntity receivingGameObjectType);

    @Query("select distinct gameObjectTypeInteraction from GameObjectTypeInteractionEntity gameObjectTypeInteraction left join fetch gameObjectTypeInteraction.donatingGameObjectType left join fetch gameObjectTypeInteraction.receivingGameObjectType "
            + "where " + "gameObjectTypeInteraction.donatingGameObjectType.uniqueName like '%' + ?1 + '%' or "
            + "gameObjectTypeInteraction.receivingGameObjectType.uniqueName like '%' + ?1 + '%' ")
    List<GameObjectTypeInteractionEntity> findAllByAnyTextFieldContaining(String content);

    @Query("select distinct gameObjectTypeInteraction from GameObjectTypeInteractionEntity gameObjectTypeInteraction left join fetch gameObjectTypeInteraction.donatingGameObjectType left join fetch gameObjectTypeInteraction.receivingGameObjectType "
            + "where " + "(:donatingGameObjectType is null or gameObjectTypeInteraction.donatingGameObjectType = :donatingGameObjectType) and"
            + "(:receivingGameObjectType is null or gameObjectTypeInteraction.receivingGameObjectType = :receivingGameObjectType) and"
            + "(:radius is null or gameObjectTypeInteraction.radius = :radius)")
    List<GameObjectTypeInteractionEntity> findAllByExample(GameObjectTypeEntity donatingGameObjectType,
            GameObjectTypeEntity receivingGameObjectType, Integer radius);
}