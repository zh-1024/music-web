package com.zh.music.dao;

import com.zh.music.bean.Song;
import com.zh.music.bean.SongList;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongListMapper {
    public int insert(SongList songList);
    public int update(SongList songList);
    public int delete(Integer id);

    //根据主键查询对象
    public SongList queryById(Integer id);
    //查询所有歌单
    public List<SongList> queryAllSongList();
    public int getSongListCount();
    //根据歌单风格查询
    public List<SongList> queryByStyle(String style);
}
