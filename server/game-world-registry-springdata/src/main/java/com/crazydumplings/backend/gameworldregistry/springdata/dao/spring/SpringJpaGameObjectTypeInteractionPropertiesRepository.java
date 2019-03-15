package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;


import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeInteractionPropertyEntity;

@Generated(value="fx.codegen.builder version 1.0.0", comments="Spring/JPA implementation of the specification of repository for the GameObjectTypeInteractionProperty entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaGameObjectTypeInteractionPropertiesRepository extends CrudRepository<GameObjectTypeInteractionPropertyEntity, Long> {

	@Query("select distinct gameObjectTypeInteractionProperty from GameObjectTypeInteractionPropertyEntity gameObjectTypeInteractionProperty where gameObjectTypeInteractionProperty.gameObjectTypeInteractionId = ?1")
	List<GameObjectTypeInteractionPropertyEntity> findAllByGameObjectTypeInteractionId(Long gameObjectTypeInteractionId);

	@Query("select distinct gameObjectTypeInteractionProperty from GameObjectTypeInteractionPropertyEntity gameObjectTypeInteractionProperty where gameObjectTypeInteractionProperty.gameObjectTypeInteractionId = ?1 and gameObjectTypeInteractionProperty.id in ?2")
    List<GameObjectTypeInteractionPropertyEntity> findAllByGameObjectTypeInteractionIdAndIds(Long GameObjectTypeInteractionId, List<Long> ids);

	@Transactional
    @Modifying
    @Query("delete GameObjectTypeInteractionPropertyEntity where gameObjectTypeInteractionId = ?1")
    void deleteAllByGameObjectTypeInteractionId(Long gameObjectTypeInteractionId);

    @Transactional
    @Modifying
    @Query("delete GameObjectTypeInteractionPropertyEntity where gameObjectTypeInteractionId = ?1 AND id IN ?2")
    void deleteAllByGameObjectTypeInteractionIdAndIds(Long gameObjectTypeInteractionId, List<Long> ids);

	@Query("select distinct gameObjectTypeInteractionProperty from GameObjectTypeInteractionPropertyEntity gameObjectTypeInteractionProperty where gameObjectTypeInteractionProperty.donatingGameObjectTypePropertyId = ?1")
	List<GameObjectTypeInteractionPropertyEntity> findAllByDonatingGameObjectTypePropertyId(Long donatingGameObjectTypePropertyId);

	@Query("select distinct gameObjectTypeInteractionProperty from GameObjectTypeInteractionPropertyEntity gameObjectTypeInteractionProperty where gameObjectTypeInteractionProperty.donatingGameObjectTypePropertyId = ?1 and gameObjectTypeInteractionProperty.id in ?2")
    List<GameObjectTypeInteractionPropertyEntity> findAllByDonatingGameObjectTypePropertyIdAndIds(Long DonatingGameObjectTypePropertyId, List<Long> ids);

	@Transactional
    @Modifying
    @Query("delete GameObjectTypeInteractionPropertyEntity where donatingGameObjectTypePropertyId = ?1")
    void deleteAllByDonatingGameObjectTypePropertyId(Long donatingGameObjectTypePropertyId);

    @Transactional
    @Modifying
    @Query("delete GameObjectTypeInteractionPropertyEntity where donatingGameObjectTypePropertyId = ?1 AND id IN ?2")
    void deleteAllByDonatingGameObjectTypePropertyIdAndIds(Long donatingGameObjectTypePropertyId, List<Long> ids);

	@Query("select distinct gameObjectTypeInteractionProperty from GameObjectTypeInteractionPropertyEntity gameObjectTypeInteractionProperty where gameObjectTypeInteractionProperty.receivingGameObjectTypePropertyId = ?1")
	List<GameObjectTypeInteractionPropertyEntity> findAllByReceivingGameObjectTypePropertyId(Long receivingGameObjectTypePropertyId);

	@Query("select distinct gameObjectTypeInteractionProperty from GameObjectTypeInteractionPropertyEntity gameObjectTypeInteractionProperty where gameObjectTypeInteractionProperty.receivingGameObjectTypePropertyId = ?1 and gameObjectTypeInteractionProperty.id in ?2")
    List<GameObjectTypeInteractionPropertyEntity> findAllByReceivingGameObjectTypePropertyIdAndIds(Long ReceivingGameObjectTypePropertyId, List<Long> ids);

	@Transactional
    @Modifying
    @Query("delete GameObjectTypeInteractionPropertyEntity where receivingGameObjectTypePropertyId = ?1")
    void deleteAllByReceivingGameObjectTypePropertyId(Long receivingGameObjectTypePropertyId);

    @Transactional
    @Modifying
    @Query("delete GameObjectTypeInteractionPropertyEntity where receivingGameObjectTypePropertyId = ?1 AND id IN ?2")
    void deleteAllByReceivingGameObjectTypePropertyIdAndIds(Long receivingGameObjectTypePropertyId, List<Long> ids);

	@Query("select distinct gameObjectTypeInteractionProperty from GameObjectTypeInteractionPropertyEntity gameObjectTypeInteractionProperty where gameObjectTypeInteractionProperty.overflowGameObjectTypePropertyId = ?1")
	List<GameObjectTypeInteractionPropertyEntity> findAllByOverflowGameObjectTypePropertyId(Long overflowGameObjectTypePropertyId);

	@Query("select distinct gameObjectTypeInteractionProperty from GameObjectTypeInteractionPropertyEntity gameObjectTypeInteractionProperty where gameObjectTypeInteractionProperty.overflowGameObjectTypePropertyId = ?1 and gameObjectTypeInteractionProperty.id in ?2")
    List<GameObjectTypeInteractionPropertyEntity> findAllByOverflowGameObjectTypePropertyIdAndIds(Long OverflowGameObjectTypePropertyId, List<Long> ids);

	@Transactional
    @Modifying
    @Query("delete GameObjectTypeInteractionPropertyEntity where overflowGameObjectTypePropertyId = ?1")
    void deleteAllByOverflowGameObjectTypePropertyId(Long overflowGameObjectTypePropertyId);

    @Transactional
    @Modifying
    @Query("delete GameObjectTypeInteractionPropertyEntity where overflowGameObjectTypePropertyId = ?1 AND id IN ?2")
    void deleteAllByOverflowGameObjectTypePropertyIdAndIds(Long overflowGameObjectTypePropertyId, List<Long> ids);


	@Transactional
    @Modifying
    @Query("delete GameObjectTypeInteractionPropertyEntity where id IN ?1")
    void deleteAllByIds(List<Long> ids);



	@Query(
		"select distinct gameObjectTypeInteractionProperty from GameObjectTypeInteractionPropertyEntity gameObjectTypeInteractionProperty " +
		"where " +
		"(:gameObjectTypeInteractionId is null or gameObjectTypeInteractionProperty.gameObjectTypeInteractionId = :gameObjectTypeInteractionId) and " + 
		"(:donatingGameObjectTypePropertyId is null or gameObjectTypeInteractionProperty.donatingGameObjectTypePropertyId = :donatingGameObjectTypePropertyId) and " + 
		"(:receivingGameObjectTypePropertyId is null or gameObjectTypeInteractionProperty.receivingGameObjectTypePropertyId = :receivingGameObjectTypePropertyId) and " + 
		"(:overflowGameObjectTypePropertyId is null or gameObjectTypeInteractionProperty.overflowGameObjectTypePropertyId = :overflowGameObjectTypePropertyId) and " + 
		"(:isIncremental is null or gameObjectTypeInteractionProperty.isIncremental = :isIncremental) and " + 
		"(:isInverted is null or gameObjectTypeInteractionProperty.isInverted = :isInverted)"
	)
	List<GameObjectTypeInteractionPropertyEntity> findAllByExample(Long gameObjectTypeInteractionId, Long donatingGameObjectTypePropertyId, Long receivingGameObjectTypePropertyId, Long overflowGameObjectTypePropertyId, Boolean isIncremental, Boolean isInverted);
}