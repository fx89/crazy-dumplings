package com.crazydumplings.backend.gameworldregistry.springdata.dao.bundle;

import java.util.Objects;

import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.ActionsRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.AutomationObjectProvidersRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameAddonInteractionReceivingPropertyModifiersRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameAssetsRepositoriesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameAssetsRepositoryOwnersRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameClientTypesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameObjectTypeAllowedAddonTypesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameObjectTypeAutomationsRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameObjectTypeClassesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameObjectTypeInteractionPropertiesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameObjectTypeInteractionsRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameObjectTypePropertiesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameObjectTypeRepresentationsRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameObjectTypeStatePropertyModifiersRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameObjectTypeStateTransitionsRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameObjectTypeStatesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameObjectTypesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameWorldCellPropertiesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameWorldCellTypesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameWorldCellsRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameWorldSpawnPointTypesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameWorldsRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.PlayableCharacterTypesRepository;

@Generated(value = "fx.codegen.builder version 1.0.0")
public abstract class DaoBundle {
    private static final String                                     MSG__DID_NOT_INITIALIZE = "The implementing class did not initialize ";

    public PlayableCharacterTypesRepository                         playableCharacterTypesRepository;
    public GameWorldSpawnPointTypesRepository                       gameWorldSpawnPointTypesRepository;
    public GameWorldCellTypesRepository                             gameWorldCellTypesRepository;
    public GameWorldsRepository                                     gameWorldsRepository;
    public GameWorldCellsRepository                                 gameWorldCellsRepository;
    public GameWorldCellPropertiesRepository                        gameWorldCellPropertiesRepository;
    public AutomationObjectProvidersRepository                      automationObjectProvidersRepository;
    public GameObjectTypeAutomationsRepository                      gameObjectTypeAutomationsRepository;
    public ActionsRepository                                        actionsRepository;
    public GameObjectTypeStateTransitionsRepository                 gameObjectTypeStateTransitionsRepository;
    public GameObjectTypeAllowedAddonTypesRepository                gameObjectTypeAllowedAddonTypesRepository;
    public GameObjectTypeInteractionsRepository                     gameObjectTypeInteractionsRepository;
    public GameClientTypesRepository                                gameClientTypesRepository;
    public GameObjectTypeRepresentationsRepository                  gameObjectTypeRepresentationsRepository;
    public GameObjectTypeStatesRepository                           gameObjectTypeStatesRepository;
    public GameObjectTypePropertiesRepository                       gameObjectTypePropertiesRepository;
    public GameAddonInteractionReceivingPropertyModifiersRepository gameAddonInteractionReceivingPropertyModifiersRepository;
    public GameObjectTypeInteractionPropertiesRepository            gameObjectTypeInteractionPropertiesRepository;
    public GameObjectTypeStatePropertyModifiersRepository           gameObjectTypeStatePropertyModifiersRepository;
    public GameObjectTypeClassesRepository                          gameObjectTypeClassesRepository;
    public GameAssetsRepositoriesRepository                         gameAssetsRepositoriesRepository;
    public GameObjectTypesRepository                                gameObjectTypesRepository;
    public GameAssetsRepositoryOwnersRepository                     gameAssetsRepositoryOwnersRepository;

    public void verify() {
        Objects.requireNonNull(playableCharacterTypesRepository, MSG__DID_NOT_INITIALIZE + "the playable character types repository");
        Objects.requireNonNull(gameWorldSpawnPointTypesRepository, MSG__DID_NOT_INITIALIZE + "the game world spawn point types repository");
        Objects.requireNonNull(gameWorldCellTypesRepository, MSG__DID_NOT_INITIALIZE + "the game world cell types repository");
        Objects.requireNonNull(gameWorldsRepository, MSG__DID_NOT_INITIALIZE + "the game worlds repository");
        Objects.requireNonNull(gameWorldCellsRepository, MSG__DID_NOT_INITIALIZE + "the game world cells repository");
        Objects.requireNonNull(gameWorldCellPropertiesRepository, MSG__DID_NOT_INITIALIZE + "the game world cell properties repository");
        Objects.requireNonNull(automationObjectProvidersRepository, MSG__DID_NOT_INITIALIZE + "the automation object providers repository");
        Objects.requireNonNull(gameObjectTypeAutomationsRepository, MSG__DID_NOT_INITIALIZE + "the game object type automations repository");
        Objects.requireNonNull(actionsRepository, MSG__DID_NOT_INITIALIZE + "the actions repository");
        Objects.requireNonNull(gameObjectTypeStateTransitionsRepository,
                MSG__DID_NOT_INITIALIZE + "the game object type state transitions repository");
        Objects.requireNonNull(gameObjectTypeAllowedAddonTypesRepository,
                MSG__DID_NOT_INITIALIZE + "the game object type allowed addon types repository");
        Objects.requireNonNull(gameObjectTypeInteractionsRepository, MSG__DID_NOT_INITIALIZE + "the game object type interactions repository");
        Objects.requireNonNull(gameClientTypesRepository, MSG__DID_NOT_INITIALIZE + "the game client types repository");
        Objects.requireNonNull(gameObjectTypeRepresentationsRepository,
                MSG__DID_NOT_INITIALIZE + "the game object type representations repository");
        Objects.requireNonNull(gameObjectTypeStatesRepository, MSG__DID_NOT_INITIALIZE + "the game object type states repository");
        Objects.requireNonNull(gameObjectTypePropertiesRepository, MSG__DID_NOT_INITIALIZE + "the game object type properties repository");
        Objects.requireNonNull(gameAddonInteractionReceivingPropertyModifiersRepository,
                MSG__DID_NOT_INITIALIZE + "the game addon interaction receiving property modifiers repository");
        Objects.requireNonNull(gameObjectTypeInteractionPropertiesRepository,
                MSG__DID_NOT_INITIALIZE + "the game object type interaction properties repository");
        Objects.requireNonNull(gameObjectTypeStatePropertyModifiersRepository,
                MSG__DID_NOT_INITIALIZE + "the game object type state property modifiers repository");
        Objects.requireNonNull(gameObjectTypeClassesRepository, MSG__DID_NOT_INITIALIZE + "the game object type classes repository");
        Objects.requireNonNull(gameAssetsRepositoriesRepository, MSG__DID_NOT_INITIALIZE + "the game assets repositories repository");
        Objects.requireNonNull(gameObjectTypesRepository, MSG__DID_NOT_INITIALIZE + "the game object types repository");
        Objects.requireNonNull(gameAssetsRepositoryOwnersRepository, MSG__DID_NOT_INITIALIZE + "the game assets repository owners repository");
    }
}
