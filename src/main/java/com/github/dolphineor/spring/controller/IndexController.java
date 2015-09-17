package com.github.dolphineor.spring.controller;

import com.github.dolphineor.spring.model.entity.CommentEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

/**
 * Created on 2015-09-12.
 *
 * @author dolphineor
 */
@RestController
public class IndexController {

    @RequestMapping(value = {"/", "/index", "/index.html"}, method = RequestMethod.GET)
    public ModelAndView handleRequest(Model model) {
        List<CommentEntity> comments = Arrays.asList(new CommentEntity("author1", "content1"),
                new CommentEntity("author2", "content2"),
                new CommentEntity("author3", "content3"));
        model.addAttribute("comments", comments);

        return new ModelAndView("index").addAllObjects(model.asMap());
    }


}
