package com.zh.music.service.impl;

import com.zh.music.bean.SongList;
import com.zh.music.dao.SongListMapper;
import com.zh.music.service.SongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongListServiceImpl implements SongListService {

    @Autowired
    SongListMapper songListMapper;
    @Override
    public boolean insert(SongList songList) {
        return songListMapper.insert(songList)>0;
    }

    @Override
    public boolean update(SongList songList) {
        return songListMapper.update(songList)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return  songListMapper.delete(id)>0;
    }

    @Override
    public SongList queryById(Integer id) {
        return songListMapper.queryById(id);
    }

    @Override
    public List<SongList> queryAllSongList() {
        return songListMapper.queryAllSongList();
    }

    @Override
    public int getSongListCount() {
        return songListMapper.getSongListCount();
    }

    @Override
    public List<SongList> queryByStyle(String style) {
        return songListMapper.queryByStyle(style);
    }
}
