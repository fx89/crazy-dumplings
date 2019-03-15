package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;


import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeStateEntity;

@Generated(value="fx.codegen.builder version 1.0.0", comments="Spring/JPA implementation of the specification of repository for the GameObjectTypeState entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaGameObjectTypeStatesRepository extends CrudRepository<GameObjectTypeStateEntity, Long> {

	@Query("select distinct gameObjectTypeState from GameObjectTypeStateEntity gameObjectTypeState where gameObjectTypeState.gameObjectTypeId = ?1")
	List<GameObjectTypeStateEntity> findAllByGameObjectTypeId(Long gameObjectTypeId);

	@Query("select distinct gameObjectTypeState from GameObjectTypeStateEntity gameObjectTypeState where gameObjectTypeState.gameObjectTypeId = ?1 and gameObjectTypeState.id in ?2")
    List<GameObjectTypeStateEntity> findAllByGameObjectTypeIdAndIds(Long GameObjectTypeId, List<Long> ids);

	@Transactional
    @Modifying
    @Query("delete GameObjectTypeStateEntity where gameObjectTypeId = ?1")
    void deleteAllByGameObjectTypeId(Long gameObjectTypeId);

    @Transactional
    @Modifying
    @Query("delete GameObjectTypeStateEntity where gameObjectTypeId = ?1 AND id IN ?2")
    void deleteAllByGameObjectTypeIdAndIds(Long gameObjectTypeId, List<Long> ids);

	@Query("select distinct gameObjectTypeState from GameObjectTypeStateEntity gameObjectTypeState where gameObjectTypeState.name = ?1")
	GameObjectTypeStateEntity findOneByName(String name);


	@Transactional
    @Modifying
    @Query("delete GameObjectTypeStateEntity where id IN ?1")
    void deleteAllByIds(List<Long> ids);



	@Query(
		"select distinct gameObjectTypeState from GameObjectTypeStateEntity gameObjectTypeState " +
		"where " +
		"(:gameObjectTypeId is null or gameObjectTypeState.gameObjectTypeId = :gameObjectTypeId) and " + 
		"(:name is null or gameObjectTypeState.name = :name)"
	)
	List<GameObjectTypeStateEntity> findAllByExample(Long gameObjectTypeId, String name);
}