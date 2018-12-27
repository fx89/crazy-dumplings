package com.crazydumplings.backend.gameworldregistry.springdata.dao.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.annotation.Generated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameObjectTypeAllowedAddonTypesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.ActionEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeAllowedAddonTypeEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Mock implementation of the specification of the repository for the GameObjectTypeAllowedAddonType entity")
public class MockGameObjectTypeAllowedAddonTypesRepository implements GameObjectTypeAllowedAddonTypesRepository {
    private final Logger                               LOGGER = LoggerFactory.getLogger(getClass());

    private List<GameObjectTypeAllowedAddonTypeEntity> gameObjectTypeAllowedAddonTypes;

    private Long                                       firstAvailableId;

    public MockGameObjectTypeAllowedAddonTypesRepository() {
        LOGGER.info("Generating mock game object type allowed addon types");

        gameObjectTypeAllowedAddonTypes = new ArrayList<>();

        Random random = new Random();
        long nElements = random.nextInt(500);

        firstAvailableId = (long) 1;
        while (firstAvailableId <= nElements) {
            gameObjectTypeAllowedAddonTypes.add(generateGameObjectTypeAllowedAddonType(random, firstAvailableId));
            firstAvailableId++;
        }
    }

    protected static GameObjectTypeAllowedAddonTypeEntity generateGameObjectTypeAllowedAddonType(Random random, long id) {
        return generateGameObjectTypeAllowedAddonType(random, id, true);
    }

    protected static GameObjectTypeAllowedAddonTypeEntity generateGameObjectTypeAllowedAddonType(Random random, long id,
            boolean withDependencies) {
        GameObjectTypeAllowedAddonTypeEntity gameObjectTypeAllowedAddonType = new GameObjectTypeAllowedAddonTypeEntity(id);

        gameObjectTypeAllowedAddonType.setUniqueName("GAME OBJECT TYPE ALLOWED ADDON TYPE " + id + " UNIQUE NAME");
        gameObjectTypeAllowedAddonType.setIsEquipedByDefault(random.nextBoolean());
        gameObjectTypeAllowedAddonType.setIsIncremental(random.nextBoolean());
        gameObjectTypeAllowedAddonType.setIsTriggered(random.nextBoolean());
        gameObjectTypeAllowedAddonType.setIsSpawning(random.nextBoolean());
        gameObjectTypeAllowedAddonType.setHasLimitedDuration(random.nextBoolean());
        gameObjectTypeAllowedAddonType.setDuration(random.nextInt());

        if (withDependencies) {
            gameObjectTypeAllowedAddonType.setAddonGameObjectType(MockGameObjectTypesRepository.generateGameObjectType(random, id, false));
            gameObjectTypeAllowedAddonType
                    .setApplicableToGameObjectType(MockGameObjectTypesRepository.generateGameObjectType(random, id, false));
            gameObjectTypeAllowedAddonType.setTriggerAction(MockActionsRepository.generateAction(random, id, false));
            gameObjectTypeAllowedAddonType.setSpawnableGameObjectType(MockGameObjectTypesRepository.generateGameObjectType(random, id, false));
        }

        return gameObjectTypeAllowedAddonType;
    }

    @Override
    public List<GameObjectTypeAllowedAddonTypeEntity> findAll() {
        return gameObjectTypeAllowedAddonTypes;
    }

    @Override
    public GameObjectTypeAllowedAddonTypeEntity findOneById(Long id) {
        return gameObjectTypeAllowedAddonTypes.stream().filter(item -> item.getId() != null && item.getId().equals(id)).findFirst()
                .orElse(null);
    }

    @Override
    public GameObjectTypeAllowedAddonTypeEntity findOneByUniqueName(String uniqueName) {
        return gameObjectTypeAllowedAddonTypes.stream().filter(item -> item.getUniqueName() != null && item.getUniqueName().equals(uniqueName))
                .findFirst().orElse(null);
    }

