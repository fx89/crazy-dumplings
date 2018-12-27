package com.crazydumplings.backend.gameworldregistry.springdata.dao.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.annotation.Generated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameWorldCellsRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameWorldCellEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameWorldCellTypeEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameWorldEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameWorldSpawnPointTypeEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Mock implementation of the specification of the repository for the GameWorldCell entity")
public class MockGameWorldCellsRepository implements GameWorldCellsRepository {
    private final Logger              LOGGER = LoggerFactory.getLogger(getClass());

    private List<GameWorldCellEntity> gameWorldCells;

    private Long                      firstAvailableId;

    public MockGameWorldCellsRepository() {
        LOGGER.info("Generating mock game world cells");

        gameWorldCells = new ArrayList<>();

        Random random = new Random();
        long nElements = random.nextInt(500);

        firstAvailableId = (long) 1;
        while (firstAvailableId <= nElements) {
            gameWorldCells.add(generateGameWorldCell(random, firstAvailableId));
            firstAvailableId++;
        }
    }

    protected static GameWorldCellEntity generateGameWorldCell(Random random, long id) {
        return generateGameWorldCell(random, id, true);
    }

    protected static GameWorldCellEntity generateGameWorldCell(Random random, long id, boolean withDependencies) {
        GameWorldCellEntity gameWorldCell = new GameWorldCellEntity(id);

        gameWorldCell.setXIndex(random.nextInt());
        gameWorldCell.setYIndex(random.nextInt());

        if (withDependencies) {
            gameWorldCell.setGameWorld(MockGameWorldsRepository.generateGameWorld(random, id, false));
            gameWorldCell.setGameWorldCellType(MockGameWorldCellTypesRepository.generateGameWorldCellType(random, id, false));
            gameWorldCell.setAttachedGameWorldSpawnPointType(
                    MockGameWorldSpawnPointTypesRepository.generateGameWorldSpawnPointType(random, id, false));
        }

        return gameWorldCell;
    }

    @Override
    public List<GameWorldCellEntity> findAll() {
        return gameWorldCells;
    }

    @Override
    public GameWorldCellEntity findOneById(Long id) {
        return gameWorldCells.stream().filter(item -> item.getId() != null && item.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<GameWorldCellEntity> findAllByGameWorld(GameWorldEntity gameWorld) {
        return gameWorldCells.stream().filter(item -> item.getGameWorld() != null && item.getGameWorld().equals(gameWorld))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameWorldCellEntity> findAllByGameWorldCellType(GameWorldCellTypeEntity gameWorldCellType) {
        return gameWorldCells.stream()
                .filter(item -> item.getGameWorldCellType() != null && item.getGameWorldCellType().equals(gameWorldCellType))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameWorldCellEntity> findAllByAttachedGameWorldSpawnPointType(GameWorldSpawnPointTypeEntity attachedGameWorldSpawnPointType) {
        return gameWorldCells.stream().filter(item -> item.getAttachedGameWorldSpawnPointType() != null
                && item.getAttachedGameWorldSpawnPointType().equals(attachedGameWorldSpawnPointType)).collect(Collectors.toList());
    }

    // List<GameWorldCell> findAllByXIndexLessThanEqualAndYIndexGreaterThanEqual(Integer targetSmallnumber, Integer targetSmallnumber);

    @Override
    public List<GameWorldCellEntity> findAllHavingTargetSmallnumberBetweenXIndexAndYIndex(Integer targetSmallnumber) {
        return (List<GameWorldCellEntity>) gameWorldCells.stream().filter(item -> item.getXIndex() != null && item.getXIndex() <= targetSmallnumber
                && (item.getYIndex() == null || item.getYIndex() >= targetSmallnumber)).findFirst().orElse(null);
    }

    @Override
    public List<GameWorldCellEntity> findAllByAnyTextFieldContaining(String content) {
        return gameWorldCells.stream()
                .filter(item -> ((item.getGameWorld() != null && item.getGameWorld().getUniqueName() != null
                        && item.getGameWorld().getUniqueName().contains(content))
                        || (item.getGameWorldCellType() != null && item.getGameWorldCellType().getUniqueName() != null
                                && item.getGameWorldCellType().getUniqueName().contains(content))))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameWorldCellEntity> findAllByExample(GameWorldEntity gameWorld, GameWorldCellTypeEntity gameWorldCellType, Integer xIndex,
            Integer yIndex, GameWorldSpawnPointTypeEntity attachedGameWorldSpawnPointType) {
        return gameWorldCells.stream()
                .filter(item -> ((item.getGameWorld() != null && gameWorld != null && item.getGameWorld().equals(gameWorld))
                        || (item.getGameWorldCellType() != null && gameWorldCellType != null
                                && item.getGameWorldCellType().equals(gameWorldCellType))
                        || (item.getXIndex() != null && item.getXIndex() == xIndex) || (item.getYIndex() != null && item.getYIndex() == yIndex)
                        || (item.getAttachedGameWorldSpawnPointType() != null && attachedGameWorldSpawnPointType != null
                                && item.getAttachedGameWorldSpawnPointType().equals(attachedGameWorldSpawnPointType))))
                .collect(Collectors.toList());
    }

    @Override
    public GameWorldCellEntity save(GameWorldCellEntity gameWorldCell) {
        if (!gameWorldCells.contains(gameWorldCell)) {
            gameWorldCell = new GameWorldCellEntity(gameWorldCell, firstAvailableId);
            gameWorldCells.add(gameWorldCell);
            firstAvailableId++;
        }

        return gameWorldCell;
    }

    @Override
    public void delete(GameWorldCellEntity gameWorldCell) {
        gameWorldCells.remove(gameWorldCell);
    }
}