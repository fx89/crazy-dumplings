package com.crazydumplings.backend.gameworldregistry.springdata.dao.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.annotation.Generated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameObjectTypeInteractionPropertiesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeInteractionEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeInteractionPropertyEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypePropertyEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Mock implementation of the specification of the repository for the GameObjectTypeInteractionProperty entity")
public class MockGameObjectTypeInteractionPropertiesRepository implements GameObjectTypeInteractionPropertiesRepository {
    private final Logger                                  LOGGER = LoggerFactory.getLogger(getClass());

    private List<GameObjectTypeInteractionPropertyEntity> gameObjectTypeInteractionProperties;

    private Long                                          firstAvailableId;

    public MockGameObjectTypeInteractionPropertiesRepository() {
        LOGGER.info("Generating mock game object type interaction properties");

        gameObjectTypeInteractionProperties = new ArrayList<>();

        Random random = new Random();
        long nElements = random.nextInt(500);

        firstAvailableId = (long) 1;
        while (firstAvailableId <= nElements) {
            gameObjectTypeInteractionProperties.add(generateGameObjectTypeInteractionProperty(random, firstAvailableId));
            firstAvailableId++;
        }
    }

    protected static GameObjectTypeInteractionPropertyEntity generateGameObjectTypeInteractionProperty(Random random, long id) {
        return generateGameObjectTypeInteractionProperty(random, id, true);
    }

    protected static GameObjectTypeInteractionPropertyEntity generateGameObjectTypeInteractionProperty(Random random, long id,
            boolean withDependencies) {
        GameObjectTypeInteractionPropertyEntity gameObjectTypeInteractionProperty = new GameObjectTypeInteractionPropertyEntity(id);

        gameObjectTypeInteractionProperty.setIsIncremental(random.nextBoolean());
        gameObjectTypeInteractionProperty.setIsInverted(random.nextBoolean());

        if (withDependencies) {
            gameObjectTypeInteractionProperty.setGameObjectTypeInteraction(
                    MockGameObjectTypeInteractionsRepository.generateGameObjectTypeInteraction(random, id, false));
            gameObjectTypeInteractionProperty.setDonatingGameObjectTypeProperty(
                    MockGameObjectTypePropertiesRepository.generateGameObjectTypeProperty(random, id, false));
            gameObjectTypeInteractionProperty.setReceivingGameObjectTypeProperty(
                    MockGameObjectTypePropertiesRepository.generateGameObjectTypeProperty(random, id, false));
            gameObjectTypeInteractionProperty.setOverflowGameObjectTypeProperty(
                    MockGameObjectTypePropertiesRepository.generateGameObjectTypeProperty(random, id, false));
        }

        return gameObjectTypeInteractionProperty;
    }

    @Override
    public List<GameObjectTypeInteractionPropertyEntity> findAll() {
        return gameObjectTypeInteractionProperties;
    }

    @Override
    public GameObjectTypeInteractionPropertyEntity findOneById(Long id) {
        return gameObjectTypeInteractionProperties.stream().filter(item -> item.getId() != null && item.getId().equals(id)).findFirst()
                .orElse(null);
    }

