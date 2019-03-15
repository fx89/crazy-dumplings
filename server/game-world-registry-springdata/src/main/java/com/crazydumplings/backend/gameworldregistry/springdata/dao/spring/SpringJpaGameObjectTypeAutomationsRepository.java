package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;


import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeAutomationEntity;

@Generated(value="fx.codegen.builder version 1.0.0", comments="Spring/JPA implementation of the specification of repository for the GameObjectTypeAutomation entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaGameObjectTypeAutomationsRepository extends CrudRepository<GameObjectTypeAutomationEntity, Long> {

	@Query("select distinct gameObjectTypeAutomation from GameObjectTypeAutomationEntity gameObjectTypeAutomation where gameObjectTypeAutomation.gameObjectTypeId = ?1")
	List<GameObjectTypeAutomationEntity> findAllByGameObjectTypeId(Long gameObjectTypeId);

	@Query("select distinct gameObjectTypeAutomation from GameObjectTypeAutomationEntity gameObjectTypeAutomation where gameObjectTypeAutomation.gameObjectTypeId = ?1 and gameObjectTypeAutomation.id in ?2")
    List<GameObjectTypeAutomationEntity> findAllByGameObjectTypeIdAndIds(Long GameObjectTypeId, List<Long> ids);

	@Transactional
    @Modifying
    @Query("delete GameObjectTypeAutomationEntity where gameObjectTypeId = ?1")
    void deleteAllByGameObjectTypeId(Long gameObjectTypeId);

    @Transactional
    @Modifying
    @Query("delete GameObjectTypeAutomationEntity where gameObjectTypeId = ?1 AND id IN ?2")
    void deleteAllByGameObjectTypeIdAndIds(Long gameObjectTypeId, List<Long> ids);

	@Query("select distinct gameObjectTypeAutomation from GameObjectTypeAutomationEntity gameObjectTypeAutomation where gameObjectTypeAutomation.automationObjectProviderId = ?1")
	List<GameObjectTypeAutomationEntity> findAllByAutomationObjectProviderId(Long automationObjectProviderId);

	@Query("select distinct gameObjectTypeAutomation from GameObjectTypeAutomationEntity gameObjectTypeAutomation where gameObjectTypeAutomation.automationObjectProviderId = ?1 and gameObjectTypeAutomation.id in ?2")
    List<GameObjectTypeAutomationEntity> findAllByAutomationObjectProviderIdAndIds(Long AutomationObjectProviderId, List<Long> ids);

	@Transactional
    @Modifying
    @Query("delete GameObjectTypeAutomationEntity where automationObjectProviderId = ?1")
    void deleteAllByAutomationObjectProviderId(Long automationObjectProviderId);

    @Transactional
    @Modifying
    @Query("delete GameObjectTypeAutomationEntity where automationObjectProviderId = ?1 AND id IN ?2")
    void deleteAllByAutomationObjectProviderIdAndIds(Long automationObjectProviderId, List<Long> ids);


	@Transactional
    @Modifying
    @Query("delete GameObjectTypeAutomationEntity where id IN ?1")
    void deleteAllByIds(List<Long> ids);



	@Query(
		"select distinct gameObjectTypeAutomation from GameObjectTypeAutomationEntity gameObjectTypeAutomation " +
		"where " +
		"(:gameObjectTypeId is null or gameObjectTypeAutomation.gameObjectTypeId = :gameObjectTypeId) and " + 
		"(:automationObjectProviderId is null or gameObjectTypeAutomation.automationObjectProviderId = :automationObjectProviderId)"
	)
	List<GameObjectTypeAutomationEntity> findAllByExample(Long gameObjectTypeId, Long automationObjectProviderId);
}