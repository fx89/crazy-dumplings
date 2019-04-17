// package com.crazydumplings.gameregistry.gameassetmanager.dao.model;
package com.crazydumplings.backend.gameworldregistry.springdata.dao.model;

// import com.crazydumplings.gameregistry.gameassetmanager.model.AutomationObjectProvider;
import com.crazydumplings.gameworldregistry.model.AutomationObjectProvider;

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
@Table(name = "AUTOMATION_OBJECT_PROVIDER")
@Generated(value="fx.codegen.builder version 1.0.0")
public class AutomationObjectProviderEntity implements AutomationObjectProvider {
	@Id
	@Column(name = "ID_AUTOMATION_OBJECT_PROVIDER")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public AutomationObjectProviderEntity() {
		
	}

	public AutomationObjectProviderEntity(Long id) {
		this.id = id;
	}

	private void copyAttributesFromEntity(AutomationObjectProvider automationObjectProvider) {
		this.name = automationObjectProvider.getName();
	}

	public AutomationObjectProviderEntity(AutomationObjectProviderEntity entity, Long id) {
		this.copyAttributesFromEntity(entity);
		this.id = id;
	}

	public AutomationObjectProviderEntity(AutomationObjectProviderEntity entity) {
		this.copyAttributesFromEntity(entity);
	}

	public AutomationObjectProviderEntity(AutomationObjectProvider automationObjectProvider) {
		this.copyAttributesFromEntity(automationObjectProvider);
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

		if (!(obj instanceof AutomationObjectProviderEntity)) {
			return false;
		}

		AutomationObjectProviderEntity other = (AutomationObjectProviderEntity) obj;

		return Objects.equals(this.getId(), other.getId());
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).build();
	}

	public int compareTo(AutomationObjectProvider obj) {
		if (obj == this) {
			return 0;
		}

		if (!(obj instanceof AutomationObjectProviderEntity)) {
			return -1;
		}

		AutomationObjectProviderEntity other = (AutomationObjectProviderEntity) obj;

		if (this.getName() == null) {
			return 1;
		}

		if (other.getName() == null) {
			return -1;
		}

		return this.getName().compareTo(other.getName());
	}
}