package com.example.controller;

import com.example.pojo.Anime;
import com.example.pojo.Blog;
import com.example.service.AnimeService;
import com.example.service.BlogService;
import com.example.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AnimeController {
    @Autowired
    private AnimeService animeService;

    @RequestMapping("/anime/anime")
    public Map home(){
        List<Anime> allAnime = animeService.getAllAnime();
        return ResultMap.returnResult(allAnime);
    }
}
