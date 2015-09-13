package com.github.dolphineor.spring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.dolphineor.spring.config.JavaScriptEngine;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 2015-09-12.
 *
 * @author dolphineor
 */
@RestController
public class IndexController {

    @Resource
    private JavaScriptEngine nashornEngine;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String handleRequest(Model model) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        List<Comment> comments = new ArrayList<>();
        comments.addAll(Arrays.asList(
                new Comment("Pete Hunt", "This is one comment"),
                new Comment("Jordan Walke", "This is *another* comment")));

//        String markup = nashornEngine.invokeFunction("renderOnServer", String::valueOf, comments);
        String initialData = objectMapper.writeValueAsString(comments);
//        model.addAttribute("markup", markup);
        model.addAttribute("initialData", initialData);
        return "index";
    }


    class Comment {
        public String author;
        public String text;

        Comment() {
        }

        public Comment(String author, String text) {
            this.author = author;
            this.text = text;
        }
    }
}
