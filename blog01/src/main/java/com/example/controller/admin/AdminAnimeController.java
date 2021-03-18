package com.example.controller.admin;

import com.example.pojo.Anime;
import com.example.pojo.Friend;
import com.example.service.AnimeService;
import com.example.service.FriendService;
import com.example.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class AdminAnimeController {
    @Autowired
    AnimeService animeService;
    /**
     * 创建 或者编辑一个友链
     * @param map
     * @return
     */
    @PostMapping("/admin/anime")
    public Map createOrEditAnime(@RequestBody Map<String,Object> map){
        Anime anime = new Anime();
        // 判断是否为修改id
        if(map.get("id")!=null){
            anime.setId((Integer) map.get("id"));
            anime.setAnimename((String) map.get("animename"));
            anime.setAnimedesc((String) map.get("animeoriginname"));
            anime.setAnimeimg((String) map.get("animeimg"));
            anime.setAnimeprogress((Integer) map.get("animeprogress"));
            anime.setAnimedesc((String) map.get("animedesc"));
            animeService.editAnime(anime);
            return ResultMap.returnResult(null,"修改成功",200);
        }
        System.out.println(map);
        anime.setAnimename((String) map.get("animename"));
        anime.setAnimeoriginname((String) map.get("animeoriginname"));
        anime.setAnimeimg((String) map.get("animeimg"));
        anime.setAnimedesc((String) map.get("animedesc"));
        anime.setAnimeprogress((Integer) map.get("animeprogress"));
        List<Anime> animes = animeService.getAnimeByName(anime.getAnimename());
        if(animes!=null && animes.size()>0){
            return ResultMap.returnResult(null,"friend已经存在",400);
        }
        animeService.insertAnime(anime);
        return ResultMap.returnResult(null,"创建成功",200);
    }

    @GetMapping("/admin/delete/anime")
    public Map deleteTag(Anime anime){
        animeService.deleteAnime(anime);
        return ResultMap.returnResult(null,"删除成功",200);
    }
}
