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

import com.crazydumplings.gameworldregistry.model.GameAssetsRepository;
import com.crazydumplings.gameworldregistry.model.GameObjectType;
import com.crazydumplings.gameworldregistry.model.GameObjectTypeClass;

@Entity
@Table(name = "GAME_OBJECT_TYPE")
@Generated(value = "fx.codegen.builder version 1.0.0")
public class GameObjectTypeEntity implements GameObjectType {
    @Id
    @Column(name = "ID_GAME_OBJECT_TYPE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public GameObjectTypeEntity() {

    }

    public GameObjectTypeEntity(Long id) {
        this.id = id;
    }

    public GameObjectTypeEntity(GameObjectTypeEntity entity, Long id) {
        this.id = id;
        this.gameAssetsRepository = entity.gameAssetsRepository;
        this.gameObjectTypeClass = entity.gameObjectTypeClass;
        this.uniqueName = entity.uniqueName;
        this.isExperimental = entity.isExperimental;
    }

    @ManyToOne
    @JoinColumn(name = "GAME_ASSETS_REPOSITORY_ID")
    private GameAssetsRepositoryEntity gameAssetsRepository;

    @ManyToOne
    @JoinColumn(name = "GAME_OBJECT_TYPE_CLASS_ID")
    private GameObjectTypeClassEntity  gameObjectTypeClass;

    @Column(name = "UNIQUE_NAME")
    @Size(max = 250)
    private String                     uniqueName;

    @Column(name = "IS_EXPERIMENTAL")
    private Boolean                    isExperimental;

    public GameAssetsRepository getGameAssetsRepository() {
        return (GameAssetsRepository) gameAssetsRepository;
    }

    public void setGameAssetsRepository(GameAssetsRepository gameAssetsRepository) {
        this.gameAssetsRepository = (GameAssetsRepositoryEntity) gameAssetsRepository;
    }

    public GameObjectTypeClass getGameObjectTypeClass() {
        return (GameObjectTypeClass) gameObjectTypeClass;
    }

    public void setGameObjectTypeClass(GameObjectTypeClass gameObjectTypeClass) {
        this.gameObjectTypeClass = (GameObjectTypeClassEntity) gameObjectTypeClass;
    }

    public String getUniqueName() {
        return uniqueName;
    }

    public void setUniqueName(String uniqueName) {
        this.uniqueName = uniqueName;
    }

    public Boolean getIsExperimental() {
        return isExperimental;
    }

    public void setIsExperimental(Boolean isExperimental) {
        this.isExperimental = isExperimental;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof GameObjectTypeEntity)) {
            return false;
        }

        GameObjectTypeEntity other = (GameObjectTypeEntity) obj;

        return Objects.equals(this.getId(), other.getId());
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getId()).build();
    }

    public int compareTo(GameObjectType obj) {
        if (obj == this) {
            return 0;
        }

        if (!(obj instanceof GameObjectTypeEntity)) {
            return -1;
        }

        GameObjectTypeEntity other = (GameObjectTypeEntity) obj;

        if (this.getUniqueName() == null) {
            return 1;
        }

        if (other.getUniqueName() == null) {
            return -1;
        }

        return this.getUniqueName().compareTo(other.getUniqueName());
    }
}