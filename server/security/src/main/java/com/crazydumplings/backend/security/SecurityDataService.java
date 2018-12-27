package com.crazydumplings.backend.security;

import java.util.List;
import java.util.Optional;

import com.crazydumplings.backend.security.exception.CrazyDumplingsSecurityException;
import com.crazydumplings.backend.security.model.Group;
import com.crazydumplings.backend.security.model.GroupPermissionMap;
import com.crazydumplings.backend.security.model.Permission;
import com.crazydumplings.backend.security.model.User;
import com.crazydumplings.backend.security.model.UserGroupMap;

/**
 * Provides access to user-related information
 */
public interface SecurityDataService {

    /**
     * Returns a list of all users in the system
     */
    List<User> getUsers() throws CrazyDumplingsSecurityException;

    /**
     * Returns a list of users in the repository. Throws exceptions in case of unexpected results.
     */
    List<User> getUsersInGroup(Group group) throws CrazyDumplingsSecurityException;

    /**
     * Returns a reference to the user having the given user name. Throws exceptions if such a user does not exist or in case of other
     * unexpected results.
     */
    Optional<User> getUserByUserName(String userName) throws CrazyDumplingsSecurityException;

    /**
     * Returns a reference to the user having the given user id.
     */
    Optional<User> getUserById(Long userId) throws CrazyDumplingsSecurityException;

    /**
     * Adds a user with the given properties, updates it and returns a reference.
     */
    User addUser(String userName, String userFullName, String encodedPassword) throws CrazyDumplingsSecurityException, IllegalArgumentException;

    /**
     * Removes the referenced user from the repository. Throws an exception in case the user does not exist or if anything weird happens.
     */
    void removeUser(User existingUser) throws CrazyDumplingsSecurityException;

    /**
     * Updates the given user and returns a reference. Throws an exception if the user does not exist or anything funny.
     */
    User saveUser(User user) throws CrazyDumplingsSecurityException;

    /**
     * Adds a new group having the provided name and returns a reference
     */
    Group addGroup(String groupName) throws CrazyDumplingsSecurityException;

    /**
     * Returns a reference to the group having the given name. Throws exceptions if the group is not found or in case of other unexpected
     * results.
     */
    Optional<Group> getGroupByName(String groupName) throws CrazyDumplingsSecurityException;

    /**
     * Returns a list of groups in the repository. Throws exceptions in case of unexpected results.
     */
    List<Group> getGroups() throws CrazyDumplingsSecurityException;

    /**
     * Removes the referenced group. Throws exceptions in case of unexpected results.
     */
    void removeGroup(Group group) throws CrazyDumplingsSecurityException;

    /**
     * Adds the referenced user to the referenced group. Throws exceptions in case of unexpected results.
     */
    UserGroupMap addUserToGroup(User user, Group group) throws CrazyDumplingsSecurityException;

    /**
     * Removes the referenced user from the referenced group. Throws exceptions in case of unexpected results.
     */
    void removeUserGroupMap(UserGroupMap userGroup) throws CrazyDumplingsSecurityException;

    /**
     * Returns a reference to the map entry for the referenced user and group. Throws exceptions in case of unexpected results.
     */
    Optional<UserGroupMap> getUserGroupMap(User user, Group group) throws CrazyDumplingsSecurityException;

    /**
     * Returns a reference to the map entries for the referenced group. Throws exceptions in case of unexpected results.
     */
    List<UserGroupMap> getUserGroupMapByGroup(Group group) throws CrazyDumplingsSecurityException;

    /**
     * Returns a reference to the map entries for the referenced user. Throws exceptions in case of unexpected results.
     */
    List<UserGroupMap> getUserGroupMapByUser(User user) throws CrazyDumplingsSecurityException;

    /**
     * Adds a permission with the referenced name and returns a new reference. Throws exceptions in case of unexpected results.
     */
    Permission addPermission(String permissionName) throws CrazyDumplingsSecurityException;

    /**
     * Returns a referenced to the permission with the given name. Throws exceptions in case of unexpected results.
     */
    Optional<Permission> getPermissionByName(String permissionName) throws CrazyDumplingsSecurityException;

    /**
     * Adds the referenced permission to the referenced group and returns a new reference. Throws exceptions in case of unexpected results.
     */
    GroupPermissionMap addPermissionToGroup(Permission permission, Group group) throws CrazyDumplingsSecurityException;

    /**
     * Removes the referenced permission. Throws exceptions in case of unexpected results.
     */
    void removePermission(Permission permission) throws CrazyDumplingsSecurityException;

    /**
     * Fetches the group-permission mappings for the referenced permission. Throws exceptions in case of unexpected results.
     */
    List<GroupPermissionMap> getGroupPermissionMapsByPermission(Permission permission) throws CrazyDumplingsSecurityException;

    /**
     * Returns the group/permission map uniquely identified by the referenced group and permission.
     */
    Optional<GroupPermissionMap> getGroupPerissionMap(Group group, Permission permission) throws CrazyDumplingsSecurityException;

    /**
     * Fetches the group-permission mappings for the referenced group. Throws exceptions in case of unexpected results.
     */
    List<GroupPermissionMap> getGroupPermissionMapsByGroup(Group group) throws CrazyDumplingsSecurityException;

    /**
     * Removes the referenced group-permission map. Throws exceptions in case of unexpected results.
     */
    void removeGroupPermissionMap(GroupPermissionMap gpMap) throws CrazyDumplingsSecurityException;

    /**
     * Returns a list of unique permissions available in the system
     */
    List<Permission> getAllPermissions() throws CrazyDumplingsSecurityException;

    /**
     * Saves the given permission and returns a reference
     */
    Permission savePermission(Permission permission) throws CrazyDumplingsSecurityException;

    /**
     * Verifies that the referenced User implementation is a type which can be processed by the implementing data service.
     */
    boolean checkUserType(User user) throws CrazyDumplingsSecurityException;

    /**
     * Verifies that the referenced Group implementation is a type which can be processed by the implementing data service.
     */
    boolean checkGroupType(Group group) throws CrazyDumplingsSecurityException;

    /**
     * Verifies that the referenced Permission implementation is a type which can be processed by the implementing data service.
     */
    boolean checkPermissionType(Permission permission) throws CrazyDumplingsSecurityException;
}
