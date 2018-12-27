package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.ActionsRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.ActionEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Spring/JPA implementation of the specification of repository for the Action entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaActionsRepository extends ActionsRepository, CrudRepository<ActionEntity, Long> {
    @Query("select distinct action from ActionEntity action")
    List<ActionEntity> findAll();

    @Query("select distinct action from ActionEntity action where action.id = ?1")
    ActionEntity findOneById(Long id);

    @Query("select distinct action from ActionEntity action where action.uniqueName = ?1")
    ActionEntity findOneByUniqueName(String uniqueName);

    @Query("select distinct action from ActionEntity action " + "where " + "action.uniqueName like '%' + ?1 + '%' ")
    List<ActionEntity> findAllByAnyTextFieldContaining(String content);

    @Query("select distinct action from ActionEntity action " + "where " + "(:uniqueName is null or action.uniqueName = :uniqueName)")
    List<ActionEntity> findAllByExample(String uniqueName);
}