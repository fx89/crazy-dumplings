package com.crazydumplings.backend.security;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.crazydumplings.backend.security.exception.AlreadyMappedException;
import com.crazydumplings.backend.security.exception.CrazyDumplingsSecurityException;
import com.crazydumplings.backend.security.exception.CrazyDumplingsSecurityWrongImplementationException;
import com.crazydumplings.backend.security.exception.ObjectAlreadyExistsException;
import com.crazydumplings.backend.security.exception.ObjectNotFoundException;
import com.crazydumplings.backend.security.model.Group;
import com.crazydumplings.backend.security.model.GroupPermissionMap;
import com.crazydumplings.backend.security.model.Permission;
import com.crazydumplings.backend.security.model.User;
import com.crazydumplings.backend.security.model.UserGroupMap;

/**
 * Provides login and permissions management to calling services
 */
@Service
public class SecurityService {
    private static final Function<String, Boolean> illegalStringDetector = (s) -> {                                  // TODO: Make injectable
                                                                             return s == null || s.trim().equals("");
                                                                         };

    private SecurityDataService                    securityDataService;

    public SecurityDataService getSecurityDataService() {
        return securityDataService;
    }

    public void setSecurityDataService(SecurityDataService securityDataService) {
        this.securityDataService = securityDataService;
    }

    public static Function<String, Boolean> getIllegalstringdetector() { // TODO: Remove STATIC after making the illegalStringDetector
                                                                         // injectable
        return illegalStringDetector;
    }

    public SecurityService putSecurityDataService(SecurityDataService securityDataService) {
        this.securityDataService = securityDataService;
        return this;
    }

    /**
     * If there are no groups extracted from the data service, we conclude that the data store is blank and therefore this is the first time
     * when the program runs after installation. In this case, a default configuration is written to the storage medium so that the application
     * administrator may log in and set up the application configuration.
     */
    public void justInstalledCheck() throws CrazyDumplingsSecurityException {
        if (justInstalled()) {
            createDefaultConfiguration();
        }
    }

    private boolean justInstalled() {
        List<Group> groups = securityDataService.getGroups();

        if (groups == null || groups.size() == 0) {
            return true;
        }

        return false;
    }

    private void createDefaultConfiguration() {
        this.addGroup("Administrators");
        addUser("admin", "12345", "Administrator");
        addUserToGroup("admin", "Administrators");
        addPermission("ACCESS_EVERYTHING");
        addPermissionToGroup("ACCESS_EVERYTHING", "Administrators");
    }

    /**
     * Returns a reference to the user having the provided user name, or fails catastrophically if the user doesn't exist
     */
    public User getUser(String userName) throws CrazyDumplingsSecurityException {
        return exceptionTranslationAspectWithoutSpringAspect(() -> securityDataService.getUserByUserName(userName).orElse(null),
                "Unable to get a reference to user [" + userName + "]");
    }

    public User getUser(Long userId) throws CrazyDumplingsSecurityException {
        return exceptionTranslationAspectWithoutSpringAspect(() -> securityDataService.getUserById(userId).orElse(null),
                "Unable to get a reference to user with id [" + userId + "]");
    }

    /**
     * Retrieves a list of the given user's permissions by looking at the user/group maps and then at the group/permission maps
     */
    public List<Permission> getUserPermissions(User user) throws CrazyDumplingsSecurityException {
        if (user == null) {
            throw new CrazyDumplingsSecurityException("The provided user reference is null");
        }

        checkUserType(user);

        return exceptionTranslationAspectWithoutSpringAspect(
                () -> securityDataService.getUserGroupMapByUser(user).stream()
                        .map(ugMap -> securityDataService.getGroupPermissionMapsByGroup(ugMap.getGroup()))
                        .flatMap(gpMapList -> gpMapList.stream()).map(gpMap -> gpMap.getPermission()).collect(Collectors.toList()),
                "Unable to retrieve permissions for the referenced user [" + user.getUserName() + "]");
    }

    /**
     * Forwards the call to the injected {@link SecurityDataService data service}.
     */
    public List<User> getUsers(Group group) throws CrazyDumplingsSecurityException {
        checkGroupType(group);

        return exceptionTranslationAspectWithoutSpringAspect(() -> securityDataService.getUsersInGroup(group),
                "Unable to get users in group [" + group + "]");
    }

    public List<User> getUsers() throws CrazyDumplingsSecurityException {
        return exceptionTranslationAspectWithoutSpringAspect(() -> securityDataService.getUsers(),
                "Unable to get a list of users in the system");
    }

