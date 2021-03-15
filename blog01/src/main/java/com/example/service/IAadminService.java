package com.example.service;

import com.example.pojo.Admin;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface IAadminService {
    /**
     * 登录之后返回token
     * @param username
     * @param password
     * @param request
     * @return
     */
    Map login(String username, String password, HttpServletRequest request);

    public Admin getAdminByUserName(String username);
}
