package com.crazydumplings.backend.security.web.config;

import static com.desolatetimelines.utils.lang.StringUtils.nvl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfig implements WebMvcConfigurer, AdditionalHttpSecurityConfig {
    @Autowired
    private Environment env;

    /**
     * CORS for the REST end points
     */
    // TODO: delete cause it's redundant, but first set all methods to the corsConfigurationSource - then stop implementing WebMvcConfigurer
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        String origin = (String) nvl(env.getProperty("cors.origins"), "http://localhost");

        registry.addMapping("/**")
                    .allowCredentials(true)
                    .allowedHeaders("*")
                    .allowedOrigins(origin)
                    .allowedMethods("*")
        ;
    }

    /**
     * CORS for everything, including the REST end points, but mostly because the Spring Security login form does not allow CORS without this configuration
     */
    @Bean
    CorsConfigurationSource corsConfigurationSource() { // TODO: evaluate if this is ok... this is a workaround - if Spring stops looking for the bean "corsConfigurationSource", then this will suddenly stop working
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList((String) nvl(env.getProperty("cors.origins"), "http://localhost")));
        configuration.setAllowedMethods(Arrays.asList("GET","POST"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.cors();
	}
}
