package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameObjectTypesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameAssetsRepositoryEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeClassEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Spring/JPA implementation of the specification of repository for the GameObjectType entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaGameObjectTypesRepository extends GameObjectTypesRepository, CrudRepository<GameObjectTypeEntity, Long> {
    @Query("select distinct gameObjectType from GameObjectTypeEntity gameObjectType left join fetch gameObjectType.gameAssetsRepository left join fetch gameObjectType.gameObjectTypeClass")
    List<GameObjectTypeEntity> findAll();

    @Query("select distinct gameObjectType from GameObjectTypeEntity gameObjectType left join fetch gameObjectType.gameAssetsRepository left join fetch gameObjectType.gameObjectTypeClass where gameObjectType.id = ?1")
    GameObjectTypeEntity findOneById(Long id);

    @Query("select distinct gameObjectType from GameObjectTypeEntity gameObjectType left join fetch gameObjectType.gameAssetsRepository left join fetch gameObjectType.gameObjectTypeClass where gameObjectType.gameAssetsRepository = ?1")
    List<GameObjectTypeEntity> findAllByGameAssetsRepository(GameAssetsRepositoryEntity gameAssetsRepository);

    @Query("select distinct gameObjectType from GameObjectTypeEntity gameObjectType left join fetch gameObjectType.gameAssetsRepository left join fetch gameObjectType.gameObjectTypeClass where gameObjectType.gameObjectTypeClass = ?1")
    List<GameObjectTypeEntity> findAllByGameObjectTypeClass(GameObjectTypeClassEntity gameObjectTypeClass);

    @Query("select distinct gameObjectType from GameObjectTypeEntity gameObjectType left join fetch gameObjectType.gameAssetsRepository left join fetch gameObjectType.gameObjectTypeClass where gameObjectType.uniqueName = ?1")
    GameObjectTypeEntity findOneByUniqueName(String uniqueName);

    @Query("select distinct gameObjectType from GameObjectTypeEntity gameObjectType left join fetch gameObjectType.gameAssetsRepository left join fetch gameObjectType.gameObjectTypeClass "
            + "where " + "gameObjectType.uniqueName like '%' + ?1 + '%' or "
            + "gameObjectType.gameAssetsRepository.uniqueName like '%' + ?1 + '%' or "
            + "gameObjectType.gameObjectTypeClass.name like '%' + ?1 + '%' ")
    List<GameObjectTypeEntity> findAllByAnyTextFieldContaining(String content);

    @Query("select distinct gameObjectType from GameObjectTypeEntity gameObjectType left join fetch gameObjectType.gameAssetsRepository left join fetch gameObjectType.gameObjectTypeClass "
            + "where " + "(:gameAssetsRepository is null or gameObjectType.gameAssetsRepository = :gameAssetsRepository) and"
            + "(:gameObjectTypeClass is null or gameObjectType.gameObjectTypeClass = :gameObjectTypeClass) and"
            + "(:uniqueName is null or gameObjectType.uniqueName = :uniqueName) and"
            + "(:isExperimental is null or gameObjectType.isExperimental = :isExperimental)")
    List<GameObjectTypeEntity> findAllByExample(GameAssetsRepositoryEntity gameAssetsRepository, GameObjectTypeClassEntity gameObjectTypeClass,
            String uniqueName, Boolean isExperimental);
}