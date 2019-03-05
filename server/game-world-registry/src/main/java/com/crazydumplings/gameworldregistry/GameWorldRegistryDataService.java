package com.crazydumplings.gameworldregistry;

import java.util.List;

import com.crazydumplings.gameworldregistry.exception.GameWorldRegistryDataServiceException;
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
 * Any implementation of this interface can be injected into the {@link GameWorldRegistryService} to provide persistence to various media
 */
public interface GameWorldRegistryDataService {
    List<PlayableCharacterType> findAllPlayableCharacterTypes();

    PlayableCharacterType newPlayableCharacterType() throws GameWorldRegistryDataServiceException;

    PlayableCharacterType findPlayableCharacterType(Long id) throws GameWorldRegistryDataServiceException;

    PlayableCharacterType savePlayableCharacterType(PlayableCharacterType playableCharacterType) throws GameWorldRegistryDataServiceException;

    void deletePlayableCharacterType(PlayableCharacterType playableCharacterType) throws GameWorldRegistryDataServiceException;

    List<PlayableCharacterType> findAllPlayableCharacterTypesByExample(PlayableCharacterType example)
            throws GameWorldRegistryDataServiceException;

    PlayableCharacterType findPlayableCharacterTypeByUniqueCharacterTypeName(String uniqueCharacterTypeName)
            throws GameWorldRegistryDataServiceException;

    List<PlayableCharacterType> findAllPlayableCharacterTypesByGameObjectType(GameObjectType gameObjectType)
            throws GameWorldRegistryDataServiceException;

    List<PlayableCharacterType> findAllPlayableCharacterTypesByAnyTextFieldContaining(String content)
            throws GameWorldRegistryDataServiceException;

    List<GameWorldSpawnPointType> findAllGameWorldSpawnPointTypes() throws GameWorldRegistryDataServiceException;

    GameWorldSpawnPointType newGameWorldSpawnPointType() throws GameWorldRegistryDataServiceException;

    GameWorldSpawnPointType findGameWorldSpawnPointType(Long id) throws GameWorldRegistryDataServiceException;

    GameWorldSpawnPointType saveGameWorldSpawnPointType(GameWorldSpawnPointType gameWorldSpawnPointType)
            throws GameWorldRegistryDataServiceException;

    void deleteGameWorldSpawnPointType(GameWorldSpawnPointType gameWorldSpawnPointType) throws GameWorldRegistryDataServiceException;

    List<GameWorldSpawnPointType> findAllGameWorldSpawnPointTypesByExample(GameWorldSpawnPointType example)
            throws GameWorldRegistryDataServiceException;

    List<GameWorldSpawnPointType> findAllGameWorldSpawnPointTypesBySpawnPointGameObjectType(GameObjectType spawnPointGameObjectType)
            throws GameWorldRegistryDataServiceException;

    List<GameWorldSpawnPointType> findAllGameWorldSpawnPointTypesBySpawnedGameObjectType(GameObjectType spawnedGameObjectType)
            throws GameWorldRegistryDataServiceException;

    List<GameWorldSpawnPointType> findAllGameWorldSpawnPointTypesByAnyTextFieldContaining(String content)
            throws GameWorldRegistryDataServiceException;

    List<GameWorldCellType> findAllGameWorldCellTypes() throws GameWorldRegistryDataServiceException;

    GameWorldCellType newGameWorldCellType() throws GameWorldRegistryDataServiceException;

    GameWorldCellType findGameWorldCellType(Long id) throws GameWorldRegistryDataServiceException;

    GameWorldCellType saveGameWorldCellType(GameWorldCellType gameWorldCellType) throws GameWorldRegistryDataServiceException;

    void deleteGameWorldCellType(GameWorldCellType gameWorldCellType) throws GameWorldRegistryDataServiceException;

    List<GameWorldCellType> findAllGameWorldCellTypesByExample(GameWorldCellType example) throws GameWorldRegistryDataServiceException;

    GameWorldCellType findGameWorldCellTypeByUniqueName(String uniqueName) throws GameWorldRegistryDataServiceException;

    List<GameWorldCellType> findAllGameWorldCellTypesByGameObjectType(GameObjectType gameObjectType)
            throws GameWorldRegistryDataServiceException;

    List<GameWorldCellType> findAllGameWorldCellTypesByAnyTextFieldContaining(String content) throws GameWorldRegistryDataServiceException;

