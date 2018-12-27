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

import com.crazydumplings.gameworldregistry.model.GameClientType;
import com.crazydumplings.gameworldregistry.model.GameObjectType;
import com.crazydumplings.gameworldregistry.model.GameObjectTypeRepresentation;

@Entity
@Table(name = "GAME_OBJECT_TYPE_REPRESENTATION")
@Generated(value = "fx.codegen.builder version 1.0.0")
public class GameObjectTypeRepresentationEntity implements GameObjectTypeRepresentation {
    @Id
    @Column(name = "ID_GAME_OBJECT_TYPE_REPRESENTATION")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public GameObjectTypeRepresentationEntity() {

    }

    public GameObjectTypeRepresentationEntity(Long id) {
        this.id = id;
    }

    public GameObjectTypeRepresentationEntity(GameObjectTypeRepresentationEntity entity, Long id) {
        this.id = id;
        this.gameObjectType = entity.gameObjectType;
        this.gameClientType = entity.gameClientType;
        this.objectHash = entity.objectHash;
    }

    @ManyToOne
    @JoinColumn(name = "GAME_OBJECT_TYPE_ID")
    private GameObjectTypeEntity gameObjectType;

    @ManyToOne
    @JoinColumn(name = "GAME_CLIENT_TYPE_ID")
    private GameClientTypeEntity gameClientType;

    @Column(name = "OBJECT_HASH")
    private String               objectHash;

    public GameObjectType getGameObjectType() {
        return (GameObjectType) gameObjectType;
    }

    public void setGameObjectType(GameObjectType gameObjectType) {
        this.gameObjectType = (GameObjectTypeEntity) gameObjectType;
    }

    public GameClientType getGameClientType() {
        return (GameClientType) gameClientType;
    }

    public void setGameClientType(GameClientType gameClientType) {
        this.gameClientType = (GameClientTypeEntity) gameClientType;
    }

    public String getObjectHash() {
        return objectHash;
    }

    public void setObjectHash(String objectHash) {
        this.objectHash = objectHash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof GameObjectTypeRepresentationEntity)) {
            return false;
        }

        GameObjectTypeRepresentationEntity other = (GameObjectTypeRepresentationEntity) obj;

        return Objects.equals(this.getId(), other.getId());
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getId()).build();
    }

    public int compareTo(GameObjectTypeRepresentation obj) {
        if (obj == this) {
            return 0;
        }

        if (!(obj instanceof GameObjectTypeRepresentationEntity)) {
            return -1;
        }

        GameObjectTypeRepresentationEntity other = (GameObjectTypeRepresentationEntity) obj;

        if (this.getId() == null) {
            return 1;
        }

        if (other.getId() == null) {
            return -1;
        }

        return this.getId().compareTo(other.getId());
    }
}