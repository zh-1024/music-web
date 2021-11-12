package com.zh.music.service.impl;

import com.zh.music.bean.Song;
import com.zh.music.dao.SongMapper;
import com.zh.music.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SongServiceImpl implements SongService {
    @Autowired
    private SongMapper songMapper;

    @Override
    public boolean insert(Song song) {
        return songMapper.insert(song)>0;
    }

    @Override
    public boolean update(Song song) {
        return songMapper.update(song)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return songMapper.delete(id)>0;
    }

    @Override
    public Song queryById(Integer id) {
        return songMapper.queryById(id);
    }

    @Override
    public List<Song> queryAllSong() {
        return songMapper.queryAllSong();
    }

    @Override
    public List<Song> queryByName(String name) {
        return songMapper.queryByName(name);
    }

    @Override
    public List<Song> queryBySingerId(Integer singerId) {
        return songMapper.queryBySingerId(singerId);
    }
}
