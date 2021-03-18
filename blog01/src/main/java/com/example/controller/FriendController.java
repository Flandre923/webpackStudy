package com.example.controller;

import com.example.pojo.Friend;
import com.example.service.FriendService;
import com.example.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class FriendController {
    @Autowired
    FriendService friendService;
    @RequestMapping("/friends/fri")
    public Map getfriends(){
        List<Friend> friend = friendService.getFriend();
        return ResultMap.returnResult(friend);
    }
}
