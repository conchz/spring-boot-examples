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
package com.github.dolphineor.spring.extension.view.mustachejava;

import com.github.dolphineor.spring.main.ApplicationBoot;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.MustacheException;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import static com.google.common.base.MoreObjects.firstNonNull;
import static java.lang.System.getProperty;

/**
 * Uses the spring resource loader to find template files.
 * <p/>
 * The prefix is set from the view resolver to handle partials as the path to
 * the parent will be fully qualified, but partials within the parent will not
 * be.
 *
 * @author Sean Scanlon <sean.scanlon@gmail.com>
 * @author Eric D. White <eric@ericwhite.ca>
 */
public class MustacheJTemplateFactory extends DefaultMustacheFactory implements
        ResourceLoaderAware, MustacheTemplateFactory {

    private ResourceLoader resourceLoader;
    private String prefix = "";
    private String suffix = "";
    private String encoding = firstNonNull(getProperty("mustache.template.encoding"), "UTF-8");


    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setResourceLoader(ResourceLoader resourceLoader) {
        //
    }

    public MustacheTemplate getTemplate(String viewName) {
        return new MustacheJTemplate(this.compile(viewName));
    }

    @Override
    public Reader getReader(String resourceName) {
        Resource resource = ApplicationBoot.getApplicationContext().getResource(
                this.prefix + resourceName + this.suffix);
        if (resource == null || !resource.exists())
            throw new MustacheException("No template exists named: " + resourceName);

        try {
            return new InputStreamReader(resource.getInputStream(), encoding);
        } catch (IOException e) {
            throw new MustacheException("Failed to load template: " + resourceName, e);
        }
    }

}
