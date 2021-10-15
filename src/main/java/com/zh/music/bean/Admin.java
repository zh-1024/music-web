package com.zh.music.bean;


import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName Admin
 * @Date 2021/10/13 22:47
 * @Author zhang hui
 * @Description 管理员信息
 */

@Data
public class Admin implements Serializable {
    private Integer id;//主键
    private String name;//账号名
    private String password;//密码

}
