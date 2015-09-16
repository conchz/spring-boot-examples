package com.github.dolphineor.spring.extension.view.mustachejava;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.servlet.view.AbstractTemplateViewResolver;
import org.springframework.web.servlet.view.AbstractUrlBasedView;


public class MustacheViewResolver extends AbstractTemplateViewResolver {

    private MustacheTemplateFactory templateFactory;

    public MustacheViewResolver() {
        setViewClass(MustacheView.class);
    }

    @Override
    protected Class<?> requiredViewClass() {
        return MustacheView.class;
    }

    @Override
    protected AbstractUrlBasedView buildView(String viewName) throws Exception {
        final MustacheView view = (MustacheView) super.buildView(viewName);

        final MustacheTemplate template = templateFactory.getTemplate(view.getUrl());
        view.setTemplate(template);

        return view;
    }

    @Required
    public void setTemplateFactory(MustacheTemplateFactory templateFactory) {
        this.templateFactory = templateFactory;
    }
}
