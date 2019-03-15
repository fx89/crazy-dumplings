package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;


import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameWorldCellPropertyEntity;

@Generated(value="fx.codegen.builder version 1.0.0", comments="Spring/JPA implementation of the specification of repository for the GameWorldCellProperty entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaGameWorldCellPropertiesRepository extends CrudRepository<GameWorldCellPropertyEntity, Long> {

	@Query("select distinct gameWorldCellProperty from GameWorldCellPropertyEntity gameWorldCellProperty where gameWorldCellProperty.gameWorldCellId = ?1")
	List<GameWorldCellPropertyEntity> findAllByGameWorldCellId(Long gameWorldCellId);

	@Query("select distinct gameWorldCellProperty from GameWorldCellPropertyEntity gameWorldCellProperty where gameWorldCellProperty.gameWorldCellId = ?1 and gameWorldCellProperty.id in ?2")
    List<GameWorldCellPropertyEntity> findAllByGameWorldCellIdAndIds(Long GameWorldCellId, List<Long> ids);

	@Transactional
    @Modifying
    @Query("delete GameWorldCellPropertyEntity where gameWorldCellId = ?1")
    void deleteAllByGameWorldCellId(Long gameWorldCellId);

    @Transactional
    @Modifying
    @Query("delete GameWorldCellPropertyEntity where gameWorldCellId = ?1 AND id IN ?2")
    void deleteAllByGameWorldCellIdAndIds(Long gameWorldCellId, List<Long> ids);

	@Query("select distinct gameWorldCellProperty from GameWorldCellPropertyEntity gameWorldCellProperty where gameWorldCellProperty.gameObjectTypePropertyId = ?1")
	List<GameWorldCellPropertyEntity> findAllByGameObjectTypePropertyId(Long gameObjectTypePropertyId);

	@Query("select distinct gameWorldCellProperty from GameWorldCellPropertyEntity gameWorldCellProperty where gameWorldCellProperty.gameObjectTypePropertyId = ?1 and gameWorldCellProperty.id in ?2")
    List<GameWorldCellPropertyEntity> findAllByGameObjectTypePropertyIdAndIds(Long GameObjectTypePropertyId, List<Long> ids);

	@Transactional
    @Modifying
    @Query("delete GameWorldCellPropertyEntity where gameObjectTypePropertyId = ?1")
    void deleteAllByGameObjectTypePropertyId(Long gameObjectTypePropertyId);

    @Transactional
    @Modifying
    @Query("delete GameWorldCellPropertyEntity where gameObjectTypePropertyId = ?1 AND id IN ?2")
    void deleteAllByGameObjectTypePropertyIdAndIds(Long gameObjectTypePropertyId, List<Long> ids);


	@Transactional
    @Modifying
    @Query("delete GameWorldCellPropertyEntity where id IN ?1")
    void deleteAllByIds(List<Long> ids);



	@Query(
		"select distinct gameWorldCellProperty from GameWorldCellPropertyEntity gameWorldCellProperty " +
		"where " +
		"(:gameWorldCellId is null or gameWorldCellProperty.gameWorldCellId = :gameWorldCellId) and " + 
		"(:gameObjectTypePropertyId is null or gameWorldCellProperty.gameObjectTypePropertyId = :gameObjectTypePropertyId) and " + 
		"(:propertyActualValue is null or gameWorldCellProperty.propertyActualValue = :propertyActualValue)"
	)
	List<GameWorldCellPropertyEntity> findAllByExample(Long gameWorldCellId, Long gameObjectTypePropertyId, Double propertyActualValue);
}