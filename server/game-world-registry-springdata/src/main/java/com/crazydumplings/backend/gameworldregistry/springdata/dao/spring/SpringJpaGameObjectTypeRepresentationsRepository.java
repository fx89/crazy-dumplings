package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;


import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeRepresentationEntity;

@Generated(value="fx.codegen.builder version 1.0.0", comments="Spring/JPA implementation of the specification of repository for the GameObjectTypeRepresentation entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaGameObjectTypeRepresentationsRepository extends CrudRepository<GameObjectTypeRepresentationEntity, Long> {

	@Query("select distinct gameObjectTypeRepresentation from GameObjectTypeRepresentationEntity gameObjectTypeRepresentation where gameObjectTypeRepresentation.gameObjectTypeId = ?1")
	List<GameObjectTypeRepresentationEntity> findAllByGameObjectTypeId(Long gameObjectTypeId);

	@Query("select distinct gameObjectTypeRepresentation from GameObjectTypeRepresentationEntity gameObjectTypeRepresentation where gameObjectTypeRepresentation.gameObjectTypeId = ?1 and gameObjectTypeRepresentation.id in ?2")
    List<GameObjectTypeRepresentationEntity> findAllByGameObjectTypeIdAndIds(Long GameObjectTypeId, List<Long> ids);

	@Transactional
    @Modifying
    @Query("delete GameObjectTypeRepresentationEntity where gameObjectTypeId = ?1")
    void deleteAllByGameObjectTypeId(Long gameObjectTypeId);

    @Transactional
    @Modifying
    @Query("delete GameObjectTypeRepresentationEntity where gameObjectTypeId = ?1 AND id IN ?2")
    void deleteAllByGameObjectTypeIdAndIds(Long gameObjectTypeId, List<Long> ids);

	@Query("select distinct gameObjectTypeRepresentation from GameObjectTypeRepresentationEntity gameObjectTypeRepresentation where gameObjectTypeRepresentation.gameClientTypeId = ?1")
	List<GameObjectTypeRepresentationEntity> findAllByGameClientTypeId(Long gameClientTypeId);

	@Query("select distinct gameObjectTypeRepresentation from GameObjectTypeRepresentationEntity gameObjectTypeRepresentation where gameObjectTypeRepresentation.gameClientTypeId = ?1 and gameObjectTypeRepresentation.id in ?2")
    List<GameObjectTypeRepresentationEntity> findAllByGameClientTypeIdAndIds(Long GameClientTypeId, List<Long> ids);

	@Transactional
    @Modifying
    @Query("delete GameObjectTypeRepresentationEntity where gameClientTypeId = ?1")
    void deleteAllByGameClientTypeId(Long gameClientTypeId);

    @Transactional
    @Modifying
    @Query("delete GameObjectTypeRepresentationEntity where gameClientTypeId = ?1 AND id IN ?2")
    void deleteAllByGameClientTypeIdAndIds(Long gameClientTypeId, List<Long> ids);


	@Transactional
    @Modifying
    @Query("delete GameObjectTypeRepresentationEntity where id IN ?1")
    void deleteAllByIds(List<Long> ids);



	@Query(
		"select distinct gameObjectTypeRepresentation from GameObjectTypeRepresentationEntity gameObjectTypeRepresentation " +
		"where " +
		"(:gameObjectTypeId is null or gameObjectTypeRepresentation.gameObjectTypeId = :gameObjectTypeId) and " + 
		"(:gameClientTypeId is null or gameObjectTypeRepresentation.gameClientTypeId = :gameClientTypeId) and " + 
		"(:objectHash is null or gameObjectTypeRepresentation.objectHash = :objectHash)"
	)
	List<GameObjectTypeRepresentationEntity> findAllByExample(Long gameObjectTypeId, Long gameClientTypeId, Boolean objectHash);
}