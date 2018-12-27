package com.crazydumplings.backend.gameworldregistry.springdata.dao.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.annotation.Generated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameWorldSpawnPointTypesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameWorldSpawnPointTypeEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Mock implementation of the specification of the repository for the GameWorldSpawnPointType entity")
public class MockGameWorldSpawnPointTypesRepository implements GameWorldSpawnPointTypesRepository {
    private final Logger                        LOGGER = LoggerFactory.getLogger(getClass());

    private List<GameWorldSpawnPointTypeEntity> gameWorldSpawnPointTypes;

    private Long                                firstAvailableId;

    public MockGameWorldSpawnPointTypesRepository() {
        LOGGER.info("Generating mock game world spawn point types");

        gameWorldSpawnPointTypes = new ArrayList<>();

        Random random = new Random();
        long nElements = random.nextInt(500);

        firstAvailableId = (long) 1;
        while (firstAvailableId <= nElements) {
            gameWorldSpawnPointTypes.add(generateGameWorldSpawnPointType(random, firstAvailableId));
            firstAvailableId++;
        }
    }

    protected static GameWorldSpawnPointTypeEntity generateGameWorldSpawnPointType(Random random, long id) {
        return generateGameWorldSpawnPointType(random, id, true);
    }

    protected static GameWorldSpawnPointTypeEntity generateGameWorldSpawnPointType(Random random, long id, boolean withDependencies) {
        GameWorldSpawnPointTypeEntity gameWorldSpawnPointType = new GameWorldSpawnPointTypeEntity(id);

        if (withDependencies) {
            gameWorldSpawnPointType.setSpawnPointGameObjectType(MockGameObjectTypesRepository.generateGameObjectType(random, id, false));
            gameWorldSpawnPointType.setSpawnedGameObjectType(MockGameObjectTypesRepository.generateGameObjectType(random, id, false));
        }

        return gameWorldSpawnPointType;
    }

    @Override
    public List<GameWorldSpawnPointTypeEntity> findAll() {
        return gameWorldSpawnPointTypes;
    }

    @Override
    public GameWorldSpawnPointTypeEntity findOneById(Long id) {
        return gameWorldSpawnPointTypes.stream().filter(item -> item.getId() != null && item.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<GameWorldSpawnPointTypeEntity> findAllBySpawnPointGameObjectType(GameObjectTypeEntity spawnPointGameObjectType) {
        return gameWorldSpawnPointTypes.stream().filter(
                item -> item.getSpawnPointGameObjectType() != null && item.getSpawnPointGameObjectType().equals(spawnPointGameObjectType))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameWorldSpawnPointTypeEntity> findAllBySpawnedGameObjectType(GameObjectTypeEntity spawnedGameObjectType) {
        return gameWorldSpawnPointTypes.stream()
                .filter(item -> item.getSpawnedGameObjectType() != null && item.getSpawnedGameObjectType().equals(spawnedGameObjectType))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameWorldSpawnPointTypeEntity> findAllByAnyTextFieldContaining(String content) {
        return gameWorldSpawnPointTypes.stream()
                .filter(item -> ((item.getSpawnPointGameObjectType() != null && item.getSpawnPointGameObjectType().getUniqueName() != null
                        && item.getSpawnPointGameObjectType().getUniqueName().contains(content))
                        || (item.getSpawnedGameObjectType() != null && item.getSpawnedGameObjectType().getUniqueName() != null
                                && item.getSpawnedGameObjectType().getUniqueName().contains(content))))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameWorldSpawnPointTypeEntity> findAllByExample(GameObjectTypeEntity spawnPointGameObjectType,
            GameObjectTypeEntity spawnedGameObjectType) {
        return gameWorldSpawnPointTypes.stream()
                .filter(item -> ((item.getSpawnPointGameObjectType() != null && spawnPointGameObjectType != null
                        && item.getSpawnPointGameObjectType().equals(spawnPointGameObjectType))
                        || (item.getSpawnedGameObjectType() != null && spawnedGameObjectType != null
                                && item.getSpawnedGameObjectType().equals(spawnedGameObjectType))))
                .collect(Collectors.toList());
    }

    @Override
    public GameWorldSpawnPointTypeEntity save(GameWorldSpawnPointTypeEntity gameWorldSpawnPointType) {
        if (!gameWorldSpawnPointTypes.contains(gameWorldSpawnPointType)) {
            gameWorldSpawnPointType = new GameWorldSpawnPointTypeEntity(gameWorldSpawnPointType, firstAvailableId);
            gameWorldSpawnPointTypes.add(gameWorldSpawnPointType);
            firstAvailableId++;
        }

        return gameWorldSpawnPointType;
    }

    @Override
    public void delete(GameWorldSpawnPointTypeEntity gameWorldSpawnPointType) {
        gameWorldSpawnPointTypes.remove(gameWorldSpawnPointType);
    }
}