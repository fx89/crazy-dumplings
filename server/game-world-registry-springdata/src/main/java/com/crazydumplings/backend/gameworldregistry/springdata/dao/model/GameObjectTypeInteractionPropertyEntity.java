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

import com.crazydumplings.gameworldregistry.model.GameObjectTypeInteraction;
import com.crazydumplings.gameworldregistry.model.GameObjectTypeInteractionProperty;
import com.crazydumplings.gameworldregistry.model.GameObjectTypeProperty;

@Entity
@Table(name = "GAME_OBJECT_TYPE_INTERACTION_PROPERTY")
@Generated(value = "fx.codegen.builder version 1.0.0")
public class GameObjectTypeInteractionPropertyEntity implements GameObjectTypeInteractionProperty {
    @Id
    @Column(name = "ID_GAME_OBJECT_TYPE_INTERACTION_PROPERTY")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public GameObjectTypeInteractionPropertyEntity() {

    }

    public GameObjectTypeInteractionPropertyEntity(Long id) {
        this.id = id;
    }

    public GameObjectTypeInteractionPropertyEntity(GameObjectTypeInteractionPropertyEntity entity, Long id) {
        this.id = id;
        this.gameObjectTypeInteraction = entity.gameObjectTypeInteraction;
        this.donatingGameObjectTypeProperty = entity.donatingGameObjectTypeProperty;
        this.receivingGameObjectTypeProperty = entity.receivingGameObjectTypeProperty;
        this.overflowGameObjectTypeProperty = entity.overflowGameObjectTypeProperty;
        this.isIncremental = entity.isIncremental;
        this.isInverted = entity.isInverted;
    }

    @ManyToOne
    @JoinColumn(name = "GAME_OBJECT_TYPE_INTERACTION_ID")
    private GameObjectTypeInteractionEntity gameObjectTypeInteraction;

    @ManyToOne
    @JoinColumn(name = "DONATING_GAME_OBJECT_TYPE_PROPERTY_ID")
    private GameObjectTypePropertyEntity    donatingGameObjectTypeProperty;

    @ManyToOne
    @JoinColumn(name = "RECEIVING_GAME_OBJECT_TYPE_PROPERTY_ID")
    private GameObjectTypePropertyEntity    receivingGameObjectTypeProperty;

    @ManyToOne
    @JoinColumn(name = "OVERFLOW_GAME_OBJECT_TYPE_PROPERTY_ID")
    private GameObjectTypePropertyEntity    overflowGameObjectTypeProperty;

    @Column(name = "IS_INCREMENTAL")
    private Boolean                         isIncremental;

    @Column(name = "IS_INVERTED")
    private Boolean                         isInverted;

    public GameObjectTypeInteraction getGameObjectTypeInteraction() {
        return (GameObjectTypeInteraction) gameObjectTypeInteraction;
    }

    public void setGameObjectTypeInteraction(GameObjectTypeInteraction gameObjectTypeInteraction) {
        this.gameObjectTypeInteraction = (GameObjectTypeInteractionEntity) gameObjectTypeInteraction;
    }

    public GameObjectTypeProperty getDonatingGameObjectTypeProperty() {
        return (GameObjectTypeProperty) donatingGameObjectTypeProperty;
    }

    public void setDonatingGameObjectTypeProperty(GameObjectTypeProperty donatingGameObjectTypeProperty) {
        this.donatingGameObjectTypeProperty = (GameObjectTypePropertyEntity) donatingGameObjectTypeProperty;
    }

    public GameObjectTypeProperty getReceivingGameObjectTypeProperty() {
        return (GameObjectTypeProperty) receivingGameObjectTypeProperty;
    }

    public void setReceivingGameObjectTypeProperty(GameObjectTypeProperty receivingGameObjectTypeProperty) {
        this.receivingGameObjectTypeProperty = (GameObjectTypePropertyEntity) receivingGameObjectTypeProperty;
    }

    public GameObjectTypeProperty getOverflowGameObjectTypeProperty() {
        return (GameObjectTypeProperty) overflowGameObjectTypeProperty;
    }

    public void setOverflowGameObjectTypeProperty(GameObjectTypeProperty overflowGameObjectTypeProperty) {
        this.overflowGameObjectTypeProperty = (GameObjectTypePropertyEntity) overflowGameObjectTypeProperty;
    }

    public Boolean getIsIncremental() {
        return isIncremental;
    }

    public void setIsIncremental(Boolean isIncremental) {
        this.isIncremental = isIncremental;
    }

    public Boolean getIsInverted() {
        return isInverted;
    }

    public void setIsInverted(Boolean isInverted) {
        this.isInverted = isInverted;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof GameObjectTypeInteractionPropertyEntity)) {
            return false;
        }

        GameObjectTypeInteractionPropertyEntity other = (GameObjectTypeInteractionPropertyEntity) obj;

        return Objects.equals(this.getId(), other.getId());
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getId()).build();
    }

    public int compareTo(GameObjectTypeInteractionProperty obj) {
        if (obj == this) {
            return 0;
        }

        if (!(obj instanceof GameObjectTypeInteractionPropertyEntity)) {
            return -1;
        }

        GameObjectTypeInteractionPropertyEntity other = (GameObjectTypeInteractionPropertyEntity) obj;

        if (this.getId() == null) {
            return 1;
        }

        if (other.getId() == null) {
            return -1;
        }

        return this.getId().compareTo(other.getId());
    }
}