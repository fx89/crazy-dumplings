package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameObjectTypeInteractionPropertiesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeInteractionEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeInteractionPropertyEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypePropertyEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Spring/JPA implementation of the specification of repository for the GameObjectTypeInteractionProperty entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaGameObjectTypeInteractionPropertiesRepository
        extends GameObjectTypeInteractionPropertiesRepository, CrudRepository<GameObjectTypeInteractionPropertyEntity, Long> {
    @Query("select distinct gameObjectTypeInteractionProperty from GameObjectTypeInteractionPropertyEntity gameObjectTypeInteractionProperty left join fetch gameObjectTypeInteractionProperty.gameObjectTypeInteraction left join fetch gameObjectTypeInteractionProperty.donatingGameObjectTypeProperty left join fetch gameObjectTypeInteractionProperty.receivingGameObjectTypeProperty left join fetch gameObjectTypeInteractionProperty.overflowGameObjectTypeProperty")
    List<GameObjectTypeInteractionPropertyEntity> findAll();

    @Query("select distinct gameObjectTypeInteractionProperty from GameObjectTypeInteractionPropertyEntity gameObjectTypeInteractionProperty left join fetch gameObjectTypeInteractionProperty.gameObjectTypeInteraction left join fetch gameObjectTypeInteractionProperty.donatingGameObjectTypeProperty left join fetch gameObjectTypeInteractionProperty.receivingGameObjectTypeProperty left join fetch gameObjectTypeInteractionProperty.overflowGameObjectTypeProperty where gameObjectTypeInteractionProperty.id = ?1")
    GameObjectTypeInteractionPropertyEntity findOneById(Long id);

    @Query("select distinct gameObjectTypeInteractionProperty from GameObjectTypeInteractionPropertyEntity gameObjectTypeInteractionProperty left join fetch gameObjectTypeInteractionProperty.gameObjectTypeInteraction left join fetch gameObjectTypeInteractionProperty.donatingGameObjectTypeProperty left join fetch gameObjectTypeInteractionProperty.receivingGameObjectTypeProperty left join fetch gameObjectTypeInteractionProperty.overflowGameObjectTypeProperty where gameObjectTypeInteractionProperty.gameObjectTypeInteraction = ?1")
    List<GameObjectTypeInteractionPropertyEntity> findAllByGameObjectTypeInteraction(GameObjectTypeInteractionEntity gameObjectTypeInteraction);

    @Query("select distinct gameObjectTypeInteractionProperty from GameObjectTypeInteractionPropertyEntity gameObjectTypeInteractionProperty left join fetch gameObjectTypeInteractionProperty.gameObjectTypeInteraction left join fetch gameObjectTypeInteractionProperty.donatingGameObjectTypeProperty left join fetch gameObjectTypeInteractionProperty.receivingGameObjectTypeProperty left join fetch gameObjectTypeInteractionProperty.overflowGameObjectTypeProperty where gameObjectTypeInteractionProperty.donatingGameObjectTypeProperty = ?1")
    List<GameObjectTypeInteractionPropertyEntity> findAllByDonatingGameObjectTypeProperty(
            GameObjectTypePropertyEntity donatingGameObjectTypeProperty);

    @Query("select distinct gameObjectTypeInteractionProperty from GameObjectTypeInteractionPropertyEntity gameObjectTypeInteractionProperty left join fetch gameObjectTypeInteractionProperty.gameObjectTypeInteraction left join fetch gameObjectTypeInteractionProperty.donatingGameObjectTypeProperty left join fetch gameObjectTypeInteractionProperty.receivingGameObjectTypeProperty left join fetch gameObjectTypeInteractionProperty.overflowGameObjectTypeProperty where gameObjectTypeInteractionProperty.receivingGameObjectTypeProperty = ?1")
    List<GameObjectTypeInteractionPropertyEntity> findAllByReceivingGameObjectTypeProperty(
            GameObjectTypePropertyEntity receivingGameObjectTypeProperty);

    @Query("select distinct gameObjectTypeInteractionProperty from GameObjectTypeInteractionPropertyEntity gameObjectTypeInteractionProperty left join fetch gameObjectTypeInteractionProperty.gameObjectTypeInteraction left join fetch gameObjectTypeInteractionProperty.donatingGameObjectTypeProperty left join fetch gameObjectTypeInteractionProperty.receivingGameObjectTypeProperty left join fetch gameObjectTypeInteractionProperty.overflowGameObjectTypeProperty where gameObjectTypeInteractionProperty.overflowGameObjectTypeProperty = ?1")
    List<GameObjectTypeInteractionPropertyEntity> findAllByOverflowGameObjectTypeProperty(
            GameObjectTypePropertyEntity overflowGameObjectTypeProperty);

    @Query("select distinct gameObjectTypeInteractionProperty from GameObjectTypeInteractionPropertyEntity gameObjectTypeInteractionProperty left join fetch gameObjectTypeInteractionProperty.gameObjectTypeInteraction left join fetch gameObjectTypeInteractionProperty.donatingGameObjectTypeProperty left join fetch gameObjectTypeInteractionProperty.receivingGameObjectTypeProperty left join fetch gameObjectTypeInteractionProperty.overflowGameObjectTypeProperty "
            + "where " + "gameObjectTypeInteractionProperty.donatingGameObjectTypeProperty.propertyName like '%' + ?1 + '%' or "
            + "gameObjectTypeInteractionProperty.receivingGameObjectTypeProperty.propertyName like '%' + ?1 + '%' or "
            + "gameObjectTypeInteractionProperty.overflowGameObjectTypeProperty.propertyName like '%' + ?1 + '%' ")
    List<GameObjectTypeInteractionPropertyEntity> findAllByAnyTextFieldContaining(String content);

    @Query("select distinct gameObjectTypeInteractionProperty from GameObjectTypeInteractionPropertyEntity gameObjectTypeInteractionProperty left join fetch gameObjectTypeInteractionProperty.gameObjectTypeInteraction left join fetch gameObjectTypeInteractionProperty.donatingGameObjectTypeProperty left join fetch gameObjectTypeInteractionProperty.receivingGameObjectTypeProperty left join fetch gameObjectTypeInteractionProperty.overflowGameObjectTypeProperty "
            + "where "
            + "(:gameObjectTypeInteraction is null or gameObjectTypeInteractionProperty.gameObjectTypeInteraction = :gameObjectTypeInteraction) and"
            + "(:donatingGameObjectTypeProperty is null or gameObjectTypeInteractionProperty.donatingGameObjectTypeProperty = :donatingGameObjectTypeProperty) and"
            + "(:receivingGameObjectTypeProperty is null or gameObjectTypeInteractionProperty.receivingGameObjectTypeProperty = :receivingGameObjectTypeProperty) and"
            + "(:overflowGameObjectTypeProperty is null or gameObjectTypeInteractionProperty.overflowGameObjectTypeProperty = :overflowGameObjectTypeProperty) and"
            + "(:isIncremental is null or gameObjectTypeInteractionProperty.isIncremental = :isIncremental) and"
            + "(:isInverted is null or gameObjectTypeInteractionProperty.isInverted = :isInverted)")
    List<GameObjectTypeInteractionPropertyEntity> findAllByExample(GameObjectTypeInteractionEntity gameObjectTypeInteraction,
            GameObjectTypePropertyEntity donatingGameObjectTypeProperty, GameObjectTypePropertyEntity receivingGameObjectTypeProperty,
            GameObjectTypePropertyEntity overflowGameObjectTypeProperty, Boolean isIncremental, Boolean isInverted);
}