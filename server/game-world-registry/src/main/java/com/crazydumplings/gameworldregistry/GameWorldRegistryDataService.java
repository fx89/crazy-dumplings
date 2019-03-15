package com.crazydumplings.gameworldregistry;

import java.util.List;

import com.crazydumplings.gameworldregistry.model.Action;
import com.crazydumplings.gameworldregistry.model.AutomationObjectProvider;
import com.crazydumplings.gameworldregistry.model.GameAddonInteractionReceivingPropertyModifier;
import com.crazydumplings.gameworldregistry.model.GameAssetsRepository;
import com.crazydumplings.gameworldregistry.model.GameAssetsRepositoryOwner;
import com.crazydumplings.gameworldregistry.model.GameAssetsRepositoryPicture;
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

/**
 * Any implementation of this interface can be injected into the
 * {@link GameWorldRegistryService} to provide persistence to various media
 */
public interface GameWorldRegistryDataService {
	List<PlayableCharacterType> findAllPlayableCharacterTypes();

	PlayableCharacterType newPlayableCharacterType();

	PlayableCharacterType newPlayableCharacterType(Long id);

	PlayableCharacterType findPlayableCharacterType(Long id);

	PlayableCharacterType savePlayableCharacterType(PlayableCharacterType playableCharacterType);

	List<PlayableCharacterType> savePlayableCharacterTypes(List<PlayableCharacterType> playableCharacterTypes);

	void deletePlayableCharacterType(PlayableCharacterType playableCharacterType);

	void deletePlayableCharacterTypesByIds(List<Long> ids);

	List<PlayableCharacterType> findAllPlayableCharacterTypesByExample(PlayableCharacterType example);

	PlayableCharacterType findPlayableCharacterTypeByUniqueCharacterTypeName(String uniqueCharacterTypeName);

	List<PlayableCharacterType> findAllPlayableCharacterTypesByGameObjectTypeId(Long gameObjectTypeId);

	List<PlayableCharacterType> findAllPlayableCharacterTypesByGameObjectTypeIdAndIds(Long gameObjectTypeIds, List<Long> ids);

	void deletePlayableCharacterTypesByGameObjectTypeIdAndIds(Long gameObjectTypeId, List<Long> gameObjectTypeIds);

	void deletePlayableCharacterTypesByGameObjectTypeId(Long gameObjectTypeId);


	List<GameWorldSpawnPointType> findAllGameWorldSpawnPointTypes();

	GameWorldSpawnPointType newGameWorldSpawnPointType();

	GameWorldSpawnPointType newGameWorldSpawnPointType(Long id);

	GameWorldSpawnPointType findGameWorldSpawnPointType(Long id);

	GameWorldSpawnPointType saveGameWorldSpawnPointType(GameWorldSpawnPointType gameWorldSpawnPointType);

	List<GameWorldSpawnPointType> saveGameWorldSpawnPointTypes(List<GameWorldSpawnPointType> gameWorldSpawnPointTypes);

	void deleteGameWorldSpawnPointType(GameWorldSpawnPointType gameWorldSpawnPointType);

	void deleteGameWorldSpawnPointTypesByIds(List<Long> ids);

	List<GameWorldSpawnPointType> findAllGameWorldSpawnPointTypesByExample(GameWorldSpawnPointType example);

	List<GameWorldSpawnPointType> findAllGameWorldSpawnPointTypesBySpawnPointGameObjectTypeId(Long spawnPointGameObjectTypeId);

	List<GameWorldSpawnPointType> findAllGameWorldSpawnPointTypesBySpawnPointGameObjectTypeIdAndIds(Long spawnPointGameObjectTypeIds, List<Long> ids);

	void deleteGameWorldSpawnPointTypesBySpawnPointGameObjectTypeIdAndIds(Long spawnPointGameObjectTypeId, List<Long> spawnPointGameObjectTypeIds);

	void deleteGameWorldSpawnPointTypesBySpawnPointGameObjectTypeId(Long spawnPointGameObjectTypeId);

	List<GameWorldSpawnPointType> findAllGameWorldSpawnPointTypesBySpawnedGameObjectTypeId(Long spawnedGameObjectTypeId);

	List<GameWorldSpawnPointType> findAllGameWorldSpawnPointTypesBySpawnedGameObjectTypeIdAndIds(Long spawnedGameObjectTypeIds, List<Long> ids);

	void deleteGameWorldSpawnPointTypesBySpawnedGameObjectTypeIdAndIds(Long spawnedGameObjectTypeId, List<Long> spawnedGameObjectTypeIds);

	void deleteGameWorldSpawnPointTypesBySpawnedGameObjectTypeId(Long spawnedGameObjectTypeId);


	List<GameWorldCellType> findAllGameWorldCellTypes();

	GameWorldCellType newGameWorldCellType();

	GameWorldCellType newGameWorldCellType(Long id);

	GameWorldCellType findGameWorldCellType(Long id);

	GameWorldCellType saveGameWorldCellType(GameWorldCellType gameWorldCellType);

	List<GameWorldCellType> saveGameWorldCellTypes(List<GameWorldCellType> gameWorldCellTypes);

	void deleteGameWorldCellType(GameWorldCellType gameWorldCellType);

	void deleteGameWorldCellTypesByIds(List<Long> ids);

	List<GameWorldCellType> findAllGameWorldCellTypesByExample(GameWorldCellType example);

	GameWorldCellType findGameWorldCellTypeByUniqueName(String uniqueName);

	List<GameWorldCellType> findAllGameWorldCellTypesByGameObjectTypeId(Long gameObjectTypeId);

	List<GameWorldCellType> findAllGameWorldCellTypesByGameObjectTypeIdAndIds(Long gameObjectTypeIds, List<Long> ids);

