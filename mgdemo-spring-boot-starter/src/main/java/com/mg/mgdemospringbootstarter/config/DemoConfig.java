package com.mg.mgdemospringbootstarter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author mg
 * @date 2023-06-19
 */
@ConfigurationProperties(prefix = "mg.demo")
public class DemoConfig {

    private String name;

    private Integer age;

    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
