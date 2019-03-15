package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;


import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeClassEntity;

@Generated(value="fx.codegen.builder version 1.0.0", comments="Spring/JPA implementation of the specification of repository for the GameObjectTypeClass entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaGameObjectTypeClassesRepository extends CrudRepository<GameObjectTypeClassEntity, Long> {

	@Query("select distinct gameObjectTypeClass from GameObjectTypeClassEntity gameObjectTypeClass where gameObjectTypeClass.name = ?1")
	GameObjectTypeClassEntity findOneByName(String name);


	@Transactional
    @Modifying
    @Query("delete GameObjectTypeClassEntity where id IN ?1")
    void deleteAllByIds(List<Long> ids);



	@Query(
		"select distinct gameObjectTypeClass from GameObjectTypeClassEntity gameObjectTypeClass " +
		"where " +
		"(:name is null or gameObjectTypeClass.name = :name)"
	)
	List<GameObjectTypeClassEntity> findAllByExample(String name);
}