package com.crazydumplings.backend.gameworldregistry.springdata.dao.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.annotation.Generated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crazydumplings.backend.gameworldregistry.springdata.dao.AutomationObjectProvidersRepository;
import com.crazydumplings.backend.gameworldregistry.springdata.dao.model.AutomationObjectProviderEntity;

@Generated(value = "fx.codegen.builder version 1.0.0", comments = "Mock implementation of the specification of the repository for the AutomationObjectProvider entity")
public class MockAutomationObjectProvidersRepository implements AutomationObjectProvidersRepository {
    private final Logger                         LOGGER = LoggerFactory.getLogger(getClass());

    private List<AutomationObjectProviderEntity> automationObjectProviders;

    private Long                                 firstAvailableId;

    public MockAutomationObjectProvidersRepository() {
        LOGGER.info("Generating mock automation object providers");

        automationObjectProviders = new ArrayList<>();

        Random random = new Random();
        long nElements = random.nextInt(100);

        firstAvailableId = (long) 1;
        while (firstAvailableId <= nElements) {
            automationObjectProviders.add(generateAutomationObjectProvider(random, firstAvailableId));
            firstAvailableId++;
        }
    }

    protected static AutomationObjectProviderEntity generateAutomationObjectProvider(Random random, long id) {
        return generateAutomationObjectProvider(random, id, true);
    }

    protected static AutomationObjectProviderEntity generateAutomationObjectProvider(Random random, long id, boolean withDependencies) {
        AutomationObjectProviderEntity automationObjectProvider = new AutomationObjectProviderEntity(id);

        automationObjectProvider.setName("AUTOMATION OBJECT PROVIDER " + id + " NAME");

        if (withDependencies) {
        }

        return automationObjectProvider;
    }

    @Override
    public List<AutomationObjectProviderEntity> findAll() {
        return automationObjectProviders;
    }

    @Override
    public AutomationObjectProviderEntity findOneById(Long id) {
        return automationObjectProviders.stream().filter(item -> item.getId() != null && item.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public AutomationObjectProviderEntity findOneByName(String name) {
        return automationObjectProviders.stream().filter(item -> item.getName() != null && item.getName().equals(name)).findFirst()
                .orElse(null);
    }

    @Override
    public List<AutomationObjectProviderEntity> findAllByAnyTextFieldContaining(String content) {
        return automationObjectProviders.stream().filter(item -> ((item.getName() != null && item.getName().contains(content))))
                .collect(Collectors.toList());
    }

    @Override
    public List<AutomationObjectProviderEntity> findAllByExample(String name) {
        return automationObjectProviders.stream().filter(item -> ((item.getName() != null && item.getName().equals(name))))
                .collect(Collectors.toList());
    }

    @Override
    public AutomationObjectProviderEntity save(AutomationObjectProviderEntity automationObjectProvider) {
        if (!automationObjectProviders.contains(automationObjectProvider)) {
            automationObjectProvider = new AutomationObjectProviderEntity(automationObjectProvider, firstAvailableId);
            automationObjectProviders.add(automationObjectProvider);
            firstAvailableId++;
        }

        return automationObjectProvider;
    }

    @Override
    public void delete(AutomationObjectProviderEntity automationObjectProvider) {
        automationObjectProviders.remove(automationObjectProvider);
    }
}