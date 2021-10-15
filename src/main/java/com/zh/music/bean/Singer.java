package com.zh.music.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.security.Principal;
import java.util.Date;

/**
 * @ClassName Singer
 * @Date 2021/10/14 16:21
 * @Author zhang hui
 * @Description TODO
 */

@Data
@ToString
public class Singer {
    private Integer id;
    private String name;
    private Byte sex;
    private String picture;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date   birth;
    private String location;
    private String introduction;
}
