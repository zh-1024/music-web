package com.zh.music.dao;

import com.zh.music.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
   public int forbidByPrimaryKey(Integer forbidden,Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int verifyPassword(String username, String password);

    int existUsername(String username);

    int addUser(User consumer);

    int updateUserMsg(User record);

    int updateUserAvatar(User record);

    int deleteUser(Integer id);

    public List<User> allUser();

    List<User> userOfId(Integer id);
    List<User> loginStatus(String username);
}
