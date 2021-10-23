package com.zh.music;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.util.Comparator;

@SpringBootTest
class MusicWebApplicationTests {
    @Test
    public void test() throws FileNotFoundException {
        char c='张';
        System.out.println(c);
    }
}
