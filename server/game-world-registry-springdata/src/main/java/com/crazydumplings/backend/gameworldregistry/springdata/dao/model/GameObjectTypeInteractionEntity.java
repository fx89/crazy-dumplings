// package com.crazydumplings.gameregistry.gameassetmanager.dao.model;
package com.crazydumplings.backend.gameworldregistry.springdata.dao.model;

// import com.crazydumplings.gameregistry.gameassetmanager.model.GameObjectTypeInteraction;
import com.crazydumplings.gameworldregistry.model.GameObjectTypeInteraction;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.annotation.Generated;


@Entity
@Table(name = "GAME_OBJECT_TYPE_INTERACTION")
@Generated(value="fx.codegen.builder version 1.0.0")
public class GameObjectTypeInteractionEntity implements GameObjectTypeInteraction {
	@Id
	@Column(name = "ID_GAME_OBJECT_TYPE_INTERACTION")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public GameObjectTypeInteractionEntity() {
		
	}

	public GameObjectTypeInteractionEntity(Long id) {
		this.id = id;
	}

	public GameObjectTypeInteractionEntity(GameObjectTypeInteractionEntity entity, Long id) {
		this.id = id;
		this.donatingGameObjectTypeId = entity.donatingGameObjectTypeId;
		this.receivingGameObjectTypeId = entity.receivingGameObjectTypeId;
		this.radius = entity.radius;
	}

	@Column(name = "DONATING_GAME_OBJECT_TYPE_ID")
	private Long donatingGameObjectTypeId;

	@Column(name = "RECEIVING_GAME_OBJECT_TYPE_ID")
	private Long receivingGameObjectTypeId;

	@Column(name = "RADIUS")
	private Integer radius;

	public Long getDonatingGameObjectTypeId() {
		return donatingGameObjectTypeId;
	}

	public void setDonatingGameObjectTypeId(Long donatingGameObjectTypeId) {
		this.donatingGameObjectTypeId = donatingGameObjectTypeId;
	}

	public Long getReceivingGameObjectTypeId() {
		return receivingGameObjectTypeId;
	}

	public void setReceivingGameObjectTypeId(Long receivingGameObjectTypeId) {
		this.receivingGameObjectTypeId = receivingGameObjectTypeId;
	}

	public Integer getRadius() {
		return radius;
	}

	public void setRadius(Integer radius) {
		this.radius = radius;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof GameObjectTypeInteractionEntity)) {
			return false;
		}

		GameObjectTypeInteractionEntity other = (GameObjectTypeInteractionEntity) obj;

		return Objects.equals(this.getId(), other.getId());
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).build();
	}

	public int compareTo(GameObjectTypeInteraction obj) {
		if (obj == this) {
			return 0;
		}

		if (!(obj instanceof GameObjectTypeInteractionEntity)) {
			return -1;
		}

		GameObjectTypeInteractionEntity other = (GameObjectTypeInteractionEntity) obj;

		if (this.getId() == null) {
			return 1;
		}

		if (other.getId() == null) {
			return -1;
		}

		return this.getId().compareTo(other.getId());
	}
}