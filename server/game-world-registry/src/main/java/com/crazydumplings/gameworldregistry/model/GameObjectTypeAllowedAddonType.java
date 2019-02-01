package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface GameObjectTypeAllowedAddonType extends Serializable, Comparable<GameObjectTypeAllowedAddonType> {
    Long getId();

    String getUniqueName();

    void setUniqueName(String uniqueName);

    GameObjectType getAddonGameObjectType();

    void setAddonGameObjectType(GameObjectType addonGameObjectType);

    GameObjectType getApplicableToGameObjectType();

    void setApplicableToGameObjectType(GameObjectType applicableToGameObjectType);

    Boolean getIsEquipedByDefault();

    void setIsEquipedByDefault(Boolean isEquipedByDefault);

    Boolean getIsIncremental();

    void setIsIncremental(Boolean isIncremental);

    Boolean getIsTriggered();

    void setIsTriggered(Boolean isTriggered);

    Action getTriggerAction();

    void setTriggerAction(Action triggerAction);

    Boolean getIsSpawning();

    void setIsSpawning(Boolean isSpawning);

    GameObjectType getSpawnableGameObjectType();

    void setSpawnableGameObjectType(GameObjectType spawnableGameObjectType);

    Boolean getHasLimitedDuration();

    void setHasLimitedDuration(Boolean hasLimitedDuration);

    Integer getDuration();

    void setDuration(Integer duration);

}