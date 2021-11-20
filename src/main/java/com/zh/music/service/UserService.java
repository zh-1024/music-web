package com.zh.music.service;

import com.zh.music.bean.User;

import java.util.List;

public interface UserService {
   public boolean forbidByPrimaryKey(Integer forbidden,Integer id);
   public List<User> allUser();
}
