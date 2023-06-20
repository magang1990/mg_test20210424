package com.mg.mgdemospringbootstarter.service;

/**
 * @author mg
 * @date 2023-06-19
 */
public class MgDemoService {

    private String name;

    private Integer age;

    private String phone;

    public MgDemoService(String name, Integer age, String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public MgDemoService() {
    }

    public String getAllMessage() {
        return "name=" + name + " age=" + age + " phone=" + phone;
    }

}
