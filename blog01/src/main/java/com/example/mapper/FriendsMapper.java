package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.Anime;
import com.example.pojo.Friends;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendsMapper extends BaseMapper<Friends> {
    public List<Friends> getFriends();
}
