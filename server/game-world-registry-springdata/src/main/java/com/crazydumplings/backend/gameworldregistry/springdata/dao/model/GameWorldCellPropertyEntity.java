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
import com.crazydumplings.gameworldregistry.model.GameWorldCell;
import com.crazydumplings.gameworldregistry.model.GameWorldCellProperty;

@Entity
@Table(name = "GAME_WORLD_CELL_PROPERTY")
@Generated(value = "fx.codegen.builder version 1.0.0")
public class GameWorldCellPropertyEntity implements GameWorldCellProperty {
    @Id
    @Column(name = "ID_GAME_WORLD_CELL_PROPERTY")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public GameWorldCellPropertyEntity() {

    }

    public GameWorldCellPropertyEntity(Long id) {
        this.id = id;
    }

    public GameWorldCellPropertyEntity(GameWorldCellPropertyEntity entity, Long id) {
        this.id = id;
        this.gameWorldCell = entity.gameWorldCell;
        this.gameObjectTypeProperty = entity.gameObjectTypeProperty;
        this.propertyActualValue = entity.propertyActualValue;
    }

    @ManyToOne
    @JoinColumn(name = "GAME_WORLD_CELL_ID")
    private GameWorldCellEntity          gameWorldCell;

    @ManyToOne
    @JoinColumn(name = "GAME_OBJECT_TYPE_PROPERTY_ID")
    private GameObjectTypePropertyEntity gameObjectTypeProperty;

    @Column(name = "PROPERTY_ACTUAL_VALUE")
    private Double                       propertyActualValue;

    public GameWorldCell getGameWorldCell() {
        return (GameWorldCell) gameWorldCell;
    }

    public void setGameWorldCell(GameWorldCell gameWorldCell) {
        this.gameWorldCell = (GameWorldCellEntity) gameWorldCell;
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

        if (!(obj instanceof GameWorldCellPropertyEntity)) {
            return false;
        }

        GameWorldCellPropertyEntity other = (GameWorldCellPropertyEntity) obj;

        return Objects.equals(this.getId(), other.getId());
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getId()).build();
    }

    public int compareTo(GameWorldCellProperty obj) {
        if (obj == this) {
            return 0;
        }

        if (!(obj instanceof GameWorldCellPropertyEntity)) {
            return -1;
        }

        GameWorldCellPropertyEntity other = (GameWorldCellPropertyEntity) obj;

        if (this.getId() == null) {
            return 1;
        }

        if (other.getId() == null) {
            return -1;
        }

        return this.getId().compareTo(other.getId());
    }
}