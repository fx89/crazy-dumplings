package com.crazydumplings.backend.gameworldregistry.springdata.dao.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.annotation.Generated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameObjectTypeStatesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeStateEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Mock implementation of the specification of the repository for the GameObjectTypeState entity")
public class MockGameObjectTypeStatesRepository implements GameObjectTypeStatesRepository {
    private final Logger                    LOGGER = LoggerFactory.getLogger(getClass());

    private List<GameObjectTypeStateEntity> gameObjectTypeStates;

    private Long                            firstAvailableId;

    public MockGameObjectTypeStatesRepository() {
        LOGGER.info("Generating mock game object type states");

        gameObjectTypeStates = new ArrayList<>();

        Random random = new Random();
        long nElements = random.nextInt(100);

        firstAvailableId = (long) 1;
        while (firstAvailableId <= nElements) {
            gameObjectTypeStates.add(generateGameObjectTypeState(random, firstAvailableId));
            firstAvailableId++;
        }
    }

    protected static GameObjectTypeStateEntity generateGameObjectTypeState(Random random, long id) {
        return generateGameObjectTypeState(random, id, true);
    }

    protected static GameObjectTypeStateEntity generateGameObjectTypeState(Random random, long id, boolean withDependencies) {
        GameObjectTypeStateEntity gameObjectTypeState = new GameObjectTypeStateEntity(id);

        gameObjectTypeState.setName("GAME OBJECT TYPE STATE " + id + " NAME");

        if (withDependencies) {
            gameObjectTypeState.setGameObjectType(MockGameObjectTypesRepository.generateGameObjectType(random, id, false));
        }

        return gameObjectTypeState;
    }

    @Override
    public List<GameObjectTypeStateEntity> findAll() {
        return gameObjectTypeStates;
    }

    @Override
    public GameObjectTypeStateEntity findOneById(Long id) {
        return gameObjectTypeStates.stream().filter(item -> item.getId() != null && item.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<GameObjectTypeStateEntity> findAllByGameObjectType(GameObjectTypeEntity gameObjectType) {
        return gameObjectTypeStates.stream().filter(item -> item.getGameObjectType() != null && item.getGameObjectType().equals(gameObjectType))
                .collect(Collectors.toList());
    }

    @Override
    public GameObjectTypeStateEntity findOneByName(String name) {
        return gameObjectTypeStates.stream().filter(item -> item.getName() != null && item.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public List<GameObjectTypeStateEntity> findAllByAnyTextFieldContaining(String content) {
        return gameObjectTypeStates.stream()
                .filter(item -> ((item.getName() != null && item.getName().contains(content)) || (item.getGameObjectType() != null
                        && item.getGameObjectType().getUniqueName() != null && item.getGameObjectType().getUniqueName().contains(content))))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameObjectTypeStateEntity> findAllByExample(GameObjectTypeEntity gameObjectType, String name) {
        return gameObjectTypeStates.stream()
                .filter(item -> ((item.getGameObjectType() != null && gameObjectType != null && item.getGameObjectType().equals(gameObjectType))
                        || (item.getName() != null && item.getName().equals(name))))
                .collect(Collectors.toList());
    }

    @Override
    public GameObjectTypeStateEntity save(GameObjectTypeStateEntity gameObjectTypeState) {
        if (!gameObjectTypeStates.contains(gameObjectTypeState)) {
            gameObjectTypeState = new GameObjectTypeStateEntity(gameObjectTypeState, firstAvailableId);
            gameObjectTypeStates.add(gameObjectTypeState);
            firstAvailableId++;
        }

        return gameObjectTypeState;
    }

    @Override
    public void delete(GameObjectTypeStateEntity gameObjectTypeState) {
        gameObjectTypeStates.remove(gameObjectTypeState);
    }

	@Override
	public void bulkDelete(List<Long> gameObjectTypeStateIds) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<GameObjectTypeStateEntity> findAllByGameObjectTypeAndIds(GameObjectTypeEntity gameObjectType,
			List<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}
}