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
public class JpaConfiguration {

    @Value("${hikari.poolName}")
    private String poolName;

    @Value("${hikari.jdbcUrl}")
    private String jdbcUrl;

    @Value("${hikari.username}")
    private String username;

    @Value("${hikari.password}")
    private String password;

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
        configuration.setJdbcUrl(jdbcUrl);
        configuration.setUsername(username);
        configuration.setPassword(password);
        configuration.setMinimumIdle(minimumIdle);
        configuration.setMaximumPoolSize(maximumPoolSize);
        configuration.setConnectionTimeout(connectionTimeout);
        configuration.setIdleTimeout(idleTimeout);
        configuration.setConnectionTestQuery(connectionTestQuery);

        // Only for MySQL
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
