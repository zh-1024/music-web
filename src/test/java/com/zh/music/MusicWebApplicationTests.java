package com.zh.music;

import com.zh.music.bean.Song;
import com.zh.music.bean.SongList;
import com.zh.music.bean.User;
import com.zh.music.service.UserService;
import com.zh.music.service.impl.SongListServiceImpl;
import com.zh.music.service.impl.SongServiceImpl;
import com.zh.music.service.impl.UserServiceImpl;
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
    @Autowired
    SongListServiceImpl songListService;
    @Autowired
    UserServiceImpl userService;
    @Test
    public void test() throws FileNotFoundException {
        System.out.println(songService.getSongCount());
    }
    @Test
    public void testInsert(){
        System.out.println(songListService.queryByStyle("test1"));
    }

}
