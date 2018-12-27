package com.crazydumplings.backend.security.springdata;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crazydumplings.backend.security.SecurityDataService;
import com.crazydumplings.backend.security.exception.CrazyDumplingsSecurityException;
import com.crazydumplings.backend.security.model.Group;
import com.crazydumplings.backend.security.model.GroupPermissionMap;
import com.crazydumplings.backend.security.model.Permission;
import com.crazydumplings.backend.security.model.User;
import com.crazydumplings.backend.security.model.UserGroupMap;
import com.crazydumplings.backend.security.springdata.dao.GroupDataRepository;
import com.crazydumplings.backend.security.springdata.dao.GroupPermissionMapRepository;
import com.crazydumplings.backend.security.springdata.dao.PermissionDataRepository;
import com.crazydumplings.backend.security.springdata.dao.UserDataRepository;
import com.crazydumplings.backend.security.springdata.dao.UserGroupMapDataRepository;
import com.crazydumplings.backend.security.springdata.model.GroupData;
import com.crazydumplings.backend.security.springdata.model.GroupPermissionMapData;
import com.crazydumplings.backend.security.springdata.model.PermissionData;
import com.crazydumplings.backend.security.springdata.model.UserData;
import com.crazydumplings.backend.security.springdata.model.UserGroupMapData;

@Service(value = "SpringDataSecurityDataService")
@Transactional("securityTransactionManager")
public class SpringDataSecurityDataService implements SecurityDataService {

    @Autowired
    private UserDataRepository           userDataRepository;

    @Autowired
    private GroupDataRepository          groupDataRepository;

    @Autowired
    private PermissionDataRepository     permissionDataRepository;

    @Autowired
    private UserGroupMapDataRepository   userGroupMapRepository;

    @Autowired
    private GroupPermissionMapRepository groupPermissionMapRepository;

    public UserDataRepository getUserDataRepository() {
        return userDataRepository;
    }

    public void setUserDataRepository(UserDataRepository userDataRepository) {
        this.userDataRepository = userDataRepository;
    }

    public GroupDataRepository getGroupDataRepository() {
        return groupDataRepository;
    }

    public void setGroupDataRepository(GroupDataRepository groupDataRepository) {
        this.groupDataRepository = groupDataRepository;
    }

    public PermissionDataRepository getPermissionDataRepository() {
        return permissionDataRepository;
    }

    public void setPermissionDataRepository(PermissionDataRepository permissionDataRepository) {
        this.permissionDataRepository = permissionDataRepository;
    }

    public UserGroupMapDataRepository getUserGroupMapRepository() {
        return userGroupMapRepository;
    }

    public void setUserGroupMapRepository(UserGroupMapDataRepository userGroupMapRepository) {
        this.userGroupMapRepository = userGroupMapRepository;
    }

    public GroupPermissionMapRepository getGroupPermissionMapRepository() {
        return groupPermissionMapRepository;
    }

    public void setGroupPermissionMapRepository(GroupPermissionMapRepository groupPermissionMapRepository) {
        this.groupPermissionMapRepository = groupPermissionMapRepository;
    }

    @Override
    public User addUser(String userName, String userFullName, String encodedPassword)
            throws CrazyDumplingsSecurityException, IllegalArgumentException {
        UserData userData = new UserData();
        userData.userName = userName;
        userData.fullName = userFullName;
        userData.encodedPassword = encodedPassword;

        return userDataRepository.save(userData);
    }

    @Override
    public void removeUser(User existingUser) throws CrazyDumplingsSecurityException {
        userDataRepository.delete((UserData) existingUser);
    }

    @Override
    public User saveUser(User user) throws CrazyDumplingsSecurityException {
        userDataRepository.save((UserData) user);
        return user;
    }

    @Override
    public Optional<Group> getGroupByName(String groupName) throws CrazyDumplingsSecurityException {
        return Optional.ofNullable(groupDataRepository.findOneByName(groupName).orElse(null));
    }

    @Override
    public Permission addPermission(String permissionName) throws CrazyDumplingsSecurityException {
        PermissionData permissionData = new PermissionData();
        permissionData.name = permissionName;

        return permissionDataRepository.save(permissionData);
    }

