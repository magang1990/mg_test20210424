package com.mg.springboot_project;

import com.mg.springboot_project.dao.SysMenuInfoMapper;
import com.mg.springboot_project.dto.SysMenuInfoDto;
import com.mg.springboot_project.entity.SysMenuInfo;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mg
 * @date 2023-07-14
 */
@SpringBootTest
public class SysMenuInfoTest {

    @Autowired
    SysMenuInfoMapper sysMenuInfoMapper;

    @Test
    public void run(){
        List<SysMenuInfo> allMenuList = sysMenuInfoMapper.getAllMenuList();
        List<SysMenuInfoDto> list = new ArrayList<>();

        for (SysMenuInfo sysMenuInfo : allMenuList) {
            if (sysMenuInfo.getLevelType()==1) {
                SysMenuInfoDto dto = new SysMenuInfoDto();
                dto.setMenuCode(sysMenuInfo.getMenuCode());
                dto.setParentMenuCode(sysMenuInfo.getParentMenuCode());
                dto.setShortMenuName(sysMenuInfo.getShortMenuName());
                dto.setLevelType(sysMenuInfo.getLevelType());
                list.add(dto);
            }
        }

        for (SysMenuInfoDto dto : list) {
            dto.setChildList(this.digui(dto.getMenuCode(),allMenuList));
        }
    }

    private List<SysMenuInfoDto> digui(String menuCode, List<SysMenuInfo> allMenuList) {
        List<SysMenuInfoDto> childList = new ArrayList<>();
        for (SysMenuInfo info : allMenuList) {
            if(menuCode.equals(info.getParentMenuCode())){
                SysMenuInfoDto dto = new SysMenuInfoDto();
                dto.setMenuCode(info.getMenuCode());
                dto.setParentMenuCode(info.getParentMenuCode());
                dto.setShortMenuName(info.getShortMenuName());
                dto.setLevelType(info.getLevelType());
                childList.add(dto);
            }
        }

        for (SysMenuInfoDto dto : childList) {
            dto.setChildList(digui(dto.getMenuCode(),allMenuList));
        }

        if (CollectionUtils.isEmpty(childList)) {
            return null;
        }

        return childList;
    }
}
