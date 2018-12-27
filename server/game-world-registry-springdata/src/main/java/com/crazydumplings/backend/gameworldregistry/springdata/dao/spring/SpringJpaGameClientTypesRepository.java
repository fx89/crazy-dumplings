package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameClientTypesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameClientTypeEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Spring/JPA implementation of the specification of repository for the GameClientType entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaGameClientTypesRepository extends GameClientTypesRepository, CrudRepository<GameClientTypeEntity, Long> {
    @Query("select distinct gameClientType from GameClientTypeEntity gameClientType")
    List<GameClientTypeEntity> findAll();

    @Query("select distinct gameClientType from GameClientTypeEntity gameClientType where gameClientType.id = ?1")
    GameClientTypeEntity findOneById(Long id);

    @Query("select distinct gameClientType from GameClientTypeEntity gameClientType where gameClientType.uniqueName = ?1")
    GameClientTypeEntity findOneByUniqueName(String uniqueName);

    @Query("select distinct gameClientType from GameClientTypeEntity gameClientType " + "where "
            + "gameClientType.uniqueName like '%' + ?1 + '%' ")
    List<GameClientTypeEntity> findAllByAnyTextFieldContaining(String content);

    @Query("select distinct gameClientType from GameClientTypeEntity gameClientType " + "where "
            + "(:uniqueName is null or gameClientType.uniqueName = :uniqueName)")
    List<GameClientTypeEntity> findAllByExample(String uniqueName);
}