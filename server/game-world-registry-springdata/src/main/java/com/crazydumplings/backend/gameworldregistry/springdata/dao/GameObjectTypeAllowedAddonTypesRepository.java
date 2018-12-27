package com.crazydumplings.backend.gameworldregistry.springdata.dao;

import java.util.List;

import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.ActionEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeAllowedAddonTypeEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Repository specification for the GameObjectTypeAllowedAddonType entity")
public interface GameObjectTypeAllowedAddonTypesRepository {
    List<GameObjectTypeAllowedAddonTypeEntity> findAll();

    GameObjectTypeAllowedAddonTypeEntity findOneById(Long id);

    GameObjectTypeAllowedAddonTypeEntity findOneByUniqueName(String uniqueName);

    List<GameObjectTypeAllowedAddonTypeEntity> findAllByAddonGameObjectType(GameObjectTypeEntity addonGameObjectType);

    List<GameObjectTypeAllowedAddonTypeEntity> findAllByApplicableToGameObjectType(GameObjectTypeEntity applicableToGameObjectType);

    List<GameObjectTypeAllowedAddonTypeEntity> findAllByTriggerAction(ActionEntity triggerAction);

    List<GameObjectTypeAllowedAddonTypeEntity> findAllBySpawnableGameObjectType(GameObjectTypeEntity spawnableGameObjectType);

    List<GameObjectTypeAllowedAddonTypeEntity> findAllByAnyTextFieldContaining(String content);

    List<GameObjectTypeAllowedAddonTypeEntity> findAllByExample(String uniqueName, GameObjectTypeEntity addonGameObjectType,
            GameObjectTypeEntity applicableToGameObjectType, Boolean isEquipedByDefault, Boolean isIncremental, Boolean isTriggered,
            ActionEntity triggerAction, Boolean isSpawning, GameObjectTypeEntity spawnableGameObjectType, Boolean hasLimitedDuration,
            Integer duration);

    GameObjectTypeAllowedAddonTypeEntity save(GameObjectTypeAllowedAddonTypeEntity gameObjectTypeAllowedAddonType);

    void delete(GameObjectTypeAllowedAddonTypeEntity gameObjectTypeAllowedAddonType);
}