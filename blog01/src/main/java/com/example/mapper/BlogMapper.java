package com.example.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.pojo.Blog;
import com.example.pojo.BlogToTag;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface BlogMapper extends BaseMapper<Blog> {
//    IPage<Blog> selectBlogs(@Param("page")Page<Blog> page,@Param(Constants.WRAPPER) Wrapper<Blog> wrapper);
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

    List<Blog> getIdAndTitleList();
}
