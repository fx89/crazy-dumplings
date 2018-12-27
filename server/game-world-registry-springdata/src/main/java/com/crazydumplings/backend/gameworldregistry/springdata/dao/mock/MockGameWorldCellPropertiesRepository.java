package com.crazydumplings.backend.gameworldregistry.springdata.dao.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.annotation.Generated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameWorldCellPropertiesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypePropertyEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameWorldCellEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameWorldCellPropertyEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Mock implementation of the specification of the repository for the GameWorldCellProperty entity")
public class MockGameWorldCellPropertiesRepository implements GameWorldCellPropertiesRepository {
    private final Logger                      LOGGER = LoggerFactory.getLogger(getClass());

    private List<GameWorldCellPropertyEntity> gameWorldCellProperties;

    private Long                              firstAvailableId;

    public MockGameWorldCellPropertiesRepository() {
        LOGGER.info("Generating mock game world cell properties");

        gameWorldCellProperties = new ArrayList<>();

        Random random = new Random();
        long nElements = random.nextInt(500);

        firstAvailableId = (long) 1;
        while (firstAvailableId <= nElements) {
            gameWorldCellProperties.add(generateGameWorldCellProperty(random, firstAvailableId));
            firstAvailableId++;
        }
    }

    protected static GameWorldCellPropertyEntity generateGameWorldCellProperty(Random random, long id) {
        return generateGameWorldCellProperty(random, id, true);
    }

    protected static GameWorldCellPropertyEntity generateGameWorldCellProperty(Random random, long id, boolean withDependencies) {
        GameWorldCellPropertyEntity gameWorldCellProperty = new GameWorldCellPropertyEntity(id);

        gameWorldCellProperty.setPropertyActualValue(random.nextDouble());

        if (withDependencies) {
            gameWorldCellProperty.setGameWorldCell(MockGameWorldCellsRepository.generateGameWorldCell(random, id, false));
            gameWorldCellProperty
                    .setGameObjectTypeProperty(MockGameObjectTypePropertiesRepository.generateGameObjectTypeProperty(random, id, false));
        }

        return gameWorldCellProperty;
    }

    @Override
    public List<GameWorldCellPropertyEntity> findAll() {
        return gameWorldCellProperties;
    }

    @Override
    public GameWorldCellPropertyEntity findOneById(Long id) {
        return gameWorldCellProperties.stream().filter(item -> item.getId() != null && item.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<GameWorldCellPropertyEntity> findAllByGameWorldCell(GameWorldCellEntity gameWorldCell) {
        return gameWorldCellProperties.stream().filter(item -> item.getGameWorldCell() != null && item.getGameWorldCell().equals(gameWorldCell))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameWorldCellPropertyEntity> findAllByGameObjectTypeProperty(GameObjectTypePropertyEntity gameObjectTypeProperty) {
        return gameWorldCellProperties.stream()
                .filter(item -> item.getGameObjectTypeProperty() != null && item.getGameObjectTypeProperty().equals(gameObjectTypeProperty))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameWorldCellPropertyEntity> findAllByAnyTextFieldContaining(String content) {
        return gameWorldCellProperties.stream()
                .filter(item -> ((item.getGameObjectTypeProperty() != null && item.getGameObjectTypeProperty().getPropertyName() != null
                        && item.getGameObjectTypeProperty().getPropertyName().contains(content))))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameWorldCellPropertyEntity> findAllByExample(GameWorldCellEntity gameWorldCell,
            GameObjectTypePropertyEntity gameObjectTypeProperty, Double propertyActualValue) {
        return gameWorldCellProperties.stream()
                .filter(item -> ((item.getGameWorldCell() != null && gameWorldCell != null && item.getGameWorldCell().equals(gameWorldCell))
                        || (item.getGameObjectTypeProperty() != null && gameObjectTypeProperty != null
                                && item.getGameObjectTypeProperty().equals(gameObjectTypeProperty))
                        || (item.getPropertyActualValue() != null && item.getPropertyActualValue() == propertyActualValue)))
                .collect(Collectors.toList());
    }

    @Override
    public GameWorldCellPropertyEntity save(GameWorldCellPropertyEntity gameWorldCellProperty) {
        if (!gameWorldCellProperties.contains(gameWorldCellProperty)) {
            gameWorldCellProperty = new GameWorldCellPropertyEntity(gameWorldCellProperty, firstAvailableId);
            gameWorldCellProperties.add(gameWorldCellProperty);
            firstAvailableId++;
        }

        return gameWorldCellProperty;
    }

    @Override
    public void delete(GameWorldCellPropertyEntity gameWorldCellProperty) {
        gameWorldCellProperties.remove(gameWorldCellProperty);
    }
}