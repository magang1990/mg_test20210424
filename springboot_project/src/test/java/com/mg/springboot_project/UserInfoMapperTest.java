package com.mg.springboot_project;

import cn.hutool.core.collection.CollectionUtil;
import com.mg.springboot_project.dao.UserInfoMapper;
import com.mg.springboot_project.entity.UserInfo;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author mg
 * @date 2024-08-02
 */
@SpringBootTest
public class UserInfoMapperTest {

    @Autowired
    UserInfoMapper userInfoMapper;

    private static final Logger logger = LoggerFactory.getLogger(UserInfoMapperTest.class);

    @Test
    public void run() {
        // "unknown"代表空串''或者null值
        List<UserInfo> userInfoList = userInfoMapper.selectByEmailList(CollectionUtil.newArrayList("110@qq.com", "unknown"));
    }
}
