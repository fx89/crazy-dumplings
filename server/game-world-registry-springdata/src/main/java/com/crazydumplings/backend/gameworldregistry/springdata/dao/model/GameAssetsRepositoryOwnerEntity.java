package com.crazydumplings.backend.gameworldregistry.springdata.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.crazydumplings.gameworldregistry.model.GameAssetsRepository;
import com.crazydumplings.gameworldregistry.model.GameAssetsRepositoryOwner;

@Entity
@Table(name = "GAME_ASSETS_REPOSITORY_OWNER")
public class GameAssetsRepositoryOwnerEntity implements GameAssetsRepositoryOwner {
    @Id
    @Column(name = "ID_GAME_ASSETS_REPOSITORY_OWNER")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long                       id;

    @ManyToOne
    @JoinColumn(name = "GAME_ASSETS_REPOSITORY_ID")
    private GameAssetsRepositoryEntity gameAssetsRepository;

    @Column(name = "OWNER_USER_ID")
    private Long                       ownerUserId;

    public GameAssetsRepositoryOwnerEntity() {
        
    }

    public GameAssetsRepositoryOwnerEntity(GameAssetsRepositoryEntity gameAssetsRepository, Long ownerUserId) {
        this.gameAssetsRepository = gameAssetsRepository;
        this.ownerUserId = ownerUserId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGameAssetsRepository(GameAssetsRepository gameAssetsRepository) {
        this.gameAssetsRepository = (GameAssetsRepositoryEntity) gameAssetsRepository;
    }

    public GameAssetsRepository getGameAssetsRepository() {
        return gameAssetsRepository;
    }

    public Long getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(Long ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

    public int compareTo(GameAssetsRepositoryOwner obj) {
        if (obj == this) {
            return 0;
        }

        if (!(obj instanceof GameAssetsRepositoryOwnerEntity)) {
            return -1;
        }

        GameAssetsRepositoryOwnerEntity other = (GameAssetsRepositoryOwnerEntity) obj;

        if (this.getId() == null) {
            return 1;
        }

        if (other.getId() == null) {
            return -1;
        }

        return this.getId().compareTo(other.getId());
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getId()).build();
    }
}
