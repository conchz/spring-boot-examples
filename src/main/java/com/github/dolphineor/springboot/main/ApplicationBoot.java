package com.github.dolphineor.springboot.main;

import com.github.dolphineor.springboot.extension.view.mustachejava.LocalizationMessageInterceptor;
import com.github.dolphineor.springboot.extension.view.mustachejava.MustacheJTemplateFactory;
import com.github.dolphineor.springboot.extension.view.mustachejava.MustacheTemplateFactory;
import com.github.dolphineor.springboot.extension.view.mustachejava.MustacheViewResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created on 2015-09-12.
 *
 * @author dolphineor
 */
@SpringBootApplication
@ImportResource("application-context.xml")
public class ApplicationBoot extends WebMvcConfigurerAdapter {

    private static ApplicationContext ctx;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LocalizationMessageInterceptor());
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        MustacheTemplateFactory templateFactory = new MustacheJTemplateFactory();
        templateFactory.setPrefix("classpath:/templates/");
        templateFactory.setSuffix(".html");

        MustacheViewResolver mustacheViewResolver = new MustacheViewResolver();
        mustacheViewResolver.setCache(false);
        mustacheViewResolver.setTemplateFactory(templateFactory);

        registry.viewResolver(mustacheViewResolver);
    }

    public static ApplicationContext getApplicationContext() {
        return ctx;
    }

    public static void main(String[] args) {
        ctx = SpringApplication.run(ApplicationBoot.class, args);
    }
}
