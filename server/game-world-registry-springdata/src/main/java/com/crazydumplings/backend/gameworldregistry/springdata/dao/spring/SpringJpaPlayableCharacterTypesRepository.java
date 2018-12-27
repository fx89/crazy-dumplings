package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.PlayableCharacterTypesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.PlayableCharacterTypeEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Spring/JPA implementation of the specification of repository for the PlayableCharacterType entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaPlayableCharacterTypesRepository
        extends PlayableCharacterTypesRepository, CrudRepository<PlayableCharacterTypeEntity, Long> {
    @Query("select distinct playableCharacterType from PlayableCharacterTypeEntity playableCharacterType left join fetch playableCharacterType.gameObjectType")
    List<PlayableCharacterTypeEntity> findAll();

    @Query("select distinct playableCharacterType from PlayableCharacterTypeEntity playableCharacterType left join fetch playableCharacterType.gameObjectType where playableCharacterType.id = ?1")
    PlayableCharacterTypeEntity findOneById(Long id);

    @Query("select distinct playableCharacterType from PlayableCharacterTypeEntity playableCharacterType left join fetch playableCharacterType.gameObjectType where playableCharacterType.uniqueCharacterTypeName = ?1")
    PlayableCharacterTypeEntity findOneByUniqueCharacterTypeName(String uniqueCharacterTypeName);

    @Query("select distinct playableCharacterType from PlayableCharacterTypeEntity playableCharacterType left join fetch playableCharacterType.gameObjectType where playableCharacterType.gameObjectType = ?1")
    List<PlayableCharacterTypeEntity> findAllByGameObjectType(GameObjectTypeEntity gameObjectType);

    @Query("select distinct playableCharacterType from PlayableCharacterTypeEntity playableCharacterType left join fetch playableCharacterType.gameObjectType "
            + "where " + "playableCharacterType.uniqueCharacterTypeName like '%' + ?1 + '%' or "
            + "playableCharacterType.gameObjectType.uniqueName like '%' + ?1 + '%' ")
    List<PlayableCharacterTypeEntity> findAllByAnyTextFieldContaining(String content);

    @Query("select distinct playableCharacterType from PlayableCharacterTypeEntity playableCharacterType left join fetch playableCharacterType.gameObjectType "
            + "where " + "(:uniqueCharacterTypeName is null or playableCharacterType.uniqueCharacterTypeName = :uniqueCharacterTypeName) and"
            + "(:gameObjectType is null or playableCharacterType.gameObjectType = :gameObjectType)")
    List<PlayableCharacterTypeEntity> findAllByExample(String uniqueCharacterTypeName, GameObjectTypeEntity gameObjectType);
}