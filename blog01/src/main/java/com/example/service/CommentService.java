package com.example.service;

import java.util.List;

import com.example.pojo.Comment;
import com.example.pojo.params.PageComment;

public interface CommentService {
    public List<PageComment> getPageCommentList(Integer page,Long blogId,Long parentCommentId);

    public List<Comment> getAllReplyComments(Long parentCommentId);

    Comment geCommentId(Long id);

    void updateCommentPublicshedById(Long commentId,Boolean published);

    void deleteCommentById(Long commentId);

    void deleteCommentByBlogId(Long Blogid);

    void updateComment(Comment comment);

    int countByPageAndIsPublished(Integer page,Long blogId);

    void saveComment(com.example.pojo.params.Ccomment ccomment);
}