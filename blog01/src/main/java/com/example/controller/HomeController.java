package com.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.pojo.Blog;
import com.example.pojo.params.PageSizeCurrent;
import com.example.service.BlogService;
import com.github.pagehelper.PageInfo;
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
    @RequestMapping("/index")
    public Map home(PageSizeCurrent page){
        PageInfo<Blog> blogs = blogService.getBlogs(page);
        Map<String,Object> blogMap = new HashMap<>();
        Map datamap  = new HashMap();
        datamap.put("data",blogs.getList());
        datamap.put("total",blogs.getTotal());
        blogMap.put("data",datamap);
        return blogMap;
    }
}
