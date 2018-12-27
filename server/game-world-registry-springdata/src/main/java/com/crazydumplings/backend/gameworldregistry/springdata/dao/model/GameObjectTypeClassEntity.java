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

import com.crazydumplings.gameworldregistry.model.GameObjectTypeClass;

@Entity
@Table(name = "GAME_OBJECT_TYPE_CLASS")
@Generated(value = "fx.codegen.builder version 1.0.0")
public class GameObjectTypeClassEntity implements GameObjectTypeClass {
    @Id
    @Column(name = "ID_GAME_OBJECT_TYPE_CLASS")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public GameObjectTypeClassEntity() {

    }

    public GameObjectTypeClassEntity(Long id) {
        this.id = id;
    }

    public GameObjectTypeClassEntity(GameObjectTypeClassEntity entity, Long id) {
        this.id = id;
        this.name = entity.name;
    }

    @Column(name = "NAME")
    @Size(max = 250)
    private String name;

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

        if (!(obj instanceof GameObjectTypeClassEntity)) {
            return false;
        }

        GameObjectTypeClassEntity other = (GameObjectTypeClassEntity) obj;

        return Objects.equals(this.getId(), other.getId());
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getId()).build();
    }

    public int compareTo(GameObjectTypeClass obj) {
        if (obj == this) {
            return 0;
        }

        if (!(obj instanceof GameObjectTypeClassEntity)) {
            return -1;
        }

        GameObjectTypeClassEntity other = (GameObjectTypeClassEntity) obj;

        if (this.getName() == null) {
            return 1;
        }

        if (other.getName() == null) {
            return -1;
        }

        return this.getName().compareTo(other.getName());
    }
}