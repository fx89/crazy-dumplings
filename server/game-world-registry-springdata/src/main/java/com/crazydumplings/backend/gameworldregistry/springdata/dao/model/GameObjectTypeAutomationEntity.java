// package com.crazydumplings.gameregistry.gameassetmanager.dao.model;
package com.crazydumplings.backend.gameworldregistry.springdata.dao.model;

// import com.crazydumplings.gameregistry.gameassetmanager.model.GameObjectTypeAutomation;
import com.crazydumplings.gameworldregistry.model.GameObjectTypeAutomation;

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
@Table(name = "GAME_OBJECT_TYPE_AUTOMATION")
@Generated(value="fx.codegen.builder version 1.0.0")
public class GameObjectTypeAutomationEntity implements GameObjectTypeAutomation {
	@Id
	@Column(name = "ID_GAME_OBJECT_TYPE_AUTOMATION")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public GameObjectTypeAutomationEntity() {
		
	}

	public GameObjectTypeAutomationEntity(Long id) {
		this.id = id;
	}

	public GameObjectTypeAutomationEntity(GameObjectTypeAutomationEntity entity, Long id) {
		this.id = id;
		this.gameObjectTypeId = entity.gameObjectTypeId;
		this.automationObjectProviderId = entity.automationObjectProviderId;
	}

	@Column(name = "GAME_OBJECT_TYPE_ID")
	private Long gameObjectTypeId;

	@Column(name = "AUTOMATION_OBJECT_PROVIDER_ID")
	private Long automationObjectProviderId;

	public Long getGameObjectTypeId() {
		return gameObjectTypeId;
	}

	public void setGameObjectTypeId(Long gameObjectTypeId) {
		this.gameObjectTypeId = gameObjectTypeId;
	}

	public Long getAutomationObjectProviderId() {
		return automationObjectProviderId;
	}

	public void setAutomationObjectProviderId(Long automationObjectProviderId) {
		this.automationObjectProviderId = automationObjectProviderId;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof GameObjectTypeAutomationEntity)) {
			return false;
		}

		GameObjectTypeAutomationEntity other = (GameObjectTypeAutomationEntity) obj;

		return Objects.equals(this.getId(), other.getId());
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).build();
	}

	public int compareTo(GameObjectTypeAutomation obj) {
		if (obj == this) {
			return 0;
		}

		if (!(obj instanceof GameObjectTypeAutomationEntity)) {
			return -1;
		}

		GameObjectTypeAutomationEntity other = (GameObjectTypeAutomationEntity) obj;

		if (this.getId() == null) {
			return 1;
		}

		if (other.getId() == null) {
			return -1;
		}

		return this.getId().compareTo(other.getId());
	}
}