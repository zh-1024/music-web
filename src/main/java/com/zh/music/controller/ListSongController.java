package com.zh.music.controller;

import com.alibaba.fastjson.JSONObject;
import com.zh.music.bean.ListSong;
import com.zh.music.service.impl.ListSongServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @ClassName SingerController
 * @Date 2021/10/14 16:46
 * @Author zhang hui
 * @Description TODO
 */

@RestController
@RequestMapping("/listSong")
public class ListSongController {
    @Autowired
    private ListSongServiceImpl listSongService;
    @PostMapping("/insertListSong")
    public Object insertListSong(ListSong listSong){
        boolean flag = listSongService.insert(listSong);
        JSONObject jsonObject = new JSONObject();
        if(flag)
        {
            jsonObject.put("code",1);
            jsonObject.put("message", "添加成功");
            return jsonObject;
        }
        jsonObject.put("code",0);
        jsonObject.put("message", "添加失败");
        return jsonObject;
    }
    @PostMapping("/updateListSong")
    public Object updateListSong(ListSong listSong){
        boolean flag = listSongService.update(listSong);
        JSONObject jsonObject = new JSONObject();
        if(flag)
        {
            jsonObject.put("code",1);
            jsonObject.put("message", "修改成功");
            return jsonObject;
        }
        jsonObject.put("code",0);
        jsonObject.put("message", "修改失败");

        return jsonObject;
    }
    @GetMapping("/deleteListSong")
    public Object deleteListSong(Integer songId,Integer songListId){
        boolean flag = listSongService.deleteBySongIdAndSongListID(songId, songListId);
        JSONObject jsonObject = new JSONObject();
        if(flag)
        {
            jsonObject.put("code",1);
            jsonObject.put("message", "删除成功");
            return jsonObject;
        }
        jsonObject.put("code",0);
        jsonObject.put("message", "删除失败");

        return jsonObject;
    }
    @GetMapping("/queryById")
    public Object queryById(Integer id){
        ListSong listSong = listSongService.queryById(id);
        return listSong;
    }
    @GetMapping("/queryListSongById")
    public Object queryListSongById(Integer songListId){
        List<ListSong> listSongs = listSongService.queryBySongListId(songListId);
        return listSongs;
    }
}
