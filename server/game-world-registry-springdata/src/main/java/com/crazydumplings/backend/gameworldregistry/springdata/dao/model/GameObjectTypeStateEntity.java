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
import com.crazydumplings.gameworldregistry.model.GameObjectTypeState;

@Entity
@Table(name = "GAME_OBJECT_TYPE_STATE")
@Generated(value = "fx.codegen.builder version 1.0.0")
public class GameObjectTypeStateEntity implements GameObjectTypeState {
    @Id
    @Column(name = "ID_GAME_OBJECT_TYPE_STATE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public GameObjectTypeStateEntity() {

    }

    public GameObjectTypeStateEntity(Long id) {
        this.id = id;
    }

    public GameObjectTypeStateEntity(GameObjectTypeStateEntity entity, Long id) {
        this.id = id;
        this.gameObjectType = entity.gameObjectType;
        this.name = entity.name;
    }

    @ManyToOne
    @JoinColumn(name = "GAME_OBJECT_TYPE_ID")
    private GameObjectTypeEntity gameObjectType;

    @Column(name = "NAME")
    @Size(max = 250)
    private String               name;

    public GameObjectType getGameObjectType() {
        return (GameObjectType) gameObjectType;
    }

    public void setGameObjectType(GameObjectType gameObjectType) {
        this.gameObjectType = (GameObjectTypeEntity) gameObjectType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof GameObjectTypeStateEntity)) {
            return false;
        }

        GameObjectTypeStateEntity other = (GameObjectTypeStateEntity) obj;

        return Objects.equals(this.getId(), other.getId());
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getId()).build();
    }

    public int compareTo(GameObjectTypeState obj) {
        if (obj == this) {
            return 0;
        }

        if (!(obj instanceof GameObjectTypeStateEntity)) {
            return -1;
        }

        GameObjectTypeStateEntity other = (GameObjectTypeStateEntity) obj;

        if (this.getName() == null) {
            return 1;
        }

        if (other.getName() == null) {
            return -1;
        }

        return this.getName().compareTo(other.getName());
    }
}