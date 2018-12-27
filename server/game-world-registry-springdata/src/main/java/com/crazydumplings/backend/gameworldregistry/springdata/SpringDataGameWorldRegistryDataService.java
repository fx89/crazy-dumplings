package com.crazydumplings.backend.gameworldregistry.springdata;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.Generated;
import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.bundle.DaoBundle;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.bundle.impl.MockDaoBundle;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.bundle.impl.SpringJpaHibernateDaoBundle;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.ActionEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.AutomationObjectProviderEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameAddonInteractionReceivingPropertyModifierEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameAssetsRepositoryEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameAssetsRepositoryOwnerEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameClientTypeEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeAllowedAddonTypeEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeAutomationEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeClassEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeInteractionEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeInteractionPropertyEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypePropertyEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeRepresentationEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeStateEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeStatePropertyModifierEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameObjectTypeStateTransitionEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameWorldCellEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameWorldCellPropertyEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameWorldCellTypeEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameWorldEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.GameWorldSpawnPointTypeEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.PlayableCharacterTypeEntity;
import com.crazydumplings.backend.gameworldregistry.springdata.exception.CrazyDumplingsSpringDataGameWorldRegistryInitializationException;
import com.crazydumplings.backend.gameworldregistry.springdata.exception.runtime.CrazyDumplingsSpringDataGameWorldRegistryExpungingException;
import com.crazydumplings.backend.gameworldregistry.springdata.exception.runtime.CrazyDumplingsSpringDataGameWorldRegistryPullingException;
import com.crazydumplings.backend.gameworldregistry.springdata.exception.runtime.CrazyDumplingsSpringDataGameWorldRegistryPushingException;
import com.crazydumplings.gameworldregistry.GameWorldRegistryDataService;
import com.crazydumplings.gameworldregistry.model.Action;
import com.crazydumplings.gameworldregistry.model.AutomationObjectProvider;
import com.crazydumplings.gameworldregistry.model.GameAddonInteractionReceivingPropertyModifier;
import com.crazydumplings.gameworldregistry.model.GameAssetsRepository;
import com.crazydumplings.gameworldregistry.model.GameAssetsRepositoryOwner;
import com.crazydumplings.gameworldregistry.model.GameClientType;
import com.crazydumplings.gameworldregistry.model.GameObjectType;
import com.crazydumplings.gameworldregistry.model.GameObjectTypeAllowedAddonType;
import com.crazydumplings.gameworldregistry.model.GameObjectTypeAutomation;
import com.crazydumplings.gameworldregistry.model.GameObjectTypeClass;
import com.crazydumplings.gameworldregistry.model.GameObjectTypeInteraction;
import com.crazydumplings.gameworldregistry.model.GameObjectTypeInteractionProperty;
import com.crazydumplings.gameworldregistry.model.GameObjectTypeProperty;
import com.crazydumplings.gameworldregistry.model.GameObjectTypeRepresentation;
import com.crazydumplings.gameworldregistry.model.GameObjectTypeState;
import com.crazydumplings.gameworldregistry.model.GameObjectTypeStatePropertyModifier;
import com.crazydumplings.gameworldregistry.model.GameObjectTypeStateTransition;
import com.crazydumplings.gameworldregistry.model.GameWorld;
import com.crazydumplings.gameworldregistry.model.GameWorldCell;
import com.crazydumplings.gameworldregistry.model.GameWorldCellProperty;
import com.crazydumplings.gameworldregistry.model.GameWorldCellType;
import com.crazydumplings.gameworldregistry.model.GameWorldSpawnPointType;
import com.crazydumplings.gameworldregistry.model.PlayableCharacterType;

@Generated(value = "fx.codegen.builder version 1.0.0")
@Service(value = "SpringDataGameWorldRegistryDataService")
@Transactional("gameWorldRegistryTransactionManager")
public class SpringDataGameWorldRegistryDataService implements GameWorldRegistryDataService {
    private static final String IMPL_TYPE_PROP_NAME = "crazydumplings.gameworldregistry.dataservice.springdata.implementationtype";

    private final Logger        LOGGER              = LoggerFactory.getLogger(getClass());

    @Autowired
    private ApplicationContext  springApplicationContext;

    private ImplementationType  implementationType;

    private DaoBundle           daoBundle;

    @PostConstruct
    public void init() {
        try {
            String implementationTypeStr = springApplicationContext.getEnvironment().getProperty(IMPL_TYPE_PROP_NAME);
            LOGGER.info(IMPL_TYPE_PROP_NAME + " = " + implementationTypeStr);

            implementationType = implementationTypeStr.equals("MOCK") ? ImplementationType.MOCK
                    : (implementationTypeStr.equals("SPRING_JPA_HIBERNATE") ? ImplementationType.SPRING_JPA_HIBERNATE : null);

            Objects.requireNonNull(implementationType, "Missing or invalid value of property [" + IMPL_TYPE_PROP_NAME + "]");

            daoBundle = createDaoBundle();
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryInitializationException(
                    "An error has occurred while attempting to initialize the WorldDomination service", ex);
        }
    }

    private DaoBundle createDaoBundle() {
        if (implementationType == ImplementationType.MOCK) {
            return new MockDaoBundle();
        }

        if (implementationType == ImplementationType.SPRING_JPA_HIBERNATE) {
            return new SpringJpaHibernateDaoBundle(springApplicationContext);
        }

        throw new CrazyDumplingsSpringDataGameWorldRegistryInitializationException("Requested implementation type not yet supported");
    }

    public PlayableCharacterType newPlayableCharacterType() {
        return new PlayableCharacterTypeEntity();
    }

    @Override
    public List<PlayableCharacterType> findAllPlayableCharacterTypes() {
        try {
            return new ArrayList<>(daoBundle.playableCharacterTypesRepository.findAll());
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve playable character types", ex);
        }
    }

    @Override
    public PlayableCharacterType findPlayableCharacterType(Long id) {
        try {
            return daoBundle.playableCharacterTypesRepository.findOneById(id);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve playable character type", ex);
        }
    }

    @Override
    public PlayableCharacterType savePlayableCharacterType(PlayableCharacterType playableCharacterType) {
        try {
            return daoBundle.playableCharacterTypesRepository.save((PlayableCharacterTypeEntity) playableCharacterType);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save playable character type", ex);
        }
    }

    @Override
    public void deletePlayableCharacterType(PlayableCharacterType playableCharacterType) {
        try {
            daoBundle.playableCharacterTypesRepository.delete((PlayableCharacterTypeEntity) playableCharacterType);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete playable character type", ex);
        }
    }

    @Override
    public List<PlayableCharacterType> findAllPlayableCharacterTypesByExample(PlayableCharacterType example) {
        try {
            return new ArrayList<>(daoBundle.playableCharacterTypesRepository.findAllByExample(example.getUniqueCharacterTypeName(),
                    (GameObjectTypeEntity) example.getGameObjectType()));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find playable character types", ex);
        }
    }

    @Override
    public PlayableCharacterType findPlayableCharacterTypeByUniqueCharacterTypeName(String uniqueCharacterTypeName) {
        try {
            return daoBundle.playableCharacterTypesRepository.findOneByUniqueCharacterTypeName(uniqueCharacterTypeName);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find playable character types", ex);
        }
    }

    @Override
    public List<PlayableCharacterType> findAllPlayableCharacterTypesByGameObjectType(GameObjectType gameObjectType) {
        try {
            return new ArrayList<>(daoBundle.playableCharacterTypesRepository.findAllByGameObjectType((GameObjectTypeEntity) gameObjectType));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find playable character types", ex);
        }
    }

    @Override
    public List<PlayableCharacterType> findAllPlayableCharacterTypesByAnyTextFieldContaining(String content) {
        try {
            return new ArrayList<>(daoBundle.playableCharacterTypesRepository.findAllByAnyTextFieldContaining(content));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find playable character types", ex);
        }
    }

    public GameWorldSpawnPointType newGameWorldSpawnPointType() {
        return new GameWorldSpawnPointTypeEntity();
    }

