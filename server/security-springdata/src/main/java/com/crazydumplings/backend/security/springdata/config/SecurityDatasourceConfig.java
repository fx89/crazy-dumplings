package com.crazydumplings.backend.security.springdata.config;

import java.sql.SQLException;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.crazydumplings.common.springboot.data.DataSourceConfigUtils;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages            = {"com.crazydumplings.backend.security.springdata.dao"},
        transactionManagerRef   =  "securityTransactionManager",
        entityManagerFactoryRef =  "securityEntityManager"
)
public class SecurityDatasourceConfig {
    private static final String DS_PREFIX  = "spring.datasource.security";
    private static final String DOMAIN_PKG = "com.crazydumplings.backend.security.springdata.model";
    private static final String DS_NAME    = "securityDS";
    private static final String PU_NAME    = "securityPU";
    private static final String EM_NAME    = "securityEntityManager";
    private static final String TM_NAME    = "securityTransactionManager";

    @Autowired
    private ApplicationContext  ctx;

    @Primary
    @Bean(name = DS_NAME)
    @ConfigurationProperties(prefix = DS_PREFIX)
    public DataSource dataSource() throws SQLException {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = EM_NAME)
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        return DataSourceConfigUtils.createEMF(ctx, DS_NAME, DS_PREFIX, DOMAIN_PKG, PU_NAME);
    }

    @Bean(name = TM_NAME)
    public PlatformTransactionManager transactionManager(@Qualifier(EM_NAME) EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
