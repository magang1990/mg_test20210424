package com.mg.springboot_project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 国家信息表实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CountyInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 人数(万人)
     */
    private BigDecimal peopleNumber;

    /**
     * 国家收入状态 0，低收入；1，中等收入；2，高收入
     */
    private Integer status;

    /**
     * GDP排名
     */
    private Integer gdpRank;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后更新人
     */
    private String updateBy;

    /**
     * 最后更新时间
     */
    private Date updateTime;

    /**
     * 是否删除 0，否 1，是
     */
    private Integer deleted;

}