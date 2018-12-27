package com.crazydumplings.backend.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.crazydumplings.backend.security.web.model.CrazyDumplingsUserDetails;

public class SecurityUtils {
    public static Long getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ((CrazyDumplingsUserDetails) authentication.getPrincipal()).user.getId();
    }
}
