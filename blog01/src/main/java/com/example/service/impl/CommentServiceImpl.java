package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.mapper.CommentMapper;
import com.example.pojo.Comment;
import com.example.pojo.params.Ccomment;
import com.example.pojo.params.PageComment;
import com.example.service.CommentService;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;
    /**
     * 通过page和blogid获得该页面下的所有评论
     */
    @Override
    public List<PageComment> getPageCommentList(Integer page, Long blogId, Long parentCommentId) {
        List<PageComment> comments = getPageCommentListByPageAndParentCommentId(page,blogId,parentCommentId);
        for (PageComment comment : comments) {
            List<PageComment> tmpCommentList = new ArrayList<>();
            getReplyCoomment(tmpCommentList,comment.getReplyComments());
        }
        return comments;
    }
    /**
     * 
     * @param tmpCommentList
     * @param comments
     */
    private void getReplyCoomment(List<PageComment> tmpCommentList,List<PageComment> comments) {
        for (PageComment c : comments) {
			tmpCommentList.add(c);
			getReplyCoomment(tmpCommentList, c.getReplyComments());
		}
    }
    /**
     * 
     * @param page
     * @param blogId
     * @param parentCommentId
     * @return
     */
    private List<PageComment> getPageCommentListByPageAndParentCommentId(Integer page, Long blogId, Long parentCommentId){
        List<PageComment> comments=commentMapper.getPageCommentListByPageAndParentCommentId(page,blogId,parentCommentId);
        for(PageComment c : comments){
            List<PageComment> replyComments = getPageCommentListByPageAndParentCommentId(page,blogId,c.getId());
            c.setReplyComments(replyComments);
        }
        return comments;
    }
    /**
     * 通过id递归查询子评论
     */
    @Override
    public List<Comment> getAllReplyComments(Long parentCommentId) {
        List<Comment> comments = commentMapper.getListByParentCommentId(parentCommentId);
        for (Comment comment : comments) {
            List<Comment>replayComment = getAllReplyComments(comment.getId());
            comment.setReplyComments(replayComment);
        }
        return comments;
    }
    /**
     * 通过id获得某条评论
     */
    @Override
    public Comment geCommentId(Long id) {
        Comment comment = commentMapper.getCommentById(id);
        if(comment==null){
            throw new PersistenceException("评论不存在");
        }
        return comment;
    }
    /**
     * 更新评论的状态
     */
    @Override
    public void updateCommentPublicshedById(Long commentId, Boolean published) {
        int i = commentMapper.updateCommentPublishedById(commentId, published);
        if(i!=1){
            throw new PersistenceException("操作失败");
        }

    }
    /**
     *通过id删除评论
     */
    @Override
    public void deleteCommentById(Long commentId) {
        List<Comment> allReplyComments = getAllReplyComments(commentId);
        for (Comment allReplyComment : allReplyComments) {
            delete(allReplyComment);
        }

    }
    /**
     * 递归子删除评论
     * @param comment
     */
    private void delete(Comment comment){
        List<Comment> replyComments = comment.getReplyComments();
        for (Comment replyComment : replyComments) {
            delete(replyComment);
        }
        if(commentMapper.deleteCommentById(comment.getId())!=1){
            throw new PersistenceException("操作失败");
        }

    }

    /**
     * 通过blogid删除
     * @param Blogid
     */
    @Override
    public void deleteCommentByBlogId(Long Blogid) {
        commentMapper.deleteCommentById(Blogid);
    }

    /**
     * 更新comment
     * @param comment
     */
    @Override
    public void updateComment(Comment comment) {
        if(commentMapper.updateComment(comment)!=1){
            throw new PersistenceException("评论修改失败");
        }

    }

    /**
     * 统计
     * @param page
     * @param blogId
     * @return
     */
    @Override
    public int countByPageAndIsPublished(Integer page, Long blogId) {
        return commentMapper.countByPageAndIsPublished(page, blogId);
    }

    /**
     * 保存comment
     * @param ccomment
     */
    @Override
    public void saveComment(Ccomment ccomment) {
        if(commentMapper.saveComment(ccomment) != 1 ){
            throw new PersistenceException("评论失败");
        }

    }

    /**
     * 递归查询所有的评论
     * @param page
     * @param blogId
     * @param parentCommentId
     * @return
     */
    @Override
    public List<Comment> getListByPageAndParentCommentId(Integer page, Long blogId, Long parentCommentId) {
        List<Comment> comments = commentMapper.getListByPageAndParentCommentId(page,blogId,parentCommentId);
        for (Comment comment : comments) {
            List<Comment> comments1 = getListByPageAndParentCommentId(page, blogId, comment.getId());
            comment.setReplyComments(comments1);
        }
        return comments;
    }

}