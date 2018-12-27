package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameWorldCellTypesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameWorldCellTypeEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Spring/JPA implementation of the specification of repository for the GameWorldCellType entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaGameWorldCellTypesRepository extends GameWorldCellTypesRepository, CrudRepository<GameWorldCellTypeEntity, Long> {
    @Query("select distinct gameWorldCellType from GameWorldCellTypeEntity gameWorldCellType left join fetch gameWorldCellType.gameObjectType")
    List<GameWorldCellTypeEntity> findAll();

    @Query("select distinct gameWorldCellType from GameWorldCellTypeEntity gameWorldCellType left join fetch gameWorldCellType.gameObjectType where gameWorldCellType.id = ?1")
    GameWorldCellTypeEntity findOneById(Long id);

    @Query("select distinct gameWorldCellType from GameWorldCellTypeEntity gameWorldCellType left join fetch gameWorldCellType.gameObjectType where gameWorldCellType.uniqueName = ?1")
    GameWorldCellTypeEntity findOneByUniqueName(String uniqueName);

    @Query("select distinct gameWorldCellType from GameWorldCellTypeEntity gameWorldCellType left join fetch gameWorldCellType.gameObjectType where gameWorldCellType.gameObjectType = ?1")
    List<GameWorldCellTypeEntity> findAllByGameObjectType(GameObjectTypeEntity gameObjectType);

    @Query("select distinct gameWorldCellType from GameWorldCellTypeEntity gameWorldCellType left join fetch gameWorldCellType.gameObjectType "
            + "where " + "gameWorldCellType.uniqueName like '%' + ?1 + '%' or "
            + "gameWorldCellType.gameObjectType.uniqueName like '%' + ?1 + '%' ")
    List<GameWorldCellTypeEntity> findAllByAnyTextFieldContaining(String content);

    @Query("select distinct gameWorldCellType from GameWorldCellTypeEntity gameWorldCellType left join fetch gameWorldCellType.gameObjectType "
            + "where " + "(:uniqueName is null or gameWorldCellType.uniqueName = :uniqueName) and"
            + "(:gameObjectType is null or gameWorldCellType.gameObjectType = :gameObjectType)")
    List<GameWorldCellTypeEntity> findAllByExample(String uniqueName, GameObjectTypeEntity gameObjectType);
}