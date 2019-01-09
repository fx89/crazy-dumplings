package com.crazydumplings.backend.security.springdata.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.crazydumplings.backend.security.model.Permission;

@Entity
@Table(name = "permissions")
public class PermissionData implements Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;

    public String name;

    public String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

}
