package com.crazydumplings.backend.gameworldregistry.springdata.dao.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.annotation.Generated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameObjectTypeRepresentationsRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameClientTypeEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeRepresentationEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Mock implementation of the specification of the repository for the GameObjectTypeRepresentation entity")
public class MockGameObjectTypeRepresentationsRepository implements GameObjectTypeRepresentationsRepository {
    private final Logger                             LOGGER = LoggerFactory.getLogger(getClass());

    private List<GameObjectTypeRepresentationEntity> gameObjectTypeRepresentations;

    private Long                                     firstAvailableId;

    public MockGameObjectTypeRepresentationsRepository() {
        LOGGER.info("Generating mock game object type representations");

        gameObjectTypeRepresentations = new ArrayList<>();

        Random random = new Random();
        long nElements = random.nextInt(500);

        firstAvailableId = (long) 1;
        while (firstAvailableId <= nElements) {
            gameObjectTypeRepresentations.add(generateGameObjectTypeRepresentation(random, firstAvailableId));
            firstAvailableId++;
        }
    }

    protected static GameObjectTypeRepresentationEntity generateGameObjectTypeRepresentation(Random random, long id) {
        return generateGameObjectTypeRepresentation(random, id, true);
    }

    protected static GameObjectTypeRepresentationEntity generateGameObjectTypeRepresentation(Random random, long id, boolean withDependencies) {
        GameObjectTypeRepresentationEntity gameObjectTypeRepresentation = new GameObjectTypeRepresentationEntity(id);

        gameObjectTypeRepresentation.setObjectHash("object hash");

        if (withDependencies) {
            gameObjectTypeRepresentation.setGameObjectType(MockGameObjectTypesRepository.generateGameObjectType(random, id, false));
            gameObjectTypeRepresentation.setGameClientType(MockGameClientTypesRepository.generateGameClientType(random, id, false));
        }

        return gameObjectTypeRepresentation;
    }

    @Override
    public List<GameObjectTypeRepresentationEntity> findAll() {
        return gameObjectTypeRepresentations;
    }

    @Override
    public GameObjectTypeRepresentationEntity findOneById(Long id) {
        return gameObjectTypeRepresentations.stream().filter(item -> item.getId() != null && item.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<GameObjectTypeRepresentationEntity> findAllByGameObjectType(GameObjectTypeEntity gameObjectType) {
        return gameObjectTypeRepresentations.stream()
                .filter(item -> item.getGameObjectType() != null && item.getGameObjectType().equals(gameObjectType))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameObjectTypeRepresentationEntity> findAllByGameClientType(GameClientTypeEntity gameClientType) {
        return gameObjectTypeRepresentations.stream()
                .filter(item -> item.getGameClientType() != null && item.getGameClientType().equals(gameClientType))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameObjectTypeRepresentationEntity> findAllByAnyTextFieldContaining(String content) {
        return gameObjectTypeRepresentations.stream()
                .filter(item -> ((item.getGameObjectType() != null && item.getGameObjectType().getUniqueName() != null
                        && item.getGameObjectType().getUniqueName().contains(content))
                        || (item.getGameClientType() != null && item.getGameClientType().getUniqueName() != null
                                && item.getGameClientType().getUniqueName().contains(content))))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameObjectTypeRepresentationEntity> findAllByExample(GameObjectTypeEntity gameObjectType, GameClientTypeEntity gameClientType) {
        return gameObjectTypeRepresentations.stream()
                .filter(item -> ((item.getGameObjectType() != null && gameObjectType != null && item.getGameObjectType().equals(gameObjectType))
                        || (item.getGameClientType() != null && gameClientType != null && item.getGameClientType().equals(gameClientType))
                        || (item.getObjectHash() != null)))
                .collect(Collectors.toList());
    }

    @Override
    public GameObjectTypeRepresentationEntity save(GameObjectTypeRepresentationEntity gameObjectTypeRepresentation) {
        if (!gameObjectTypeRepresentations.contains(gameObjectTypeRepresentation)) {
            gameObjectTypeRepresentation = new GameObjectTypeRepresentationEntity(gameObjectTypeRepresentation, firstAvailableId);
            gameObjectTypeRepresentations.add(gameObjectTypeRepresentation);
            firstAvailableId++;
        }

        return gameObjectTypeRepresentation;
    }

    @Override
    public void delete(GameObjectTypeRepresentationEntity gameObjectTypeRepresentation) {
        gameObjectTypeRepresentations.remove(gameObjectTypeRepresentation);
    }
}