package com.example.pojo;

import lombok.*;

import java.util.List;

/**
 * 关于blog和tag关系的 拥有查询数据库
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BlogToTag {
    private Integer blogid;
    private List<TagIdAndTagToBlogID> list;

}
