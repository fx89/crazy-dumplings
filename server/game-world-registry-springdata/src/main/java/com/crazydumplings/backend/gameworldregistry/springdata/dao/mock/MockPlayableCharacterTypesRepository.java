package com.crazydumplings.backend.gameworldregistry.springdata.dao.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.annotation.Generated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.PlayableCharacterTypesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.PlayableCharacterTypeEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Mock implementation of the specification of the repository for the PlayableCharacterType entity")
public class MockPlayableCharacterTypesRepository implements PlayableCharacterTypesRepository {
    private final Logger                      LOGGER = LoggerFactory.getLogger(getClass());

    private List<PlayableCharacterTypeEntity> playableCharacterTypes;

    private Long                              firstAvailableId;

    public MockPlayableCharacterTypesRepository() {
        LOGGER.info("Generating mock playable character types");

        playableCharacterTypes = new ArrayList<>();

        Random random = new Random();
        long nElements = random.nextInt(500);

        firstAvailableId = (long) 1;
        while (firstAvailableId <= nElements) {
            playableCharacterTypes.add(generatePlayableCharacterType(random, firstAvailableId));
            firstAvailableId++;
        }
    }

    protected static PlayableCharacterTypeEntity generatePlayableCharacterType(Random random, long id) {
        return generatePlayableCharacterType(random, id, true);
    }

    protected static PlayableCharacterTypeEntity generatePlayableCharacterType(Random random, long id, boolean withDependencies) {
        PlayableCharacterTypeEntity playableCharacterType = new PlayableCharacterTypeEntity(id);

        playableCharacterType.setUniqueCharacterTypeName("PLAYABLE CHARACTER TYPE " + id + " UNIQUE CHARACTER TYPE NAME");

        if (withDependencies) {
            playableCharacterType.setGameObjectType(MockGameObjectTypesRepository.generateGameObjectType(random, id, false));
        }

        return playableCharacterType;
    }

    @Override
    public List<PlayableCharacterTypeEntity> findAll() {
        return playableCharacterTypes;
    }

    @Override
    public PlayableCharacterTypeEntity findOneById(Long id) {
        return playableCharacterTypes.stream().filter(item -> item.getId() != null && item.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public PlayableCharacterTypeEntity findOneByUniqueCharacterTypeName(String uniqueCharacterTypeName) {
        return playableCharacterTypes.stream()
                .filter(item -> item.getUniqueCharacterTypeName() != null && item.getUniqueCharacterTypeName().equals(uniqueCharacterTypeName))
                .findFirst().orElse(null);
    }

    @Override
    public List<PlayableCharacterTypeEntity> findAllByGameObjectType(GameObjectTypeEntity gameObjectType) {
        return playableCharacterTypes.stream()
                .filter(item -> item.getGameObjectType() != null && item.getGameObjectType().equals(gameObjectType))
                .collect(Collectors.toList());
    }

    @Override
    public List<PlayableCharacterTypeEntity> findAllByAnyTextFieldContaining(String content) {
        return playableCharacterTypes.stream()
                .filter(item -> ((item.getUniqueCharacterTypeName() != null && item.getUniqueCharacterTypeName().contains(content))
                        || (item.getGameObjectType() != null && item.getGameObjectType().getUniqueName() != null
                                && item.getGameObjectType().getUniqueName().contains(content))))
                .collect(Collectors.toList());
    }

    @Override
    public List<PlayableCharacterTypeEntity> findAllByExample(String uniqueCharacterTypeName, GameObjectTypeEntity gameObjectType) {
        return playableCharacterTypes.stream().filter(
                item -> ((item.getUniqueCharacterTypeName() != null && item.getUniqueCharacterTypeName().equals(uniqueCharacterTypeName))
                        || (item.getGameObjectType() != null && gameObjectType != null && item.getGameObjectType().equals(gameObjectType))))
                .collect(Collectors.toList());
    }

    @Override
    public PlayableCharacterTypeEntity save(PlayableCharacterTypeEntity playableCharacterType) {
        if (!playableCharacterTypes.contains(playableCharacterType)) {
            playableCharacterType = new PlayableCharacterTypeEntity(playableCharacterType, firstAvailableId);
            playableCharacterTypes.add(playableCharacterType);
            firstAvailableId++;
        }

        return playableCharacterType;
    }

    @Override
    public void delete(PlayableCharacterTypeEntity playableCharacterType) {
        playableCharacterTypes.remove(playableCharacterType);
    }
}