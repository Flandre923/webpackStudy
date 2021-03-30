package com.example.pojo.params;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.pojo.Tag;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BlogParams {
    private Integer id;
    private String title;
    private String summary;
    private List<Tag> tags = new ArrayList<>();
    private Date updateTime;
    private String content;
    private Date createTime;
    private Integer number;
    private Integer readTime;
    private String picture;
}