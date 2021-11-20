package com.zh.music.service;

import com.zh.music.bean.ListSong;
import com.zh.music.bean.SongList;

import java.util.List;

public interface ListSongService {
    public boolean insert(ListSong listSong);
    public boolean update(ListSong listSong);
    public boolean delete(Integer id);
    public boolean deleteBySongIdAndSongListID(Integer songId,Integer songListId);

    //根据主键查询
    public ListSong queryById(Integer id);
    //查询歌单所有的歌曲
    public List<ListSong> queryAllListSong();

    //根据歌单id查询查询所有歌曲
    public List<ListSong> queryBySongListId(Integer id);
}
