package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;


import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameAssetsRepositoryPictureEntity;

@Generated(value="fx.codegen.builder version 1.0.0", comments="Spring/JPA implementation of the specification of repository for the GameAssetsRepositoryPicture entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaGameAssetsRepositoryPicturesRepository extends CrudRepository<GameAssetsRepositoryPictureEntity, Long> {

	@Query("select distinct gameAssetsRepositoryPicture from GameAssetsRepositoryPictureEntity gameAssetsRepositoryPicture where gameAssetsRepositoryPicture.gameAssetsRepositoryId = ?1")
	List<GameAssetsRepositoryPictureEntity> findAllByGameAssetsRepositoryId(Long gameAssetsRepositoryId);

	@Query("select distinct gameAssetsRepositoryPicture from GameAssetsRepositoryPictureEntity gameAssetsRepositoryPicture where gameAssetsRepositoryPicture.gameAssetsRepositoryId = ?1 and gameAssetsRepositoryPicture.id in ?2")
    List<GameAssetsRepositoryPictureEntity> findAllByGameAssetsRepositoryIdAndIds(Long GameAssetsRepositoryId, List<Long> ids);

	@Transactional
    @Modifying
    @Query("delete GameAssetsRepositoryPictureEntity where gameAssetsRepositoryId = ?1")
    void deleteAllByGameAssetsRepositoryId(Long gameAssetsRepositoryId);

    @Transactional
    @Modifying
    @Query("delete GameAssetsRepositoryPictureEntity where gameAssetsRepositoryId = ?1 AND id IN ?2")
    void deleteAllByGameAssetsRepositoryIdAndIds(Long gameAssetsRepositoryId, List<Long> ids);


	@Transactional
    @Modifying
    @Query("delete GameAssetsRepositoryPictureEntity where id IN ?1")
    void deleteAllByIds(List<Long> ids);



	@Query(
		"select distinct gameAssetsRepositoryPicture from GameAssetsRepositoryPictureEntity gameAssetsRepositoryPicture " +
		"where " +
		"(:gameAssetsRepositoryId is null or gameAssetsRepositoryPicture.gameAssetsRepositoryId = :gameAssetsRepositoryId) and " + 
		"(:pictureHash is null or gameAssetsRepositoryPicture.pictureHash = :pictureHash)"
	)
	List<GameAssetsRepositoryPictureEntity> findAllByExample(Long gameAssetsRepositoryId, Boolean pictureHash);
}