package com.mg.mybatisplustest.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mg.mybatisplustest.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserInfoMapper extends BaseMapper<UserInfo> {

}