package com.example.pojo.params;



import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Ccomment {
    private Long id;
    private String nickname;//昵称
    private String email;//邮箱
    private String content;//评论内容
    private String avatar;//头像(图片路径)
    private Date createTime;//评论时间
    private String website;//个人网站
    private Boolean published;//公开或回收站
    private Boolean adminComment;//博主回复
    private Integer page;//0普通文章，1关于我页面
    private Long parentCommentId;//父评论id
    private Long blogId;//所属的文章id
}