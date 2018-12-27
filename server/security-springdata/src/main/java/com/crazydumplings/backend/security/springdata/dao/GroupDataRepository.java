package com.crazydumplings.backend.security.springdata.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.crazydumplings.backend.security.springdata.model.GroupData;

public interface GroupDataRepository extends CrudRepository<GroupData, Long> {
    Optional<GroupData> findOneByName(String name);
}
