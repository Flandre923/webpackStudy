package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.pojo.Comment;
import com.example.pojo.params.Ccomment;
import com.example.pojo.params.PageComment;
import com.example.pojo.params.PageResult;
import com.example.service.AboutService;
import com.example.service.BlogService;
import com.example.service.CommentService;
import com.example.service.FriendService;
import com.example.util.ResultMap;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
    @Autowired
    CommentService commentService;
    @Autowired
    BlogService blogService;
    @Autowired
    AboutService aboutService;
    @Autowired
    FriendService friendService;
    /**
     * 根据页面查询
     */
    @GetMapping("/comment")
    public Map<String,Object> comment(@RequestParam Integer page,
    @RequestParam(defaultValue = "") Long blogId,
    @RequestParam(defaultValue = "1")Integer pagenum,
    @RequestParam(defaultValue = "10")Integer pagesize){
        //总数
        Integer count = commentService.countByPageAndIsPublished(page, blogId);
        //分页
        PageHelper.startPage(pagenum,pagesize);
        PageInfo<PageComment> pageInfo = new PageInfo<>(commentService.getPageCommentList(page, blogId, -1L));
        // 结束查询
        PageResult<PageComment> pageResult = new PageResult<>(pageInfo.getPages(),pageInfo.getList());
        Map<String, Object> map = new HashMap<>();
		map.put("count", count);
		map.put("comments", pageResult);
        return ResultMap.ok("获取成功", map);
    }

    /**
     * 提交消息
     * @param ccomment
     * @return
     */
    @PostMapping("/comment")
    public Map<String,Object> commitComment(@RequestBody Ccomment ccomment){
        // 判断内容是否合法
        if(StringUtils.isEmpty(ccomment.getContent()) || ccomment.getContent().length() > 250){
            return ResultMap.error("参数错误");
        }
        // 判断提交地址是否可以被提交
        int judegeResult = judgeCommentEnable(ccomment.getPage(),ccomment.getBlogId());
        //
        if(judegeResult == 2){
            return ResultMap.create(404,"该博客不存在");
        }else if(judegeResult==1) {
            return ResultMap.create(403, "评论已关闭");
        }else if(judegeResult==0){//普通文章
            if(StringUtils.isEmpty(ccomment.getEmail())|| StringUtils.isEmpty(ccomment.getNickname())|| ccomment.getNickname().length()>15){
                return ResultMap.error("参数不合法");
            }
        }
        commentService.saveComment(ccomment);
        return ResultMap.ok("请求评论成功");

    }

    /**
     * 校验消息合法性
     * @param page
     * @param blogId
     * @return
     */
    private int judgeCommentEnable(Integer page,Long blogId) {
        if(page==0){ // 普通的博客页面
            Boolean commentEnable = false; //评论关闭
            Boolean published = false;  //博客未公开
            if(commentEnable == null ||published==null ){
                // 未查询到该博客
                return 2 ;
            } else if(!published){ //博客未公开
                return 2 ;
            } else if(!commentEnable){  // 博客评论关闭
                return 1;
            }
            //判断文章时候有密码
            return 0;
        }else if(page==1){//关于我页面
            Boolean enableCommentAble = false ;  //aboutService.getAboutCommentEnable
            if(!enableCommentAble){
                return  1;
            }
            return 0;
        }else if(page==2){//友链
            Boolean  enableCommentAble = false;
            if(!enableCommentAble){
                return 1;
            }
        }
        return  0;
    }
}