	void deleteGameWorldCellTypesByGameObjectTypeIdAndIds(Long gameObjectTypeId, List<Long> gameObjectTypeIds);

	void deleteGameWorldCellTypesByGameObjectTypeId(Long gameObjectTypeId);


	List<GameWorld> findAllGameWorlds();

	GameWorld newGameWorld();

	GameWorld newGameWorld(Long id);

	GameWorld findGameWorld(Long id);

	GameWorld saveGameWorld(GameWorld gameWorld);

	List<GameWorld> saveGameWorlds(List<GameWorld> gameWorlds);

	void deleteGameWorld(GameWorld gameWorld);

	void deleteGameWorldsByIds(List<Long> ids);

	List<GameWorld> findAllGameWorldsByExample(GameWorld example);

	GameWorld findGameWorldByUniqueName(String uniqueName);


	List<GameWorldCell> findAllGameWorldCells();

	GameWorldCell newGameWorldCell();

	GameWorldCell newGameWorldCell(Long id);

	GameWorldCell findGameWorldCell(Long id);

	GameWorldCell saveGameWorldCell(GameWorldCell gameWorldCell);

	List<GameWorldCell> saveGameWorldCells(List<GameWorldCell> gameWorldCells);

	void deleteGameWorldCell(GameWorldCell gameWorldCell);

	void deleteGameWorldCellsByIds(List<Long> ids);

	List<GameWorldCell> findAllGameWorldCellsByExample(GameWorldCell example);

	List<GameWorldCell> findAllGameWorldCellsByGameWorldId(Long gameWorldId);

	List<GameWorldCell> findAllGameWorldCellsByGameWorldIdAndIds(Long gameWorldIds, List<Long> ids);

	void deleteGameWorldCellsByGameWorldIdAndIds(Long gameWorldId, List<Long> gameWorldIds);

	void deleteGameWorldCellsByGameWorldId(Long gameWorldId);

	List<GameWorldCell> findAllGameWorldCellsByGameWorldCellTypeId(Long gameWorldCellTypeId);

	List<GameWorldCell> findAllGameWorldCellsByGameWorldCellTypeIdAndIds(Long gameWorldCellTypeIds, List<Long> ids);

	void deleteGameWorldCellsByGameWorldCellTypeIdAndIds(Long gameWorldCellTypeId, List<Long> gameWorldCellTypeIds);

	void deleteGameWorldCellsByGameWorldCellTypeId(Long gameWorldCellTypeId);

	List<GameWorldCell> findAllGameWorldCellsByAttachedGameWorldSpawnPointTypeId(Long attachedGameWorldSpawnPointTypeId);

	List<GameWorldCell> findAllGameWorldCellsByAttachedGameWorldSpawnPointTypeIdAndIds(Long attachedGameWorldSpawnPointTypeIds, List<Long> ids);

	void deleteGameWorldCellsByAttachedGameWorldSpawnPointTypeIdAndIds(Long attachedGameWorldSpawnPointTypeId, List<Long> attachedGameWorldSpawnPointTypeIds);

	void deleteGameWorldCellsByAttachedGameWorldSpawnPointTypeId(Long attachedGameWorldSpawnPointTypeId);

	List<GameWorldCell> findAllGameWorldCellsHavingTargetSmallnumberBetweenXIndexAndYIndex(Integer targetSmallnumber);


	List<GameWorldCellProperty> findAllGameWorldCellProperties();

	GameWorldCellProperty newGameWorldCellProperty();

	GameWorldCellProperty newGameWorldCellProperty(Long id);

	GameWorldCellProperty findGameWorldCellProperty(Long id);

	GameWorldCellProperty saveGameWorldCellProperty(GameWorldCellProperty gameWorldCellProperty);

	List<GameWorldCellProperty> saveGameWorldCellProperties(List<GameWorldCellProperty> gameWorldCellProperties);

	void deleteGameWorldCellProperty(GameWorldCellProperty gameWorldCellProperty);

	void deleteGameWorldCellPropertiesByIds(List<Long> ids);

	List<GameWorldCellProperty> findAllGameWorldCellPropertiesByExample(GameWorldCellProperty example);

	List<GameWorldCellProperty> findAllGameWorldCellPropertiesByGameWorldCellId(Long gameWorldCellId);

	List<GameWorldCellProperty> findAllGameWorldCellPropertiesByGameWorldCellIdAndIds(Long gameWorldCellIds, List<Long> ids);

	void deleteGameWorldCellPropertiesByGameWorldCellIdAndIds(Long gameWorldCellId, List<Long> gameWorldCellIds);

	void deleteGameWorldCellPropertiesByGameWorldCellId(Long gameWorldCellId);

	List<GameWorldCellProperty> findAllGameWorldCellPropertiesByGameObjectTypePropertyId(Long gameObjectTypePropertyId);

	List<GameWorldCellProperty> findAllGameWorldCellPropertiesByGameObjectTypePropertyIdAndIds(Long gameObjectTypePropertyIds, List<Long> ids);

	void deleteGameWorldCellPropertiesByGameObjectTypePropertyIdAndIds(Long gameObjectTypePropertyId, List<Long> gameObjectTypePropertyIds);

	void deleteGameWorldCellPropertiesByGameObjectTypePropertyId(Long gameObjectTypePropertyId);


	List<AutomationObjectProvider> findAllAutomationObjectProviders();

	AutomationObjectProvider newAutomationObjectProvider();

	AutomationObjectProvider newAutomationObjectProvider(Long id);

	AutomationObjectProvider findAutomationObjectProvider(Long id);

	AutomationObjectProvider saveAutomationObjectProvider(AutomationObjectProvider automationObjectProvider);

	List<AutomationObjectProvider> saveAutomationObjectProviders(List<AutomationObjectProvider> automationObjectProviders);

	void deleteAutomationObjectProvider(AutomationObjectProvider automationObjectProvider);

