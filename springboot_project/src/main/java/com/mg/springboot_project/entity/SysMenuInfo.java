package com.mg.springboot_project.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 菜单信息表实体类
 *
 * @author 01391642
 * @date 2021-08-01
 */
@Data
public class SysMenuInfo implements Serializable {
    private static final long serialVersionUID = 693625958785173564L;
        
    /**
     * 主键
     */
    private Long id;
        
    /**
     * 菜单编码
     */
    private String menuCode;
        
    /**
     * 菜单简称
     */
    private String shortMenuName;
        
    /**
     * 菜单全路径名称
     */
    private String fullMenuName;
        
    /**
     * 菜单状态:0-无效;1-有效
     */
    private Integer menuStatus;
        
    /**
     * 菜单级别：1-一级菜单;2-二级菜单;3-三级菜单
     */
    private Integer levelType;
        
    /**
     * 菜单类型：0-PC端；1-小程序
     */
    private Integer menuType;
        
    /**
     * 父级节点编码
     */
    private String parentMenuCode;
        
    /**
     * 创建时间
     */
    private Date createTime;
        
    /**
     * 创建人账号
     */
    private String creator;
        
    /**
     * 更新时间
     */
    private Date updateTime;
        
    /**
     * 更新人账号
     */
    private String updator;


}