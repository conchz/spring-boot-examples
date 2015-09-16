package com.github.dolphineor.spring.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created on 2015-09-12.
 *
 * @author dolphineor
 */
@SpringBootApplication
@ImportResource("META-INF/application-context.xml")
@EnableWebMvc
public class ApplicationBoot {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationBoot.class, args);
    }
}
