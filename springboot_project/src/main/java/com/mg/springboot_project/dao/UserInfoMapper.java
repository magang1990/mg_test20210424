package com.mg.springboot_project.dao;

import com.mg.springboot_project.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    /**
     * 解决集合in语句不能查询null的问题
     *
     * @param list
     * @return
     */
    List<UserInfo> selectByEmailList(@Param("list")List<String> list);

    UserInfo selectByName(String userAccount);

}