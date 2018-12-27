package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameObjectTypeAllowedAddonTypesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.ActionEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeAllowedAddonTypeEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Spring/JPA implementation of the specification of repository for the GameObjectTypeAllowedAddonType entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaGameObjectTypeAllowedAddonTypesRepository
        extends GameObjectTypeAllowedAddonTypesRepository, CrudRepository<GameObjectTypeAllowedAddonTypeEntity, Long> {
    @Query("select distinct gameObjectTypeAllowedAddonType from GameObjectTypeAllowedAddonTypeEntity gameObjectTypeAllowedAddonType left join fetch gameObjectTypeAllowedAddonType.addonGameObjectType left join fetch gameObjectTypeAllowedAddonType.applicableToGameObjectType left join fetch gameObjectTypeAllowedAddonType.triggerAction left join fetch gameObjectTypeAllowedAddonType.spawnableGameObjectType")
    List<GameObjectTypeAllowedAddonTypeEntity> findAll();

    @Query("select distinct gameObjectTypeAllowedAddonType from GameObjectTypeAllowedAddonTypeEntity gameObjectTypeAllowedAddonType left join fetch gameObjectTypeAllowedAddonType.addonGameObjectType left join fetch gameObjectTypeAllowedAddonType.applicableToGameObjectType left join fetch gameObjectTypeAllowedAddonType.triggerAction left join fetch gameObjectTypeAllowedAddonType.spawnableGameObjectType where gameObjectTypeAllowedAddonType.id = ?1")
    GameObjectTypeAllowedAddonTypeEntity findOneById(Long id);

    @Query("select distinct gameObjectTypeAllowedAddonType from GameObjectTypeAllowedAddonTypeEntity gameObjectTypeAllowedAddonType left join fetch gameObjectTypeAllowedAddonType.addonGameObjectType left join fetch gameObjectTypeAllowedAddonType.applicableToGameObjectType left join fetch gameObjectTypeAllowedAddonType.triggerAction left join fetch gameObjectTypeAllowedAddonType.spawnableGameObjectType where gameObjectTypeAllowedAddonType.uniqueName = ?1")
    GameObjectTypeAllowedAddonTypeEntity findOneByUniqueName(String uniqueName);

    @Query("select distinct gameObjectTypeAllowedAddonType from GameObjectTypeAllowedAddonTypeEntity gameObjectTypeAllowedAddonType left join fetch gameObjectTypeAllowedAddonType.addonGameObjectType left join fetch gameObjectTypeAllowedAddonType.applicableToGameObjectType left join fetch gameObjectTypeAllowedAddonType.triggerAction left join fetch gameObjectTypeAllowedAddonType.spawnableGameObjectType where gameObjectTypeAllowedAddonType.addonGameObjectType = ?1")
    List<GameObjectTypeAllowedAddonTypeEntity> findAllByAddonGameObjectType(GameObjectTypeEntity addonGameObjectType);

    @Query("select distinct gameObjectTypeAllowedAddonType from GameObjectTypeAllowedAddonTypeEntity gameObjectTypeAllowedAddonType left join fetch gameObjectTypeAllowedAddonType.addonGameObjectType left join fetch gameObjectTypeAllowedAddonType.applicableToGameObjectType left join fetch gameObjectTypeAllowedAddonType.triggerAction left join fetch gameObjectTypeAllowedAddonType.spawnableGameObjectType where gameObjectTypeAllowedAddonType.applicableToGameObjectType = ?1")
    List<GameObjectTypeAllowedAddonTypeEntity> findAllByApplicableToGameObjectType(GameObjectTypeEntity applicableToGameObjectType);

    @Query("select distinct gameObjectTypeAllowedAddonType from GameObjectTypeAllowedAddonTypeEntity gameObjectTypeAllowedAddonType left join fetch gameObjectTypeAllowedAddonType.addonGameObjectType left join fetch gameObjectTypeAllowedAddonType.applicableToGameObjectType left join fetch gameObjectTypeAllowedAddonType.triggerAction left join fetch gameObjectTypeAllowedAddonType.spawnableGameObjectType where gameObjectTypeAllowedAddonType.triggerAction = ?1")
    List<GameObjectTypeAllowedAddonTypeEntity> findAllByTriggerAction(ActionEntity triggerAction);

    @Query("select distinct gameObjectTypeAllowedAddonType from GameObjectTypeAllowedAddonTypeEntity gameObjectTypeAllowedAddonType left join fetch gameObjectTypeAllowedAddonType.addonGameObjectType left join fetch gameObjectTypeAllowedAddonType.applicableToGameObjectType left join fetch gameObjectTypeAllowedAddonType.triggerAction left join fetch gameObjectTypeAllowedAddonType.spawnableGameObjectType where gameObjectTypeAllowedAddonType.spawnableGameObjectType = ?1")
    List<GameObjectTypeAllowedAddonTypeEntity> findAllBySpawnableGameObjectType(GameObjectTypeEntity spawnableGameObjectType);

    @Query("select distinct gameObjectTypeAllowedAddonType from GameObjectTypeAllowedAddonTypeEntity gameObjectTypeAllowedAddonType left join fetch gameObjectTypeAllowedAddonType.addonGameObjectType left join fetch gameObjectTypeAllowedAddonType.applicableToGameObjectType left join fetch gameObjectTypeAllowedAddonType.triggerAction left join fetch gameObjectTypeAllowedAddonType.spawnableGameObjectType "
            + "where " + "gameObjectTypeAllowedAddonType.uniqueName like '%' + ?1 + '%' or "
            + "gameObjectTypeAllowedAddonType.addonGameObjectType.uniqueName like '%' + ?1 + '%' or "
            + "gameObjectTypeAllowedAddonType.applicableToGameObjectType.uniqueName like '%' + ?1 + '%' or "
            + "gameObjectTypeAllowedAddonType.triggerAction.uniqueName like '%' + ?1 + '%' or "
            + "gameObjectTypeAllowedAddonType.spawnableGameObjectType.uniqueName like '%' + ?1 + '%' ")
    List<GameObjectTypeAllowedAddonTypeEntity> findAllByAnyTextFieldContaining(String content);

    @Query("select distinct gameObjectTypeAllowedAddonType from GameObjectTypeAllowedAddonTypeEntity gameObjectTypeAllowedAddonType left join fetch gameObjectTypeAllowedAddonType.addonGameObjectType left join fetch gameObjectTypeAllowedAddonType.applicableToGameObjectType left join fetch gameObjectTypeAllowedAddonType.triggerAction left join fetch gameObjectTypeAllowedAddonType.spawnableGameObjectType "
            + "where " + "(:uniqueName is null or gameObjectTypeAllowedAddonType.uniqueName = :uniqueName) and"
            + "(:addonGameObjectType is null or gameObjectTypeAllowedAddonType.addonGameObjectType = :addonGameObjectType) and"
            + "(:applicableToGameObjectType is null or gameObjectTypeAllowedAddonType.applicableToGameObjectType = :applicableToGameObjectType) and"
            + "(:isEquipedByDefault is null or gameObjectTypeAllowedAddonType.isEquipedByDefault = :isEquipedByDefault) and"
            + "(:isIncremental is null or gameObjectTypeAllowedAddonType.isIncremental = :isIncremental) and"
            + "(:isTriggered is null or gameObjectTypeAllowedAddonType.isTriggered = :isTriggered) and"
            + "(:triggerAction is null or gameObjectTypeAllowedAddonType.triggerAction = :triggerAction) and"
            + "(:isSpawning is null or gameObjectTypeAllowedAddonType.isSpawning = :isSpawning) and"
            + "(:spawnableGameObjectType is null or gameObjectTypeAllowedAddonType.spawnableGameObjectType = :spawnableGameObjectType) and"
            + "(:hasLimitedDuration is null or gameObjectTypeAllowedAddonType.hasLimitedDuration = :hasLimitedDuration) and"
            + "(:duration is null or gameObjectTypeAllowedAddonType.duration = :duration)")
    List<GameObjectTypeAllowedAddonTypeEntity> findAllByExample(String uniqueName, GameObjectTypeEntity addonGameObjectType,
            GameObjectTypeEntity applicableToGameObjectType, Boolean isEquipedByDefault, Boolean isIncremental, Boolean isTriggered,
            ActionEntity triggerAction, Boolean isSpawning, GameObjectTypeEntity spawnableGameObjectType, Boolean hasLimitedDuration,
            Integer duration);
}