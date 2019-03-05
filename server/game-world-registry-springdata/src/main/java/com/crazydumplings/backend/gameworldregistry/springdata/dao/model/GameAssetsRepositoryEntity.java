package com.crazydumplings.backend.gameworldregistry.springdata.dao.model;

import java.util.Objects;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.crazydumplings.gameworldregistry.model.GameAssetsRepository;

@Entity
@Table(name = "GAME_ASSETS_REPOSITORY")
@Generated(value = "fx.codegen.builder version 1.0.0")
public class GameAssetsRepositoryEntity implements GameAssetsRepository {
    @Id
    @Column(name = "ID_GAME_ASSETS_REPOSITORY")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public GameAssetsRepositoryEntity() {

    }

    public GameAssetsRepositoryEntity(Long id) {
        this.id = id;
    }

    public GameAssetsRepositoryEntity(GameAssetsRepositoryEntity entity, Long id) {
        this.id = id;
        this.uniqueName = entity.uniqueName;
        this.description = entity.description;
    }

    @Column(name = "UNIQUE_NAME")
    @Size(max = 250)
    private String uniqueName;

    @Column(name = "DESCRIPTION")
    private String description;

    public String getUniqueName() {
        return uniqueName;
    }

    public void setUniqueName(String uniqueName) {
        this.uniqueName = uniqueName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof GameAssetsRepositoryEntity)) {
            return false;
        }

        GameAssetsRepositoryEntity other = (GameAssetsRepositoryEntity) obj;

        return Objects.equals(this.getId(), other.getId());
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getId()).build();
    }

    public int compareTo(GameAssetsRepository obj) {
        if (obj == this) {
            return 0;
        }

        if (!(obj instanceof GameAssetsRepositoryEntity)) {
            return -1;
        }

        GameAssetsRepositoryEntity other = (GameAssetsRepositoryEntity) obj;

        if (this.getUniqueName() == null) {
            return 1;
        }

        if (other.getUniqueName() == null) {
            return -1;
        }

        return this.getUniqueName().compareTo(other.getUniqueName());
    }
}