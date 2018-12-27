package com.crazydumplings.backend.gameworldregistry.springdata.dao;

import java.util.List;

import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameWorldEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Repository specification for the GameWorld entity")
public interface GameWorldsRepository {
    List<GameWorldEntity> findAll();

    GameWorldEntity findOneById(Long id);

    GameWorldEntity findOneByUniqueName(String uniqueName);

    List<GameWorldEntity> findAllByAnyTextFieldContaining(String content);

    List<GameWorldEntity> findAllByExample(String uniqueName, String description, String pictureRefPath, Integer width, Integer height);

    GameWorldEntity save(GameWorldEntity gameWorld);

    void delete(GameWorldEntity gameWorld);
}