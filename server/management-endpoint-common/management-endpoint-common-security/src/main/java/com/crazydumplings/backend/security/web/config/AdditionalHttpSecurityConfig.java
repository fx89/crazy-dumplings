package com.crazydumplings.backend.security.web.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

/**
 * Implementations of this interface are called from {@link com.crazydumplings.backend.security.web.config.WebSecurityConfig the generic
 * WebSecurityConfig} just before applying the standard Spring configuration. This can be used instead of a new security configuration to avoid
 * overwriting the standard Spring configuration.
 */
public interface AdditionalHttpSecurityConfig {
    void configure(HttpSecurity http) throws Exception;
}
