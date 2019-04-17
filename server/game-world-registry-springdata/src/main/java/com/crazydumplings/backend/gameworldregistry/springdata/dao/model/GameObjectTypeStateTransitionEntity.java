// package com.crazydumplings.gameregistry.gameassetmanager.dao.model;
package com.crazydumplings.backend.gameworldregistry.springdata.dao.model;

// import com.crazydumplings.gameregistry.gameassetmanager.model.GameObjectTypeStateTransition;
import com.crazydumplings.gameworldregistry.model.GameObjectTypeStateTransition;

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
@Table(name = "GAME_OBJECT_TYPE_STATE_TRANSITION")
@Generated(value="fx.codegen.builder version 1.0.0")
public class GameObjectTypeStateTransitionEntity implements GameObjectTypeStateTransition {
	@Id
	@Column(name = "ID_GAME_OBJECT_TYPE_STATE_TRANSITION")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public GameObjectTypeStateTransitionEntity() {
		
	}

	public GameObjectTypeStateTransitionEntity(Long id) {
		this.id = id;
	}

	private void copyAttributesFromEntity(GameObjectTypeStateTransition gameObjectTypeStateTransition) {
		this.sourceGameObjectTypeStateId = gameObjectTypeStateTransition.getSourceGameObjectTypeStateId();
		this.targetGameObjectTypeStateId = gameObjectTypeStateTransition.getTargetGameObjectTypeStateId();
		this.isAutomatic = gameObjectTypeStateTransition.getIsAutomatic();
		this.triggerActionId = gameObjectTypeStateTransition.getTriggerActionId();
	}

	public GameObjectTypeStateTransitionEntity(GameObjectTypeStateTransitionEntity entity, Long id) {
		this.copyAttributesFromEntity(entity);
		this.id = id;
	}

	public GameObjectTypeStateTransitionEntity(GameObjectTypeStateTransitionEntity entity) {
		this.copyAttributesFromEntity(entity);
	}

	public GameObjectTypeStateTransitionEntity(GameObjectTypeStateTransition gameObjectTypeStateTransition) {
		this.copyAttributesFromEntity(gameObjectTypeStateTransition);
	}

	@Column(name = "SOURCE_GAME_OBJECT_TYPE_STATE_ID")
	private Long sourceGameObjectTypeStateId;

	@Column(name = "TARGET_GAME_OBJECT_TYPE_STATE_ID")
	private Long targetGameObjectTypeStateId;

	@Column(name = "IS_AUTOMATIC")
	private Boolean isAutomatic;

	@Column(name = "TRIGGER_ACTION_ID")
	private Long triggerActionId;

	public Long getSourceGameObjectTypeStateId() {
		return sourceGameObjectTypeStateId;
	}

	public void setSourceGameObjectTypeStateId(Long sourceGameObjectTypeStateId) {
		this.sourceGameObjectTypeStateId = sourceGameObjectTypeStateId;
	}

	public Long getTargetGameObjectTypeStateId() {
		return targetGameObjectTypeStateId;
	}

	public void setTargetGameObjectTypeStateId(Long targetGameObjectTypeStateId) {
		this.targetGameObjectTypeStateId = targetGameObjectTypeStateId;
	}

	public Boolean getIsAutomatic() {
		return isAutomatic;
	}

	public void setIsAutomatic(Boolean isAutomatic) {
		this.isAutomatic = isAutomatic;
	}

	public Long getTriggerActionId() {
		return triggerActionId;
	}

	public void setTriggerActionId(Long triggerActionId) {
		this.triggerActionId = triggerActionId;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof GameObjectTypeStateTransitionEntity)) {
			return false;
		}

		GameObjectTypeStateTransitionEntity other = (GameObjectTypeStateTransitionEntity) obj;

		return Objects.equals(this.getId(), other.getId());
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).build();
	}

	public int compareTo(GameObjectTypeStateTransition obj) {
		if (obj == this) {
			return 0;
		}

		if (!(obj instanceof GameObjectTypeStateTransitionEntity)) {
			return -1;
		}

		GameObjectTypeStateTransitionEntity other = (GameObjectTypeStateTransitionEntity) obj;

		if (this.getId() == null) {
			return 1;
		}

		if (other.getId() == null) {
			return -1;
		}

		return this.getId().compareTo(other.getId());
	}
}