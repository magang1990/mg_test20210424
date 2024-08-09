package com.mg.springboot_project.service.impl;

import com.mg.springboot_project.dao.UserInfoMapper;
import com.mg.springboot_project.entity.UserInfo;
import com.mg.springboot_project.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mg
 * @date 2024-08-08
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;


    @Override
    public UserInfo getUserInfoByAccount(String userAccount) {
        return userInfoMapper.selectByName(userAccount);
    }
}
