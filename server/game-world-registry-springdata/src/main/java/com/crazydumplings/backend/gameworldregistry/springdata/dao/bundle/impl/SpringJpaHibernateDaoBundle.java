package com.crazydumplings.backend.gameworldregistry.springdata.dao.bundle.impl;

import org.springframework.context.ApplicationContext;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.ActionsRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.AutomationObjectProvidersRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameAddonInteractionReceivingPropertyModifiersRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameAssetsRepositoriesRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameAssetsRepositoryOwnersRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.GameAssetsRepositoryPicturesRepository;
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
import com.crazydumplings.backend.gameworldregistry.springdata.dao.bundle.DaoBundle;

public class SpringJpaHibernateDaoBundle extends DaoBundle {
    private ApplicationContext springApplicationContext;

    public SpringJpaHibernateDaoBundle(ApplicationContext applicationContext) {
        springApplicationContext = applicationContext;

        playableCharacterTypesRepository = springApplicationContext.getBean(PlayableCharacterTypesRepository.class);
        gameWorldSpawnPointTypesRepository = springApplicationContext.getBean(GameWorldSpawnPointTypesRepository.class);
        gameWorldCellTypesRepository = springApplicationContext.getBean(GameWorldCellTypesRepository.class);
        gameWorldsRepository = springApplicationContext.getBean(GameWorldsRepository.class);
        gameWorldCellsRepository = springApplicationContext.getBean(GameWorldCellsRepository.class);
        gameWorldCellPropertiesRepository = springApplicationContext.getBean(GameWorldCellPropertiesRepository.class);
        automationObjectProvidersRepository = springApplicationContext.getBean(AutomationObjectProvidersRepository.class);
        gameObjectTypeAutomationsRepository = springApplicationContext.getBean(GameObjectTypeAutomationsRepository.class);
        actionsRepository = springApplicationContext.getBean(ActionsRepository.class);
        gameObjectTypeStateTransitionsRepository = springApplicationContext.getBean(GameObjectTypeStateTransitionsRepository.class);
        gameObjectTypeAllowedAddonTypesRepository = springApplicationContext.getBean(GameObjectTypeAllowedAddonTypesRepository.class);
        gameObjectTypeInteractionsRepository = springApplicationContext.getBean(GameObjectTypeInteractionsRepository.class);
        gameClientTypesRepository = springApplicationContext.getBean(GameClientTypesRepository.class);
        gameObjectTypeRepresentationsRepository = springApplicationContext.getBean(GameObjectTypeRepresentationsRepository.class);
        gameObjectTypeStatesRepository = springApplicationContext.getBean(GameObjectTypeStatesRepository.class);
        gameObjectTypePropertiesRepository = springApplicationContext.getBean(GameObjectTypePropertiesRepository.class);
        gameAddonInteractionReceivingPropertyModifiersRepository = springApplicationContext
                .getBean(GameAddonInteractionReceivingPropertyModifiersRepository.class);
        gameObjectTypeInteractionPropertiesRepository = springApplicationContext.getBean(GameObjectTypeInteractionPropertiesRepository.class);
        gameObjectTypeStatePropertyModifiersRepository = springApplicationContext.getBean(GameObjectTypeStatePropertyModifiersRepository.class);
        gameObjectTypeClassesRepository = springApplicationContext.getBean(GameObjectTypeClassesRepository.class);
        gameAssetsRepositoriesRepository = springApplicationContext.getBean(GameAssetsRepositoriesRepository.class);
        gameObjectTypesRepository = springApplicationContext.getBean(GameObjectTypesRepository.class);
        gameAssetsRepositoryOwnersRepository = springApplicationContext.getBean(GameAssetsRepositoryOwnersRepository.class);
        gameAssetsRepositoryPicturesRepository = springApplicationContext.getBean(GameAssetsRepositoryPicturesRepository.class);
    }
}
