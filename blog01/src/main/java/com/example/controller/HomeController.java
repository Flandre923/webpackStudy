package com.example.controller;

import com.example.pojo.Blog;
import com.example.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HomeController {
    @Autowired
    BlogService blogService;
    @RequestMapping("/")
    public Map home(){
        List<Blog> blogs = blogService.getBlogs();
        Map<String,Object> blogMap = new HashMap<>();
        blogMap.put("data",blogs);
        return blogMap;
    }
}
