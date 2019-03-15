package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;


import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeStatePropertyModifierEntity;

@Generated(value="fx.codegen.builder version 1.0.0", comments="Spring/JPA implementation of the specification of repository for the GameObjectTypeStatePropertyModifier entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaGameObjectTypeStatePropertyModifiersRepository extends CrudRepository<GameObjectTypeStatePropertyModifierEntity, Long> {

	@Query("select distinct gameObjectTypeStatePropertyModifier from GameObjectTypeStatePropertyModifierEntity gameObjectTypeStatePropertyModifier where gameObjectTypeStatePropertyModifier.gameObjectTypeStateId = ?1")
	List<GameObjectTypeStatePropertyModifierEntity> findAllByGameObjectTypeStateId(Long gameObjectTypeStateId);

	@Query("select distinct gameObjectTypeStatePropertyModifier from GameObjectTypeStatePropertyModifierEntity gameObjectTypeStatePropertyModifier where gameObjectTypeStatePropertyModifier.gameObjectTypeStateId = ?1 and gameObjectTypeStatePropertyModifier.id in ?2")
    List<GameObjectTypeStatePropertyModifierEntity> findAllByGameObjectTypeStateIdAndIds(Long GameObjectTypeStateId, List<Long> ids);

	@Transactional
    @Modifying
    @Query("delete GameObjectTypeStatePropertyModifierEntity where gameObjectTypeStateId = ?1")
    void deleteAllByGameObjectTypeStateId(Long gameObjectTypeStateId);

    @Transactional
    @Modifying
    @Query("delete GameObjectTypeStatePropertyModifierEntity where gameObjectTypeStateId = ?1 AND id IN ?2")
    void deleteAllByGameObjectTypeStateIdAndIds(Long gameObjectTypeStateId, List<Long> ids);

	@Query("select distinct gameObjectTypeStatePropertyModifier from GameObjectTypeStatePropertyModifierEntity gameObjectTypeStatePropertyModifier where gameObjectTypeStatePropertyModifier.gameObjectTypePropertyId = ?1")
	List<GameObjectTypeStatePropertyModifierEntity> findAllByGameObjectTypePropertyId(Long gameObjectTypePropertyId);

	@Query("select distinct gameObjectTypeStatePropertyModifier from GameObjectTypeStatePropertyModifierEntity gameObjectTypeStatePropertyModifier where gameObjectTypeStatePropertyModifier.gameObjectTypePropertyId = ?1 and gameObjectTypeStatePropertyModifier.id in ?2")
    List<GameObjectTypeStatePropertyModifierEntity> findAllByGameObjectTypePropertyIdAndIds(Long GameObjectTypePropertyId, List<Long> ids);

	@Transactional
    @Modifying
    @Query("delete GameObjectTypeStatePropertyModifierEntity where gameObjectTypePropertyId = ?1")
    void deleteAllByGameObjectTypePropertyId(Long gameObjectTypePropertyId);

    @Transactional
    @Modifying
    @Query("delete GameObjectTypeStatePropertyModifierEntity where gameObjectTypePropertyId = ?1 AND id IN ?2")
    void deleteAllByGameObjectTypePropertyIdAndIds(Long gameObjectTypePropertyId, List<Long> ids);


	@Transactional
    @Modifying
    @Query("delete GameObjectTypeStatePropertyModifierEntity where id IN ?1")
    void deleteAllByIds(List<Long> ids);



	@Query(
		"select distinct gameObjectTypeStatePropertyModifier from GameObjectTypeStatePropertyModifierEntity gameObjectTypeStatePropertyModifier " +
		"where " +
		"(:gameObjectTypeStateId is null or gameObjectTypeStatePropertyModifier.gameObjectTypeStateId = :gameObjectTypeStateId) and " + 
		"(:gameObjectTypePropertyId is null or gameObjectTypeStatePropertyModifier.gameObjectTypePropertyId = :gameObjectTypePropertyId) and " + 
		"(:propertyActualValue is null or gameObjectTypeStatePropertyModifier.propertyActualValue = :propertyActualValue)"
	)
	List<GameObjectTypeStatePropertyModifierEntity> findAllByExample(Long gameObjectTypeStateId, Long gameObjectTypePropertyId, Double propertyActualValue);
}