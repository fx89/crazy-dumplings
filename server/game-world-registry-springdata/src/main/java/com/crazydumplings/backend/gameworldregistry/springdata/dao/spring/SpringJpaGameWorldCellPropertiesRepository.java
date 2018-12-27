package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameWorldCellPropertiesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypePropertyEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameWorldCellEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameWorldCellPropertyEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Spring/JPA implementation of the specification of repository for the GameWorldCellProperty entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaGameWorldCellPropertiesRepository
        extends GameWorldCellPropertiesRepository, CrudRepository<GameWorldCellPropertyEntity, Long> {
    @Query("select distinct gameWorldCellProperty from GameWorldCellPropertyEntity gameWorldCellProperty left join fetch gameWorldCellProperty.gameWorldCell left join fetch gameWorldCellProperty.gameObjectTypeProperty")
    List<GameWorldCellPropertyEntity> findAll();

    @Query("select distinct gameWorldCellProperty from GameWorldCellPropertyEntity gameWorldCellProperty left join fetch gameWorldCellProperty.gameWorldCell left join fetch gameWorldCellProperty.gameObjectTypeProperty where gameWorldCellProperty.id = ?1")
    GameWorldCellPropertyEntity findOneById(Long id);

    @Query("select distinct gameWorldCellProperty from GameWorldCellPropertyEntity gameWorldCellProperty left join fetch gameWorldCellProperty.gameWorldCell left join fetch gameWorldCellProperty.gameObjectTypeProperty where gameWorldCellProperty.gameWorldCell = ?1")
    List<GameWorldCellPropertyEntity> findAllByGameWorldCell(GameWorldCellEntity gameWorldCell);

    @Query("select distinct gameWorldCellProperty from GameWorldCellPropertyEntity gameWorldCellProperty left join fetch gameWorldCellProperty.gameWorldCell left join fetch gameWorldCellProperty.gameObjectTypeProperty where gameWorldCellProperty.gameObjectTypeProperty = ?1")
    List<GameWorldCellPropertyEntity> findAllByGameObjectTypeProperty(GameObjectTypePropertyEntity gameObjectTypeProperty);

    @Query("select distinct gameWorldCellProperty from GameWorldCellPropertyEntity gameWorldCellProperty left join fetch gameWorldCellProperty.gameWorldCell left join fetch gameWorldCellProperty.gameObjectTypeProperty "
            + "where " + "gameWorldCellProperty.gameObjectTypeProperty.propertyName like '%' + ?1 + '%' ")
    List<GameWorldCellPropertyEntity> findAllByAnyTextFieldContaining(String content);

    @Query("select distinct gameWorldCellProperty from GameWorldCellPropertyEntity gameWorldCellProperty left join fetch gameWorldCellProperty.gameWorldCell left join fetch gameWorldCellProperty.gameObjectTypeProperty "
            + "where " + "(:gameWorldCell is null or gameWorldCellProperty.gameWorldCell = :gameWorldCell) and"
            + "(:gameObjectTypeProperty is null or gameWorldCellProperty.gameObjectTypeProperty = :gameObjectTypeProperty) and"
            + "(:propertyActualValue is null or gameWorldCellProperty.propertyActualValue = :propertyActualValue)")
    List<GameWorldCellPropertyEntity> findAllByExample(GameWorldCellEntity gameWorldCell, GameObjectTypePropertyEntity gameObjectTypeProperty,
            Double propertyActualValue);
}