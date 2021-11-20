package com.zh.music.service.impl;

import com.zh.music.bean.User;
import com.zh.music.dao.UserMapper;
import com.zh.music.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public boolean forbidByPrimaryKey(Integer forbidden, Integer id) {
        return userMapper.forbidByPrimaryKey(forbidden,id)>0;
    }

    @Override
    public List<User> allUser() {
        System.out.println(userMapper);
        return userMapper.allUser();
    }
}
