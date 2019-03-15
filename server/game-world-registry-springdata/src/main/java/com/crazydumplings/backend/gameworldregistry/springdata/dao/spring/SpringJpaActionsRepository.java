package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;


import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.ActionEntity;

@Generated(value="fx.codegen.builder version 1.0.0", comments="Spring/JPA implementation of the specification of repository for the Action entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaActionsRepository extends CrudRepository<ActionEntity, Long> {

	@Query("select distinct action from ActionEntity action where action.uniqueName = ?1")
	ActionEntity findOneByUniqueName(String uniqueName);


	@Transactional
    @Modifying
    @Query("delete ActionEntity where id IN ?1")
    void deleteAllByIds(List<Long> ids);



	@Query(
		"select distinct action from ActionEntity action " +
		"where " +
		"(:uniqueName is null or action.uniqueName = :uniqueName)"
	)
	List<ActionEntity> findAllByExample(String uniqueName);
}