    List<GameWorld> findAllGameWorlds() throws GameWorldRegistryDataServiceException;

    GameWorld newGameWorld() throws GameWorldRegistryDataServiceException;

    GameWorld findGameWorld(Long id) throws GameWorldRegistryDataServiceException;

    GameWorld saveGameWorld(GameWorld gameWorld) throws GameWorldRegistryDataServiceException;

    void deleteGameWorld(GameWorld gameWorld) throws GameWorldRegistryDataServiceException;

    List<GameWorld> findAllGameWorldsByExample(GameWorld example) throws GameWorldRegistryDataServiceException;

    GameWorld findGameWorldByUniqueName(String uniqueName) throws GameWorldRegistryDataServiceException;

    List<GameWorld> findAllGameWorldsByAnyTextFieldContaining(String content) throws GameWorldRegistryDataServiceException;

    List<GameWorldCell> findAllGameWorldCells() throws GameWorldRegistryDataServiceException;

    GameWorldCell newGameWorldCell() throws GameWorldRegistryDataServiceException;

    GameWorldCell findGameWorldCell(Long id) throws GameWorldRegistryDataServiceException;

    GameWorldCell saveGameWorldCell(GameWorldCell gameWorldCell) throws GameWorldRegistryDataServiceException;

    void deleteGameWorldCell(GameWorldCell gameWorldCell) throws GameWorldRegistryDataServiceException;

    List<GameWorldCell> findAllGameWorldCellsByExample(GameWorldCell example) throws GameWorldRegistryDataServiceException;

    List<GameWorldCell> findAllGameWorldCellsByGameWorld(GameWorld gameWorld) throws GameWorldRegistryDataServiceException;

    List<GameWorldCell> findAllGameWorldCellsByGameWorldCellType(GameWorldCellType gameWorldCellType)
            throws GameWorldRegistryDataServiceException;

    List<GameWorldCell> findAllGameWorldCellsByAttachedGameWorldSpawnPointType(GameWorldSpawnPointType attachedGameWorldSpawnPointType)
            throws GameWorldRegistryDataServiceException;

    List<GameWorldCell> findAllGameWorldCellsHavingTargetSmallnumberBetweenXIndexAndYIndex(Integer targetSmallnumber)
            throws GameWorldRegistryDataServiceException;

    List<GameWorldCell> findAllGameWorldCellsByAnyTextFieldContaining(String content) throws GameWorldRegistryDataServiceException;

    List<GameWorldCellProperty> findAllGameWorldCellProperties() throws GameWorldRegistryDataServiceException;

    GameWorldCellProperty newGameWorldCellProperty() throws GameWorldRegistryDataServiceException;

    GameWorldCellProperty findGameWorldCellProperty(Long id) throws GameWorldRegistryDataServiceException;

    GameWorldCellProperty saveGameWorldCellProperty(GameWorldCellProperty gameWorldCellProperty) throws GameWorldRegistryDataServiceException;

    void deleteGameWorldCellProperty(GameWorldCellProperty gameWorldCellProperty) throws GameWorldRegistryDataServiceException;

    List<GameWorldCellProperty> findAllGameWorldCellPropertiesByExample(GameWorldCellProperty example)
            throws GameWorldRegistryDataServiceException;

    List<GameWorldCellProperty> findAllGameWorldCellPropertiesByGameWorldCell(GameWorldCell gameWorldCell)
            throws GameWorldRegistryDataServiceException;

    List<GameWorldCellProperty> findAllGameWorldCellPropertiesByGameObjectTypeProperty(GameObjectTypeProperty gameObjectTypeProperty)
            throws GameWorldRegistryDataServiceException;

    List<GameWorldCellProperty> findAllGameWorldCellPropertiesByAnyTextFieldContaining(String content)
            throws GameWorldRegistryDataServiceException;

    List<AutomationObjectProvider> findAllAutomationObjectProviders() throws GameWorldRegistryDataServiceException;

    AutomationObjectProvider newAutomationObjectProvider() throws GameWorldRegistryDataServiceException;

    AutomationObjectProvider findAutomationObjectProvider(Long id) throws GameWorldRegistryDataServiceException;

    AutomationObjectProvider saveAutomationObjectProvider(AutomationObjectProvider automationObjectProvider)
            throws GameWorldRegistryDataServiceException;

