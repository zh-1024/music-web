package com.zh.music.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SongList  implements Serializable {
    private Integer id;
    private String title;
    private String pic;
    private String introduction;
    private String style;
}
