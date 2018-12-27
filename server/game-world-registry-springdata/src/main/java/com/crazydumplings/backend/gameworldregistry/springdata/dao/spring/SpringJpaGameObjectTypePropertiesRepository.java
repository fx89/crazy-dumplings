package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameObjectTypePropertiesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypePropertyEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Spring/JPA implementation of the specification of repository for the GameObjectTypeProperty entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaGameObjectTypePropertiesRepository
        extends GameObjectTypePropertiesRepository, CrudRepository<GameObjectTypePropertyEntity, Long> {
    @Query("select distinct gameObjectTypeProperty from GameObjectTypePropertyEntity gameObjectTypeProperty left join fetch gameObjectTypeProperty.gameObjectType")
    List<GameObjectTypePropertyEntity> findAll();

    @Query("select distinct gameObjectTypeProperty from GameObjectTypePropertyEntity gameObjectTypeProperty left join fetch gameObjectTypeProperty.gameObjectType where gameObjectTypeProperty.id = ?1")
    GameObjectTypePropertyEntity findOneById(Long id);

    @Query("select distinct gameObjectTypeProperty from GameObjectTypePropertyEntity gameObjectTypeProperty left join fetch gameObjectTypeProperty.gameObjectType where gameObjectTypeProperty.gameObjectType = ?1")
    List<GameObjectTypePropertyEntity> findAllByGameObjectType(GameObjectTypeEntity gameObjectType);

    @Query("select distinct gameObjectTypeProperty from GameObjectTypePropertyEntity gameObjectTypeProperty left join fetch gameObjectTypeProperty.gameObjectType where gameObjectTypeProperty.propertyName = ?1")
    GameObjectTypePropertyEntity findOneByPropertyName(String propertyName);

    @Query("select distinct gameObjectTypeProperty from GameObjectTypePropertyEntity gameObjectTypeProperty left join fetch gameObjectTypeProperty.gameObjectType "
            + "where " + "gameObjectTypeProperty.propertyName like '%' + ?1 + '%' or "
            + "gameObjectTypeProperty.gameObjectType.uniqueName like '%' + ?1 + '%' ")
    List<GameObjectTypePropertyEntity> findAllByAnyTextFieldContaining(String content);

    @Query("select distinct gameObjectTypeProperty from GameObjectTypePropertyEntity gameObjectTypeProperty left join fetch gameObjectTypeProperty.gameObjectType "
            + "where " + "(:gameObjectType is null or gameObjectTypeProperty.gameObjectType = :gameObjectType) and"
            + "(:propertyName is null or gameObjectTypeProperty.propertyName = :propertyName) and"
            + "(:propertyDefaultValue is null or gameObjectTypeProperty.propertyDefaultValue = :propertyDefaultValue) and"
            + "(:propertyMinValue is null or gameObjectTypeProperty.propertyMinValue = :propertyMinValue) and"
            + "(:propertyMaxValue is null or gameObjectTypeProperty.propertyMaxValue = :propertyMaxValue)")
    List<GameObjectTypePropertyEntity> findAllByExample(GameObjectTypeEntity gameObjectType, String propertyName, Double propertyDefaultValue,
            Double propertyMinValue, Double propertyMaxValue);
}