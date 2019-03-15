// package com.crazydumplings.gameregistry.gameassetmanager.dao.model;
package com.crazydumplings.backend.gameworldregistry.springdata.dao.model;

// import com.crazydumplings.gameregistry.gameassetmanager.model.GameClientType;
import com.crazydumplings.gameworldregistry.model.GameClientType;

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
@Table(name = "GAME_CLIENT_TYPE")
@Generated(value="fx.codegen.builder version 1.0.0")
public class GameClientTypeEntity implements GameClientType {
	@Id
	@Column(name = "ID_GAME_CLIENT_TYPE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public GameClientTypeEntity() {
		
	}

	public GameClientTypeEntity(Long id) {
		this.id = id;
	}

	public GameClientTypeEntity(GameClientTypeEntity entity, Long id) {
		this.id = id;
		this.uniqueName = entity.uniqueName;
	}

	@Column(name = "UNIQUE_NAME")
	@Size(max = 250)
	private String uniqueName;

	public String getUniqueName() {
		return uniqueName;
	}

	public void setUniqueName(String uniqueName) {
		this.uniqueName = uniqueName;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof GameClientTypeEntity)) {
			return false;
		}

		GameClientTypeEntity other = (GameClientTypeEntity) obj;

		return Objects.equals(this.getId(), other.getId());
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).build();
	}

	public int compareTo(GameClientType obj) {
		if (obj == this) {
			return 0;
		}

		if (!(obj instanceof GameClientTypeEntity)) {
			return -1;
		}

		GameClientTypeEntity other = (GameClientTypeEntity) obj;

		if (this.getUniqueName() == null) {
			return 1;
		}

		if (other.getUniqueName() == null) {
			return -1;
		}

		return this.getUniqueName().compareTo(other.getUniqueName());
	}
}