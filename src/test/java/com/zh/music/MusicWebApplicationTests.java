package com.zh.music;

import com.zh.music.bean.Song;
import com.zh.music.service.impl.SongServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;

@SpringBootTest
class MusicWebApplicationTests {
    @Autowired
    SongServiceImpl songService;
    @Test
    public void test() throws FileNotFoundException {
        List<Song> songs = songService.queryBySingerId(1);
        System.out.println(songs);
    }
}
