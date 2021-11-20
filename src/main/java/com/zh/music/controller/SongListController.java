package com.zh.music.controller;

import com.alibaba.fastjson.JSONObject;
import com.zh.music.bean.Singer;
import com.zh.music.bean.SongList;
import com.zh.music.service.impl.SingerServiceImpl;
import com.zh.music.service.impl.SongListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName SingerController
 * @Date 2021/10/14 16:46
 * @Author zhang hui
 * @Description TODO
 */

@RestController
@RequestMapping("/songList")
public class SongListController {
    @Autowired
    private SongListServiceImpl songListService;
    @PostMapping("/insertSongList")
    public Object insertSongList(SongList songList){
        boolean flag = songListService.insert(songList);
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
    @PostMapping("/updateSongList")
    public Object updateSongList(SongList songList){
        boolean flag = songListService.update(songList);
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
    @GetMapping("/deleteSongList")
    public Object deleteSongList(Integer id){

        SongList songList = songListService.queryById(id);
        String oldImg=songList.getPic();
        if(!"/img/songListPic/songList-logo.jpg".equals(oldImg)){
            File file = new File(System.getProperty("user.dir")+ oldImg);
            if(file.exists())
            {
                file.delete();
            }

        }
        boolean flag = songListService.delete(id);
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
    @GetMapping("/querySongListById")
    public Object querySongListById(Integer id){
        SongList songList = songListService.queryById(id);
        return songList;
    }
    @GetMapping("/queryAllSongList")
    public Object queryAllSongList(){
        List<SongList> songLists = songListService.queryAllSongList();
        return songLists;
    }
    @GetMapping("/querySongListByStyle")
    public Object querySongListByStyle(String style){
        List<SongList> songLists = songListService.queryByStyle(style);
        return songLists;
    }

    @PostMapping("/uploadImg")
    public Object uploadImg(@RequestParam("file") MultipartFile avatorFile,
                            @RequestParam("id") int id) throws IOException {
        SongList songList = songListService.queryById(id);
        String oldImg=songList.getPic();
        if(!"/img/songListPic/songList-logo.jpg".equals(oldImg)){
            File file = new File(System.getProperty("user.dir")+ oldImg);
            if(file.exists())
            {
                file.delete();
            }
        }
        String filename=System.currentTimeMillis()+avatorFile.getOriginalFilename();
        String filePath= System.getProperty("user.dir")+System.getProperty("file.separator")+"img"
                +System.getProperty("file.separator")+"songListPic";
        JSONObject jsonObject = new JSONObject();
        if(avatorFile.isEmpty())
        {
            jsonObject.put("code",0);
            jsonObject.put("message", "图片上传失败");
            return jsonObject;
        }

        File file = new File(filePath+System.getProperty("file.separator")+filename);
        //存储再数据库种的相对文件地址
        String storePath="/img/songListPic/"+filename;
        avatorFile.transferTo(file);
        SongList songList1 = new SongList();
        songList1.setId(id);
        songList1.setPic(storePath);
        boolean update = songListService.update(songList1);
        if(update){
            jsonObject.put("code",1);
            jsonObject.put("message", "上传成功");
            return jsonObject;
        }
        jsonObject.put("code",0);
        jsonObject.put("message", "上传失败");
        return jsonObject;
    }
    @GetMapping("/getSongListCount")
    public Object getSongCount(){
        return songListService.getSongListCount();
    }
}
