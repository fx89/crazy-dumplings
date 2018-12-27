package com.crazydumplings.backend.rest;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crazydumplings.backend.rest.model.PermissionPropertiesRequest;
import com.crazydumplings.backend.security.SecurityService;
import com.crazydumplings.backend.security.model.Permission;

@RestController
@RequestMapping("/permissions")
@PreAuthorize("hasAuthority('ACCESS_EVERYTHING')")
public class SecurityManagementPermissionsController {
    @Autowired
    private SecurityService securityService;

    @GetMapping("/list")
    public List<Permission> listAllPermissions() {
        return securityService.getAllPermissions();
    }

    @PostMapping("/add")
    public Permission addPermission(@RequestBody PermissionPropertiesRequest permissionAddRequest) {
        Objects.requireNonNull(permissionAddRequest, "Missing request body");

        Permission permission = securityService.addPermission(permissionAddRequest.getName());

        if (permissionAddRequest.getDescription() != null) {
            permission.setDescription(permissionAddRequest.getDescription());
            permission = securityService.savePermission(permission);
        }

        return permission;
    }
}