    @Override
    public List<GameObjectTypeInteractionPropertyEntity> findAllByGameObjectTypeInteraction(
            GameObjectTypeInteractionEntity gameObjectTypeInteraction) {
        return gameObjectTypeInteractionProperties.stream().filter(
                item -> item.getGameObjectTypeInteraction() != null && item.getGameObjectTypeInteraction().equals(gameObjectTypeInteraction))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameObjectTypeInteractionPropertyEntity> findAllByDonatingGameObjectTypeProperty(
            GameObjectTypePropertyEntity donatingGameObjectTypeProperty) {
        return gameObjectTypeInteractionProperties.stream().filter(item -> item.getDonatingGameObjectTypeProperty() != null
                && item.getDonatingGameObjectTypeProperty().equals(donatingGameObjectTypeProperty)).collect(Collectors.toList());
    }

    @Override
    public List<GameObjectTypeInteractionPropertyEntity> findAllByReceivingGameObjectTypeProperty(
            GameObjectTypePropertyEntity receivingGameObjectTypeProperty) {
        return gameObjectTypeInteractionProperties.stream().filter(item -> item.getReceivingGameObjectTypeProperty() != null
                && item.getReceivingGameObjectTypeProperty().equals(receivingGameObjectTypeProperty)).collect(Collectors.toList());
    }

    @Override
    public List<GameObjectTypeInteractionPropertyEntity> findAllByOverflowGameObjectTypeProperty(
            GameObjectTypePropertyEntity overflowGameObjectTypeProperty) {
        return gameObjectTypeInteractionProperties.stream().filter(item -> item.getOverflowGameObjectTypeProperty() != null
                && item.getOverflowGameObjectTypeProperty().equals(overflowGameObjectTypeProperty)).collect(Collectors.toList());
    }

    @Override
    public List<GameObjectTypeInteractionPropertyEntity> findAllByAnyTextFieldContaining(String content) {
        return gameObjectTypeInteractionProperties.stream()
                .filter(item -> ((item.getDonatingGameObjectTypeProperty() != null
                        && item.getDonatingGameObjectTypeProperty().getPropertyName() != null
                        && item.getDonatingGameObjectTypeProperty().getPropertyName().contains(content))
                        || (item.getReceivingGameObjectTypeProperty() != null
                                && item.getReceivingGameObjectTypeProperty().getPropertyName() != null
                                && item.getReceivingGameObjectTypeProperty().getPropertyName().contains(content))
                        || (item.getOverflowGameObjectTypeProperty() != null
                                && item.getOverflowGameObjectTypeProperty().getPropertyName() != null
                                && item.getOverflowGameObjectTypeProperty().getPropertyName().contains(content))))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameObjectTypeInteractionPropertyEntity> findAllByExample(GameObjectTypeInteractionEntity gameObjectTypeInteraction,
            GameObjectTypePropertyEntity donatingGameObjectTypeProperty, GameObjectTypePropertyEntity receivingGameObjectTypeProperty,
            GameObjectTypePropertyEntity overflowGameObjectTypeProperty, Boolean isIncremental, Boolean isInverted) {
        return gameObjectTypeInteractionProperties.stream()
                .filter(item -> ((item.getGameObjectTypeInteraction() != null && gameObjectTypeInteraction != null
                        && item.getGameObjectTypeInteraction().equals(gameObjectTypeInteraction))
                        || (item.getDonatingGameObjectTypeProperty() != null && donatingGameObjectTypeProperty != null
                                && item.getDonatingGameObjectTypeProperty().equals(donatingGameObjectTypeProperty))
                        || (item.getReceivingGameObjectTypeProperty() != null && receivingGameObjectTypeProperty != null
                                && item.getReceivingGameObjectTypeProperty().equals(receivingGameObjectTypeProperty))
                        || (item.getOverflowGameObjectTypeProperty() != null && overflowGameObjectTypeProperty != null
                                && item.getOverflowGameObjectTypeProperty().equals(overflowGameObjectTypeProperty))
                        || (item.getIsIncremental() != null && item.getIsIncremental() == isIncremental)
                        || (item.getIsInverted() != null && item.getIsInverted() == isInverted)))
                .collect(Collectors.toList());
    }

    @Override
    public GameObjectTypeInteractionPropertyEntity save(GameObjectTypeInteractionPropertyEntity gameObjectTypeInteractionProperty) {
        if (!gameObjectTypeInteractionProperties.contains(gameObjectTypeInteractionProperty)) {
            gameObjectTypeInteractionProperty = new GameObjectTypeInteractionPropertyEntity(gameObjectTypeInteractionProperty,
                    firstAvailableId);
            gameObjectTypeInteractionProperties.add(gameObjectTypeInteractionProperty);
            firstAvailableId++;
        }

        return gameObjectTypeInteractionProperty;
    }

    @Override
    public void delete(GameObjectTypeInteractionPropertyEntity gameObjectTypeInteractionProperty) {
        gameObjectTypeInteractionProperties.remove(gameObjectTypeInteractionProperty);
    }
}