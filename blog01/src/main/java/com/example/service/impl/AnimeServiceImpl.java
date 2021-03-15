package com.example.service.impl;

import com.example.mapper.AnimeMapper;
import com.example.pojo.Anime;
import com.example.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeServiceImpl implements AnimeService {
    @Autowired
    private AnimeMapper animeMapper;

    @Override
    public List<Anime> getAllAnime() {
        List<Anime> getallanime = animeMapper.getallanime();
        return getallanime;
    }

}
