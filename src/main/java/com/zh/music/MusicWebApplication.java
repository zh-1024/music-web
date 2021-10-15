package com.zh.music;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.zh.music")
@SpringBootApplication
public class MusicWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicWebApplication.class, args);
	}

}