    /**
     * Creates a new user with the provided details and returns a reference. Throws an exception in case the user already exists or in other
     * exceptional cases.
     */
    public User addUser(String userName, String encodedPassword, String userFullName) throws CrazyDumplingsSecurityException {
        if (illegalStringDetector.apply(userName))
            throw new IllegalArgumentException("The username of the provided user is not valid");

        if (illegalStringDetector.apply(userFullName))
            throw new IllegalArgumentException("The full name of the provided user is not valid");

        if (exceptionTranslationAspectWithoutSpringAspect(() -> securityDataService.getUserByUserName(userName), "").isPresent())
            throw new ObjectAlreadyExistsException("The user name [" + userName + "] is already registered.");

        return exceptionTranslationAspectWithoutSpringAspect(() -> securityDataService.addUser(userName, userFullName, encodedPassword),
                "Unable to add user [" + userName + "]");
    }

    /**
     * Removes the referenced user and its related user-group mapping. Throws exceptions in case things go wrong.
     */
    public void removeUser(User existingUser) throws CrazyDumplingsSecurityException {
        checkUserType(existingUser);

        List<UserGroupMap> ugMaps = securityDataService.getUserGroupMapByUser(existingUser);

        for (UserGroupMap ugMap : ugMaps)
            securityDataService.removeUserGroupMap(ugMap);

        securityDataService.removeUser(existingUser);
    }

    /**
     * Forwards the call to the injected {@link SecurityDataService data service}.
     */
    public User saveUser(User user) throws CrazyDumplingsSecurityException {
        checkUserType(user);
        return securityDataService.saveUser(user);
    }

    /**
     * Adds a new group having the provided name and returns a reference
     */
    public Group addGroup(String groupName) throws CrazyDumplingsSecurityException {
        if (illegalStringDetector.apply(groupName))
            throw new IllegalArgumentException("The provided group name is not valid");

        if (securityDataService.getGroupByName(groupName).isPresent())
            throw new ObjectAlreadyExistsException("A group named [" + groupName + "] already exists");

        return securityDataService.addGroup(groupName);
    }

    /**
     * Forwards the call to the injected {@link SecurityDataService data service}.
     */
    public List<Group> getGroups() throws CrazyDumplingsSecurityException {
        return securityDataService.getGroups();
    }

    /**
     * Removes the referenced group along with all the associated user-group mappings and group-permission mappings. Throws exceptions in
     * exceptional cases.
     */
    public void removeGroup(Group group) throws CrazyDumplingsSecurityException {
        checkGroupType(group);

        List<UserGroupMap> userGroupMaps = securityDataService.getUserGroupMapByGroup(group);

        for (UserGroupMap ugMap : userGroupMaps)
            securityDataService.removeUserGroupMap(ugMap);

        List<GroupPermissionMap> groupPermissionMaps = securityDataService.getGroupPermissionMapsByGroup(group);

        for (GroupPermissionMap gpMap : groupPermissionMaps)
            securityDataService.removeGroupPermissionMap(gpMap);

        securityDataService.removeGroup(group);
    }

    /**
     * Adds the referenced user to the referenced group. Throws exceptions in case of unexpected results.
     */
    public UserGroupMap addUserToGroup(String userName, String groupName) throws CrazyDumplingsSecurityException {
        return exceptionTranslationAspectWithoutSpringAspect(() -> {
            if (illegalStringDetector.apply(userName))
                throw new IllegalArgumentException("The provided user name is not valid");

            if (illegalStringDetector.apply(groupName))
                throw new IllegalArgumentException("The provided group name is not valid");

            User user = securityDataService.getUserByUserName(userName)
                    .orElseThrow(() -> new ObjectNotFoundException("User [" + userName + "] not found"));

            Group group = securityDataService.getGroupByName(groupName)
                    .orElseThrow(() -> new ObjectNotFoundException("Group [" + groupName + "] not found"));

            if (securityDataService.getUserGroupMap(user, group).isPresent())
                throw new AlreadyMappedException("User [" + userName + "] already exists in group [" + groupName + "]");

            return securityDataService.addUserToGroup(user, group);
        }, "Unable to add user [" + userName + "] to group [ + groupName + ]");
    }

    /**
     * Removes the mapping between the named user and the named group. Throws exceptions if the user or group doesn't exist or in case of
     * unexpected results;
     */
    public void removeUserFromGroup(String userName, String groupName) throws CrazyDumplingsSecurityException {
        if (illegalStringDetector.apply(userName))
            throw new IllegalArgumentException("The provided user name is not valid");

        if (illegalStringDetector.apply(groupName))
            throw new IllegalArgumentException("The provided group name is not valid");

        User user = getUserOrThrow(userName);
        Group group = getGroupOrThrow(groupName);

        UserGroupMap ugMap = securityDataService.getUserGroupMap(user, group)
                .orElseThrow(() -> new AlreadyMappedException("User [" + userName + "] already exists in group [" + groupName + "]"));

        securityDataService.removeUserGroupMap(ugMap);
    }

    /**
     * Returns a list of users in the referenced group. Throws exceptions in case of unexpected results.
     */
    public List<User> getGroupUsers(Group group) throws CrazyDumplingsSecurityException {
        checkGroupType(group);

        return exceptionTranslationAspectWithoutSpringAspect(
                () -> securityDataService.getUserGroupMapByGroup(group).stream().map(ugMap -> ugMap.getUser()).collect(Collectors.toList()),
                "Unable to get users from group");
    }

