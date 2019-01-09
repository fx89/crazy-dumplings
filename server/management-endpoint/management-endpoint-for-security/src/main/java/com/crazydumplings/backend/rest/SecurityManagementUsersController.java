package com.crazydumplings.backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crazydumplings.backend.rest.model.UserPropertiesRequest;
import com.crazydumplings.backend.security.SecurityService;
import com.crazydumplings.backend.security.model.Permission;
import com.crazydumplings.backend.security.model.User;


import static com.crazydumplings.backend.security.SecurityService.passwordEncoder;

@RestController
@RequestMapping("/users")
@PreAuthorize("hasAuthority('SECURITY_MANAGEMENT')")
public class SecurityManagementUsersController {
    @Autowired
    private SecurityService              securityService;

    @GetMapping("/list")
    public List<User> listUsers() {
        return securityService.getUsers();
    }

    @PostMapping("/add")
    public User addUser(@RequestBody UserPropertiesRequest userAddRequest) {
        return securityService.addUser(userAddRequest.userName, passwordEncoder.encode(userAddRequest.clearPassword),
                userAddRequest.userFullName);
    }

    @PutMapping("/edit")
    public User editUser(@RequestBody UserPropertiesRequest userEditRequest) {
        User user = securityService.getUser(userEditRequest.userId);

        user.setUserName(userEditRequest.userName);
        user.setFullName(userEditRequest.userFullName);

        if (userEditRequest.clearPassword != null)
            user.setEncodedPassword(passwordEncoder.encode(userEditRequest.clearPassword));

        securityService.saveUser(user);

        return user;
    }

    @GetMapping("/listpermissions")
    public List<Permission> listUerPermissions(@RequestParam("userId") Long userId) {
        User user = securityService.getUser(userId);
        return securityService.getUserPermissions(user);
    }
}
