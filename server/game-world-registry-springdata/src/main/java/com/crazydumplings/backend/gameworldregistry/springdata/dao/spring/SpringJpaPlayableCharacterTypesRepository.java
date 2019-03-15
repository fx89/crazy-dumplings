package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;


import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.PlayableCharacterTypeEntity;

@Generated(value="fx.codegen.builder version 1.0.0", comments="Spring/JPA implementation of the specification of repository for the PlayableCharacterType entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaPlayableCharacterTypesRepository extends CrudRepository<PlayableCharacterTypeEntity, Long> {

	@Query("select distinct playableCharacterType from PlayableCharacterTypeEntity playableCharacterType where playableCharacterType.uniqueCharacterTypeName = ?1")
	PlayableCharacterTypeEntity findOneByUniqueCharacterTypeName(String uniqueCharacterTypeName);

	@Query("select distinct playableCharacterType from PlayableCharacterTypeEntity playableCharacterType where playableCharacterType.gameObjectTypeId = ?1")
	List<PlayableCharacterTypeEntity> findAllByGameObjectTypeId(Long gameObjectTypeId);

	@Query("select distinct playableCharacterType from PlayableCharacterTypeEntity playableCharacterType where playableCharacterType.gameObjectTypeId = ?1 and playableCharacterType.id in ?2")
    List<PlayableCharacterTypeEntity> findAllByGameObjectTypeIdAndIds(Long GameObjectTypeId, List<Long> ids);

	@Transactional
    @Modifying
    @Query("delete PlayableCharacterTypeEntity where gameObjectTypeId = ?1")
    void deleteAllByGameObjectTypeId(Long gameObjectTypeId);

    @Transactional
    @Modifying
    @Query("delete PlayableCharacterTypeEntity where gameObjectTypeId = ?1 AND id IN ?2")
    void deleteAllByGameObjectTypeIdAndIds(Long gameObjectTypeId, List<Long> ids);


	@Transactional
    @Modifying
    @Query("delete PlayableCharacterTypeEntity where id IN ?1")
    void deleteAllByIds(List<Long> ids);



	@Query(
		"select distinct playableCharacterType from PlayableCharacterTypeEntity playableCharacterType " +
		"where " +
		"(:uniqueCharacterTypeName is null or playableCharacterType.uniqueCharacterTypeName = :uniqueCharacterTypeName) and " + 
		"(:gameObjectTypeId is null or playableCharacterType.gameObjectTypeId = :gameObjectTypeId)"
	)
	List<PlayableCharacterTypeEntity> findAllByExample(String uniqueCharacterTypeName, Long gameObjectTypeId);
}