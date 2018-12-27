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
import com.crazydumplings.gameworldregistry.model.GameWorldCellType;

@Entity
@Table(name = "GAME_WORLD_CELL_TYPE")
@Generated(value = "fx.codegen.builder version 1.0.0")
public class GameWorldCellTypeEntity implements GameWorldCellType {
    @Id
    @Column(name = "ID_GAME_WORLD_CELL_TYPE")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public GameWorldCellTypeEntity() {

    }

    public GameWorldCellTypeEntity(Long id) {
        this.id = id;
    }

    public GameWorldCellTypeEntity(GameWorldCellTypeEntity entity, Long id) {
        this.id = id;
        this.uniqueName = entity.uniqueName;
        this.gameObjectType = entity.gameObjectType;
    }

    @Column(name = "UNIQUE_NAME")
    @Size(max = 250)
    private String               uniqueName;

    @ManyToOne
    @JoinColumn(name = "GAME_OBJECT_TYPE_ID")
    private GameObjectTypeEntity gameObjectType;

    public String getUniqueName() {
        return uniqueName;
    }

    public void setUniqueName(String uniqueName) {
        this.uniqueName = uniqueName;
    }

    public GameObjectType getGameObjectType() {
        return (GameObjectType) gameObjectType;
    }

    public void setGameObjectType(GameObjectType gameObjectType) {
        this.gameObjectType = (GameObjectTypeEntity) gameObjectType;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof GameWorldCellTypeEntity)) {
            return false;
        }

        GameWorldCellTypeEntity other = (GameWorldCellTypeEntity) obj;

        return Objects.equals(this.getId(), other.getId());
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getId()).build();
    }

    public int compareTo(GameWorldCellType obj) {
        if (obj == this) {
            return 0;
        }

        if (!(obj instanceof GameWorldCellTypeEntity)) {
            return -1;
        }

        GameWorldCellTypeEntity other = (GameWorldCellTypeEntity) obj;

        if (this.getUniqueName() == null) {
            return 1;
        }

        if (other.getUniqueName() == null) {
            return -1;
        }

        return this.getUniqueName().compareTo(other.getUniqueName());
    }
}