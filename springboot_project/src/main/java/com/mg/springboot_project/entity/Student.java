package com.mg.springboot_project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {
    /**
     * 
     */
    private Long code;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    private static final long serialVersionUID = 1L;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}