// package com.crazydumplings.gameregistry.gameassetmanager.dao.model;
package com.crazydumplings.backend.gameworldregistry.springdata.dao.model;

// import com.crazydumplings.gameregistry.gameassetmanager.model.Action;
import com.crazydumplings.gameworldregistry.model.Action;

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
@Table(name = "ACTION")
@Generated(value="fx.codegen.builder version 1.0.0")
public class ActionEntity implements Action {
	@Id
	@Column(name = "ID_ACTION")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public ActionEntity() {
		
	}

	public ActionEntity(Long id) {
		this.id = id;
	}

	private void copyAttributesFromEntity(Action action) {
		this.uniqueName = action.getUniqueName();
	}

	public ActionEntity(ActionEntity entity, Long id) {
		this.copyAttributesFromEntity(entity);
		this.id = id;
	}

	public ActionEntity(ActionEntity entity) {
		this.copyAttributesFromEntity(entity);
	}

	public ActionEntity(Action action) {
		this.copyAttributesFromEntity(action);
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

		if (!(obj instanceof ActionEntity)) {
			return false;
		}

		ActionEntity other = (ActionEntity) obj;

		return Objects.equals(this.getId(), other.getId());
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).build();
	}

	public int compareTo(Action obj) {
		if (obj == this) {
			return 0;
		}

		if (!(obj instanceof ActionEntity)) {
			return -1;
		}

		ActionEntity other = (ActionEntity) obj;

		if (this.getUniqueName() == null) {
			return 1;
		}

		if (other.getUniqueName() == null) {
			return -1;
		}

		return this.getUniqueName().compareTo(other.getUniqueName());
	}
}