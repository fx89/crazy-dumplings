package com.crazydumplings.backend.common.web.config;

import static com.desolatetimelines.utils.lang.StringUtils.nvl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfig implements WebMvcConfigurer {
    @Autowired
    private Environment env;

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
}