    void deleteAutomationObjectProvider(AutomationObjectProvider automationObjectProvider) throws GameWorldRegistryDataServiceException;

    List<AutomationObjectProvider> findAllAutomationObjectProvidersByExample(AutomationObjectProvider example)
            throws GameWorldRegistryDataServiceException;

    AutomationObjectProvider findAutomationObjectProviderByName(String name) throws GameWorldRegistryDataServiceException;

    List<AutomationObjectProvider> findAllAutomationObjectProvidersByAnyTextFieldContaining(String content)
            throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeAutomation> findAllGameObjectTypeAutomations() throws GameWorldRegistryDataServiceException;

    GameObjectTypeAutomation newGameObjectTypeAutomation() throws GameWorldRegistryDataServiceException;

    GameObjectTypeAutomation findGameObjectTypeAutomation(Long id) throws GameWorldRegistryDataServiceException;

    GameObjectTypeAutomation saveGameObjectTypeAutomation(GameObjectTypeAutomation gameObjectTypeAutomation)
            throws GameWorldRegistryDataServiceException;

    void deleteGameObjectTypeAutomation(GameObjectTypeAutomation gameObjectTypeAutomation) throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeAutomation> findAllGameObjectTypeAutomationsByExample(GameObjectTypeAutomation example)
            throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeAutomation> findAllGameObjectTypeAutomationsByGameObjectType(GameObjectType gameObjectType)
            throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeAutomation> findAllGameObjectTypeAutomationsByAutomationObjectProvider(AutomationObjectProvider automationObjectProvider)
            throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeAutomation> findAllGameObjectTypeAutomationsByAnyTextFieldContaining(String content)
            throws GameWorldRegistryDataServiceException;

    List<Action> findAllActions() throws GameWorldRegistryDataServiceException;

    Action newAction() throws GameWorldRegistryDataServiceException;

    Action findAction(Long id) throws GameWorldRegistryDataServiceException;

    Action saveAction(Action action) throws GameWorldRegistryDataServiceException;

    void deleteAction(Action action) throws GameWorldRegistryDataServiceException;

    List<Action> findAllActionsByExample(Action example) throws GameWorldRegistryDataServiceException;

    Action findActionByUniqueName(String uniqueName) throws GameWorldRegistryDataServiceException;

    List<Action> findAllActionsByAnyTextFieldContaining(String content) throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeStateTransition> findAllGameObjectTypeStateTransitions() throws GameWorldRegistryDataServiceException;

    GameObjectTypeStateTransition newGameObjectTypeStateTransition() throws GameWorldRegistryDataServiceException;

    GameObjectTypeStateTransition findGameObjectTypeStateTransition(Long id) throws GameWorldRegistryDataServiceException;

    GameObjectTypeStateTransition saveGameObjectTypeStateTransition(GameObjectTypeStateTransition gameObjectTypeStateTransition)
            throws GameWorldRegistryDataServiceException;

    void deleteGameObjectTypeStateTransition(GameObjectTypeStateTransition gameObjectTypeStateTransition)
            throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeStateTransition> findAllGameObjectTypeStateTransitionsByExample(GameObjectTypeStateTransition example)
            throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeStateTransition> findAllGameObjectTypeStateTransitionsBySourceGameObjectTypeState(
            GameObjectTypeState sourceGameObjectTypeState) throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeStateTransition> findAllGameObjectTypeStateTransitionsByTargetGameObjectTypeState(
            GameObjectTypeState targetGameObjectTypeState) throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeStateTransition> findAllGameObjectTypeStateTransitionsByTriggerAction(Action triggerAction)
            throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeStateTransition> findAllGameObjectTypeStateTransitionsByAnyTextFieldContaining(String content)
            throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeAllowedAddonType> findAllGameObjectTypeAllowedAddonTypes() throws GameWorldRegistryDataServiceException;

    GameObjectTypeAllowedAddonType newGameObjectTypeAllowedAddonType() throws GameWorldRegistryDataServiceException;

    GameObjectTypeAllowedAddonType findGameObjectTypeAllowedAddonType(Long id) throws GameWorldRegistryDataServiceException;

    GameObjectTypeAllowedAddonType saveGameObjectTypeAllowedAddonType(GameObjectTypeAllowedAddonType gameObjectTypeAllowedAddonType)
            throws GameWorldRegistryDataServiceException;