	void deleteAutomationObjectProvidersByIds(List<Long> ids);

	List<AutomationObjectProvider> findAllAutomationObjectProvidersByExample(AutomationObjectProvider example);

	AutomationObjectProvider findAutomationObjectProviderByName(String name);


	List<GameObjectTypeAutomation> findAllGameObjectTypeAutomations();

	GameObjectTypeAutomation newGameObjectTypeAutomation();

	GameObjectTypeAutomation newGameObjectTypeAutomation(Long id);

	GameObjectTypeAutomation findGameObjectTypeAutomation(Long id);

	GameObjectTypeAutomation saveGameObjectTypeAutomation(GameObjectTypeAutomation gameObjectTypeAutomation);

	List<GameObjectTypeAutomation> saveGameObjectTypeAutomations(List<GameObjectTypeAutomation> gameObjectTypeAutomations);

	void deleteGameObjectTypeAutomation(GameObjectTypeAutomation gameObjectTypeAutomation);

	void deleteGameObjectTypeAutomationsByIds(List<Long> ids);

	List<GameObjectTypeAutomation> findAllGameObjectTypeAutomationsByExample(GameObjectTypeAutomation example);

	List<GameObjectTypeAutomation> findAllGameObjectTypeAutomationsByGameObjectTypeId(Long gameObjectTypeId);

	List<GameObjectTypeAutomation> findAllGameObjectTypeAutomationsByGameObjectTypeIdAndIds(Long gameObjectTypeIds, List<Long> ids);

	void deleteGameObjectTypeAutomationsByGameObjectTypeIdAndIds(Long gameObjectTypeId, List<Long> gameObjectTypeIds);

	void deleteGameObjectTypeAutomationsByGameObjectTypeId(Long gameObjectTypeId);

	List<GameObjectTypeAutomation> findAllGameObjectTypeAutomationsByAutomationObjectProviderId(Long automationObjectProviderId);

	List<GameObjectTypeAutomation> findAllGameObjectTypeAutomationsByAutomationObjectProviderIdAndIds(Long automationObjectProviderIds, List<Long> ids);

	void deleteGameObjectTypeAutomationsByAutomationObjectProviderIdAndIds(Long automationObjectProviderId, List<Long> automationObjectProviderIds);

	void deleteGameObjectTypeAutomationsByAutomationObjectProviderId(Long automationObjectProviderId);


	List<Action> findAllActions();

	Action newAction();

	Action newAction(Long id);

	Action findAction(Long id);

	Action saveAction(Action action);

	List<Action> saveActions(List<Action> actions);

	void deleteAction(Action action);

	void deleteActionsByIds(List<Long> ids);

	List<Action> findAllActionsByExample(Action example);

	Action findActionByUniqueName(String uniqueName);


	List<GameObjectTypeStateTransition> findAllGameObjectTypeStateTransitions();

	GameObjectTypeStateTransition newGameObjectTypeStateTransition();

	GameObjectTypeStateTransition newGameObjectTypeStateTransition(Long id);

	GameObjectTypeStateTransition findGameObjectTypeStateTransition(Long id);

	GameObjectTypeStateTransition saveGameObjectTypeStateTransition(GameObjectTypeStateTransition gameObjectTypeStateTransition);

	List<GameObjectTypeStateTransition> saveGameObjectTypeStateTransitions(List<GameObjectTypeStateTransition> gameObjectTypeStateTransitions);

	void deleteGameObjectTypeStateTransition(GameObjectTypeStateTransition gameObjectTypeStateTransition);

	void deleteGameObjectTypeStateTransitionsByIds(List<Long> ids);

	List<GameObjectTypeStateTransition> findAllGameObjectTypeStateTransitionsByExample(GameObjectTypeStateTransition example);

	List<GameObjectTypeStateTransition> findAllGameObjectTypeStateTransitionsBySourceGameObjectTypeStateId(Long sourceGameObjectTypeStateId);

	List<GameObjectTypeStateTransition> findAllGameObjectTypeStateTransitionsBySourceGameObjectTypeStateIdAndIds(Long sourceGameObjectTypeStateIds, List<Long> ids);

	void deleteGameObjectTypeStateTransitionsBySourceGameObjectTypeStateIdAndIds(Long sourceGameObjectTypeStateId, List<Long> sourceGameObjectTypeStateIds);

	void deleteGameObjectTypeStateTransitionsBySourceGameObjectTypeStateId(Long sourceGameObjectTypeStateId);

	List<GameObjectTypeStateTransition> findAllGameObjectTypeStateTransitionsByTargetGameObjectTypeStateId(Long targetGameObjectTypeStateId);

	List<GameObjectTypeStateTransition> findAllGameObjectTypeStateTransitionsByTargetGameObjectTypeStateIdAndIds(Long targetGameObjectTypeStateIds, List<Long> ids);

	void deleteGameObjectTypeStateTransitionsByTargetGameObjectTypeStateIdAndIds(Long targetGameObjectTypeStateId, List<Long> targetGameObjectTypeStateIds);

	void deleteGameObjectTypeStateTransitionsByTargetGameObjectTypeStateId(Long targetGameObjectTypeStateId);

	List<GameObjectTypeStateTransition> findAllGameObjectTypeStateTransitionsByTriggerActionId(Long triggerActionId);

	List<GameObjectTypeStateTransition> findAllGameObjectTypeStateTransitionsByTriggerActionIdAndIds(Long triggerActionIds, List<Long> ids);

	void deleteGameObjectTypeStateTransitionsByTriggerActionIdAndIds(Long triggerActionId, List<Long> triggerActionIds);

	void deleteGameObjectTypeStateTransitionsByTriggerActionId(Long triggerActionId);


	List<GameObjectTypeAllowedAddonType> findAllGameObjectTypeAllowedAddonTypes();

