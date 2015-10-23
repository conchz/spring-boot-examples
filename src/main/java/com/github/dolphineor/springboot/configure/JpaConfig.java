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
import java.util.Properties;

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

    @Value("${hikari.dataSource.url}")
    private String url;

    @Value("${hikari.dataSource.user}")
    private String user;

    @Value("${hikari.dataSource.password}")
    private String password;

    @Value("${hikari.dataSource.cachePrepStmts}")
    private boolean cachePrepStmts;

    @Value("${hikari.dataSource.prepStmtCacheSize}")
    private int prepStmtCacheSize;

    @Value("${hikari.dataSource.prepStmtCacheSqlLimit}")
    private int prepStmtCacheSqlLimit;


    @Bean
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setPoolName(poolName);
        hikariConfig.setMinimumIdle(minimumIdle);
        hikariConfig.setMaximumPoolSize(maximumPoolSize);
        hikariConfig.setConnectionTimeout(connectionTimeout);
        hikariConfig.setIdleTimeout(idleTimeout);
        hikariConfig.setConnectionTestQuery(connectionTestQuery);
        hikariConfig.setDataSourceClassName(dataSourceClassName);

        Properties props = new Properties();
        props.put("url", url);
        props.put("user", user);
        props.put("password", password);
        props.put("cachePrepStmts", cachePrepStmts);
        props.put("prepStmtCacheSize", prepStmtCacheSize);
        props.put("prepStmtCacheSqlLimit", prepStmtCacheSqlLimit);
        hikariConfig.setDataSourceProperties(props);

        return new HikariDataSource(hikariConfig);
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
