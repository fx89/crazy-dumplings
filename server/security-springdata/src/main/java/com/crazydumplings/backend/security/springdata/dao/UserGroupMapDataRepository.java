package com.crazydumplings.backend.security.springdata.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.crazydumplings.backend.security.springdata.model.GroupData;
import com.crazydumplings.backend.security.springdata.model.UserData;
import com.crazydumplings.backend.security.springdata.model.UserGroupMapData;

public interface UserGroupMapDataRepository extends CrudRepository<UserGroupMapData, Long> {
    Optional<UserGroupMapData> findOneByUserAndGroup(UserData user, GroupData group);

    List<UserGroupMapData> findAllByGroup(GroupData group);

    List<UserGroupMapData> findAllByUser(UserData user);
}
