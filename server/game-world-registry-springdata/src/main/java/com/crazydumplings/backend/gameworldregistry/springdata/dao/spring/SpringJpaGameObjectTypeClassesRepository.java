package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameObjectTypeClassesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeClassEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Spring/JPA implementation of the specification of repository for the GameObjectTypeClass entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaGameObjectTypeClassesRepository
        extends GameObjectTypeClassesRepository, CrudRepository<GameObjectTypeClassEntity, Long> {
    @Query("select distinct gameObjectTypeClass from GameObjectTypeClassEntity gameObjectTypeClass")
    List<GameObjectTypeClassEntity> findAll();

    @Query("select distinct gameObjectTypeClass from GameObjectTypeClassEntity gameObjectTypeClass where gameObjectTypeClass.id = ?1")
    GameObjectTypeClassEntity findOneById(Long id);

    @Query("select distinct gameObjectTypeClass from GameObjectTypeClassEntity gameObjectTypeClass where gameObjectTypeClass.name = ?1")
    GameObjectTypeClassEntity findOneByName(String name);

    @Query("select distinct gameObjectTypeClass from GameObjectTypeClassEntity gameObjectTypeClass " + "where "
            + "gameObjectTypeClass.name like '%' + ?1 + '%' ")
    List<GameObjectTypeClassEntity> findAllByAnyTextFieldContaining(String content);

    @Query("select distinct gameObjectTypeClass from GameObjectTypeClassEntity gameObjectTypeClass " + "where "
            + "(:name is null or gameObjectTypeClass.name = :name)")
    List<GameObjectTypeClassEntity> findAllByExample(String name);
}