    void deleteGameObjectTypeAllowedAddonType(GameObjectTypeAllowedAddonType gameObjectTypeAllowedAddonType)
            throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeAllowedAddonType> findAllGameObjectTypeAllowedAddonTypesByExample(GameObjectTypeAllowedAddonType example)
            throws GameWorldRegistryDataServiceException;

    GameObjectTypeAllowedAddonType findGameObjectTypeAllowedAddonTypeByUniqueName(String uniqueName)
            throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeAllowedAddonType> findAllGameObjectTypeAllowedAddonTypesByAddonGameObjectType(GameObjectType addonGameObjectType)
            throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeAllowedAddonType> findAllGameObjectTypeAllowedAddonTypesByApplicableToGameObjectType(
            GameObjectType applicableToGameObjectType) throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeAllowedAddonType> findAllGameObjectTypeAllowedAddonTypesByTriggerAction(Action triggerAction)
            throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeAllowedAddonType> findAllGameObjectTypeAllowedAddonTypesBySpawnableGameObjectType(GameObjectType spawnableGameObjectType)
            throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeAllowedAddonType> findAllGameObjectTypeAllowedAddonTypesByAnyTextFieldContaining(String content)
            throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeInteraction> findAllGameObjectTypeInteractions() throws GameWorldRegistryDataServiceException;

    GameObjectTypeInteraction newGameObjectTypeInteraction() throws GameWorldRegistryDataServiceException;

    GameObjectTypeInteraction findGameObjectTypeInteraction(Long id) throws GameWorldRegistryDataServiceException;

    GameObjectTypeInteraction saveGameObjectTypeInteraction(GameObjectTypeInteraction gameObjectTypeInteraction)
            throws GameWorldRegistryDataServiceException;

    void deleteGameObjectTypeInteraction(GameObjectTypeInteraction gameObjectTypeInteraction) throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeInteraction> findAllGameObjectTypeInteractionsByExample(GameObjectTypeInteraction example)
            throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeInteraction> findAllGameObjectTypeInteractionsByDonatingGameObjectType(GameObjectType donatingGameObjectType)
            throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeInteraction> findAllGameObjectTypeInteractionsByReceivingGameObjectType(GameObjectType receivingGameObjectType)
            throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeInteraction> findAllGameObjectTypeInteractionsByAnyTextFieldContaining(String content)
            throws GameWorldRegistryDataServiceException;

    List<GameClientType> findAllGameClientTypes() throws GameWorldRegistryDataServiceException;

    GameClientType newGameClientType() throws GameWorldRegistryDataServiceException;

    GameClientType findGameClientType(Long id) throws GameWorldRegistryDataServiceException;

    GameClientType saveGameClientType(GameClientType gameClientType) throws GameWorldRegistryDataServiceException;

    void deleteGameClientType(GameClientType gameClientType) throws GameWorldRegistryDataServiceException;

    List<GameClientType> findAllGameClientTypesByExample(GameClientType example) throws GameWorldRegistryDataServiceException;

    GameClientType findGameClientTypeByUniqueName(String uniqueName) throws GameWorldRegistryDataServiceException;

    List<GameClientType> findAllGameClientTypesByAnyTextFieldContaining(String content) throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeRepresentation> findAllGameObjectTypeRepresentations() throws GameWorldRegistryDataServiceException;

    GameObjectTypeRepresentation newGameObjectTypeRepresentation() throws GameWorldRegistryDataServiceException;

    GameObjectTypeRepresentation findGameObjectTypeRepresentation(Long id) throws GameWorldRegistryDataServiceException;

    GameObjectTypeRepresentation saveGameObjectTypeRepresentation(GameObjectTypeRepresentation gameObjectTypeRepresentation)
            throws GameWorldRegistryDataServiceException;

    void deleteGameObjectTypeRepresentation(GameObjectTypeRepresentation gameObjectTypeRepresentation)
            throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeRepresentation> findAllGameObjectTypeRepresentationsByExample(GameObjectTypeRepresentation example)
            throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeRepresentation> findAllGameObjectTypeRepresentationsByGameObjectType(GameObjectType gameObjectType)
            throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeRepresentation> findAllGameObjectTypeRepresentationsByGameClientType(GameClientType gameClientType)
            throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeRepresentation> findAllGameObjectTypeRepresentationsByAnyTextFieldContaining(String content)
            throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeState> findAllGameObjectTypeStates() throws GameWorldRegistryDataServiceException;

