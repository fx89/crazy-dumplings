package com.crazydumplings.backend.security.springdata.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.crazydumplings.backend.security.springdata.model.UserData;

public interface UserDataRepository extends CrudRepository<UserData, Long> {
    Optional<UserData> findOneByUserName(String userName);

    @Query(value = "SELECT u FROM UserData u INNER JOIN UserGroupMapData m INNER JOIN GroupData g WHERE g.id = ?1")
    List<UserData> findAllByGroupId(Long groupId);
}
