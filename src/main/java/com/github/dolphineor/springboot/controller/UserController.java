package com.github.dolphineor.springboot.controller;

import org.hibernate.SessionFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created on 2015-09-12.
 *
 * @author dolphineor
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private SessionFactory sessionFactory;


}
