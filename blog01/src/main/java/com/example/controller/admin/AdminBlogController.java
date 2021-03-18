package com.example.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.pojo.AdminLoginParam;
import com.example.pojo.Blog;
import com.example.pojo.Tag;
import com.example.service.BlogService;
import com.example.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AdminBlogController {
    @Autowired
    private BlogService blogService;

    /**
     * 通过id查blog
     * @param id
     * @return
     */
    @GetMapping("/admin/blog/id")
    public Map login(@RequestParam(name = "id") int id){
//        System.out.println(id);
        Blog blog = blogService.selectBlogOneById(id);
        return ResultMap.returnResult(blog,"123",200);
    }

    /**
     * 后台分页查询
     * @param map
     * @return
     */
    @GetMapping("/admin/blog")
    public Map login(Map map){
//        System.out.println(map);
        Page blogPage = blogService.selectBlogByPage(map);
        Map<String,Object> rmap = new HashMap();
        rmap.put("data",blogPage.getRecords());
        rmap.put("total",blogPage.getTotal());
        return ResultMap.returnResult(rmap,"123",200);
    }

    /**
     * 通过di修改文章
     * @param blog
     * @return
     */
    @PostMapping("/admin/blog")
    public Map createEditBlog(@RequestBody Map blog){
        System.out.println(blog);
        if(blog.get("id")!=null){
            Blog blogt = new Blog();
            blogt.setId((Integer) blog.get("id"));
            blogt.setTitle((String) blog.get("title"));
            blogt.setSummary((String) blog.get("summary"));
            blogt.setContent((String) blog.get("content"));
            blogt.setNumber((Integer) blog.get("number"));
            blogt.setReadTime((Integer) blog.get("readTime"));
            blogt.setPicture((String) blog.get("picture"));
            List list = (List<Integer>)blog.get("tags");
            blogt.setUpdateTime(new Date());
            blogService.updateBlog(blogt,list);
        }else{
            Blog blogt = new Blog();
            blogt.setTitle((String) blog.get("title"));
            blogt.setSummary((String) blog.get("summary"));
            blogt.setContent((String) blog.get("content"));
            blogt.setNumber((Integer) blog.get("number"));
            blogt.setReadTime((Integer) blog.get("readTime"));
            blogt.setPicture((String) blog.get("picture"));
            List list = (List<Integer>)blog.get("tags");
            blogt.setUpdateTime(new Date());
            blogt.setCreateTime(new Date());
            blogService.insertBlog(blogt,list);
        }
        return ResultMap.returnResult(null,"操作成功",200);
    }
    @GetMapping("/admin/blog/delete")
    public Map deleteBlog(int id){
        blogService.deteleBlogById(id);
        return  ResultMap.returnResult(null,"操作成功",200);
    }


}
