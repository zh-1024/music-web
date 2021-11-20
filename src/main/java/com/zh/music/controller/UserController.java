package com.zh.music.controller;

import com.alibaba.fastjson.JSONObject;
import com.zh.music.bean.SongList;
import com.zh.music.bean.User;
import com.zh.music.service.UserService;
import com.zh.music.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @GetMapping("/getAllUser")
    public Object getAllUser(){
        List<User> users = userService.allUser();
        return users;
    }

    @PostMapping("/forbidUser")
    public Object forbidUser(Integer forbidden, Integer id){
        System.out.println(id);
        boolean flag = userService.forbidByPrimaryKey(forbidden, id);
        JSONObject jsonObject = new JSONObject();
        if(flag)
        {
            jsonObject.put("code",1);
            jsonObject.put("message", "禁用成功");
            return jsonObject;
        }
        jsonObject.put("code",0);
        jsonObject.put("message", "禁用失败");
        return jsonObject;
    }

}
