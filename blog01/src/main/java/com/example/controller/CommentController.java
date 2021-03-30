package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.pojo.Comment;
import com.example.pojo.params.Ccomment;
import com.example.pojo.params.PageComment;
import com.example.pojo.params.PageResult;
import com.example.service.BlogService;
import com.example.service.CommentService;
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
    /**
     * 根据页面查询
     */
    @GetMapping("/comment")
    public Map<String,Object> comment(@RequestParam Integer page,
    @RequestParam(defaultValue = "") Long blogId,
    @RequestParam(defaultValue = "1")Integer pagenum,
    @RequestParam(defaultValue = "10")Integer pagesize){
        Integer count = commentService.countByPageAndIsPublished(page, blogId);
        PageHelper.startPage(pagenum,pagesize);
        PageInfo<PageComment> pageInfo = new PageInfo<>(commentService.getPageCommentList(page, blogId, -1L));
        PageResult<PageComment> pageResult = new PageResult<>(pageInfo.getPages(),pageInfo.getList());
        Map<String, Object> map = new HashMap<>();
		map.put("count", count);
		map.put("comments", pageResult);
        return ResultMap.ok("获取成功", map);
    }

    @PostMapping("/comment")
    public Map<String,Object> commitComment(@RequestBody Ccomment ccomment){
        // 判断内容是否合法
        if(StringUtils.isEmpty(ccomment.getContent()) || ccomment.getContent().length() > 250){
            return ResultMap.error("参数错误");
        }
        // 判断提交地址是否可以被提交
        int judegeResult = judgeCommentEnable(ccomment.getPage(),ccomment.getBlogId());
        //
        if(judegeResult == 0){//正常可以提交
            
        }
        return ResultMap.ok("请求评论成功");

    }

    private int judgeCommentEnable(Integer page,Long blogId) {
        if(page==0){ // 普通的博客页面
            //
            //Boolean commentEnable = blogService.getComemntEnableBlog(blogId);
            return 0;
        }
        if(page==1){//关于我页面
            // 
            return 0;
        }else if(page==2){//友链
            return 0;
        }
        return  0;
    }
}