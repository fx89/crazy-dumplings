package com.crazydumplings.backend.gameworldregistry.springdata.dao.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.annotation.Generated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameWorldsRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameWorldEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Mock implementation of the specification of the repository for the GameWorld entity")
public class MockGameWorldsRepository implements GameWorldsRepository {
    private final Logger          LOGGER = LoggerFactory.getLogger(getClass());

    private List<GameWorldEntity> gameWorlds;

    private Long                  firstAvailableId;

    public MockGameWorldsRepository() {
        LOGGER.info("Generating mock game worlds");

        gameWorlds = new ArrayList<>();

        Random random = new Random();
        long nElements = random.nextInt(100);

        firstAvailableId = (long) 1;
        while (firstAvailableId <= nElements) {
            gameWorlds.add(generateGameWorld(random, firstAvailableId));
            firstAvailableId++;
        }
    }

    protected static GameWorldEntity generateGameWorld(Random random, long id) {
        return generateGameWorld(random, id, true);
    }

    protected static GameWorldEntity generateGameWorld(Random random, long id, boolean withDependencies) {
        GameWorldEntity gameWorld = new GameWorldEntity(id);

        gameWorld.setUniqueName("GAME WORLD " + id + " UNIQUE NAME");
        gameWorld.setDescription("GAME WORLD " + id + " DESCRIPTION");
        gameWorld.setPictureRefPath("GAME WORLD " + id + " PICTURE REF PATH");
        gameWorld.setWidth(random.nextInt());
        gameWorld.setHeight(random.nextInt());

        if (withDependencies) {
        }

        return gameWorld;
    }

    @Override
    public List<GameWorldEntity> findAll() {
        return gameWorlds;
    }

    @Override
    public GameWorldEntity findOneById(Long id) {
        return gameWorlds.stream().filter(item -> item.getId() != null && item.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public GameWorldEntity findOneByUniqueName(String uniqueName) {
        return gameWorlds.stream().filter(item -> item.getUniqueName() != null && item.getUniqueName().equals(uniqueName)).findFirst()
                .orElse(null);
    }

    @Override
    public List<GameWorldEntity> findAllByAnyTextFieldContaining(String content) {
        return gameWorlds.stream()
                .filter(item -> ((item.getUniqueName() != null && item.getUniqueName().contains(content))
                        || (item.getDescription() != null && item.getDescription().contains(content))
                        || (item.getPictureRefPath() != null && item.getPictureRefPath().contains(content))))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameWorldEntity> findAllByExample(String uniqueName, String description, String pictureRefPath, Integer width, Integer height) {
        return gameWorlds.stream()
                .filter(item -> ((item.getUniqueName() != null && item.getUniqueName().equals(uniqueName))
                        || (item.getDescription() != null && item.getDescription().equals(description))
                        || (item.getPictureRefPath() != null && item.getPictureRefPath().equals(pictureRefPath))
                        || (item.getWidth() != null && item.getWidth() == width) || (item.getHeight() != null && item.getHeight() == height)))
                .collect(Collectors.toList());
    }

    @Override
    public GameWorldEntity save(GameWorldEntity gameWorld) {
        if (!gameWorlds.contains(gameWorld)) {
            gameWorld = new GameWorldEntity(gameWorld, firstAvailableId);
            gameWorlds.add(gameWorld);
            firstAvailableId++;
        }

        return gameWorld;
    }

    @Override
    public void delete(GameWorldEntity gameWorld) {
        gameWorlds.remove(gameWorld);
    }
}