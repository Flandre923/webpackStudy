package com.example.controller.admin;

import com.example.pojo.Admin;
import com.example.pojo.AdminLoginParam;
import com.example.service.IAadminService;
import com.example.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private IAadminService adminService;
    @RequestMapping("/login")
    public Map login(AdminLoginParam adminLoginParam, HttpServletRequest request){
//        System.out.println(adminLoginParam);
        return adminService.login(adminLoginParam.getUsername(),adminLoginParam.getPassword(),request);
    }

    @GetMapping("/admin/info")
    public Admin getAdminInfo(Principal principal){
        if(null == principal){
            return null;
        }
        String username = principal.getName();
        Admin admin = adminService.getAdminByUserName(username);
        admin.setPassword(null);
        return admin;
    }

    @PostMapping("/logout")
    public Map logout(){
        return ResultMap.returnResult(null,"注销成功",200);
    }
}
