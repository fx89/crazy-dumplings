package com.crazydumplings.gameworldregistry.model;

import java.io.Serializable;

public interface GameObjectTypeAllowedAddonType extends Serializable, Comparable<GameObjectTypeAllowedAddonType> {
    public Long getId();

    public String getUniqueName();

    public void setUniqueName(String uniqueName);

    public GameObjectType getAddonGameObjectType();

    public void setAddonGameObjectType(GameObjectType addonGameObjectType);

    public GameObjectType getApplicableToGameObjectType();

    public void setApplicableToGameObjectType(GameObjectType applicableToGameObjectType);

    public Boolean getIsEquipedByDefault();

    public void setIsEquipedByDefault(Boolean isEquipedByDefault);

    public Boolean getIsIncremental();

    public void setIsIncremental(Boolean isIncremental);

    public Boolean getIsTriggered();

    public void setIsTriggered(Boolean isTriggered);

    public Action getTriggerAction();

    public void setTriggerAction(Action triggerAction);

    public Boolean getIsSpawning();

    public void setIsSpawning(Boolean isSpawning);

    public GameObjectType getSpawnableGameObjectType();

    public void setSpawnableGameObjectType(GameObjectType spawnableGameObjectType);

    public Boolean getHasLimitedDuration();

    public void setHasLimitedDuration(Boolean hasLimitedDuration);

    public Integer getDuration();

    public void setDuration(Integer duration);

}