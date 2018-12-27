package com.crazydumplings.backend.gameworldregistry.springdata.dao.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.annotation.Generated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameClientTypesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameClientTypeEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Mock implementation of the specification of the repository for the GameClientType entity")
public class MockGameClientTypesRepository implements GameClientTypesRepository {
    private final Logger               LOGGER = LoggerFactory.getLogger(getClass());

    private List<GameClientTypeEntity> gameClientTypes;

    private Long                       firstAvailableId;

    public MockGameClientTypesRepository() {
        LOGGER.info("Generating mock game client types");

        gameClientTypes = new ArrayList<>();

        Random random = new Random();
        long nElements = random.nextInt(100);

        firstAvailableId = (long) 1;
        while (firstAvailableId <= nElements) {
            gameClientTypes.add(generateGameClientType(random, firstAvailableId));
            firstAvailableId++;
        }
    }

    protected static GameClientTypeEntity generateGameClientType(Random random, long id) {
        return generateGameClientType(random, id, true);
    }

    protected static GameClientTypeEntity generateGameClientType(Random random, long id, boolean withDependencies) {
        GameClientTypeEntity gameClientType = new GameClientTypeEntity(id);

        gameClientType.setUniqueName("GAME CLIENT TYPE " + id + " UNIQUE NAME");

        if (withDependencies) {
        }

        return gameClientType;
    }

    @Override
    public List<GameClientTypeEntity> findAll() {
        return gameClientTypes;
    }

    @Override
    public GameClientTypeEntity findOneById(Long id) {
        return gameClientTypes.stream().filter(item -> item.getId() != null && item.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public GameClientTypeEntity findOneByUniqueName(String uniqueName) {
        return gameClientTypes.stream().filter(item -> item.getUniqueName() != null && item.getUniqueName().equals(uniqueName)).findFirst()
                .orElse(null);
    }

    @Override
    public List<GameClientTypeEntity> findAllByAnyTextFieldContaining(String content) {
        return gameClientTypes.stream().filter(item -> ((item.getUniqueName() != null && item.getUniqueName().contains(content))))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameClientTypeEntity> findAllByExample(String uniqueName) {
        return gameClientTypes.stream().filter(item -> ((item.getUniqueName() != null && item.getUniqueName().equals(uniqueName))))
                .collect(Collectors.toList());
    }

    @Override
    public GameClientTypeEntity save(GameClientTypeEntity gameClientType) {
        if (!gameClientTypes.contains(gameClientType)) {
            gameClientType = new GameClientTypeEntity(gameClientType, firstAvailableId);
            gameClientTypes.add(gameClientType);
            firstAvailableId++;
        }

        return gameClientType;
    }

    @Override
    public void delete(GameClientTypeEntity gameClientType) {
        gameClientTypes.remove(gameClientType);
    }
}