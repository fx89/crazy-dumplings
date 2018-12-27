package com.crazydumplings.backend.gameworldregistry.springdata.dao;

import java.util.List;

import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameAssetsRepositoryEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Repository specification for the GameAssetsRepository entity")
public interface GameAssetsRepositoriesRepository {
    List<GameAssetsRepositoryEntity> findAll();

    GameAssetsRepositoryEntity findOneById(Long id);

    GameAssetsRepositoryEntity findOneByUniqueName(String uniqueName);

    List<GameAssetsRepositoryEntity> findAllByAnyTextFieldContaining(String content);

    List<GameAssetsRepositoryEntity> findAllByExample(String uniqueName, String description);

    GameAssetsRepositoryEntity save(GameAssetsRepositoryEntity gameAssetsRepository);

    void delete(GameAssetsRepositoryEntity gameAssetsRepository);
}