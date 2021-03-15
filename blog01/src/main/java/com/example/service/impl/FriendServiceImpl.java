package com.example.service.impl;

import com.example.mapper.FriendsMapper;
import com.example.pojo.Friends;
import com.example.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FriendServiceImpl implements FriendService{
    @Autowired
    private FriendsMapper friendsMapper;

    @Override
    public List<Friends> getFriend() {
        List<Friends> friends = friendsMapper.getFriends();
//        System.out.println(friends);
        return friends;
    }
}
