package com.github.dolphineor.spring.controller;

import com.github.dolphineor.spring.model.entity.CommentEntity;
import com.github.dolphineor.spring.service.CommentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * Created on 2015-09-15.
 *
 * @author dolphineor
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private CommentService commentService;


    @RequestMapping(path = "/showAll", method = RequestMethod.GET, produces = "application/json")
    public Collection<CommentEntity> findAll() {
        return commentService.findAll(1, 10);
    }

}
