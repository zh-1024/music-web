package com.zh.music.dao;

import com.zh.music.bean.Song;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongMapper {
    public int insert(Song song);
    public int update(Song song);
    public int delete(Integer id);

    //根据主键查询对象
    public Song queryById(Integer id);
    //查询所有歌曲
    public List<Song> queryAllSong();
    //查询歌曲数量
    public int getSongCount();

    //根据歌曲名字查询
    public List<Song> queryByName(String name);
    //根据歌手id查询
    public List<Song> queryBySingerId(Integer singerId);

}
