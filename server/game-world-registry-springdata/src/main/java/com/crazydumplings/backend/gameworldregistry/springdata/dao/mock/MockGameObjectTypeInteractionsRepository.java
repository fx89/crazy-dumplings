package com.crazydumplings.backend.gameworldregistry.springdata.dao.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.annotation.Generated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameObjectTypeInteractionsRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeInteractionEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Mock implementation of the specification of the repository for the GameObjectTypeInteraction entity")
public class MockGameObjectTypeInteractionsRepository implements GameObjectTypeInteractionsRepository {
    private final Logger                          LOGGER = LoggerFactory.getLogger(getClass());

    private List<GameObjectTypeInteractionEntity> gameObjectTypeInteractions;

    private Long                                  firstAvailableId;

    public MockGameObjectTypeInteractionsRepository() {
        LOGGER.info("Generating mock game object type interactions");

        gameObjectTypeInteractions = new ArrayList<>();

        Random random = new Random();
        long nElements = random.nextInt(500);

        firstAvailableId = (long) 1;
        while (firstAvailableId <= nElements) {
            gameObjectTypeInteractions.add(generateGameObjectTypeInteraction(random, firstAvailableId));
            firstAvailableId++;
        }
    }

    protected static GameObjectTypeInteractionEntity generateGameObjectTypeInteraction(Random random, long id) {
        return generateGameObjectTypeInteraction(random, id, true);
    }

    protected static GameObjectTypeInteractionEntity generateGameObjectTypeInteraction(Random random, long id, boolean withDependencies) {
        GameObjectTypeInteractionEntity gameObjectTypeInteraction = new GameObjectTypeInteractionEntity(id);

        gameObjectTypeInteraction.setRadius(random.nextInt());

        if (withDependencies) {
            gameObjectTypeInteraction.setDonatingGameObjectType(MockGameObjectTypesRepository.generateGameObjectType(random, id, false));
            gameObjectTypeInteraction.setReceivingGameObjectType(MockGameObjectTypesRepository.generateGameObjectType(random, id, false));
        }

        return gameObjectTypeInteraction;
    }

    @Override
    public List<GameObjectTypeInteractionEntity> findAll() {
        return gameObjectTypeInteractions;
    }

    @Override
    public GameObjectTypeInteractionEntity findOneById(Long id) {
        return gameObjectTypeInteractions.stream().filter(item -> item.getId() != null && item.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<GameObjectTypeInteractionEntity> findAllByDonatingGameObjectType(GameObjectTypeEntity donatingGameObjectType) {
        return gameObjectTypeInteractions.stream()
                .filter(item -> item.getDonatingGameObjectType() != null && item.getDonatingGameObjectType().equals(donatingGameObjectType))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameObjectTypeInteractionEntity> findAllByReceivingGameObjectType(GameObjectTypeEntity receivingGameObjectType) {
        return gameObjectTypeInteractions.stream()
                .filter(item -> item.getReceivingGameObjectType() != null && item.getReceivingGameObjectType().equals(receivingGameObjectType))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameObjectTypeInteractionEntity> findAllByAnyTextFieldContaining(String content) {
        return gameObjectTypeInteractions.stream()
                .filter(item -> ((item.getDonatingGameObjectType() != null && item.getDonatingGameObjectType().getUniqueName() != null
                        && item.getDonatingGameObjectType().getUniqueName().contains(content))
                        || (item.getReceivingGameObjectType() != null && item.getReceivingGameObjectType().getUniqueName() != null
                                && item.getReceivingGameObjectType().getUniqueName().contains(content))))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameObjectTypeInteractionEntity> findAllByExample(GameObjectTypeEntity donatingGameObjectType,
            GameObjectTypeEntity receivingGameObjectType, Integer radius) {
        return gameObjectTypeInteractions.stream()
                .filter(item -> ((item.getDonatingGameObjectType() != null && donatingGameObjectType != null
                        && item.getDonatingGameObjectType().equals(donatingGameObjectType))
                        || (item.getReceivingGameObjectType() != null && receivingGameObjectType != null
                                && item.getReceivingGameObjectType().equals(receivingGameObjectType))
                        || (item.getRadius() != null && item.getRadius() == radius)))
                .collect(Collectors.toList());
    }

    @Override
    public GameObjectTypeInteractionEntity save(GameObjectTypeInteractionEntity gameObjectTypeInteraction) {
        if (!gameObjectTypeInteractions.contains(gameObjectTypeInteraction)) {
            gameObjectTypeInteraction = new GameObjectTypeInteractionEntity(gameObjectTypeInteraction, firstAvailableId);
            gameObjectTypeInteractions.add(gameObjectTypeInteraction);
            firstAvailableId++;
        }

        return gameObjectTypeInteraction;
    }

    @Override
    public void delete(GameObjectTypeInteractionEntity gameObjectTypeInteraction) {
        gameObjectTypeInteractions.remove(gameObjectTypeInteraction);
    }
}