    @Override
    public List<GameWorldSpawnPointType> findAllGameWorldSpawnPointTypes() {
        try {
            return new ArrayList<>(daoBundle.gameWorldSpawnPointTypesRepository.findAll());
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game world spawn point types", ex);
        }
    }

    @Override
    public GameWorldSpawnPointType findGameWorldSpawnPointType(Long id) {
        try {
            return daoBundle.gameWorldSpawnPointTypesRepository.findOneById(id);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game world spawn point type", ex);
        }
    }

    @Override
    public GameWorldSpawnPointType saveGameWorldSpawnPointType(GameWorldSpawnPointType gameWorldSpawnPointType) {
        try {
            return daoBundle.gameWorldSpawnPointTypesRepository.save((GameWorldSpawnPointTypeEntity) gameWorldSpawnPointType);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game world spawn point type", ex);
        }
    }

    @Override
    public void deleteGameWorldSpawnPointType(GameWorldSpawnPointType gameWorldSpawnPointType) {
        try {
            daoBundle.gameWorldSpawnPointTypesRepository.delete((GameWorldSpawnPointTypeEntity) gameWorldSpawnPointType);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete game world spawn point type", ex);
        }
    }

    @Override
    public List<GameWorldSpawnPointType> findAllGameWorldSpawnPointTypesByExample(GameWorldSpawnPointType example) {
        try {
            return new ArrayList<>(daoBundle.gameWorldSpawnPointTypesRepository.findAllByExample(
                    (GameObjectTypeEntity) example.getSpawnPointGameObjectType(), (GameObjectTypeEntity) example.getSpawnedGameObjectType()));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game world spawn point types", ex);
        }
    }

    @Override
    public List<GameWorldSpawnPointType> findAllGameWorldSpawnPointTypesBySpawnPointGameObjectType(GameObjectType spawnPointGameObjectType) {
        try {
            return new ArrayList<>(daoBundle.gameWorldSpawnPointTypesRepository
                    .findAllBySpawnPointGameObjectType((GameObjectTypeEntity) spawnPointGameObjectType));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game world spawn point types", ex);
        }
    }

    @Override
    public List<GameWorldSpawnPointType> findAllGameWorldSpawnPointTypesBySpawnedGameObjectType(GameObjectType spawnedGameObjectType) {
        try {
            return new ArrayList<>(
                    daoBundle.gameWorldSpawnPointTypesRepository.findAllBySpawnedGameObjectType((GameObjectTypeEntity) spawnedGameObjectType));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game world spawn point types", ex);
        }
    }

    @Override
    public List<GameWorldSpawnPointType> findAllGameWorldSpawnPointTypesByAnyTextFieldContaining(String content) {
        try {
            return new ArrayList<>(daoBundle.gameWorldSpawnPointTypesRepository.findAllByAnyTextFieldContaining(content));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game world spawn point types", ex);
        }
    }

    public GameWorldCellType newGameWorldCellType() {
        return new GameWorldCellTypeEntity();
    }

    @Override
    public List<GameWorldCellType> findAllGameWorldCellTypes() {
        try {
            return new ArrayList<>(daoBundle.gameWorldCellTypesRepository.findAll());
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game world cell types", ex);
        }
    }

    @Override
    public GameWorldCellType findGameWorldCellType(Long id) {
        try {
            return daoBundle.gameWorldCellTypesRepository.findOneById(id);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game world cell type", ex);
        }
    }

    @Override
    public GameWorldCellType saveGameWorldCellType(GameWorldCellType gameWorldCellType) {
        try {
            return daoBundle.gameWorldCellTypesRepository.save((GameWorldCellTypeEntity) gameWorldCellType);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game world cell type", ex);
        }
    }

    @Override
    public void deleteGameWorldCellType(GameWorldCellType gameWorldCellType) {
        try {
            daoBundle.gameWorldCellTypesRepository.delete((GameWorldCellTypeEntity) gameWorldCellType);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete game world cell type", ex);
        }
    }

    @Override
    public List<GameWorldCellType> findAllGameWorldCellTypesByExample(GameWorldCellType example) {
        try {
            return new ArrayList<>(daoBundle.gameWorldCellTypesRepository.findAllByExample(example.getUniqueName(),
                    (GameObjectTypeEntity) example.getGameObjectType()));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game world cell types", ex);
        }
    }

    @Override
    public GameWorldCellType findGameWorldCellTypeByUniqueName(String uniqueName) {
        try {
            return daoBundle.gameWorldCellTypesRepository.findOneByUniqueName(uniqueName);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game world cell types", ex);
        }
    }

    @Override
    public List<GameWorldCellType> findAllGameWorldCellTypesByGameObjectType(GameObjectType gameObjectType) {
        try {
            return new ArrayList<>(daoBundle.gameWorldCellTypesRepository.findAllByGameObjectType((GameObjectTypeEntity) gameObjectType));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game world cell types", ex);
        }
    }

    @Override
    public List<GameWorldCellType> findAllGameWorldCellTypesByAnyTextFieldContaining(String content) {
        try {
            return new ArrayList<>(daoBundle.gameWorldCellTypesRepository.findAllByAnyTextFieldContaining(content));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game world cell types", ex);
        }
    }

    public GameWorld newGameWorld() {
        return new GameWorldEntity();
    }

    @Override
    public List<GameWorld> findAllGameWorlds() {
        try {
            return new ArrayList<>(daoBundle.gameWorldsRepository.findAll());
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game worlds", ex);
        }
    }

    @Override
    public GameWorld findGameWorld(Long id) {
        try {
            return daoBundle.gameWorldsRepository.findOneById(id);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game world", ex);
        }
    }

    @Override
    public GameWorld saveGameWorld(GameWorld gameWorld) {
        try {
            return daoBundle.gameWorldsRepository.save((GameWorldEntity) gameWorld);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game world", ex);
        }
    }

    @Override
    public void deleteGameWorld(GameWorld gameWorld) {
        try {
            daoBundle.gameWorldsRepository.delete((GameWorldEntity) gameWorld);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete game world", ex);
        }
    }

    @Override
    public List<GameWorld> findAllGameWorldsByExample(GameWorld example) {
        try {
            return new ArrayList<>(daoBundle.gameWorldsRepository.findAllByExample(example.getUniqueName(), example.getDescription(),
                    example.getPictureRefPath(), example.getWidth(), example.getHeight()));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game worlds", ex);
        }
    }

    @Override
    public GameWorld findGameWorldByUniqueName(String uniqueName) {
        try {
            return daoBundle.gameWorldsRepository.findOneByUniqueName(uniqueName);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game worlds", ex);
        }
    }

    @Override
    public List<GameWorld> findAllGameWorldsByAnyTextFieldContaining(String content) {
        try {
            return new ArrayList<>(daoBundle.gameWorldsRepository.findAllByAnyTextFieldContaining(content));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game worlds", ex);
        }
    }

    public GameWorldCell newGameWorldCell() {
        return new GameWorldCellEntity();
    }

    @Override
    public List<GameWorldCell> findAllGameWorldCells() {
        try {
            return new ArrayList<>(daoBundle.gameWorldCellsRepository.findAll());
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game world cells", ex);
        }
    }

    @Override
    public GameWorldCell findGameWorldCell(Long id) {
        try {
            return daoBundle.gameWorldCellsRepository.findOneById(id);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game world cell", ex);
        }
    }

    @Override
    public GameWorldCell saveGameWorldCell(GameWorldCell gameWorldCell) {
        try {
            return daoBundle.gameWorldCellsRepository.save((GameWorldCellEntity) gameWorldCell);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game world cell", ex);
        }
    }

    @Override
    public void deleteGameWorldCell(GameWorldCell gameWorldCell) {
        try {
            daoBundle.gameWorldCellsRepository.delete((GameWorldCellEntity) gameWorldCell);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete game world cell", ex);
        }
    }

    @Override
    public List<GameWorldCell> findAllGameWorldCellsByExample(GameWorldCell example) {
        try {
            return new ArrayList<>(daoBundle.gameWorldCellsRepository.findAllByExample((GameWorldEntity) example.getGameWorld(),
                    (GameWorldCellTypeEntity) example.getGameWorldCellType(), example.getXIndex(), example.getYIndex(),
                    (GameWorldSpawnPointTypeEntity) example.getAttachedGameWorldSpawnPointType()));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game world cells", ex);
        }
    }

