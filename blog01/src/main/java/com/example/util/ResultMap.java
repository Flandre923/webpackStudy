package com.example.util;

import java.util.HashMap;
import java.util.Map;

public class ResultMap {
    public static Map returnResult(Object data){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("data",data);
        return resultMap;
    }
}
