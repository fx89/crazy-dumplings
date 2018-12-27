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

import com.crazydumplings.gameworldregistry.model.GameAddonInteractionReceivingPropertyModifier;
import com.crazydumplings.gameworldregistry.model.GameObjectTypeAllowedAddonType;
import com.crazydumplings.gameworldregistry.model.GameObjectTypeProperty;

@Entity
@Table(name = "GAME_ADDON_INTERACTION_RECEIVING_PROPERTY_MODIFIER")
@Generated(value = "fx.codegen.builder version 1.0.0")
public class GameAddonInteractionReceivingPropertyModifierEntity implements GameAddonInteractionReceivingPropertyModifier {
    @Id
    @Column(name = "ID_GAME_ADDON_INTERACTION_RECEIVING_PROPERTY_MODIFIER")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public GameAddonInteractionReceivingPropertyModifierEntity() {

    }

    public GameAddonInteractionReceivingPropertyModifierEntity(Long id) {
        this.id = id;
    }

    public GameAddonInteractionReceivingPropertyModifierEntity(GameAddonInteractionReceivingPropertyModifierEntity entity, Long id) {
        this.id = id;
        this.gameObjectTypeAllowedAddonType = entity.gameObjectTypeAllowedAddonType;
        this.affectedGameObjectTypeProperty = entity.affectedGameObjectTypeProperty;
        this.appliedPropertyValueMultiplier = entity.appliedPropertyValueMultiplier;
    }

    @ManyToOne
    @JoinColumn(name = "GAME_OBJECT_TYPE_ALLOWED_ADDON_TYPE_ID")
    private GameObjectTypeAllowedAddonTypeEntity gameObjectTypeAllowedAddonType;

    @ManyToOne
    @JoinColumn(name = "AFFECTED_GAME_OBJECT_TYPE_PROPERTY_ID")
    private GameObjectTypePropertyEntity         affectedGameObjectTypeProperty;

    @Column(name = "APPLIED_PROPERTY_VALUE_MULTIPLIER")
    private Double                               appliedPropertyValueMultiplier;

    public GameObjectTypeAllowedAddonType getGameObjectTypeAllowedAddonType() {
        return (GameObjectTypeAllowedAddonType) gameObjectTypeAllowedAddonType;
    }

    public void setGameObjectTypeAllowedAddonType(GameObjectTypeAllowedAddonType gameObjectTypeAllowedAddonType) {
        this.gameObjectTypeAllowedAddonType = (GameObjectTypeAllowedAddonTypeEntity) gameObjectTypeAllowedAddonType;
    }

    public GameObjectTypeProperty getAffectedGameObjectTypeProperty() {
        return (GameObjectTypeProperty) affectedGameObjectTypeProperty;
    }

    public void setAffectedGameObjectTypeProperty(GameObjectTypeProperty affectedGameObjectTypeProperty) {
        this.affectedGameObjectTypeProperty = (GameObjectTypePropertyEntity) affectedGameObjectTypeProperty;
    }

    public Double getAppliedPropertyValueMultiplier() {
        return appliedPropertyValueMultiplier;
    }

    public void setAppliedPropertyValueMultiplier(Double appliedPropertyValueMultiplier) {
        this.appliedPropertyValueMultiplier = appliedPropertyValueMultiplier;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof GameAddonInteractionReceivingPropertyModifierEntity)) {
            return false;
        }

        GameAddonInteractionReceivingPropertyModifierEntity other = (GameAddonInteractionReceivingPropertyModifierEntity) obj;

        return Objects.equals(this.getId(), other.getId());
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getId()).build();
    }

    public int compareTo(GameAddonInteractionReceivingPropertyModifier obj) {
        if (obj == this) {
            return 0;
        }

        if (!(obj instanceof GameAddonInteractionReceivingPropertyModifierEntity)) {
            return -1;
        }

        GameAddonInteractionReceivingPropertyModifierEntity other = (GameAddonInteractionReceivingPropertyModifierEntity) obj;

        if (this.getId() == null) {
            return 1;
        }

        if (other.getId() == null) {
            return -1;
        }

        return this.getId().compareTo(other.getId());
    }
}