	GameObjectTypeAllowedAddonType newGameObjectTypeAllowedAddonType();

	GameObjectTypeAllowedAddonType newGameObjectTypeAllowedAddonType(Long id);

	GameObjectTypeAllowedAddonType findGameObjectTypeAllowedAddonType(Long id);

	GameObjectTypeAllowedAddonType saveGameObjectTypeAllowedAddonType(GameObjectTypeAllowedAddonType gameObjectTypeAllowedAddonType);

	List<GameObjectTypeAllowedAddonType> saveGameObjectTypeAllowedAddonTypes(List<GameObjectTypeAllowedAddonType> gameObjectTypeAllowedAddonTypes);

	void deleteGameObjectTypeAllowedAddonType(GameObjectTypeAllowedAddonType gameObjectTypeAllowedAddonType);

	void deleteGameObjectTypeAllowedAddonTypesByIds(List<Long> ids);

	List<GameObjectTypeAllowedAddonType> findAllGameObjectTypeAllowedAddonTypesByExample(GameObjectTypeAllowedAddonType example);

	GameObjectTypeAllowedAddonType findGameObjectTypeAllowedAddonTypeByUniqueName(String uniqueName);

	List<GameObjectTypeAllowedAddonType> findAllGameObjectTypeAllowedAddonTypesByAddonGameObjectTypeId(Long addonGameObjectTypeId);

	List<GameObjectTypeAllowedAddonType> findAllGameObjectTypeAllowedAddonTypesByAddonGameObjectTypeIdAndIds(Long addonGameObjectTypeIds, List<Long> ids);

	void deleteGameObjectTypeAllowedAddonTypesByAddonGameObjectTypeIdAndIds(Long addonGameObjectTypeId, List<Long> addonGameObjectTypeIds);

	void deleteGameObjectTypeAllowedAddonTypesByAddonGameObjectTypeId(Long addonGameObjectTypeId);

	List<GameObjectTypeAllowedAddonType> findAllGameObjectTypeAllowedAddonTypesByApplicableToGameObjectTypeId(Long applicableToGameObjectTypeId);

	List<GameObjectTypeAllowedAddonType> findAllGameObjectTypeAllowedAddonTypesByApplicableToGameObjectTypeIdAndIds(Long applicableToGameObjectTypeIds, List<Long> ids);

	void deleteGameObjectTypeAllowedAddonTypesByApplicableToGameObjectTypeIdAndIds(Long applicableToGameObjectTypeId, List<Long> applicableToGameObjectTypeIds);

	void deleteGameObjectTypeAllowedAddonTypesByApplicableToGameObjectTypeId(Long applicableToGameObjectTypeId);

	List<GameObjectTypeAllowedAddonType> findAllGameObjectTypeAllowedAddonTypesByTriggerActionId(Long triggerActionId);

	List<GameObjectTypeAllowedAddonType> findAllGameObjectTypeAllowedAddonTypesByTriggerActionIdAndIds(Long triggerActionIds, List<Long> ids);

	void deleteGameObjectTypeAllowedAddonTypesByTriggerActionIdAndIds(Long triggerActionId, List<Long> triggerActionIds);

	void deleteGameObjectTypeAllowedAddonTypesByTriggerActionId(Long triggerActionId);

	List<GameObjectTypeAllowedAddonType> findAllGameObjectTypeAllowedAddonTypesBySpawnableGameObjectTypeId(Long spawnableGameObjectTypeId);

	List<GameObjectTypeAllowedAddonType> findAllGameObjectTypeAllowedAddonTypesBySpawnableGameObjectTypeIdAndIds(Long spawnableGameObjectTypeIds, List<Long> ids);

	void deleteGameObjectTypeAllowedAddonTypesBySpawnableGameObjectTypeIdAndIds(Long spawnableGameObjectTypeId, List<Long> spawnableGameObjectTypeIds);

	void deleteGameObjectTypeAllowedAddonTypesBySpawnableGameObjectTypeId(Long spawnableGameObjectTypeId);


	List<GameAddonInteractionReceivingPropertyModifier> findAllGameAddonInteractionReceivingPropertyModifiers();

	GameAddonInteractionReceivingPropertyModifier newGameAddonInteractionReceivingPropertyModifier();

	GameAddonInteractionReceivingPropertyModifier newGameAddonInteractionReceivingPropertyModifier(Long id);

	GameAddonInteractionReceivingPropertyModifier findGameAddonInteractionReceivingPropertyModifier(Long id);

	GameAddonInteractionReceivingPropertyModifier saveGameAddonInteractionReceivingPropertyModifier(GameAddonInteractionReceivingPropertyModifier gameAddonInteractionReceivingPropertyModifier);

	List<GameAddonInteractionReceivingPropertyModifier> saveGameAddonInteractionReceivingPropertyModifiers(List<GameAddonInteractionReceivingPropertyModifier> gameAddonInteractionReceivingPropertyModifiers);

	void deleteGameAddonInteractionReceivingPropertyModifier(GameAddonInteractionReceivingPropertyModifier gameAddonInteractionReceivingPropertyModifier);

	void deleteGameAddonInteractionReceivingPropertyModifiersByIds(List<Long> ids);

	List<GameAddonInteractionReceivingPropertyModifier> findAllGameAddonInteractionReceivingPropertyModifiersByExample(GameAddonInteractionReceivingPropertyModifier example);

	List<GameAddonInteractionReceivingPropertyModifier> findAllGameAddonInteractionReceivingPropertyModifiersByGameObjectTypeAllowedAddonTypeId(Long gameObjectTypeAllowedAddonTypeId);

	List<GameAddonInteractionReceivingPropertyModifier> findAllGameAddonInteractionReceivingPropertyModifiersByGameObjectTypeAllowedAddonTypeIdAndIds(Long gameObjectTypeAllowedAddonTypeIds, List<Long> ids);

