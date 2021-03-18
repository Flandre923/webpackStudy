package com.example.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Blog implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String title;
    private String summary;
    @TableField(exist = false)
    private List<Tag> tags = new ArrayList<>();
    private Date updateTime;
    private String content;
    private Date createTime;
    private Integer number;
    private Integer readTime;
    private String picture;
}
