package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;


import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypePropertyInstanceEntity;

@Generated(value="fx.codegen.builder version 1.0.0", comments="Spring/JPA implementation of the specification of repository for the GameObjectTypePropertyInstance entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaGameObjectTypePropertyInstancesRepository extends CrudRepository<GameObjectTypePropertyInstanceEntity, Long> {

	@Query("select distinct gameObjectTypePropertyInstance from GameObjectTypePropertyInstanceEntity gameObjectTypePropertyInstance where gameObjectTypePropertyInstance.gameObjectTypeId = ?1")
	List<GameObjectTypePropertyInstanceEntity> findAllByGameObjectTypeId(Long gameObjectTypeId);

	@Query("select distinct gameObjectTypePropertyInstance from GameObjectTypePropertyInstanceEntity gameObjectTypePropertyInstance where gameObjectTypePropertyInstance.gameObjectTypeId = ?1 and gameObjectTypePropertyInstance.id in ?2")
    List<GameObjectTypePropertyInstanceEntity> findAllByGameObjectTypeIdAndIds(Long GameObjectTypeId, List<Long> ids);

	@Transactional
    @Modifying
    @Query("delete GameObjectTypePropertyInstanceEntity where gameObjectTypeId = ?1")
    void deleteAllByGameObjectTypeId(Long gameObjectTypeId);

    @Transactional
    @Modifying
    @Query("delete GameObjectTypePropertyInstanceEntity where gameObjectTypeId = ?1 AND id IN ?2")
    void deleteAllByGameObjectTypeIdAndIds(Long gameObjectTypeId, List<Long> ids);

	@Query("select distinct gameObjectTypePropertyInstance from GameObjectTypePropertyInstanceEntity gameObjectTypePropertyInstance where gameObjectTypePropertyInstance.gameObjectTypePropertyId = ?1")
	List<GameObjectTypePropertyInstanceEntity> findAllByGameObjectTypePropertyId(Long gameObjectTypePropertyId);

	@Query("select distinct gameObjectTypePropertyInstance from GameObjectTypePropertyInstanceEntity gameObjectTypePropertyInstance where gameObjectTypePropertyInstance.gameObjectTypePropertyId = ?1 and gameObjectTypePropertyInstance.id in ?2")
    List<GameObjectTypePropertyInstanceEntity> findAllByGameObjectTypePropertyIdAndIds(Long GameObjectTypePropertyId, List<Long> ids);

	@Transactional
    @Modifying
    @Query("delete GameObjectTypePropertyInstanceEntity where gameObjectTypePropertyId = ?1")
    void deleteAllByGameObjectTypePropertyId(Long gameObjectTypePropertyId);

    @Transactional
    @Modifying
    @Query("delete GameObjectTypePropertyInstanceEntity where gameObjectTypePropertyId = ?1 AND id IN ?2")
    void deleteAllByGameObjectTypePropertyIdAndIds(Long gameObjectTypePropertyId, List<Long> ids);


	@Transactional
    @Modifying
    @Query("delete GameObjectTypePropertyInstanceEntity where id IN ?1")
    void deleteAllByIds(List<Long> ids);



	@Query(
		"select distinct gameObjectTypePropertyInstance from GameObjectTypePropertyInstanceEntity gameObjectTypePropertyInstance " +
		"where " +
		"(:gameObjectTypeId is null or gameObjectTypePropertyInstance.gameObjectTypeId = :gameObjectTypeId) and " + 
		"(:gameObjectTypePropertyId is null or gameObjectTypePropertyInstance.gameObjectTypePropertyId = :gameObjectTypePropertyId) and " + 
		"(:propertyDefaultValue is null or gameObjectTypePropertyInstance.propertyDefaultValue = :propertyDefaultValue) and " + 
		"(:propertyMinValue is null or gameObjectTypePropertyInstance.propertyMinValue = :propertyMinValue) and " + 
		"(:propertyMaxValue is null or gameObjectTypePropertyInstance.propertyMaxValue = :propertyMaxValue)"
	)
	List<GameObjectTypePropertyInstanceEntity> findAllByExample(Long gameObjectTypeId, Long gameObjectTypePropertyId, Double propertyDefaultValue, Double propertyMinValue, Double propertyMaxValue);
}