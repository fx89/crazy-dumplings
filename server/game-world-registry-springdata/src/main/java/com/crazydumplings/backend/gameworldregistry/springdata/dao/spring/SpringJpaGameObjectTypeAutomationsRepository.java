package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameObjectTypeAutomationsRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.AutomationObjectProviderEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeAutomationEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Spring/JPA implementation of the specification of repository for the GameObjectTypeAutomation entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaGameObjectTypeAutomationsRepository
        extends GameObjectTypeAutomationsRepository, CrudRepository<GameObjectTypeAutomationEntity, Long> {
    @Query("select distinct gameObjectTypeAutomation from GameObjectTypeAutomationEntity gameObjectTypeAutomation left join fetch gameObjectTypeAutomation.gameObjectType left join fetch gameObjectTypeAutomation.automationObjectProvider")
    List<GameObjectTypeAutomationEntity> findAll();

    @Query("select distinct gameObjectTypeAutomation from GameObjectTypeAutomationEntity gameObjectTypeAutomation left join fetch gameObjectTypeAutomation.gameObjectType left join fetch gameObjectTypeAutomation.automationObjectProvider where gameObjectTypeAutomation.id = ?1")
    GameObjectTypeAutomationEntity findOneById(Long id);

    @Query("select distinct gameObjectTypeAutomation from GameObjectTypeAutomationEntity gameObjectTypeAutomation left join fetch gameObjectTypeAutomation.gameObjectType left join fetch gameObjectTypeAutomation.automationObjectProvider where gameObjectTypeAutomation.gameObjectType = ?1")
    List<GameObjectTypeAutomationEntity> findAllByGameObjectType(GameObjectTypeEntity gameObjectType);

    @Query("select distinct gameObjectTypeAutomation from GameObjectTypeAutomationEntity gameObjectTypeAutomation left join fetch gameObjectTypeAutomation.gameObjectType left join fetch gameObjectTypeAutomation.automationObjectProvider where gameObjectTypeAutomation.automationObjectProvider = ?1")
    List<GameObjectTypeAutomationEntity> findAllByAutomationObjectProvider(AutomationObjectProviderEntity automationObjectProvider);

    @Query("select distinct gameObjectTypeAutomation from GameObjectTypeAutomationEntity gameObjectTypeAutomation left join fetch gameObjectTypeAutomation.gameObjectType left join fetch gameObjectTypeAutomation.automationObjectProvider "
            + "where " + "gameObjectTypeAutomation.gameObjectType.uniqueName like '%' + ?1 + '%' or "
            + "gameObjectTypeAutomation.automationObjectProvider.name like '%' + ?1 + '%' ")
    List<GameObjectTypeAutomationEntity> findAllByAnyTextFieldContaining(String content);

    @Query("select distinct gameObjectTypeAutomation from GameObjectTypeAutomationEntity gameObjectTypeAutomation left join fetch gameObjectTypeAutomation.gameObjectType left join fetch gameObjectTypeAutomation.automationObjectProvider "
            + "where " + "(:gameObjectType is null or gameObjectTypeAutomation.gameObjectType = :gameObjectType) and"
            + "(:automationObjectProvider is null or gameObjectTypeAutomation.automationObjectProvider = :automationObjectProvider)")
    List<GameObjectTypeAutomationEntity> findAllByExample(GameObjectTypeEntity gameObjectType,
            AutomationObjectProviderEntity automationObjectProvider);
}