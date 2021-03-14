package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.Blog;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BlogMapper extends BaseMapper<Blog> {
    List<Blog> selectBlogs();
    List<Date> selectBlogDate();
    List<Blog> selectBlogsCategroy(String year);
}
