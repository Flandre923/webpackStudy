package com.example.controller;

import com.example.pojo.Tag;
import com.example.service.BlogService;
import com.example.service.TagService;
import com.example.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class BlogController {
    @Autowired
    private TagService tagService;
    @Autowired
    private BlogService blogService;

    @RequestMapping("/blog/tags")
    public Map getTags(){
        List<Tag> tags = tagService.getTags();
        System.out.println(tags);
        Map map = ResultMap.returnResult(tags);
        return map;
    }

    @RequestMapping("/blog/artdate")
    public Map getArtsDate(){
        List<Map> blogDate = blogService.getBlogDate();
        return ResultMap.returnResult(blogDate);
    }

}
