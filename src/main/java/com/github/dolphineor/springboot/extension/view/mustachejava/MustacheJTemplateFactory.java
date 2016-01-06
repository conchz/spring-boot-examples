/*
 * Copyright 2011-2014 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.github.dolphineor.springboot.extension.view.mustachejava;

import com.github.dolphineor.springboot.main.SpringAppBoot;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.MustacheException;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Objects;

import static com.google.common.base.MoreObjects.firstNonNull;

/**
 * Uses the spring resource loader to find template files.
 * <p>
 * The prefix is set from the view resolver to handle partials as the path to
 * the parent will be fully qualified, but partials within the parent will not
 * be.
 *
 * @author Sean Scanlon <sean.scanlon@gmail.com>
 * @author Eric D. White <eric@ericwhite.ca>
 */
public class MustacheJTemplateFactory extends DefaultMustacheFactory implements MustacheTemplateFactory {

    private final String encoding = firstNonNull(System.getProperty("mustache.template.encoding"), "UTF-8");

    private String prefix = "";
    private String suffix = "";


    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public MustacheTemplate getTemplate(String viewName) {
        return new MustacheJTemplate(this.compile(viewName));
    }

    @Override
    public Reader getReader(String resourceName) {
        Resource resource = SpringAppBoot.getApplicationContext()
                .getResource(this.prefix + resourceName + this.suffix);
        if (Objects.isNull(resource) || !resource.exists()) {
            throw new MustacheException("No template exists named: " + resourceName);
        }

        try {
            return new InputStreamReader(resource.getInputStream(), encoding);
        } catch (IOException e) {
            throw new MustacheException("Failed to load template: " + resourceName, e);
        }
    }

}