    @Override
    public List<GameWorldCell> findAllGameWorldCellsByGameWorld(GameWorld gameWorld) {
        try {
            return new ArrayList<>(daoBundle.gameWorldCellsRepository.findAllByGameWorld((GameWorldEntity) gameWorld));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game world cells", ex);
        }
    }

    @Override
    public List<GameWorldCell> findAllGameWorldCellsByGameWorldCellType(GameWorldCellType gameWorldCellType) {
        try {
            return new ArrayList<>(daoBundle.gameWorldCellsRepository.findAllByGameWorldCellType((GameWorldCellTypeEntity) gameWorldCellType));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game world cells", ex);
        }
    }

    @Override
    public List<GameWorldCell> findAllGameWorldCellsByAttachedGameWorldSpawnPointType(GameWorldSpawnPointType attachedGameWorldSpawnPointType) {
        try {
            return new ArrayList<>(daoBundle.gameWorldCellsRepository
                    .findAllByAttachedGameWorldSpawnPointType((GameWorldSpawnPointTypeEntity) attachedGameWorldSpawnPointType));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game world cells", ex);
        }
    }

    @Override
    public List<GameWorldCell> findAllGameWorldCellsHavingTargetSmallnumberBetweenXIndexAndYIndex(Integer targetSmallnumber) {
        try {
            return new ArrayList<>(daoBundle.gameWorldCellsRepository.findAllHavingTargetSmallnumberBetweenXIndexAndYIndex(targetSmallnumber));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game world cells", ex);
        }
    }

    @Override
    public List<GameWorldCell> findAllGameWorldCellsByAnyTextFieldContaining(String content) {
        try {
            return new ArrayList<>(daoBundle.gameWorldCellsRepository.findAllByAnyTextFieldContaining(content));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game world cells", ex);
        }
    }

    public GameWorldCellProperty newGameWorldCellProperty() {
        return new GameWorldCellPropertyEntity();
    }

    @Override
    public List<GameWorldCellProperty> findAllGameWorldCellProperties() {
        try {
            return new ArrayList<>(daoBundle.gameWorldCellPropertiesRepository.findAll());
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game world cell properties", ex);
        }
    }

    @Override
    public GameWorldCellProperty findGameWorldCellProperty(Long id) {
        try {
            return daoBundle.gameWorldCellPropertiesRepository.findOneById(id);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game world cell property", ex);
        }
    }

    @Override
    public GameWorldCellProperty saveGameWorldCellProperty(GameWorldCellProperty gameWorldCellProperty) {
        try {
            return daoBundle.gameWorldCellPropertiesRepository.save((GameWorldCellPropertyEntity) gameWorldCellProperty);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game world cell property", ex);
        }
    }

    @Override
    public void deleteGameWorldCellProperty(GameWorldCellProperty gameWorldCellProperty) {
        try {
            daoBundle.gameWorldCellPropertiesRepository.delete((GameWorldCellPropertyEntity) gameWorldCellProperty);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete game world cell property", ex);
        }
    }

    @Override
    public List<GameWorldCellProperty> findAllGameWorldCellPropertiesByExample(GameWorldCellProperty example) {
        try {
            return new ArrayList<>(
                    daoBundle.gameWorldCellPropertiesRepository.findAllByExample((GameWorldCellEntity) example.getGameWorldCell(),
                            (GameObjectTypePropertyEntity) example.getGameObjectTypeProperty(), example.getPropertyActualValue()));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game world cell properties", ex);
        }
    }

    @Override
    public List<GameWorldCellProperty> findAllGameWorldCellPropertiesByGameWorldCell(GameWorldCell gameWorldCell) {
        try {
            return new ArrayList<>(daoBundle.gameWorldCellPropertiesRepository.findAllByGameWorldCell((GameWorldCellEntity) gameWorldCell));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game world cell properties", ex);
        }
    }

    @Override
    public List<GameWorldCellProperty> findAllGameWorldCellPropertiesByGameObjectTypeProperty(GameObjectTypeProperty gameObjectTypeProperty) {
        try {
            return new ArrayList<>(daoBundle.gameWorldCellPropertiesRepository
                    .findAllByGameObjectTypeProperty((GameObjectTypePropertyEntity) gameObjectTypeProperty));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game world cell properties", ex);
        }
    }

    @Override
    public List<GameWorldCellProperty> findAllGameWorldCellPropertiesByAnyTextFieldContaining(String content) {
        try {
            return new ArrayList<>(daoBundle.gameWorldCellPropertiesRepository.findAllByAnyTextFieldContaining(content));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game world cell properties", ex);
        }
    }

    public AutomationObjectProvider newAutomationObjectProvider() {
        return new AutomationObjectProviderEntity();
    }

    @Override
    public List<AutomationObjectProvider> findAllAutomationObjectProviders() {
        try {
            return new ArrayList<>(daoBundle.automationObjectProvidersRepository.findAll());
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve automation object providers", ex);
        }
    }

    @Override
    public AutomationObjectProvider findAutomationObjectProvider(Long id) {
        try {
            return daoBundle.automationObjectProvidersRepository.findOneById(id);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve automation object provider", ex);
        }
    }

    @Override
    public AutomationObjectProvider saveAutomationObjectProvider(AutomationObjectProvider automationObjectProvider) {
        try {
            return daoBundle.automationObjectProvidersRepository.save((AutomationObjectProviderEntity) automationObjectProvider);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save automation object provider", ex);
        }
    }

    @Override
    public void deleteAutomationObjectProvider(AutomationObjectProvider automationObjectProvider) {
        try {
            daoBundle.automationObjectProvidersRepository.delete((AutomationObjectProviderEntity) automationObjectProvider);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete automation object provider", ex);
        }
    }

    @Override
    public List<AutomationObjectProvider> findAllAutomationObjectProvidersByExample(AutomationObjectProvider example) {
        try {
            return new ArrayList<>(daoBundle.automationObjectProvidersRepository.findAllByExample(example.getName()));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find automation object providers", ex);
        }
    }

    @Override
    public AutomationObjectProvider findAutomationObjectProviderByName(String name) {
        try {
            return daoBundle.automationObjectProvidersRepository.findOneByName(name);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find automation object providers", ex);
        }
    }

    @Override
    public List<AutomationObjectProvider> findAllAutomationObjectProvidersByAnyTextFieldContaining(String content) {
        try {
            return new ArrayList<>(daoBundle.automationObjectProvidersRepository.findAllByAnyTextFieldContaining(content));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find automation object providers", ex);
        }
    }

    public GameObjectTypeAutomation newGameObjectTypeAutomation() {
        return new GameObjectTypeAutomationEntity();
    }

