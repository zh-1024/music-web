package com.zh.music.controller;

import com.alibaba.fastjson.JSONObject;
import com.zh.music.dao.AdminMapper;
import com.zh.music.service.AdminService;
import com.zh.music.service.impl.AdminServiceImpl;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @ClassName AdminController
 * @Date 2021/10/14 10:10
 * @Author zhang hui
 * @Description 音乐管理系统相关controller
 */

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminServiceImpl adminService;

    @PostMapping("/login/status")
    public Object loginStatus(@RequestParam("name") String name,
                              @RequestParam("password") String password,
                              HttpSession session){
        JSONObject jsonObject = new JSONObject();
        boolean login = adminService.verifyPassword(name,password);
        if(login){
            jsonObject.put("code",1);
            jsonObject.put("message", "登陆成功");
            session.setAttribute("name",name);
            return jsonObject;
        }
        jsonObject.put("code",0);
        jsonObject.put("message","用户名或密码错误");
        return jsonObject;

    }
}
