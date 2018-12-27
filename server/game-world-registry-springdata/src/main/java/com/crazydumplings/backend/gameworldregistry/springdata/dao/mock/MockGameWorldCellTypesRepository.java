package com.crazydumplings.backend.gameworldregistry.springdata.dao.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.annotation.Generated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameWorldCellTypesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameWorldCellTypeEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Mock implementation of the specification of the repository for the GameWorldCellType entity")
public class MockGameWorldCellTypesRepository implements GameWorldCellTypesRepository {
    private final Logger                  LOGGER = LoggerFactory.getLogger(getClass());

    private List<GameWorldCellTypeEntity> gameWorldCellTypes;

    private Long                          firstAvailableId;

    public MockGameWorldCellTypesRepository() {
        LOGGER.info("Generating mock game world cell types");

        gameWorldCellTypes = new ArrayList<>();

        Random random = new Random();
        long nElements = random.nextInt(100);

        firstAvailableId = (long) 1;
        while (firstAvailableId <= nElements) {
            gameWorldCellTypes.add(generateGameWorldCellType(random, firstAvailableId));
            firstAvailableId++;
        }
    }

    protected static GameWorldCellTypeEntity generateGameWorldCellType(Random random, long id) {
        return generateGameWorldCellType(random, id, true);
    }

    protected static GameWorldCellTypeEntity generateGameWorldCellType(Random random, long id, boolean withDependencies) {
        GameWorldCellTypeEntity gameWorldCellType = new GameWorldCellTypeEntity(id);

        gameWorldCellType.setUniqueName("GAME WORLD CELL TYPE " + id + " UNIQUE NAME");

        if (withDependencies) {
            gameWorldCellType.setGameObjectType(MockGameObjectTypesRepository.generateGameObjectType(random, id, false));
        }

        return gameWorldCellType;
    }

    @Override
    public List<GameWorldCellTypeEntity> findAll() {
        return gameWorldCellTypes;
    }

    @Override
    public GameWorldCellTypeEntity findOneById(Long id) {
        return gameWorldCellTypes.stream().filter(item -> item.getId() != null && item.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public GameWorldCellTypeEntity findOneByUniqueName(String uniqueName) {
        return gameWorldCellTypes.stream().filter(item -> item.getUniqueName() != null && item.getUniqueName().equals(uniqueName)).findFirst()
                .orElse(null);
    }

    @Override
    public List<GameWorldCellTypeEntity> findAllByGameObjectType(GameObjectTypeEntity gameObjectType) {
        return gameWorldCellTypes.stream().filter(item -> item.getGameObjectType() != null && item.getGameObjectType().equals(gameObjectType))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameWorldCellTypeEntity> findAllByAnyTextFieldContaining(String content) {
        return gameWorldCellTypes.stream()
                .filter(item -> ((item.getUniqueName() != null && item.getUniqueName().contains(content)) || (item.getGameObjectType() != null
                        && item.getGameObjectType().getUniqueName() != null && item.getGameObjectType().getUniqueName().contains(content))))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameWorldCellTypeEntity> findAllByExample(String uniqueName, GameObjectTypeEntity gameObjectType) {
        return gameWorldCellTypes.stream()
                .filter(item -> ((item.getUniqueName() != null && item.getUniqueName().equals(uniqueName))
                        || (item.getGameObjectType() != null && gameObjectType != null && item.getGameObjectType().equals(gameObjectType))))
                .collect(Collectors.toList());
    }

    @Override
    public GameWorldCellTypeEntity save(GameWorldCellTypeEntity gameWorldCellType) {
        if (!gameWorldCellTypes.contains(gameWorldCellType)) {
            gameWorldCellType = new GameWorldCellTypeEntity(gameWorldCellType, firstAvailableId);
            gameWorldCellTypes.add(gameWorldCellType);
            firstAvailableId++;
        }

        return gameWorldCellType;
    }

    @Override
    public void delete(GameWorldCellTypeEntity gameWorldCellType) {
        gameWorldCellTypes.remove(gameWorldCellType);
    }
}