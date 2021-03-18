package com.example.controller.admin;

import com.example.pojo.Tag;
import com.example.service.TagService;
import com.example.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class AdminTagController {
    @Autowired
    TagService tagService;

    /**
     * 创建 或者编辑一个tag
     * @param map
     * @return
     */
    @PostMapping("/admin/tags")
    public Map createOrEditTag(@RequestBody Map<String,Object> map){
        Tag tag = new Tag();
        // 判断是否为修改id
        if(map.get("id")!=null){
            tag.setId((Integer) map.get("id"));
            tag.setName((String) map.get("name"));
            tagService.editTag(tag);
            return ResultMap.returnResult(null,"修改成功",200);
        }
        tag.setName((String) map.get("name"));
        List<Tag> currenttag = tagService.getTagByName(tag.getName());
        if(currenttag.size()>0){
            return ResultMap.returnResult(null,"tag已经存在",400);
        }
        tagService.insertTag(tag);
        return ResultMap.returnResult(null,"创建成功",200);
    }

    /**
     * 删除tag
     * @param tag
     * @return
     */
    @GetMapping("/admin/delete/tag")
    public Map deleteTag(Tag tag){
        System.out.println(tag);
        tagService.deleteTagById((Integer)tag.getId());
        return ResultMap.returnResult(null,"删除成功",200);
    }
}
