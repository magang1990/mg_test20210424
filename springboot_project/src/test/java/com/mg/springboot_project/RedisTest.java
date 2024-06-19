package com.mg.springboot_project;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * @author mg
 * @date 2023-08-02
 */
@SpringBootTest
public class RedisTest {

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    public void run(){
       /* redisTemplate.opsForValue().set();
        redisTemplate.opsForValue().setIfPresent();
        redisTemplate.expireAt()*/
    }
}
