package com.crazydumplings.backend.common.web.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Component;

import com.crazydumplings.backend.security.web.AdditionalHttpSecurityConfig;

/**
 * Allows unconditioned access to URL's where unsecured access is required. Called from
 * {@link com.crazydumplings.backend.security.web.WebSecurityConfig the generic WebSecurityConfig}
 */
@Component
public class OpenStatusQueriesSecurityConfiguration implements AdditionalHttpSecurityConfig {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/status/open/**").permitAll();
    }

}