    @Override
    public List<GameObjectTypeAllowedAddonTypeEntity> findAllByAddonGameObjectType(GameObjectTypeEntity addonGameObjectType) {
        return gameObjectTypeAllowedAddonTypes.stream()
                .filter(item -> item.getAddonGameObjectType() != null && item.getAddonGameObjectType().equals(addonGameObjectType))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameObjectTypeAllowedAddonTypeEntity> findAllByApplicableToGameObjectType(GameObjectTypeEntity applicableToGameObjectType) {
        return gameObjectTypeAllowedAddonTypes.stream().filter(
                item -> item.getApplicableToGameObjectType() != null && item.getApplicableToGameObjectType().equals(applicableToGameObjectType))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameObjectTypeAllowedAddonTypeEntity> findAllByTriggerAction(ActionEntity triggerAction) {
        return gameObjectTypeAllowedAddonTypes.stream()
                .filter(item -> item.getTriggerAction() != null && item.getTriggerAction().equals(triggerAction)).collect(Collectors.toList());
    }

    @Override
    public List<GameObjectTypeAllowedAddonTypeEntity> findAllBySpawnableGameObjectType(GameObjectTypeEntity spawnableGameObjectType) {
        return gameObjectTypeAllowedAddonTypes.stream()
                .filter(item -> item.getSpawnableGameObjectType() != null && item.getSpawnableGameObjectType().equals(spawnableGameObjectType))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameObjectTypeAllowedAddonTypeEntity> findAllByAnyTextFieldContaining(String content) {
        return gameObjectTypeAllowedAddonTypes.stream()
                .filter(item -> ((item.getUniqueName() != null && item.getUniqueName().contains(content))
                        || (item.getAddonGameObjectType() != null && item.getAddonGameObjectType().getUniqueName() != null
                                && item.getAddonGameObjectType().getUniqueName().contains(content))
                        || (item.getApplicableToGameObjectType() != null && item.getApplicableToGameObjectType().getUniqueName() != null
                                && item.getApplicableToGameObjectType().getUniqueName().contains(content))
                        || (item.getTriggerAction() != null && item.getTriggerAction().getUniqueName() != null
                                && item.getTriggerAction().getUniqueName().contains(content))
                        || (item.getSpawnableGameObjectType() != null && item.getSpawnableGameObjectType().getUniqueName() != null
                                && item.getSpawnableGameObjectType().getUniqueName().contains(content))))
                .collect(Collectors.toList());
    }

    @Override
    public List<GameObjectTypeAllowedAddonTypeEntity> findAllByExample(String uniqueName, GameObjectTypeEntity addonGameObjectType,
            GameObjectTypeEntity applicableToGameObjectType, Boolean isEquipedByDefault, Boolean isIncremental, Boolean isTriggered,
            ActionEntity triggerAction, Boolean isSpawning, GameObjectTypeEntity spawnableGameObjectType, Boolean hasLimitedDuration,
            Integer duration) {
        return gameObjectTypeAllowedAddonTypes.stream()
                .filter(item -> ((item.getUniqueName() != null && item.getUniqueName().equals(uniqueName))
                        || (item.getAddonGameObjectType() != null && addonGameObjectType != null
                                && item.getAddonGameObjectType().equals(addonGameObjectType))
                        || (item.getApplicableToGameObjectType() != null && applicableToGameObjectType != null
                                && item.getApplicableToGameObjectType().equals(applicableToGameObjectType))
                        || (item.getIsEquipedByDefault() != null && item.getIsEquipedByDefault() == isEquipedByDefault)
                        || (item.getIsIncremental() != null && item.getIsIncremental() == isIncremental)
                        || (item.getIsTriggered() != null && item.getIsTriggered() == isTriggered)
                        || (item.getTriggerAction() != null && triggerAction != null && item.getTriggerAction().equals(triggerAction))
                        || (item.getIsSpawning() != null && item.getIsSpawning() == isSpawning)
                        || (item.getSpawnableGameObjectType() != null && spawnableGameObjectType != null
                                && item.getSpawnableGameObjectType().equals(spawnableGameObjectType))
                        || (item.getHasLimitedDuration() != null && item.getHasLimitedDuration() == hasLimitedDuration)
                        || (item.getDuration() != null && item.getDuration() == duration)))
                .collect(Collectors.toList());
    }

    @Override
    public GameObjectTypeAllowedAddonTypeEntity save(GameObjectTypeAllowedAddonTypeEntity gameObjectTypeAllowedAddonType) {
        if (!gameObjectTypeAllowedAddonTypes.contains(gameObjectTypeAllowedAddonType)) {
            gameObjectTypeAllowedAddonType = new GameObjectTypeAllowedAddonTypeEntity(gameObjectTypeAllowedAddonType, firstAvailableId);
            gameObjectTypeAllowedAddonTypes.add(gameObjectTypeAllowedAddonType);
            firstAvailableId++;
        }

        return gameObjectTypeAllowedAddonType;
    }

    @Override
    public void delete(GameObjectTypeAllowedAddonTypeEntity gameObjectTypeAllowedAddonType) {
        gameObjectTypeAllowedAddonTypes.remove(gameObjectTypeAllowedAddonType);
    }
}