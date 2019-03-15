// package com.crazydumplings.gameregistry.gameassetmanager.dao.model;
package com.crazydumplings.backend.gameworldregistry.springdata.dao.model;

// import com.crazydumplings.gameregistry.gameassetmanager.model.GameObjectTypeInteractionProperty;
import com.crazydumplings.gameworldregistry.model.GameObjectTypeInteractionProperty;

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
@Table(name = "GAME_OBJECT_TYPE_INTERACTION_PROPERTY")
@Generated(value="fx.codegen.builder version 1.0.0")
public class GameObjectTypeInteractionPropertyEntity implements GameObjectTypeInteractionProperty {
	@Id
	@Column(name = "ID_GAME_OBJECT_TYPE_INTERACTION_PROPERTY")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public GameObjectTypeInteractionPropertyEntity() {
		
	}

	public GameObjectTypeInteractionPropertyEntity(Long id) {
		this.id = id;
	}

	public GameObjectTypeInteractionPropertyEntity(GameObjectTypeInteractionPropertyEntity entity, Long id) {
		this.id = id;
		this.gameObjectTypeInteractionId = entity.gameObjectTypeInteractionId;
		this.donatingGameObjectTypePropertyId = entity.donatingGameObjectTypePropertyId;
		this.receivingGameObjectTypePropertyId = entity.receivingGameObjectTypePropertyId;
		this.overflowGameObjectTypePropertyId = entity.overflowGameObjectTypePropertyId;
		this.isIncremental = entity.isIncremental;
		this.isInverted = entity.isInverted;
	}

	@Column(name = "GAME_OBJECT_TYPE_INTERACTION_ID")
	private Long gameObjectTypeInteractionId;

	@Column(name = "DONATING_GAME_OBJECT_TYPE_PROPERTY_ID")
	private Long donatingGameObjectTypePropertyId;

	@Column(name = "RECEIVING_GAME_OBJECT_TYPE_PROPERTY_ID")
	private Long receivingGameObjectTypePropertyId;

	@Column(name = "OVERFLOW_GAME_OBJECT_TYPE_PROPERTY_ID")
	private Long overflowGameObjectTypePropertyId;

	@Column(name = "IS_INCREMENTAL")
	private Boolean isIncremental;

	@Column(name = "IS_INVERTED")
	private Boolean isInverted;

	public Long getGameObjectTypeInteractionId() {
		return gameObjectTypeInteractionId;
	}

	public void setGameObjectTypeInteractionId(Long gameObjectTypeInteractionId) {
		this.gameObjectTypeInteractionId = gameObjectTypeInteractionId;
	}

	public Long getDonatingGameObjectTypePropertyId() {
		return donatingGameObjectTypePropertyId;
	}

	public void setDonatingGameObjectTypePropertyId(Long donatingGameObjectTypePropertyId) {
		this.donatingGameObjectTypePropertyId = donatingGameObjectTypePropertyId;
	}

	public Long getReceivingGameObjectTypePropertyId() {
		return receivingGameObjectTypePropertyId;
	}

	public void setReceivingGameObjectTypePropertyId(Long receivingGameObjectTypePropertyId) {
		this.receivingGameObjectTypePropertyId = receivingGameObjectTypePropertyId;
	}

	public Long getOverflowGameObjectTypePropertyId() {
		return overflowGameObjectTypePropertyId;
	}

	public void setOverflowGameObjectTypePropertyId(Long overflowGameObjectTypePropertyId) {
		this.overflowGameObjectTypePropertyId = overflowGameObjectTypePropertyId;
	}

	public Boolean getIsIncremental() {
		return isIncremental;
	}

	public void setIsIncremental(Boolean isIncremental) {
		this.isIncremental = isIncremental;
	}

	public Boolean getIsInverted() {
		return isInverted;
	}

	public void setIsInverted(Boolean isInverted) {
		this.isInverted = isInverted;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof GameObjectTypeInteractionPropertyEntity)) {
			return false;
		}

		GameObjectTypeInteractionPropertyEntity other = (GameObjectTypeInteractionPropertyEntity) obj;

		return Objects.equals(this.getId(), other.getId());
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).build();
	}

	public int compareTo(GameObjectTypeInteractionProperty obj) {
		if (obj == this) {
			return 0;
		}

		if (!(obj instanceof GameObjectTypeInteractionPropertyEntity)) {
			return -1;
		}

		GameObjectTypeInteractionPropertyEntity other = (GameObjectTypeInteractionPropertyEntity) obj;

		if (this.getId() == null) {
			return 1;
		}

		if (other.getId() == null) {
			return -1;
		}

		return this.getId().compareTo(other.getId());
	}
}