package com.crazydumplings.backend.gameworldregistry.springdata.dao.spring;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameWorldCellsRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameWorldCellEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameWorldCellTypeEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameWorldEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameWorldSpawnPointTypeEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Spring/JPA implementation of the specification of repository for the GameWorldCell entity. Note that the explicit queries prevent Spring from generating / running multiple queries for the same object in case it has parent references to other entities")
public interface SpringJpaGameWorldCellsRepository extends GameWorldCellsRepository, CrudRepository<GameWorldCellEntity, Long> {
    @Query("select distinct gameWorldCell from GameWorldCellEntity gameWorldCell left join fetch gameWorldCell.gameWorld left join fetch gameWorldCell.gameWorldCellType left join fetch gameWorldCell.attachedGameWorldSpawnPointType")
    List<GameWorldCellEntity> findAll();

    @Query("select distinct gameWorldCell from GameWorldCellEntity gameWorldCell left join fetch gameWorldCell.gameWorld left join fetch gameWorldCell.gameWorldCellType left join fetch gameWorldCell.attachedGameWorldSpawnPointType where gameWorldCell.id = ?1")
    GameWorldCellEntity findOneById(Long id);

    @Query("select distinct gameWorldCell from GameWorldCellEntity gameWorldCell left join fetch gameWorldCell.gameWorld left join fetch gameWorldCell.gameWorldCellType left join fetch gameWorldCell.attachedGameWorldSpawnPointType where gameWorldCell.gameWorld = ?1")
    List<GameWorldCellEntity> findAllByGameWorld(GameWorldEntity gameWorld);

    @Query("select distinct gameWorldCell from GameWorldCellEntity gameWorldCell left join fetch gameWorldCell.gameWorld left join fetch gameWorldCell.gameWorldCellType left join fetch gameWorldCell.attachedGameWorldSpawnPointType where gameWorldCell.gameWorldCellType = ?1")
    List<GameWorldCellEntity> findAllByGameWorldCellType(GameWorldCellTypeEntity gameWorldCellType);

    @Query("select distinct gameWorldCell from GameWorldCellEntity gameWorldCell left join fetch gameWorldCell.gameWorld left join fetch gameWorldCell.gameWorldCellType left join fetch gameWorldCell.attachedGameWorldSpawnPointType where gameWorldCell.attachedGameWorldSpawnPointType = ?1")
    List<GameWorldCellEntity> findAllByAttachedGameWorldSpawnPointType(GameWorldSpawnPointTypeEntity attachedGameWorldSpawnPointType);

    // List<GameWorldCell> findAllByXIndexLessThanEqualAndYIndexGreaterThanEqual(Integer targetSmallnumber, Integer targetSmallnumber);

    @Query("select distinct gameWorldCell from GameWorldCellEntity gameWorldCell left join fetch gameWorldCell.gameWorld left join fetch gameWorldCell.gameWorldCellType left join fetch gameWorldCell.attachedGameWorldSpawnPointType where gameWorldCell.xIndex <= ?1 and (gameWorldCell.yIndex >= ?1 or gameWorldCell.yIndex is null)")
    List<GameWorldCellEntity> findAllHavingTargetSmallnumberBetweenXIndexAndYIndex(Integer targetSmallnumber);

    @Query("select distinct gameWorldCell from GameWorldCellEntity gameWorldCell left join fetch gameWorldCell.gameWorld left join fetch gameWorldCell.gameWorldCellType left join fetch gameWorldCell.attachedGameWorldSpawnPointType "
            + "where " + "gameWorldCell.gameWorld.uniqueName like '%' + ?1 + '%' or "
            + "gameWorldCell.gameWorldCellType.uniqueName like '%' + ?1 + '%' ")
    List<GameWorldCellEntity> findAllByAnyTextFieldContaining(String content);

    @Query("select distinct gameWorldCell from GameWorldCellEntity gameWorldCell left join fetch gameWorldCell.gameWorld left join fetch gameWorldCell.gameWorldCellType left join fetch gameWorldCell.attachedGameWorldSpawnPointType "
            + "where " + "(:gameWorld is null or gameWorldCell.gameWorld = :gameWorld) and"
            + "(:gameWorldCellType is null or gameWorldCell.gameWorldCellType = :gameWorldCellType) and"
            + "(:xIndex is null or gameWorldCell.xIndex = :xIndex) and" + "(:yIndex is null or gameWorldCell.yIndex = :yIndex) and"
            + "(:attachedGameWorldSpawnPointType is null or gameWorldCell.attachedGameWorldSpawnPointType = :attachedGameWorldSpawnPointType)")
    List<GameWorldCellEntity> findAllByExample(GameWorldEntity gameWorld, GameWorldCellTypeEntity gameWorldCellType, Integer xIndex,
            Integer yIndex, GameWorldSpawnPointTypeEntity attachedGameWorldSpawnPointType);
}