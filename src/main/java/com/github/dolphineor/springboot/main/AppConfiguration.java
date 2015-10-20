package com.github.dolphineor.springboot.main;

import com.github.dolphineor.springboot.config.HibernateProperties;
import com.zaxxer.hikari.HikariConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created on 2015-10-18.
 *
 * @author dolphineor
 */
@Configuration
@EnableConfigurationProperties({HibernateProperties.class})
public class AppConfiguration {

    @Autowired
    private HibernateProperties hibernateProperties;

    @Bean
    public HikariConfig hikariConfig() {
        String t = hibernateProperties.getDialect();
        return new HikariConfig();
    }
}
