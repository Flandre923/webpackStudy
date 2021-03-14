package com.example.service;

import com.example.pojo.Blog;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface BlogService {
    public List<Blog> getBlogs();

    public List<Map> getBlogDate();

}
