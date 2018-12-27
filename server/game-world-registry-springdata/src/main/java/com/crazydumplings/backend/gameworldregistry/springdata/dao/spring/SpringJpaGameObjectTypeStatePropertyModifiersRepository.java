package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameObjectTypeStatePropertyModifiersRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypePropertyEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeStateEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeStatePropertyModifierEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Spring/JPA implementation of the specification of repository for the GameObjectTypeStatePropertyModifier entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaGameObjectTypeStatePropertyModifiersRepository
        extends GameObjectTypeStatePropertyModifiersRepository, CrudRepository<GameObjectTypeStatePropertyModifierEntity, Long> {
    @Query("select distinct gameObjectTypeStatePropertyModifier from GameObjectTypeStatePropertyModifierEntity gameObjectTypeStatePropertyModifier left join fetch gameObjectTypeStatePropertyModifier.gameObjectTypeState left join fetch gameObjectTypeStatePropertyModifier.gameObjectTypeProperty")
    List<GameObjectTypeStatePropertyModifierEntity> findAll();

    @Query("select distinct gameObjectTypeStatePropertyModifier from GameObjectTypeStatePropertyModifierEntity gameObjectTypeStatePropertyModifier left join fetch gameObjectTypeStatePropertyModifier.gameObjectTypeState left join fetch gameObjectTypeStatePropertyModifier.gameObjectTypeProperty where gameObjectTypeStatePropertyModifier.id = ?1")
    GameObjectTypeStatePropertyModifierEntity findOneById(Long id);

    @Query("select distinct gameObjectTypeStatePropertyModifier from GameObjectTypeStatePropertyModifierEntity gameObjectTypeStatePropertyModifier left join fetch gameObjectTypeStatePropertyModifier.gameObjectTypeState left join fetch gameObjectTypeStatePropertyModifier.gameObjectTypeProperty where gameObjectTypeStatePropertyModifier.gameObjectTypeState = ?1")
    List<GameObjectTypeStatePropertyModifierEntity> findAllByGameObjectTypeState(GameObjectTypeStateEntity gameObjectTypeState);

    @Query("select distinct gameObjectTypeStatePropertyModifier from GameObjectTypeStatePropertyModifierEntity gameObjectTypeStatePropertyModifier left join fetch gameObjectTypeStatePropertyModifier.gameObjectTypeState left join fetch gameObjectTypeStatePropertyModifier.gameObjectTypeProperty where gameObjectTypeStatePropertyModifier.gameObjectTypeProperty = ?1")
    List<GameObjectTypeStatePropertyModifierEntity> findAllByGameObjectTypeProperty(GameObjectTypePropertyEntity gameObjectTypeProperty);

    @Query("select distinct gameObjectTypeStatePropertyModifier from GameObjectTypeStatePropertyModifierEntity gameObjectTypeStatePropertyModifier left join fetch gameObjectTypeStatePropertyModifier.gameObjectTypeState left join fetch gameObjectTypeStatePropertyModifier.gameObjectTypeProperty "
            + "where " + "gameObjectTypeStatePropertyModifier.gameObjectTypeState.name like '%' + ?1 + '%' or "
            + "gameObjectTypeStatePropertyModifier.gameObjectTypeProperty.propertyName like '%' + ?1 + '%' ")
    List<GameObjectTypeStatePropertyModifierEntity> findAllByAnyTextFieldContaining(String content);

    @Query("select distinct gameObjectTypeStatePropertyModifier from GameObjectTypeStatePropertyModifierEntity gameObjectTypeStatePropertyModifier left join fetch gameObjectTypeStatePropertyModifier.gameObjectTypeState left join fetch gameObjectTypeStatePropertyModifier.gameObjectTypeProperty "
            + "where " + "(:gameObjectTypeState is null or gameObjectTypeStatePropertyModifier.gameObjectTypeState = :gameObjectTypeState) and"
            + "(:gameObjectTypeProperty is null or gameObjectTypeStatePropertyModifier.gameObjectTypeProperty = :gameObjectTypeProperty) and"
            + "(:propertyActualValue is null or gameObjectTypeStatePropertyModifier.propertyActualValue = :propertyActualValue)")
    List<GameObjectTypeStatePropertyModifierEntity> findAllByExample(GameObjectTypeStateEntity gameObjectTypeState,
            GameObjectTypePropertyEntity gameObjectTypeProperty, Double propertyActualValue);
}