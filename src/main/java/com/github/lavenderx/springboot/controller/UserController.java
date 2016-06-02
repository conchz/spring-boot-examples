package com.github.lavenderx.springboot.controller;

import com.github.lavenderx.springboot.model.entity.UserEntity;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping("/user")
public class UserController {

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public ModelAndView register() {
        return new ModelAndView();
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ModelAndView login() {
        return new ModelAndView();
    }

    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public ModelAndView logout() {
        return new ModelAndView();
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public ModelAndView update(@RequestBody UserEntity user) {
        return new ModelAndView();
    }
}
