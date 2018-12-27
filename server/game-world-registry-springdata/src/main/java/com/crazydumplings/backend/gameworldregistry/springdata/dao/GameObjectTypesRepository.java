package com.crazydumplings.backend.gameworldregistry.springdata.dao;

import java.util.List;

import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameAssetsRepositoryEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeClassEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Repository specification for the GameObjectType entity")
public interface GameObjectTypesRepository {
    List<GameObjectTypeEntity> findAll();

    GameObjectTypeEntity findOneById(Long id);

    List<GameObjectTypeEntity> findAllByGameAssetsRepository(GameAssetsRepositoryEntity gameAssetsRepository);

    List<GameObjectTypeEntity> findAllByGameObjectTypeClass(GameObjectTypeClassEntity gameObjectTypeClass);

    GameObjectTypeEntity findOneByUniqueName(String uniqueName);

    List<GameObjectTypeEntity> findAllByAnyTextFieldContaining(String content);

    List<GameObjectTypeEntity> findAllByExample(GameAssetsRepositoryEntity gameAssetsRepository, GameObjectTypeClassEntity gameObjectTypeClass,
            String uniqueName, Boolean isExperimental);

    GameObjectTypeEntity save(GameObjectTypeEntity gameObjectType);

    void delete(GameObjectTypeEntity gameObjectType);
}