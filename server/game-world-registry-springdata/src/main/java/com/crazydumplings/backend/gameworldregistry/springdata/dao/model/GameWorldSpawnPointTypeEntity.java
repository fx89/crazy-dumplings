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

import com.crazydumplings.gameworldregistry.model.GameObjectType;
import com.crazydumplings.gameworldregistry.model.GameWorldSpawnPointType;

@Entity
@Table(name = "GAME_WORLD_SPAWN_POINT_TYPE")
@Generated(value = "fx.codegen.builder version 1.0.0")
public class GameWorldSpawnPointTypeEntity implements GameWorldSpawnPointType {
    @Id
    @Column(name = "ID_GAME_WORLD_SPAWN_POINT_TYPE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public GameWorldSpawnPointTypeEntity() {

    }

    public GameWorldSpawnPointTypeEntity(Long id) {
        this.id = id;
    }

    public GameWorldSpawnPointTypeEntity(GameWorldSpawnPointTypeEntity entity, Long id) {
        this.id = id;
        this.spawnPointGameObjectType = entity.spawnPointGameObjectType;
        this.spawnedGameObjectType = entity.spawnedGameObjectType;
    }

    @ManyToOne
    @JoinColumn(name = "SPAWN_POINT_GAME_OBJECT_TYPE_ID")
    private GameObjectTypeEntity spawnPointGameObjectType;

    @ManyToOne
    @JoinColumn(name = "SPAWNED_GAME_OBJECT_TYPE_ID")
    private GameObjectTypeEntity spawnedGameObjectType;

    public GameObjectType getSpawnPointGameObjectType() {
        return (GameObjectType) spawnPointGameObjectType;
    }

    public void setSpawnPointGameObjectType(GameObjectType spawnPointGameObjectType) {
        this.spawnPointGameObjectType = (GameObjectTypeEntity) spawnPointGameObjectType;
    }

    public GameObjectType getSpawnedGameObjectType() {
        return (GameObjectType) spawnedGameObjectType;
    }

    public void setSpawnedGameObjectType(GameObjectType spawnedGameObjectType) {
        this.spawnedGameObjectType = (GameObjectTypeEntity) spawnedGameObjectType;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof GameWorldSpawnPointTypeEntity)) {
            return false;
        }

        GameWorldSpawnPointTypeEntity other = (GameWorldSpawnPointTypeEntity) obj;

        return Objects.equals(this.getId(), other.getId());
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getId()).build();
    }

    public int compareTo(GameWorldSpawnPointType obj) {
        if (obj == this) {
            return 0;
        }

        if (!(obj instanceof GameWorldSpawnPointTypeEntity)) {
            return -1;
        }

        GameWorldSpawnPointTypeEntity other = (GameWorldSpawnPointTypeEntity) obj;

        if (this.getId() == null) {
            return 1;
        }

        if (other.getId() == null) {
            return -1;
        }

        return this.getId().compareTo(other.getId());
    }
}