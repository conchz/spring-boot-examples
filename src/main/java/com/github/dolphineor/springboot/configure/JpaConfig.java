package com.github.dolphineor.springboot.configure;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;

import javax.sql.DataSource;

/**
 * Created on 2015-10-23.
 *
 * @author dolphineor
 */
@Configuration
public class JpaConfig {

    @Value("${hikari.poolName}")
    private String poolName;

    @Value("${hikari.minimumIdle}")
    private int minimumIdle;

    @Value("${hikari.maximumPoolSize}")
    private int maximumPoolSize;

    @Value("${hikari.connectionTimeout}")
    private long connectionTimeout;

    @Value("${hikari.idleTimeout}")
    private long idleTimeout;

    @Value("${hikari.connectionTestQuery}")
    private String connectionTestQuery;

    @Value("${hikari.dataSourceClassName}")
    private String dataSourceClassName;

    @Value("${hikari.dataSourceProperties.url}")
    private String url;

    @Value("${hikari.dataSourceProperties.user}")
    private String user;

    @Value("${hikari.dataSourceProperties.password}")
    private String password;

    @Value("${hikari.dataSourceProperties.cachePrepStmts}")
    private boolean cachePrepStmts;

    @Value("${hikari.dataSourceProperties.prepStmtCacheSize}")
    private int prepStmtCacheSize;

    @Value("${hikari.dataSourceProperties.prepStmtCacheSqlLimit}")
    private int prepStmtCacheSqlLimit;


    @Bean
    public DataSource dataSource() {
        HikariConfig configuration = new HikariConfig();
        configuration.setPoolName(poolName);
        configuration.setMinimumIdle(minimumIdle);
        configuration.setMaximumPoolSize(maximumPoolSize);
        configuration.setConnectionTimeout(connectionTimeout);
        configuration.setIdleTimeout(idleTimeout);
        configuration.setConnectionTestQuery(connectionTestQuery);
        configuration.setDataSourceClassName(dataSourceClassName);

        configuration.addDataSourceProperty("url", url);
        configuration.addDataSourceProperty("user", user);
        configuration.addDataSourceProperty("password", password);
        configuration.addDataSourceProperty("cachePrepStmts", cachePrepStmts);
        configuration.addDataSourceProperty("prepStmtCacheSize", prepStmtCacheSize);
        configuration.addDataSourceProperty("prepStmtCacheSqlLimit", prepStmtCacheSqlLimit);

        return new HikariDataSource(configuration);
    }

    @Bean
    public SessionFactory sessionFactory(HibernateEntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.getSessionFactory();
    }

    @Bean
    public HibernateTransactionManager transactionManager(HibernateEntityManagerFactory entityManagerFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setDataSource(dataSource());
        transactionManager.setSessionFactory(sessionFactory(entityManagerFactory));

        return transactionManager;
    }
}
