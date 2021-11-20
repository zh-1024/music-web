package com.zh.music.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class Song implements Serializable {
    private Integer id;
    //歌曲Id
    private Integer singerId;
    //歌名
    private String name;
    //歌曲简介
    private String introduction;
    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    //更新时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;
    //歌曲图片
    private String pic;
    //歌词
    private String lyric;
    //歌曲地址
    private String url;

}
