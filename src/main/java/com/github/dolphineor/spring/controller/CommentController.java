package com.github.dolphineor.spring.controller;

import com.github.dolphineor.spring.model.entity.CommentEntity;
import com.github.dolphineor.spring.service.CommentService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created on 2015-09-15.
 *
 * @author dolphineor
 */
@RestController
public class CommentController {

    @Resource
    private CommentService commentService;

    private final List<SseEmitter> sseEmitters = new ArrayList<>();


    @RequestMapping(path = "/comment/all", method = RequestMethod.GET, produces = "application/json")
    public Collection<CommentEntity> findAll() {
        return commentService.findAll();
    }

    @RequestMapping(path = "/comment/index", method = RequestMethod.GET, produces = "application/json")
    public ModelAndView commentIndex(Model model) {
        List comments = Arrays.asList(new CommentEntity("author1", "content1"),
                new CommentEntity("author2", "content2"),
                new CommentEntity("author3", "content3"));
        model.addAttribute("comments", comments);
        return new ModelAndView("index");
    }
}
