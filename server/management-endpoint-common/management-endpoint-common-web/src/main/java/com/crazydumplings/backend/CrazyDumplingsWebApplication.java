package com.crazydumplings.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import com.crazydumplings.backend.security.SecurityDataService;
import com.crazydumplings.backend.security.SecurityService;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
@EnableAspectJAutoProxy
@ComponentScan(basePackages = { "com.crazydumplings" })
public class CrazyDumplingsWebApplication {
    public static void main(String[] args, CrazyDumplingsConfigurationRunnable<ApplicationContext> additionalConfiguration) {
        ApplicationContext applicationContext = SpringApplication.run(CrazyDumplingsWebApplication.class, args);

        configureApplicationContext(applicationContext);

        if (additionalConfiguration != null) {
            additionalConfiguration.run(applicationContext);
        }
    }

    private static void configureApplicationContext(ApplicationContext applicationContext) {
        String securityDataServiceName = applicationContext.getEnvironment().getProperty("crazydumplings.security.dataservice");

        applicationContext.getBean(SecurityService.class)
                .putSecurityDataService((SecurityDataService) applicationContext.getBean(securityDataServiceName)).justInstalledCheck();
    }

}
