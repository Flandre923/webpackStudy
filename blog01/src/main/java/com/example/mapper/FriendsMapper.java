package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.Friend;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendsMapper extends BaseMapper<Friend> {
    public List<Friend> getFriends();
}
