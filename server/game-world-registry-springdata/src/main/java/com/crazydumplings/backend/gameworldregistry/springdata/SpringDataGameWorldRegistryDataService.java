package com.crazydumplings.backend.gameworldregistry.springdata;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.annotation.Generated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
import com.crazydumplings.backend.gameworldregistry.springdata.dao.spring.SpringJpaActionsRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.spring.SpringJpaAutomationObjectProvidersRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.spring.SpringJpaGameAddonInteractionReceivingPropertyModifiersRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.spring.SpringJpaGameAssetsRepositoriesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.spring.SpringJpaGameAssetsRepositoryOwnersRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.spring.SpringJpaGameClientTypesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.spring.SpringJpaGameObjectTypeAllowedAddonTypesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.spring.SpringJpaGameObjectTypeAutomationsRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.spring.SpringJpaGameObjectTypeClassesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.spring.SpringJpaGameObjectTypeInteractionPropertiesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.spring.SpringJpaGameObjectTypeInteractionsRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.spring.SpringJpaGameObjectTypePropertiesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.spring.SpringJpaGameObjectTypeRepresentationsRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.spring.SpringJpaGameObjectTypeStatePropertyModifiersRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.spring.SpringJpaGameObjectTypeStateTransitionsRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.spring.SpringJpaGameObjectTypeStatesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.spring.SpringJpaGameObjectTypesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.spring.SpringJpaGameWorldCellPropertiesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.spring.SpringJpaGameWorldCellTypesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.spring.SpringJpaGameWorldCellsRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.spring.SpringJpaGameWorldSpawnPointTypesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.spring.SpringJpaGameWorldsRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.spring.SpringJpaPlayableCharacterTypesRepository;
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
	@Autowired
	SpringJpaPlayableCharacterTypesRepository playableCharacterTypesRepository;

	@Autowired
	SpringJpaGameWorldSpawnPointTypesRepository gameWorldSpawnPointTypesRepository;

	@Autowired
	SpringJpaGameWorldCellTypesRepository gameWorldCellTypesRepository;

	@Autowired
	SpringJpaGameWorldsRepository gameWorldsRepository;

	@Autowired
	SpringJpaGameWorldCellsRepository gameWorldCellsRepository;

	@Autowired
	SpringJpaGameWorldCellPropertiesRepository gameWorldCellPropertiesRepository;

	@Autowired
	SpringJpaAutomationObjectProvidersRepository automationObjectProvidersRepository;

	@Autowired
	SpringJpaGameObjectTypeAutomationsRepository gameObjectTypeAutomationsRepository;

	@Autowired
	SpringJpaActionsRepository actionsRepository;

	@Autowired
	SpringJpaGameObjectTypeStateTransitionsRepository gameObjectTypeStateTransitionsRepository;

	@Autowired
	SpringJpaGameObjectTypeAllowedAddonTypesRepository gameObjectTypeAllowedAddonTypesRepository;

	@Autowired
	SpringJpaGameAddonInteractionReceivingPropertyModifiersRepository gameAddonInteractionReceivingPropertyModifiersRepository;

	@Autowired
	SpringJpaGameObjectTypeInteractionsRepository gameObjectTypeInteractionsRepository;

	@Autowired
	SpringJpaGameObjectTypeInteractionPropertiesRepository gameObjectTypeInteractionPropertiesRepository;

	@Autowired
	SpringJpaGameClientTypesRepository gameClientTypesRepository;

	@Autowired
	SpringJpaGameObjectTypeRepresentationsRepository gameObjectTypeRepresentationsRepository;

	@Autowired
	SpringJpaGameObjectTypeStatesRepository gameObjectTypeStatesRepository;

	@Autowired
	SpringJpaGameObjectTypeStatePropertyModifiersRepository gameObjectTypeStatePropertyModifiersRepository;

	@Autowired
	SpringJpaGameObjectTypeClassesRepository gameObjectTypeClassesRepository;

	@Autowired
	SpringJpaGameAssetsRepositoriesRepository gameAssetsRepositoriesRepository;

	@Autowired
	SpringJpaGameObjectTypesRepository gameObjectTypesRepository;

	@Autowired
	SpringJpaGameObjectTypePropertiesRepository gameObjectTypePropertiesRepository;

	@Autowired
	SpringJpaGameAssetsRepositoryOwnersRepository gameAssetsRepositoryOwnersRepository;


	public PlayableCharacterType newPlayableCharacterType() {
		return new PlayableCharacterTypeEntity();
	}

	@Override
	public PlayableCharacterType newPlayableCharacterType(Long id) {
		return new PlayableCharacterTypeEntity(id);
	}

	@Override
	public List<PlayableCharacterType> findAllPlayableCharacterTypes() {
		try {
			return StreamSupport.stream(playableCharacterTypesRepository.findAll().spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve playable character types", ex);
		}
	}

	@Override
	public PlayableCharacterType findPlayableCharacterType(Long id) {
		try {
			return playableCharacterTypesRepository.findById(id).orElse(null);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve playable character type", ex);
		}
	}

	@Override
	public PlayableCharacterType savePlayableCharacterType(PlayableCharacterType playableCharacterType) {
		try {
			return playableCharacterTypesRepository.save((PlayableCharacterTypeEntity) playableCharacterType);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save playable character type", ex);
		}
	}

	@Override
	public List<PlayableCharacterType> savePlayableCharacterTypes(List<PlayableCharacterType> playableCharacterTypes) {
		try {
			Iterable<PlayableCharacterTypeEntity> lst = playableCharacterTypes.stream().map(a -> (PlayableCharacterTypeEntity)a).collect(Collectors.toList());
			lst = playableCharacterTypesRepository.saveAll(lst);
			return StreamSupport.stream(lst.spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save playable character type", ex);
		}
	}

	@Override
	public void deletePlayableCharacterType(PlayableCharacterType playableCharacterType) {
		try {
			playableCharacterTypesRepository.delete((PlayableCharacterTypeEntity) playableCharacterType);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete playable character type", ex);
		}
	}

	@Override
	public void deletePlayableCharacterTypesByIds(List<Long> ids) {
		try {
			playableCharacterTypesRepository.deleteAllByIds(ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find playable character types", ex);
		}
	}

	@Override
	public List<PlayableCharacterType> findAllPlayableCharacterTypesByExample(PlayableCharacterType example) {
		try {
			return new ArrayList<>(playableCharacterTypesRepository.findAllByExample(example.getUniqueCharacterTypeName() , example.getGameObjectTypeId() ));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find playable character types", ex);
		}
	}

	@Override
	public PlayableCharacterType findPlayableCharacterTypeByUniqueCharacterTypeName(String uniqueCharacterTypeName) {
		try {
			return playableCharacterTypesRepository.findOneByUniqueCharacterTypeName(uniqueCharacterTypeName);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find playable character types", ex);
		}
	}

	@Override
	public List<PlayableCharacterType> findAllPlayableCharacterTypesByGameObjectTypeId(Long gameObjectTypeId) {
		try {
			return new ArrayList<>(playableCharacterTypesRepository.findAllByGameObjectTypeId(gameObjectTypeId));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find playable character types", ex);
		}
	}

	@Override
	public List<PlayableCharacterType> findAllPlayableCharacterTypesByGameObjectTypeIdAndIds(Long gameObjectTypeId, List<Long> ids) {
		try {
			return new ArrayList<>(playableCharacterTypesRepository.findAllByGameObjectTypeIdAndIds(gameObjectTypeId, ids));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find playable character types", ex);
		}
	}

	@Override
	public void deletePlayableCharacterTypesByGameObjectTypeId(Long gameObjectTypeId) {
		try {
			playableCharacterTypesRepository.deleteAllByGameObjectTypeId(gameObjectTypeId);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find playable character types", ex);
		}
	}

	@Override
	public void deletePlayableCharacterTypesByGameObjectTypeIdAndIds(Long gameObjectTypeId, List<Long> ids) {
		try {
			playableCharacterTypesRepository.deleteAllByGameObjectTypeIdAndIds(gameObjectTypeId, ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find playable character types", ex);
		}
	}


	public GameWorldSpawnPointType newGameWorldSpawnPointType() {
		return new GameWorldSpawnPointTypeEntity();
	}

	@Override
	public GameWorldSpawnPointType newGameWorldSpawnPointType(Long id) {
		return new GameWorldSpawnPointTypeEntity(id);
	}

	@Override
	public List<GameWorldSpawnPointType> findAllGameWorldSpawnPointTypes() {
		try {
			return StreamSupport.stream(gameWorldSpawnPointTypesRepository.findAll().spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game world spawn point types", ex);
		}
	}

	@Override
	public GameWorldSpawnPointType findGameWorldSpawnPointType(Long id) {
		try {
			return gameWorldSpawnPointTypesRepository.findById(id).orElse(null);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game world spawn point type", ex);
		}
	}

	@Override
	public GameWorldSpawnPointType saveGameWorldSpawnPointType(GameWorldSpawnPointType gameWorldSpawnPointType) {
		try {
			return gameWorldSpawnPointTypesRepository.save((GameWorldSpawnPointTypeEntity) gameWorldSpawnPointType);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game world spawn point type", ex);
		}
	}

	@Override
	public List<GameWorldSpawnPointType> saveGameWorldSpawnPointTypes(List<GameWorldSpawnPointType> gameWorldSpawnPointTypes) {
		try {
			Iterable<GameWorldSpawnPointTypeEntity> lst = gameWorldSpawnPointTypes.stream().map(a -> (GameWorldSpawnPointTypeEntity)a).collect(Collectors.toList());
			lst = gameWorldSpawnPointTypesRepository.saveAll(lst);
			return StreamSupport.stream(lst.spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game world spawn point type", ex);
		}
	}

	@Override
	public void deleteGameWorldSpawnPointType(GameWorldSpawnPointType gameWorldSpawnPointType) {
		try {
			gameWorldSpawnPointTypesRepository.delete((GameWorldSpawnPointTypeEntity) gameWorldSpawnPointType);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete game world spawn point type", ex);
		}
	}

	@Override
	public void deleteGameWorldSpawnPointTypesByIds(List<Long> ids) {
		try {
			gameWorldSpawnPointTypesRepository.deleteAllByIds(ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game world spawn point types", ex);
		}
	}

	@Override
	public List<GameWorldSpawnPointType> findAllGameWorldSpawnPointTypesByExample(GameWorldSpawnPointType example) {
		try {
			return new ArrayList<>(gameWorldSpawnPointTypesRepository.findAllByExample(example.getSpawnPointGameObjectTypeId() , example.getSpawnedGameObjectTypeId() ));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game world spawn point types", ex);
		}
	}

	@Override
	public List<GameWorldSpawnPointType> findAllGameWorldSpawnPointTypesBySpawnPointGameObjectTypeId(Long spawnPointGameObjectTypeId) {
		try {
			return new ArrayList<>(gameWorldSpawnPointTypesRepository.findAllBySpawnPointGameObjectTypeId(spawnPointGameObjectTypeId));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game world spawn point types", ex);
		}
	}

	@Override
	public List<GameWorldSpawnPointType> findAllGameWorldSpawnPointTypesBySpawnPointGameObjectTypeIdAndIds(Long spawnPointGameObjectTypeId, List<Long> ids) {
		try {
			return new ArrayList<>(gameWorldSpawnPointTypesRepository.findAllBySpawnPointGameObjectTypeIdAndIds(spawnPointGameObjectTypeId, ids));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game world spawn point types", ex);
		}
	}

	@Override
	public void deleteGameWorldSpawnPointTypesBySpawnPointGameObjectTypeId(Long spawnPointGameObjectTypeId) {
		try {
			gameWorldSpawnPointTypesRepository.deleteAllBySpawnPointGameObjectTypeId(spawnPointGameObjectTypeId);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game world spawn point types", ex);
		}
	}

	@Override
	public void deleteGameWorldSpawnPointTypesBySpawnPointGameObjectTypeIdAndIds(Long spawnPointGameObjectTypeId, List<Long> ids) {
		try {
			gameWorldSpawnPointTypesRepository.deleteAllBySpawnPointGameObjectTypeIdAndIds(spawnPointGameObjectTypeId, ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game world spawn point types", ex);
		}
	}

	@Override
	public List<GameWorldSpawnPointType> findAllGameWorldSpawnPointTypesBySpawnedGameObjectTypeId(Long spawnedGameObjectTypeId) {
		try {
			return new ArrayList<>(gameWorldSpawnPointTypesRepository.findAllBySpawnedGameObjectTypeId(spawnedGameObjectTypeId));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game world spawn point types", ex);
		}
	}

	@Override
	public List<GameWorldSpawnPointType> findAllGameWorldSpawnPointTypesBySpawnedGameObjectTypeIdAndIds(Long spawnedGameObjectTypeId, List<Long> ids) {
		try {
			return new ArrayList<>(gameWorldSpawnPointTypesRepository.findAllBySpawnedGameObjectTypeIdAndIds(spawnedGameObjectTypeId, ids));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game world spawn point types", ex);
		}
	}

	@Override
	public void deleteGameWorldSpawnPointTypesBySpawnedGameObjectTypeId(Long spawnedGameObjectTypeId) {
		try {
			gameWorldSpawnPointTypesRepository.deleteAllBySpawnedGameObjectTypeId(spawnedGameObjectTypeId);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game world spawn point types", ex);
		}
	}

	@Override
	public void deleteGameWorldSpawnPointTypesBySpawnedGameObjectTypeIdAndIds(Long spawnedGameObjectTypeId, List<Long> ids) {
		try {
			gameWorldSpawnPointTypesRepository.deleteAllBySpawnedGameObjectTypeIdAndIds(spawnedGameObjectTypeId, ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game world spawn point types", ex);
		}
	}


	public GameWorldCellType newGameWorldCellType() {
		return new GameWorldCellTypeEntity();
	}

	@Override
	public GameWorldCellType newGameWorldCellType(Long id) {
		return new GameWorldCellTypeEntity(id);
	}

	@Override
	public List<GameWorldCellType> findAllGameWorldCellTypes() {
		try {
			return StreamSupport.stream(gameWorldCellTypesRepository.findAll().spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game world cell types", ex);
		}
	}

	@Override
	public GameWorldCellType findGameWorldCellType(Long id) {
		try {
			return gameWorldCellTypesRepository.findById(id).orElse(null);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game world cell type", ex);
		}
	}

	@Override
	public GameWorldCellType saveGameWorldCellType(GameWorldCellType gameWorldCellType) {
		try {
			return gameWorldCellTypesRepository.save((GameWorldCellTypeEntity) gameWorldCellType);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game world cell type", ex);
		}
	}

	@Override
	public List<GameWorldCellType> saveGameWorldCellTypes(List<GameWorldCellType> gameWorldCellTypes) {
		try {
			Iterable<GameWorldCellTypeEntity> lst = gameWorldCellTypes.stream().map(a -> (GameWorldCellTypeEntity)a).collect(Collectors.toList());
			lst = gameWorldCellTypesRepository.saveAll(lst);
			return StreamSupport.stream(lst.spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game world cell type", ex);
		}
	}

	@Override
	public void deleteGameWorldCellType(GameWorldCellType gameWorldCellType) {
		try {
			gameWorldCellTypesRepository.delete((GameWorldCellTypeEntity) gameWorldCellType);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete game world cell type", ex);
		}
	}

	@Override
	public void deleteGameWorldCellTypesByIds(List<Long> ids) {
		try {
			gameWorldCellTypesRepository.deleteAllByIds(ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game world cell types", ex);
		}
	}

	@Override
	public List<GameWorldCellType> findAllGameWorldCellTypesByExample(GameWorldCellType example) {
		try {
			return new ArrayList<>(gameWorldCellTypesRepository.findAllByExample(example.getUniqueName() , example.getGameObjectTypeId() ));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game world cell types", ex);
		}
	}

	@Override
	public GameWorldCellType findGameWorldCellTypeByUniqueName(String uniqueName) {
		try {
			return gameWorldCellTypesRepository.findOneByUniqueName(uniqueName);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game world cell types", ex);
		}
	}

	@Override
	public List<GameWorldCellType> findAllGameWorldCellTypesByGameObjectTypeId(Long gameObjectTypeId) {
		try {
			return new ArrayList<>(gameWorldCellTypesRepository.findAllByGameObjectTypeId(gameObjectTypeId));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game world cell types", ex);
		}
	}

	@Override
	public List<GameWorldCellType> findAllGameWorldCellTypesByGameObjectTypeIdAndIds(Long gameObjectTypeId, List<Long> ids) {
		try {
			return new ArrayList<>(gameWorldCellTypesRepository.findAllByGameObjectTypeIdAndIds(gameObjectTypeId, ids));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game world cell types", ex);
		}
	}

	@Override
	public void deleteGameWorldCellTypesByGameObjectTypeId(Long gameObjectTypeId) {
		try {
			gameWorldCellTypesRepository.deleteAllByGameObjectTypeId(gameObjectTypeId);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game world cell types", ex);
		}
	}

	@Override
	public void deleteGameWorldCellTypesByGameObjectTypeIdAndIds(Long gameObjectTypeId, List<Long> ids) {
		try {
			gameWorldCellTypesRepository.deleteAllByGameObjectTypeIdAndIds(gameObjectTypeId, ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game world cell types", ex);
		}
	}


	public GameWorld newGameWorld() {
		return new GameWorldEntity();
	}

	@Override
	public GameWorld newGameWorld(Long id) {
		return new GameWorldEntity(id);
	}

	@Override
	public List<GameWorld> findAllGameWorlds() {
		try {
			return StreamSupport.stream(gameWorldsRepository.findAll().spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game worlds", ex);
		}
	}

	@Override
	public GameWorld findGameWorld(Long id) {
		try {
			return gameWorldsRepository.findById(id).orElse(null);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game world", ex);
		}
	}

	@Override
	public GameWorld saveGameWorld(GameWorld gameWorld) {
		try {
			return gameWorldsRepository.save((GameWorldEntity) gameWorld);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game world", ex);
		}
	}

	@Override
	public List<GameWorld> saveGameWorlds(List<GameWorld> gameWorlds) {
		try {
			Iterable<GameWorldEntity> lst = gameWorlds.stream().map(a -> (GameWorldEntity)a).collect(Collectors.toList());
			lst = gameWorldsRepository.saveAll(lst);
			return StreamSupport.stream(lst.spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game world", ex);
		}
	}

	@Override
	public void deleteGameWorld(GameWorld gameWorld) {
		try {
			gameWorldsRepository.delete((GameWorldEntity) gameWorld);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete game world", ex);
		}
	}

	@Override
	public void deleteGameWorldsByIds(List<Long> ids) {
		try {
			gameWorldsRepository.deleteAllByIds(ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game worlds", ex);
		}
	}

	@Override
	public List<GameWorld> findAllGameWorldsByExample(GameWorld example) {
		try {
			return new ArrayList<>(gameWorldsRepository.findAllByExample(example.getUniqueName() , example.getDescription() , example.getPictureRefPath() , example.getWidth() , example.getHeight() ));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game worlds", ex);
		}
	}

	@Override
	public GameWorld findGameWorldByUniqueName(String uniqueName) {
		try {
			return gameWorldsRepository.findOneByUniqueName(uniqueName);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game worlds", ex);
		}
	}


	public GameWorldCell newGameWorldCell() {
		return new GameWorldCellEntity();
	}

	@Override
	public GameWorldCell newGameWorldCell(Long id) {
		return new GameWorldCellEntity(id);
	}

	@Override
	public List<GameWorldCell> findAllGameWorldCells() {
		try {
			return StreamSupport.stream(gameWorldCellsRepository.findAll().spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game world cells", ex);
		}
	}

	@Override
	public GameWorldCell findGameWorldCell(Long id) {
		try {
			return gameWorldCellsRepository.findById(id).orElse(null);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game world cell", ex);
		}
	}

	@Override
	public GameWorldCell saveGameWorldCell(GameWorldCell gameWorldCell) {
		try {
			return gameWorldCellsRepository.save((GameWorldCellEntity) gameWorldCell);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game world cell", ex);
		}
	}

	@Override
	public List<GameWorldCell> saveGameWorldCells(List<GameWorldCell> gameWorldCells) {
		try {
			Iterable<GameWorldCellEntity> lst = gameWorldCells.stream().map(a -> (GameWorldCellEntity)a).collect(Collectors.toList());
			lst = gameWorldCellsRepository.saveAll(lst);
			return StreamSupport.stream(lst.spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game world cell", ex);
		}
	}

	@Override
	public void deleteGameWorldCell(GameWorldCell gameWorldCell) {
		try {
			gameWorldCellsRepository.delete((GameWorldCellEntity) gameWorldCell);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete game world cell", ex);
		}
	}

	@Override
	public void deleteGameWorldCellsByIds(List<Long> ids) {
		try {
			gameWorldCellsRepository.deleteAllByIds(ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game world cells", ex);
		}
	}

	@Override
	public List<GameWorldCell> findAllGameWorldCellsByExample(GameWorldCell example) {
		try {
			return new ArrayList<>(gameWorldCellsRepository.findAllByExample(example.getGameWorldId() , example.getGameWorldCellTypeId() , example.getXIndex() , example.getYIndex() , example.getAttachedGameWorldSpawnPointTypeId() ));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game world cells", ex);
		}
	}

	@Override
	public List<GameWorldCell> findAllGameWorldCellsByGameWorldId(Long gameWorldId) {
		try {
			return new ArrayList<>(gameWorldCellsRepository.findAllByGameWorldId(gameWorldId));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game world cells", ex);
		}
	}

	@Override
	public List<GameWorldCell> findAllGameWorldCellsByGameWorldIdAndIds(Long gameWorldId, List<Long> ids) {
		try {
			return new ArrayList<>(gameWorldCellsRepository.findAllByGameWorldIdAndIds(gameWorldId, ids));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game world cells", ex);
		}
	}

	@Override
	public void deleteGameWorldCellsByGameWorldId(Long gameWorldId) {
		try {
			gameWorldCellsRepository.deleteAllByGameWorldId(gameWorldId);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game world cells", ex);
		}
	}

	@Override
	public void deleteGameWorldCellsByGameWorldIdAndIds(Long gameWorldId, List<Long> ids) {
		try {
			gameWorldCellsRepository.deleteAllByGameWorldIdAndIds(gameWorldId, ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game world cells", ex);
		}
	}

	@Override
	public List<GameWorldCell> findAllGameWorldCellsByGameWorldCellTypeId(Long gameWorldCellTypeId) {
		try {
			return new ArrayList<>(gameWorldCellsRepository.findAllByGameWorldCellTypeId(gameWorldCellTypeId));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game world cells", ex);
		}
	}

	@Override
	public List<GameWorldCell> findAllGameWorldCellsByGameWorldCellTypeIdAndIds(Long gameWorldCellTypeId, List<Long> ids) {
		try {
			return new ArrayList<>(gameWorldCellsRepository.findAllByGameWorldCellTypeIdAndIds(gameWorldCellTypeId, ids));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game world cells", ex);
		}
	}

	@Override
	public void deleteGameWorldCellsByGameWorldCellTypeId(Long gameWorldCellTypeId) {
		try {
			gameWorldCellsRepository.deleteAllByGameWorldCellTypeId(gameWorldCellTypeId);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game world cells", ex);
		}
	}

	@Override
	public void deleteGameWorldCellsByGameWorldCellTypeIdAndIds(Long gameWorldCellTypeId, List<Long> ids) {
		try {
			gameWorldCellsRepository.deleteAllByGameWorldCellTypeIdAndIds(gameWorldCellTypeId, ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game world cells", ex);
		}
	}

	@Override
	public List<GameWorldCell> findAllGameWorldCellsByAttachedGameWorldSpawnPointTypeId(Long attachedGameWorldSpawnPointTypeId) {
		try {
			return new ArrayList<>(gameWorldCellsRepository.findAllByAttachedGameWorldSpawnPointTypeId(attachedGameWorldSpawnPointTypeId));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game world cells", ex);
		}
	}

	@Override
	public List<GameWorldCell> findAllGameWorldCellsByAttachedGameWorldSpawnPointTypeIdAndIds(Long attachedGameWorldSpawnPointTypeId, List<Long> ids) {
		try {
			return new ArrayList<>(gameWorldCellsRepository.findAllByAttachedGameWorldSpawnPointTypeIdAndIds(attachedGameWorldSpawnPointTypeId, ids));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game world cells", ex);
		}
	}

	@Override
	public void deleteGameWorldCellsByAttachedGameWorldSpawnPointTypeId(Long attachedGameWorldSpawnPointTypeId) {
		try {
			gameWorldCellsRepository.deleteAllByAttachedGameWorldSpawnPointTypeId(attachedGameWorldSpawnPointTypeId);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game world cells", ex);
		}
	}

	@Override
	public void deleteGameWorldCellsByAttachedGameWorldSpawnPointTypeIdAndIds(Long attachedGameWorldSpawnPointTypeId, List<Long> ids) {
		try {
			gameWorldCellsRepository.deleteAllByAttachedGameWorldSpawnPointTypeIdAndIds(attachedGameWorldSpawnPointTypeId, ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game world cells", ex);
		}
	}

	@Override
	public List<GameWorldCell> findAllGameWorldCellsHavingTargetSmallnumberBetweenXIndexAndYIndex(Integer targetSmallnumber) {
		try {
			return new ArrayList<>(gameWorldCellsRepository.findAllHavingTargetSmallnumberBetweenXIndexAndYIndex(targetSmallnumber));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game world cells", ex);
		}
	}


	public GameWorldCellProperty newGameWorldCellProperty() {
		return new GameWorldCellPropertyEntity();
	}

	@Override
	public GameWorldCellProperty newGameWorldCellProperty(Long id) {
		return new GameWorldCellPropertyEntity(id);
	}

	@Override
	public List<GameWorldCellProperty> findAllGameWorldCellProperties() {
		try {
			return StreamSupport.stream(gameWorldCellPropertiesRepository.findAll().spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game world cell properties", ex);
		}
	}

	@Override
	public GameWorldCellProperty findGameWorldCellProperty(Long id) {
		try {
			return gameWorldCellPropertiesRepository.findById(id).orElse(null);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game world cell property", ex);
		}
	}

	@Override
	public GameWorldCellProperty saveGameWorldCellProperty(GameWorldCellProperty gameWorldCellProperty) {
		try {
			return gameWorldCellPropertiesRepository.save((GameWorldCellPropertyEntity) gameWorldCellProperty);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game world cell property", ex);
		}
	}

	@Override
	public List<GameWorldCellProperty> saveGameWorldCellProperties(List<GameWorldCellProperty> gameWorldCellProperties) {
		try {
			Iterable<GameWorldCellPropertyEntity> lst = gameWorldCellProperties.stream().map(a -> (GameWorldCellPropertyEntity)a).collect(Collectors.toList());
			lst = gameWorldCellPropertiesRepository.saveAll(lst);
			return StreamSupport.stream(lst.spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game world cell property", ex);
		}
	}

	@Override
	public void deleteGameWorldCellProperty(GameWorldCellProperty gameWorldCellProperty) {
		try {
			gameWorldCellPropertiesRepository.delete((GameWorldCellPropertyEntity) gameWorldCellProperty);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete game world cell property", ex);
		}
	}

	@Override
	public void deleteGameWorldCellPropertiesByIds(List<Long> ids) {
		try {
			gameWorldCellPropertiesRepository.deleteAllByIds(ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game world cell properties", ex);
		}
	}

	@Override
	public List<GameWorldCellProperty> findAllGameWorldCellPropertiesByExample(GameWorldCellProperty example) {
		try {
			return new ArrayList<>(gameWorldCellPropertiesRepository.findAllByExample(example.getGameWorldCellId() , example.getGameObjectTypePropertyId() , example.getPropertyActualValue() ));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game world cell properties", ex);
		}
	}

	@Override
	public List<GameWorldCellProperty> findAllGameWorldCellPropertiesByGameWorldCellId(Long gameWorldCellId) {
		try {
			return new ArrayList<>(gameWorldCellPropertiesRepository.findAllByGameWorldCellId(gameWorldCellId));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game world cell properties", ex);
		}
	}

	@Override
	public List<GameWorldCellProperty> findAllGameWorldCellPropertiesByGameWorldCellIdAndIds(Long gameWorldCellId, List<Long> ids) {
		try {
			return new ArrayList<>(gameWorldCellPropertiesRepository.findAllByGameWorldCellIdAndIds(gameWorldCellId, ids));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game world cell properties", ex);
		}
	}

	@Override
	public void deleteGameWorldCellPropertiesByGameWorldCellId(Long gameWorldCellId) {
		try {
			gameWorldCellPropertiesRepository.deleteAllByGameWorldCellId(gameWorldCellId);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game world cell properties", ex);
		}
	}

	@Override
	public void deleteGameWorldCellPropertiesByGameWorldCellIdAndIds(Long gameWorldCellId, List<Long> ids) {
		try {
			gameWorldCellPropertiesRepository.deleteAllByGameWorldCellIdAndIds(gameWorldCellId, ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game world cell properties", ex);
		}
	}

	@Override
	public List<GameWorldCellProperty> findAllGameWorldCellPropertiesByGameObjectTypePropertyId(Long gameObjectTypePropertyId) {
		try {
			return new ArrayList<>(gameWorldCellPropertiesRepository.findAllByGameObjectTypePropertyId(gameObjectTypePropertyId));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game world cell properties", ex);
		}
	}

	@Override
	public List<GameWorldCellProperty> findAllGameWorldCellPropertiesByGameObjectTypePropertyIdAndIds(Long gameObjectTypePropertyId, List<Long> ids) {
		try {
			return new ArrayList<>(gameWorldCellPropertiesRepository.findAllByGameObjectTypePropertyIdAndIds(gameObjectTypePropertyId, ids));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game world cell properties", ex);
		}
	}

	@Override
	public void deleteGameWorldCellPropertiesByGameObjectTypePropertyId(Long gameObjectTypePropertyId) {
		try {
			gameWorldCellPropertiesRepository.deleteAllByGameObjectTypePropertyId(gameObjectTypePropertyId);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game world cell properties", ex);
		}
	}

	@Override
	public void deleteGameWorldCellPropertiesByGameObjectTypePropertyIdAndIds(Long gameObjectTypePropertyId, List<Long> ids) {
		try {
			gameWorldCellPropertiesRepository.deleteAllByGameObjectTypePropertyIdAndIds(gameObjectTypePropertyId, ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game world cell properties", ex);
		}
	}


	public AutomationObjectProvider newAutomationObjectProvider() {
		return new AutomationObjectProviderEntity();
	}

	@Override
	public AutomationObjectProvider newAutomationObjectProvider(Long id) {
		return new AutomationObjectProviderEntity(id);
	}

	@Override
	public List<AutomationObjectProvider> findAllAutomationObjectProviders() {
		try {
			return StreamSupport.stream(automationObjectProvidersRepository.findAll().spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve automation object providers", ex);
		}
	}

	@Override
	public AutomationObjectProvider findAutomationObjectProvider(Long id) {
		try {
			return automationObjectProvidersRepository.findById(id).orElse(null);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve automation object provider", ex);
		}
	}

	@Override
	public AutomationObjectProvider saveAutomationObjectProvider(AutomationObjectProvider automationObjectProvider) {
		try {
			return automationObjectProvidersRepository.save((AutomationObjectProviderEntity) automationObjectProvider);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save automation object provider", ex);
		}
	}

	@Override
	public List<AutomationObjectProvider> saveAutomationObjectProviders(List<AutomationObjectProvider> automationObjectProviders) {
		try {
			Iterable<AutomationObjectProviderEntity> lst = automationObjectProviders.stream().map(a -> (AutomationObjectProviderEntity)a).collect(Collectors.toList());
			lst = automationObjectProvidersRepository.saveAll(lst);
			return StreamSupport.stream(lst.spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save automation object provider", ex);
		}
	}

	@Override
	public void deleteAutomationObjectProvider(AutomationObjectProvider automationObjectProvider) {
		try {
			automationObjectProvidersRepository.delete((AutomationObjectProviderEntity) automationObjectProvider);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete automation object provider", ex);
		}
	}

	@Override
	public void deleteAutomationObjectProvidersByIds(List<Long> ids) {
		try {
			automationObjectProvidersRepository.deleteAllByIds(ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find automation object providers", ex);
		}
	}

	@Override
	public List<AutomationObjectProvider> findAllAutomationObjectProvidersByExample(AutomationObjectProvider example) {
		try {
			return new ArrayList<>(automationObjectProvidersRepository.findAllByExample(example.getName() ));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find automation object providers", ex);
		}
	}

	@Override
	public AutomationObjectProvider findAutomationObjectProviderByName(String name) {
		try {
			return automationObjectProvidersRepository.findOneByName(name);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find automation object providers", ex);
		}
	}


	public GameObjectTypeAutomation newGameObjectTypeAutomation() {
		return new GameObjectTypeAutomationEntity();
	}

	@Override
	public GameObjectTypeAutomation newGameObjectTypeAutomation(Long id) {
		return new GameObjectTypeAutomationEntity(id);
	}

	@Override
	public List<GameObjectTypeAutomation> findAllGameObjectTypeAutomations() {
		try {
			return StreamSupport.stream(gameObjectTypeAutomationsRepository.findAll().spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type automations", ex);
		}
	}

	@Override
	public GameObjectTypeAutomation findGameObjectTypeAutomation(Long id) {
		try {
			return gameObjectTypeAutomationsRepository.findById(id).orElse(null);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type automation", ex);
		}
	}

	@Override
	public GameObjectTypeAutomation saveGameObjectTypeAutomation(GameObjectTypeAutomation gameObjectTypeAutomation) {
		try {
			return gameObjectTypeAutomationsRepository.save((GameObjectTypeAutomationEntity) gameObjectTypeAutomation);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game object type automation", ex);
		}
	}

	@Override
	public List<GameObjectTypeAutomation> saveGameObjectTypeAutomations(List<GameObjectTypeAutomation> gameObjectTypeAutomations) {
		try {
			Iterable<GameObjectTypeAutomationEntity> lst = gameObjectTypeAutomations.stream().map(a -> (GameObjectTypeAutomationEntity)a).collect(Collectors.toList());
			lst = gameObjectTypeAutomationsRepository.saveAll(lst);
			return StreamSupport.stream(lst.spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game object type automation", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeAutomation(GameObjectTypeAutomation gameObjectTypeAutomation) {
		try {
			gameObjectTypeAutomationsRepository.delete((GameObjectTypeAutomationEntity) gameObjectTypeAutomation);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete game object type automation", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeAutomationsByIds(List<Long> ids) {
		try {
			gameObjectTypeAutomationsRepository.deleteAllByIds(ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type automations", ex);
		}
	}

	@Override
	public List<GameObjectTypeAutomation> findAllGameObjectTypeAutomationsByExample(GameObjectTypeAutomation example) {
		try {
			return new ArrayList<>(gameObjectTypeAutomationsRepository.findAllByExample(example.getGameObjectTypeId() , example.getAutomationObjectProviderId() ));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type automations", ex);
		}
	}

	@Override
	public List<GameObjectTypeAutomation> findAllGameObjectTypeAutomationsByGameObjectTypeId(Long gameObjectTypeId) {
		try {
			return new ArrayList<>(gameObjectTypeAutomationsRepository.findAllByGameObjectTypeId(gameObjectTypeId));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type automations", ex);
		}
	}

	@Override
	public List<GameObjectTypeAutomation> findAllGameObjectTypeAutomationsByGameObjectTypeIdAndIds(Long gameObjectTypeId, List<Long> ids) {
		try {
			return new ArrayList<>(gameObjectTypeAutomationsRepository.findAllByGameObjectTypeIdAndIds(gameObjectTypeId, ids));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type automations", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeAutomationsByGameObjectTypeId(Long gameObjectTypeId) {
		try {
			gameObjectTypeAutomationsRepository.deleteAllByGameObjectTypeId(gameObjectTypeId);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type automations", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeAutomationsByGameObjectTypeIdAndIds(Long gameObjectTypeId, List<Long> ids) {
		try {
			gameObjectTypeAutomationsRepository.deleteAllByGameObjectTypeIdAndIds(gameObjectTypeId, ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type automations", ex);
		}
	}

	@Override
	public List<GameObjectTypeAutomation> findAllGameObjectTypeAutomationsByAutomationObjectProviderId(Long automationObjectProviderId) {
		try {
			return new ArrayList<>(gameObjectTypeAutomationsRepository.findAllByAutomationObjectProviderId(automationObjectProviderId));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type automations", ex);
		}
	}

	@Override
	public List<GameObjectTypeAutomation> findAllGameObjectTypeAutomationsByAutomationObjectProviderIdAndIds(Long automationObjectProviderId, List<Long> ids) {
		try {
			return new ArrayList<>(gameObjectTypeAutomationsRepository.findAllByAutomationObjectProviderIdAndIds(automationObjectProviderId, ids));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type automations", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeAutomationsByAutomationObjectProviderId(Long automationObjectProviderId) {
		try {
			gameObjectTypeAutomationsRepository.deleteAllByAutomationObjectProviderId(automationObjectProviderId);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type automations", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeAutomationsByAutomationObjectProviderIdAndIds(Long automationObjectProviderId, List<Long> ids) {
		try {
			gameObjectTypeAutomationsRepository.deleteAllByAutomationObjectProviderIdAndIds(automationObjectProviderId, ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type automations", ex);
		}
	}


	public Action newAction() {
		return new ActionEntity();
	}

	@Override
	public Action newAction(Long id) {
		return new ActionEntity(id);
	}

	@Override
	public List<Action> findAllActions() {
		try {
			return StreamSupport.stream(actionsRepository.findAll().spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve actions", ex);
		}
	}

	@Override
	public Action findAction(Long id) {
		try {
			return actionsRepository.findById(id).orElse(null);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve action", ex);
		}
	}

	@Override
	public Action saveAction(Action action) {
		try {
			return actionsRepository.save((ActionEntity) action);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save action", ex);
		}
	}

	@Override
	public List<Action> saveActions(List<Action> actions) {
		try {
			Iterable<ActionEntity> lst = actions.stream().map(a -> (ActionEntity)a).collect(Collectors.toList());
			lst = actionsRepository.saveAll(lst);
			return StreamSupport.stream(lst.spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save action", ex);
		}
	}

	@Override
	public void deleteAction(Action action) {
		try {
			actionsRepository.delete((ActionEntity) action);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete action", ex);
		}
	}

	@Override
	public void deleteActionsByIds(List<Long> ids) {
		try {
			actionsRepository.deleteAllByIds(ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find actions", ex);
		}
	}

	@Override
	public List<Action> findAllActionsByExample(Action example) {
		try {
			return new ArrayList<>(actionsRepository.findAllByExample(example.getUniqueName() ));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find actions", ex);
		}
	}

	@Override
	public Action findActionByUniqueName(String uniqueName) {
		try {
			return actionsRepository.findOneByUniqueName(uniqueName);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find actions", ex);
		}
	}


	public GameObjectTypeStateTransition newGameObjectTypeStateTransition() {
		return new GameObjectTypeStateTransitionEntity();
	}

	@Override
	public GameObjectTypeStateTransition newGameObjectTypeStateTransition(Long id) {
		return new GameObjectTypeStateTransitionEntity(id);
	}

	@Override
	public List<GameObjectTypeStateTransition> findAllGameObjectTypeStateTransitions() {
		try {
			return StreamSupport.stream(gameObjectTypeStateTransitionsRepository.findAll().spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type state transitions", ex);
		}
	}

	@Override
	public GameObjectTypeStateTransition findGameObjectTypeStateTransition(Long id) {
		try {
			return gameObjectTypeStateTransitionsRepository.findById(id).orElse(null);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type state transition", ex);
		}
	}

	@Override
	public GameObjectTypeStateTransition saveGameObjectTypeStateTransition(GameObjectTypeStateTransition gameObjectTypeStateTransition) {
		try {
			return gameObjectTypeStateTransitionsRepository.save((GameObjectTypeStateTransitionEntity) gameObjectTypeStateTransition);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game object type state transition", ex);
		}
	}

	@Override
	public List<GameObjectTypeStateTransition> saveGameObjectTypeStateTransitions(List<GameObjectTypeStateTransition> gameObjectTypeStateTransitions) {
		try {
			Iterable<GameObjectTypeStateTransitionEntity> lst = gameObjectTypeStateTransitions.stream().map(a -> (GameObjectTypeStateTransitionEntity)a).collect(Collectors.toList());
			lst = gameObjectTypeStateTransitionsRepository.saveAll(lst);
			return StreamSupport.stream(lst.spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game object type state transition", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeStateTransition(GameObjectTypeStateTransition gameObjectTypeStateTransition) {
		try {
			gameObjectTypeStateTransitionsRepository.delete((GameObjectTypeStateTransitionEntity) gameObjectTypeStateTransition);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete game object type state transition", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeStateTransitionsByIds(List<Long> ids) {
		try {
			gameObjectTypeStateTransitionsRepository.deleteAllByIds(ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type state transitions", ex);
		}
	}

	@Override
	public List<GameObjectTypeStateTransition> findAllGameObjectTypeStateTransitionsByExample(GameObjectTypeStateTransition example) {
		try {
			return new ArrayList<>(gameObjectTypeStateTransitionsRepository.findAllByExample(example.getSourceGameObjectTypeStateId() , example.getTargetGameObjectTypeStateId() , example.getIsAutomatic() , example.getTriggerActionId() ));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type state transitions", ex);
		}
	}

	@Override
	public List<GameObjectTypeStateTransition> findAllGameObjectTypeStateTransitionsBySourceGameObjectTypeStateId(Long sourceGameObjectTypeStateId) {
		try {
			return new ArrayList<>(gameObjectTypeStateTransitionsRepository.findAllBySourceGameObjectTypeStateId(sourceGameObjectTypeStateId));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type state transitions", ex);
		}
	}

	@Override
	public List<GameObjectTypeStateTransition> findAllGameObjectTypeStateTransitionsBySourceGameObjectTypeStateIdAndIds(Long sourceGameObjectTypeStateId, List<Long> ids) {
		try {
			return new ArrayList<>(gameObjectTypeStateTransitionsRepository.findAllBySourceGameObjectTypeStateIdAndIds(sourceGameObjectTypeStateId, ids));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type state transitions", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeStateTransitionsBySourceGameObjectTypeStateId(Long sourceGameObjectTypeStateId) {
		try {
			gameObjectTypeStateTransitionsRepository.deleteAllBySourceGameObjectTypeStateId(sourceGameObjectTypeStateId);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type state transitions", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeStateTransitionsBySourceGameObjectTypeStateIdAndIds(Long sourceGameObjectTypeStateId, List<Long> ids) {
		try {
			gameObjectTypeStateTransitionsRepository.deleteAllBySourceGameObjectTypeStateIdAndIds(sourceGameObjectTypeStateId, ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type state transitions", ex);
		}
	}

	@Override
	public List<GameObjectTypeStateTransition> findAllGameObjectTypeStateTransitionsByTargetGameObjectTypeStateId(Long targetGameObjectTypeStateId) {
		try {
			return new ArrayList<>(gameObjectTypeStateTransitionsRepository.findAllByTargetGameObjectTypeStateId(targetGameObjectTypeStateId));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type state transitions", ex);
		}
	}

	@Override
	public List<GameObjectTypeStateTransition> findAllGameObjectTypeStateTransitionsByTargetGameObjectTypeStateIdAndIds(Long targetGameObjectTypeStateId, List<Long> ids) {
		try {
			return new ArrayList<>(gameObjectTypeStateTransitionsRepository.findAllByTargetGameObjectTypeStateIdAndIds(targetGameObjectTypeStateId, ids));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type state transitions", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeStateTransitionsByTargetGameObjectTypeStateId(Long targetGameObjectTypeStateId) {
		try {
			gameObjectTypeStateTransitionsRepository.deleteAllByTargetGameObjectTypeStateId(targetGameObjectTypeStateId);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type state transitions", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeStateTransitionsByTargetGameObjectTypeStateIdAndIds(Long targetGameObjectTypeStateId, List<Long> ids) {
		try {
			gameObjectTypeStateTransitionsRepository.deleteAllByTargetGameObjectTypeStateIdAndIds(targetGameObjectTypeStateId, ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type state transitions", ex);
		}
	}

	@Override
	public List<GameObjectTypeStateTransition> findAllGameObjectTypeStateTransitionsByTriggerActionId(Long triggerActionId) {
		try {
			return new ArrayList<>(gameObjectTypeStateTransitionsRepository.findAllByTriggerActionId(triggerActionId));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type state transitions", ex);
		}
	}

	@Override
	public List<GameObjectTypeStateTransition> findAllGameObjectTypeStateTransitionsByTriggerActionIdAndIds(Long triggerActionId, List<Long> ids) {
		try {
			return new ArrayList<>(gameObjectTypeStateTransitionsRepository.findAllByTriggerActionIdAndIds(triggerActionId, ids));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type state transitions", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeStateTransitionsByTriggerActionId(Long triggerActionId) {
		try {
			gameObjectTypeStateTransitionsRepository.deleteAllByTriggerActionId(triggerActionId);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type state transitions", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeStateTransitionsByTriggerActionIdAndIds(Long triggerActionId, List<Long> ids) {
		try {
			gameObjectTypeStateTransitionsRepository.deleteAllByTriggerActionIdAndIds(triggerActionId, ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type state transitions", ex);
		}
	}


	public GameObjectTypeAllowedAddonType newGameObjectTypeAllowedAddonType() {
		return new GameObjectTypeAllowedAddonTypeEntity();
	}

	@Override
	public GameObjectTypeAllowedAddonType newGameObjectTypeAllowedAddonType(Long id) {
		return new GameObjectTypeAllowedAddonTypeEntity(id);
	}

	@Override
	public List<GameObjectTypeAllowedAddonType> findAllGameObjectTypeAllowedAddonTypes() {
		try {
			return StreamSupport.stream(gameObjectTypeAllowedAddonTypesRepository.findAll().spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type allowed addon types", ex);
		}
	}

	@Override
	public GameObjectTypeAllowedAddonType findGameObjectTypeAllowedAddonType(Long id) {
		try {
			return gameObjectTypeAllowedAddonTypesRepository.findById(id).orElse(null);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type allowed addon type", ex);
		}
	}

	@Override
	public GameObjectTypeAllowedAddonType saveGameObjectTypeAllowedAddonType(GameObjectTypeAllowedAddonType gameObjectTypeAllowedAddonType) {
		try {
			return gameObjectTypeAllowedAddonTypesRepository.save((GameObjectTypeAllowedAddonTypeEntity) gameObjectTypeAllowedAddonType);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game object type allowed addon type", ex);
		}
	}

	@Override
	public List<GameObjectTypeAllowedAddonType> saveGameObjectTypeAllowedAddonTypes(List<GameObjectTypeAllowedAddonType> gameObjectTypeAllowedAddonTypes) {
		try {
			Iterable<GameObjectTypeAllowedAddonTypeEntity> lst = gameObjectTypeAllowedAddonTypes.stream().map(a -> (GameObjectTypeAllowedAddonTypeEntity)a).collect(Collectors.toList());
			lst = gameObjectTypeAllowedAddonTypesRepository.saveAll(lst);
			return StreamSupport.stream(lst.spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game object type allowed addon type", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeAllowedAddonType(GameObjectTypeAllowedAddonType gameObjectTypeAllowedAddonType) {
		try {
			gameObjectTypeAllowedAddonTypesRepository.delete((GameObjectTypeAllowedAddonTypeEntity) gameObjectTypeAllowedAddonType);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete game object type allowed addon type", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeAllowedAddonTypesByIds(List<Long> ids) {
		try {
			gameObjectTypeAllowedAddonTypesRepository.deleteAllByIds(ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type allowed addon types", ex);
		}
	}

	@Override
	public List<GameObjectTypeAllowedAddonType> findAllGameObjectTypeAllowedAddonTypesByExample(GameObjectTypeAllowedAddonType example) {
		try {
			return new ArrayList<>(gameObjectTypeAllowedAddonTypesRepository.findAllByExample(example.getUniqueName() , example.getAddonGameObjectTypeId() , example.getApplicableToGameObjectTypeId() , example.getIsEquipedByDefault() , example.getIsIncremental() , example.getIsTriggered() , example.getTriggerActionId() , example.getIsSpawning() , example.getSpawnableGameObjectTypeId() , example.getHasLimitedDuration() , example.getDuration() ));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type allowed addon types", ex);
		}
	}

	@Override
	public GameObjectTypeAllowedAddonType findGameObjectTypeAllowedAddonTypeByUniqueName(String uniqueName) {
		try {
			return gameObjectTypeAllowedAddonTypesRepository.findOneByUniqueName(uniqueName);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type allowed addon types", ex);
		}
	}

	@Override
	public List<GameObjectTypeAllowedAddonType> findAllGameObjectTypeAllowedAddonTypesByAddonGameObjectTypeId(Long addonGameObjectTypeId) {
		try {
			return new ArrayList<>(gameObjectTypeAllowedAddonTypesRepository.findAllByAddonGameObjectTypeId(addonGameObjectTypeId));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type allowed addon types", ex);
		}
	}

	@Override
	public List<GameObjectTypeAllowedAddonType> findAllGameObjectTypeAllowedAddonTypesByAddonGameObjectTypeIdAndIds(Long addonGameObjectTypeId, List<Long> ids) {
		try {
			return new ArrayList<>(gameObjectTypeAllowedAddonTypesRepository.findAllByAddonGameObjectTypeIdAndIds(addonGameObjectTypeId, ids));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type allowed addon types", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeAllowedAddonTypesByAddonGameObjectTypeId(Long addonGameObjectTypeId) {
		try {
			gameObjectTypeAllowedAddonTypesRepository.deleteAllByAddonGameObjectTypeId(addonGameObjectTypeId);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type allowed addon types", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeAllowedAddonTypesByAddonGameObjectTypeIdAndIds(Long addonGameObjectTypeId, List<Long> ids) {
		try {
			gameObjectTypeAllowedAddonTypesRepository.deleteAllByAddonGameObjectTypeIdAndIds(addonGameObjectTypeId, ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type allowed addon types", ex);
		}
	}

	@Override
	public List<GameObjectTypeAllowedAddonType> findAllGameObjectTypeAllowedAddonTypesByApplicableToGameObjectTypeId(Long applicableToGameObjectTypeId) {
		try {
			return new ArrayList<>(gameObjectTypeAllowedAddonTypesRepository.findAllByApplicableToGameObjectTypeId(applicableToGameObjectTypeId));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type allowed addon types", ex);
		}
	}

	@Override
	public List<GameObjectTypeAllowedAddonType> findAllGameObjectTypeAllowedAddonTypesByApplicableToGameObjectTypeIdAndIds(Long applicableToGameObjectTypeId, List<Long> ids) {
		try {
			return new ArrayList<>(gameObjectTypeAllowedAddonTypesRepository.findAllByApplicableToGameObjectTypeIdAndIds(applicableToGameObjectTypeId, ids));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type allowed addon types", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeAllowedAddonTypesByApplicableToGameObjectTypeId(Long applicableToGameObjectTypeId) {
		try {
			gameObjectTypeAllowedAddonTypesRepository.deleteAllByApplicableToGameObjectTypeId(applicableToGameObjectTypeId);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type allowed addon types", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeAllowedAddonTypesByApplicableToGameObjectTypeIdAndIds(Long applicableToGameObjectTypeId, List<Long> ids) {
		try {
			gameObjectTypeAllowedAddonTypesRepository.deleteAllByApplicableToGameObjectTypeIdAndIds(applicableToGameObjectTypeId, ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type allowed addon types", ex);
		}
	}

	@Override
	public List<GameObjectTypeAllowedAddonType> findAllGameObjectTypeAllowedAddonTypesByTriggerActionId(Long triggerActionId) {
		try {
			return new ArrayList<>(gameObjectTypeAllowedAddonTypesRepository.findAllByTriggerActionId(triggerActionId));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type allowed addon types", ex);
		}
	}

	@Override
	public List<GameObjectTypeAllowedAddonType> findAllGameObjectTypeAllowedAddonTypesByTriggerActionIdAndIds(Long triggerActionId, List<Long> ids) {
		try {
			return new ArrayList<>(gameObjectTypeAllowedAddonTypesRepository.findAllByTriggerActionIdAndIds(triggerActionId, ids));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type allowed addon types", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeAllowedAddonTypesByTriggerActionId(Long triggerActionId) {
		try {
			gameObjectTypeAllowedAddonTypesRepository.deleteAllByTriggerActionId(triggerActionId);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type allowed addon types", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeAllowedAddonTypesByTriggerActionIdAndIds(Long triggerActionId, List<Long> ids) {
		try {
			gameObjectTypeAllowedAddonTypesRepository.deleteAllByTriggerActionIdAndIds(triggerActionId, ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type allowed addon types", ex);
		}
	}

	@Override
	public List<GameObjectTypeAllowedAddonType> findAllGameObjectTypeAllowedAddonTypesBySpawnableGameObjectTypeId(Long spawnableGameObjectTypeId) {
		try {
			return new ArrayList<>(gameObjectTypeAllowedAddonTypesRepository.findAllBySpawnableGameObjectTypeId(spawnableGameObjectTypeId));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type allowed addon types", ex);
		}
	}

	@Override
	public List<GameObjectTypeAllowedAddonType> findAllGameObjectTypeAllowedAddonTypesBySpawnableGameObjectTypeIdAndIds(Long spawnableGameObjectTypeId, List<Long> ids) {
		try {
			return new ArrayList<>(gameObjectTypeAllowedAddonTypesRepository.findAllBySpawnableGameObjectTypeIdAndIds(spawnableGameObjectTypeId, ids));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type allowed addon types", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeAllowedAddonTypesBySpawnableGameObjectTypeId(Long spawnableGameObjectTypeId) {
		try {
			gameObjectTypeAllowedAddonTypesRepository.deleteAllBySpawnableGameObjectTypeId(spawnableGameObjectTypeId);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type allowed addon types", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeAllowedAddonTypesBySpawnableGameObjectTypeIdAndIds(Long spawnableGameObjectTypeId, List<Long> ids) {
		try {
			gameObjectTypeAllowedAddonTypesRepository.deleteAllBySpawnableGameObjectTypeIdAndIds(spawnableGameObjectTypeId, ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type allowed addon types", ex);
		}
	}


	public GameAddonInteractionReceivingPropertyModifier newGameAddonInteractionReceivingPropertyModifier() {
		return new GameAddonInteractionReceivingPropertyModifierEntity();
	}

	@Override
	public GameAddonInteractionReceivingPropertyModifier newGameAddonInteractionReceivingPropertyModifier(Long id) {
		return new GameAddonInteractionReceivingPropertyModifierEntity(id);
	}

	@Override
	public List<GameAddonInteractionReceivingPropertyModifier> findAllGameAddonInteractionReceivingPropertyModifiers() {
		try {
			return StreamSupport.stream(gameAddonInteractionReceivingPropertyModifiersRepository.findAll().spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game addon interaction receiving property modifiers", ex);
		}
	}

	@Override
	public GameAddonInteractionReceivingPropertyModifier findGameAddonInteractionReceivingPropertyModifier(Long id) {
		try {
			return gameAddonInteractionReceivingPropertyModifiersRepository.findById(id).orElse(null);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game addon interaction receiving property modifier", ex);
		}
	}

	@Override
	public GameAddonInteractionReceivingPropertyModifier saveGameAddonInteractionReceivingPropertyModifier(GameAddonInteractionReceivingPropertyModifier gameAddonInteractionReceivingPropertyModifier) {
		try {
			return gameAddonInteractionReceivingPropertyModifiersRepository.save((GameAddonInteractionReceivingPropertyModifierEntity) gameAddonInteractionReceivingPropertyModifier);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game addon interaction receiving property modifier", ex);
		}
	}

	@Override
	public List<GameAddonInteractionReceivingPropertyModifier> saveGameAddonInteractionReceivingPropertyModifiers(List<GameAddonInteractionReceivingPropertyModifier> gameAddonInteractionReceivingPropertyModifiers) {
		try {
			Iterable<GameAddonInteractionReceivingPropertyModifierEntity> lst = gameAddonInteractionReceivingPropertyModifiers.stream().map(a -> (GameAddonInteractionReceivingPropertyModifierEntity)a).collect(Collectors.toList());
			lst = gameAddonInteractionReceivingPropertyModifiersRepository.saveAll(lst);
			return StreamSupport.stream(lst.spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game addon interaction receiving property modifier", ex);
		}
	}

	@Override
	public void deleteGameAddonInteractionReceivingPropertyModifier(GameAddonInteractionReceivingPropertyModifier gameAddonInteractionReceivingPropertyModifier) {
		try {
			gameAddonInteractionReceivingPropertyModifiersRepository.delete((GameAddonInteractionReceivingPropertyModifierEntity) gameAddonInteractionReceivingPropertyModifier);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete game addon interaction receiving property modifier", ex);
		}
	}

	@Override
	public void deleteGameAddonInteractionReceivingPropertyModifiersByIds(List<Long> ids) {
		try {
			gameAddonInteractionReceivingPropertyModifiersRepository.deleteAllByIds(ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game addon interaction receiving property modifiers", ex);
		}
	}

	@Override
	public List<GameAddonInteractionReceivingPropertyModifier> findAllGameAddonInteractionReceivingPropertyModifiersByExample(GameAddonInteractionReceivingPropertyModifier example) {
		try {
			return new ArrayList<>(gameAddonInteractionReceivingPropertyModifiersRepository.findAllByExample(example.getGameObjectTypeAllowedAddonTypeId() , example.getAffectedGameObjectTypePropertyId() , example.getAppliedPropertyValueMultiplier() ));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game addon interaction receiving property modifiers", ex);
		}
	}

	@Override
	public List<GameAddonInteractionReceivingPropertyModifier> findAllGameAddonInteractionReceivingPropertyModifiersByGameObjectTypeAllowedAddonTypeId(Long gameObjectTypeAllowedAddonTypeId) {
		try {
			return new ArrayList<>(gameAddonInteractionReceivingPropertyModifiersRepository.findAllByGameObjectTypeAllowedAddonTypeId(gameObjectTypeAllowedAddonTypeId));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game addon interaction receiving property modifiers", ex);
		}
	}

	@Override
	public List<GameAddonInteractionReceivingPropertyModifier> findAllGameAddonInteractionReceivingPropertyModifiersByGameObjectTypeAllowedAddonTypeIdAndIds(Long gameObjectTypeAllowedAddonTypeId, List<Long> ids) {
		try {
			return new ArrayList<>(gameAddonInteractionReceivingPropertyModifiersRepository.findAllByGameObjectTypeAllowedAddonTypeIdAndIds(gameObjectTypeAllowedAddonTypeId, ids));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game addon interaction receiving property modifiers", ex);
		}
	}

	@Override
	public void deleteGameAddonInteractionReceivingPropertyModifiersByGameObjectTypeAllowedAddonTypeId(Long gameObjectTypeAllowedAddonTypeId) {
		try {
			gameAddonInteractionReceivingPropertyModifiersRepository.deleteAllByGameObjectTypeAllowedAddonTypeId(gameObjectTypeAllowedAddonTypeId);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game addon interaction receiving property modifiers", ex);
		}
	}

	@Override
	public void deleteGameAddonInteractionReceivingPropertyModifiersByGameObjectTypeAllowedAddonTypeIdAndIds(Long gameObjectTypeAllowedAddonTypeId, List<Long> ids) {
		try {
			gameAddonInteractionReceivingPropertyModifiersRepository.deleteAllByGameObjectTypeAllowedAddonTypeIdAndIds(gameObjectTypeAllowedAddonTypeId, ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game addon interaction receiving property modifiers", ex);
		}
	}

	@Override
	public List<GameAddonInteractionReceivingPropertyModifier> findAllGameAddonInteractionReceivingPropertyModifiersByAffectedGameObjectTypePropertyId(Long affectedGameObjectTypePropertyId) {
		try {
			return new ArrayList<>(gameAddonInteractionReceivingPropertyModifiersRepository.findAllByAffectedGameObjectTypePropertyId(affectedGameObjectTypePropertyId));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game addon interaction receiving property modifiers", ex);
		}
	}

	@Override
	public List<GameAddonInteractionReceivingPropertyModifier> findAllGameAddonInteractionReceivingPropertyModifiersByAffectedGameObjectTypePropertyIdAndIds(Long affectedGameObjectTypePropertyId, List<Long> ids) {
		try {
			return new ArrayList<>(gameAddonInteractionReceivingPropertyModifiersRepository.findAllByAffectedGameObjectTypePropertyIdAndIds(affectedGameObjectTypePropertyId, ids));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game addon interaction receiving property modifiers", ex);
		}
	}

	@Override
	public void deleteGameAddonInteractionReceivingPropertyModifiersByAffectedGameObjectTypePropertyId(Long affectedGameObjectTypePropertyId) {
		try {
			gameAddonInteractionReceivingPropertyModifiersRepository.deleteAllByAffectedGameObjectTypePropertyId(affectedGameObjectTypePropertyId);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game addon interaction receiving property modifiers", ex);
		}
	}

	@Override
	public void deleteGameAddonInteractionReceivingPropertyModifiersByAffectedGameObjectTypePropertyIdAndIds(Long affectedGameObjectTypePropertyId, List<Long> ids) {
		try {
			gameAddonInteractionReceivingPropertyModifiersRepository.deleteAllByAffectedGameObjectTypePropertyIdAndIds(affectedGameObjectTypePropertyId, ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game addon interaction receiving property modifiers", ex);
		}
	}


	public GameObjectTypeInteraction newGameObjectTypeInteraction() {
		return new GameObjectTypeInteractionEntity();
	}

	@Override
	public GameObjectTypeInteraction newGameObjectTypeInteraction(Long id) {
		return new GameObjectTypeInteractionEntity(id);
	}

	@Override
	public List<GameObjectTypeInteraction> findAllGameObjectTypeInteractions() {
		try {
			return StreamSupport.stream(gameObjectTypeInteractionsRepository.findAll().spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type interactions", ex);
		}
	}

	@Override
	public GameObjectTypeInteraction findGameObjectTypeInteraction(Long id) {
		try {
			return gameObjectTypeInteractionsRepository.findById(id).orElse(null);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type interaction", ex);
		}
	}

	@Override
	public GameObjectTypeInteraction saveGameObjectTypeInteraction(GameObjectTypeInteraction gameObjectTypeInteraction) {
		try {
			return gameObjectTypeInteractionsRepository.save((GameObjectTypeInteractionEntity) gameObjectTypeInteraction);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game object type interaction", ex);
		}
	}

	@Override
	public List<GameObjectTypeInteraction> saveGameObjectTypeInteractions(List<GameObjectTypeInteraction> gameObjectTypeInteractions) {
		try {
			Iterable<GameObjectTypeInteractionEntity> lst = gameObjectTypeInteractions.stream().map(a -> (GameObjectTypeInteractionEntity)a).collect(Collectors.toList());
			lst = gameObjectTypeInteractionsRepository.saveAll(lst);
			return StreamSupport.stream(lst.spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game object type interaction", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeInteraction(GameObjectTypeInteraction gameObjectTypeInteraction) {
		try {
			gameObjectTypeInteractionsRepository.delete((GameObjectTypeInteractionEntity) gameObjectTypeInteraction);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete game object type interaction", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeInteractionsByIds(List<Long> ids) {
		try {
			gameObjectTypeInteractionsRepository.deleteAllByIds(ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type interactions", ex);
		}
	}

	@Override
	public List<GameObjectTypeInteraction> findAllGameObjectTypeInteractionsByExample(GameObjectTypeInteraction example) {
		try {
			return new ArrayList<>(gameObjectTypeInteractionsRepository.findAllByExample(example.getDonatingGameObjectTypeId() , example.getReceivingGameObjectTypeId() , example.getRadius() ));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type interactions", ex);
		}
	}

	@Override
	public List<GameObjectTypeInteraction> findAllGameObjectTypeInteractionsByDonatingGameObjectTypeId(Long donatingGameObjectTypeId) {
		try {
			return new ArrayList<>(gameObjectTypeInteractionsRepository.findAllByDonatingGameObjectTypeId(donatingGameObjectTypeId));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type interactions", ex);
		}
	}

	@Override
	public List<GameObjectTypeInteraction> findAllGameObjectTypeInteractionsByDonatingGameObjectTypeIdAndIds(Long donatingGameObjectTypeId, List<Long> ids) {
		try {
			return new ArrayList<>(gameObjectTypeInteractionsRepository.findAllByDonatingGameObjectTypeIdAndIds(donatingGameObjectTypeId, ids));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type interactions", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeInteractionsByDonatingGameObjectTypeId(Long donatingGameObjectTypeId) {
		try {
			gameObjectTypeInteractionsRepository.deleteAllByDonatingGameObjectTypeId(donatingGameObjectTypeId);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type interactions", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeInteractionsByDonatingGameObjectTypeIdAndIds(Long donatingGameObjectTypeId, List<Long> ids) {
		try {
			gameObjectTypeInteractionsRepository.deleteAllByDonatingGameObjectTypeIdAndIds(donatingGameObjectTypeId, ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type interactions", ex);
		}
	}

	@Override
	public List<GameObjectTypeInteraction> findAllGameObjectTypeInteractionsByReceivingGameObjectTypeId(Long receivingGameObjectTypeId) {
		try {
			return new ArrayList<>(gameObjectTypeInteractionsRepository.findAllByReceivingGameObjectTypeId(receivingGameObjectTypeId));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type interactions", ex);
		}
	}

	@Override
	public List<GameObjectTypeInteraction> findAllGameObjectTypeInteractionsByReceivingGameObjectTypeIdAndIds(Long receivingGameObjectTypeId, List<Long> ids) {
		try {
			return new ArrayList<>(gameObjectTypeInteractionsRepository.findAllByReceivingGameObjectTypeIdAndIds(receivingGameObjectTypeId, ids));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type interactions", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeInteractionsByReceivingGameObjectTypeId(Long receivingGameObjectTypeId) {
		try {
			gameObjectTypeInteractionsRepository.deleteAllByReceivingGameObjectTypeId(receivingGameObjectTypeId);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type interactions", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeInteractionsByReceivingGameObjectTypeIdAndIds(Long receivingGameObjectTypeId, List<Long> ids) {
		try {
			gameObjectTypeInteractionsRepository.deleteAllByReceivingGameObjectTypeIdAndIds(receivingGameObjectTypeId, ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type interactions", ex);
		}
	}


	public GameObjectTypeInteractionProperty newGameObjectTypeInteractionProperty() {
		return new GameObjectTypeInteractionPropertyEntity();
	}

	@Override
	public GameObjectTypeInteractionProperty newGameObjectTypeInteractionProperty(Long id) {
		return new GameObjectTypeInteractionPropertyEntity(id);
	}

	@Override
	public List<GameObjectTypeInteractionProperty> findAllGameObjectTypeInteractionProperties() {
		try {
			return StreamSupport.stream(gameObjectTypeInteractionPropertiesRepository.findAll().spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type interaction properties", ex);
		}
	}

	@Override
	public GameObjectTypeInteractionProperty findGameObjectTypeInteractionProperty(Long id) {
		try {
			return gameObjectTypeInteractionPropertiesRepository.findById(id).orElse(null);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type interaction property", ex);
		}
	}

	@Override
	public GameObjectTypeInteractionProperty saveGameObjectTypeInteractionProperty(GameObjectTypeInteractionProperty gameObjectTypeInteractionProperty) {
		try {
			return gameObjectTypeInteractionPropertiesRepository.save((GameObjectTypeInteractionPropertyEntity) gameObjectTypeInteractionProperty);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game object type interaction property", ex);
		}
	}

	@Override
	public List<GameObjectTypeInteractionProperty> saveGameObjectTypeInteractionProperties(List<GameObjectTypeInteractionProperty> gameObjectTypeInteractionProperties) {
		try {
			Iterable<GameObjectTypeInteractionPropertyEntity> lst = gameObjectTypeInteractionProperties.stream().map(a -> (GameObjectTypeInteractionPropertyEntity)a).collect(Collectors.toList());
			lst = gameObjectTypeInteractionPropertiesRepository.saveAll(lst);
			return StreamSupport.stream(lst.spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game object type interaction property", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeInteractionProperty(GameObjectTypeInteractionProperty gameObjectTypeInteractionProperty) {
		try {
			gameObjectTypeInteractionPropertiesRepository.delete((GameObjectTypeInteractionPropertyEntity) gameObjectTypeInteractionProperty);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete game object type interaction property", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeInteractionPropertiesByIds(List<Long> ids) {
		try {
			gameObjectTypeInteractionPropertiesRepository.deleteAllByIds(ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type interaction properties", ex);
		}
	}

	@Override
	public List<GameObjectTypeInteractionProperty> findAllGameObjectTypeInteractionPropertiesByExample(GameObjectTypeInteractionProperty example) {
		try {
			return new ArrayList<>(gameObjectTypeInteractionPropertiesRepository.findAllByExample(example.getGameObjectTypeInteractionId() , example.getDonatingGameObjectTypePropertyId() , example.getReceivingGameObjectTypePropertyId() , example.getOverflowGameObjectTypePropertyId() , example.getIsIncremental() , example.getIsInverted() ));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type interaction properties", ex);
		}
	}

	@Override
	public List<GameObjectTypeInteractionProperty> findAllGameObjectTypeInteractionPropertiesByGameObjectTypeInteractionId(Long gameObjectTypeInteractionId) {
		try {
			return new ArrayList<>(gameObjectTypeInteractionPropertiesRepository.findAllByGameObjectTypeInteractionId(gameObjectTypeInteractionId));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type interaction properties", ex);
		}
	}

	@Override
	public List<GameObjectTypeInteractionProperty> findAllGameObjectTypeInteractionPropertiesByGameObjectTypeInteractionIdAndIds(Long gameObjectTypeInteractionId, List<Long> ids) {
		try {
			return new ArrayList<>(gameObjectTypeInteractionPropertiesRepository.findAllByGameObjectTypeInteractionIdAndIds(gameObjectTypeInteractionId, ids));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type interaction properties", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeInteractionPropertiesByGameObjectTypeInteractionId(Long gameObjectTypeInteractionId) {
		try {
			gameObjectTypeInteractionPropertiesRepository.deleteAllByGameObjectTypeInteractionId(gameObjectTypeInteractionId);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type interaction properties", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeInteractionPropertiesByGameObjectTypeInteractionIdAndIds(Long gameObjectTypeInteractionId, List<Long> ids) {
		try {
			gameObjectTypeInteractionPropertiesRepository.deleteAllByGameObjectTypeInteractionIdAndIds(gameObjectTypeInteractionId, ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type interaction properties", ex);
		}
	}

	@Override
	public List<GameObjectTypeInteractionProperty> findAllGameObjectTypeInteractionPropertiesByDonatingGameObjectTypePropertyId(Long donatingGameObjectTypePropertyId) {
		try {
			return new ArrayList<>(gameObjectTypeInteractionPropertiesRepository.findAllByDonatingGameObjectTypePropertyId(donatingGameObjectTypePropertyId));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type interaction properties", ex);
		}
	}

	@Override
	public List<GameObjectTypeInteractionProperty> findAllGameObjectTypeInteractionPropertiesByDonatingGameObjectTypePropertyIdAndIds(Long donatingGameObjectTypePropertyId, List<Long> ids) {
		try {
			return new ArrayList<>(gameObjectTypeInteractionPropertiesRepository.findAllByDonatingGameObjectTypePropertyIdAndIds(donatingGameObjectTypePropertyId, ids));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type interaction properties", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeInteractionPropertiesByDonatingGameObjectTypePropertyId(Long donatingGameObjectTypePropertyId) {
		try {
			gameObjectTypeInteractionPropertiesRepository.deleteAllByDonatingGameObjectTypePropertyId(donatingGameObjectTypePropertyId);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type interaction properties", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeInteractionPropertiesByDonatingGameObjectTypePropertyIdAndIds(Long donatingGameObjectTypePropertyId, List<Long> ids) {
		try {
			gameObjectTypeInteractionPropertiesRepository.deleteAllByDonatingGameObjectTypePropertyIdAndIds(donatingGameObjectTypePropertyId, ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type interaction properties", ex);
		}
	}

	@Override
	public List<GameObjectTypeInteractionProperty> findAllGameObjectTypeInteractionPropertiesByReceivingGameObjectTypePropertyId(Long receivingGameObjectTypePropertyId) {
		try {
			return new ArrayList<>(gameObjectTypeInteractionPropertiesRepository.findAllByReceivingGameObjectTypePropertyId(receivingGameObjectTypePropertyId));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type interaction properties", ex);
		}
	}

	@Override
	public List<GameObjectTypeInteractionProperty> findAllGameObjectTypeInteractionPropertiesByReceivingGameObjectTypePropertyIdAndIds(Long receivingGameObjectTypePropertyId, List<Long> ids) {
		try {
			return new ArrayList<>(gameObjectTypeInteractionPropertiesRepository.findAllByReceivingGameObjectTypePropertyIdAndIds(receivingGameObjectTypePropertyId, ids));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type interaction properties", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeInteractionPropertiesByReceivingGameObjectTypePropertyId(Long receivingGameObjectTypePropertyId) {
		try {
			gameObjectTypeInteractionPropertiesRepository.deleteAllByReceivingGameObjectTypePropertyId(receivingGameObjectTypePropertyId);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type interaction properties", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeInteractionPropertiesByReceivingGameObjectTypePropertyIdAndIds(Long receivingGameObjectTypePropertyId, List<Long> ids) {
		try {
			gameObjectTypeInteractionPropertiesRepository.deleteAllByReceivingGameObjectTypePropertyIdAndIds(receivingGameObjectTypePropertyId, ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type interaction properties", ex);
		}
	}

	@Override
	public List<GameObjectTypeInteractionProperty> findAllGameObjectTypeInteractionPropertiesByOverflowGameObjectTypePropertyId(Long overflowGameObjectTypePropertyId) {
		try {
			return new ArrayList<>(gameObjectTypeInteractionPropertiesRepository.findAllByOverflowGameObjectTypePropertyId(overflowGameObjectTypePropertyId));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type interaction properties", ex);
		}
	}

	@Override
	public List<GameObjectTypeInteractionProperty> findAllGameObjectTypeInteractionPropertiesByOverflowGameObjectTypePropertyIdAndIds(Long overflowGameObjectTypePropertyId, List<Long> ids) {
		try {
			return new ArrayList<>(gameObjectTypeInteractionPropertiesRepository.findAllByOverflowGameObjectTypePropertyIdAndIds(overflowGameObjectTypePropertyId, ids));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type interaction properties", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeInteractionPropertiesByOverflowGameObjectTypePropertyId(Long overflowGameObjectTypePropertyId) {
		try {
			gameObjectTypeInteractionPropertiesRepository.deleteAllByOverflowGameObjectTypePropertyId(overflowGameObjectTypePropertyId);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type interaction properties", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeInteractionPropertiesByOverflowGameObjectTypePropertyIdAndIds(Long overflowGameObjectTypePropertyId, List<Long> ids) {
		try {
			gameObjectTypeInteractionPropertiesRepository.deleteAllByOverflowGameObjectTypePropertyIdAndIds(overflowGameObjectTypePropertyId, ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type interaction properties", ex);
		}
	}


	public GameClientType newGameClientType() {
		return new GameClientTypeEntity();
	}

	@Override
	public GameClientType newGameClientType(Long id) {
		return new GameClientTypeEntity(id);
	}

	@Override
	public List<GameClientType> findAllGameClientTypes() {
		try {
			return StreamSupport.stream(gameClientTypesRepository.findAll().spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game client types", ex);
		}
	}

	@Override
	public GameClientType findGameClientType(Long id) {
		try {
			return gameClientTypesRepository.findById(id).orElse(null);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game client type", ex);
		}
	}

	@Override
	public GameClientType saveGameClientType(GameClientType gameClientType) {
		try {
			return gameClientTypesRepository.save((GameClientTypeEntity) gameClientType);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game client type", ex);
		}
	}

	@Override
	public List<GameClientType> saveGameClientTypes(List<GameClientType> gameClientTypes) {
		try {
			Iterable<GameClientTypeEntity> lst = gameClientTypes.stream().map(a -> (GameClientTypeEntity)a).collect(Collectors.toList());
			lst = gameClientTypesRepository.saveAll(lst);
			return StreamSupport.stream(lst.spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game client type", ex);
		}
	}

	@Override
	public void deleteGameClientType(GameClientType gameClientType) {
		try {
			gameClientTypesRepository.delete((GameClientTypeEntity) gameClientType);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete game client type", ex);
		}
	}

	@Override
	public void deleteGameClientTypesByIds(List<Long> ids) {
		try {
			gameClientTypesRepository.deleteAllByIds(ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game client types", ex);
		}
	}

	@Override
	public List<GameClientType> findAllGameClientTypesByExample(GameClientType example) {
		try {
			return new ArrayList<>(gameClientTypesRepository.findAllByExample(example.getUniqueName() ));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game client types", ex);
		}
	}

	@Override
	public GameClientType findGameClientTypeByUniqueName(String uniqueName) {
		try {
			return gameClientTypesRepository.findOneByUniqueName(uniqueName);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game client types", ex);
		}
	}


	public GameObjectTypeRepresentation newGameObjectTypeRepresentation() {
		return new GameObjectTypeRepresentationEntity();
	}

	@Override
	public GameObjectTypeRepresentation newGameObjectTypeRepresentation(Long id) {
		return new GameObjectTypeRepresentationEntity(id);
	}

	@Override
	public List<GameObjectTypeRepresentation> findAllGameObjectTypeRepresentations() {
		try {
			return StreamSupport.stream(gameObjectTypeRepresentationsRepository.findAll().spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type representations", ex);
		}
	}

	@Override
	public GameObjectTypeRepresentation findGameObjectTypeRepresentation(Long id) {
		try {
			return gameObjectTypeRepresentationsRepository.findById(id).orElse(null);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type representation", ex);
		}
	}

	@Override
	public GameObjectTypeRepresentation saveGameObjectTypeRepresentation(GameObjectTypeRepresentation gameObjectTypeRepresentation) {
		try {
			return gameObjectTypeRepresentationsRepository.save((GameObjectTypeRepresentationEntity) gameObjectTypeRepresentation);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game object type representation", ex);
		}
	}

	@Override
	public List<GameObjectTypeRepresentation> saveGameObjectTypeRepresentations(List<GameObjectTypeRepresentation> gameObjectTypeRepresentations) {
		try {
			Iterable<GameObjectTypeRepresentationEntity> lst = gameObjectTypeRepresentations.stream().map(a -> (GameObjectTypeRepresentationEntity)a).collect(Collectors.toList());
			lst = gameObjectTypeRepresentationsRepository.saveAll(lst);
			return StreamSupport.stream(lst.spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game object type representation", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeRepresentation(GameObjectTypeRepresentation gameObjectTypeRepresentation) {
		try {
			gameObjectTypeRepresentationsRepository.delete((GameObjectTypeRepresentationEntity) gameObjectTypeRepresentation);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete game object type representation", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeRepresentationsByIds(List<Long> ids) {
		try {
			gameObjectTypeRepresentationsRepository.deleteAllByIds(ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type representations", ex);
		}
	}

	@Override
	public List<GameObjectTypeRepresentation> findAllGameObjectTypeRepresentationsByExample(GameObjectTypeRepresentation example) {
		try {
			return new ArrayList<>(gameObjectTypeRepresentationsRepository.findAllByExample(example.getGameObjectTypeId() , example.getGameClientTypeId() , example.getObjectHash() ));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type representations", ex);
		}
	}

	@Override
	public List<GameObjectTypeRepresentation> findAllGameObjectTypeRepresentationsByGameObjectTypeId(Long gameObjectTypeId) {
		try {
			return new ArrayList<>(gameObjectTypeRepresentationsRepository.findAllByGameObjectTypeId(gameObjectTypeId));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type representations", ex);
		}
	}

	@Override
	public List<GameObjectTypeRepresentation> findAllGameObjectTypeRepresentationsByGameObjectTypeIdAndIds(Long gameObjectTypeId, List<Long> ids) {
		try {
			return new ArrayList<>(gameObjectTypeRepresentationsRepository.findAllByGameObjectTypeIdAndIds(gameObjectTypeId, ids));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type representations", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeRepresentationsByGameObjectTypeId(Long gameObjectTypeId) {
		try {
			gameObjectTypeRepresentationsRepository.deleteAllByGameObjectTypeId(gameObjectTypeId);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type representations", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeRepresentationsByGameObjectTypeIdAndIds(Long gameObjectTypeId, List<Long> ids) {
		try {
			gameObjectTypeRepresentationsRepository.deleteAllByGameObjectTypeIdAndIds(gameObjectTypeId, ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type representations", ex);
		}
	}

	@Override
	public List<GameObjectTypeRepresentation> findAllGameObjectTypeRepresentationsByGameClientTypeId(Long gameClientTypeId) {
		try {
			return new ArrayList<>(gameObjectTypeRepresentationsRepository.findAllByGameClientTypeId(gameClientTypeId));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type representations", ex);
		}
	}

	@Override
	public List<GameObjectTypeRepresentation> findAllGameObjectTypeRepresentationsByGameClientTypeIdAndIds(Long gameClientTypeId, List<Long> ids) {
		try {
			return new ArrayList<>(gameObjectTypeRepresentationsRepository.findAllByGameClientTypeIdAndIds(gameClientTypeId, ids));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type representations", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeRepresentationsByGameClientTypeId(Long gameClientTypeId) {
		try {
			gameObjectTypeRepresentationsRepository.deleteAllByGameClientTypeId(gameClientTypeId);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type representations", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeRepresentationsByGameClientTypeIdAndIds(Long gameClientTypeId, List<Long> ids) {
		try {
			gameObjectTypeRepresentationsRepository.deleteAllByGameClientTypeIdAndIds(gameClientTypeId, ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type representations", ex);
		}
	}


	public GameObjectTypeState newGameObjectTypeState() {
		return new GameObjectTypeStateEntity();
	}

	@Override
	public GameObjectTypeState newGameObjectTypeState(Long id) {
		return new GameObjectTypeStateEntity(id);
	}

	@Override
	public List<GameObjectTypeState> findAllGameObjectTypeStates() {
		try {
			return StreamSupport.stream(gameObjectTypeStatesRepository.findAll().spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type states", ex);
		}
	}

	@Override
	public GameObjectTypeState findGameObjectTypeState(Long id) {
		try {
			return gameObjectTypeStatesRepository.findById(id).orElse(null);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type state", ex);
		}
	}

	@Override
	public GameObjectTypeState saveGameObjectTypeState(GameObjectTypeState gameObjectTypeState) {
		try {
			return gameObjectTypeStatesRepository.save((GameObjectTypeStateEntity) gameObjectTypeState);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game object type state", ex);
		}
	}

	@Override
	public List<GameObjectTypeState> saveGameObjectTypeStates(List<GameObjectTypeState> gameObjectTypeStates) {
		try {
			Iterable<GameObjectTypeStateEntity> lst = gameObjectTypeStates.stream().map(a -> (GameObjectTypeStateEntity)a).collect(Collectors.toList());
			lst = gameObjectTypeStatesRepository.saveAll(lst);
			return StreamSupport.stream(lst.spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game object type state", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeState(GameObjectTypeState gameObjectTypeState) {
		try {
			gameObjectTypeStatesRepository.delete((GameObjectTypeStateEntity) gameObjectTypeState);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete game object type state", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeStatesByIds(List<Long> ids) {
		try {
			gameObjectTypeStatesRepository.deleteAllByIds(ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type states", ex);
		}
	}

	@Override
	public List<GameObjectTypeState> findAllGameObjectTypeStatesByExample(GameObjectTypeState example) {
		try {
			return new ArrayList<>(gameObjectTypeStatesRepository.findAllByExample(example.getGameObjectTypeId() , example.getName() ));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type states", ex);
		}
	}

	@Override
	public List<GameObjectTypeState> findAllGameObjectTypeStatesByGameObjectTypeId(Long gameObjectTypeId) {
		try {
			return new ArrayList<>(gameObjectTypeStatesRepository.findAllByGameObjectTypeId(gameObjectTypeId));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type states", ex);
		}
	}

	@Override
	public List<GameObjectTypeState> findAllGameObjectTypeStatesByGameObjectTypeIdAndIds(Long gameObjectTypeId, List<Long> ids) {
		try {
			return new ArrayList<>(gameObjectTypeStatesRepository.findAllByGameObjectTypeIdAndIds(gameObjectTypeId, ids));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type states", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeStatesByGameObjectTypeId(Long gameObjectTypeId) {
		try {
			gameObjectTypeStatesRepository.deleteAllByGameObjectTypeId(gameObjectTypeId);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type states", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeStatesByGameObjectTypeIdAndIds(Long gameObjectTypeId, List<Long> ids) {
		try {
			gameObjectTypeStatesRepository.deleteAllByGameObjectTypeIdAndIds(gameObjectTypeId, ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type states", ex);
		}
	}

	@Override
	public GameObjectTypeState findGameObjectTypeStateByName(String name) {
		try {
			return gameObjectTypeStatesRepository.findOneByName(name);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type states", ex);
		}
	}


	public GameObjectTypeStatePropertyModifier newGameObjectTypeStatePropertyModifier() {
		return new GameObjectTypeStatePropertyModifierEntity();
	}

	@Override
	public GameObjectTypeStatePropertyModifier newGameObjectTypeStatePropertyModifier(Long id) {
		return new GameObjectTypeStatePropertyModifierEntity(id);
	}

	@Override
	public List<GameObjectTypeStatePropertyModifier> findAllGameObjectTypeStatePropertyModifiers() {
		try {
			return StreamSupport.stream(gameObjectTypeStatePropertyModifiersRepository.findAll().spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type state property modifiers", ex);
		}
	}

	@Override
	public GameObjectTypeStatePropertyModifier findGameObjectTypeStatePropertyModifier(Long id) {
		try {
			return gameObjectTypeStatePropertyModifiersRepository.findById(id).orElse(null);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type state property modifier", ex);
		}
	}

	@Override
	public GameObjectTypeStatePropertyModifier saveGameObjectTypeStatePropertyModifier(GameObjectTypeStatePropertyModifier gameObjectTypeStatePropertyModifier) {
		try {
			return gameObjectTypeStatePropertyModifiersRepository.save((GameObjectTypeStatePropertyModifierEntity) gameObjectTypeStatePropertyModifier);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game object type state property modifier", ex);
		}
	}

	@Override
	public List<GameObjectTypeStatePropertyModifier> saveGameObjectTypeStatePropertyModifiers(List<GameObjectTypeStatePropertyModifier> gameObjectTypeStatePropertyModifiers) {
		try {
			Iterable<GameObjectTypeStatePropertyModifierEntity> lst = gameObjectTypeStatePropertyModifiers.stream().map(a -> (GameObjectTypeStatePropertyModifierEntity)a).collect(Collectors.toList());
			lst = gameObjectTypeStatePropertyModifiersRepository.saveAll(lst);
			return StreamSupport.stream(lst.spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game object type state property modifier", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeStatePropertyModifier(GameObjectTypeStatePropertyModifier gameObjectTypeStatePropertyModifier) {
		try {
			gameObjectTypeStatePropertyModifiersRepository.delete((GameObjectTypeStatePropertyModifierEntity) gameObjectTypeStatePropertyModifier);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete game object type state property modifier", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeStatePropertyModifiersByIds(List<Long> ids) {
		try {
			gameObjectTypeStatePropertyModifiersRepository.deleteAllByIds(ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type state property modifiers", ex);
		}
	}

	@Override
	public List<GameObjectTypeStatePropertyModifier> findAllGameObjectTypeStatePropertyModifiersByExample(GameObjectTypeStatePropertyModifier example) {
		try {
			return new ArrayList<>(gameObjectTypeStatePropertyModifiersRepository.findAllByExample(example.getGameObjectTypeStateId() , example.getGameObjectTypePropertyId() , example.getPropertyActualValue() ));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type state property modifiers", ex);
		}
	}

	@Override
	public List<GameObjectTypeStatePropertyModifier> findAllGameObjectTypeStatePropertyModifiersByGameObjectTypeStateId(Long gameObjectTypeStateId) {
		try {
			return new ArrayList<>(gameObjectTypeStatePropertyModifiersRepository.findAllByGameObjectTypeStateId(gameObjectTypeStateId));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type state property modifiers", ex);
		}
	}

	@Override
	public List<GameObjectTypeStatePropertyModifier> findAllGameObjectTypeStatePropertyModifiersByGameObjectTypeStateIdAndIds(Long gameObjectTypeStateId, List<Long> ids) {
		try {
			return new ArrayList<>(gameObjectTypeStatePropertyModifiersRepository.findAllByGameObjectTypeStateIdAndIds(gameObjectTypeStateId, ids));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type state property modifiers", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeStatePropertyModifiersByGameObjectTypeStateId(Long gameObjectTypeStateId) {
		try {
			gameObjectTypeStatePropertyModifiersRepository.deleteAllByGameObjectTypeStateId(gameObjectTypeStateId);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type state property modifiers", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeStatePropertyModifiersByGameObjectTypeStateIdAndIds(Long gameObjectTypeStateId, List<Long> ids) {
		try {
			gameObjectTypeStatePropertyModifiersRepository.deleteAllByGameObjectTypeStateIdAndIds(gameObjectTypeStateId, ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type state property modifiers", ex);
		}
	}

	@Override
	public List<GameObjectTypeStatePropertyModifier> findAllGameObjectTypeStatePropertyModifiersByGameObjectTypePropertyId(Long gameObjectTypePropertyId) {
		try {
			return new ArrayList<>(gameObjectTypeStatePropertyModifiersRepository.findAllByGameObjectTypePropertyId(gameObjectTypePropertyId));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type state property modifiers", ex);
		}
	}

	@Override
	public List<GameObjectTypeStatePropertyModifier> findAllGameObjectTypeStatePropertyModifiersByGameObjectTypePropertyIdAndIds(Long gameObjectTypePropertyId, List<Long> ids) {
		try {
			return new ArrayList<>(gameObjectTypeStatePropertyModifiersRepository.findAllByGameObjectTypePropertyIdAndIds(gameObjectTypePropertyId, ids));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type state property modifiers", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeStatePropertyModifiersByGameObjectTypePropertyId(Long gameObjectTypePropertyId) {
		try {
			gameObjectTypeStatePropertyModifiersRepository.deleteAllByGameObjectTypePropertyId(gameObjectTypePropertyId);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type state property modifiers", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeStatePropertyModifiersByGameObjectTypePropertyIdAndIds(Long gameObjectTypePropertyId, List<Long> ids) {
		try {
			gameObjectTypeStatePropertyModifiersRepository.deleteAllByGameObjectTypePropertyIdAndIds(gameObjectTypePropertyId, ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type state property modifiers", ex);
		}
	}


	public GameObjectTypeClass newGameObjectTypeClass() {
		return new GameObjectTypeClassEntity();
	}

	@Override
	public GameObjectTypeClass newGameObjectTypeClass(Long id) {
		return new GameObjectTypeClassEntity(id);
	}

	@Override
	public List<GameObjectTypeClass> findAllGameObjectTypeClasses() {
		try {
			return StreamSupport.stream(gameObjectTypeClassesRepository.findAll().spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type classes", ex);
		}
	}

	@Override
	public GameObjectTypeClass findGameObjectTypeClass(Long id) {
		try {
			return gameObjectTypeClassesRepository.findById(id).orElse(null);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type class", ex);
		}
	}

	@Override
	public GameObjectTypeClass saveGameObjectTypeClass(GameObjectTypeClass gameObjectTypeClass) {
		try {
			return gameObjectTypeClassesRepository.save((GameObjectTypeClassEntity) gameObjectTypeClass);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game object type class", ex);
		}
	}

	@Override
	public List<GameObjectTypeClass> saveGameObjectTypeClasses(List<GameObjectTypeClass> gameObjectTypeClasses) {
		try {
			Iterable<GameObjectTypeClassEntity> lst = gameObjectTypeClasses.stream().map(a -> (GameObjectTypeClassEntity)a).collect(Collectors.toList());
			lst = gameObjectTypeClassesRepository.saveAll(lst);
			return StreamSupport.stream(lst.spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game object type class", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeClass(GameObjectTypeClass gameObjectTypeClass) {
		try {
			gameObjectTypeClassesRepository.delete((GameObjectTypeClassEntity) gameObjectTypeClass);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete game object type class", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeClassesByIds(List<Long> ids) {
		try {
			gameObjectTypeClassesRepository.deleteAllByIds(ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type classes", ex);
		}
	}

	@Override
	public List<GameObjectTypeClass> findAllGameObjectTypeClassesByExample(GameObjectTypeClass example) {
		try {
			return new ArrayList<>(gameObjectTypeClassesRepository.findAllByExample(example.getName() ));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type classes", ex);
		}
	}

	@Override
	public GameObjectTypeClass findGameObjectTypeClassByName(String name) {
		try {
			return gameObjectTypeClassesRepository.findOneByName(name);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type classes", ex);
		}
	}


	public GameAssetsRepository newGameAssetsRepository() {
		return new GameAssetsRepositoryEntity();
	}

	@Override
	public GameAssetsRepository newGameAssetsRepository(Long id) {
		return new GameAssetsRepositoryEntity(id);
	}

	@Override
	public List<GameAssetsRepository> findAllGameAssetsRepositories() {
		try {
			return StreamSupport.stream(gameAssetsRepositoriesRepository.findAll().spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game assets repositories", ex);
		}
	}

	@Override
	public GameAssetsRepository findGameAssetsRepository(Long id) {
		try {
			return gameAssetsRepositoriesRepository.findById(id).orElse(null);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game assets repository", ex);
		}
	}

	@Override
	public GameAssetsRepository saveGameAssetsRepository(GameAssetsRepository gameAssetsRepository) {
		try {
			return gameAssetsRepositoriesRepository.save((GameAssetsRepositoryEntity) gameAssetsRepository);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game assets repository", ex);
		}
	}

	@Override
	public List<GameAssetsRepository> saveGameAssetsRepositories(List<GameAssetsRepository> gameAssetsRepositories) {
		try {
			Iterable<GameAssetsRepositoryEntity> lst = gameAssetsRepositories.stream().map(a -> (GameAssetsRepositoryEntity)a).collect(Collectors.toList());
			lst = gameAssetsRepositoriesRepository.saveAll(lst);
			return StreamSupport.stream(lst.spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game assets repository", ex);
		}
	}

	@Override
	public void deleteGameAssetsRepository(GameAssetsRepository gameAssetsRepository) {
		try {
			gameAssetsRepositoriesRepository.delete((GameAssetsRepositoryEntity) gameAssetsRepository);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete game assets repository", ex);
		}
	}

	@Override
	public void deleteGameAssetsRepositoriesByIds(List<Long> ids) {
		try {
			gameAssetsRepositoriesRepository.deleteAllByIds(ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game assets repositories", ex);
		}
	}

	@Override
	public List<GameAssetsRepository> findAllGameAssetsRepositoriesByExample(GameAssetsRepository example) {
		try {
			return new ArrayList<>(gameAssetsRepositoriesRepository.findAllByExample(example.getUniqueName() , example.getDescription() ));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game assets repositories", ex);
		}
	}

	@Override
	public GameAssetsRepository findGameAssetsRepositoryByUniqueName(String uniqueName) {
		try {
			return gameAssetsRepositoriesRepository.findOneByUniqueName(uniqueName);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game assets repositories", ex);
		}
	}


	public GameObjectType newGameObjectType() {
		return new GameObjectTypeEntity();
	}

	@Override
	public GameObjectType newGameObjectType(Long id) {
		return new GameObjectTypeEntity(id);
	}

	@Override
	public List<GameObjectType> findAllGameObjectTypes() {
		try {
			return StreamSupport.stream(gameObjectTypesRepository.findAll().spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object types", ex);
		}
	}

	@Override
	public GameObjectType findGameObjectType(Long id) {
		try {
			return gameObjectTypesRepository.findById(id).orElse(null);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type", ex);
		}
	}

	@Override
	public GameObjectType saveGameObjectType(GameObjectType gameObjectType) {
		try {
			return gameObjectTypesRepository.save((GameObjectTypeEntity) gameObjectType);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game object type", ex);
		}
	}

	@Override
	public List<GameObjectType> saveGameObjectTypes(List<GameObjectType> gameObjectTypes) {
		try {
			Iterable<GameObjectTypeEntity> lst = gameObjectTypes.stream().map(a -> (GameObjectTypeEntity)a).collect(Collectors.toList());
			lst = gameObjectTypesRepository.saveAll(lst);
			return StreamSupport.stream(lst.spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game object type", ex);
		}
	}

	@Override
	public void deleteGameObjectType(GameObjectType gameObjectType) {
		try {
			gameObjectTypesRepository.delete((GameObjectTypeEntity) gameObjectType);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete game object type", ex);
		}
	}

	@Override
	public void deleteGameObjectTypesByIds(List<Long> ids) {
		try {
			gameObjectTypesRepository.deleteAllByIds(ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object types", ex);
		}
	}

	@Override
	public List<GameObjectType> findAllGameObjectTypesByExample(GameObjectType example) {
		try {
			return new ArrayList<>(gameObjectTypesRepository.findAllByExample(example.getGameAssetsRepositoryId() , example.getGameObjectTypeClassId() , example.getUniqueName() , example.getDescription() , example.getIsExperimental() ));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object types", ex);
		}
	}

	@Override
	public List<GameObjectType> findAllGameObjectTypesByGameAssetsRepositoryId(Long gameAssetsRepositoryId) {
		try {
			return new ArrayList<>(gameObjectTypesRepository.findAllByGameAssetsRepositoryId(gameAssetsRepositoryId));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object types", ex);
		}
	}

	@Override
	public List<GameObjectType> findAllGameObjectTypesByGameAssetsRepositoryIdAndIds(Long gameAssetsRepositoryId, List<Long> ids) {
		try {
			return new ArrayList<>(gameObjectTypesRepository.findAllByGameAssetsRepositoryIdAndIds(gameAssetsRepositoryId, ids));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object types", ex);
		}
	}

	@Override
	public void deleteGameObjectTypesByGameAssetsRepositoryId(Long gameAssetsRepositoryId) {
		try {
			gameObjectTypesRepository.deleteAllByGameAssetsRepositoryId(gameAssetsRepositoryId);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object types", ex);
		}
	}

	@Override
	public void deleteGameObjectTypesByGameAssetsRepositoryIdAndIds(Long gameAssetsRepositoryId, List<Long> ids) {
		try {
			gameObjectTypesRepository.deleteAllByGameAssetsRepositoryIdAndIds(gameAssetsRepositoryId, ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object types", ex);
		}
	}

	@Override
	public List<GameObjectType> findAllGameObjectTypesByGameObjectTypeClassId(Long gameObjectTypeClassId) {
		try {
			return new ArrayList<>(gameObjectTypesRepository.findAllByGameObjectTypeClassId(gameObjectTypeClassId));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object types", ex);
		}
	}

	@Override
	public List<GameObjectType> findAllGameObjectTypesByGameObjectTypeClassIdAndIds(Long gameObjectTypeClassId, List<Long> ids) {
		try {
			return new ArrayList<>(gameObjectTypesRepository.findAllByGameObjectTypeClassIdAndIds(gameObjectTypeClassId, ids));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object types", ex);
		}
	}

	@Override
	public void deleteGameObjectTypesByGameObjectTypeClassId(Long gameObjectTypeClassId) {
		try {
			gameObjectTypesRepository.deleteAllByGameObjectTypeClassId(gameObjectTypeClassId);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object types", ex);
		}
	}

	@Override
	public void deleteGameObjectTypesByGameObjectTypeClassIdAndIds(Long gameObjectTypeClassId, List<Long> ids) {
		try {
			gameObjectTypesRepository.deleteAllByGameObjectTypeClassIdAndIds(gameObjectTypeClassId, ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object types", ex);
		}
	}

	@Override
	public GameObjectType findGameObjectTypeByUniqueName(String uniqueName) {
		try {
			return gameObjectTypesRepository.findOneByUniqueName(uniqueName);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object types", ex);
		}
	}


	public GameObjectTypeProperty newGameObjectTypeProperty() {
		return new GameObjectTypePropertyEntity();
	}

	@Override
	public GameObjectTypeProperty newGameObjectTypeProperty(Long id) {
		return new GameObjectTypePropertyEntity(id);
	}

	@Override
	public List<GameObjectTypeProperty> findAllGameObjectTypeProperties() {
		try {
			return StreamSupport.stream(gameObjectTypePropertiesRepository.findAll().spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type properties", ex);
		}
	}

	@Override
	public GameObjectTypeProperty findGameObjectTypeProperty(Long id) {
		try {
			return gameObjectTypePropertiesRepository.findById(id).orElse(null);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to retrieve game object type property", ex);
		}
	}

	@Override
	public GameObjectTypeProperty saveGameObjectTypeProperty(GameObjectTypeProperty gameObjectTypeProperty) {
		try {
			return gameObjectTypePropertiesRepository.save((GameObjectTypePropertyEntity) gameObjectTypeProperty);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game object type property", ex);
		}
	}

	@Override
	public List<GameObjectTypeProperty> saveGameObjectTypeProperties(List<GameObjectTypeProperty> gameObjectTypeProperties) {
		try {
			Iterable<GameObjectTypePropertyEntity> lst = gameObjectTypeProperties.stream().map(a -> (GameObjectTypePropertyEntity)a).collect(Collectors.toList());
			lst = gameObjectTypePropertiesRepository.saveAll(lst);
			return StreamSupport.stream(lst.spliterator(), false).collect(Collectors.toList());
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game object type property", ex);
		}
	}

	@Override
	public void deleteGameObjectTypeProperty(GameObjectTypeProperty gameObjectTypeProperty) {
		try {
			gameObjectTypePropertiesRepository.delete((GameObjectTypePropertyEntity) gameObjectTypeProperty);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to delete game object type property", ex);
		}
	}

	@Override
	public void deleteGameObjectTypePropertiesByIds(List<Long> ids) {
		try {
			gameObjectTypePropertiesRepository.deleteAllByIds(ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type properties", ex);
		}
	}

	@Override
	public List<GameObjectTypeProperty> findAllGameObjectTypePropertiesByExample(GameObjectTypeProperty example) {
		try {
			return new ArrayList<>(gameObjectTypePropertiesRepository.findAllByExample(example.getGameObjectTypeId() , example.getPropertyName() , example.getPropertyDefaultValue() , example.getPropertyMinValue() , example.getPropertyMaxValue() ));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type properties", ex);
		}
	}

	@Override
	public List<GameObjectTypeProperty> findAllGameObjectTypePropertiesByGameObjectTypeId(Long gameObjectTypeId) {
		try {
			return new ArrayList<>(gameObjectTypePropertiesRepository.findAllByGameObjectTypeId(gameObjectTypeId));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type properties", ex);
		}
	}

	@Override
	public List<GameObjectTypeProperty> findAllGameObjectTypePropertiesByGameObjectTypeIdAndIds(Long gameObjectTypeId, List<Long> ids) {
		try {
			return new ArrayList<>(gameObjectTypePropertiesRepository.findAllByGameObjectTypeIdAndIds(gameObjectTypeId, ids));
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type properties", ex);
		}
	}

	@Override
	public void deleteGameObjectTypePropertiesByGameObjectTypeId(Long gameObjectTypeId) {
		try {
			gameObjectTypePropertiesRepository.deleteAllByGameObjectTypeId(gameObjectTypeId);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type properties", ex);
		}
	}

	@Override
	public void deleteGameObjectTypePropertiesByGameObjectTypeIdAndIds(Long gameObjectTypeId, List<Long> ids) {
		try {
			gameObjectTypePropertiesRepository.deleteAllByGameObjectTypeIdAndIds(gameObjectTypeId, ids);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game object type properties", ex);
		}
	}

	@Override
	public GameObjectTypeProperty findGameObjectTypePropertyByPropertyName(String propertyName) {
		try {
			return gameObjectTypePropertiesRepository.findOneByPropertyName(propertyName);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPullingException("Unable to find game object type properties", ex);
		}
	}


	public GameAssetsRepositoryOwner newGameAssetsRepositoryOwner() {
		return new GameAssetsRepositoryOwnerEntity();
	}

	@Override
	public GameAssetsRepositoryOwner saveGameAssetsRepositoryOwner(GameAssetsRepositoryOwner gameAssetsRepositoryOwner) {
		try {
			return gameAssetsRepositoryOwnersRepository.save((GameAssetsRepositoryOwnerEntity) gameAssetsRepositoryOwner);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryPushingException("Unable to save game assets repository owner", ex);
		}
	}

	@Override
	public void deleteGameAssetsRepositoryOwnersByGameAssetsRepositoryId(Long gameAssetsRepositoryId) {
		try {
			gameAssetsRepositoryOwnersRepository.deleteAllByGameAssetsRepositoryId(gameAssetsRepositoryId);
		} catch (Exception ex) {
			throw new CrazyDumplingsSpringDataGameWorldRegistryExpungingException("Unable to find game assets repository owners", ex);
		}
	}

	@Override
	public GameAssetsRepositoryOwner newGameAssetsRepositoryOwner(Long repId, Long repOwnerId) {
		return new GameAssetsRepositoryOwnerEntity(repId, repOwnerId);
	}

	@Override
	public List<GameAssetsRepositoryOwner> findAllGameAssetsRepositoryOwners() {
		throw new UnsupportedOperationException("not implemented");
	}

	@Override
	public GameAssetsRepositoryOwner newGameAssetsRepositoryOwner(Long id) {
		throw new UnsupportedOperationException("not implemented");
	}

	@Override
	public GameAssetsRepositoryOwner findGameAssetsRepositoryOwner(Long id) {
		throw new UnsupportedOperationException("not implemented");
	}

	@Override
	public List<GameAssetsRepositoryOwner> saveGameAssetsRepositoryOwners(
			List<GameAssetsRepositoryOwner> gameAssetsRepositoryOwners) {
		throw new UnsupportedOperationException("not implemented");
	}

	@Override
	public void deleteGameAssetsRepositoryOwner(GameAssetsRepositoryOwner gameAssetsRepositoryOwner) {
		throw new UnsupportedOperationException("not implemented");
	}

	@Override
	public void deleteGameAssetsRepositoryOwnersByIds(List<Long> ids) {
		throw new UnsupportedOperationException("not implemented");
	}

	@Override
	public List<GameAssetsRepositoryOwner> findAllGameAssetsRepositoryOwnersByExample(GameAssetsRepositoryOwner example) {
		throw new UnsupportedOperationException("not implemented");
	}

	@Override
	public List<GameAssetsRepositoryOwner> findAllGameAssetsRepositoryOwnersByGameAssetsRepositoryId(Long gameAssetsRepositoryId) {
		throw new UnsupportedOperationException("not implemented");
	}

	@Override
	public List<GameAssetsRepositoryOwner> findAllGameAssetsRepositoryOwnersByGameAssetsRepositoryIdAndIds(Long gameAssetsRepositoryIds, List<Long> ids) {
		throw new UnsupportedOperationException("not implemented");
	}

	@Override
	public void deleteGameAssetsRepositoryOwnersByGameAssetsRepositoryIdAndIds(Long gameAssetsRepositoryId, List<Long> gameAssetsRepositoryIds) {
		throw new UnsupportedOperationException("not implemented");
	}

	@Override
	public GameAssetsRepositoryOwner findGameAssetsRepositoryOwnerByGameAssetsRepositoryIdAndOwnerId(Long repoId, Long userId) {
		List<GameAssetsRepositoryOwnerEntity> repOwners = gameAssetsRepositoryOwnersRepository.findAllByExample(repoId, userId);
		
		if (repOwners == null) {
			return null;
		}

		return repOwners.get(0);
	}

}
