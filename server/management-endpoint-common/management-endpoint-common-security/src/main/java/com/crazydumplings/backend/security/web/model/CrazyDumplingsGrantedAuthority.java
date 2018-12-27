package com.crazydumplings.backend.security.web.model;

import org.springframework.security.core.GrantedAuthority;

public class CrazyDumplingsGrantedAuthority implements GrantedAuthority {

    public String name;

    public CrazyDumplingsGrantedAuthority(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }

}
