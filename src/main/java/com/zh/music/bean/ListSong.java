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
public class ListSong implements Serializable {
    private Integer id;
    private Integer songId;
    private Integer songListId;
}
