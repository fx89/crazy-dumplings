package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;


import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameAssetsRepositoryEntity;

@Generated(value="fx.codegen.builder version 1.0.0", comments="Spring/JPA implementation of the specification of repository for the GameAssetsRepository entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaGameAssetsRepositoriesRepository extends CrudRepository<GameAssetsRepositoryEntity, Long> {

	@Query("select distinct gameAssetsRepository from GameAssetsRepositoryEntity gameAssetsRepository where gameAssetsRepository.uniqueName = ?1")
	GameAssetsRepositoryEntity findOneByUniqueName(String uniqueName);


	@Transactional
    @Modifying
    @Query("delete GameAssetsRepositoryEntity where id IN ?1")
    void deleteAllByIds(List<Long> ids);



	@Query(
		"select distinct gameAssetsRepository from GameAssetsRepositoryEntity gameAssetsRepository " +
		"where " +
		"(:uniqueName is null or gameAssetsRepository.uniqueName = :uniqueName) and " + 
		"(:description is null or gameAssetsRepository.description = :description)"
	)
	List<GameAssetsRepositoryEntity> findAllByExample(String uniqueName, String description);
}