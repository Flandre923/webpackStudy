package com.example.service.impl;

import com.example.mapper.FriendsMapper;
import com.example.pojo.Friend;
import com.example.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FriendServiceImpl implements FriendService{
    @Autowired
    private FriendsMapper friendsMapper;

    /**
     * 获得友链
     * @return
     */
    @Override
    public List<Friend> getFriend() {
        List<Friend> friends = friendsMapper.getFriends();
//        System.out.println(friends);
        return friends;
    }

    /**
     * 编辑一个友链
     * @param friend
     * @return
     */
    @Override
    public int editFriend(Friend friend) {
        friendsMapper.updateById(friend);
        return 0;
    }

    /**
     * 查询友链通过名字
     * @param friendname
     * @return
     */
    @Override
    public List<Friend> getFriendByName(String friendname) {
        Map map = new HashMap<String,Object>();
        map.put("friendname",friendname);
        List list = friendsMapper.selectByMap(map);
        return list;
    }

    /**
     * 创建友链
     * @param friend
     * @return
     */
    @Override
    public int insertFriend(Friend friend) {
        System.out.println(friend);
        friendsMapper.insert(friend);
        return 1;
    }

    /**
     * 通过id删除友链
     * @param friend
     * @return
     */
    @Override
    public int deleteFriend(Friend friend) {
        friendsMapper.deleteById(friend.getId());
        return 1;
    }

}