	void deleteGameAddonInteractionReceivingPropertyModifiersByGameObjectTypeAllowedAddonTypeIdAndIds(Long gameObjectTypeAllowedAddonTypeId, List<Long> gameObjectTypeAllowedAddonTypeIds);

	void deleteGameAddonInteractionReceivingPropertyModifiersByGameObjectTypeAllowedAddonTypeId(Long gameObjectTypeAllowedAddonTypeId);

	List<GameAddonInteractionReceivingPropertyModifier> findAllGameAddonInteractionReceivingPropertyModifiersByAffectedGameObjectTypePropertyId(Long affectedGameObjectTypePropertyId);

	List<GameAddonInteractionReceivingPropertyModifier> findAllGameAddonInteractionReceivingPropertyModifiersByAffectedGameObjectTypePropertyIdAndIds(Long affectedGameObjectTypePropertyIds, List<Long> ids);

	void deleteGameAddonInteractionReceivingPropertyModifiersByAffectedGameObjectTypePropertyIdAndIds(Long affectedGameObjectTypePropertyId, List<Long> affectedGameObjectTypePropertyIds);

	void deleteGameAddonInteractionReceivingPropertyModifiersByAffectedGameObjectTypePropertyId(Long affectedGameObjectTypePropertyId);


	List<GameObjectTypeInteraction> findAllGameObjectTypeInteractions();

	GameObjectTypeInteraction newGameObjectTypeInteraction();

	GameObjectTypeInteraction newGameObjectTypeInteraction(Long id);

	GameObjectTypeInteraction findGameObjectTypeInteraction(Long id);

	GameObjectTypeInteraction saveGameObjectTypeInteraction(GameObjectTypeInteraction gameObjectTypeInteraction);

	List<GameObjectTypeInteraction> saveGameObjectTypeInteractions(List<GameObjectTypeInteraction> gameObjectTypeInteractions);

	void deleteGameObjectTypeInteraction(GameObjectTypeInteraction gameObjectTypeInteraction);

	void deleteGameObjectTypeInteractionsByIds(List<Long> ids);

	List<GameObjectTypeInteraction> findAllGameObjectTypeInteractionsByExample(GameObjectTypeInteraction example);

	List<GameObjectTypeInteraction> findAllGameObjectTypeInteractionsByDonatingGameObjectTypeId(Long donatingGameObjectTypeId);

	List<GameObjectTypeInteraction> findAllGameObjectTypeInteractionsByDonatingGameObjectTypeIdAndIds(Long donatingGameObjectTypeIds, List<Long> ids);

	void deleteGameObjectTypeInteractionsByDonatingGameObjectTypeIdAndIds(Long donatingGameObjectTypeId, List<Long> donatingGameObjectTypeIds);

	void deleteGameObjectTypeInteractionsByDonatingGameObjectTypeId(Long donatingGameObjectTypeId);

	List<GameObjectTypeInteraction> findAllGameObjectTypeInteractionsByReceivingGameObjectTypeId(Long receivingGameObjectTypeId);

	List<GameObjectTypeInteraction> findAllGameObjectTypeInteractionsByReceivingGameObjectTypeIdAndIds(Long receivingGameObjectTypeIds, List<Long> ids);

	void deleteGameObjectTypeInteractionsByReceivingGameObjectTypeIdAndIds(Long receivingGameObjectTypeId, List<Long> receivingGameObjectTypeIds);

	void deleteGameObjectTypeInteractionsByReceivingGameObjectTypeId(Long receivingGameObjectTypeId);


	List<GameObjectTypeInteractionProperty> findAllGameObjectTypeInteractionProperties();

	GameObjectTypeInteractionProperty newGameObjectTypeInteractionProperty();

	GameObjectTypeInteractionProperty newGameObjectTypeInteractionProperty(Long id);

	GameObjectTypeInteractionProperty findGameObjectTypeInteractionProperty(Long id);

	GameObjectTypeInteractionProperty saveGameObjectTypeInteractionProperty(GameObjectTypeInteractionProperty gameObjectTypeInteractionProperty);

	List<GameObjectTypeInteractionProperty> saveGameObjectTypeInteractionProperties(List<GameObjectTypeInteractionProperty> gameObjectTypeInteractionProperties);

	void deleteGameObjectTypeInteractionProperty(GameObjectTypeInteractionProperty gameObjectTypeInteractionProperty);

	void deleteGameObjectTypeInteractionPropertiesByIds(List<Long> ids);

	List<GameObjectTypeInteractionProperty> findAllGameObjectTypeInteractionPropertiesByExample(GameObjectTypeInteractionProperty example);

	List<GameObjectTypeInteractionProperty> findAllGameObjectTypeInteractionPropertiesByGameObjectTypeInteractionId(Long gameObjectTypeInteractionId);

	List<GameObjectTypeInteractionProperty> findAllGameObjectTypeInteractionPropertiesByGameObjectTypeInteractionIdAndIds(Long gameObjectTypeInteractionIds, List<Long> ids);

	void deleteGameObjectTypeInteractionPropertiesByGameObjectTypeInteractionIdAndIds(Long gameObjectTypeInteractionId, List<Long> gameObjectTypeInteractionIds);

	void deleteGameObjectTypeInteractionPropertiesByGameObjectTypeInteractionId(Long gameObjectTypeInteractionId);

	List<GameObjectTypeInteractionProperty> findAllGameObjectTypeInteractionPropertiesByDonatingGameObjectTypePropertyId(Long donatingGameObjectTypePropertyId);

	List<GameObjectTypeInteractionProperty> findAllGameObjectTypeInteractionPropertiesByDonatingGameObjectTypePropertyIdAndIds(Long donatingGameObjectTypePropertyIds, List<Long> ids);

