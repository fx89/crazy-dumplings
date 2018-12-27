package com.crazydumplings.backend.gameworldregistry.springdata.dao.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.annotation.Generated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.ActionsRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.ActionEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Mock implementation of the specification of the repository for the Action entity")
public class MockActionsRepository implements ActionsRepository {
    private final Logger       LOGGER = LoggerFactory.getLogger(getClass());

    private List<ActionEntity> actions;

    private Long               firstAvailableId;

    public MockActionsRepository() {
        LOGGER.info("Generating mock actions");

        actions = new ArrayList<>();

        Random random = new Random();
        long nElements = random.nextInt(100);

        firstAvailableId = (long) 1;
        while (firstAvailableId <= nElements) {
            actions.add(generateAction(random, firstAvailableId));
            firstAvailableId++;
        }
    }

    protected static ActionEntity generateAction(Random random, long id) {
        return generateAction(random, id, true);
    }

    protected static ActionEntity generateAction(Random random, long id, boolean withDependencies) {
        ActionEntity action = new ActionEntity(id);

        action.setUniqueName("ACTION " + id + " UNIQUE NAME");

        if (withDependencies) {
        }

        return action;
    }

    @Override
    public List<ActionEntity> findAll() {
        return actions;
    }

    @Override
    public ActionEntity findOneById(Long id) {
        return actions.stream().filter(item -> item.getId() != null && item.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public ActionEntity findOneByUniqueName(String uniqueName) {
        return actions.stream().filter(item -> item.getUniqueName() != null && item.getUniqueName().equals(uniqueName)).findFirst()
                .orElse(null);
    }

    @Override
    public List<ActionEntity> findAllByAnyTextFieldContaining(String content) {
        return actions.stream().filter(item -> ((item.getUniqueName() != null && item.getUniqueName().contains(content))))
                .collect(Collectors.toList());
    }

    @Override
    public List<ActionEntity> findAllByExample(String uniqueName) {
        return actions.stream().filter(item -> ((item.getUniqueName() != null && item.getUniqueName().equals(uniqueName))))
                .collect(Collectors.toList());
    }

    @Override
    public ActionEntity save(ActionEntity action) {
        if (!actions.contains(action)) {
            action = new ActionEntity(action, firstAvailableId);
            actions.add(action);
            firstAvailableId++;
        }

        return action;
    }

    @Override
    public void delete(ActionEntity action) {
        actions.remove(action);
    }
}