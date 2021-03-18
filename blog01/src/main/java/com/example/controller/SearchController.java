package com.example.controller;

import com.example.pojo.Blog;
import com.example.service.TagService;
import com.example.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class SearchController {
    @Autowired
    TagService tagService;

    @RequestMapping("/search/tags/blog")
    public Map searchBlogByTag(String tagid){
        if(tagid.startsWith("tag")){
            int id = Integer.parseInt(tagid.substring(tagid.lastIndexOf('g')+1));
            System.out.println(id);
            List<Blog> blogs = tagService.selectBlogbyTagId(id);
            return ResultMap.returnResult(blogs,"success",200);
        }
        return ResultMap.returnResult(null,"error",400);
    }
}
