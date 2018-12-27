package com.crazydumplings.backend.gameworldregistry.springdata.dao;

import java.util.List;

import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameClientTypeEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Repository specification for the GameClientType entity")
public interface GameClientTypesRepository {
    List<GameClientTypeEntity> findAll();

    GameClientTypeEntity findOneById(Long id);

    GameClientTypeEntity findOneByUniqueName(String uniqueName);

    List<GameClientTypeEntity> findAllByAnyTextFieldContaining(String content);

    List<GameClientTypeEntity> findAllByExample(String uniqueName);

    GameClientTypeEntity save(GameClientTypeEntity gameClientType);

    void delete(GameClientTypeEntity gameClientType);
}