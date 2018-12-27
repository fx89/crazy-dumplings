package com.crazydumplings.backend.gameworldregistry.springdata.dao.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.annotation.Generated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameObjectTypeClassesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeClassEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Mock implementation of the specification of the repository for the GameObjectTypeClass entity")
public class MockGameObjectTypeClassesRepository implements GameObjectTypeClassesRepository {
    private final Logger                    LOGGER = LoggerFactory.getLogger(getClass());

    private List<GameObjectTypeClassEntity> gameObjectTypeClasses;

    private Long                            firstAvailableId;

    public MockGameObjectTypeClassesRepository() {
        LOGGER.info("Generating mock game object type classes");

        gameObjectTypeClasses = new ArrayList<>();

        Random random = new Random();
        long nElements = random.nextInt(100);

        firstAvailableId = (long) 1;
        while (firstAvailableId <= nElements) {
            gameObjectTypeClasses.add(generateGameObjectTypeClass(random, firstAvailableId));
            firstAvailableId++;
        }
    }

    protected static GameObjectTypeClassEntity generateGameObjectTypeClass(Random random, long id) {
        return generateGameObjectTypeClass(random, id, true);
    }

    protected static GameObjectTypeClassEntity generateGameObjectTypeClass(Random random, long id, boolean withDependencies) {
        GameObjectTypeClassEntity gameObjectTypeClass = new GameObjectTypeClassEntity(id);

        gameObjectTypeClass.setName("GAME OBJECT TYPE CLASS " + id + " NAME");

        if (withDependencies) {
        }

        return gameObjectTypeClass;
    }

    @Override
    public List<GameObjectTypeClassEntity> findAll() {
        return gameObjectTypeClasses;
    }

    @Override
    public GameObjectTypeClassEntity findOneById(Long id) {
        return gameObjectTypeClasses.stream().filter(item -> item.getId() != null && item.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public GameObjectTypeClassEntity findOneByName(String name) {
        return gameObjectTypeClasses.stream().filter(item -> item.getName() != null && item.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public List<GameObjectTypeClassEntity> findAllByAnyTextFieldContaining(String content) {
        return gameObjectTypeClasses.stream().filter(item -> ((item.getName() != null && item.getName().contains(content))))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameObjectTypeClassEntity> findAllByExample(String name) {
        return gameObjectTypeClasses.stream().filter(item -> ((item.getName() != null && item.getName().equals(name))))
                .collect(Collectors.toList());
    }

    @Override
    public GameObjectTypeClassEntity save(GameObjectTypeClassEntity gameObjectTypeClass) {
        if (!gameObjectTypeClasses.contains(gameObjectTypeClass)) {
            gameObjectTypeClass = new GameObjectTypeClassEntity(gameObjectTypeClass, firstAvailableId);
            gameObjectTypeClasses.add(gameObjectTypeClass);
            firstAvailableId++;
        }

        return gameObjectTypeClass;
    }

    @Override
    public void delete(GameObjectTypeClassEntity gameObjectTypeClass) {
        gameObjectTypeClasses.remove(gameObjectTypeClass);
    }
}