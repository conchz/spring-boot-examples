package com.github.dolphineor.spring.main;

import com.github.dolphineor.spring.extension.view.mustachejava.LocalizationMessageInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created on 2015-09-12.
 *
 * @author dolphineor
 */
@SpringBootApplication
@ImportResource("application-context.xml")
public class ApplicationBoot extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LocalizationMessageInterceptor());
    }


    public static void main(String[] args) {
        SpringApplication.run(ApplicationBoot.class, args);
    }
}
