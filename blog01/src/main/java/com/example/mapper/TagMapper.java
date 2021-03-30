package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.Tag;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TagMapper extends BaseMapper<Tag> {
    public List<Tag> getAllTag();
    int deleteBlog2Tag(int id);
    public  List<Tag> getTagsByBlogId(int id);
    List<Integer> selectBlogbyTagId(int id);
}
