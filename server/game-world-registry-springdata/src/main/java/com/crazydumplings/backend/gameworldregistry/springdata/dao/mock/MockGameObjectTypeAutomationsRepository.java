package com.crazydumplings.backend.gameworldregistry.springdata.dao.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.annotation.Generated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameObjectTypeAutomationsRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.AutomationObjectProviderEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeAutomationEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Mock implementation of the specification of the repository for the GameObjectTypeAutomation entity")
public class MockGameObjectTypeAutomationsRepository implements GameObjectTypeAutomationsRepository {
    private final Logger                         LOGGER = LoggerFactory.getLogger(getClass());

    private List<GameObjectTypeAutomationEntity> gameObjectTypeAutomations;

    private Long                                 firstAvailableId;

    public MockGameObjectTypeAutomationsRepository() {
        LOGGER.info("Generating mock game object type automations");

        gameObjectTypeAutomations = new ArrayList<>();

        Random random = new Random();
        long nElements = random.nextInt(500);

        firstAvailableId = (long) 1;
        while (firstAvailableId <= nElements) {
            gameObjectTypeAutomations.add(generateGameObjectTypeAutomation(random, firstAvailableId));
            firstAvailableId++;
        }
    }

    protected static GameObjectTypeAutomationEntity generateGameObjectTypeAutomation(Random random, long id) {
        return generateGameObjectTypeAutomation(random, id, true);
    }

    protected static GameObjectTypeAutomationEntity generateGameObjectTypeAutomation(Random random, long id, boolean withDependencies) {
        GameObjectTypeAutomationEntity gameObjectTypeAutomation = new GameObjectTypeAutomationEntity(id);

        if (withDependencies) {
            gameObjectTypeAutomation.setGameObjectType(MockGameObjectTypesRepository.generateGameObjectType(random, id, false));
            gameObjectTypeAutomation
                    .setAutomationObjectProvider(MockAutomationObjectProvidersRepository.generateAutomationObjectProvider(random, id, false));
        }

        return gameObjectTypeAutomation;
    }

    @Override
    public List<GameObjectTypeAutomationEntity> findAll() {
        return gameObjectTypeAutomations;
    }

    @Override
    public GameObjectTypeAutomationEntity findOneById(Long id) {
        return gameObjectTypeAutomations.stream().filter(item -> item.getId() != null && item.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<GameObjectTypeAutomationEntity> findAllByGameObjectType(GameObjectTypeEntity gameObjectType) {
        return gameObjectTypeAutomations.stream()
                .filter(item -> item.getGameObjectType() != null && item.getGameObjectType().equals(gameObjectType))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameObjectTypeAutomationEntity> findAllByAutomationObjectProvider(AutomationObjectProviderEntity automationObjectProvider) {
        return gameObjectTypeAutomations.stream().filter(
                item -> item.getAutomationObjectProvider() != null && item.getAutomationObjectProvider().equals(automationObjectProvider))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameObjectTypeAutomationEntity> findAllByAnyTextFieldContaining(String content) {
        return gameObjectTypeAutomations.stream()
                .filter(item -> ((item.getGameObjectType() != null && item.getGameObjectType().getUniqueName() != null
                        && item.getGameObjectType().getUniqueName().contains(content))
                        || (item.getAutomationObjectProvider() != null && item.getAutomationObjectProvider().getName() != null
                                && item.getAutomationObjectProvider().getName().contains(content))))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameObjectTypeAutomationEntity> findAllByExample(GameObjectTypeEntity gameObjectType,
            AutomationObjectProviderEntity automationObjectProvider) {
        return gameObjectTypeAutomations.stream()
                .filter(item -> ((item.getGameObjectType() != null && gameObjectType != null && item.getGameObjectType().equals(gameObjectType))
                        || (item.getAutomationObjectProvider() != null && automationObjectProvider != null
                                && item.getAutomationObjectProvider().equals(automationObjectProvider))))
                .collect(Collectors.toList());
    }

    @Override
    public GameObjectTypeAutomationEntity save(GameObjectTypeAutomationEntity gameObjectTypeAutomation) {
        if (!gameObjectTypeAutomations.contains(gameObjectTypeAutomation)) {
            gameObjectTypeAutomation = new GameObjectTypeAutomationEntity(gameObjectTypeAutomation, firstAvailableId);
            gameObjectTypeAutomations.add(gameObjectTypeAutomation);
            firstAvailableId++;
        }

        return gameObjectTypeAutomation;
    }

    @Override
    public void delete(GameObjectTypeAutomationEntity gameObjectTypeAutomation) {
        gameObjectTypeAutomations.remove(gameObjectTypeAutomation);
    }
}