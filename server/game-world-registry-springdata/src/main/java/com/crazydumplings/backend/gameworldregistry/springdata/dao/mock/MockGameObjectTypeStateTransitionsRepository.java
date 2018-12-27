package com.crazydumplings.backend.gameworldregistry.springdata.dao.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.annotation.Generated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameObjectTypeStateTransitionsRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.ActionEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeStateEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeStateTransitionEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Mock implementation of the specification of the repository for the GameObjectTypeStateTransition entity")
public class MockGameObjectTypeStateTransitionsRepository implements GameObjectTypeStateTransitionsRepository {
    private final Logger                              LOGGER = LoggerFactory.getLogger(getClass());

    private List<GameObjectTypeStateTransitionEntity> gameObjectTypeStateTransitions;

    private Long                                      firstAvailableId;

    public MockGameObjectTypeStateTransitionsRepository() {
        LOGGER.info("Generating mock game object type state transitions");

        gameObjectTypeStateTransitions = new ArrayList<>();

        Random random = new Random();
        long nElements = random.nextInt(500);

        firstAvailableId = (long) 1;
        while (firstAvailableId <= nElements) {
            gameObjectTypeStateTransitions.add(generateGameObjectTypeStateTransition(random, firstAvailableId));
            firstAvailableId++;
        }
    }

    protected static GameObjectTypeStateTransitionEntity generateGameObjectTypeStateTransition(Random random, long id) {
        return generateGameObjectTypeStateTransition(random, id, true);
    }

    protected static GameObjectTypeStateTransitionEntity generateGameObjectTypeStateTransition(Random random, long id,
            boolean withDependencies) {
        GameObjectTypeStateTransitionEntity gameObjectTypeStateTransition = new GameObjectTypeStateTransitionEntity(id);

        gameObjectTypeStateTransition.setIsAutomatic(random.nextBoolean());

        if (withDependencies) {
            gameObjectTypeStateTransition
                    .setSourceGameObjectTypeState(MockGameObjectTypeStatesRepository.generateGameObjectTypeState(random, id, false));
            gameObjectTypeStateTransition
                    .setTargetGameObjectTypeState(MockGameObjectTypeStatesRepository.generateGameObjectTypeState(random, id, false));
            gameObjectTypeStateTransition.setTriggerAction(MockActionsRepository.generateAction(random, id, false));
        }

        return gameObjectTypeStateTransition;
    }

    @Override
    public List<GameObjectTypeStateTransitionEntity> findAll() {
        return gameObjectTypeStateTransitions;
    }

    @Override
    public GameObjectTypeStateTransitionEntity findOneById(Long id) {
        return gameObjectTypeStateTransitions.stream().filter(item -> item.getId() != null && item.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<GameObjectTypeStateTransitionEntity> findAllBySourceGameObjectTypeState(GameObjectTypeStateEntity sourceGameObjectTypeState) {
        return gameObjectTypeStateTransitions.stream().filter(
                item -> item.getSourceGameObjectTypeState() != null && item.getSourceGameObjectTypeState().equals(sourceGameObjectTypeState))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameObjectTypeStateTransitionEntity> findAllByTargetGameObjectTypeState(GameObjectTypeStateEntity targetGameObjectTypeState) {
        return gameObjectTypeStateTransitions.stream().filter(
                item -> item.getTargetGameObjectTypeState() != null && item.getTargetGameObjectTypeState().equals(targetGameObjectTypeState))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameObjectTypeStateTransitionEntity> findAllByTriggerAction(ActionEntity triggerAction) {
        return gameObjectTypeStateTransitions.stream()
                .filter(item -> item.getTriggerAction() != null && item.getTriggerAction().equals(triggerAction)).collect(Collectors.toList());
    }

    @Override
    public List<GameObjectTypeStateTransitionEntity> findAllByAnyTextFieldContaining(String content) {
        return gameObjectTypeStateTransitions.stream()
                .filter(item -> ((item.getSourceGameObjectTypeState() != null && item.getSourceGameObjectTypeState().getName() != null
                        && item.getSourceGameObjectTypeState().getName().contains(content))
                        || (item.getTargetGameObjectTypeState() != null && item.getTargetGameObjectTypeState().getName() != null
                                && item.getTargetGameObjectTypeState().getName().contains(content))
                        || (item.getTriggerAction() != null && item.getTriggerAction().getUniqueName() != null
                                && item.getTriggerAction().getUniqueName().contains(content))))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameObjectTypeStateTransitionEntity> findAllByExample(GameObjectTypeStateEntity sourceGameObjectTypeState,
            GameObjectTypeStateEntity targetGameObjectTypeState, Boolean isAutomatic, ActionEntity triggerAction) {
        return gameObjectTypeStateTransitions.stream()
                .filter(item -> ((item.getSourceGameObjectTypeState() != null && sourceGameObjectTypeState != null
                        && item.getSourceGameObjectTypeState().equals(sourceGameObjectTypeState))
                        || (item.getTargetGameObjectTypeState() != null && targetGameObjectTypeState != null
                                && item.getTargetGameObjectTypeState().equals(targetGameObjectTypeState))
                        || (item.getIsAutomatic() != null && item.getIsAutomatic() == isAutomatic)
                        || (item.getTriggerAction() != null && triggerAction != null && item.getTriggerAction().equals(triggerAction))))
                .collect(Collectors.toList());
    }

    @Override
    public GameObjectTypeStateTransitionEntity save(GameObjectTypeStateTransitionEntity gameObjectTypeStateTransition) {
        if (!gameObjectTypeStateTransitions.contains(gameObjectTypeStateTransition)) {
            gameObjectTypeStateTransition = new GameObjectTypeStateTransitionEntity(gameObjectTypeStateTransition, firstAvailableId);
            gameObjectTypeStateTransitions.add(gameObjectTypeStateTransition);
            firstAvailableId++;
        }

        return gameObjectTypeStateTransition;
    }

    @Override
    public void delete(GameObjectTypeStateTransitionEntity gameObjectTypeStateTransition) {
        gameObjectTypeStateTransitions.remove(gameObjectTypeStateTransition);
    }
}