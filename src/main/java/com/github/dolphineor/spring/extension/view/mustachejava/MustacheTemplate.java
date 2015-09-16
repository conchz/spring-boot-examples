package com.github.dolphineor.spring.extension.view.mustachejava;

import java.io.Writer;


public interface MustacheTemplate {

    void execute(Writer writer, Object scope);
}
