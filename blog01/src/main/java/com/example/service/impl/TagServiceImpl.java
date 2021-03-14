package com.example.service.impl;

import com.example.mapper.TagMapper;
import com.example.pojo.Tag;
import com.example.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    TagMapper tagMapper;
    public List<Tag> getTags(){
        List<Tag> Tags = tagMapper.getAllTag();
        return Tags;
    }

}
