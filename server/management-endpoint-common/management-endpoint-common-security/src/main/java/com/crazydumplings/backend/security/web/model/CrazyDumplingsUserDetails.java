package com.crazydumplings.backend.security.web.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.crazydumplings.backend.security.model.User;

public class CrazyDumplingsUserDetails implements UserDetails {

    public User                                 user;

    public List<CrazyDumplingsGrantedAuthority> authorities = new ArrayList<>();

    public CrazyDumplingsUserDetails(User user) {
        this.user = user;
    }

    public CrazyDumplingsUserDetails addGrantedAuthority(CrazyDumplingsGrantedAuthority grantedAuthority) {
        authorities.add(grantedAuthority);
        return this;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getEncodedPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
