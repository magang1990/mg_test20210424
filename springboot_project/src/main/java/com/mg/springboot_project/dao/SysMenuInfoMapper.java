package com.mg.springboot_project.dao;

import com.mg.springboot_project.entity.SysMenuInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 菜单信息mapper接口层
 *
 * @author 01391642
 * @date 2021/7/7
 */
@Mapper
@Repository
public interface SysMenuInfoMapper {

    /**
     * 获取所有的功能菜单信息
     *
     * @return
     */
    List<SysMenuInfo> getAllMenuList();

}
