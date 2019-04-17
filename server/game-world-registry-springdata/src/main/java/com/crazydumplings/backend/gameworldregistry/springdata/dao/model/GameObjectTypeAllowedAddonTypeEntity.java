// package com.crazydumplings.gameregistry.gameassetmanager.dao.model;
package com.crazydumplings.backend.gameworldregistry.springdata.dao.model;

// import com.crazydumplings.gameregistry.gameassetmanager.model.GameObjectTypeAllowedAddonType;
import com.crazydumplings.gameworldregistry.model.GameObjectTypeAllowedAddonType;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.annotation.Generated;

import javax.validation.constraints.Size;


@Entity
@Table(name = "GAME_OBJECT_TYPE_ALLOWED_ADDON_TYPE")
@Generated(value="fx.codegen.builder version 1.0.0")
public class GameObjectTypeAllowedAddonTypeEntity implements GameObjectTypeAllowedAddonType {
	@Id
	@Column(name = "ID_GAME_OBJECT_TYPE_ALLOWED_ADDON_TYPE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public GameObjectTypeAllowedAddonTypeEntity() {
		
	}

	public GameObjectTypeAllowedAddonTypeEntity(Long id) {
		this.id = id;
	}

	private void copyAttributesFromEntity(GameObjectTypeAllowedAddonType gameObjectTypeAllowedAddonType) {
		this.uniqueName = gameObjectTypeAllowedAddonType.getUniqueName();
		this.addonGameObjectTypeId = gameObjectTypeAllowedAddonType.getAddonGameObjectTypeId();
		this.applicableToGameObjectTypeId = gameObjectTypeAllowedAddonType.getApplicableToGameObjectTypeId();
		this.isEquipedByDefault = gameObjectTypeAllowedAddonType.getIsEquipedByDefault();
		this.isIncremental = gameObjectTypeAllowedAddonType.getIsIncremental();
		this.isTriggered = gameObjectTypeAllowedAddonType.getIsTriggered();
		this.triggerActionId = gameObjectTypeAllowedAddonType.getTriggerActionId();
		this.isSpawning = gameObjectTypeAllowedAddonType.getIsSpawning();
		this.spawnableGameObjectTypeId = gameObjectTypeAllowedAddonType.getSpawnableGameObjectTypeId();
		this.hasLimitedDuration = gameObjectTypeAllowedAddonType.getHasLimitedDuration();
		this.duration = gameObjectTypeAllowedAddonType.getDuration();
	}

	public GameObjectTypeAllowedAddonTypeEntity(GameObjectTypeAllowedAddonTypeEntity entity, Long id) {
		this.copyAttributesFromEntity(entity);
		this.id = id;
	}

	public GameObjectTypeAllowedAddonTypeEntity(GameObjectTypeAllowedAddonTypeEntity entity) {
		this.copyAttributesFromEntity(entity);
	}

	public GameObjectTypeAllowedAddonTypeEntity(GameObjectTypeAllowedAddonType gameObjectTypeAllowedAddonType) {
		this.copyAttributesFromEntity(gameObjectTypeAllowedAddonType);
	}

	@Column(name = "UNIQUE_NAME")
	@Size(max = 250)
	private String uniqueName;

	@Column(name = "ADDON_GAME_OBJECT_TYPE_ID")
	private Long addonGameObjectTypeId;

	@Column(name = "APPLICABLE_TO_GAME_OBJECT_TYPE_ID")
	private Long applicableToGameObjectTypeId;

	@Column(name = "IS_EQUIPED_BY_DEFAULT")
	private Boolean isEquipedByDefault;

	@Column(name = "IS_INCREMENTAL")
	private Boolean isIncremental;

	@Column(name = "IS_TRIGGERED")
	private Boolean isTriggered;

	@Column(name = "TRIGGER_ACTION_ID")
	private Long triggerActionId;

	@Column(name = "IS_SPAWNING")
	private Boolean isSpawning;

	@Column(name = "SPAWNABLE_GAME_OBJECT_TYPE_ID")
	private Long spawnableGameObjectTypeId;

	@Column(name = "HAS_LIMITED_DURATION")
	private Boolean hasLimitedDuration;

	@Column(name = "DURATION")
	private Integer duration;

	public String getUniqueName() {
		return uniqueName;
	}

	public void setUniqueName(String uniqueName) {
		this.uniqueName = uniqueName;
	}

	public Long getAddonGameObjectTypeId() {
		return addonGameObjectTypeId;
	}

	public void setAddonGameObjectTypeId(Long addonGameObjectTypeId) {
		this.addonGameObjectTypeId = addonGameObjectTypeId;
	}

	public Long getApplicableToGameObjectTypeId() {
		return applicableToGameObjectTypeId;
	}

	public void setApplicableToGameObjectTypeId(Long applicableToGameObjectTypeId) {
		this.applicableToGameObjectTypeId = applicableToGameObjectTypeId;
	}

	public Boolean getIsEquipedByDefault() {
		return isEquipedByDefault;
	}

	public void setIsEquipedByDefault(Boolean isEquipedByDefault) {
		this.isEquipedByDefault = isEquipedByDefault;
	}

	public Boolean getIsIncremental() {
		return isIncremental;
	}

	public void setIsIncremental(Boolean isIncremental) {
		this.isIncremental = isIncremental;
	}

	public Boolean getIsTriggered() {
		return isTriggered;
	}

	public void setIsTriggered(Boolean isTriggered) {
		this.isTriggered = isTriggered;
	}

	public Long getTriggerActionId() {
		return triggerActionId;
	}

	public void setTriggerActionId(Long triggerActionId) {
		this.triggerActionId = triggerActionId;
	}

	public Boolean getIsSpawning() {
		return isSpawning;
	}

	public void setIsSpawning(Boolean isSpawning) {
		this.isSpawning = isSpawning;
	}

	public Long getSpawnableGameObjectTypeId() {
		return spawnableGameObjectTypeId;
	}

	public void setSpawnableGameObjectTypeId(Long spawnableGameObjectTypeId) {
		this.spawnableGameObjectTypeId = spawnableGameObjectTypeId;
	}

	public Boolean getHasLimitedDuration() {
		return hasLimitedDuration;
	}

	public void setHasLimitedDuration(Boolean hasLimitedDuration) {
		this.hasLimitedDuration = hasLimitedDuration;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof GameObjectTypeAllowedAddonTypeEntity)) {
			return false;
		}

		GameObjectTypeAllowedAddonTypeEntity other = (GameObjectTypeAllowedAddonTypeEntity) obj;

		return Objects.equals(this.getId(), other.getId());
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).build();
	}

	public int compareTo(GameObjectTypeAllowedAddonType obj) {
		if (obj == this) {
			return 0;
		}

		if (!(obj instanceof GameObjectTypeAllowedAddonTypeEntity)) {
			return -1;
		}

		GameObjectTypeAllowedAddonTypeEntity other = (GameObjectTypeAllowedAddonTypeEntity) obj;

		if (this.getUniqueName() == null) {
			return 1;
		}

		if (other.getUniqueName() == null) {
			return -1;
		}

		return this.getUniqueName().compareTo(other.getUniqueName());
	}
}