package com.crazydumplings.backend.security.model;

public interface GroupPermissionMap {
    Group getGroup();

    void setGroup(Group group);

    Permission getPermission();

    void setPermission(Permission permission);
}
