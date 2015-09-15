package com.github.dolphineor.spring.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2015-09-12.
 *
 * @author dolphineor
 */
@RestController
public class IndexController {


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String handleRequest(Model model) {
        return "index";
    }


}
