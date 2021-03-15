package com.example.util;

import java.util.HashMap;
import java.util.Map;

public class ResultMap {
    public static Map returnResult(Object data){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("data",data);
        return resultMap;
    }

    // 成功 返回
    public static Map returnResult(Object data,String message,int code){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("data",data);
        resultMap.put("message",message);
        resultMap.put("code",code);
        return resultMap;
    }

    // 成功 返回 200
    public static Map returnResult(Object data,String message){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("data",data);
        resultMap.put("message",message);
        resultMap.put("code",200);
        return resultMap;
    }


}
