package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;


import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeAllowedAddonTypeEntity;

@Generated(value="fx.codegen.builder version 1.0.0", comments="Spring/JPA implementation of the specification of repository for the GameObjectTypeAllowedAddonType entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaGameObjectTypeAllowedAddonTypesRepository extends CrudRepository<GameObjectTypeAllowedAddonTypeEntity, Long> {

	@Query("select distinct gameObjectTypeAllowedAddonType from GameObjectTypeAllowedAddonTypeEntity gameObjectTypeAllowedAddonType where gameObjectTypeAllowedAddonType.uniqueName = ?1")
	GameObjectTypeAllowedAddonTypeEntity findOneByUniqueName(String uniqueName);

	@Query("select distinct gameObjectTypeAllowedAddonType from GameObjectTypeAllowedAddonTypeEntity gameObjectTypeAllowedAddonType where gameObjectTypeAllowedAddonType.addonGameObjectTypeId = ?1")
	List<GameObjectTypeAllowedAddonTypeEntity> findAllByAddonGameObjectTypeId(Long addonGameObjectTypeId);

	@Query("select distinct gameObjectTypeAllowedAddonType from GameObjectTypeAllowedAddonTypeEntity gameObjectTypeAllowedAddonType where gameObjectTypeAllowedAddonType.addonGameObjectTypeId = ?1 and gameObjectTypeAllowedAddonType.id in ?2")
    List<GameObjectTypeAllowedAddonTypeEntity> findAllByAddonGameObjectTypeIdAndIds(Long AddonGameObjectTypeId, List<Long> ids);

	@Transactional
    @Modifying
    @Query("delete GameObjectTypeAllowedAddonTypeEntity where addonGameObjectTypeId = ?1")
    void deleteAllByAddonGameObjectTypeId(Long addonGameObjectTypeId);

    @Transactional
    @Modifying
    @Query("delete GameObjectTypeAllowedAddonTypeEntity where addonGameObjectTypeId = ?1 AND id IN ?2")
    void deleteAllByAddonGameObjectTypeIdAndIds(Long addonGameObjectTypeId, List<Long> ids);

	@Query("select distinct gameObjectTypeAllowedAddonType from GameObjectTypeAllowedAddonTypeEntity gameObjectTypeAllowedAddonType where gameObjectTypeAllowedAddonType.applicableToGameObjectTypeId = ?1")
	List<GameObjectTypeAllowedAddonTypeEntity> findAllByApplicableToGameObjectTypeId(Long applicableToGameObjectTypeId);

	@Query("select distinct gameObjectTypeAllowedAddonType from GameObjectTypeAllowedAddonTypeEntity gameObjectTypeAllowedAddonType where gameObjectTypeAllowedAddonType.applicableToGameObjectTypeId = ?1 and gameObjectTypeAllowedAddonType.id in ?2")
    List<GameObjectTypeAllowedAddonTypeEntity> findAllByApplicableToGameObjectTypeIdAndIds(Long ApplicableToGameObjectTypeId, List<Long> ids);

	@Transactional
    @Modifying
    @Query("delete GameObjectTypeAllowedAddonTypeEntity where applicableToGameObjectTypeId = ?1")
    void deleteAllByApplicableToGameObjectTypeId(Long applicableToGameObjectTypeId);

    @Transactional
    @Modifying
    @Query("delete GameObjectTypeAllowedAddonTypeEntity where applicableToGameObjectTypeId = ?1 AND id IN ?2")
    void deleteAllByApplicableToGameObjectTypeIdAndIds(Long applicableToGameObjectTypeId, List<Long> ids);

	@Query("select distinct gameObjectTypeAllowedAddonType from GameObjectTypeAllowedAddonTypeEntity gameObjectTypeAllowedAddonType where gameObjectTypeAllowedAddonType.triggerActionId = ?1")
	List<GameObjectTypeAllowedAddonTypeEntity> findAllByTriggerActionId(Long triggerActionId);

	@Query("select distinct gameObjectTypeAllowedAddonType from GameObjectTypeAllowedAddonTypeEntity gameObjectTypeAllowedAddonType where gameObjectTypeAllowedAddonType.triggerActionId = ?1 and gameObjectTypeAllowedAddonType.id in ?2")
    List<GameObjectTypeAllowedAddonTypeEntity> findAllByTriggerActionIdAndIds(Long TriggerActionId, List<Long> ids);

	@Transactional
    @Modifying
    @Query("delete GameObjectTypeAllowedAddonTypeEntity where triggerActionId = ?1")
    void deleteAllByTriggerActionId(Long triggerActionId);

    @Transactional
    @Modifying
    @Query("delete GameObjectTypeAllowedAddonTypeEntity where triggerActionId = ?1 AND id IN ?2")
    void deleteAllByTriggerActionIdAndIds(Long triggerActionId, List<Long> ids);

	@Query("select distinct gameObjectTypeAllowedAddonType from GameObjectTypeAllowedAddonTypeEntity gameObjectTypeAllowedAddonType where gameObjectTypeAllowedAddonType.spawnableGameObjectTypeId = ?1")
	List<GameObjectTypeAllowedAddonTypeEntity> findAllBySpawnableGameObjectTypeId(Long spawnableGameObjectTypeId);

	@Query("select distinct gameObjectTypeAllowedAddonType from GameObjectTypeAllowedAddonTypeEntity gameObjectTypeAllowedAddonType where gameObjectTypeAllowedAddonType.spawnableGameObjectTypeId = ?1 and gameObjectTypeAllowedAddonType.id in ?2")
    List<GameObjectTypeAllowedAddonTypeEntity> findAllBySpawnableGameObjectTypeIdAndIds(Long SpawnableGameObjectTypeId, List<Long> ids);

	@Transactional
    @Modifying
    @Query("delete GameObjectTypeAllowedAddonTypeEntity where spawnableGameObjectTypeId = ?1")
    void deleteAllBySpawnableGameObjectTypeId(Long spawnableGameObjectTypeId);

    @Transactional
    @Modifying
    @Query("delete GameObjectTypeAllowedAddonTypeEntity where spawnableGameObjectTypeId = ?1 AND id IN ?2")
    void deleteAllBySpawnableGameObjectTypeIdAndIds(Long spawnableGameObjectTypeId, List<Long> ids);


	@Transactional
    @Modifying
    @Query("delete GameObjectTypeAllowedAddonTypeEntity where id IN ?1")
    void deleteAllByIds(List<Long> ids);



	@Query(
		"select distinct gameObjectTypeAllowedAddonType from GameObjectTypeAllowedAddonTypeEntity gameObjectTypeAllowedAddonType " +
		"where " +
		"(:uniqueName is null or gameObjectTypeAllowedAddonType.uniqueName = :uniqueName) and " + 
		"(:addonGameObjectTypeId is null or gameObjectTypeAllowedAddonType.addonGameObjectTypeId = :addonGameObjectTypeId) and " + 
		"(:applicableToGameObjectTypeId is null or gameObjectTypeAllowedAddonType.applicableToGameObjectTypeId = :applicableToGameObjectTypeId) and " + 
		"(:isEquipedByDefault is null or gameObjectTypeAllowedAddonType.isEquipedByDefault = :isEquipedByDefault) and " + 
		"(:isIncremental is null or gameObjectTypeAllowedAddonType.isIncremental = :isIncremental) and " + 
		"(:isTriggered is null or gameObjectTypeAllowedAddonType.isTriggered = :isTriggered) and " + 
		"(:triggerActionId is null or gameObjectTypeAllowedAddonType.triggerActionId = :triggerActionId) and " + 
		"(:isSpawning is null or gameObjectTypeAllowedAddonType.isSpawning = :isSpawning) and " + 
		"(:spawnableGameObjectTypeId is null or gameObjectTypeAllowedAddonType.spawnableGameObjectTypeId = :spawnableGameObjectTypeId) and " + 
		"(:hasLimitedDuration is null or gameObjectTypeAllowedAddonType.hasLimitedDuration = :hasLimitedDuration) and " + 
		"(:duration is null or gameObjectTypeAllowedAddonType.duration = :duration)"
	)
	List<GameObjectTypeAllowedAddonTypeEntity> findAllByExample(String uniqueName, Long addonGameObjectTypeId, Long applicableToGameObjectTypeId, Boolean isEquipedByDefault, Boolean isIncremental, Boolean isTriggered, Long triggerActionId, Boolean isSpawning, Long spawnableGameObjectTypeId, Boolean hasLimitedDuration, Integer duration);
}