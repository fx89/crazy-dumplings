package com.crazydumplings.backend.gameworldregistry.springdata.dao.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.annotation.Generated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameObjectTypePropertiesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypePropertyEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Mock implementation of the specification of the repository for the GameObjectTypeProperty entity")
public class MockGameObjectTypePropertiesRepository implements GameObjectTypePropertiesRepository {
    private final Logger                       LOGGER = LoggerFactory.getLogger(getClass());

    private List<GameObjectTypePropertyEntity> gameObjectTypeProperties;

    private Long                               firstAvailableId;

    public MockGameObjectTypePropertiesRepository() {
        LOGGER.info("Generating mock game object type properties");

        gameObjectTypeProperties = new ArrayList<>();

        Random random = new Random();
        long nElements = random.nextInt(100);

        firstAvailableId = (long) 1;
        while (firstAvailableId <= nElements) {
            gameObjectTypeProperties.add(generateGameObjectTypeProperty(random, firstAvailableId));
            firstAvailableId++;
        }
    }

    protected static GameObjectTypePropertyEntity generateGameObjectTypeProperty(Random random, long id) {
        return generateGameObjectTypeProperty(random, id, true);
    }

    protected static GameObjectTypePropertyEntity generateGameObjectTypeProperty(Random random, long id, boolean withDependencies) {
        GameObjectTypePropertyEntity gameObjectTypeProperty = new GameObjectTypePropertyEntity(id);

        gameObjectTypeProperty.setPropertyName("GAME OBJECT TYPE PROPERTY " + id + " PROPERTY NAME");
        gameObjectTypeProperty.setPropertyDefaultValue(random.nextDouble());
        gameObjectTypeProperty.setPropertyMinValue(random.nextDouble());
        gameObjectTypeProperty.setPropertyMaxValue(random.nextDouble());

        if (withDependencies) {
            gameObjectTypeProperty.setGameObjectType(MockGameObjectTypesRepository.generateGameObjectType(random, id, false));
        }

        return gameObjectTypeProperty;
    }

    @Override
    public List<GameObjectTypePropertyEntity> findAll() {
        return gameObjectTypeProperties;
    }

    @Override
    public GameObjectTypePropertyEntity findOneById(Long id) {
        return gameObjectTypeProperties.stream().filter(item -> item.getId() != null && item.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<GameObjectTypePropertyEntity> findAllByGameObjectType(GameObjectTypeEntity gameObjectType) {
        return gameObjectTypeProperties.stream()
                .filter(item -> item.getGameObjectType() != null && item.getGameObjectType().equals(gameObjectType))
                .collect(Collectors.toList());
    }

    @Override
    public GameObjectTypePropertyEntity findOneByPropertyName(String propertyName) {
        return gameObjectTypeProperties.stream().filter(item -> item.getPropertyName() != null && item.getPropertyName().equals(propertyName))
                .findFirst().orElse(null);
    }

    @Override
    public List<GameObjectTypePropertyEntity> findAllByAnyTextFieldContaining(String content) {
        return gameObjectTypeProperties.stream().filter(
                item -> ((item.getPropertyName() != null && item.getPropertyName().contains(content)) || (item.getGameObjectType() != null
                        && item.getGameObjectType().getUniqueName() != null && item.getGameObjectType().getUniqueName().contains(content))))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameObjectTypePropertyEntity> findAllByExample(GameObjectTypeEntity gameObjectType, String propertyName,
            Double propertyDefaultValue, Double propertyMinValue, Double propertyMaxValue) {
        return gameObjectTypeProperties.stream()
                .filter(item -> ((item.getGameObjectType() != null && gameObjectType != null && item.getGameObjectType().equals(gameObjectType))
                        || (item.getPropertyName() != null && item.getPropertyName().equals(propertyName))
                        || (item.getPropertyDefaultValue() != null && item.getPropertyDefaultValue() == propertyDefaultValue)
                        || (item.getPropertyMinValue() != null && item.getPropertyMinValue() == propertyMinValue)
                        || (item.getPropertyMaxValue() != null && item.getPropertyMaxValue() == propertyMaxValue)))
                .collect(Collectors.toList());
    }

    @Override
    public GameObjectTypePropertyEntity save(GameObjectTypePropertyEntity gameObjectTypeProperty) {
        if (!gameObjectTypeProperties.contains(gameObjectTypeProperty)) {
            gameObjectTypeProperty = new GameObjectTypePropertyEntity(gameObjectTypeProperty, firstAvailableId);
            gameObjectTypeProperties.add(gameObjectTypeProperty);
            firstAvailableId++;
        }

        return gameObjectTypeProperty;
    }

    @Override
    public void delete(GameObjectTypePropertyEntity gameObjectTypeProperty) {
        gameObjectTypeProperties.remove(gameObjectTypeProperty);
    }
}