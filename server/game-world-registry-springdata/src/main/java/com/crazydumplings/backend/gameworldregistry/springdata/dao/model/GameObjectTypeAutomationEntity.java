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

import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.crazydumplings.gameworldregistry.model.AutomationObjectProvider;
import com.crazydumplings.gameworldregistry.model.GameObjectType;
import com.crazydumplings.gameworldregistry.model.GameObjectTypeAutomation;

@Entity
@Table(name = "GAME_OBJECT_TYPE_AUTOMATION")
@Generated(value = "fx.codegen.builder version 1.0.0")
public class GameObjectTypeAutomationEntity implements GameObjectTypeAutomation {
    @Id
    @Column(name = "ID_GAME_OBJECT_TYPE_AUTOMATION")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public GameObjectTypeAutomationEntity() {

    }

    public GameObjectTypeAutomationEntity(Long id) {
        this.id = id;
    }

    public GameObjectTypeAutomationEntity(GameObjectTypeAutomationEntity entity, Long id) {
        this.id = id;
        this.gameObjectType = entity.gameObjectType;
        this.automationObjectProvider = entity.automationObjectProvider;
    }

    @ManyToOne
    @JoinColumn(name = "GAME_OBJECT_TYPE_ID")
    private GameObjectTypeEntity           gameObjectType;

    @ManyToOne
    @JoinColumn(name = "AUTOMATION_OBJECT_PROVIDER_ID")
    private AutomationObjectProviderEntity automationObjectProvider;

    public GameObjectType getGameObjectType() {
        return (GameObjectType) gameObjectType;
    }

    public void setGameObjectType(GameObjectType gameObjectType) {
        this.gameObjectType = (GameObjectTypeEntity) gameObjectType;
    }

    public AutomationObjectProvider getAutomationObjectProvider() {
        return (AutomationObjectProvider) automationObjectProvider;
    }

    public void setAutomationObjectProvider(AutomationObjectProvider automationObjectProvider) {
        this.automationObjectProvider = (AutomationObjectProviderEntity) automationObjectProvider;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof GameObjectTypeAutomationEntity)) {
            return false;
        }

        GameObjectTypeAutomationEntity other = (GameObjectTypeAutomationEntity) obj;

        return Objects.equals(this.getId(), other.getId());
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getId()).build();
    }

    public int compareTo(GameObjectTypeAutomation obj) {
        if (obj == this) {
            return 0;
        }

        if (!(obj instanceof GameObjectTypeAutomationEntity)) {
            return -1;
        }

        GameObjectTypeAutomationEntity other = (GameObjectTypeAutomationEntity) obj;

        if (this.getId() == null) {
            return 1;
        }

        if (other.getId() == null) {
            return -1;
        }

        return this.getId().compareTo(other.getId());
    }
}