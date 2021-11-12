package com.zh.music.controller;

import com.alibaba.fastjson.JSONObject;
import com.zh.music.bean.Singer;
import com.zh.music.bean.Song;
import com.zh.music.service.impl.SongServiceImpl;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/song")
public class SongController {
    @Autowired
    private SongServiceImpl songService;

    @PostMapping("/insertSong")
    public Object insertSong(Song song,
                             @RequestParam("file") MultipartFile mpFile) {
        System.out.println(song);
        //设置默认歌曲图片
        song.setPic("/img/songPic/music-logo.jpg");
        JSONObject jsonObject = new JSONObject();
        //上传歌曲文件
        if(mpFile.isEmpty()){
            jsonObject.put("code",0);
            jsonObject.put("message","上传文件失败");
            return jsonObject;
        }
        String  filename=System.currentTimeMillis()+mpFile.getOriginalFilename();
        String filePath=System.getProperty("user.dir")+System.getProperty("file.separator")+"song"
                +System.getProperty("file.separator");
        File file = new File(filePath + filename);
        String storeName="/song/"+filename;

        try {
            mpFile.transferTo(file);
            song.setUrl(storeName);
            System.out.println(song);
            boolean insert = songService.insert(song);
            if (insert) {
                jsonObject.put("code", 1);
                jsonObject.put("message", "歌曲添加成功");
                jsonObject.put("url",storeName);
                return jsonObject;
            }
            jsonObject.put("code", 0);
            jsonObject.put("message", "歌曲添加失败");
            return jsonObject;
        } catch (IOException e) {
            jsonObject.put("code", 0);
            jsonObject.put("message","歌曲添加失败"+ e.getMessage());

        } finally {
            return jsonObject;
        }
    }
    @GetMapping("/getSongBySingerId")
    public Object getSongBySingerId(Integer singerId){
        System.out.println(singerId);
        return songService.queryBySingerId(singerId);
    }
    @PostMapping("/updateSong")
    public Object updateSong(Song song){
        boolean flag = songService.update(song);
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

    @GetMapping("/deleteSong")
    public Object deleteSong(Integer id){
        boolean flag = songService.delete(id);
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
}
