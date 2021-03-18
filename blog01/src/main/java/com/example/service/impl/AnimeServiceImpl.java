package com.example.service.impl;

import com.example.mapper.AnimeMapper;
import com.example.pojo.Anime;
import com.example.pojo.Friend;
import com.example.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AnimeServiceImpl implements AnimeService {
    @Autowired
    private AnimeMapper animeMapper;

    @Override
    public List<Anime> getAllAnime() {
        List<Anime> getallanime = animeMapper.getallanime();
        return getallanime;
    }

    /**
     * 修改一个番剧名字
     * @param anime
     * @return
     */
    @Override
    public int editAnime(Anime anime) {
        animeMapper.updateById(anime);
        return 1;
    }

    /**
     * 通过一个番剧名字获得番剧
     * @param animename
     * @return
     */
    @Override
    public List<Anime> getAnimeByName(String animename) {
        Map map = new HashMap<String,Object>();
        map.put("animename",animename);
        List list = animeMapper.selectByMap(map);
        return list;
    }

    /**
     * 增加一个番剧
     * @param anime
     * @return
     */
    @Override
    public int insertAnime(Anime anime) {
        System.out.println(anime);
        animeMapper.insert(anime);
        return 1;
    }

    /**
     * 删除一个饭局
     * @param anime
     * @return
     */
    @Override
    public int deleteAnime(Anime anime) {
        animeMapper.deleteById(anime.getId());
        return 1;
    }

}
