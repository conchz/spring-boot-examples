package com.github.dolphineor.spring.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.script.ScriptTemplateConfigurer;
import org.springframework.web.servlet.view.script.ScriptTemplateViewResolver;

/**
 * Created on 2015-09-15.
 *
 * @author dolphineor
 */
@SpringBootApplication
@ImportResource("META-INF/application-context.xml")
public class BootStrap {

    public static void main(String[] args) {
        SpringApplication.run(BootStrap.class, args);
    }

    @Bean
    public ScriptTemplateConfigurer handlebarsConfigurer() {
        ScriptTemplateConfigurer configurer = new ScriptTemplateConfigurer();

        configurer.setEngineName("nashorn");

        configurer.setScripts("/static/js/polyfill.js",
                "/META-INF/resources/webjars/handlebars/4.0.2/handlebars.js",
                "/META-INF/resources/webjars/react/0.13.3/react.min.js",
                "/META-INF/resources/webjars/react-router/0.13.2/ReactRouter.min.js",
                "/META-INF/resources/webjars/react-bootstrap/0.25.1/react-bootstrap.min.js",
                "/META-INF/resources/webjars/showdown/0.3.1/compressed/showdown.js",
                "/static/js/render.js");

        configurer.setRenderFunction("render");
        configurer.setSharedEngine(false);

        return configurer;
    }

    public ViewResolver viewResolver() {
        ScriptTemplateViewResolver viewResolver = new ScriptTemplateViewResolver();
        viewResolver.setPrefix("static/templates/");
        viewResolver.setSuffix(".html");
        return viewResolver;
    }
}
