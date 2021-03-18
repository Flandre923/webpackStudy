package com.example.controller;

import com.example.pojo.Blog;
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

    /**
     * 获得所有分类
     * @return
     */
    @RequestMapping("/blog/tags")
    public Map getTags(){
        List<Tag> tags = tagService.getTags();
//        System.out.println(tags);
        Map map = ResultMap.returnResult(tags);
        return map;
    }

    /**
     * 获得关于所有的blog的年份和相应的分类
     * @return
     */
    @RequestMapping("/blog/artdate")
    public Map getArtsDate(){
        List<Map> blogDate = blogService.getBlogDate();
        return ResultMap.returnResult(blogDate);
    }

    @RequestMapping("/blog/content")
    public Map getBlogContent(int id){
        Blog blog = blogService.selectBlogOneById(id);
        return ResultMap.returnResult(blog,"message",200);
    }


}
