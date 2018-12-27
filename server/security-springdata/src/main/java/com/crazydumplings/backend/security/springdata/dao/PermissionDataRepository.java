package com.crazydumplings.backend.security.springdata.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.crazydumplings.backend.security.springdata.model.PermissionData;

public interface PermissionDataRepository extends CrudRepository<PermissionData, Long> {
    Optional<PermissionData> findOneByName(String name);
}
