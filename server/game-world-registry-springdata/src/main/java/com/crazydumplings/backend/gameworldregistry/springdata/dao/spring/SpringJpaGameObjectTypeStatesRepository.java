package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import java.util.List;

import javax.annotation.Generated;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameObjectTypeStatesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeStateEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Spring/JPA implementation of the specification of repository for the GameObjectTypeState entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaGameObjectTypeStatesRepository
        extends GameObjectTypeStatesRepository, CrudRepository<GameObjectTypeStateEntity, Long> {
    @Query("select distinct gameObjectTypeState from GameObjectTypeStateEntity gameObjectTypeState left join fetch gameObjectTypeState.gameObjectType")
    List<GameObjectTypeStateEntity> findAll();

    @Query("select distinct gameObjectTypeState from GameObjectTypeStateEntity gameObjectTypeState left join fetch gameObjectTypeState.gameObjectType where gameObjectTypeState.id = ?1")
    GameObjectTypeStateEntity findOneById(Long id);

    @Query("select distinct gameObjectTypeState from GameObjectTypeStateEntity gameObjectTypeState left join fetch gameObjectTypeState.gameObjectType where gameObjectTypeState.gameObjectType = ?1")
    List<GameObjectTypeStateEntity> findAllByGameObjectType(GameObjectTypeEntity gameObjectType);

    @Query("select distinct gameObjectTypeState from GameObjectTypeStateEntity gameObjectTypeState left join fetch gameObjectTypeState.gameObjectType where gameObjectTypeState.name = ?1")
    GameObjectTypeStateEntity findOneByName(String name);

    @Query("select distinct gameObjectTypeState from GameObjectTypeStateEntity gameObjectTypeState left join fetch gameObjectTypeState.gameObjectType "
            + "where " + "gameObjectTypeState.name like '%' + ?1 + '%' or "
            + "gameObjectTypeState.gameObjectType.uniqueName like '%' + ?1 + '%' ")
    List<GameObjectTypeStateEntity> findAllByAnyTextFieldContaining(String content);

    @Query("select distinct gameObjectTypeState from GameObjectTypeStateEntity gameObjectTypeState left join fetch gameObjectTypeState.gameObjectType "
            + "where " + "(:gameObjectType is null or gameObjectTypeState.gameObjectType = :gameObjectType) and"
            + "(:name is null or gameObjectTypeState.name = :name)")
    List<GameObjectTypeStateEntity> findAllByExample(GameObjectTypeEntity gameObjectType, String name);

    @Query("select distinct gameObjectTypeState from GameObjectTypeStateEntity gameObjectTypeState left join fetch gameObjectTypeState.gameObjectType where gameObjectTypeState.gameObjectType = ?1 and gameObjectTypeState.id in ?2")
    List<GameObjectTypeStateEntity> findAllByGameObjectTypeAndIds(GameObjectTypeEntity gameObjectType, List<Long> ids);

    @Transactional
    @Modifying
    @Query("delete GameObjectTypeStateEntity where id in ?1")
    void bulkDelete(List<Long> gameObjectTypeStateIds);
}