package com.crazydumplings.backend.gameworldregistry.springdata.dao;

import java.util.List;

import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.AutomationObjectProviderEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Repository specification for the AutomationObjectProvider entity")
public interface AutomationObjectProvidersRepository {
    List<AutomationObjectProviderEntity> findAll();

    AutomationObjectProviderEntity findOneById(Long id);

    AutomationObjectProviderEntity findOneByName(String name);

    List<AutomationObjectProviderEntity> findAllByAnyTextFieldContaining(String content);

    List<AutomationObjectProviderEntity> findAllByExample(String name);

    AutomationObjectProviderEntity save(AutomationObjectProviderEntity automationObjectProvider);

    void delete(AutomationObjectProviderEntity automationObjectProvider);
}