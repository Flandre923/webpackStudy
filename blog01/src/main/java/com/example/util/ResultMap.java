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

    public static Map<String,Object> ok(String msg,Object data){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("data",data);
        resultMap.put("message",msg);
        resultMap.put("code",200);
        return resultMap;
    }

    public static Map<String,Object> ok(String msg){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("message",msg);
        resultMap.put("code",200);
        return resultMap;
    }

    public static Map<String,Object> error(String msg){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("message",msg);
        resultMap.put("code",500);
        return resultMap;
    }


    public static Map<String,Object> error(){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("message","异常错误");
        resultMap.put("code",500);
        return resultMap;
    }

    public static Map<String,Object> create(Integer code,String msg,Object data){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("msg",msg);
        resultMap.put("code",code);
        resultMap.put("data",data);
        return resultMap;
    }

    public static Map<String,Object> create(Integer code,String msg ){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("code",msg);
        resultMap.put("code",code);
        return resultMap;
    }

}
