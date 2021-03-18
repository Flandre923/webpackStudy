package com.example.controller.admin;

import com.example.pojo.Friend;
import com.example.pojo.Tag;
import com.example.service.FriendService;
import com.example.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class AdminFriendController {
    @Autowired
    FriendService friendService;
    /**
     * 创建 或者编辑一个友链
     * @param map
     * @return
     */
    @PostMapping("/admin/friends")
    public Map createOrEditFriend(@RequestBody Map<String,Object> map){
        Friend friend = new Friend();
        // 判断是否为修改id
        if(map.get("id")!=null){
            friend.setId((Integer) map.get("id"));
            friend.setFriendname((String) map.get("friendname"));
            friend.setFrienddesc((String) map.get("frienddesc"));
            friend.setFriendurl((String) map.get("friendurl"));
            friend.setFriendavatar((String) map.get("friendavatar"));
            friendService.editFriend(friend);
            return ResultMap.returnResult(null,"修改成功",200);
        }
        friend.setFriendname((String) map.get("friendname"));
        friend.setFrienddesc((String) map.get("frienddesc"));
        friend.setFriendurl((String) map.get("friendurl"));
        friend.setFriendavatar((String) map.get("friendavatar"));
        List<Friend> friends = friendService.getFriendByName(friend.getFriendname());
        if(friends.size()>0){
            return ResultMap.returnResult(null,"friend已经存在",400);
        }
        friendService.insertFriend(friend);
        return ResultMap.returnResult(null,"创建成功",200);
    }

    /**
     * 删除Friend
     * @param friend
     * @return
     */
    @GetMapping("/admin/delete/friend")
    public Map deleteTag(Friend friend){
        friendService.deleteFriend(friend);
        return ResultMap.returnResult(null,"删除成功",200);
    }
}
