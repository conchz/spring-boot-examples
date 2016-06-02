package com.github.lavenderx.springboot.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created on 2015-09-12.
 *
 * @author Baymax
 */
@RestController
@Scope("prototype")
public class IndexController {

    @RequestMapping(path = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView handleRequest(Model model) {
        model.addAttribute("title", "Hello Mustache");

        return new ModelAndView("index").addAllObjects(model.asMap());
    }

}