    /**
     * Forwards the call to the injected {@link SecurityDataService data service}.
     */
    public Permission addPermission(String permissionName) throws CrazyDumplingsSecurityException {
        if (illegalStringDetector.apply(permissionName))
            throw new IllegalArgumentException("The provided permission name is not valid");

        return exceptionTranslationAspectWithoutSpringAspect(() -> securityDataService.addPermission(permissionName),
                "Unable to create permission [" + permissionName + "]");
    }

    public GroupPermissionMap addPermissionToGroup(String permissionName, String groupName) throws CrazyDumplingsSecurityException {
        Permission permission = securityDataService.getPermissionByName(permissionName)
                .orElseThrow(() -> new CrazyDumplingsSecurityException("Invalid permission name"));

        Group group = securityDataService.getGroupByName(groupName)
                .orElseThrow(() -> new CrazyDumplingsSecurityException("Invalid group name"));

        return securityDataService.addPermissionToGroup(permission, group);
    }

    /**
     * Removes the referenced permission and all of the related group-permission mappings. Throws exceptions in case of unexpected results.
     */
    public void removePermission(Permission permission) throws CrazyDumplingsSecurityException {
        checkPermissionType(permission);

        for (GroupPermissionMap gpMap : securityDataService.getGroupPermissionMapsByPermission(permission))
            securityDataService.removeGroupPermissionMap(gpMap);

        securityDataService.removePermission(permission);
    }

    /**
     * Removes the referenced permission from the referenced group. Throws exceptions in case of unexpected results.
     */
    public void removePermissionFromGroup(String permissionName, String groupName) throws CrazyDumplingsSecurityException {
        Permission permission = getPermissionOrThrow(permissionName);
        Group group = getGroupOrThrow(groupName);

        GroupPermissionMap gpMap = securityDataService.getGroupPerissionMap(group, permission).orElseThrow(
                () -> new ObjectNotFoundException("The permission [" + permissionName + "] is not mapped to the group [" + groupName + "]"));

        securityDataService.removeGroupPermissionMap(gpMap);
    }

    /**
     * Returns a list of permissions related to the referenced group. Throws exceptions in case of unexpected results.
     */
    public List<Permission> getGroupPermissions(Group group) throws CrazyDumplingsSecurityException {
        checkGroupType(group);

        List<Permission> ret = new ArrayList<>();
        securityDataService.getGroupPermissionMapsByGroup(group).forEach(gpMap -> ret.add(gpMap.getPermission()));
        return ret;
    }

    /**
     * Returns a list of unique permissions available in the security system
     */
    public List<Permission> getAllPermissions() throws CrazyDumplingsSecurityException {
        return securityDataService.getAllPermissions();
    }

    /**
     * Saves the referenced permission
     */
    public Permission savePermission(Permission permission) throws CrazyDumplingsSecurityException {
        checkPermissionType(permission);
        return securityDataService.savePermission(permission);
    }

    private User getUserOrThrow(String userName) throws CrazyDumplingsSecurityException {
        return securityDataService.getUserByUserName(userName)
                .orElseThrow(() -> new ObjectNotFoundException("User [" + userName + "] not found"));
    }

    private Group getGroupOrThrow(String groupName) throws CrazyDumplingsSecurityException {
        return securityDataService.getGroupByName(groupName)
                .orElseThrow(() -> new ObjectNotFoundException("The group [" + groupName + "] does not exist."));
    }

    private Permission getPermissionOrThrow(String permissionName) throws CrazyDumplingsSecurityException {
        return securityDataService.getPermissionByName(permissionName)
                .orElseThrow(() -> new ObjectNotFoundException("The permission [" + permissionName + "] does not exist."));
    }

    private void checkUserType(User user) {
        if (!securityDataService.checkUserType(user)) {
            throw new CrazyDumplingsSecurityWrongImplementationException(
                    "The type of the referenced User object is not supported by the data layer.");
        }
    }

    private void checkGroupType(Group group) {
        if (!securityDataService.checkGroupType(group)) {
            throw new CrazyDumplingsSecurityWrongImplementationException(
                    "The type of the referenced Group object is not supported by the data layer.");
        }
    }

    private void checkPermissionType(Permission permission) {
        if (!securityDataService.checkPermissionType(permission)) {
            throw new CrazyDumplingsSecurityWrongImplementationException(
                    "The type of the referenced Permission object is not supported by the data layer.");
        }
    }

    private static <T> T exceptionTranslationAspectWithoutSpringAspect(Callable<T> c, String exceptionMessage)
            throws CrazyDumplingsSecurityException {
        try {
            return c.call();
        } catch (Exception exc) {
            throw new CrazyDumplingsSecurityException(exceptionMessage, exc);
        }
    }
}
