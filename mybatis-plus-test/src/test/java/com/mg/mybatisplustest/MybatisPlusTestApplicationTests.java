package com.mg.mybatisplustest;

import com.mg.mybatisplustest.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisPlusTestApplicationTests {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    void contextLoads() {
        //userInfoService.saveBatch()
    }

}
