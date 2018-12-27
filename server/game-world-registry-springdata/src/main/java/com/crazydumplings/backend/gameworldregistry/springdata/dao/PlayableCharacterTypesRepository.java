package com.crazydumplings.backend.gameworldregistry.springdata.dao;

import java.util.List;

import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.PlayableCharacterTypeEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Repository specification for the PlayableCharacterType entity")
public interface PlayableCharacterTypesRepository {
    List<PlayableCharacterTypeEntity> findAll();

    PlayableCharacterTypeEntity findOneById(Long id);

    PlayableCharacterTypeEntity findOneByUniqueCharacterTypeName(String uniqueCharacterTypeName);

    List<PlayableCharacterTypeEntity> findAllByGameObjectType(GameObjectTypeEntity gameObjectType);

    List<PlayableCharacterTypeEntity> findAllByAnyTextFieldContaining(String content);

    List<PlayableCharacterTypeEntity> findAllByExample(String uniqueCharacterTypeName, GameObjectTypeEntity gameObjectType);

    PlayableCharacterTypeEntity save(PlayableCharacterTypeEntity playableCharacterType);

    void delete(PlayableCharacterTypeEntity playableCharacterType);
}