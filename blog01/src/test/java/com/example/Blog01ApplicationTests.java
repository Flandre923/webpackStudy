package com.example;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.pojo.Blog;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Blog01ApplicationTests {

    @Test
    void contextLoads() {
        QueryWrapper<Blog> wrapper = new QueryWrapper<>();
    }

}
