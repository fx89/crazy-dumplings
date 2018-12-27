package com.crazydumplings.backend.gameworldregistry.springdata.dao;

import java.util.List;

import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.ActionEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Repository specification for the Action entity")
public interface ActionsRepository {
    List<ActionEntity> findAll();

    ActionEntity findOneById(Long id);

    ActionEntity findOneByUniqueName(String uniqueName);

    List<ActionEntity> findAllByAnyTextFieldContaining(String content);

    List<ActionEntity> findAllByExample(String uniqueName);

    ActionEntity save(ActionEntity action);

    void delete(ActionEntity action);
}