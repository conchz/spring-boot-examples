package com.github.dolphineor.spring.main;

import com.github.dolphineor.spring.config.JavaScriptEngine;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

/**
 * Created on 2015-09-12.
 *
 * @author dolphineor
 */
//@SpringBootApplication
//@ImportResource("META-INF/application-context.xml")
public class ApplicationBoot implements CommandLineRunner {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ApplicationBoot.class, args);
    }


//    @Bean
    public JavaScriptEngine nashornEngine() {
        return new JavaScriptEngine()
                .loadFromClassPath("META-INF/resources/webjars/react/0.13.3/react.min.js")
                .loadFromClassPath("META-INF/resources/webjars/react-router/0.13.2/ReactRouter.min.js")
                .loadFromClassPath("META-INF/resources/webjars/react-bootstrap/0.25.1/react-bootstrap.min.js")
                .loadFromClassPath("META-INF/resources/webjars/showdown/0.3.1/compressed/showdown.js")
                .loadFromClassPath("static/tutorial.js");
    }

//    @Override
    public void run(String... strings) throws Exception {
        System.out.println("");
    }
}
