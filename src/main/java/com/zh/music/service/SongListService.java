package com.zh.music.service;

import com.zh.music.bean.SongList;

import java.util.List;

public interface SongListService {
    public boolean insert(SongList songList);
    public boolean update(SongList songList);
    public boolean delete(Integer id);

    //根据主键查询对象
    public SongList queryById(Integer id);
    //查询所有歌单
    public List<SongList> queryAllSongList();
    public int getSongListCount();
    //根据歌单风格查询
    public List<SongList> queryByStyle(String style);
}
