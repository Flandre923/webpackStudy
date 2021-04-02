package com.example.controller.admin;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.pojo.Blog;
import com.example.pojo.Comment;
import com.example.service.BlogService;
import com.example.service.CommentService;
import com.example.util.ResultMap;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class AdminCommentController {
    @Autowired
    CommentService commentService;
    @Autowired
    BlogService blogService;

    /**
     * 按照page和blogid查询评论
     * @param page
     * @param blogId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/admin/comments")
    public Map<String,Object> comments(@RequestParam(defaultValue = "")Integer page,
                                       @RequestParam(defaultValue = "")Long blogId,
                                       @RequestParam(defaultValue = "1")Integer pageNum,
                                       @RequestParam(defaultValue = "10")Integer pageSize){
        String orderBy = "create_time desc";
        PageHelper.startPage(pageNum,pageSize,orderBy);
        List<Comment> comments = commentService.getListByPageAndParentCommentId(page,blogId,-1L);
        PageInfo<Comment> pageInfo = new PageInfo<>(comments);
        return ResultMap.ok("请求成功",pageInfo);
    }

    /**
     * 获得所有的blogid和title
     * @return
     */
    @GetMapping("/admin/blogIdAndTitle")
    public Map<String,Object> blogIdAndTitle(){
        List<Blog> blogs = blogService.getIdAndTitleList();
        return ResultMap.ok("请求成功",blogs);
    }

    /**
     * 更新评论公开
     * @param id
     * @param published
     * @return
     */
    public Map<String,Object> updateCommentPublicshedById(@RequestParam Long id,@RequestParam Boolean published){
        commentService.updateCommentPublicshedById(id,published);
        return ResultMap.ok("操作成功");
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public Map<String,Object> delete(@RequestParam Long id){
        commentService.deleteCommentById(id);
        return ResultMap.ok("删除成功");
    }

    public Map<String,Object> updateComment(@RequestParam Comment comment){
        if(StringUtils.isEmpty(comment.getNickname())
        ||StringUtils.isEmpty(comment.getContent())
        ||StringUtils.isEmpty(comment.getAvatar())
        ||StringUtils.isEmpty(comment.getEmail())){
            return ResultMap.error("参数错误");
        }
        commentService.updateComment(comment);
        return ResultMap.ok("评论修改成功");
    }




}
