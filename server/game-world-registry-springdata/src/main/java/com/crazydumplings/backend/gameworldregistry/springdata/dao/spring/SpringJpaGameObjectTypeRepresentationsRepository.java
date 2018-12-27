package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameObjectTypeRepresentationsRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameClientTypeEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeRepresentationEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Spring/JPA implementation of the specification of repository for the GameObjectTypeRepresentation entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaGameObjectTypeRepresentationsRepository
        extends GameObjectTypeRepresentationsRepository, CrudRepository<GameObjectTypeRepresentationEntity, Long> {
    @Query("select distinct gameObjectTypeRepresentation from GameObjectTypeRepresentationEntity gameObjectTypeRepresentation left join fetch gameObjectTypeRepresentation.gameObjectType left join fetch gameObjectTypeRepresentation.gameClientType")
    List<GameObjectTypeRepresentationEntity> findAll();

    @Query("select distinct gameObjectTypeRepresentation from GameObjectTypeRepresentationEntity gameObjectTypeRepresentation left join fetch gameObjectTypeRepresentation.gameObjectType left join fetch gameObjectTypeRepresentation.gameClientType where gameObjectTypeRepresentation.id = ?1")
    GameObjectTypeRepresentationEntity findOneById(Long id);

    @Query("select distinct gameObjectTypeRepresentation from GameObjectTypeRepresentationEntity gameObjectTypeRepresentation left join fetch gameObjectTypeRepresentation.gameObjectType left join fetch gameObjectTypeRepresentation.gameClientType where gameObjectTypeRepresentation.gameObjectType = ?1")
    List<GameObjectTypeRepresentationEntity> findAllByGameObjectType(GameObjectTypeEntity gameObjectType);

    @Query("select distinct gameObjectTypeRepresentation from GameObjectTypeRepresentationEntity gameObjectTypeRepresentation left join fetch gameObjectTypeRepresentation.gameObjectType left join fetch gameObjectTypeRepresentation.gameClientType where gameObjectTypeRepresentation.gameClientType = ?1")
    List<GameObjectTypeRepresentationEntity> findAllByGameClientType(GameClientTypeEntity gameClientType);

    @Query("select distinct gameObjectTypeRepresentation from GameObjectTypeRepresentationEntity gameObjectTypeRepresentation left join fetch gameObjectTypeRepresentation.gameObjectType left join fetch gameObjectTypeRepresentation.gameClientType "
            + "where " + "gameObjectTypeRepresentation.gameObjectType.uniqueName like '%' + ?1 + '%' or "
            + "gameObjectTypeRepresentation.gameClientType.uniqueName like '%' + ?1 + '%' ")
    List<GameObjectTypeRepresentationEntity> findAllByAnyTextFieldContaining(String content);

    @Query("select distinct gameObjectTypeRepresentation from GameObjectTypeRepresentationEntity gameObjectTypeRepresentation left join fetch gameObjectTypeRepresentation.gameObjectType left join fetch gameObjectTypeRepresentation.gameClientType "
            + "where " + "(:gameObjectType is null or gameObjectTypeRepresentation.gameObjectType = ?1) and"
            + "(:gameClientType is null or gameObjectTypeRepresentation.gameClientType = ?1)")
    List<GameObjectTypeRepresentationEntity> findAllByExample(GameObjectTypeEntity gameObjectType, GameClientTypeEntity gameClientType);
}