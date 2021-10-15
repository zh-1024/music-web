package com.zh.music.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * 管理员dao
 */
@Repository
public interface AdminMapper {
    /**
     * @param name 管理员账号
     * @param password 管理员密码
     * @Description: 验证登陆的管理员的账号和密码
     * @author zhanghui
     * @date 2021/10/13 22:51
    */
    public int verifyPassword(@Param("name") String name,@Param("password") String password);

}
