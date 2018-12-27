package com.crazydumplings.backend.gameworldregistry.springdata.dao.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.annotation.Generated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameAddonInteractionReceivingPropertyModifiersRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameAddonInteractionReceivingPropertyModifierEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeAllowedAddonTypeEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypePropertyEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Mock implementation of the specification of the repository for the GameAddonInteractionReceivingPropertyModifier entity")
public class MockGameAddonInteractionReceivingPropertyModifiersRepository implements GameAddonInteractionReceivingPropertyModifiersRepository {
    private final Logger                                              LOGGER = LoggerFactory.getLogger(getClass());

    private List<GameAddonInteractionReceivingPropertyModifierEntity> gameAddonInteractionReceivingPropertyModifiers;

    private Long                                                      firstAvailableId;

    public MockGameAddonInteractionReceivingPropertyModifiersRepository() {
        LOGGER.info("Generating mock game addon interaction receiving property modifiers");

        gameAddonInteractionReceivingPropertyModifiers = new ArrayList<>();

        Random random = new Random();
        long nElements = random.nextInt(500);

        firstAvailableId = (long) 1;
        while (firstAvailableId <= nElements) {
            gameAddonInteractionReceivingPropertyModifiers.add(generateGameAddonInteractionReceivingPropertyModifier(random, firstAvailableId));
            firstAvailableId++;
        }
    }

    protected static GameAddonInteractionReceivingPropertyModifierEntity generateGameAddonInteractionReceivingPropertyModifier(Random random,
            long id) {
        return generateGameAddonInteractionReceivingPropertyModifier(random, id, true);
    }

    protected static GameAddonInteractionReceivingPropertyModifierEntity generateGameAddonInteractionReceivingPropertyModifier(Random random,
            long id, boolean withDependencies) {
        GameAddonInteractionReceivingPropertyModifierEntity gameAddonInteractionReceivingPropertyModifier = new GameAddonInteractionReceivingPropertyModifierEntity(
                id);

        gameAddonInteractionReceivingPropertyModifier.setAppliedPropertyValueMultiplier(random.nextDouble());

        if (withDependencies) {
            gameAddonInteractionReceivingPropertyModifier.setGameObjectTypeAllowedAddonType(
                    MockGameObjectTypeAllowedAddonTypesRepository.generateGameObjectTypeAllowedAddonType(random, id, false));
            gameAddonInteractionReceivingPropertyModifier.setAffectedGameObjectTypeProperty(
                    MockGameObjectTypePropertiesRepository.generateGameObjectTypeProperty(random, id, false));
        }

        return gameAddonInteractionReceivingPropertyModifier;
    }

    @Override
    public List<GameAddonInteractionReceivingPropertyModifierEntity> findAll() {
        return gameAddonInteractionReceivingPropertyModifiers;
    }

    @Override
    public GameAddonInteractionReceivingPropertyModifierEntity findOneById(Long id) {
        return gameAddonInteractionReceivingPropertyModifiers.stream().filter(item -> item.getId() != null && item.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public List<GameAddonInteractionReceivingPropertyModifierEntity> findAllByGameObjectTypeAllowedAddonType(
            GameObjectTypeAllowedAddonTypeEntity gameObjectTypeAllowedAddonType) {
        return gameAddonInteractionReceivingPropertyModifiers.stream().filter(item -> item.getGameObjectTypeAllowedAddonType() != null
                && item.getGameObjectTypeAllowedAddonType().equals(gameObjectTypeAllowedAddonType)).collect(Collectors.toList());
    }

    @Override
    public List<GameAddonInteractionReceivingPropertyModifierEntity> findAllByAffectedGameObjectTypeProperty(
            GameObjectTypePropertyEntity affectedGameObjectTypeProperty) {
        return gameAddonInteractionReceivingPropertyModifiers.stream().filter(item -> item.getAffectedGameObjectTypeProperty() != null
                && item.getAffectedGameObjectTypeProperty().equals(affectedGameObjectTypeProperty)).collect(Collectors.toList());
    }

    @Override
    public List<GameAddonInteractionReceivingPropertyModifierEntity> findAllByAnyTextFieldContaining(String content) {
        return gameAddonInteractionReceivingPropertyModifiers.stream()
                .filter(item -> ((item.getGameObjectTypeAllowedAddonType() != null
                        && item.getGameObjectTypeAllowedAddonType().getUniqueName() != null
                        && item.getGameObjectTypeAllowedAddonType().getUniqueName().contains(content))
                        || (item.getAffectedGameObjectTypeProperty() != null
                                && item.getAffectedGameObjectTypeProperty().getPropertyName() != null
                                && item.getAffectedGameObjectTypeProperty().getPropertyName().contains(content))))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameAddonInteractionReceivingPropertyModifierEntity> findAllByExample(
            GameObjectTypeAllowedAddonTypeEntity gameObjectTypeAllowedAddonType, GameObjectTypePropertyEntity affectedGameObjectTypeProperty,
            Double appliedPropertyValueMultiplier) {
        return gameAddonInteractionReceivingPropertyModifiers.stream()
                .filter(item -> ((item.getGameObjectTypeAllowedAddonType() != null && gameObjectTypeAllowedAddonType != null
                        && item.getGameObjectTypeAllowedAddonType().equals(gameObjectTypeAllowedAddonType))
                        || (item.getAffectedGameObjectTypeProperty() != null && affectedGameObjectTypeProperty != null
                                && item.getAffectedGameObjectTypeProperty().equals(affectedGameObjectTypeProperty))
                        || (item.getAppliedPropertyValueMultiplier() != null
                                && item.getAppliedPropertyValueMultiplier() == appliedPropertyValueMultiplier)))
                .collect(Collectors.toList());
    }

    @Override
    public GameAddonInteractionReceivingPropertyModifierEntity save(
            GameAddonInteractionReceivingPropertyModifierEntity gameAddonInteractionReceivingPropertyModifier) {
        if (!gameAddonInteractionReceivingPropertyModifiers.contains(gameAddonInteractionReceivingPropertyModifier)) {
            gameAddonInteractionReceivingPropertyModifier = new GameAddonInteractionReceivingPropertyModifierEntity(
                    gameAddonInteractionReceivingPropertyModifier, firstAvailableId);
            gameAddonInteractionReceivingPropertyModifiers.add(gameAddonInteractionReceivingPropertyModifier);
            firstAvailableId++;
        }

        return gameAddonInteractionReceivingPropertyModifier;
    }

    @Override
    public void delete(GameAddonInteractionReceivingPropertyModifierEntity gameAddonInteractionReceivingPropertyModifier) {
        gameAddonInteractionReceivingPropertyModifiers.remove(gameAddonInteractionReceivingPropertyModifier);
    }
}