    @Override
    public List<GameObjectTypeAutomation> findAllGameObjectTypeAutomations() {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeAutomationsRepository.findAll());
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type automations", ex);
        }
    }

    @Override
    public GameObjectTypeAutomation findGameObjectTypeAutomation(Long id) {
        try {
            return daoBundle.gameObjectTypeAutomationsRepository.findOneById(id);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type automation", ex);
        }
    }

    @Override
    public GameObjectTypeAutomation saveGameObjectTypeAutomation(GameObjectTypeAutomation gameObjectTypeAutomation) {
        try {
            return daoBundle.gameObjectTypeAutomationsRepository.save((GameObjectTypeAutomationEntity) gameObjectTypeAutomation);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game object type automation", ex);
        }
    }

    @Override
    public void deleteGameObjectTypeAutomation(GameObjectTypeAutomation gameObjectTypeAutomation) {
        try {
            daoBundle.gameObjectTypeAutomationsRepository.delete((GameObjectTypeAutomationEntity) gameObjectTypeAutomation);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete game object type automation", ex);
        }
    }

    @Override
    public List<GameObjectTypeAutomation> findAllGameObjectTypeAutomationsByExample(GameObjectTypeAutomation example) {
        try {
            return new ArrayList<>(
                    daoBundle.gameObjectTypeAutomationsRepository.findAllByExample((GameObjectTypeEntity) example.getGameObjectType(),
                            (AutomationObjectProviderEntity) example.getAutomationObjectProvider()));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type automations", ex);
        }
    }

    @Override
    public List<GameObjectTypeAutomation> findAllGameObjectTypeAutomationsByGameObjectType(GameObjectType gameObjectType) {
        try {
            return new ArrayList<>(
                    daoBundle.gameObjectTypeAutomationsRepository.findAllByGameObjectType((GameObjectTypeEntity) gameObjectType));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type automations", ex);
        }
    }

    @Override
    public List<GameObjectTypeAutomation> findAllGameObjectTypeAutomationsByAutomationObjectProvider(
            AutomationObjectProvider automationObjectProvider) {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeAutomationsRepository
                    .findAllByAutomationObjectProvider((AutomationObjectProviderEntity) automationObjectProvider));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type automations", ex);
        }
    }

    @Override
    public List<GameObjectTypeAutomation> findAllGameObjectTypeAutomationsByAnyTextFieldContaining(String content) {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeAutomationsRepository.findAllByAnyTextFieldContaining(content));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type automations", ex);
        }
    }

    public Action newAction() {
        return new ActionEntity();
    }

    @Override
    public List<Action> findAllActions() {
        try {
            return new ArrayList<>(daoBundle.actionsRepository.findAll());
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve actions", ex);
        }
    }

    @Override
    public Action findAction(Long id) {
        try {
            return daoBundle.actionsRepository.findOneById(id);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve action", ex);
        }
    }

    @Override
    public Action saveAction(Action action) {
        try {
            return daoBundle.actionsRepository.save((ActionEntity) action);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save action", ex);
        }
    }

    @Override
    public void deleteAction(Action action) {
        try {
            daoBundle.actionsRepository.delete((ActionEntity) action);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete action", ex);
        }
    }

    @Override
    public List<Action> findAllActionsByExample(Action example) {
        try {
            return new ArrayList<>(daoBundle.actionsRepository.findAllByExample(example.getUniqueName()));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find actions", ex);
        }
    }

    @Override
    public Action findActionByUniqueName(String uniqueName) {
        try {
            return daoBundle.actionsRepository.findOneByUniqueName(uniqueName);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find actions", ex);
        }
    }

    @Override
    public List<Action> findAllActionsByAnyTextFieldContaining(String content) {
        try {
            return new ArrayList<>(daoBundle.actionsRepository.findAllByAnyTextFieldContaining(content));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find actions", ex);
        }
    }

    public GameObjectTypeStateTransition newGameObjectTypeStateTransition() {
        return new GameObjectTypeStateTransitionEntity();
    }

    @Override
    public List<GameObjectTypeStateTransition> findAllGameObjectTypeStateTransitions() {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeStateTransitionsRepository.findAll());
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type state transitions", ex);
        }
    }

    @Override
    public GameObjectTypeStateTransition findGameObjectTypeStateTransition(Long id) {
        try {
            return daoBundle.gameObjectTypeStateTransitionsRepository.findOneById(id);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type state transition", ex);
        }
    }

    @Override
    public GameObjectTypeStateTransition saveGameObjectTypeStateTransition(GameObjectTypeStateTransition gameObjectTypeStateTransition) {
        try {
            return daoBundle.gameObjectTypeStateTransitionsRepository.save((GameObjectTypeStateTransitionEntity) gameObjectTypeStateTransition);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game object type state transition", ex);
        }
    }

    @Override
    public void deleteGameObjectTypeStateTransition(GameObjectTypeStateTransition gameObjectTypeStateTransition) {
        try {
            daoBundle.gameObjectTypeStateTransitionsRepository.delete((GameObjectTypeStateTransitionEntity) gameObjectTypeStateTransition);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete game object type state transition", ex);
        }
    }

    @Override
    public List<GameObjectTypeStateTransition> findAllGameObjectTypeStateTransitionsByExample(GameObjectTypeStateTransition example) {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeStateTransitionsRepository.findAllByExample(
                    (GameObjectTypeStateEntity) example.getSourceGameObjectTypeState(),
                    (GameObjectTypeStateEntity) example.getTargetGameObjectTypeState(), example.getIsAutomatic(),
                    (ActionEntity) example.getTriggerAction()));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type state transitions", ex);
        }
    }

    @Override
    public List<GameObjectTypeStateTransition> findAllGameObjectTypeStateTransitionsBySourceGameObjectTypeState(
            GameObjectTypeState sourceGameObjectTypeState) {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeStateTransitionsRepository
                    .findAllBySourceGameObjectTypeState((GameObjectTypeStateEntity) sourceGameObjectTypeState));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type state transitions", ex);
        }
    }

    @Override
    public List<GameObjectTypeStateTransition> findAllGameObjectTypeStateTransitionsByTargetGameObjectTypeState(
            GameObjectTypeState targetGameObjectTypeState) {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeStateTransitionsRepository
                    .findAllByTargetGameObjectTypeState((GameObjectTypeStateEntity) targetGameObjectTypeState));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type state transitions", ex);
        }
    }

    @Override
    public List<GameObjectTypeStateTransition> findAllGameObjectTypeStateTransitionsByTriggerAction(Action triggerAction) {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeStateTransitionsRepository.findAllByTriggerAction((ActionEntity) triggerAction));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type state transitions", ex);
        }
    }

    @Override
    public List<GameObjectTypeStateTransition> findAllGameObjectTypeStateTransitionsByAnyTextFieldContaining(String content) {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeStateTransitionsRepository.findAllByAnyTextFieldContaining(content));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type state transitions", ex);
        }
    }

    public GameObjectTypeAllowedAddonType newGameObjectTypeAllowedAddonType() {
        return new GameObjectTypeAllowedAddonTypeEntity();
    }

    @Override
    public List<GameObjectTypeAllowedAddonType> findAllGameObjectTypeAllowedAddonTypes() {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeAllowedAddonTypesRepository.findAll());
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type allowed addon types", ex);
        }
    }

    @Override
    public GameObjectTypeAllowedAddonType findGameObjectTypeAllowedAddonType(Long id) {
        try {
            return daoBundle.gameObjectTypeAllowedAddonTypesRepository.findOneById(id);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type allowed addon type", ex);
        }
    }

    @Override
    public GameObjectTypeAllowedAddonType saveGameObjectTypeAllowedAddonType(GameObjectTypeAllowedAddonType gameObjectTypeAllowedAddonType) {
        try {
            return daoBundle.gameObjectTypeAllowedAddonTypesRepository
                    .save((GameObjectTypeAllowedAddonTypeEntity) gameObjectTypeAllowedAddonType);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game object type allowed addon type", ex);
        }
    }

    @Override
    public void deleteGameObjectTypeAllowedAddonType(GameObjectTypeAllowedAddonType gameObjectTypeAllowedAddonType) {
        try {
            daoBundle.gameObjectTypeAllowedAddonTypesRepository.delete((GameObjectTypeAllowedAddonTypeEntity) gameObjectTypeAllowedAddonType);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete game object type allowed addon type", ex);
        }
    }

    @Override
    public List<GameObjectTypeAllowedAddonType> findAllGameObjectTypeAllowedAddonTypesByExample(GameObjectTypeAllowedAddonType example) {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeAllowedAddonTypesRepository.findAllByExample(example.getUniqueName(),
                    (GameObjectTypeEntity) example.getAddonGameObjectType(), (GameObjectTypeEntity) example.getApplicableToGameObjectType(),
                    example.getIsEquipedByDefault(), example.getIsIncremental(), example.getIsTriggered(),
                    (ActionEntity) example.getTriggerAction(), example.getIsSpawning(),
                    (GameObjectTypeEntity) example.getSpawnableGameObjectType(), example.getHasLimitedDuration(), example.getDuration()));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type allowed addon types", ex);
        }
    }

    @Override
    public GameObjectTypeAllowedAddonType findGameObjectTypeAllowedAddonTypeByUniqueName(String uniqueName) {
        try {
            return daoBundle.gameObjectTypeAllowedAddonTypesRepository.findOneByUniqueName(uniqueName);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type allowed addon types", ex);
        }
    }

    @Override
    public List<GameObjectTypeAllowedAddonType> findAllGameObjectTypeAllowedAddonTypesByAddonGameObjectType(
            GameObjectType addonGameObjectType) {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeAllowedAddonTypesRepository
                    .findAllByAddonGameObjectType((GameObjectTypeEntity) addonGameObjectType));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type allowed addon types", ex);
        }
    }

    @Override
    public List<GameObjectTypeAllowedAddonType> findAllGameObjectTypeAllowedAddonTypesByApplicableToGameObjectType(
            GameObjectType applicableToGameObjectType) {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeAllowedAddonTypesRepository
                    .findAllByApplicableToGameObjectType((GameObjectTypeEntity) applicableToGameObjectType));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type allowed addon types", ex);
        }
    }

    @Override
    public List<GameObjectTypeAllowedAddonType> findAllGameObjectTypeAllowedAddonTypesByTriggerAction(Action triggerAction) {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeAllowedAddonTypesRepository.findAllByTriggerAction((ActionEntity) triggerAction));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type allowed addon types", ex);
        }
    }

    @Override
    public List<GameObjectTypeAllowedAddonType> findAllGameObjectTypeAllowedAddonTypesBySpawnableGameObjectType(
            GameObjectType spawnableGameObjectType) {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeAllowedAddonTypesRepository
                    .findAllBySpawnableGameObjectType((GameObjectTypeEntity) spawnableGameObjectType));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type allowed addon types", ex);
        }
    }

    @Override
    public List<GameObjectTypeAllowedAddonType> findAllGameObjectTypeAllowedAddonTypesByAnyTextFieldContaining(String content) {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeAllowedAddonTypesRepository.findAllByAnyTextFieldContaining(content));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type allowed addon types", ex);
        }
    }

    public GameObjectTypeInteraction newGameObjectTypeInteraction() {
        return new GameObjectTypeInteractionEntity();
    }

    @Override
    public List<GameObjectTypeInteraction> findAllGameObjectTypeInteractions() {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeInteractionsRepository.findAll());
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type interactions", ex);
        }
    }

    @Override
    public GameObjectTypeInteraction findGameObjectTypeInteraction(Long id) {
        try {
            return daoBundle.gameObjectTypeInteractionsRepository.findOneById(id);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type interaction", ex);
        }
    }

    @Override
    public GameObjectTypeInteraction saveGameObjectTypeInteraction(GameObjectTypeInteraction gameObjectTypeInteraction) {
        try {
            return daoBundle.gameObjectTypeInteractionsRepository.save((GameObjectTypeInteractionEntity) gameObjectTypeInteraction);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game object type interaction", ex);
        }
    }

    @Override
    public void deleteGameObjectTypeInteraction(GameObjectTypeInteraction gameObjectTypeInteraction) {
        try {
            daoBundle.gameObjectTypeInteractionsRepository.delete((GameObjectTypeInteractionEntity) gameObjectTypeInteraction);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete game object type interaction", ex);
        }
    }

    @Override
    public List<GameObjectTypeInteraction> findAllGameObjectTypeInteractionsByExample(GameObjectTypeInteraction example) {
        try {
            return new ArrayList<>(
                    daoBundle.gameObjectTypeInteractionsRepository.findAllByExample((GameObjectTypeEntity) example.getDonatingGameObjectType(),
                            (GameObjectTypeEntity) example.getReceivingGameObjectType(), example.getRadius()));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type interactions", ex);
        }
    }

    @Override
    public List<GameObjectTypeInteraction> findAllGameObjectTypeInteractionsByDonatingGameObjectType(GameObjectType donatingGameObjectType) {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeInteractionsRepository
                    .findAllByDonatingGameObjectType((GameObjectTypeEntity) donatingGameObjectType));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type interactions", ex);
        }
    }

    @Override
    public List<GameObjectTypeInteraction> findAllGameObjectTypeInteractionsByReceivingGameObjectType(GameObjectType receivingGameObjectType) {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeInteractionsRepository
                    .findAllByReceivingGameObjectType((GameObjectTypeEntity) receivingGameObjectType));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type interactions", ex);
        }
    }

    @Override
    public List<GameObjectTypeInteraction> findAllGameObjectTypeInteractionsByAnyTextFieldContaining(String content) {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeInteractionsRepository.findAllByAnyTextFieldContaining(content));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type interactions", ex);
        }
    }

    public GameClientType newGameClientType() {
        return new GameClientTypeEntity();
    }

    @Override
    public List<GameClientType> findAllGameClientTypes() {
        try {
            return new ArrayList<>(daoBundle.gameClientTypesRepository.findAll());
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game client types", ex);
        }
    }

    @Override
    public GameClientType findGameClientType(Long id) {
        try {
            return daoBundle.gameClientTypesRepository.findOneById(id);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game client type", ex);
        }
    }

    @Override
    public GameClientType saveGameClientType(GameClientType gameClientType) {
        try {
            return daoBundle.gameClientTypesRepository.save((GameClientTypeEntity) gameClientType);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game client type", ex);
        }
    }

    @Override
    public void deleteGameClientType(GameClientType gameClientType) {
        try {
            daoBundle.gameClientTypesRepository.delete((GameClientTypeEntity) gameClientType);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete game client type", ex);
        }
    }

    @Override
    public List<GameClientType> findAllGameClientTypesByExample(GameClientType example) {
        try {
            return new ArrayList<>(daoBundle.gameClientTypesRepository.findAllByExample(example.getUniqueName()));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game client types", ex);
        }
    }

    @Override
    public GameClientType findGameClientTypeByUniqueName(String uniqueName) {
        try {
            return daoBundle.gameClientTypesRepository.findOneByUniqueName(uniqueName);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game client types", ex);
        }
    }

    @Override
    public List<GameClientType> findAllGameClientTypesByAnyTextFieldContaining(String content) {
        try {
            return new ArrayList<>(daoBundle.gameClientTypesRepository.findAllByAnyTextFieldContaining(content));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game client types", ex);
        }
    }

    public GameObjectTypeRepresentation newGameObjectTypeRepresentation() {
        return new GameObjectTypeRepresentationEntity();
    }

    @Override
    public List<GameObjectTypeRepresentation> findAllGameObjectTypeRepresentations() {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeRepresentationsRepository.findAll());
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type representations", ex);
        }
    }

    @Override
    public GameObjectTypeRepresentation findGameObjectTypeRepresentation(Long id) {
        try {
            return daoBundle.gameObjectTypeRepresentationsRepository.findOneById(id);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type representation", ex);
        }
    }

    @Override
    public GameObjectTypeRepresentation saveGameObjectTypeRepresentation(GameObjectTypeRepresentation gameObjectTypeRepresentation) {
        try {
            return daoBundle.gameObjectTypeRepresentationsRepository.save((GameObjectTypeRepresentationEntity) gameObjectTypeRepresentation);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game object type representation", ex);
        }
    }

    @Override
    public void deleteGameObjectTypeRepresentation(GameObjectTypeRepresentation gameObjectTypeRepresentation) {
        try {
            daoBundle.gameObjectTypeRepresentationsRepository.delete((GameObjectTypeRepresentationEntity) gameObjectTypeRepresentation);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete game object type representation", ex);
        }
    }

    @Override
    public List<GameObjectTypeRepresentation> findAllGameObjectTypeRepresentationsByExample(GameObjectTypeRepresentation example) {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeRepresentationsRepository
                    .findAllByExample((GameObjectTypeEntity) example.getGameObjectType(), (GameClientTypeEntity) example.getGameClientType()));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type representations", ex);
        }
    }

    @Override
    public List<GameObjectTypeRepresentation> findAllGameObjectTypeRepresentationsByGameObjectType(GameObjectType gameObjectType) {
        try {
            return new ArrayList<>(
                    daoBundle.gameObjectTypeRepresentationsRepository.findAllByGameObjectType((GameObjectTypeEntity) gameObjectType));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type representations", ex);
        }
    }

    @Override
    public List<GameObjectTypeRepresentation> findAllGameObjectTypeRepresentationsByGameClientType(GameClientType gameClientType) {
        try {
            return new ArrayList<>(
                    daoBundle.gameObjectTypeRepresentationsRepository.findAllByGameClientType((GameClientTypeEntity) gameClientType));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type representations", ex);
        }
    }

    @Override
    public List<GameObjectTypeRepresentation> findAllGameObjectTypeRepresentationsByAnyTextFieldContaining(String content) {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeRepresentationsRepository.findAllByAnyTextFieldContaining(content));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type representations", ex);
        }
    }

    public GameObjectTypeState newGameObjectTypeState() {
        return new GameObjectTypeStateEntity();
    }

    @Override
    public List<GameObjectTypeState> findAllGameObjectTypeStates() {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeStatesRepository.findAll());
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type states", ex);
        }
    }

    @Override
    public GameObjectTypeState findGameObjectTypeState(Long id) {
        try {
            return daoBundle.gameObjectTypeStatesRepository.findOneById(id);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type state", ex);
        }
    }

    @Override
    public GameObjectTypeState saveGameObjectTypeState(GameObjectTypeState gameObjectTypeState) {
        try {
            return daoBundle.gameObjectTypeStatesRepository.save((GameObjectTypeStateEntity) gameObjectTypeState);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game object type state", ex);
        }
    }

    @Override
    public void deleteGameObjectTypeState(GameObjectTypeState gameObjectTypeState) {
        try {
            daoBundle.gameObjectTypeStatesRepository.delete((GameObjectTypeStateEntity) gameObjectTypeState);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete game object type state", ex);
        }
    }

    @Override
    public List<GameObjectTypeState> findAllGameObjectTypeStatesByExample(GameObjectTypeState example) {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeStatesRepository.findAllByExample((GameObjectTypeEntity) example.getGameObjectType(),
                    example.getName()));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type states", ex);
        }
    }

    @Override
    public List<GameObjectTypeState> findAllGameObjectTypeStatesByGameObjectType(GameObjectType gameObjectType) {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeStatesRepository.findAllByGameObjectType((GameObjectTypeEntity) gameObjectType));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type states", ex);
        }
    }

    @Override
    public GameObjectTypeState findGameObjectTypeStateByName(String name) {
        try {
            return daoBundle.gameObjectTypeStatesRepository.findOneByName(name);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type states", ex);
        }
    }

    @Override
    public List<GameObjectTypeState> findAllGameObjectTypeStatesByAnyTextFieldContaining(String content) {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeStatesRepository.findAllByAnyTextFieldContaining(content));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type states", ex);
        }
    }

    public GameObjectTypeProperty newGameObjectTypeProperty() {
        return new GameObjectTypePropertyEntity();
    }

    @Override
    public List<GameObjectTypeProperty> findAllGameObjectTypeProperties() {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypePropertiesRepository.findAll());
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type properties", ex);
        }
    }

    @Override
    public GameObjectTypeProperty findGameObjectTypeProperty(Long id) {
        try {
            return daoBundle.gameObjectTypePropertiesRepository.findOneById(id);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type property", ex);
        }
    }

    @Override
    public GameObjectTypeProperty saveGameObjectTypeProperty(GameObjectTypeProperty gameObjectTypeProperty) {
        try {
            return daoBundle.gameObjectTypePropertiesRepository.save((GameObjectTypePropertyEntity) gameObjectTypeProperty);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game object type property", ex);
        }
    }

    @Override
    public void deleteGameObjectTypeProperty(GameObjectTypeProperty gameObjectTypeProperty) {
        try {
            daoBundle.gameObjectTypePropertiesRepository.delete((GameObjectTypePropertyEntity) gameObjectTypeProperty);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete game object type property", ex);
        }
    }

    @Override
    public List<GameObjectTypeProperty> findAllGameObjectTypePropertiesByExample(GameObjectTypeProperty example) {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypePropertiesRepository.findAllByExample(
                    (GameObjectTypeEntity) example.getGameObjectType(), example.getPropertyName(), example.getPropertyDefaultValue(),
                    example.getPropertyMinValue(), example.getPropertyMaxValue()));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type properties", ex);
        }
    }

    @Override
    public List<GameObjectTypeProperty> findAllGameObjectTypePropertiesByGameObjectType(GameObjectType gameObjectType) {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypePropertiesRepository.findAllByGameObjectType((GameObjectTypeEntity) gameObjectType));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type properties", ex);
        }
    }

    @Override
    public GameObjectTypeProperty findGameObjectTypePropertyByPropertyName(String propertyName) {
        try {
            return daoBundle.gameObjectTypePropertiesRepository.findOneByPropertyName(propertyName);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type properties", ex);
        }
    }

    @Override
    public List<GameObjectTypeProperty> findAllGameObjectTypePropertiesByAnyTextFieldContaining(String content) {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypePropertiesRepository.findAllByAnyTextFieldContaining(content));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type properties", ex);
        }
    }

    public GameAddonInteractionReceivingPropertyModifier newGameAddonInteractionReceivingPropertyModifier() {
        return new GameAddonInteractionReceivingPropertyModifierEntity();
    }

    @Override
    public List<GameAddonInteractionReceivingPropertyModifier> findAllGameAddonInteractionReceivingPropertyModifiers() {
        try {
            return new ArrayList<>(daoBundle.gameAddonInteractionReceivingPropertyModifiersRepository.findAll());
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException(
                    "Unable to retrieve game addon interaction receiving property modifiers", ex);
        }
    }

    @Override
    public GameAddonInteractionReceivingPropertyModifier findGameAddonInteractionReceivingPropertyModifier(Long id) {
        try {
            return daoBundle.gameAddonInteractionReceivingPropertyModifiersRepository.findOneById(id);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException(
                    "Unable to retrieve game addon interaction receiving property modifier", ex);
        }
    }

    @Override
    public GameAddonInteractionReceivingPropertyModifier saveGameAddonInteractionReceivingPropertyModifier(
            GameAddonInteractionReceivingPropertyModifier gameAddonInteractionReceivingPropertyModifier) {
        try {
            return daoBundle.gameAddonInteractionReceivingPropertyModifiersRepository
                    .save((GameAddonInteractionReceivingPropertyModifierEntity) gameAddonInteractionReceivingPropertyModifier);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException(
                    "Unable to save game addon interaction receiving property modifier", ex);
        }
    }

    @Override
    public void deleteGameAddonInteractionReceivingPropertyModifier(
            GameAddonInteractionReceivingPropertyModifier gameAddonInteractionReceivingPropertyModifier) {
        try {
            daoBundle.gameAddonInteractionReceivingPropertyModifiersRepository
                    .delete((GameAddonInteractionReceivingPropertyModifierEntity) gameAddonInteractionReceivingPropertyModifier);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException(
                    "Unable to delete game addon interaction receiving property modifier", ex);
        }
    }

    @Override
    public List<GameAddonInteractionReceivingPropertyModifier> findAllGameAddonInteractionReceivingPropertyModifiersByExample(
            GameAddonInteractionReceivingPropertyModifier example) {
        try {
            return new ArrayList<>(daoBundle.gameAddonInteractionReceivingPropertyModifiersRepository.findAllByExample(
                    (GameObjectTypeAllowedAddonTypeEntity) example.getGameObjectTypeAllowedAddonType(),
                    (GameObjectTypePropertyEntity) example.getAffectedGameObjectTypeProperty(), example.getAppliedPropertyValueMultiplier()));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException(
                    "Unable to find game addon interaction receiving property modifiers", ex);
        }
    }

    @Override
    public List<GameAddonInteractionReceivingPropertyModifier> findAllGameAddonInteractionReceivingPropertyModifiersByGameObjectTypeAllowedAddonType(
            GameObjectTypeAllowedAddonType gameObjectTypeAllowedAddonType) {
        try {
            return new ArrayList<>(daoBundle.gameAddonInteractionReceivingPropertyModifiersRepository
                    .findAllByGameObjectTypeAllowedAddonType((GameObjectTypeAllowedAddonTypeEntity) gameObjectTypeAllowedAddonType));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException(
                    "Unable to find game addon interaction receiving property modifiers", ex);
        }
    }

    @Override
    public List<GameAddonInteractionReceivingPropertyModifier> findAllGameAddonInteractionReceivingPropertyModifiersByAffectedGameObjectTypeProperty(
            GameObjectTypeProperty affectedGameObjectTypeProperty) {
        try {
            return new ArrayList<>(daoBundle.gameAddonInteractionReceivingPropertyModifiersRepository
                    .findAllByAffectedGameObjectTypeProperty((GameObjectTypePropertyEntity) affectedGameObjectTypeProperty));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException(
                    "Unable to find game addon interaction receiving property modifiers", ex);
        }
    }

    @Override
    public List<GameAddonInteractionReceivingPropertyModifier> findAllGameAddonInteractionReceivingPropertyModifiersByAnyTextFieldContaining(
            String content) {
        try {
            return new ArrayList<>(daoBundle.gameAddonInteractionReceivingPropertyModifiersRepository.findAllByAnyTextFieldContaining(content));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException(
                    "Unable to find game addon interaction receiving property modifiers", ex);
        }
    }

    public GameObjectTypeInteractionProperty newGameObjectTypeInteractionProperty() {
        return new GameObjectTypeInteractionPropertyEntity();
    }

    @Override
    public List<GameObjectTypeInteractionProperty> findAllGameObjectTypeInteractionProperties() {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeInteractionPropertiesRepository.findAll());
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type interaction properties",
                    ex);
        }
    }

    @Override
    public GameObjectTypeInteractionProperty findGameObjectTypeInteractionProperty(Long id) {
        try {
            return daoBundle.gameObjectTypeInteractionPropertiesRepository.findOneById(id);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type interaction property", ex);
        }
    }

    @Override
    public GameObjectTypeInteractionProperty saveGameObjectTypeInteractionProperty(
            GameObjectTypeInteractionProperty gameObjectTypeInteractionProperty) {
        try {
            return daoBundle.gameObjectTypeInteractionPropertiesRepository
                    .save((GameObjectTypeInteractionPropertyEntity) gameObjectTypeInteractionProperty);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game object type interaction property", ex);
        }
    }

    @Override
    public void deleteGameObjectTypeInteractionProperty(GameObjectTypeInteractionProperty gameObjectTypeInteractionProperty) {
        try {
            daoBundle.gameObjectTypeInteractionPropertiesRepository
                    .delete((GameObjectTypeInteractionPropertyEntity) gameObjectTypeInteractionProperty);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete game object type interaction property", ex);
        }
    }

    @Override
    public List<GameObjectTypeInteractionProperty> findAllGameObjectTypeInteractionPropertiesByExample(
            GameObjectTypeInteractionProperty example) {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeInteractionPropertiesRepository.findAllByExample(
                    (GameObjectTypeInteractionEntity) example.getGameObjectTypeInteraction(),
                    (GameObjectTypePropertyEntity) example.getDonatingGameObjectTypeProperty(),
                    (GameObjectTypePropertyEntity) example.getReceivingGameObjectTypeProperty(),
                    (GameObjectTypePropertyEntity) example.getOverflowGameObjectTypeProperty(), example.getIsIncremental(),
                    example.getIsInverted()));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type interaction properties", ex);
        }
    }

    @Override
    public List<GameObjectTypeInteractionProperty> findAllGameObjectTypeInteractionPropertiesByGameObjectTypeInteraction(
            GameObjectTypeInteraction gameObjectTypeInteraction) {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeInteractionPropertiesRepository
                    .findAllByGameObjectTypeInteraction((GameObjectTypeInteractionEntity) gameObjectTypeInteraction));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type interaction properties", ex);
        }
    }

    @Override
    public List<GameObjectTypeInteractionProperty> findAllGameObjectTypeInteractionPropertiesByDonatingGameObjectTypeProperty(
            GameObjectTypeProperty donatingGameObjectTypeProperty) {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeInteractionPropertiesRepository
                    .findAllByDonatingGameObjectTypeProperty((GameObjectTypePropertyEntity) donatingGameObjectTypeProperty));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type interaction properties", ex);
        }
    }

    @Override
    public List<GameObjectTypeInteractionProperty> findAllGameObjectTypeInteractionPropertiesByReceivingGameObjectTypeProperty(
            GameObjectTypeProperty receivingGameObjectTypeProperty) {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeInteractionPropertiesRepository
                    .findAllByReceivingGameObjectTypeProperty((GameObjectTypePropertyEntity) receivingGameObjectTypeProperty));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type interaction properties", ex);
        }
    }

    @Override
    public List<GameObjectTypeInteractionProperty> findAllGameObjectTypeInteractionPropertiesByOverflowGameObjectTypeProperty(
            GameObjectTypeProperty overflowGameObjectTypeProperty) {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeInteractionPropertiesRepository
                    .findAllByOverflowGameObjectTypeProperty((GameObjectTypePropertyEntity) overflowGameObjectTypeProperty));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type interaction properties", ex);
        }
    }

    @Override
    public List<GameObjectTypeInteractionProperty> findAllGameObjectTypeInteractionPropertiesByAnyTextFieldContaining(String content) {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeInteractionPropertiesRepository.findAllByAnyTextFieldContaining(content));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type interaction properties", ex);
        }
    }

    public GameObjectTypeStatePropertyModifier newGameObjectTypeStatePropertyModifier() {
        return new GameObjectTypeStatePropertyModifierEntity();
    }

    @Override
    public List<GameObjectTypeStatePropertyModifier> findAllGameObjectTypeStatePropertyModifiers() {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeStatePropertyModifiersRepository.findAll());
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type state property modifiers",
                    ex);
        }
    }

    @Override
    public GameObjectTypeStatePropertyModifier findGameObjectTypeStatePropertyModifier(Long id) {
        try {
            return daoBundle.gameObjectTypeStatePropertyModifiersRepository.findOneById(id);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type state property modifier",
                    ex);
        }
    }

    @Override
    public GameObjectTypeStatePropertyModifier saveGameObjectTypeStatePropertyModifier(
            GameObjectTypeStatePropertyModifier gameObjectTypeStatePropertyModifier) {
        try {
            return daoBundle.gameObjectTypeStatePropertyModifiersRepository
                    .save((GameObjectTypeStatePropertyModifierEntity) gameObjectTypeStatePropertyModifier);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game object type state property modifier", ex);
        }
    }

    @Override
    public void deleteGameObjectTypeStatePropertyModifier(GameObjectTypeStatePropertyModifier gameObjectTypeStatePropertyModifier) {
        try {
            daoBundle.gameObjectTypeStatePropertyModifiersRepository
                    .delete((GameObjectTypeStatePropertyModifierEntity) gameObjectTypeStatePropertyModifier);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete game object type state property modifier",
                    ex);
        }
    }

    @Override
    public List<GameObjectTypeStatePropertyModifier> findAllGameObjectTypeStatePropertyModifiersByExample(
            GameObjectTypeStatePropertyModifier example) {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeStatePropertyModifiersRepository.findAllByExample(
                    (GameObjectTypeStateEntity) example.getGameObjectTypeState(),
                    (GameObjectTypePropertyEntity) example.getGameObjectTypeProperty(), example.getPropertyActualValue()));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type state property modifiers", ex);
        }
    }

    @Override
    public List<GameObjectTypeStatePropertyModifier> findAllGameObjectTypeStatePropertyModifiersByGameObjectTypeState(
            GameObjectTypeState gameObjectTypeState) {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeStatePropertyModifiersRepository
                    .findAllByGameObjectTypeState((GameObjectTypeStateEntity) gameObjectTypeState));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type state property modifiers", ex);
        }
    }

    @Override
    public List<GameObjectTypeStatePropertyModifier> findAllGameObjectTypeStatePropertyModifiersByGameObjectTypeProperty(
            GameObjectTypeProperty gameObjectTypeProperty) {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeStatePropertyModifiersRepository
                    .findAllByGameObjectTypeProperty((GameObjectTypePropertyEntity) gameObjectTypeProperty));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type state property modifiers", ex);
        }
    }

    @Override
    public List<GameObjectTypeStatePropertyModifier> findAllGameObjectTypeStatePropertyModifiersByAnyTextFieldContaining(String content) {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeStatePropertyModifiersRepository.findAllByAnyTextFieldContaining(content));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type state property modifiers", ex);
        }
    }

    public GameObjectTypeClass newGameObjectTypeClass() {
        return new GameObjectTypeClassEntity();
    }

    @Override
    public List<GameObjectTypeClass> findAllGameObjectTypeClasses() {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeClassesRepository.findAll());
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type classes", ex);
        }
    }

    @Override
    public GameObjectTypeClass findGameObjectTypeClass(Long id) {
        try {
            return daoBundle.gameObjectTypeClassesRepository.findOneById(id);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type class", ex);
        }
    }

    @Override
    public GameObjectTypeClass saveGameObjectTypeClass(GameObjectTypeClass gameObjectTypeClass) {
        try {
            return daoBundle.gameObjectTypeClassesRepository.save((GameObjectTypeClassEntity) gameObjectTypeClass);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game object type class", ex);
        }
    }

    @Override
    public void deleteGameObjectTypeClass(GameObjectTypeClass gameObjectTypeClass) {
        try {
            daoBundle.gameObjectTypeClassesRepository.delete((GameObjectTypeClassEntity) gameObjectTypeClass);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete game object type class", ex);
        }
    }

    @Override
    public List<GameObjectTypeClass> findAllGameObjectTypeClassesByExample(GameObjectTypeClass example) {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeClassesRepository.findAllByExample(example.getName()));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type classes", ex);
        }
    }

    @Override
    public GameObjectTypeClass findGameObjectTypeClassByName(String name) {
        try {
            return daoBundle.gameObjectTypeClassesRepository.findOneByName(name);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type classes", ex);
        }
    }

    @Override
    public List<GameObjectTypeClass> findAllGameObjectTypeClassesByAnyTextFieldContaining(String content) {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypeClassesRepository.findAllByAnyTextFieldContaining(content));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type classes", ex);
        }
    }

    public GameAssetsRepository newGameAssetsRepository() {
        return new GameAssetsRepositoryEntity();
    }

    @Override
    public List<GameAssetsRepository> findAllGameAssetsRepositories() {
        try {
            return new ArrayList<>(daoBundle.gameAssetsRepositoriesRepository.findAll());
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game assets repositories", ex);
        }
    }

    @Override
    public GameAssetsRepository findGameAssetsRepository(Long id) {
        try {
            return daoBundle.gameAssetsRepositoriesRepository.findOneById(id);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game assets repository", ex);
        }
    }

    @Override
    public GameAssetsRepository saveGameAssetsRepository(GameAssetsRepository gameAssetsRepository) {
        try {
            return daoBundle.gameAssetsRepositoriesRepository.save((GameAssetsRepositoryEntity) gameAssetsRepository);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game assets repository", ex);
        }
    }

    @Override
    public void deleteGameAssetsRepository(GameAssetsRepository gameAssetsRepository) {
        try {
            daoBundle.gameAssetsRepositoriesRepository.delete((GameAssetsRepositoryEntity) gameAssetsRepository);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete game assets repository", ex);
        }
    }

    @Override
    public List<GameAssetsRepository> findAllGameAssetsRepositoriesByExample(GameAssetsRepository example) {
        try {
            return new ArrayList<>(daoBundle.gameAssetsRepositoriesRepository.findAllByExample(example.getUniqueName(), example.getDescription()));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game assets repositories", ex);
        }
    }

    @Override
    public GameAssetsRepository findGameAssetsRepositoryByUniqueName(String uniqueName) {
        try {
            return daoBundle.gameAssetsRepositoriesRepository.findOneByUniqueName(uniqueName);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game assets repositories", ex);
        }
    }

    @Override
    public List<GameAssetsRepository> findAllGameAssetsRepositoriesByAnyTextFieldContaining(String content) {
        try {
            return new ArrayList<>(daoBundle.gameAssetsRepositoriesRepository.findAllByAnyTextFieldContaining(content));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game assets repositories", ex);
        }
    }

    public GameObjectType newGameObjectType() {
        return new GameObjectTypeEntity();
    }

    @Override
    public List<GameObjectType> findAllGameObjectTypes() {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypesRepository.findAll());
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object types", ex);
        }
    }

    @Override
    public GameObjectType findGameObjectType(Long id) {
        try {
            return daoBundle.gameObjectTypesRepository.findOneById(id);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type", ex);
        }
    }

    @Override
    public GameObjectType saveGameObjectType(GameObjectType gameObjectType) {
        try {
            return daoBundle.gameObjectTypesRepository.save((GameObjectTypeEntity) gameObjectType);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game object type", ex);
        }
    }

    @Override
    public void deleteGameObjectType(GameObjectType gameObjectType) {
        try {
            daoBundle.gameObjectTypesRepository.delete((GameObjectTypeEntity) gameObjectType);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete game object type", ex);
        }
    }

    @Override
    public List<GameObjectType> findAllGameObjectTypesByExample(GameObjectType example) {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypesRepository.findAllByExample(
                    (GameAssetsRepositoryEntity) example.getGameAssetsRepository(),
                    (GameObjectTypeClassEntity) example.getGameObjectTypeClass(), example.getUniqueName(), example.getIsExperimental()));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object types", ex);
        }
    }

    @Override
    public List<GameObjectType> findAllGameObjectTypesByGameAssetsRepository(GameAssetsRepository gameAssetsRepository) {
        try {
            return new ArrayList<>(
                    daoBundle.gameObjectTypesRepository.findAllByGameAssetsRepository((GameAssetsRepositoryEntity) gameAssetsRepository));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object types", ex);
        }
    }

    @Override
    public List<GameObjectType> findAllGameObjectTypesByGameObjectTypeClass(GameObjectTypeClass gameObjectTypeClass) {
        try {
            return new ArrayList<>(
                    daoBundle.gameObjectTypesRepository.findAllByGameObjectTypeClass((GameObjectTypeClassEntity) gameObjectTypeClass));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object types", ex);
        }
    }

    @Override
    public GameObjectType findGameObjectTypeByUniqueName(String uniqueName) {
        try {
            return daoBundle.gameObjectTypesRepository.findOneByUniqueName(uniqueName);
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object types", ex);
        }
    }

    @Override
    public List<GameObjectType> findAllGameObjectTypesByAnyTextFieldContaining(String content) {
        try {
            return new ArrayList<>(daoBundle.gameObjectTypesRepository.findAllByAnyTextFieldContaining(content));
        } catch (Exception ex) {
            throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object types", ex);
        }
    }

    public ImplementationType getImplementationType() {
        return implementationType;
    }

    public void setImplementationType(ImplementationType implementationType) {
        this.implementationType = implementationType;
    }

    @Override
    public GameAssetsRepositoryOwner findGameAssetsRepositoryOwnerByGameAssetsRepositoryIdAndOwnerId(Long gameAssetsRepositoryId,
            Long ownerId) {
        return daoBundle.gameAssetsRepositoryOwnersRepository.findOneByGameAssetsRepositoryIdAndOwnerUserId(gameAssetsRepositoryId, ownerId);
    }

    @Override
    public void deleteGameAssetsRepositoryOwnersByGameAssetsRepository(GameAssetsRepository rep) {
        daoBundle.gameAssetsRepositoryOwnersRepository.deleteByGameAssetsRepository(rep);
    }

    @Override
    public GameAssetsRepositoryOwner saveGameAssetsRepositoryOwner(GameAssetsRepositoryOwner repOwner) {
        return daoBundle.gameAssetsRepositoryOwnersRepository.save(repOwner);
    }

    @Override
    public GameAssetsRepositoryOwner newGameAssetsRepositoryOwner(GameAssetsRepository gameAssetsRepository, Long ownerUserId) {
        return new GameAssetsRepositoryOwnerEntity((GameAssetsRepositoryEntity) gameAssetsRepository, ownerUserId);
    }
}
