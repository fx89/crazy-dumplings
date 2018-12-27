package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameWorldSpawnPointTypesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameWorldSpawnPointTypeEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Spring/JPA implementation of the specification of repository for the GameWorldSpawnPointType entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaGameWorldSpawnPointTypesRepository
        extends GameWorldSpawnPointTypesRepository, CrudRepository<GameWorldSpawnPointTypeEntity, Long> {
    @Query("select distinct gameWorldSpawnPointType from GameWorldSpawnPointTypeEntity gameWorldSpawnPointType left join fetch gameWorldSpawnPointType.spawnPointGameObjectType left join fetch gameWorldSpawnPointType.spawnedGameObjectType")
    List<GameWorldSpawnPointTypeEntity> findAll();

    @Query("select distinct gameWorldSpawnPointType from GameWorldSpawnPointTypeEntity gameWorldSpawnPointType left join fetch gameWorldSpawnPointType.spawnPointGameObjectType left join fetch gameWorldSpawnPointType.spawnedGameObjectType where gameWorldSpawnPointType.id = ?1")
    GameWorldSpawnPointTypeEntity findOneById(Long id);

    @Query("select distinct gameWorldSpawnPointType from GameWorldSpawnPointTypeEntity gameWorldSpawnPointType left join fetch gameWorldSpawnPointType.spawnPointGameObjectType left join fetch gameWorldSpawnPointType.spawnedGameObjectType where gameWorldSpawnPointType.spawnPointGameObjectType = ?1")
    List<GameWorldSpawnPointTypeEntity> findAllBySpawnPointGameObjectType(GameObjectTypeEntity spawnPointGameObjectType);

    @Query("select distinct gameWorldSpawnPointType from GameWorldSpawnPointTypeEntity gameWorldSpawnPointType left join fetch gameWorldSpawnPointType.spawnPointGameObjectType left join fetch gameWorldSpawnPointType.spawnedGameObjectType where gameWorldSpawnPointType.spawnedGameObjectType = ?1")
    List<GameWorldSpawnPointTypeEntity> findAllBySpawnedGameObjectType(GameObjectTypeEntity spawnedGameObjectType);

    @Query("select distinct gameWorldSpawnPointType from GameWorldSpawnPointTypeEntity gameWorldSpawnPointType left join fetch gameWorldSpawnPointType.spawnPointGameObjectType left join fetch gameWorldSpawnPointType.spawnedGameObjectType "
            + "where " + "gameWorldSpawnPointType.spawnPointGameObjectType.uniqueName like '%' + ?1 + '%' or "
            + "gameWorldSpawnPointType.spawnedGameObjectType.uniqueName like '%' + ?1 + '%' ")
    List<GameWorldSpawnPointTypeEntity> findAllByAnyTextFieldContaining(String content);

    @Query("select distinct gameWorldSpawnPointType from GameWorldSpawnPointTypeEntity gameWorldSpawnPointType left join fetch gameWorldSpawnPointType.spawnPointGameObjectType left join fetch gameWorldSpawnPointType.spawnedGameObjectType "
            + "where "
            + "(:spawnPointGameObjectType is null or gameWorldSpawnPointType.spawnPointGameObjectType = :spawnPointGameObjectType) and"
            + "(:spawnedGameObjectType is null or gameWorldSpawnPointType.spawnedGameObjectType = :spawnedGameObjectType)")
    List<GameWorldSpawnPointTypeEntity> findAllByExample(GameObjectTypeEntity spawnPointGameObjectType,
            GameObjectTypeEntity spawnedGameObjectType);
}