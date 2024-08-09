package com.mg.springboot_project.service;

import com.mg.springboot_project.entity.UserInfo;

/**
 * @author mg
 * @date 2024-08-08
 */
public interface UserInfoService {

    UserInfo getUserInfoByAccount(String userAccount);

}
