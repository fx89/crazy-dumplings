package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;


import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameWorldCellTypeEntity;

@Generated(value="fx.codegen.builder version 1.0.0", comments="Spring/JPA implementation of the specification of repository for the GameWorldCellType entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaGameWorldCellTypesRepository extends CrudRepository<GameWorldCellTypeEntity, Long> {

	@Query("select distinct gameWorldCellType from GameWorldCellTypeEntity gameWorldCellType where gameWorldCellType.uniqueName = ?1")
	GameWorldCellTypeEntity findOneByUniqueName(String uniqueName);

	@Query("select distinct gameWorldCellType from GameWorldCellTypeEntity gameWorldCellType where gameWorldCellType.gameObjectTypeId = ?1")
	List<GameWorldCellTypeEntity> findAllByGameObjectTypeId(Long gameObjectTypeId);

	@Query("select distinct gameWorldCellType from GameWorldCellTypeEntity gameWorldCellType where gameWorldCellType.gameObjectTypeId = ?1 and gameWorldCellType.id in ?2")
    List<GameWorldCellTypeEntity> findAllByGameObjectTypeIdAndIds(Long GameObjectTypeId, List<Long> ids);

	@Transactional
    @Modifying
    @Query("delete GameWorldCellTypeEntity where gameObjectTypeId = ?1")
    void deleteAllByGameObjectTypeId(Long gameObjectTypeId);

    @Transactional
    @Modifying
    @Query("delete GameWorldCellTypeEntity where gameObjectTypeId = ?1 AND id IN ?2")
    void deleteAllByGameObjectTypeIdAndIds(Long gameObjectTypeId, List<Long> ids);


	@Transactional
    @Modifying
    @Query("delete GameWorldCellTypeEntity where id IN ?1")
    void deleteAllByIds(List<Long> ids);



	@Query(
		"select distinct gameWorldCellType from GameWorldCellTypeEntity gameWorldCellType " +
		"where " +
		"(:uniqueName is null or gameWorldCellType.uniqueName = :uniqueName) and " + 
		"(:gameObjectTypeId is null or gameWorldCellType.gameObjectTypeId = :gameObjectTypeId)"
	)
	List<GameWorldCellTypeEntity> findAllByExample(String uniqueName, Long gameObjectTypeId);
}