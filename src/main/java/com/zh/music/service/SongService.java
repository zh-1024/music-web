package com.zh.music.service;


import com.zh.music.bean.Song;

import java.util.List;

public interface SongService {
    public boolean insert(Song song);
    public boolean update(Song song);
    public boolean delete(Integer id);

    //根据主键查询对象
    public Song queryById(Integer id);
    //查询所有歌曲
    public List<Song> queryAllSong();

    //根据歌曲名字查询
    public List<Song> queryByName(String name);
    //根据歌手id查询
    public List<Song> queryBySingerId(Integer singerId);
}
