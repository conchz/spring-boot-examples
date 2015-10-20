package com.github.dolphineor.springboot.extension.view.mustachejava;

import com.github.dolphineor.springboot.extension.i18n.MustacheLocalizationMessageInterceptor;
import com.google.common.base.Throwables;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.StringWriter;
import java.util.function.Function;


public class LocalizationMessageInterceptor extends MustacheLocalizationMessageInterceptor {

    @Override
    protected Object createHelper(HttpServletRequest request) {
        return (Function<String, String>) input -> {
            final StringWriter out = new StringWriter();
            try {
                localize(request, input, out);
            } catch (IOException e) {
                Throwables.propagate(e);
            }

            return out.toString();
        };
    }
}