    @Override
    public List<User> getUsers() throws CrazyDumplingsSecurityException {
        return StreamSupport.stream(userDataRepository.findAll().spliterator(), false).map(userData -> (User) userData)
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getUsersInGroup(Group group) throws CrazyDumplingsSecurityException {
        return userDataRepository.findAllByGroupId(((GroupData) group).getId()).stream().map(usrData -> (User) usrData)
                .collect(Collectors.toList());
    }

    @Override
    public List<Group> getGroups() throws CrazyDumplingsSecurityException {
        Iterable<GroupData> groups = groupDataRepository.findAll();

        if (groups == null) {
            return null;
        }

        return StreamSupport.stream(groups.spliterator(), false).map(grpData -> (Group) grpData).collect(Collectors.toList());
    }

    @Override
    public Group addGroup(String groupName) throws CrazyDumplingsSecurityException {
        GroupData groupData = new GroupData();
        groupData.setName(groupName);
        groupDataRepository.save(groupData);
        return groupData;
    }

    @Override
    public Optional<User> getUserByUserName(String userName) throws CrazyDumplingsSecurityException {
        return Optional.ofNullable(userDataRepository.findOneByUserName(userName).orElse(null));
    }

    @Override
    public Optional<User> getUserById(Long userId) throws CrazyDumplingsSecurityException {
        return Optional.ofNullable(userDataRepository.findById(userId).orElse(null));
    }

    @Override
    public void removeGroup(Group group) throws CrazyDumplingsSecurityException {
        groupDataRepository.delete((GroupData) group);
    }

    @Override
    public UserGroupMap addUserToGroup(User user, Group group) throws CrazyDumplingsSecurityException {
        UserGroupMapData ugMap = new UserGroupMapData();
        ugMap.setUser(user);
        ugMap.setGroup(group);

        return userGroupMapRepository.save(ugMap);
    }

    @Override
    public void removeUserGroupMap(UserGroupMap userGroup) throws CrazyDumplingsSecurityException {
        userGroupMapRepository.delete((UserGroupMapData) userGroup);
    }

    @Override
    public Optional<UserGroupMap> getUserGroupMap(User user, Group group) throws CrazyDumplingsSecurityException {
        return Optional.ofNullable(userGroupMapRepository.findOneByUserAndGroup((UserData) user, (GroupData) group).orElse(null));
    }

    @Override
    public List<UserGroupMap> getUserGroupMapByGroup(Group group) throws CrazyDumplingsSecurityException {
        return userGroupMapRepository.findAllByGroup((GroupData) group).stream().map(grpMapData -> (UserGroupMap) grpMapData)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserGroupMap> getUserGroupMapByUser(User user) throws CrazyDumplingsSecurityException {
        return userGroupMapRepository.findAllByUser((UserData) user).stream().map(grpMapData -> (UserGroupMap) grpMapData)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Permission> getPermissionByName(String permissionName) throws CrazyDumplingsSecurityException {
        return Optional.ofNullable(permissionDataRepository.findOneByName(permissionName).orElse(null));
    }

    @Override
    public GroupPermissionMap addPermissionToGroup(Permission permission, Group group) throws CrazyDumplingsSecurityException {
        GroupPermissionMapData gpMap = new GroupPermissionMapData();
        gpMap.setGroup(group);
        gpMap.setPermission(permission);

        return groupPermissionMapRepository.save(gpMap);
    }

    @Override
    public void removePermission(Permission permission) throws CrazyDumplingsSecurityException {
        permissionDataRepository.delete((PermissionData) permission);
    }

    @Override
    public List<GroupPermissionMap> getGroupPermissionMapsByPermission(Permission permission) throws CrazyDumplingsSecurityException {
        return groupPermissionMapRepository.findAllByPermission((PermissionData) permission).stream()
                .map(gpMapData -> (GroupPermissionMap) gpMapData).collect(Collectors.toList());
    }

    @Override
    public Optional<GroupPermissionMap> getGroupPerissionMap(Group group, Permission permission) throws CrazyDumplingsSecurityException {
        return Optional.ofNullable(groupPermissionMapRepository.findOneByGroupAndPermission(group, permission).orElse(null));
    }

    @Override
    public List<GroupPermissionMap> getGroupPermissionMapsByGroup(Group group) throws CrazyDumplingsSecurityException {
        return groupPermissionMapRepository.findAllByGroup(group).stream().map(gpMapData -> (GroupPermissionMap) gpMapData)
                .collect(Collectors.toList());
    }

    @Override
    public void removeGroupPermissionMap(GroupPermissionMap gpMap) throws CrazyDumplingsSecurityException {
        groupPermissionMapRepository.delete((GroupPermissionMapData) gpMap);
    }

    @Override
    public List<Permission> getAllPermissions() throws CrazyDumplingsSecurityException {
        return StreamSupport.stream(permissionDataRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public Permission savePermission(Permission permission) throws CrazyDumplingsSecurityException {
        return permissionDataRepository.save((PermissionData) permission);
    }

    @Override
    public boolean checkUserType(User user) throws CrazyDumplingsSecurityException {
        return user instanceof UserData;
    }

    @Override
    public boolean checkGroupType(Group group) throws CrazyDumplingsSecurityException {
        return group instanceof GroupData;
    }

    @Override
    public boolean checkPermissionType(Permission permission) throws CrazyDumplingsSecurityException {
        return permission instanceof PermissionData;
    }

}
