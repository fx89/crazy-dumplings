// package com.crazydumplings.gameregistry.gameassetmanager.dao.model;
package com.crazydumplings.backend.gameworldregistry.springdata.dao.model;

// import com.crazydumplings.gameregistry.gameassetmanager.model.GameObjectTypeClass;
import com.crazydumplings.gameworldregistry.model.GameObjectTypeClass;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.annotation.Generated;

import javax.validation.constraints.Size;


@Entity
@Table(name = "GAME_OBJECT_TYPE_CLASS")
@Generated(value="fx.codegen.builder version 1.0.0")
public class GameObjectTypeClassEntity implements GameObjectTypeClass {
	@Id
	@Column(name = "ID_GAME_OBJECT_TYPE_CLASS")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public GameObjectTypeClassEntity() {
		
	}

	public GameObjectTypeClassEntity(Long id) {
		this.id = id;
	}

	private void copyAttributesFromEntity(GameObjectTypeClass gameObjectTypeClass) {
		this.name = gameObjectTypeClass.getName();
	}

	public GameObjectTypeClassEntity(GameObjectTypeClassEntity entity, Long id) {
		this.copyAttributesFromEntity(entity);
		this.id = id;
	}

	public GameObjectTypeClassEntity(GameObjectTypeClassEntity entity) {
		this.copyAttributesFromEntity(entity);
	}

	public GameObjectTypeClassEntity(GameObjectTypeClass gameObjectTypeClass) {
		this.copyAttributesFromEntity(gameObjectTypeClass);
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