package com.crazydumplings.backend.gameworldregistry.springdata.dao.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.annotation.Generated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameObjectTypesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameAssetsRepositoryEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeClassEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Mock implementation of the specification of the repository for the GameObjectType entity")
public class MockGameObjectTypesRepository implements GameObjectTypesRepository {
    private final Logger               LOGGER = LoggerFactory.getLogger(getClass());

    private List<GameObjectTypeEntity> gameObjectTypes;

    private Long                       firstAvailableId;

    public MockGameObjectTypesRepository() {
        LOGGER.info("Generating mock game object types");

        gameObjectTypes = new ArrayList<>();

        Random random = new Random();
        long nElements = random.nextInt(100);

        firstAvailableId = (long) 1;
        while (firstAvailableId <= nElements) {
            gameObjectTypes.add(generateGameObjectType(random, firstAvailableId));
            firstAvailableId++;
        }
    }

    protected static GameObjectTypeEntity generateGameObjectType(Random random, long id) {
        return generateGameObjectType(random, id, true);
    }

    protected static GameObjectTypeEntity generateGameObjectType(Random random, long id, boolean withDependencies) {
        GameObjectTypeEntity gameObjectType = new GameObjectTypeEntity(id);

        gameObjectType.setUniqueName("GAME OBJECT TYPE " + id + " UNIQUE NAME");
        gameObjectType.setIsExperimental(random.nextBoolean());

        if (withDependencies) {
            gameObjectType.setGameAssetsRepository(MockGameAssetsRepositoriesRepository.generateGameAssetsRepository(random, id, false));
            gameObjectType.setGameObjectTypeClass(MockGameObjectTypeClassesRepository.generateGameObjectTypeClass(random, id, false));
        }

        return gameObjectType;
    }

    @Override
    public List<GameObjectTypeEntity> findAll() {
        return gameObjectTypes;
    }

    @Override
    public GameObjectTypeEntity findOneById(Long id) {
        return gameObjectTypes.stream().filter(item -> item.getId() != null && item.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<GameObjectTypeEntity> findAllByGameAssetsRepository(GameAssetsRepositoryEntity gameAssetsRepository) {
        return gameObjectTypes.stream()
                .filter(item -> item.getGameAssetsRepository() != null && item.getGameAssetsRepository().equals(gameAssetsRepository))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameObjectTypeEntity> findAllByGameObjectTypeClass(GameObjectTypeClassEntity gameObjectTypeClass) {
        return gameObjectTypes.stream()
                .filter(item -> item.getGameObjectTypeClass() != null && item.getGameObjectTypeClass().equals(gameObjectTypeClass))
                .collect(Collectors.toList());
    }

    @Override
    public GameObjectTypeEntity findOneByUniqueName(String uniqueName) {
        return gameObjectTypes.stream().filter(item -> item.getUniqueName() != null && item.getUniqueName().equals(uniqueName)).findFirst()
                .orElse(null);
    }

    @Override
    public List<GameObjectTypeEntity> findAllByAnyTextFieldContaining(String content) {
        return gameObjectTypes.stream()
                .filter(item -> ((item.getUniqueName() != null && item.getUniqueName().contains(content))
                        || (item.getGameAssetsRepository() != null && item.getGameAssetsRepository().getUniqueName() != null
                                && item.getGameAssetsRepository().getUniqueName().contains(content))
                        || (item.getGameObjectTypeClass() != null && item.getGameObjectTypeClass().getName() != null
                                && item.getGameObjectTypeClass().getName().contains(content))))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameObjectTypeEntity> findAllByExample(GameAssetsRepositoryEntity gameAssetsRepository,
            GameObjectTypeClassEntity gameObjectTypeClass, String uniqueName, Boolean isExperimental) {
        return gameObjectTypes.stream()
                .filter(item -> ((item.getGameAssetsRepository() != null && gameAssetsRepository != null
                        && item.getGameAssetsRepository().equals(gameAssetsRepository))
                        || (item.getGameObjectTypeClass() != null && gameObjectTypeClass != null
                                && item.getGameObjectTypeClass().equals(gameObjectTypeClass))
                        || (item.getUniqueName() != null && item.getUniqueName().equals(uniqueName))
                        || (item.getIsExperimental() != null && item.getIsExperimental() == isExperimental)))
                .collect(Collectors.toList());
    }

    @Override
    public GameObjectTypeEntity save(GameObjectTypeEntity gameObjectType) {
        if (!gameObjectTypes.contains(gameObjectType)) {
            gameObjectType = new GameObjectTypeEntity(gameObjectType, firstAvailableId);
            gameObjectTypes.add(gameObjectType);
            firstAvailableId++;
        }

        return gameObjectType;
    }

    @Override
    public void delete(GameObjectTypeEntity gameObjectType) {
        gameObjectTypes.remove(gameObjectType);
    }
}