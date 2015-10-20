package com.github.dolphineor.springboot.extension.view.mustachejava;

import java.io.Writer;


public interface MustacheTemplate {

    void execute(Writer writer, Object scope);
}
