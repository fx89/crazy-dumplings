package com.crazydumplings.backend.security.springdata.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.crazydumplings.backend.security.model.Group;
import com.crazydumplings.backend.security.model.GroupPermissionMap;
import com.crazydumplings.backend.security.model.Permission;

@Entity
@Table(name = "group_permission_maps")
public class GroupPermissionMapData implements GroupPermissionMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long           Id;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private GroupData      group;

    @ManyToOne
    @JoinColumn(name = "permission_id")
    private PermissionData permission;

    @Override
    public Group getGroup() {
        return group;
    }

    @Override
    public void setGroup(Group group) {
        this.group = (GroupData) group;
    }

    @Override
    public Permission getPermission() {
        return permission;
    }

    @Override
    public void setPermission(Permission permission) {
        this.permission = (PermissionData) permission;
    }

}
