package com.mg.mybatisplustest.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_user_info")
public class UserInfo implements Serializable {

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 是否删除
     */
    //@TableField(value = "null")
    private Boolean deleted;

    private static final long serialVersionUID = 1L;

    public UserInfo(String name, Integer age, String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }
}