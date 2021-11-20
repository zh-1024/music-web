package com.zh.music.service;

import com.zh.music.bean.Singer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName SingerService
 * @Date 2021/10/14 16:42
 * @Author zhang hui
 * @Description TODO
 */


public interface SingerService {
    public boolean insert(Singer singer);
    public boolean update(Singer singer);
    public boolean delete(Integer id);

    //根据主键查询对象
    public Singer queryById(Integer id);
    //查询所有歌手
    public List<Singer> queryAllSinger();

    //根据歌手名字模糊查询
    public List<Singer> queryByName(String name);

    //根据性别查询
    public List<Singer> queryBySex(Integer sex);
    public int getSingerCount();
}
