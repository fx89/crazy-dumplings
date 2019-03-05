package com.crazydumplings.backend.gameworldregistry.springdata.dao.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.annotation.Generated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameAssetsRepositoriesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameAssetsRepositoryEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Mock implementation of the specification of the repository for the GameAssetsRepository entity")
public class MockGameAssetsRepositoriesRepository implements GameAssetsRepositoriesRepository {
    private final Logger                     LOGGER = LoggerFactory.getLogger(getClass());

    private List<GameAssetsRepositoryEntity> gameAssetsRepositories;

    private Long                             firstAvailableId;

    public MockGameAssetsRepositoriesRepository() {
        LOGGER.info("Generating mock game assets repositories");

        gameAssetsRepositories = new ArrayList<>();

        Random random = new Random();
        long nElements = random.nextInt(100);

        firstAvailableId = (long) 1;
        while (firstAvailableId <= nElements) {
            gameAssetsRepositories.add(generateGameAssetsRepository(random, firstAvailableId));
            firstAvailableId++;
        }
    }

    protected static GameAssetsRepositoryEntity generateGameAssetsRepository(Random random, long id) {
        return generateGameAssetsRepository(random, id, true);
    }

    protected static GameAssetsRepositoryEntity generateGameAssetsRepository(Random random, long id, boolean withDependencies) {
        GameAssetsRepositoryEntity gameAssetsRepository = new GameAssetsRepositoryEntity(id);

        gameAssetsRepository.setUniqueName("GAME ASSETS REPOSITORY " + id + " UNIQUE NAME");
        gameAssetsRepository.setDescription("GAME ASSETS REPOSITORY " + id + " DESCRIPTION");

        if (withDependencies) {
        }

        return gameAssetsRepository;
    }

    @Override
    public List<GameAssetsRepositoryEntity> findAll() {
        return gameAssetsRepositories;
    }

    @Override
    public GameAssetsRepositoryEntity findOneById(Long id) {
        return gameAssetsRepositories.stream().filter(item -> item.getId() != null && item.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public GameAssetsRepositoryEntity findOneByUniqueName(String uniqueName) {
        return gameAssetsRepositories.stream().filter(item -> item.getUniqueName() != null && item.getUniqueName().equals(uniqueName))
                .findFirst().orElse(null);
    }

    @Override
    public List<GameAssetsRepositoryEntity> findAllByAnyTextFieldContaining(String content) {
        return gameAssetsRepositories.stream()
                .filter(item -> ((item.getUniqueName() != null && item.getUniqueName().contains(content))
                        || (item.getDescription() != null && item.getDescription().contains(content))))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameAssetsRepositoryEntity> findAllByExample(String uniqueName, String description) {
        return gameAssetsRepositories.stream()
                .filter(item -> ((item.getUniqueName() != null && item.getUniqueName().equals(uniqueName))
                        || (item.getDescription() != null && item.getDescription().equals(description))
                 ))
                .collect(Collectors.toList());
    }

    @Override
    public GameAssetsRepositoryEntity save(GameAssetsRepositoryEntity gameAssetsRepository) {
        if (!gameAssetsRepositories.contains(gameAssetsRepository)) {
            gameAssetsRepository = new GameAssetsRepositoryEntity(gameAssetsRepository, firstAvailableId);
            gameAssetsRepositories.add(gameAssetsRepository);
            firstAvailableId++;
        }

        return gameAssetsRepository;
    }

    @Override
    public void delete(GameAssetsRepositoryEntity gameAssetsRepository) {
        gameAssetsRepositories.remove(gameAssetsRepository);
    }
}