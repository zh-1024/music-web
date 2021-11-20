package com.zh.music.dao;

import com.zh.music.bean.ListSong;
import com.zh.music.bean.SongList;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListSongMapper {
    public int insert(ListSong listSong);
    public int update(ListSong listSong);
    public int delete(Integer id);
    public int deleteBySongIdAndSongListID(Integer songId,Integer songListId);

    //根据主键查询
    public ListSong queryById(Integer id);
    //查询歌单所有的歌曲
    public List<ListSong> queryAllListSong();

    //根据歌单id查询查询所有歌曲
    public List<ListSong> queryBySongListId(Integer id);
}
