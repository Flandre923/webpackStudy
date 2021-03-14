package com.example.service.impl;

import com.example.mapper.BlogMapper;
import com.example.pojo.Blog;
import com.example.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogMapper blogMapper;
    @Override
    public List<Blog> getBlogs() {
        List<Blog> blogs1 = blogMapper.selectBlogs();
        return blogs1;
    }

    @Override
    public List getBlogDate() {
//        查到博客的年份
        List<Date> dates = blogMapper.selectBlogDate();
//        处理掉重复的年份
        Set yearSet = new HashSet();
//        处理出来年份
        SimpleDateFormat f = new SimpleDateFormat("yyyy");
        dates.forEach(date -> {
            yearSet.add(f.format(date));
        });
//        查出来每一个年份下面的博客
//        把年份和博客放到一个map中
//        把每个年份和对应的map放到数组中
        List<Map> maplist = new ArrayList<>();
        yearSet.forEach(year -> {
            Map<String,Object> map = new HashMap<>();
            map.put("year",year);
            List<Blog> blogs = blogMapper.selectBlogsCategroy(year+"%");
            map.put("blogs",blogs);
            maplist.add(map);
        });
//        maplist.forEach(System.out::println);
        return maplist;
    }


}
