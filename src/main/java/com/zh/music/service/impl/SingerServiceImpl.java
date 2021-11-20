package com.zh.music.service.impl;

import com.zh.music.bean.Singer;
import com.zh.music.dao.SingerMapper;
import com.zh.music.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName SingerServiceImpl
 * @Date 2021/10/14 16:43
 * @Author zhang hui
 * @Description TODO
 */

@Service
public class SingerServiceImpl implements SingerService {
    @Autowired
    SingerMapper singerMapper;
    @Override
    public boolean insert(Singer singer) {
        int insert = singerMapper.insert(singer);
        return insert>0;
    }

    @Override
    public boolean update(Singer singer) {
        int update = singerMapper.update(singer);
        return update>0;
    }

    @Override
    public boolean delete(Integer id) {
        int delete = singerMapper.delete(id);
        return delete>0;
    }

    @Override
    public Singer queryById(Integer id) {
        Singer singer = singerMapper.queryById(id);
        return singer;
    }

    @Override
    public List<Singer> queryAllSinger() {
        List<Singer> singers = singerMapper.queryAllSinger();
        return singers;
    }

    @Override
    public List<Singer> queryByName(String name) {
        List<Singer> singers = singerMapper.queryByName(name);
        return singers;
    }

    @Override
    public List<Singer> queryBySex(Integer sex) {
        List<Singer> singers = singerMapper.queryBySex(sex);
        return singers;
    }

    @Override
    public int getSingerCount() {
        return singerMapper.getSingerCount();
    }
}
