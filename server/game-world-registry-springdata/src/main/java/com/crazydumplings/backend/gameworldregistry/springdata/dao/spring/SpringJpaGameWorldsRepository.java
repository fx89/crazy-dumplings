package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameWorldsRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameWorldEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Spring/JPA implementation of the specification of repository for the GameWorld entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaGameWorldsRepository extends GameWorldsRepository, CrudRepository<GameWorldEntity, Long> {
    @Query("select distinct gameWorld from GameWorldEntity gameWorld")
    List<GameWorldEntity> findAll();

    @Query("select distinct gameWorld from GameWorldEntity gameWorld where gameWorld.id = ?1")
    GameWorldEntity findOneById(Long id);

    @Query("select distinct gameWorld from GameWorldEntity gameWorld where gameWorld.uniqueName = ?1")
    GameWorldEntity findOneByUniqueName(String uniqueName);

    @Query("select distinct gameWorld from GameWorldEntity gameWorld " + "where " + "gameWorld.uniqueName like '%' + ?1 + '%' or "
            + "gameWorld.description like '%' + ?1 + '%' or " + "gameWorld.pictureRefPath like '%' + ?1 + '%' ")
    List<GameWorldEntity> findAllByAnyTextFieldContaining(String content);

    @Query("select distinct gameWorld from GameWorldEntity gameWorld " + "where "
            + "(:uniqueName is null or gameWorld.uniqueName = :uniqueName) and"
            + "(:description is null or gameWorld.description = :description) and"
            + "(:pictureRefPath is null or gameWorld.pictureRefPath = :pictureRefPath) and" + "(:width is null or gameWorld.width = :width) and"
            + "(:height is null or gameWorld.height = :height)")
    List<GameWorldEntity> findAllByExample(String uniqueName, String description, String pictureRefPath, Integer width, Integer height);
}