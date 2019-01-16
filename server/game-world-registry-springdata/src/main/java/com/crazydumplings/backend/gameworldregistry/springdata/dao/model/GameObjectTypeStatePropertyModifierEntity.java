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

import com.crazydumplings.gameworldregistry.model.GameObjectTypeProperty;
import com.crazydumplings.gameworldregistry.model.GameObjectTypeState;
import com.crazydumplings.gameworldregistry.model.GameObjectTypeStatePropertyModifier;

@Entity
@Table(name = "GAME_OBJECT_TYPE_STATE_PROPERTY_MODIFIER")
@Generated(value = "fx.codegen.builder version 1.0.0")
public class GameObjectTypeStatePropertyModifierEntity implements GameObjectTypeStatePropertyModifier {
    @Id
    @Column(name = "ID_GAME_OBJECT_TYPE_STATE_PROPERTY_MODIFIER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public GameObjectTypeStatePropertyModifierEntity() {

    }

    public GameObjectTypeStatePropertyModifierEntity(Long id) {
        this.id = id;
    }

    public GameObjectTypeStatePropertyModifierEntity(GameObjectTypeStatePropertyModifierEntity entity, Long id) {
        this.id = id;
        this.gameObjectTypeState = entity.gameObjectTypeState;
        this.gameObjectTypeProperty = entity.gameObjectTypeProperty;
        this.propertyActualValue = entity.propertyActualValue;
    }

    @ManyToOne
    @JoinColumn(name = "GAME_OBJECT_TYPE_STATE_ID")
    private GameObjectTypeStateEntity    gameObjectTypeState;

    @ManyToOne
    @JoinColumn(name = "GAME_OBJECT_TYPE_PROPERTY_ID")
    private GameObjectTypePropertyEntity gameObjectTypeProperty;

    @Column(name = "PROPERTY_ACTUAL_VALUE")
    private Double                       propertyActualValue;

    public GameObjectTypeState getGameObjectTypeState() {
        return (GameObjectTypeState) gameObjectTypeState;
    }

    public void setGameObjectTypeState(GameObjectTypeState gameObjectTypeState) {
        this.gameObjectTypeState = (GameObjectTypeStateEntity) gameObjectTypeState;
    }

    public GameObjectTypeProperty getGameObjectTypeProperty() {
        return (GameObjectTypeProperty) gameObjectTypeProperty;
    }

    public void setGameObjectTypeProperty(GameObjectTypeProperty gameObjectTypeProperty) {
        this.gameObjectTypeProperty = (GameObjectTypePropertyEntity) gameObjectTypeProperty;
    }

    public Double getPropertyActualValue() {
        return propertyActualValue;
    }

    public void setPropertyActualValue(Double propertyActualValue) {
        this.propertyActualValue = propertyActualValue;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof GameObjectTypeStatePropertyModifierEntity)) {
            return false;
        }

        GameObjectTypeStatePropertyModifierEntity other = (GameObjectTypeStatePropertyModifierEntity) obj;

        return Objects.equals(this.getId(), other.getId());
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getId()).build();
    }

    public int compareTo(GameObjectTypeStatePropertyModifier obj) {
        if (obj == this) {
            return 0;
        }

        if (!(obj instanceof GameObjectTypeStatePropertyModifierEntity)) {
            return -1;
        }

        GameObjectTypeStatePropertyModifierEntity other = (GameObjectTypeStatePropertyModifierEntity) obj;

        if (this.getId() == null) {
            return 1;
        }

        if (other.getId() == null) {
            return -1;
        }

        return this.getId().compareTo(other.getId());
    }
}