	void deleteGameObjectTypeInteractionPropertiesByDonatingGameObjectTypePropertyIdAndIds(Long donatingGameObjectTypePropertyId, List<Long> donatingGameObjectTypePropertyIds);

	void deleteGameObjectTypeInteractionPropertiesByDonatingGameObjectTypePropertyId(Long donatingGameObjectTypePropertyId);

	List<GameObjectTypeInteractionProperty> findAllGameObjectTypeInteractionPropertiesByReceivingGameObjectTypePropertyId(Long receivingGameObjectTypePropertyId);

	List<GameObjectTypeInteractionProperty> findAllGameObjectTypeInteractionPropertiesByReceivingGameObjectTypePropertyIdAndIds(Long receivingGameObjectTypePropertyIds, List<Long> ids);

	void deleteGameObjectTypeInteractionPropertiesByReceivingGameObjectTypePropertyIdAndIds(Long receivingGameObjectTypePropertyId, List<Long> receivingGameObjectTypePropertyIds);

	void deleteGameObjectTypeInteractionPropertiesByReceivingGameObjectTypePropertyId(Long receivingGameObjectTypePropertyId);

	List<GameObjectTypeInteractionProperty> findAllGameObjectTypeInteractionPropertiesByOverflowGameObjectTypePropertyId(Long overflowGameObjectTypePropertyId);

	List<GameObjectTypeInteractionProperty> findAllGameObjectTypeInteractionPropertiesByOverflowGameObjectTypePropertyIdAndIds(Long overflowGameObjectTypePropertyIds, List<Long> ids);

	void deleteGameObjectTypeInteractionPropertiesByOverflowGameObjectTypePropertyIdAndIds(Long overflowGameObjectTypePropertyId, List<Long> overflowGameObjectTypePropertyIds);

	void deleteGameObjectTypeInteractionPropertiesByOverflowGameObjectTypePropertyId(Long overflowGameObjectTypePropertyId);


	List<GameClientType> findAllGameClientTypes();

	GameClientType newGameClientType();

	GameClientType newGameClientType(Long id);

	GameClientType findGameClientType(Long id);

	GameClientType saveGameClientType(GameClientType gameClientType);

	List<GameClientType> saveGameClientTypes(List<GameClientType> gameClientTypes);

	void deleteGameClientType(GameClientType gameClientType);

	void deleteGameClientTypesByIds(List<Long> ids);

	List<GameClientType> findAllGameClientTypesByExample(GameClientType example);

	GameClientType findGameClientTypeByUniqueName(String uniqueName);


	List<GameObjectTypeRepresentation> findAllGameObjectTypeRepresentations();

	GameObjectTypeRepresentation newGameObjectTypeRepresentation();

	GameObjectTypeRepresentation newGameObjectTypeRepresentation(Long id);

	GameObjectTypeRepresentation findGameObjectTypeRepresentation(Long id);

	GameObjectTypeRepresentation saveGameObjectTypeRepresentation(GameObjectTypeRepresentation gameObjectTypeRepresentation);

	List<GameObjectTypeRepresentation> saveGameObjectTypeRepresentations(List<GameObjectTypeRepresentation> gameObjectTypeRepresentations);

	void deleteGameObjectTypeRepresentation(GameObjectTypeRepresentation gameObjectTypeRepresentation);

	void deleteGameObjectTypeRepresentationsByIds(List<Long> ids);

	List<GameObjectTypeRepresentation> findAllGameObjectTypeRepresentationsByExample(GameObjectTypeRepresentation example);

	List<GameObjectTypeRepresentation> findAllGameObjectTypeRepresentationsByGameObjectTypeId(Long gameObjectTypeId);

	List<GameObjectTypeRepresentation> findAllGameObjectTypeRepresentationsByGameObjectTypeIdAndIds(Long gameObjectTypeIds, List<Long> ids);

	void deleteGameObjectTypeRepresentationsByGameObjectTypeIdAndIds(Long gameObjectTypeId, List<Long> gameObjectTypeIds);

	void deleteGameObjectTypeRepresentationsByGameObjectTypeId(Long gameObjectTypeId);

	List<GameObjectTypeRepresentation> findAllGameObjectTypeRepresentationsByGameClientTypeId(Long gameClientTypeId);

	List<GameObjectTypeRepresentation> findAllGameObjectTypeRepresentationsByGameClientTypeIdAndIds(Long gameClientTypeIds, List<Long> ids);

	void deleteGameObjectTypeRepresentationsByGameClientTypeIdAndIds(Long gameClientTypeId, List<Long> gameClientTypeIds);

	void deleteGameObjectTypeRepresentationsByGameClientTypeId(Long gameClientTypeId);


	List<GameObjectTypeState> findAllGameObjectTypeStates();

	GameObjectTypeState newGameObjectTypeState();

	GameObjectTypeState newGameObjectTypeState(Long id);

	GameObjectTypeState findGameObjectTypeState(Long id);

	GameObjectTypeState saveGameObjectTypeState(GameObjectTypeState gameObjectTypeState);

	List<GameObjectTypeState> saveGameObjectTypeStates(List<GameObjectTypeState> gameObjectTypeStates);

	void deleteGameObjectTypeState(GameObjectTypeState gameObjectTypeState);

	void deleteGameObjectTypeStatesByIds(List<Long> ids);

	List<GameObjectTypeState> findAllGameObjectTypeStatesByExample(GameObjectTypeState example);

	List<GameObjectTypeState> findAllGameObjectTypeStatesByGameObjectTypeId(Long gameObjectTypeId);

	List<GameObjectTypeState> findAllGameObjectTypeStatesByGameObjectTypeIdAndIds(Long gameObjectTypeIds, List<Long> ids);

