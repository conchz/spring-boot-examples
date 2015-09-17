package com.github.dolphineor.spring.extension.view.mustachejava;


public interface MustacheTemplateFactory {

    MustacheTemplate getTemplate(String viewName);

    void setPrefix(String prefix);

    void setSuffix(String suffix);
}
