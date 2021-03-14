package com.example.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    private Integer id;
    private String title;
    private String summary;
    private List<Tag> tags;
    private Date updateTime;
    private String content;
    private Date createTime;
    private Integer number;
    private Integer readTime;
    private String picture;
}
