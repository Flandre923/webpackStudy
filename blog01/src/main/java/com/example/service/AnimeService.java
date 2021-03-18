package com.example.service;

import com.example.pojo.Anime;
import com.example.pojo.Friend;

import java.util.List;

public interface AnimeService {
    public List<Anime> getAllAnime();

    public int editAnime(Anime anime);

    List<Anime> getAnimeByName(String animename);

    public int insertAnime(Anime anime);

    public int deleteAnime(Anime anime);
}
