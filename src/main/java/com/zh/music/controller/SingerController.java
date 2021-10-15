package com.zh.music.controller;

import com.alibaba.fastjson.JSONObject;
import com.zh.music.bean.Singer;
import com.zh.music.service.SingerService;
import com.zh.music.service.impl.SingerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        System.out.println(singer);
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
    @GetMapping("/updateSinger")
    public Object updateSinger(Singer singer){
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

}
