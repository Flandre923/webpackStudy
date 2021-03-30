package com.example.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.pojo.params.BlogIdAndTitle;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class Comment {
    private Long id;
    private String nickname;//昵称
    private String email;//邮箱
    private String content;//评论内容
    private String avatar;//头像(图片路径)
    private Date createTime;//评论时间
    private Boolean published;//公开或回收站
    private Integer page;//0普通文章，1关于我页面
    private Long parentCommentId;//父评论id
    private String website; //网站

    private BlogIdAndTitle blog;//所属的文章
    private List<Comment> replyComments = new ArrayList<>();//回复该评论的评论
}