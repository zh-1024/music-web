package com.zh.music.controller;

import com.alibaba.fastjson.JSONObject;
import com.zh.music.bean.Singer;
import com.zh.music.service.SingerService;
import com.zh.music.service.impl.SingerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName SingerController
 * @Date 2021/10/14 16:46
 * @Author zhang hui
 * @Description TODO
 */

@RestController
@RequestMapping("/singer")
public class SingerController {
    @Autowired
    private SingerServiceImpl singerService;
    @PostMapping("/insertSinger")
    public Object insertSinger(Singer singer){
        boolean flag = singerService.insert(singer);
        JSONObject jsonObject = new JSONObject();
        if(flag)
        {
            jsonObject.put("code",1);
            jsonObject.put("message", "插入成功");
            return jsonObject;
        }
        jsonObject.put("code",0);
        jsonObject.put("message", "插入失败");
        return jsonObject;
    }
    @PostMapping("/updateSinger")
    public Object updateSinger(Singer singer){
        System.out.println(singer);
        boolean flag = singerService.update(singer);
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
    @GetMapping("/deleteSinger")
    public Object deleteSinger(Integer id){

        Singer singer1 = singerService.queryById(id);
        String oldImg=singer1.getPicture();
        if(!"/img/singerPic/singer.jpg".equals(oldImg)){
            File file = new File(System.getProperty("user.dir")+ oldImg);
            if(file.exists())
            {
                file.delete();
            }

        }

        System.out.println(id);
        boolean flag = singerService.delete(id);
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
    @GetMapping("/querySingerById")
    public Object querySingerById(Integer id){
        Singer singer = singerService.queryById(id);
        return singer;
    }
    @GetMapping("/queryAllSinger")
    public Object queryAllSinger(){
        List<Singer> singers = singerService.queryAllSinger();
        return singers;
    }
    @GetMapping("/querySingerByName")
    public Object querySingerByName(String name){
        List<Singer> singers = singerService.queryByName("%"+name+"%");
        return singers;
    }
    @GetMapping("/querySingerBySex")
    public Object querySingerBySex(Integer sex){
        List<Singer> singers = singerService.queryBySex(sex);
        return singers;
    }
    @PostMapping("/uploadImg")
    public Object uploadImg(@RequestParam("file") MultipartFile avatorFile,
                            @RequestParam("id") int id) throws IOException {
        Singer singer1 = singerService.queryById(id);
        String oldImg=singer1.getPicture();
        if(!"/img/singerPic/singer.jpg".equals(oldImg)){
            File file = new File(System.getProperty("user.dir")+ oldImg);
            if(file.exists())
            {
                file.delete();
            }
        }
        String filename=System.currentTimeMillis()+avatorFile.getOriginalFilename();
        String filePath= System.getProperty("user.dir")+System.getProperty("file.separator")+"img"
                +System.getProperty("file.separator")+"singerPic";
        JSONObject jsonObject = new JSONObject();
        if(avatorFile.isEmpty())
        {
            jsonObject.put("code",0);
            jsonObject.put("message", "歌曲上传失败");
            return jsonObject;
        }

        File file = new File(filePath+System.getProperty("file.separator")+filename);
        //存储再数据库种的相对文件地址
        String storePath="/img/singerPic/"+filename;
        avatorFile.transferTo(file);
        Singer singer=new Singer();
        singer.setId(id);
        singer.setPicture(storePath);
        boolean update = singerService.update(singer);
        if(update){
            jsonObject.put("code",1);
            jsonObject.put("message", "上传成功");
            return jsonObject;
        }
        jsonObject.put("code",0);
        jsonObject.put("message", "上传失败");
        return jsonObject;
    }
}
