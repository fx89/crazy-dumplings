package com.crazydumplings.backend.security.springdata.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.crazydumplings.backend.security.model.Group;
import com.crazydumplings.backend.security.model.Permission;
import com.crazydumplings.backend.security.springdata.model.GroupPermissionMapData;
import com.crazydumplings.backend.security.springdata.model.PermissionData;

public interface GroupPermissionMapRepository extends CrudRepository<GroupPermissionMapData, Long> {
    List<GroupPermissionMapData> findAllByPermission(PermissionData permission);

    List<GroupPermissionMapData> findAllByGroup(Group group);

    Optional<GroupPermissionMapData> findOneByGroupAndPermission(Group group, Permission permission);
}
