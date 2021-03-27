package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mapper.BlogMapper;
import com.example.pojo.Blog;
import com.example.pojo.BlogToTag;
import com.example.pojo.Tag;
import com.example.pojo.TagIdAndTagToBlogID;
import com.example.pojo.params.PageSizeCurrent;
import com.example.service.BlogService;
import com.example.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogMapper blogMapper;
    @Autowired
    TagService tagService;

    /**
     * 获得所有blog
     * @return
     */
    @Override
    public Page getBlogs(PageSizeCurrent page) {
        int current=0,size=0;
        if(page != null && page.getCurrent()!= null
                && page.getPage_size()!= null
                && page.getPage_size() > 0 && page.getCurrent()>0){
            current = page.getCurrent();
            size = page.getPage_size();
        }else{
            if(page==null || page.getCurrent() == null || page.getPage_size() ==null){
                QueryWrapper qw = new QueryWrapper();
                qw.orderByDesc("create_time");
                System.out.println("============page===========");
                Page<Blog> footerblogs = new Page<>(1,4);
                blogMapper.selectPage(footerblogs,qw);
                return  footerblogs;
            }
            current = 1;
            size= 10;
        }
        QueryWrapper qw = new QueryWrapper();
        qw.orderByDesc("create_time");
        Page<Blog> page1 = new Page<>(current,size);
        blogMapper.selectPage(page1,qw);
        return page1;
    }

    /**
     * 查询博客的年份
     * @return
     */
    @Override
    public List getBlogDate() {
//        查到博客的年份
        List<Date> dates = blogMapper.selectBlogDate();
//        处理掉重复的年份
        Set yearSet = new HashSet();
//        处理出来年份
        SimpleDateFormat f = new SimpleDateFormat("yyyy");
        dates.forEach(date -> {
            yearSet.add(f.format(date));
        });
//        查出来每一个年份下面的博客
//        把年份和博客放到一个map中
//        把每个年份和对应的map放到数组中
        List<Map> maplist = new ArrayList<>();
        yearSet.forEach(year -> {
            Map<String,Object> map = new HashMap<>();
            map.put("year",year);
            List<Blog> blogs = blogMapper.selectBlogsCategroy(year+"%");
            map.put("blogs",blogs);
            maplist.add(map);
        });
//        maplist.forEach(System.out::println);
        return maplist;
    }

    /**
     * 通过分页查询查到博客的内容
     * @return
     */
    @Override
    public Page selectBlogByPage(Map map) {
        int current=1,size=5;
        if(map.get("current")!=null && (int)map.get("current")!=0){
            current = (int)map.get("current");
        }
        if(map.get("size")!=null && (int)map.get("size")!=0){
            size = (int)map.get("size");
        }
        Page<Blog> page = new Page<>(current,size);
        blogMapper.selectPage(page,null);
        return page;
    }

    /**
     * 通过id查询一篇blog
     * @param id
     * @return
     */
    @Override
    public Blog selectBlogOneById(int id) {
        Blog blog = blogMapper.selectBlogById(id);
        return blog;
    }

    /**
     * 通过id更新blog
     * @param blog
     * @return
     */
    @Override
    public int updateBlog(Blog blog,List list) {
        // 查询到所有tag和blog的关系
        BlogToTag blogTags = blogMapper.selectTagList(blog.getId());
        System.out.println("----blogTags------"+blogTags);
        for (Object i : list) {
            int i2 = (int) i;
            Tag tag = new Tag();
            tag.setId(i2);
            Tag tag1 = tagService.selectTagByID(tag);
            // tag在表中存在
            if(tag1 != null){
                Map map = new HashMap();
                map.put("blogid",blog.getId());
                map.put("tagid",tag1.getId());
                Map map1 = blogMapper.selectBlog2TagByTagId(map);

                if(map1 != null){
                    // 获得所有不应该在数据库中出现的tag并删除这些tag
                    List<TagIdAndTagToBlogID> tags1 = blogTags.getList();
                    System.out.println("----tags1------"+tags1);
                    for (int i1 = 0; i1 < tags1.size(); i1++) {
                        if(tags1.get(i1).getTagid() == tag.getId()){
                            tags1.remove(i1);
                        }
                    }
                    System.out.println("----tags1------"+tags1);
                    //删除不应该有关系的tag
                    for (int i1 = 0; i1 < tags1.size(); i1++) {
                        blogMapper.removeBlog2Tag(tags1.get(i1).getId());
                    }
                    //tag存在 并且 tag与blog关系存在，则更新blog和tag的关系
                    Map map2 = new HashMap();
                    map2.put("blogid",blog.getId());
                    map2.put("tagid",tag1.getId());
                    map2.put("blog2tagid",map1.get("id"));
                    blogMapper.updateBlog2Tag(map2);
                }else{
                    // tag 与blog 关系不存在 则创建相应的关系
                    Map map3 = new HashMap();
                    map3.put("blogid",blog.getId());
                    map3.put("tagid",tag1.getId());
                    blogMapper.insertBlog2Tag(map3);
                }
            }
        }
        if(list.size()==0 || list ==null ){
            //                //查询该文章下所有的tag并删除
            List<TagIdAndTagToBlogID> tags1 =  blogTags.getList();
            for (int i1 = 0; i1 < tags1.size(); i1++) {
                blogMapper.removeBlog2Tag((tags1.get(i1).getId()));
            }
        }


        blogMapper.updateById(blog);
        return 1;
    }

    /**
     * 插入一篇博客
     * @param blogt
     * @param list
     * @return
     */
    @Override
    public int insertBlog(Blog blogt, List list) {
        blogMapper.insert(blogt);
        Map<String,Object> map = new HashMap<>();
        map.put("title",blogt.getTitle());
        List<Blog> blogs = blogMapper.selectByMap(map);
        Blog blog = blogs.get(0);
        int id =blog.getId();
        list.forEach(l->{
            map.clear();
            map.put("blogid",id);
            map.put("tagid",(int)l);
            blogMapper.insertBlog2Tag(map);
        });
        return 1;
    }

    @Override
    public int deteleBlogById(int id) {
        blogMapper.deleteById(id);
        blogMapper.deleteBlog2Tag(id);
        return 1;
    }


}
