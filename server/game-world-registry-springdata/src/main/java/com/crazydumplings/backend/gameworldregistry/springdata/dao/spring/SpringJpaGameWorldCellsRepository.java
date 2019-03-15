package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;


import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameWorldCellEntity;

@Generated(value="fx.codegen.builder version 1.0.0", comments="Spring/JPA implementation of the specification of repository for the GameWorldCell entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaGameWorldCellsRepository extends CrudRepository<GameWorldCellEntity, Long> {

	@Query("select distinct gameWorldCell from GameWorldCellEntity gameWorldCell where gameWorldCell.gameWorldId = ?1")
	List<GameWorldCellEntity> findAllByGameWorldId(Long gameWorldId);

	@Query("select distinct gameWorldCell from GameWorldCellEntity gameWorldCell where gameWorldCell.gameWorldId = ?1 and gameWorldCell.id in ?2")
    List<GameWorldCellEntity> findAllByGameWorldIdAndIds(Long GameWorldId, List<Long> ids);

	@Transactional
    @Modifying
    @Query("delete GameWorldCellEntity where gameWorldId = ?1")
    void deleteAllByGameWorldId(Long gameWorldId);

    @Transactional
    @Modifying
    @Query("delete GameWorldCellEntity where gameWorldId = ?1 AND id IN ?2")
    void deleteAllByGameWorldIdAndIds(Long gameWorldId, List<Long> ids);

	@Query("select distinct gameWorldCell from GameWorldCellEntity gameWorldCell where gameWorldCell.gameWorldCellTypeId = ?1")
	List<GameWorldCellEntity> findAllByGameWorldCellTypeId(Long gameWorldCellTypeId);

	@Query("select distinct gameWorldCell from GameWorldCellEntity gameWorldCell where gameWorldCell.gameWorldCellTypeId = ?1 and gameWorldCell.id in ?2")
    List<GameWorldCellEntity> findAllByGameWorldCellTypeIdAndIds(Long GameWorldCellTypeId, List<Long> ids);

	@Transactional
    @Modifying
    @Query("delete GameWorldCellEntity where gameWorldCellTypeId = ?1")
    void deleteAllByGameWorldCellTypeId(Long gameWorldCellTypeId);

    @Transactional
    @Modifying
    @Query("delete GameWorldCellEntity where gameWorldCellTypeId = ?1 AND id IN ?2")
    void deleteAllByGameWorldCellTypeIdAndIds(Long gameWorldCellTypeId, List<Long> ids);

	@Query("select distinct gameWorldCell from GameWorldCellEntity gameWorldCell where gameWorldCell.attachedGameWorldSpawnPointTypeId = ?1")
	List<GameWorldCellEntity> findAllByAttachedGameWorldSpawnPointTypeId(Long attachedGameWorldSpawnPointTypeId);

	@Query("select distinct gameWorldCell from GameWorldCellEntity gameWorldCell where gameWorldCell.attachedGameWorldSpawnPointTypeId = ?1 and gameWorldCell.id in ?2")
    List<GameWorldCellEntity> findAllByAttachedGameWorldSpawnPointTypeIdAndIds(Long AttachedGameWorldSpawnPointTypeId, List<Long> ids);

	@Transactional
    @Modifying
    @Query("delete GameWorldCellEntity where attachedGameWorldSpawnPointTypeId = ?1")
    void deleteAllByAttachedGameWorldSpawnPointTypeId(Long attachedGameWorldSpawnPointTypeId);

    @Transactional
    @Modifying
    @Query("delete GameWorldCellEntity where attachedGameWorldSpawnPointTypeId = ?1 AND id IN ?2")
    void deleteAllByAttachedGameWorldSpawnPointTypeIdAndIds(Long attachedGameWorldSpawnPointTypeId, List<Long> ids);


	@Transactional
    @Modifying
    @Query("delete GameWorldCellEntity where id IN ?1")
    void deleteAllByIds(List<Long> ids);

	// List<GameWorldCell> findAllByXIndexLessThanEqualAndYIndexGreaterThanEqual(Integer targetSmallnumber, Integer targetSmallnumber);

	@Query("select distinct gameWorldCell from GameWorldCellEntity gameWorldCell where gameWorldCell.xIndex <= ?1 and (gameWorldCell.yIndex >= ?1 or gameWorldCell.yIndex is null)")
	List<GameWorldCellEntity> findAllHavingTargetSmallnumberBetweenXIndexAndYIndex(Integer targetSmallnumber);



	@Query(
		"select distinct gameWorldCell from GameWorldCellEntity gameWorldCell " +
		"where " +
		"(:gameWorldId is null or gameWorldCell.gameWorldId = :gameWorldId) and " + 
		"(:gameWorldCellTypeId is null or gameWorldCell.gameWorldCellTypeId = :gameWorldCellTypeId) and " + 
		"(:xIndex is null or gameWorldCell.xIndex = :xIndex) and " + 
		"(:yIndex is null or gameWorldCell.yIndex = :yIndex) and " + 
		"(:attachedGameWorldSpawnPointTypeId is null or gameWorldCell.attachedGameWorldSpawnPointTypeId = :attachedGameWorldSpawnPointTypeId)"
	)
	List<GameWorldCellEntity> findAllByExample(Long gameWorldId, Long gameWorldCellTypeId, Integer xIndex, Integer yIndex, Long attachedGameWorldSpawnPointTypeId);
}