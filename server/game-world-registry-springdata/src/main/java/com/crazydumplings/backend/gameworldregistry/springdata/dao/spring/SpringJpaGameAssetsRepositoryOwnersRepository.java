package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;


import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameAssetsRepositoryOwnerEntity;

@Generated(value="fx.codegen.builder version 1.0.0", comments="Spring/JPA implementation of the specification of repository for the GameAssetsRepositoryOwner entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaGameAssetsRepositoryOwnersRepository extends CrudRepository<GameAssetsRepositoryOwnerEntity, Long> {

	@Query("select distinct gameAssetsRepositoryOwner from GameAssetsRepositoryOwnerEntity gameAssetsRepositoryOwner where gameAssetsRepositoryOwner.gameAssetsRepositoryId = ?1")
	List<GameAssetsRepositoryOwnerEntity> findAllByGameAssetsRepositoryId(Long gameAssetsRepositoryId);

	@Query("select distinct gameAssetsRepositoryOwner from GameAssetsRepositoryOwnerEntity gameAssetsRepositoryOwner where gameAssetsRepositoryOwner.gameAssetsRepositoryId = ?1 and gameAssetsRepositoryOwner.id in ?2")
    List<GameAssetsRepositoryOwnerEntity> findAllByGameAssetsRepositoryIdAndIds(Long GameAssetsRepositoryId, List<Long> ids);

	@Transactional
    @Modifying
    @Query("delete GameAssetsRepositoryOwnerEntity where gameAssetsRepositoryId = ?1")
    void deleteAllByGameAssetsRepositoryId(Long gameAssetsRepositoryId);

    @Transactional
    @Modifying
    @Query("delete GameAssetsRepositoryOwnerEntity where gameAssetsRepositoryId = ?1 AND id IN ?2")
    void deleteAllByGameAssetsRepositoryIdAndIds(Long gameAssetsRepositoryId, List<Long> ids);


	@Transactional
    @Modifying
    @Query("delete GameAssetsRepositoryOwnerEntity where id IN ?1")
    void deleteAllByIds(List<Long> ids);



	@Query(
		"select distinct gameAssetsRepositoryOwner from GameAssetsRepositoryOwnerEntity gameAssetsRepositoryOwner " +
		"where " +
		"(?1 is null or gameAssetsRepositoryOwner.gameAssetsRepositoryId = ?1) and " + 
		"(?2 is null or gameAssetsRepositoryOwner.ownerUserId = ?2)"
	)
	List<GameAssetsRepositoryOwnerEntity> findAllByExample(Long gameAssetsRepositoryId, Long ownerUserId);
}