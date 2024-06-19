package com.mg.mybatisplustest.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mg
 * @date 2023-08-20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private String age;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 是否删除
     */
    private String deleted;

}
