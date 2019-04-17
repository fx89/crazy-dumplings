package com.crazydumplings.gameworldregistry.model;



import javax.annotation.Generated;



import com.crazydumplings.gameworldregistry.model.generic.IdentifiableGameAsset;

@Generated(value="fx.codegen.builder version 1.0.0")
public interface GameObjectTypeAllowedAddonType extends IdentifiableGameAsset, Comparable<GameObjectTypeAllowedAddonType> {

	String getUniqueName();

	void setUniqueName(String uniqueName);

	Long getAddonGameObjectTypeId();

	void setAddonGameObjectTypeId(Long addonGameObjectTypeId);

	Long getApplicableToGameObjectTypeId();

	void setApplicableToGameObjectTypeId(Long applicableToGameObjectTypeId);

	Boolean getIsEquipedByDefault();

	void setIsEquipedByDefault(Boolean isEquipedByDefault);

	Boolean getIsIncremental();

	void setIsIncremental(Boolean isIncremental);

	Boolean getIsTriggered();

	void setIsTriggered(Boolean isTriggered);

	Long getTriggerActionId();

	void setTriggerActionId(Long triggerActionId);

	Boolean getIsSpawning();

	void setIsSpawning(Boolean isSpawning);

	Long getSpawnableGameObjectTypeId();

	void setSpawnableGameObjectTypeId(Long spawnableGameObjectTypeId);

	Boolean getHasLimitedDuration();

	void setHasLimitedDuration(Boolean hasLimitedDuration);

	Integer getDuration();

	void setDuration(Integer duration);


}