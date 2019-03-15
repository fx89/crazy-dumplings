// package com.crazydumplings.gameregistry.gameassetmanager.dao.model;
package com.crazydumplings.backend.gameworldregistry.springdata.dao.model;

// import com.crazydumplings.gameregistry.gameassetmanager.model.GameWorld;
import com.crazydumplings.gameworldregistry.model.GameWorld;

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
@Table(name = "GAME_WORLD")
@Generated(value="fx.codegen.builder version 1.0.0")
public class GameWorldEntity implements GameWorld {
	@Id
	@Column(name = "ID_GAME_WORLD")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public GameWorldEntity() {
		
	}

	public GameWorldEntity(Long id) {
		this.id = id;
	}

	public GameWorldEntity(GameWorldEntity entity, Long id) {
		this.id = id;
		this.uniqueName = entity.uniqueName;
		this.description = entity.description;
		this.pictureRefPath = entity.pictureRefPath;
		this.width = entity.width;
		this.height = entity.height;
	}

	@Column(name = "UNIQUE_NAME")
	@Size(max = 250)
	private String uniqueName;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "PICTURE_REF_PATH")
	private String pictureRefPath;

	@Column(name = "WIDTH")
	private Integer width;

	@Column(name = "HEIGHT")
	private Integer height;

	public String getUniqueName() {
		return uniqueName;
	}

	public void setUniqueName(String uniqueName) {
		this.uniqueName = uniqueName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPictureRefPath() {
		return pictureRefPath;
	}

	public void setPictureRefPath(String pictureRefPath) {
		this.pictureRefPath = pictureRefPath;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof GameWorldEntity)) {
			return false;
		}

		GameWorldEntity other = (GameWorldEntity) obj;

		return Objects.equals(this.getId(), other.getId());
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).build();
	}

	public int compareTo(GameWorld obj) {
		if (obj == this) {
			return 0;
		}

		if (!(obj instanceof GameWorldEntity)) {
			return -1;
		}

		GameWorldEntity other = (GameWorldEntity) obj;

		if (this.getUniqueName() == null) {
			return 1;
		}

		if (other.getUniqueName() == null) {
			return -1;
		}

		return this.getUniqueName().compareTo(other.getUniqueName());
	}
}