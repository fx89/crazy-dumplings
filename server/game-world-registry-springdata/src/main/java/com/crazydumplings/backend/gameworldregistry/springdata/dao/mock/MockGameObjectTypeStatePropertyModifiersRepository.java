package com.crazydumplings.backend.gameworldregistry.springdata.dao.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.annotation.Generated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameObjectTypeStatePropertyModifiersRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypePropertyEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeStateEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeStatePropertyModifierEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Mock implementation of the specification of the repository for the GameObjectTypeStatePropertyModifier entity")
public class MockGameObjectTypeStatePropertyModifiersRepository implements GameObjectTypeStatePropertyModifiersRepository {
    private final Logger                                    LOGGER = LoggerFactory.getLogger(getClass());

    private List<GameObjectTypeStatePropertyModifierEntity> gameObjectTypeStatePropertyModifiers;

    private Long                                            firstAvailableId;

    public MockGameObjectTypeStatePropertyModifiersRepository() {
        LOGGER.info("Generating mock game object type state property modifiers");

        gameObjectTypeStatePropertyModifiers = new ArrayList<>();

        Random random = new Random();
        long nElements = random.nextInt(500);

        firstAvailableId = (long) 1;
        while (firstAvailableId <= nElements) {
            gameObjectTypeStatePropertyModifiers.add(generateGameObjectTypeStatePropertyModifier(random, firstAvailableId));
            firstAvailableId++;
        }
    }

    protected static GameObjectTypeStatePropertyModifierEntity generateGameObjectTypeStatePropertyModifier(Random random, long id) {
        return generateGameObjectTypeStatePropertyModifier(random, id, true);
    }

    protected static GameObjectTypeStatePropertyModifierEntity generateGameObjectTypeStatePropertyModifier(Random random, long id,
            boolean withDependencies) {
        GameObjectTypeStatePropertyModifierEntity gameObjectTypeStatePropertyModifier = new GameObjectTypeStatePropertyModifierEntity(id);

        gameObjectTypeStatePropertyModifier.setPropertyActualValue(random.nextDouble());

        if (withDependencies) {
            gameObjectTypeStatePropertyModifier
                    .setGameObjectTypeState(MockGameObjectTypeStatesRepository.generateGameObjectTypeState(random, id, false));
            gameObjectTypeStatePropertyModifier
                    .setGameObjectTypeProperty(MockGameObjectTypePropertiesRepository.generateGameObjectTypeProperty(random, id, false));
        }

        return gameObjectTypeStatePropertyModifier;
    }

    @Override
    public List<GameObjectTypeStatePropertyModifierEntity> findAll() {
        return gameObjectTypeStatePropertyModifiers;
    }

    @Override
    public GameObjectTypeStatePropertyModifierEntity findOneById(Long id) {
        return gameObjectTypeStatePropertyModifiers.stream().filter(item -> item.getId() != null && item.getId().equals(id)).findFirst()
                .orElse(null);
    }

    @Override
    public List<GameObjectTypeStatePropertyModifierEntity> findAllByGameObjectTypeState(GameObjectTypeStateEntity gameObjectTypeState) {
        return gameObjectTypeStatePropertyModifiers.stream()
                .filter(item -> item.getGameObjectTypeState() != null && item.getGameObjectTypeState().equals(gameObjectTypeState))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameObjectTypeStatePropertyModifierEntity> findAllByGameObjectTypeProperty(
            GameObjectTypePropertyEntity gameObjectTypeProperty) {
        return gameObjectTypeStatePropertyModifiers.stream()
                .filter(item -> item.getGameObjectTypeProperty() != null && item.getGameObjectTypeProperty().equals(gameObjectTypeProperty))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameObjectTypeStatePropertyModifierEntity> findAllByAnyTextFieldContaining(String content) {
        return gameObjectTypeStatePropertyModifiers.stream()
                .filter(item -> ((item.getGameObjectTypeState() != null && item.getGameObjectTypeState().getName() != null
                        && item.getGameObjectTypeState().getName().contains(content))
                        || (item.getGameObjectTypeProperty() != null && item.getGameObjectTypeProperty().getPropertyName() != null
                                && item.getGameObjectTypeProperty().getPropertyName().contains(content))))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameObjectTypeStatePropertyModifierEntity> findAllByExample(GameObjectTypeStateEntity gameObjectTypeState,
            GameObjectTypePropertyEntity gameObjectTypeProperty, Double propertyActualValue) {
        return gameObjectTypeStatePropertyModifiers.stream()
                .filter(item -> ((item.getGameObjectTypeState() != null && gameObjectTypeState != null
                        && item.getGameObjectTypeState().equals(gameObjectTypeState))
                        || (item.getGameObjectTypeProperty() != null && gameObjectTypeProperty != null
                                && item.getGameObjectTypeProperty().equals(gameObjectTypeProperty))
                        || (item.getPropertyActualValue() != null && item.getPropertyActualValue() == propertyActualValue)))
                .collect(Collectors.toList());
    }

    @Override
    public GameObjectTypeStatePropertyModifierEntity save(GameObjectTypeStatePropertyModifierEntity gameObjectTypeStatePropertyModifier) {
        if (!gameObjectTypeStatePropertyModifiers.contains(gameObjectTypeStatePropertyModifier)) {
            gameObjectTypeStatePropertyModifier = new GameObjectTypeStatePropertyModifierEntity(gameObjectTypeStatePropertyModifier,
                    firstAvailableId);
            gameObjectTypeStatePropertyModifiers.add(gameObjectTypeStatePropertyModifier);
            firstAvailableId++;
        }

        return gameObjectTypeStatePropertyModifier;
    }

    @Override
    public void delete(GameObjectTypeStatePropertyModifierEntity gameObjectTypeStatePropertyModifier) {
        gameObjectTypeStatePropertyModifiers.remove(gameObjectTypeStatePropertyModifier);
    }
}