	void deleteGameObjectTypeStatesByGameObjectTypeIdAndIds(Long gameObjectTypeId, List<Long> gameObjectTypeIds);

	void deleteGameObjectTypeStatesByGameObjectTypeId(Long gameObjectTypeId);

	GameObjectTypeState findGameObjectTypeStateByName(String name);


	List<GameObjectTypeStatePropertyModifier> findAllGameObjectTypeStatePropertyModifiers();

	GameObjectTypeStatePropertyModifier newGameObjectTypeStatePropertyModifier();

	GameObjectTypeStatePropertyModifier newGameObjectTypeStatePropertyModifier(Long id);

	GameObjectTypeStatePropertyModifier findGameObjectTypeStatePropertyModifier(Long id);

	GameObjectTypeStatePropertyModifier saveGameObjectTypeStatePropertyModifier(GameObjectTypeStatePropertyModifier gameObjectTypeStatePropertyModifier);

	List<GameObjectTypeStatePropertyModifier> saveGameObjectTypeStatePropertyModifiers(List<GameObjectTypeStatePropertyModifier> gameObjectTypeStatePropertyModifiers);

	void deleteGameObjectTypeStatePropertyModifier(GameObjectTypeStatePropertyModifier gameObjectTypeStatePropertyModifier);

	void deleteGameObjectTypeStatePropertyModifiersByIds(List<Long> ids);

	List<GameObjectTypeStatePropertyModifier> findAllGameObjectTypeStatePropertyModifiersByExample(GameObjectTypeStatePropertyModifier example);

	List<GameObjectTypeStatePropertyModifier> findAllGameObjectTypeStatePropertyModifiersByGameObjectTypeStateId(Long gameObjectTypeStateId);

	List<GameObjectTypeStatePropertyModifier> findAllGameObjectTypeStatePropertyModifiersByGameObjectTypeStateIdAndIds(Long gameObjectTypeStateIds, List<Long> ids);

	void deleteGameObjectTypeStatePropertyModifiersByGameObjectTypeStateIdAndIds(Long gameObjectTypeStateId, List<Long> gameObjectTypeStateIds);

	void deleteGameObjectTypeStatePropertyModifiersByGameObjectTypeStateId(Long gameObjectTypeStateId);

	List<GameObjectTypeStatePropertyModifier> findAllGameObjectTypeStatePropertyModifiersByGameObjectTypePropertyId(Long gameObjectTypePropertyId);

	List<GameObjectTypeStatePropertyModifier> findAllGameObjectTypeStatePropertyModifiersByGameObjectTypePropertyIdAndIds(Long gameObjectTypePropertyIds, List<Long> ids);

	void deleteGameObjectTypeStatePropertyModifiersByGameObjectTypePropertyIdAndIds(Long gameObjectTypePropertyId, List<Long> gameObjectTypePropertyIds);

	void deleteGameObjectTypeStatePropertyModifiersByGameObjectTypePropertyId(Long gameObjectTypePropertyId);


	List<GameObjectTypeClass> findAllGameObjectTypeClasses();

	GameObjectTypeClass newGameObjectTypeClass();

	GameObjectTypeClass newGameObjectTypeClass(Long id);

	GameObjectTypeClass findGameObjectTypeClass(Long id);

	GameObjectTypeClass saveGameObjectTypeClass(GameObjectTypeClass gameObjectTypeClass);

	List<GameObjectTypeClass> saveGameObjectTypeClasses(List<GameObjectTypeClass> gameObjectTypeClasses);

	void deleteGameObjectTypeClass(GameObjectTypeClass gameObjectTypeClass);

	void deleteGameObjectTypeClassesByIds(List<Long> ids);

	List<GameObjectTypeClass> findAllGameObjectTypeClassesByExample(GameObjectTypeClass example);

	GameObjectTypeClass findGameObjectTypeClassByName(String name);


	List<GameAssetsRepository> findAllGameAssetsRepositories();

	GameAssetsRepository newGameAssetsRepository();

	GameAssetsRepository newGameAssetsRepository(Long id);

	GameAssetsRepository findGameAssetsRepository(Long id);

	GameAssetsRepository saveGameAssetsRepository(GameAssetsRepository gameAssetsRepository);

	List<GameAssetsRepository> saveGameAssetsRepositories(List<GameAssetsRepository> gameAssetsRepositories);

	void deleteGameAssetsRepository(GameAssetsRepository gameAssetsRepository);

	void deleteGameAssetsRepositoriesByIds(List<Long> ids);

	List<GameAssetsRepository> findAllGameAssetsRepositoriesByExample(GameAssetsRepository example);

	GameAssetsRepository findGameAssetsRepositoryByUniqueName(String uniqueName);


	List<GameObjectType> findAllGameObjectTypes();

	GameObjectType newGameObjectType();

	GameObjectType newGameObjectType(Long id);

	GameObjectType findGameObjectType(Long id);

	GameObjectType saveGameObjectType(GameObjectType gameObjectType);

	List<GameObjectType> saveGameObjectTypes(List<GameObjectType> gameObjectTypes);

	void deleteGameObjectType(GameObjectType gameObjectType);

	void deleteGameObjectTypesByIds(List<Long> ids);

	List<GameObjectType> findAllGameObjectTypesByExample(GameObjectType example);

	List<GameObjectType> findAllGameObjectTypesByGameAssetsRepositoryId(Long gameAssetsRepositoryId);

	List<GameObjectType> findAllGameObjectTypesByGameAssetsRepositoryIdAndIds(Long gameAssetsRepositoryIds, List<Long> ids);

	void deleteGameObjectTypesByGameAssetsRepositoryIdAndIds(Long gameAssetsRepositoryId, List<Long> gameAssetsRepositoryIds);

	void deleteGameObjectTypesByGameAssetsRepositoryId(Long gameAssetsRepositoryId);

