package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;


import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeStateTransitionEntity;

@Generated(value="fx.codegen.builder version 1.0.0", comments="Spring/JPA implementation of the specification of repository for the GameObjectTypeStateTransition entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaGameObjectTypeStateTransitionsRepository extends CrudRepository<GameObjectTypeStateTransitionEntity, Long> {

	@Query("select distinct gameObjectTypeStateTransition from GameObjectTypeStateTransitionEntity gameObjectTypeStateTransition where gameObjectTypeStateTransition.sourceGameObjectTypeStateId = ?1")
	List<GameObjectTypeStateTransitionEntity> findAllBySourceGameObjectTypeStateId(Long sourceGameObjectTypeStateId);

	@Query("select distinct gameObjectTypeStateTransition from GameObjectTypeStateTransitionEntity gameObjectTypeStateTransition where gameObjectTypeStateTransition.sourceGameObjectTypeStateId = ?1 and gameObjectTypeStateTransition.id in ?2")
    List<GameObjectTypeStateTransitionEntity> findAllBySourceGameObjectTypeStateIdAndIds(Long SourceGameObjectTypeStateId, List<Long> ids);

	@Transactional
    @Modifying
    @Query("delete GameObjectTypeStateTransitionEntity where sourceGameObjectTypeStateId = ?1")
    void deleteAllBySourceGameObjectTypeStateId(Long sourceGameObjectTypeStateId);

    @Transactional
    @Modifying
    @Query("delete GameObjectTypeStateTransitionEntity where sourceGameObjectTypeStateId = ?1 AND id IN ?2")
    void deleteAllBySourceGameObjectTypeStateIdAndIds(Long sourceGameObjectTypeStateId, List<Long> ids);

	@Query("select distinct gameObjectTypeStateTransition from GameObjectTypeStateTransitionEntity gameObjectTypeStateTransition where gameObjectTypeStateTransition.targetGameObjectTypeStateId = ?1")
	List<GameObjectTypeStateTransitionEntity> findAllByTargetGameObjectTypeStateId(Long targetGameObjectTypeStateId);

	@Query("select distinct gameObjectTypeStateTransition from GameObjectTypeStateTransitionEntity gameObjectTypeStateTransition where gameObjectTypeStateTransition.targetGameObjectTypeStateId = ?1 and gameObjectTypeStateTransition.id in ?2")
    List<GameObjectTypeStateTransitionEntity> findAllByTargetGameObjectTypeStateIdAndIds(Long TargetGameObjectTypeStateId, List<Long> ids);

	@Transactional
    @Modifying
    @Query("delete GameObjectTypeStateTransitionEntity where targetGameObjectTypeStateId = ?1")
    void deleteAllByTargetGameObjectTypeStateId(Long targetGameObjectTypeStateId);

    @Transactional
    @Modifying
    @Query("delete GameObjectTypeStateTransitionEntity where targetGameObjectTypeStateId = ?1 AND id IN ?2")
    void deleteAllByTargetGameObjectTypeStateIdAndIds(Long targetGameObjectTypeStateId, List<Long> ids);

	@Query("select distinct gameObjectTypeStateTransition from GameObjectTypeStateTransitionEntity gameObjectTypeStateTransition where gameObjectTypeStateTransition.triggerActionId = ?1")
	List<GameObjectTypeStateTransitionEntity> findAllByTriggerActionId(Long triggerActionId);

	@Query("select distinct gameObjectTypeStateTransition from GameObjectTypeStateTransitionEntity gameObjectTypeStateTransition where gameObjectTypeStateTransition.triggerActionId = ?1 and gameObjectTypeStateTransition.id in ?2")
    List<GameObjectTypeStateTransitionEntity> findAllByTriggerActionIdAndIds(Long TriggerActionId, List<Long> ids);

	@Transactional
    @Modifying
    @Query("delete GameObjectTypeStateTransitionEntity where triggerActionId = ?1")
    void deleteAllByTriggerActionId(Long triggerActionId);

    @Transactional
    @Modifying
    @Query("delete GameObjectTypeStateTransitionEntity where triggerActionId = ?1 AND id IN ?2")
    void deleteAllByTriggerActionIdAndIds(Long triggerActionId, List<Long> ids);


	@Transactional
    @Modifying
    @Query("delete GameObjectTypeStateTransitionEntity where id IN ?1")
    void deleteAllByIds(List<Long> ids);



	@Query(
		"select distinct gameObjectTypeStateTransition from GameObjectTypeStateTransitionEntity gameObjectTypeStateTransition " +
		"where " +
		"(:sourceGameObjectTypeStateId is null or gameObjectTypeStateTransition.sourceGameObjectTypeStateId = :sourceGameObjectTypeStateId) and " + 
		"(:targetGameObjectTypeStateId is null or gameObjectTypeStateTransition.targetGameObjectTypeStateId = :targetGameObjectTypeStateId) and " + 
		"(:isAutomatic is null or gameObjectTypeStateTransition.isAutomatic = :isAutomatic) and " + 
		"(:triggerActionId is null or gameObjectTypeStateTransition.triggerActionId = :triggerActionId)"
	)
	List<GameObjectTypeStateTransitionEntity> findAllByExample(Long sourceGameObjectTypeStateId, Long targetGameObjectTypeStateId, Boolean isAutomatic, Long triggerActionId);
}