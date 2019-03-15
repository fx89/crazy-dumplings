package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;


import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeInteractionEntity;

@Generated(value="fx.codegen.builder version 1.0.0", comments="Spring/JPA implementation of the specification of repository for the GameObjectTypeInteraction entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaGameObjectTypeInteractionsRepository extends CrudRepository<GameObjectTypeInteractionEntity, Long> {

	@Query("select distinct gameObjectTypeInteraction from GameObjectTypeInteractionEntity gameObjectTypeInteraction where gameObjectTypeInteraction.donatingGameObjectTypeId = ?1")
	List<GameObjectTypeInteractionEntity> findAllByDonatingGameObjectTypeId(Long donatingGameObjectTypeId);

	@Query("select distinct gameObjectTypeInteraction from GameObjectTypeInteractionEntity gameObjectTypeInteraction where gameObjectTypeInteraction.donatingGameObjectTypeId = ?1 and gameObjectTypeInteraction.id in ?2")
    List<GameObjectTypeInteractionEntity> findAllByDonatingGameObjectTypeIdAndIds(Long DonatingGameObjectTypeId, List<Long> ids);

	@Transactional
    @Modifying
    @Query("delete GameObjectTypeInteractionEntity where donatingGameObjectTypeId = ?1")
    void deleteAllByDonatingGameObjectTypeId(Long donatingGameObjectTypeId);

    @Transactional
    @Modifying
    @Query("delete GameObjectTypeInteractionEntity where donatingGameObjectTypeId = ?1 AND id IN ?2")
    void deleteAllByDonatingGameObjectTypeIdAndIds(Long donatingGameObjectTypeId, List<Long> ids);

	@Query("select distinct gameObjectTypeInteraction from GameObjectTypeInteractionEntity gameObjectTypeInteraction where gameObjectTypeInteraction.receivingGameObjectTypeId = ?1")
	List<GameObjectTypeInteractionEntity> findAllByReceivingGameObjectTypeId(Long receivingGameObjectTypeId);

	@Query("select distinct gameObjectTypeInteraction from GameObjectTypeInteractionEntity gameObjectTypeInteraction where gameObjectTypeInteraction.receivingGameObjectTypeId = ?1 and gameObjectTypeInteraction.id in ?2")
    List<GameObjectTypeInteractionEntity> findAllByReceivingGameObjectTypeIdAndIds(Long ReceivingGameObjectTypeId, List<Long> ids);

	@Transactional
    @Modifying
    @Query("delete GameObjectTypeInteractionEntity where receivingGameObjectTypeId = ?1")
    void deleteAllByReceivingGameObjectTypeId(Long receivingGameObjectTypeId);

    @Transactional
    @Modifying
    @Query("delete GameObjectTypeInteractionEntity where receivingGameObjectTypeId = ?1 AND id IN ?2")
    void deleteAllByReceivingGameObjectTypeIdAndIds(Long receivingGameObjectTypeId, List<Long> ids);


	@Transactional
    @Modifying
    @Query("delete GameObjectTypeInteractionEntity where id IN ?1")
    void deleteAllByIds(List<Long> ids);



	@Query(
		"select distinct gameObjectTypeInteraction from GameObjectTypeInteractionEntity gameObjectTypeInteraction " +
		"where " +
		"(:donatingGameObjectTypeId is null or gameObjectTypeInteraction.donatingGameObjectTypeId = :donatingGameObjectTypeId) and " + 
		"(:receivingGameObjectTypeId is null or gameObjectTypeInteraction.receivingGameObjectTypeId = :receivingGameObjectTypeId) and " + 
		"(:radius is null or gameObjectTypeInteraction.radius = :radius)"
	)
	List<GameObjectTypeInteractionEntity> findAllByExample(Long donatingGameObjectTypeId, Long receivingGameObjectTypeId, Integer radius);
}