	List<GameObjectType> findAllGameObjectTypesByGameObjectTypeClassId(Long gameObjectTypeClassId);

	List<GameObjectType> findAllGameObjectTypesByGameObjectTypeClassIdAndIds(Long gameObjectTypeClassIds, List<Long> ids);

	void deleteGameObjectTypesByGameObjectTypeClassIdAndIds(Long gameObjectTypeClassId, List<Long> gameObjectTypeClassIds);

	void deleteGameObjectTypesByGameObjectTypeClassId(Long gameObjectTypeClassId);

	GameObjectType findGameObjectTypeByUniqueName(String uniqueName);


	List<GameObjectTypeProperty> findAllGameObjectTypeProperties();

	GameObjectTypeProperty newGameObjectTypeProperty();

	GameObjectTypeProperty newGameObjectTypeProperty(Long id);

	GameObjectTypeProperty findGameObjectTypeProperty(Long id);

	GameObjectTypeProperty saveGameObjectTypeProperty(GameObjectTypeProperty gameObjectTypeProperty);

	List<GameObjectTypeProperty> saveGameObjectTypeProperties(List<GameObjectTypeProperty> gameObjectTypeProperties);

	void deleteGameObjectTypeProperty(GameObjectTypeProperty gameObjectTypeProperty);

	void deleteGameObjectTypePropertiesByIds(List<Long> ids);

	List<GameObjectTypeProperty> findAllGameObjectTypePropertiesByExample(GameObjectTypeProperty example);

	List<GameObjectTypeProperty> findAllGameObjectTypePropertiesByGameObjectTypeId(Long gameObjectTypeId);

	List<GameObjectTypeProperty> findAllGameObjectTypePropertiesByGameObjectTypeIdAndIds(Long gameObjectTypeIds, List<Long> ids);

	void deleteGameObjectTypePropertiesByGameObjectTypeIdAndIds(Long gameObjectTypeId, List<Long> gameObjectTypeIds);

	void deleteGameObjectTypePropertiesByGameObjectTypeId(Long gameObjectTypeId);

	GameObjectTypeProperty findGameObjectTypePropertyByPropertyName(String propertyName);


	List<GameAssetsRepositoryOwner> findAllGameAssetsRepositoryOwners();

	GameAssetsRepositoryOwner newGameAssetsRepositoryOwner();

	GameAssetsRepositoryOwner newGameAssetsRepositoryOwner(Long id);

	GameAssetsRepositoryOwner findGameAssetsRepositoryOwner(Long id);

	GameAssetsRepositoryOwner saveGameAssetsRepositoryOwner(GameAssetsRepositoryOwner gameAssetsRepositoryOwner);

	List<GameAssetsRepositoryOwner> saveGameAssetsRepositoryOwners(List<GameAssetsRepositoryOwner> gameAssetsRepositoryOwners);

	void deleteGameAssetsRepositoryOwner(GameAssetsRepositoryOwner gameAssetsRepositoryOwner);

	void deleteGameAssetsRepositoryOwnersByIds(List<Long> ids);

	List<GameAssetsRepositoryOwner> findAllGameAssetsRepositoryOwnersByExample(GameAssetsRepositoryOwner example);

	List<GameAssetsRepositoryOwner> findAllGameAssetsRepositoryOwnersByGameAssetsRepositoryId(Long gameAssetsRepositoryId);

	List<GameAssetsRepositoryOwner> findAllGameAssetsRepositoryOwnersByGameAssetsRepositoryIdAndIds(Long gameAssetsRepositoryIds, List<Long> ids);

	void deleteGameAssetsRepositoryOwnersByGameAssetsRepositoryIdAndIds(Long gameAssetsRepositoryId, List<Long> gameAssetsRepositoryIds);

	void deleteGameAssetsRepositoryOwnersByGameAssetsRepositoryId(Long gameAssetsRepositoryId);


	List<GameAssetsRepositoryPicture> findAllGameAssetsRepositoryPictures();

	GameAssetsRepositoryPicture newGameAssetsRepositoryPicture();

	GameAssetsRepositoryPicture newGameAssetsRepositoryPicture(Long id);

	GameAssetsRepositoryPicture findGameAssetsRepositoryPicture(Long id);

	GameAssetsRepositoryPicture saveGameAssetsRepositoryPicture(GameAssetsRepositoryPicture gameAssetsRepositoryPicture);

	List<GameAssetsRepositoryPicture> saveGameAssetsRepositoryPictures(List<GameAssetsRepositoryPicture> gameAssetsRepositoryPictures);

	void deleteGameAssetsRepositoryPicture(GameAssetsRepositoryPicture gameAssetsRepositoryPicture);

	void deleteGameAssetsRepositoryPicturesByIds(List<Long> ids);

	List<GameAssetsRepositoryPicture> findAllGameAssetsRepositoryPicturesByExample(GameAssetsRepositoryPicture example);

	List<GameAssetsRepositoryPicture> findAllGameAssetsRepositoryPicturesByGameAssetsRepositoryId(Long gameAssetsRepositoryId);

	List<GameAssetsRepositoryPicture> findAllGameAssetsRepositoryPicturesByGameAssetsRepositoryIdAndIds(Long gameAssetsRepositoryIds, List<Long> ids);

	void deleteGameAssetsRepositoryPicturesByGameAssetsRepositoryIdAndIds(Long gameAssetsRepositoryId, List<Long> gameAssetsRepositoryIds);

	void deleteGameAssetsRepositoryPicturesByGameAssetsRepositoryId(Long gameAssetsRepositoryId);

	GameAssetsRepositoryOwner findGameAssetsRepositoryOwnerByGameAssetsRepositoryIdAndOwnerId(Long repoId, Long userId);

	GameAssetsRepositoryOwner newGameAssetsRepositoryOwner(Long repId, Long ownerId);
}
