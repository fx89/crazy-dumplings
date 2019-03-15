package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;


import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameWorldSpawnPointTypeEntity;

@Generated(value="fx.codegen.builder version 1.0.0", comments="Spring/JPA implementation of the specification of repository for the GameWorldSpawnPointType entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaGameWorldSpawnPointTypesRepository extends CrudRepository<GameWorldSpawnPointTypeEntity, Long> {

	@Query("select distinct gameWorldSpawnPointType from GameWorldSpawnPointTypeEntity gameWorldSpawnPointType where gameWorldSpawnPointType.spawnPointGameObjectTypeId = ?1")
	List<GameWorldSpawnPointTypeEntity> findAllBySpawnPointGameObjectTypeId(Long spawnPointGameObjectTypeId);

	@Query("select distinct gameWorldSpawnPointType from GameWorldSpawnPointTypeEntity gameWorldSpawnPointType where gameWorldSpawnPointType.spawnPointGameObjectTypeId = ?1 and gameWorldSpawnPointType.id in ?2")
    List<GameWorldSpawnPointTypeEntity> findAllBySpawnPointGameObjectTypeIdAndIds(Long SpawnPointGameObjectTypeId, List<Long> ids);

	@Transactional
    @Modifying
    @Query("delete GameWorldSpawnPointTypeEntity where spawnPointGameObjectTypeId = ?1")
    void deleteAllBySpawnPointGameObjectTypeId(Long spawnPointGameObjectTypeId);

    @Transactional
    @Modifying
    @Query("delete GameWorldSpawnPointTypeEntity where spawnPointGameObjectTypeId = ?1 AND id IN ?2")
    void deleteAllBySpawnPointGameObjectTypeIdAndIds(Long spawnPointGameObjectTypeId, List<Long> ids);

	@Query("select distinct gameWorldSpawnPointType from GameWorldSpawnPointTypeEntity gameWorldSpawnPointType where gameWorldSpawnPointType.spawnedGameObjectTypeId = ?1")
	List<GameWorldSpawnPointTypeEntity> findAllBySpawnedGameObjectTypeId(Long spawnedGameObjectTypeId);

	@Query("select distinct gameWorldSpawnPointType from GameWorldSpawnPointTypeEntity gameWorldSpawnPointType where gameWorldSpawnPointType.spawnedGameObjectTypeId = ?1 and gameWorldSpawnPointType.id in ?2")
    List<GameWorldSpawnPointTypeEntity> findAllBySpawnedGameObjectTypeIdAndIds(Long SpawnedGameObjectTypeId, List<Long> ids);

	@Transactional
    @Modifying
    @Query("delete GameWorldSpawnPointTypeEntity where spawnedGameObjectTypeId = ?1")
    void deleteAllBySpawnedGameObjectTypeId(Long spawnedGameObjectTypeId);

    @Transactional
    @Modifying
    @Query("delete GameWorldSpawnPointTypeEntity where spawnedGameObjectTypeId = ?1 AND id IN ?2")
    void deleteAllBySpawnedGameObjectTypeIdAndIds(Long spawnedGameObjectTypeId, List<Long> ids);


	@Transactional
    @Modifying
    @Query("delete GameWorldSpawnPointTypeEntity where id IN ?1")
    void deleteAllByIds(List<Long> ids);



	@Query(
		"select distinct gameWorldSpawnPointType from GameWorldSpawnPointTypeEntity gameWorldSpawnPointType " +
		"where " +
		"(:spawnPointGameObjectTypeId is null or gameWorldSpawnPointType.spawnPointGameObjectTypeId = :spawnPointGameObjectTypeId) and " + 
		"(:spawnedGameObjectTypeId is null or gameWorldSpawnPointType.spawnedGameObjectTypeId = :spawnedGameObjectTypeId)"
	)
	List<GameWorldSpawnPointTypeEntity> findAllByExample(Long spawnPointGameObjectTypeId, Long spawnedGameObjectTypeId);
}