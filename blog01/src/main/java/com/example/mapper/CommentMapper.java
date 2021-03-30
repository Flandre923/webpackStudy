package com.example.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.Comment;
import com.example.pojo.params.PageComment;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
@Mapper
@Repository
public interface CommentMapper extends BaseMapper<Comment> {
    public List<Comment> getListByParentCommentId(Long parantCommentId);
    public List<Comment> getListByPageAndParentCommentId(Integer page,Long blogId,Long parentCommentId);
    List<PageComment> getPageCommentListByPageAndParentCommentId(Integer page,Long blogId,Long parentCommentId);
    Comment getCommentById(Long id);
    int updateCommentPublishedById(Long commentId,Boolean published);
    int deleteCommentById(Long id);
    int deleteCommentsByBlogId(Integer blogid);
    int updateComment(Comment comment);
    int countByPageAndIsPublished(Integer page,Long blogId);
    int countComment();
    int saveComment(com.example.pojo.params.Ccomment comment);
}