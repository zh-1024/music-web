package com.zh.music.service.impl;

import com.zh.music.bean.ListSong;
import com.zh.music.dao.ListSongMapper;
import com.zh.music.service.ListSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListSongServiceImpl implements ListSongService {
    @Autowired
    ListSongMapper listSongMapper;

    @Override
    public boolean insert(ListSong listSong) {
        return listSongMapper.insert(listSong)>0;
    }

    @Override
    public boolean update(ListSong listSong) {
        return listSongMapper.update(listSong)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return listSongMapper.delete(id)>0;
    }

    @Override
    public boolean deleteBySongIdAndSongListID(Integer songId, Integer songListId) {
        return listSongMapper.deleteBySongIdAndSongListID(songId,songListId)>0;
    }

    @Override
    public ListSong queryById(Integer id) {
        return listSongMapper.queryById(id);
    }

    @Override
    public List<ListSong> queryAllListSong() {
        return listSongMapper.queryAllListSong();
    }

    @Override
    public List<ListSong> queryBySongListId(Integer id) {
        return listSongMapper.queryBySongListId(id);
    }
}
