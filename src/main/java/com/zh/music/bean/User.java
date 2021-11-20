package com.zh.music.bean;

import com.sun.xml.internal.ws.spi.db.DatabindingException;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;
    private Byte sex;
    private String phoneNum;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date   birth;
    private String introduction;
    private String location;
    private String avatar;
    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    //更新时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;
    private Integer forbidden;
}
