package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.pojo.Blog;
import com.example.pojo.params.PageSizeCurrent;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface BlogService {
    public PageInfo<Blog> getBlogs(PageSizeCurrent page);

    public List<Map> getBlogDate();

    public Page selectBlogByPage(Map map);

    public Blog  selectBlogOneById(int id);

    public int updateBlog(Blog blog,List list);

    public int insertBlog(Blog blogt, List list);

    public int deteleBlogById(int id);

    public List<Blog> getIdAndTitleList();
}
