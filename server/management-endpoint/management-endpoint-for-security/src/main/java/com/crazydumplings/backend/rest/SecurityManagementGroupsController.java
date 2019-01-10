package com.crazydumplings.backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.crazydumplings.backend.rest.model.GroupPermissionRequest;
import com.crazydumplings.backend.security.SecurityService;
import com.crazydumplings.backend.security.model.Group;
import com.crazydumplings.backend.security.model.GroupPermissionMap;

@RestController
@RequestMapping("/groups")
@PreAuthorize("hasAuthority('SECURITY_MANAGEMENT')")
public class SecurityManagementGroupsController {
    @Autowired
    private SecurityService securityService;

    @GetMapping("/list")
    public List<Group> listGroups() {
        return securityService.getGroups();
    }

    @PostMapping("/addpermission")
    public GroupPermissionMap addPermission(@RequestBody GroupPermissionRequest permissionAddRequest) {
        return securityService.addPermissionToGroup(permissionAddRequest.getPermissionName(), permissionAddRequest.getGroupName());
    }

}
