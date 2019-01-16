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

import com.crazydumplings.gameworldregistry.model.Action;
import com.crazydumplings.gameworldregistry.model.GameObjectTypeState;
import com.crazydumplings.gameworldregistry.model.GameObjectTypeStateTransition;

@Entity
@Table(name = "GAME_OBJECT_TYPE_STATE_TRANSITION")
@Generated(value = "fx.codegen.builder version 1.0.0")
public class GameObjectTypeStateTransitionEntity implements GameObjectTypeStateTransition {
    @Id
    @Column(name = "ID_GAME_OBJECT_TYPE_STATE_TRANSITION")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public GameObjectTypeStateTransitionEntity() {

    }

    public GameObjectTypeStateTransitionEntity(Long id) {
        this.id = id;
    }

    public GameObjectTypeStateTransitionEntity(GameObjectTypeStateTransitionEntity entity, Long id) {
        this.id = id;
        this.sourceGameObjectTypeState = entity.sourceGameObjectTypeState;
        this.targetGameObjectTypeState = entity.targetGameObjectTypeState;
        this.isAutomatic = entity.isAutomatic;
        this.triggerAction = entity.triggerAction;
    }

    @ManyToOne
    @JoinColumn(name = "SOURCE_GAME_OBJECT_TYPE_STATE_ID")
    private GameObjectTypeStateEntity sourceGameObjectTypeState;

    @ManyToOne
    @JoinColumn(name = "TARGET_GAME_OBJECT_TYPE_STATE_ID")
    private GameObjectTypeStateEntity targetGameObjectTypeState;

    @Column(name = "IS_AUTOMATIC")
    private Boolean                   isAutomatic;

    @ManyToOne
    @JoinColumn(name = "TRIGGER_ACTION_ID")
    private ActionEntity              triggerAction;

    public GameObjectTypeState getSourceGameObjectTypeState() {
        return (GameObjectTypeState) sourceGameObjectTypeState;
    }

    public void setSourceGameObjectTypeState(GameObjectTypeState sourceGameObjectTypeState) {
        this.sourceGameObjectTypeState = (GameObjectTypeStateEntity) sourceGameObjectTypeState;
    }

    public GameObjectTypeState getTargetGameObjectTypeState() {
        return (GameObjectTypeState) targetGameObjectTypeState;
    }

    public void setTargetGameObjectTypeState(GameObjectTypeState targetGameObjectTypeState) {
        this.targetGameObjectTypeState = (GameObjectTypeStateEntity) targetGameObjectTypeState;
    }

    public Boolean getIsAutomatic() {
        return isAutomatic;
    }

    public void setIsAutomatic(Boolean isAutomatic) {
        this.isAutomatic = isAutomatic;
    }

    public Action getTriggerAction() {
        return (Action) triggerAction;
    }

    public void setTriggerAction(Action triggerAction) {
        this.triggerAction = (ActionEntity) triggerAction;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof GameObjectTypeStateTransitionEntity)) {
            return false;
        }

        GameObjectTypeStateTransitionEntity other = (GameObjectTypeStateTransitionEntity) obj;

        return Objects.equals(this.getId(), other.getId());
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getId()).build();
    }

    public int compareTo(GameObjectTypeStateTransition obj) {
        if (obj == this) {
            return 0;
        }

        if (!(obj instanceof GameObjectTypeStateTransitionEntity)) {
            return -1;
        }

        GameObjectTypeStateTransitionEntity other = (GameObjectTypeStateTransitionEntity) obj;

        if (this.getId() == null) {
            return 1;
        }

        if (other.getId() == null) {
            return -1;
        }

        return this.getId().compareTo(other.getId());
    }
}