package com.example.pojo.params;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 页面评论
 */
@NoArgsConstructor
@Data
public class PageComment {
    private Long id;
	private String nickname;//昵称
	private String content;//评论内容
	private String avatar;//头像(图片路径)
	private Date createTime;//评论时间
	private String website;//个人网站
	private String parentCommentId;//父评论id
	private String parentCommentNickname;//父评论昵称

	private List<PageComment> replyComments = new ArrayList<>();//回复该评论的评论
}