    GameObjectTypeState newGameObjectTypeState() throws GameWorldRegistryDataServiceException;

    GameObjectTypeState findGameObjectTypeState(Long id) throws GameWorldRegistryDataServiceException;

    GameObjectTypeState saveGameObjectTypeState(GameObjectTypeState gameObjectTypeState) throws GameWorldRegistryDataServiceException;

    void deleteGameObjectTypeState(GameObjectTypeState gameObjectTypeState) throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeState> findAllGameObjectTypeStatesByExample(GameObjectTypeState example) throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeState> findAllGameObjectTypeStatesByGameObjectType(GameObjectType gameObjectType)
            throws GameWorldRegistryDataServiceException;

    GameObjectTypeState findGameObjectTypeStateByName(String name) throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeState> findAllGameObjectTypeStatesByAnyTextFieldContaining(String content) throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeProperty> findAllGameObjectTypeProperties() throws GameWorldRegistryDataServiceException;

    GameObjectTypeProperty newGameObjectTypeProperty() throws GameWorldRegistryDataServiceException;

    GameObjectTypeProperty newGameObjectTypeProperty(Long id) throws GameWorldRegistryDataServiceException;

    GameObjectTypeProperty findGameObjectTypeProperty(Long id) throws GameWorldRegistryDataServiceException;

    GameObjectTypeProperty saveGameObjectTypeProperty(GameObjectTypeProperty gameObjectTypeProperty)
            throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeProperty> saveGameObjectTypeProperties(List<GameObjectTypeProperty> gameObjectTypeProperties)
            throws GameWorldRegistryDataServiceException;

    void deleteGameObjectTypeProperty(GameObjectTypeProperty gameObjectTypeProperty) throws GameWorldRegistryDataServiceException;

    void deleteGameObjectTypePropertiesByGameObjectType(GameObjectType gameObjectType) throws GameWorldRegistryDataServiceException;

    void deleteGameObjectTypePropertiesByIds(List<Long> gameObjectTypePropertyIds) throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeProperty> findAllGameObjectTypePropertiesByExample(GameObjectTypeProperty example)
            throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeProperty> findAllGameObjectTypePropertiesByGameObjectType(GameObjectType gameObjectType)
            throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeProperty> findAllGameObjectTypePropertiesByGameObjectTypeAndIds(GameObjectType gameObjectType, List<Long> ids)
            throws GameWorldRegistryDataServiceException;

    GameObjectTypeProperty findGameObjectTypePropertyByPropertyName(String propertyName) throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeProperty> findAllGameObjectTypePropertiesByAnyTextFieldContaining(String content)
            throws GameWorldRegistryDataServiceException;

    List<GameAddonInteractionReceivingPropertyModifier> findAllGameAddonInteractionReceivingPropertyModifiers()
            throws GameWorldRegistryDataServiceException;

    GameAddonInteractionReceivingPropertyModifier newGameAddonInteractionReceivingPropertyModifier()
            throws GameWorldRegistryDataServiceException;

    GameAddonInteractionReceivingPropertyModifier findGameAddonInteractionReceivingPropertyModifier(Long id)
            throws GameWorldRegistryDataServiceException;

    GameAddonInteractionReceivingPropertyModifier saveGameAddonInteractionReceivingPropertyModifier(
            GameAddonInteractionReceivingPropertyModifier gameAddonInteractionReceivingPropertyModifier)
            throws GameWorldRegistryDataServiceException;

    void deleteGameAddonInteractionReceivingPropertyModifier(
            GameAddonInteractionReceivingPropertyModifier gameAddonInteractionReceivingPropertyModifier)
            throws GameWorldRegistryDataServiceException;

    List<GameAddonInteractionReceivingPropertyModifier> findAllGameAddonInteractionReceivingPropertyModifiersByExample(
            GameAddonInteractionReceivingPropertyModifier example) throws GameWorldRegistryDataServiceException;

    List<GameAddonInteractionReceivingPropertyModifier> findAllGameAddonInteractionReceivingPropertyModifiersByGameObjectTypeAllowedAddonType(
            GameObjectTypeAllowedAddonType gameObjectTypeAllowedAddonType) throws GameWorldRegistryDataServiceException;

