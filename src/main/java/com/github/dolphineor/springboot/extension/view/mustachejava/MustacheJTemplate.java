package com.github.dolphineor.springboot.extension.view.mustachejava;

import com.github.mustachejava.Mustache;

import java.io.Writer;


public class MustacheJTemplate implements MustacheTemplate {

    private final Mustache template;

    public MustacheJTemplate(Mustache template) {
        this.template = template;
    }

    @Override
    public void execute(Writer writer, Object scope) {
        template.execute(writer, scope);
    }
}
