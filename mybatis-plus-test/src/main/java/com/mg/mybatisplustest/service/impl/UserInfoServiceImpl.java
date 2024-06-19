package com.mg.mybatisplustest.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mg.mybatisplustest.dao.UserInfoMapper;
import com.mg.mybatisplustest.entity.UserInfo;
import com.mg.mybatisplustest.service.UserInfoService;
import org.springframework.stereotype.Service;

/**
 * @author mg
 * @date 2023-08-19
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {


}
