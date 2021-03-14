package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.Anime;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimeMapper extends BaseMapper<Anime> {
    public List<Anime> getallanime();
}
