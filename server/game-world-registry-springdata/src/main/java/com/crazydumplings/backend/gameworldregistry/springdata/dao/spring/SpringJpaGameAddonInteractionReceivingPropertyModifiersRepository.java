package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameAddonInteractionReceivingPropertyModifiersRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameAddonInteractionReceivingPropertyModifierEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeAllowedAddonTypeEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypePropertyEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Spring/JPA implementation of the specification of repository for the GameAddonInteractionReceivingPropertyModifier entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaGameAddonInteractionReceivingPropertyModifiersRepository extends
        GameAddonInteractionReceivingPropertyModifiersRepository, CrudRepository<GameAddonInteractionReceivingPropertyModifierEntity, Long> {
    @Query("select distinct gameAddonInteractionReceivingPropertyModifier from GameAddonInteractionReceivingPropertyModifierEntity gameAddonInteractionReceivingPropertyModifier left join fetch gameAddonInteractionReceivingPropertyModifier.gameObjectTypeAllowedAddonType left join fetch gameAddonInteractionReceivingPropertyModifier.affectedGameObjectTypeProperty")
    List<GameAddonInteractionReceivingPropertyModifierEntity> findAll();

    @Query("select distinct gameAddonInteractionReceivingPropertyModifier from GameAddonInteractionReceivingPropertyModifierEntity gameAddonInteractionReceivingPropertyModifier left join fetch gameAddonInteractionReceivingPropertyModifier.gameObjectTypeAllowedAddonType left join fetch gameAddonInteractionReceivingPropertyModifier.affectedGameObjectTypeProperty where gameAddonInteractionReceivingPropertyModifier.id = ?1")
    GameAddonInteractionReceivingPropertyModifierEntity findOneById(Long id);

    @Query("select distinct gameAddonInteractionReceivingPropertyModifier from GameAddonInteractionReceivingPropertyModifierEntity gameAddonInteractionReceivingPropertyModifier left join fetch gameAddonInteractionReceivingPropertyModifier.gameObjectTypeAllowedAddonType left join fetch gameAddonInteractionReceivingPropertyModifier.affectedGameObjectTypeProperty where gameAddonInteractionReceivingPropertyModifier.gameObjectTypeAllowedAddonType = ?1")
    List<GameAddonInteractionReceivingPropertyModifierEntity> findAllByGameObjectTypeAllowedAddonType(
            GameObjectTypeAllowedAddonTypeEntity gameObjectTypeAllowedAddonType);

    @Query("select distinct gameAddonInteractionReceivingPropertyModifier from GameAddonInteractionReceivingPropertyModifierEntity gameAddonInteractionReceivingPropertyModifier left join fetch gameAddonInteractionReceivingPropertyModifier.gameObjectTypeAllowedAddonType left join fetch gameAddonInteractionReceivingPropertyModifier.affectedGameObjectTypeProperty where gameAddonInteractionReceivingPropertyModifier.affectedGameObjectTypeProperty = ?1")
    List<GameAddonInteractionReceivingPropertyModifierEntity> findAllByAffectedGameObjectTypeProperty(
            GameObjectTypePropertyEntity affectedGameObjectTypeProperty);

    @Query("select distinct gameAddonInteractionReceivingPropertyModifier from GameAddonInteractionReceivingPropertyModifierEntity gameAddonInteractionReceivingPropertyModifier left join fetch gameAddonInteractionReceivingPropertyModifier.gameObjectTypeAllowedAddonType left join fetch gameAddonInteractionReceivingPropertyModifier.affectedGameObjectTypeProperty "
            + "where " + "gameAddonInteractionReceivingPropertyModifier.gameObjectTypeAllowedAddonType.uniqueName like '%' + ?1 + '%' or "
            + "gameAddonInteractionReceivingPropertyModifier.affectedGameObjectTypeProperty.propertyName like '%' + ?1 + '%' ")
    List<GameAddonInteractionReceivingPropertyModifierEntity> findAllByAnyTextFieldContaining(String content);

    @Query("select distinct gameAddonInteractionReceivingPropertyModifier from GameAddonInteractionReceivingPropertyModifierEntity gameAddonInteractionReceivingPropertyModifier left join fetch gameAddonInteractionReceivingPropertyModifier.gameObjectTypeAllowedAddonType left join fetch gameAddonInteractionReceivingPropertyModifier.affectedGameObjectTypeProperty "
            + "where "
            + "(:gameObjectTypeAllowedAddonType is null or gameAddonInteractionReceivingPropertyModifier.gameObjectTypeAllowedAddonType = :gameObjectTypeAllowedAddonType) and"
            + "(:affectedGameObjectTypeProperty is null or gameAddonInteractionReceivingPropertyModifier.affectedGameObjectTypeProperty = :affectedGameObjectTypeProperty) and"
            + "(:appliedPropertyValueMultiplier is null or gameAddonInteractionReceivingPropertyModifier.appliedPropertyValueMultiplier = :appliedPropertyValueMultiplier)")
    List<GameAddonInteractionReceivingPropertyModifierEntity> findAllByExample(
            GameObjectTypeAllowedAddonTypeEntity gameObjectTypeAllowedAddonType, GameObjectTypePropertyEntity affectedGameObjectTypeProperty,
            Double appliedPropertyValueMultiplier);
}