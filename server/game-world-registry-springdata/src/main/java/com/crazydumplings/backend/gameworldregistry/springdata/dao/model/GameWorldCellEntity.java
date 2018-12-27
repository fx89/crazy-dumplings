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

import com.crazydumplings.gameworldregistry.model.GameWorld;
import com.crazydumplings.gameworldregistry.model.GameWorldCell;
import com.crazydumplings.gameworldregistry.model.GameWorldCellType;
import com.crazydumplings.gameworldregistry.model.GameWorldSpawnPointType;

@Entity
@Table(name = "GAME_WORLD_CELL")
@Generated(value = "fx.codegen.builder version 1.0.0")
public class GameWorldCellEntity implements GameWorldCell {
    @Id
    @Column(name = "ID_GAME_WORLD_CELL")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public GameWorldCellEntity() {

    }

    public GameWorldCellEntity(Long id) {
        this.id = id;
    }

    public GameWorldCellEntity(GameWorldCellEntity entity, Long id) {
        this.id = id;
        this.gameWorld = entity.gameWorld;
        this.gameWorldCellType = entity.gameWorldCellType;
        this.xIndex = entity.xIndex;
        this.yIndex = entity.yIndex;
        this.attachedGameWorldSpawnPointType = entity.attachedGameWorldSpawnPointType;
    }

    @ManyToOne
    @JoinColumn(name = "GAME_WORLD_ID")
    private GameWorldEntity               gameWorld;

    @ManyToOne
    @JoinColumn(name = "GAME_WORLD_CELL_TYPE_ID")
    private GameWorldCellTypeEntity       gameWorldCellType;

    @Column(name = "X_INDEX")
    private Integer                       xIndex;

    @Column(name = "Y_INDEX")
    private Integer                       yIndex;

    @ManyToOne
    @JoinColumn(name = "ATTACHED_GAME_WORLD_SPAWN_POINT_TYPE_ID")
    private GameWorldSpawnPointTypeEntity attachedGameWorldSpawnPointType;

    public GameWorld getGameWorld() {
        return (GameWorld) gameWorld;
    }

    public void setGameWorld(GameWorld gameWorld) {
        this.gameWorld = (GameWorldEntity) gameWorld;
    }

    public GameWorldCellType getGameWorldCellType() {
        return (GameWorldCellType) gameWorldCellType;
    }

    public void setGameWorldCellType(GameWorldCellType gameWorldCellType) {
        this.gameWorldCellType = (GameWorldCellTypeEntity) gameWorldCellType;
    }

    public Integer getXIndex() {
        return xIndex;
    }

    public void setXIndex(Integer xIndex) {
        this.xIndex = xIndex;
    }

    public Integer getYIndex() {
        return yIndex;
    }

    public void setYIndex(Integer yIndex) {
        this.yIndex = yIndex;
    }

    public GameWorldSpawnPointType getAttachedGameWorldSpawnPointType() {
        return (GameWorldSpawnPointType) attachedGameWorldSpawnPointType;
    }

    public void setAttachedGameWorldSpawnPointType(GameWorldSpawnPointType attachedGameWorldSpawnPointType) {
        this.attachedGameWorldSpawnPointType = (GameWorldSpawnPointTypeEntity) attachedGameWorldSpawnPointType;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof GameWorldCellEntity)) {
            return false;
        }

        GameWorldCellEntity other = (GameWorldCellEntity) obj;

        return Objects.equals(this.getId(), other.getId());
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getId()).build();
    }

    public int compareTo(GameWorldCell obj) {
        if (obj == this) {
            return 0;
        }

        if (!(obj instanceof GameWorldCellEntity)) {
            return -1;
        }

        GameWorldCellEntity other = (GameWorldCellEntity) obj;

        if (this.getId() == null) {
            return 1;
        }

        if (other.getId() == null) {
            return -1;
        }

        return this.getId().compareTo(other.getId());
    }
}