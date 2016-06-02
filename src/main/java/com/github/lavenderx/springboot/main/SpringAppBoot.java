package com.github.lavenderx.springboot.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mustache.web.MustacheViewResolver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Objects;

/**
 * Created on 2015-09-12.
 *
 * @author Baymax
 */
@ComponentScan("com.github.lavenderx.springboot.*")
@EnableTransactionManagement
@SpringBootApplication
public class SpringAppBoot extends WebMvcConfigurerAdapter {

    private static ApplicationContext ctx;

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        MustacheViewResolver mustacheViewResolver = new MustacheViewResolver();
        mustacheViewResolver.setPrefix("classpath:/templates/");
        mustacheViewResolver.setSuffix(".html");
        mustacheViewResolver.setCharset("UTF-8");
        mustacheViewResolver.setCache(true);
        mustacheViewResolver.setCacheLimit(1024);

        registry.viewResolver(mustacheViewResolver);
    }

    public static ApplicationContext getApplicationContext() {
        if (Objects.isNull(ctx)) {
            throw new NullPointerException();
        }

        return ctx;
    }

    public static void main(String[] args) {
        ctx = SpringApplication.run(SpringAppBoot.class, args);
    }
}
