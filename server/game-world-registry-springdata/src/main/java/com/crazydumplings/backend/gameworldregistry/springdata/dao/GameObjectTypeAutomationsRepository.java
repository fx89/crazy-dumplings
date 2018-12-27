package com.crazydumplings.backend.gameworldregistry.springdata.dao;

import java.util.List;

import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.AutomationObjectProviderEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeAutomationEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Repository specification for the GameObjectTypeAutomation entity")
public interface GameObjectTypeAutomationsRepository {
    List<GameObjectTypeAutomationEntity> findAll();

    GameObjectTypeAutomationEntity findOneById(Long id);

    List<GameObjectTypeAutomationEntity> findAllByGameObjectType(GameObjectTypeEntity gameObjectType);

    List<GameObjectTypeAutomationEntity> findAllByAutomationObjectProvider(AutomationObjectProviderEntity automationObjectProvider);

    List<GameObjectTypeAutomationEntity> findAllByAnyTextFieldContaining(String content);

    List<GameObjectTypeAutomationEntity> findAllByExample(GameObjectTypeEntity gameObjectType,
            AutomationObjectProviderEntity automationObjectProvider);

    GameObjectTypeAutomationEntity save(GameObjectTypeAutomationEntity gameObjectTypeAutomation);

    void delete(GameObjectTypeAutomationEntity gameObjectTypeAutomation);
}