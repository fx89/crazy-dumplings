package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;


import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeEntity;

@Generated(value="fx.codegen.builder version 1.0.0", comments="Spring/JPA implementation of the specification of repository for the GameObjectType entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaGameObjectTypesRepository extends CrudRepository<GameObjectTypeEntity, Long> {

	@Query("select distinct gameObjectType from GameObjectTypeEntity gameObjectType where gameObjectType.gameAssetsRepositoryId = ?1")
	List<GameObjectTypeEntity> findAllByGameAssetsRepositoryId(Long gameAssetsRepositoryId);

	@Query("select distinct gameObjectType from GameObjectTypeEntity gameObjectType where gameObjectType.gameAssetsRepositoryId = ?1 and gameObjectType.id in ?2")
    List<GameObjectTypeEntity> findAllByGameAssetsRepositoryIdAndIds(Long GameAssetsRepositoryId, List<Long> ids);

	@Transactional
    @Modifying
    @Query("delete GameObjectTypeEntity where gameAssetsRepositoryId = ?1")
    void deleteAllByGameAssetsRepositoryId(Long gameAssetsRepositoryId);

    @Transactional
    @Modifying
    @Query("delete GameObjectTypeEntity where gameAssetsRepositoryId = ?1 AND id IN ?2")
    void deleteAllByGameAssetsRepositoryIdAndIds(Long gameAssetsRepositoryId, List<Long> ids);

	@Query("select distinct gameObjectType from GameObjectTypeEntity gameObjectType where gameObjectType.gameObjectTypeClassId = ?1")
	List<GameObjectTypeEntity> findAllByGameObjectTypeClassId(Long gameObjectTypeClassId);

	@Query("select distinct gameObjectType from GameObjectTypeEntity gameObjectType where gameObjectType.gameObjectTypeClassId = ?1 and gameObjectType.id in ?2")
    List<GameObjectTypeEntity> findAllByGameObjectTypeClassIdAndIds(Long GameObjectTypeClassId, List<Long> ids);

	@Transactional
    @Modifying
    @Query("delete GameObjectTypeEntity where gameObjectTypeClassId = ?1")
    void deleteAllByGameObjectTypeClassId(Long gameObjectTypeClassId);

    @Transactional
    @Modifying
    @Query("delete GameObjectTypeEntity where gameObjectTypeClassId = ?1 AND id IN ?2")
    void deleteAllByGameObjectTypeClassIdAndIds(Long gameObjectTypeClassId, List<Long> ids);

	@Query("select distinct gameObjectType from GameObjectTypeEntity gameObjectType where gameObjectType.uniqueName = ?1")
	GameObjectTypeEntity findOneByUniqueName(String uniqueName);


	@Transactional
    @Modifying
    @Query("delete GameObjectTypeEntity where id IN ?1")
    void deleteAllByIds(List<Long> ids);



	@Query(
		"select distinct gameObjectType from GameObjectTypeEntity gameObjectType " +
		"where " +
		"(:gameAssetsRepositoryId is null or gameObjectType.gameAssetsRepositoryId = :gameAssetsRepositoryId) and " + 
		"(:gameObjectTypeClassId is null or gameObjectType.gameObjectTypeClassId = :gameObjectTypeClassId) and " + 
		"(:uniqueName is null or gameObjectType.uniqueName = :uniqueName) and " + 
		"(:description is null or gameObjectType.description = :description) and " + 
		"(:isExperimental is null or gameObjectType.isExperimental = :isExperimental)"
	)
	List<GameObjectTypeEntity> findAllByExample(Long gameAssetsRepositoryId, Long gameObjectTypeClassId, String uniqueName, String description, Boolean isExperimental);
}