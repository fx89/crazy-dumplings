package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;


import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypePropertyEntity;

@Generated(value="fx.codegen.builder version 1.0.0", comments="Spring/JPA implementation of the specification of repository for the GameObjectTypeProperty entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaGameObjectTypePropertiesRepository extends CrudRepository<GameObjectTypePropertyEntity, Long> {

	@Query("select distinct gameObjectTypeProperty from GameObjectTypePropertyEntity gameObjectTypeProperty where gameObjectTypeProperty.gameObjectTypeId = ?1")
	List<GameObjectTypePropertyEntity> findAllByGameObjectTypeId(Long gameObjectTypeId);

	@Query("select distinct gameObjectTypeProperty from GameObjectTypePropertyEntity gameObjectTypeProperty where gameObjectTypeProperty.gameObjectTypeId = ?1 and gameObjectTypeProperty.id in ?2")
    List<GameObjectTypePropertyEntity> findAllByGameObjectTypeIdAndIds(Long GameObjectTypeId, List<Long> ids);

	@Transactional
    @Modifying
    @Query("delete GameObjectTypePropertyEntity where gameObjectTypeId = ?1")
    void deleteAllByGameObjectTypeId(Long gameObjectTypeId);

    @Transactional
    @Modifying
    @Query("delete GameObjectTypePropertyEntity where gameObjectTypeId = ?1 AND id IN ?2")
    void deleteAllByGameObjectTypeIdAndIds(Long gameObjectTypeId, List<Long> ids);

	@Query("select distinct gameObjectTypeProperty from GameObjectTypePropertyEntity gameObjectTypeProperty where gameObjectTypeProperty.propertyName = ?1")
	GameObjectTypePropertyEntity findOneByPropertyName(String propertyName);


	@Transactional
    @Modifying
    @Query("delete GameObjectTypePropertyEntity where id IN ?1")
    void deleteAllByIds(List<Long> ids);



	@Query(
		"select distinct gameObjectTypeProperty from GameObjectTypePropertyEntity gameObjectTypeProperty " +
		"where " +
		"(:gameObjectTypeId is null or gameObjectTypeProperty.gameObjectTypeId = :gameObjectTypeId) and " + 
		"(:propertyName is null or gameObjectTypeProperty.propertyName = :propertyName)"
	)
	List<GameObjectTypePropertyEntity> findAllByExample(Long gameObjectTypeId, String propertyName);
}