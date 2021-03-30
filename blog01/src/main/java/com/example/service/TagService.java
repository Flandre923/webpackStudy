package com.example.service;

import com.example.pojo.Blog;
import com.example.pojo.Tag;

import java.util.List;

public interface TagService {
    public List<Tag> getTags();

    public List<Tag>  getTagByName(String name);

    public int editTag(Tag tag);

    public int  insertTag(Tag tag);

    public int  deleteTagById(int id);

    public Tag selectTagByID(Tag tag);

    List<Blog> selectBlogbyTagId(int id);

    public List<Tag> getTagsByBlogId(Integer id);

}