    List<GameAddonInteractionReceivingPropertyModifier> findAllGameAddonInteractionReceivingPropertyModifiersByAffectedGameObjectTypeProperty(
            GameObjectTypeProperty affectedGameObjectTypeProperty) throws GameWorldRegistryDataServiceException;

    List<GameAddonInteractionReceivingPropertyModifier> findAllGameAddonInteractionReceivingPropertyModifiersByAnyTextFieldContaining(
            String content) throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeInteractionProperty> findAllGameObjectTypeInteractionProperties() throws GameWorldRegistryDataServiceException;

    GameObjectTypeInteractionProperty newGameObjectTypeInteractionProperty() throws GameWorldRegistryDataServiceException;

    GameObjectTypeInteractionProperty findGameObjectTypeInteractionProperty(Long id) throws GameWorldRegistryDataServiceException;

    GameObjectTypeInteractionProperty saveGameObjectTypeInteractionProperty(GameObjectTypeInteractionProperty gameObjectTypeInteractionProperty)
            throws GameWorldRegistryDataServiceException;

    void deleteGameObjectTypeInteractionProperty(GameObjectTypeInteractionProperty gameObjectTypeInteractionProperty)
            throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeInteractionProperty> findAllGameObjectTypeInteractionPropertiesByExample(GameObjectTypeInteractionProperty example)
            throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeInteractionProperty> findAllGameObjectTypeInteractionPropertiesByGameObjectTypeInteraction(
            GameObjectTypeInteraction gameObjectTypeInteraction) throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeInteractionProperty> findAllGameObjectTypeInteractionPropertiesByDonatingGameObjectTypeProperty(
            GameObjectTypeProperty donatingGameObjectTypeProperty) throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeInteractionProperty> findAllGameObjectTypeInteractionPropertiesByReceivingGameObjectTypeProperty(
            GameObjectTypeProperty receivingGameObjectTypeProperty) throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeInteractionProperty> findAllGameObjectTypeInteractionPropertiesByOverflowGameObjectTypeProperty(
            GameObjectTypeProperty overflowGameObjectTypeProperty) throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeInteractionProperty> findAllGameObjectTypeInteractionPropertiesByAnyTextFieldContaining(String content)
            throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeStatePropertyModifier> findAllGameObjectTypeStatePropertyModifiers() throws GameWorldRegistryDataServiceException;

    GameObjectTypeStatePropertyModifier newGameObjectTypeStatePropertyModifier() throws GameWorldRegistryDataServiceException;

    GameObjectTypeStatePropertyModifier findGameObjectTypeStatePropertyModifier(Long id) throws GameWorldRegistryDataServiceException;

    GameObjectTypeStatePropertyModifier saveGameObjectTypeStatePropertyModifier(
            GameObjectTypeStatePropertyModifier gameObjectTypeStatePropertyModifier) throws GameWorldRegistryDataServiceException;

    void deleteGameObjectTypeStatePropertyModifier(GameObjectTypeStatePropertyModifier gameObjectTypeStatePropertyModifier)
            throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeStatePropertyModifier> findAllGameObjectTypeStatePropertyModifiersByExample(GameObjectTypeStatePropertyModifier example)
            throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeStatePropertyModifier> findAllGameObjectTypeStatePropertyModifiersByGameObjectTypeState(
            GameObjectTypeState gameObjectTypeState) throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeStatePropertyModifier> findAllGameObjectTypeStatePropertyModifiersByGameObjectTypeProperty(
            GameObjectTypeProperty gameObjectTypeProperty) throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeStatePropertyModifier> findAllGameObjectTypeStatePropertyModifiersByAnyTextFieldContaining(String content)
            throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeClass> findAllGameObjectTypeClasses() throws GameWorldRegistryDataServiceException;

    GameObjectTypeClass newGameObjectTypeClass() throws GameWorldRegistryDataServiceException;

    GameObjectTypeClass findGameObjectTypeClass(Long id) throws GameWorldRegistryDataServiceException;

    GameObjectTypeClass saveGameObjectTypeClass(GameObjectTypeClass gameObjectTypeClass) throws GameWorldRegistryDataServiceException;

    void deleteGameObjectTypeClass(GameObjectTypeClass gameObjectTypeClass) throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeClass> findAllGameObjectTypeClassesByExample(GameObjectTypeClass example) throws GameWorldRegistryDataServiceException;

    GameObjectTypeClass findGameObjectTypeClassByName(String name) throws GameWorldRegistryDataServiceException;

