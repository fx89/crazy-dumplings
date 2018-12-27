package com.crazydumplings.backend.gameworldregistry.springdata.dao.bundle.impl;

import javax.annotation.Generated;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.bundle.DaoBundle;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.mock.MockActionsRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.mock.MockAutomationObjectProvidersRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.mock.MockGameAddonInteractionReceivingPropertyModifiersRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.mock.MockGameAssetsRepositoriesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.mock.MockGameAssetsRepositoryOwnersRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.mock.MockGameClientTypesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.mock.MockGameObjectTypeAllowedAddonTypesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.mock.MockGameObjectTypeAutomationsRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.mock.MockGameObjectTypeClassesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.mock.MockGameObjectTypeInteractionPropertiesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.mock.MockGameObjectTypeInteractionsRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.mock.MockGameObjectTypePropertiesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.mock.MockGameObjectTypeRepresentationsRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.mock.MockGameObjectTypeStatePropertyModifiersRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.mock.MockGameObjectTypeStateTransitionsRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.mock.MockGameObjectTypeStatesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.mock.MockGameObjectTypesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.mock.MockGameWorldCellPropertiesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.mock.MockGameWorldCellTypesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.mock.MockGameWorldCellsRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.mock.MockGameWorldSpawnPointTypesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.mock.MockGameWorldsRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.mock.MockPlayableCharacterTypesRepository;

@Generated(value = "fx.codegen.builder version 1.0.0")
public class MockDaoBundle extends DaoBundle {
    public MockDaoBundle() {
        playableCharacterTypesRepository = new MockPlayableCharacterTypesRepository();
        gameWorldSpawnPointTypesRepository = new MockGameWorldSpawnPointTypesRepository();
        gameWorldCellTypesRepository = new MockGameWorldCellTypesRepository();
        gameWorldsRepository = new MockGameWorldsRepository();
        gameWorldCellsRepository = new MockGameWorldCellsRepository();
        gameWorldCellPropertiesRepository = new MockGameWorldCellPropertiesRepository();
        automationObjectProvidersRepository = new MockAutomationObjectProvidersRepository();
        gameObjectTypeAutomationsRepository = new MockGameObjectTypeAutomationsRepository();
        actionsRepository = new MockActionsRepository();
        gameObjectTypeStateTransitionsRepository = new MockGameObjectTypeStateTransitionsRepository();
        gameObjectTypeAllowedAddonTypesRepository = new MockGameObjectTypeAllowedAddonTypesRepository();
        gameObjectTypeInteractionsRepository = new MockGameObjectTypeInteractionsRepository();
        gameClientTypesRepository = new MockGameClientTypesRepository();
        gameObjectTypeRepresentationsRepository = new MockGameObjectTypeRepresentationsRepository();
        gameObjectTypeStatesRepository = new MockGameObjectTypeStatesRepository();
        gameObjectTypePropertiesRepository = new MockGameObjectTypePropertiesRepository();
        gameAddonInteractionReceivingPropertyModifiersRepository = new MockGameAddonInteractionReceivingPropertyModifiersRepository();
        gameObjectTypeInteractionPropertiesRepository = new MockGameObjectTypeInteractionPropertiesRepository();
        gameObjectTypeStatePropertyModifiersRepository = new MockGameObjectTypeStatePropertyModifiersRepository();
        gameObjectTypeClassesRepository = new MockGameObjectTypeClassesRepository();
        gameAssetsRepositoriesRepository = new MockGameAssetsRepositoriesRepository();
        gameObjectTypesRepository = new MockGameObjectTypesRepository();
        gameAssetsRepositoryOwnersRepository = new MockGameAssetsRepositoryOwnersRepository();
    }
}
