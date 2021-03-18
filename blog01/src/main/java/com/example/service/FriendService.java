package com.example.service;

import com.example.pojo.Friend;

import java.util.List;

public interface FriendService {
    public List<Friend> getFriend();

    public int editFriend(Friend friend);

    List<Friend> getFriendByName(String friendname);

    public int insertFriend(Friend friend);

    public int deleteFriend(Friend friend);
}
