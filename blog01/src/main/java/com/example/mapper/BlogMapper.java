package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.Blog;
import com.example.pojo.BlogToTag;
import com.example.pojo.Tag;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface BlogMapper extends BaseMapper<Blog> {
    List<Blog> selectBlogs();
    List<Date> selectBlogDate();
    List<Blog> selectBlogsCategroy(String year);
    Blog selectBlogById(int id);
    Map selectBlog2TagByTagId(Map map);

    int updateBlog2Tag(Map map);

    int insertBlog2Tag(Map map);

    BlogToTag selectTagList(Integer id);

    int removeBlog2Tag(int tagid);

    int deleteBlog2Tag(int id);
}
