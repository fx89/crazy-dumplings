package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.AutomationObjectProvidersRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.AutomationObjectProviderEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Spring/JPA implementation of the specification of repository for the AutomationObjectProvider entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaAutomationObjectProvidersRepository
        extends AutomationObjectProvidersRepository, CrudRepository<AutomationObjectProviderEntity, Long> {
    @Query("select distinct automationObjectProvider from AutomationObjectProviderEntity automationObjectProvider")
    List<AutomationObjectProviderEntity> findAll();

    @Query("select distinct automationObjectProvider from AutomationObjectProviderEntity automationObjectProvider where automationObjectProvider.id = ?1")
    AutomationObjectProviderEntity findOneById(Long id);

    @Query("select distinct automationObjectProvider from AutomationObjectProviderEntity automationObjectProvider where automationObjectProvider.name = ?1")
    AutomationObjectProviderEntity findOneByName(String name);

    @Query("select distinct automationObjectProvider from AutomationObjectProviderEntity automationObjectProvider " + "where "
            + "automationObjectProvider.name like '%' + ?1 + '%' ")
    List<AutomationObjectProviderEntity> findAllByAnyTextFieldContaining(String content);

    @Query("select distinct automationObjectProvider from AutomationObjectProviderEntity automationObjectProvider " + "where "
            + "(:name is null or automationObjectProvider.name = :name)")
    List<AutomationObjectProviderEntity> findAllByExample(String name);
}