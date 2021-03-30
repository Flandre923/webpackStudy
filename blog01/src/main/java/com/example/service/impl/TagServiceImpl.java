package com.example.service.impl;

import com.example.mapper.BlogMapper;
import com.example.mapper.TagMapper;
import com.example.pojo.Blog;
import com.example.pojo.Tag;
import com.example.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    TagMapper tagMapper;
    @Autowired
    BlogMapper blogMapper;
    public List<Tag> getTags(){
        List<Tag> Tags = tagMapper.getAllTag();
        return Tags;
    }

    /**
     * 通过name查tag
     * @param name
     * @return
     */
    @Override
    public List<Tag> getTagByName(String name) {
        Map<String, Object> map = new HashMap<>();
        map.put("name",name);
        List<Tag> tags = tagMapper.selectByMap(map);
        return tags;
    }

    /**
     * 修改tag
     * @param tag
     * @return
     */
    @Override
    public int editTag(Tag tag) {
        tagMapper.updateById(tag);
        return 1;
    }

    /**
     * 添加tag
     * @param tag
     * @return
     */
    @Override
    public int insertTag(Tag tag) {
        tagMapper.insert(tag);
        return 1;
    }

    /**
     * 删除tag
     * @param id
     * @return
     */
    @Override
    public int deleteTagById(int id) {
        tagMapper.deleteBlog2Tag(id);
        tagMapper.deleteById(id);
        return 1;
    }

    /**
     * 通过id查询tag
     * @param tag
     * @return
     */
    @Override
    public Tag selectTagByID(Tag tag) {
        Tag tag1 = tagMapper.selectById(tag.getId());
        return tag1;
    }

    /**
     * 通过tag去查询tag下所属的blog
     * @param id
     * @return
     */
    @Override
    public List<Blog> selectBlogbyTagId(int id) {
        List<Integer> blogids = tagMapper.selectBlogbyTagId(id);
        List<Blog> blogs = new ArrayList<>();
        blogids.forEach(blogid->{
            Blog blog = blogMapper.selectBlogById(blogid);
            blogs.add(blog);
        });
        return blogs;
    }

    /**
     * 通过blogid查询tags
     * @param id
     * @return
     */
    @Override
    public List<Tag> getTagsByBlogId(Integer id) {
        List<Tag> tagsByBlogId = tagMapper.getTagsByBlogId(id);
        return tagsByBlogId;
    }

}
