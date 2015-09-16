package com.github.dolphineor.spring.extension.view.mustachejava;

import org.springframework.web.servlet.view.AbstractTemplateView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Writer;
import java.util.Map;


public class MustacheView extends AbstractTemplateView {

    private MustacheTemplate template;

    @Override
    protected void renderMergedTemplateModel(Map<String, Object> model, HttpServletRequest request,
                                             HttpServletResponse response) throws Exception {

        response.setContentType(getContentType());
        final Writer writer = response.getWriter();
        template.execute(writer, model);
        writer.flush();
    }

    public MustacheTemplate getTemplate() {
        return template;
    }

    public void setTemplate(MustacheTemplate template) {
        this.template = template;
    }
}
