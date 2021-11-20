package com.zh.music.dao;

import com.zh.music.bean.Singer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SingerMapper {
    public int insert(Singer singer);
    public int update(Singer singer);
    public int delete(Integer id);

    //根据主键查询对象
    public Singer queryById(Integer id);
    //查询所有歌手
    public List<Singer> queryAllSinger();
    public int getSingerCount();
    //根据歌手名字模糊查询
    public List<Singer> queryByName(String name);

    //根据性别查询
    public List<Singer> queryBySex(Integer sex);
}
