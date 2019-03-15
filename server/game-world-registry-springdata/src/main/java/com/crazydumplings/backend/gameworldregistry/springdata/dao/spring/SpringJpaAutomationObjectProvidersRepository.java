package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;


import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.AutomationObjectProviderEntity;

@Generated(value="fx.codegen.builder version 1.0.0", comments="Spring/JPA implementation of the specification of repository for the AutomationObjectProvider entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaAutomationObjectProvidersRepository extends CrudRepository<AutomationObjectProviderEntity, Long> {

	@Query("select distinct automationObjectProvider from AutomationObjectProviderEntity automationObjectProvider where automationObjectProvider.name = ?1")
	AutomationObjectProviderEntity findOneByName(String name);


	@Transactional
    @Modifying
    @Query("delete AutomationObjectProviderEntity where id IN ?1")
    void deleteAllByIds(List<Long> ids);



	@Query(
		"select distinct automationObjectProvider from AutomationObjectProviderEntity automationObjectProvider " +
		"where " +
		"(:name is null or automationObjectProvider.name = :name)"
	)
	List<AutomationObjectProviderEntity> findAllByExample(String name);
}