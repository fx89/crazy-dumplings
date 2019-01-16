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
import com.crazydumplings.gameworldregistry.model.PlayableCharacterType;

@Entity
@Table(name = "PLAYABLE_CHARACTER_TYPE")
@Generated(value = "fx.codegen.builder version 1.0.0")
public class PlayableCharacterTypeEntity implements PlayableCharacterType {
    @Id
    @Column(name = "ID_PLAYABLE_CHARACTER_TYPE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public PlayableCharacterTypeEntity() {

    }

    public PlayableCharacterTypeEntity(Long id) {
        this.id = id;
    }

    public PlayableCharacterTypeEntity(PlayableCharacterTypeEntity entity, Long id) {
        this.id = id;
        this.uniqueCharacterTypeName = entity.uniqueCharacterTypeName;
        this.gameObjectType = entity.gameObjectType;
    }

    @Column(name = "UNIQUE_CHARACTER_TYPE_NAME")
    @Size(max = 250)
    private String               uniqueCharacterTypeName;

    @ManyToOne
    @JoinColumn(name = "GAME_OBJECT_TYPE_ID")
    private GameObjectTypeEntity gameObjectType;

    public String getUniqueCharacterTypeName() {
        return uniqueCharacterTypeName;
    }

    public void setUniqueCharacterTypeName(String uniqueCharacterTypeName) {
        this.uniqueCharacterTypeName = uniqueCharacterTypeName;
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

        if (!(obj instanceof PlayableCharacterTypeEntity)) {
            return false;
        }

        PlayableCharacterTypeEntity other = (PlayableCharacterTypeEntity) obj;

        return Objects.equals(this.getId(), other.getId());
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getId()).build();
    }

    public int compareTo(PlayableCharacterType obj) {
        if (obj == this) {
            return 0;
        }

        if (!(obj instanceof PlayableCharacterTypeEntity)) {
            return -1;
        }

        PlayableCharacterTypeEntity other = (PlayableCharacterTypeEntity) obj;

        if (this.getUniqueCharacterTypeName() == null) {
            return 1;
        }

        if (other.getUniqueCharacterTypeName() == null) {
            return -1;
        }

        return this.getUniqueCharacterTypeName().compareTo(other.getUniqueCharacterTypeName());
    }
}