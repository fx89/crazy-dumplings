package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;


import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameClientTypeEntity;

@Generated(value="fx.codegen.builder version 1.0.0", comments="Spring/JPA implementation of the specification of repository for the GameClientType entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaGameClientTypesRepository extends CrudRepository<GameClientTypeEntity, Long> {

	@Query("select distinct gameClientType from GameClientTypeEntity gameClientType where gameClientType.uniqueName = ?1")
	GameClientTypeEntity findOneByUniqueName(String uniqueName);


	@Transactional
    @Modifying
    @Query("delete GameClientTypeEntity where id IN ?1")
    void deleteAllByIds(List<Long> ids);



	@Query(
		"select distinct gameClientType from GameClientTypeEntity gameClientType " +
		"where " +
		"(:uniqueName is null or gameClientType.uniqueName = :uniqueName)"
	)
	List<GameClientTypeEntity> findAllByExample(String uniqueName);
}