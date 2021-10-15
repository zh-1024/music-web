package com.zh.music.service.impl;

import com.zh.music.dao.AdminMapper;
import com.zh.music.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName AdminServiceImpl
 * @Date 2021/10/13 23:33
 * @Author zhang hui
 * @Description
 */

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public boolean verifyPassword(String name, String password) {
        int count = adminMapper.verifyPassword(name, password);
        return count>0;

    }
}
