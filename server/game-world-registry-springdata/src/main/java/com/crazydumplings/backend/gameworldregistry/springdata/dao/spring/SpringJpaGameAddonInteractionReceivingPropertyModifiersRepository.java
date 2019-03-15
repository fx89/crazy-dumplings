package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;


import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameAddonInteractionReceivingPropertyModifierEntity;

@Generated(value="fx.codegen.builder version 1.0.0", comments="Spring/JPA implementation of the specification of repository for the GameAddonInteractionReceivingPropertyModifier entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaGameAddonInteractionReceivingPropertyModifiersRepository extends CrudRepository<GameAddonInteractionReceivingPropertyModifierEntity, Long> {

	@Query("select distinct gameAddonInteractionReceivingPropertyModifier from GameAddonInteractionReceivingPropertyModifierEntity gameAddonInteractionReceivingPropertyModifier where gameAddonInteractionReceivingPropertyModifier.gameObjectTypeAllowedAddonTypeId = ?1")
	List<GameAddonInteractionReceivingPropertyModifierEntity> findAllByGameObjectTypeAllowedAddonTypeId(Long gameObjectTypeAllowedAddonTypeId);

	@Query("select distinct gameAddonInteractionReceivingPropertyModifier from GameAddonInteractionReceivingPropertyModifierEntity gameAddonInteractionReceivingPropertyModifier where gameAddonInteractionReceivingPropertyModifier.gameObjectTypeAllowedAddonTypeId = ?1 and gameAddonInteractionReceivingPropertyModifier.id in ?2")
    List<GameAddonInteractionReceivingPropertyModifierEntity> findAllByGameObjectTypeAllowedAddonTypeIdAndIds(Long GameObjectTypeAllowedAddonTypeId, List<Long> ids);

	@Transactional
    @Modifying
    @Query("delete GameAddonInteractionReceivingPropertyModifierEntity where gameObjectTypeAllowedAddonTypeId = ?1")
    void deleteAllByGameObjectTypeAllowedAddonTypeId(Long gameObjectTypeAllowedAddonTypeId);

    @Transactional
    @Modifying
    @Query("delete GameAddonInteractionReceivingPropertyModifierEntity where gameObjectTypeAllowedAddonTypeId = ?1 AND id IN ?2")
    void deleteAllByGameObjectTypeAllowedAddonTypeIdAndIds(Long gameObjectTypeAllowedAddonTypeId, List<Long> ids);

	@Query("select distinct gameAddonInteractionReceivingPropertyModifier from GameAddonInteractionReceivingPropertyModifierEntity gameAddonInteractionReceivingPropertyModifier where gameAddonInteractionReceivingPropertyModifier.affectedGameObjectTypePropertyId = ?1")
	List<GameAddonInteractionReceivingPropertyModifierEntity> findAllByAffectedGameObjectTypePropertyId(Long affectedGameObjectTypePropertyId);

	@Query("select distinct gameAddonInteractionReceivingPropertyModifier from GameAddonInteractionReceivingPropertyModifierEntity gameAddonInteractionReceivingPropertyModifier where gameAddonInteractionReceivingPropertyModifier.affectedGameObjectTypePropertyId = ?1 and gameAddonInteractionReceivingPropertyModifier.id in ?2")
    List<GameAddonInteractionReceivingPropertyModifierEntity> findAllByAffectedGameObjectTypePropertyIdAndIds(Long AffectedGameObjectTypePropertyId, List<Long> ids);

	@Transactional
    @Modifying
    @Query("delete GameAddonInteractionReceivingPropertyModifierEntity where affectedGameObjectTypePropertyId = ?1")
    void deleteAllByAffectedGameObjectTypePropertyId(Long affectedGameObjectTypePropertyId);

    @Transactional
    @Modifying
    @Query("delete GameAddonInteractionReceivingPropertyModifierEntity where affectedGameObjectTypePropertyId = ?1 AND id IN ?2")
    void deleteAllByAffectedGameObjectTypePropertyIdAndIds(Long affectedGameObjectTypePropertyId, List<Long> ids);


	@Transactional
    @Modifying
    @Query("delete GameAddonInteractionReceivingPropertyModifierEntity where id IN ?1")
    void deleteAllByIds(List<Long> ids);



	@Query(
		"select distinct gameAddonInteractionReceivingPropertyModifier from GameAddonInteractionReceivingPropertyModifierEntity gameAddonInteractionReceivingPropertyModifier " +
		"where " +
		"(:gameObjectTypeAllowedAddonTypeId is null or gameAddonInteractionReceivingPropertyModifier.gameObjectTypeAllowedAddonTypeId = :gameObjectTypeAllowedAddonTypeId) and " + 
		"(:affectedGameObjectTypePropertyId is null or gameAddonInteractionReceivingPropertyModifier.affectedGameObjectTypePropertyId = :affectedGameObjectTypePropertyId) and " + 
		"(:appliedPropertyValueMultiplier is null or gameAddonInteractionReceivingPropertyModifier.appliedPropertyValueMultiplier = :appliedPropertyValueMultiplier)"
	)
	List<GameAddonInteractionReceivingPropertyModifierEntity> findAllByExample(Long gameObjectTypeAllowedAddonTypeId, Long affectedGameObjectTypePropertyId, Double appliedPropertyValueMultiplier);
}