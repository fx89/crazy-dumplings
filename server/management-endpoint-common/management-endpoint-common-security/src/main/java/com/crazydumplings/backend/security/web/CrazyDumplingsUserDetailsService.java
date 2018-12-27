package com.crazydumplings.backend.security.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.crazydumplings.backend.security.SecurityService;
import com.crazydumplings.backend.security.model.Permission;
import com.crazydumplings.backend.security.model.User;
import com.crazydumplings.backend.security.web.model.CrazyDumplingsGrantedAuthority;
import com.crazydumplings.backend.security.web.model.CrazyDumplingsUserDetails;

@Service
public class CrazyDumplingsUserDetailsService implements UserDetailsService {
    @Autowired
    private SecurityService securityService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = securityService.getUser(username);
        List<Permission> permissions = securityService.getUserPermissions(user);

        CrazyDumplingsUserDetails userDetails = new CrazyDumplingsUserDetails(user);

        if (permissions != null) {
            permissions.forEach(permission -> userDetails.addGrantedAuthority(new CrazyDumplingsGrantedAuthority(permission.getName())));
        }

        return userDetails;
    }

}