    List<GameObjectTypeClass> findAllGameObjectTypeClassesByAnyTextFieldContaining(String content) throws GameWorldRegistryDataServiceException;

    List<GameAssetsRepository> findAllGameAssetsRepositories() throws GameWorldRegistryDataServiceException;

    GameAssetsRepository newGameAssetsRepository() throws GameWorldRegistryDataServiceException;

    GameAssetsRepository findGameAssetsRepository(Long id) throws GameWorldRegistryDataServiceException;

    GameAssetsRepository saveGameAssetsRepository(GameAssetsRepository gameAssetsRepository) throws GameWorldRegistryDataServiceException;

    void deleteGameAssetsRepository(GameAssetsRepository gameAssetsRepository) throws GameWorldRegistryDataServiceException;

    GameAssetsRepositoryPicture newGameAssetsRepositoryPicture() throws GameWorldRegistryDataServiceException;

    List<GameAssetsRepositoryPicture> findAllGameAssetsRepositoryPictures() throws GameWorldRegistryDataServiceException;

    GameAssetsRepositoryPicture findGameAssetsRepositoryPicture(Long id) throws GameWorldRegistryDataServiceException;

    List<GameAssetsRepository> findAllGameAssetsRepositoriesByExample(GameAssetsRepository example)
            throws GameWorldRegistryDataServiceException;

    GameAssetsRepositoryPicture findOneGameAssetsRepositoryPictureByGameAssetsRepositoryId(Long gameAssetsRepositoryId) throws GameWorldRegistryDataServiceException;

    GameAssetsRepositoryPicture saveGameAssetsRepositoryPicture(GameAssetsRepositoryPicture gameAssetsRepositoryPicture) throws GameWorldRegistryDataServiceException;

    void deleteGameAssetsRepositoryPicture(GameAssetsRepositoryPicture gameAssetsRepositoryPicture) throws GameWorldRegistryDataServiceException;

    void deleteGameAssetsRepositoryPicturesByGameAssetsRepository(GameAssetsRepository gameAssetsRepository) throws GameWorldRegistryDataServiceException;

    GameAssetsRepository findGameAssetsRepositoryByUniqueName(String uniqueName) throws GameWorldRegistryDataServiceException;

    List<GameAssetsRepository> findAllGameAssetsRepositoriesByAnyTextFieldContaining(String content)
            throws GameWorldRegistryDataServiceException;

    List<GameObjectType> findAllGameObjectTypes() throws GameWorldRegistryDataServiceException;

    GameObjectType newGameObjectType() throws GameWorldRegistryDataServiceException;

    GameObjectType newGameObjectType(Long id) throws GameWorldRegistryDataServiceException;

    GameObjectType findGameObjectType(Long id) throws GameWorldRegistryDataServiceException;

    GameObjectType saveGameObjectType(GameObjectType gameObjectType) throws GameWorldRegistryDataServiceException;

    void deleteGameObjectType(GameObjectType gameObjectType) throws GameWorldRegistryDataServiceException;

    List<GameObjectType> findAllGameObjectTypesByExample(GameObjectType example) throws GameWorldRegistryDataServiceException;

    List<GameObjectType> findAllGameObjectTypesByGameAssetsRepository(GameAssetsRepository gameAssetsRepository)
            throws GameWorldRegistryDataServiceException;

    List<GameObjectType> findAllGameObjectTypesByGameObjectTypeClass(GameObjectTypeClass gameObjectTypeClass)
            throws GameWorldRegistryDataServiceException;

    GameObjectType findGameObjectTypeByUniqueName(String uniqueName) throws GameWorldRegistryDataServiceException;

    List<GameObjectType> findAllGameObjectTypesByAnyTextFieldContaining(String content) throws GameWorldRegistryDataServiceException;

    GameAssetsRepositoryOwner findGameAssetsRepositoryOwnerByGameAssetsRepositoryIdAndOwnerId(Long gameAssetsRepositoryId, Long ownerId);

    void deleteGameAssetsRepositoryOwnersByGameAssetsRepository(GameAssetsRepository rep);

    GameAssetsRepositoryOwner saveGameAssetsRepositoryOwner(GameAssetsRepositoryOwner repOwner);

    GameAssetsRepositoryOwner newGameAssetsRepositoryOwner(GameAssetsRepository gameAssetsRepository, Long ownerUserId);
}
