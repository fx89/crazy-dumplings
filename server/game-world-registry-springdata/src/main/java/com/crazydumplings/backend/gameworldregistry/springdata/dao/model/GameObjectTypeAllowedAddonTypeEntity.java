package com.crazydumplings.backend.gameworldregistry.springdata.dao.model;

import java.util.Objects;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.crazydumplings.gameworldregistry.model.Action;
import com.crazydumplings.gameworldregistry.model.GameObjectType;
import com.crazydumplings.gameworldregistry.model.GameObjectTypeAllowedAddonType;

@Entity
@Table(name = "GAME_OBJECT_TYPE_ALLOWED_ADDON_TYPE")
@Generated(value = "fx.codegen.builder version 1.0.0")
public class GameObjectTypeAllowedAddonTypeEntity implements GameObjectTypeAllowedAddonType {
    @Id
    @Column(name = "ID_GAME_OBJECT_TYPE_ALLOWED_ADDON_TYPE")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public GameObjectTypeAllowedAddonTypeEntity() {

    }

    public GameObjectTypeAllowedAddonTypeEntity(Long id) {
        this.id = id;
    }

    public GameObjectTypeAllowedAddonTypeEntity(GameObjectTypeAllowedAddonTypeEntity entity, Long id) {
        this.id = id;
        this.uniqueName = entity.uniqueName;
        this.addonGameObjectType = entity.addonGameObjectType;
        this.applicableToGameObjectType = entity.applicableToGameObjectType;
        this.isEquipedByDefault = entity.isEquipedByDefault;
        this.isIncremental = entity.isIncremental;
        this.isTriggered = entity.isTriggered;
        this.triggerAction = entity.triggerAction;
        this.isSpawning = entity.isSpawning;
        this.spawnableGameObjectType = entity.spawnableGameObjectType;
        this.hasLimitedDuration = entity.hasLimitedDuration;
        this.duration = entity.duration;
    }

    @Column(name = "UNIQUE_NAME")
    @Size(max = 250)
    private String               uniqueName;

    @ManyToOne
    @JoinColumn(name = "ADDON_GAME_OBJECT_TYPE_ID")
    private GameObjectTypeEntity addonGameObjectType;

    @ManyToOne
    @JoinColumn(name = "APPLICABLE_TO_GAME_OBJECT_TYPE_ID")
    private GameObjectTypeEntity applicableToGameObjectType;

    @Column(name = "IS_EQUIPED_BY_DEFAULT")
    private Boolean              isEquipedByDefault;

    @Column(name = "IS_INCREMENTAL")
    private Boolean              isIncremental;

    @Column(name = "IS_TRIGGERED")
    private Boolean              isTriggered;

    @ManyToOne
    @JoinColumn(name = "TRIGGER_ACTION_ID")
    private ActionEntity         triggerAction;

    @Column(name = "IS_SPAWNING")
    private Boolean              isSpawning;

    @ManyToOne
    @JoinColumn(name = "SPAWNABLE_GAME_OBJECT_TYPE_ID")
    private GameObjectTypeEntity spawnableGameObjectType;

    @Column(name = "HAS_LIMITED_DURATION")
    private Boolean              hasLimitedDuration;

    @Column(name = "DURATION")
    private Integer              duration;

    public String getUniqueName() {
        return uniqueName;
    }

    public void setUniqueName(String uniqueName) {
        this.uniqueName = uniqueName;
    }

    public GameObjectType getAddonGameObjectType() {
        return (GameObjectType) addonGameObjectType;
    }

    public void setAddonGameObjectType(GameObjectType addonGameObjectType) {
        this.addonGameObjectType = (GameObjectTypeEntity) addonGameObjectType;
    }

    public GameObjectType getApplicableToGameObjectType() {
        return (GameObjectType) applicableToGameObjectType;
    }

    public void setApplicableToGameObjectType(GameObjectType applicableToGameObjectType) {
        this.applicableToGameObjectType = (GameObjectTypeEntity) applicableToGameObjectType;
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

    public Action getTriggerAction() {
        return (Action) triggerAction;
    }

    public void setTriggerAction(Action triggerAction) {
        this.triggerAction = (ActionEntity) triggerAction;
    }

    public Boolean getIsSpawning() {
        return isSpawning;
    }

    public void setIsSpawning(Boolean isSpawning) {
        this.isSpawning = isSpawning;
    }

    public GameObjectType getSpawnableGameObjectType() {
        return (GameObjectType) spawnableGameObjectType;
    }

    public void setSpawnableGameObjectType(GameObjectType spawnableGameObjectType) {
        this.spawnableGameObjectType = (GameObjectTypeEntity) spawnableGameObjectType;
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