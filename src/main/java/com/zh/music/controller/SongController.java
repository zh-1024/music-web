package com.zh.music.controller;

import com.alibaba.fastjson.JSONObject;
import com.zh.music.bean.Song;
import com.zh.music.service.impl.SongServiceImpl;
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
    @GetMapping("/getSongBySongId")
    public Object getSongBySongId(Integer songId){
        System.out.println(songId);
        return songService.queryById(songId);
    }
    @GetMapping("/getSongBySingerId")
    public Object getSongBySingerId(Integer singerId){
        return songService.queryBySingerId(singerId);
    }
    @GetMapping("/getSongBySongName")
    public Object getSongBySongName(String songName){
        return songService.queryByName(songName);
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
    @PostMapping("/uploadImg")
    public Object uploadImg(@RequestParam("file") MultipartFile picFile,
                            @RequestParam("id") int id) throws IOException {
        Song song = songService.queryById(id);
        String pic = song.getPic();
        if(!"/img/songPic/music-logo.jpg".equals(pic)){
            File file = new File(System.getProperty("user.dir")+ pic);
            if(file.exists())
            {
                file.delete();
            }
        }
        String filename=System.currentTimeMillis()+picFile.getOriginalFilename();
        String filePath= System.getProperty("user.dir")+System.getProperty("file.separator")+"img"
                +System.getProperty("file.separator")+"songPic";
        JSONObject jsonObject = new JSONObject();
        if(picFile.isEmpty())
        {
            jsonObject.put("code",0);
            jsonObject.put("message", "图片上传失败");
            return jsonObject;
        }

        File file = new File(filePath+System.getProperty("file.separator")+filename);
        //存储再数据库种的相对文件地址
        String storePath="/img/songPic/"+filename;
        picFile.transferTo(file);
        Song song1 = new Song();
        song1.setId(id);
        song1.setPic(storePath);
        boolean update = songService.update(song1);
        if(update){
            jsonObject.put("code",1);
            jsonObject.put("message", "上传成功");
            return jsonObject;
        }
        jsonObject.put("code",0);
        jsonObject.put("message", "上传失败");
        return jsonObject;
    }
    @PostMapping("/uploadSongFile")
    public Object uploadSongFile(@RequestParam("file") MultipartFile SongFile,
                            @RequestParam("id") int id) throws IOException {
        Song song = songService.queryById(id);
        String url = song.getUrl();

        File file = new File(System.getProperty("user.dir")+ url);
        if(file.exists())
        {
           file.delete();
         }
        String filename=System.currentTimeMillis()+SongFile.getOriginalFilename();
        String filePath= System.getProperty("user.dir")+System.getProperty("file.separator")+"song";
        JSONObject jsonObject = new JSONObject();
        if(SongFile.isEmpty())
        {
            jsonObject.put("code",0);
            jsonObject.put("message", "图片上传失败");
            return jsonObject;
        }

        File file1 = new File(filePath+System.getProperty("file.separator")+filename);
        //存储在数据库中的相对文件地址
        String storePath="/song/"+filename;
        SongFile.transferTo(file1);
        Song song1 = new Song();
        song1.setId(id);
        song1.setUrl(storePath);
        boolean update = songService.update(song1);
        if(update){
            jsonObject.put("code",1);
            jsonObject.put("message", "上传成功");
            return jsonObject;
        }
        jsonObject.put("code",0);
        jsonObject.put("message", "上传失败");
        return jsonObject;
    }
    @GetMapping("/getSongCount")
    public Object getSongCount(){
        return songService.getSongCount();
    }

}
