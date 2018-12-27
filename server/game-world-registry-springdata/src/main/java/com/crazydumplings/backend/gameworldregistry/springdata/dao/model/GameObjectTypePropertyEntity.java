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

import com.crazydumplings.gameworldregistry.model.GameObjectType;
import com.crazydumplings.gameworldregistry.model.GameObjectTypeProperty;

@Entity
@Table(name = "GAME_OBJECT_TYPE_PROPERTY")
@Generated(value = "fx.codegen.builder version 1.0.0")
public class GameObjectTypePropertyEntity implements GameObjectTypeProperty {
    @Id
    @Column(name = "ID_GAME_OBJECT_TYPE_PROPERTY")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public GameObjectTypePropertyEntity() {

    }

    public GameObjectTypePropertyEntity(Long id) {
        this.id = id;
    }

    public GameObjectTypePropertyEntity(GameObjectTypePropertyEntity entity, Long id) {
        this.id = id;
        this.gameObjectType = entity.gameObjectType;
        this.propertyName = entity.propertyName;
        this.propertyDefaultValue = entity.propertyDefaultValue;
        this.propertyMinValue = entity.propertyMinValue;
        this.propertyMaxValue = entity.propertyMaxValue;
    }

    @ManyToOne
    @JoinColumn(name = "GAME_OBJECT_TYPE_ID")
    private GameObjectTypeEntity gameObjectType;

    @Column(name = "PROPERTY_NAME")
    @Size(max = 250)
    private String               propertyName;

    @Column(name = "PROPERTY_DEFAULT_VALUE")
    private Double               propertyDefaultValue;

    @Column(name = "PROPERTY_MIN_VALUE")
    private Double               propertyMinValue;

    @Column(name = "PROPERTY_MAX_VALUE")
    private Double               propertyMaxValue;

    public GameObjectType getGameObjectType() {
        return (GameObjectType) gameObjectType;
    }

    public void setGameObjectType(GameObjectType gameObjectType) {
        this.gameObjectType = (GameObjectTypeEntity) gameObjectType;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Double getPropertyDefaultValue() {
        return propertyDefaultValue;
    }

    public void setPropertyDefaultValue(Double propertyDefaultValue) {
        this.propertyDefaultValue = propertyDefaultValue;
    }

    public Double getPropertyMinValue() {
        return propertyMinValue;
    }

    public void setPropertyMinValue(Double propertyMinValue) {
        this.propertyMinValue = propertyMinValue;
    }

    public Double getPropertyMaxValue() {
        return propertyMaxValue;
    }

    public void setPropertyMaxValue(Double propertyMaxValue) {
        this.propertyMaxValue = propertyMaxValue;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof GameObjectTypePropertyEntity)) {
            return false;
        }

        GameObjectTypePropertyEntity other = (GameObjectTypePropertyEntity) obj;

        return Objects.equals(this.getId(), other.getId());
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getId()).build();
    }

    public int compareTo(GameObjectTypeProperty obj) {
        if (obj == this) {
            return 0;
        }

        if (!(obj instanceof GameObjectTypePropertyEntity)) {
            return -1;
        }

        GameObjectTypePropertyEntity other = (GameObjectTypePropertyEntity) obj;

        if (this.getPropertyName() == null) {
            return 1;
        }

        if (other.getPropertyName() == null) {
            return -1;
        }

        return this.getPropertyName().compareTo(other.getPropertyName());
    }
}