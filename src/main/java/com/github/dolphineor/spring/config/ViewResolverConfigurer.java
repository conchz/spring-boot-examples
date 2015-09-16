package com.github.dolphineor.spring.config;

import com.github.dolphineor.spring.extension.view.mustachejava.LocalizationMessageInterceptor;
import com.github.dolphineor.spring.extension.view.mustachejava.MustacheJTemplateFactory;
import com.github.dolphineor.spring.extension.view.mustachejava.MustacheTemplateFactory;
import com.github.dolphineor.spring.extension.view.mustachejava.MustacheViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;

/**
 * Created on 2015-09-16.
 *
 * @author dolphineor
 */
//@Configuration
public class ViewResolverConfigurer {

//    @Resource
//    private MustacheTemplateFactory templateFactory;


//    @Bean
    public MustacheTemplateFactory templateFactory() {
        MustacheTemplateFactory templateFactory = new MustacheJTemplateFactory();

        templateFactory.setPrefix("/static/templates/");
        templateFactory.setSuffix(".html");

        return templateFactory;
    }

//    @Bean
    public ViewResolver viewResolver() {
        MustacheViewResolver viewResolver = new MustacheViewResolver();

        viewResolver.setCache(false);
        viewResolver.setTemplateFactory(templateFactory());

        return viewResolver;
    }

//    @Bean
//    public HandlerInterceptorAdapter interceptor() {
//        LocalizationMessageInterceptor interceptor = new LocalizationMessageInterceptor();
//
//        interceptor.setLocaleResolver();
//        interceptor.setMessageSource();
//        interceptor.setMessageKey();
//
//        return interceptor;
//    }
}
