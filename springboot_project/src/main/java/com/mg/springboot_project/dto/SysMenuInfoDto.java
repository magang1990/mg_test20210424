package com.mg.springboot_project.dto;

import lombok.Data;

import java.util.List;

/**
 * @author mg
 * @date 2023-07-14
 */
@Data
public class SysMenuInfoDto {

    /**
     * 菜单编码
     */
    private String menuCode;

    /**
     * 菜单简称
     */
    private String shortMenuName;

    /**
     * 父级节点编码
     */
    private String parentMenuCode;

    /**
     * 菜单级别：1-一级菜单;2-二级菜单;3-三级菜单
     */
    private Integer levelType;

    private List<SysMenuInfoDto> childList;

}
