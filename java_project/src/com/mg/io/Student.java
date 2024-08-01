package com.mg.io;

import java.io.Serializable;

/**
 * @author mg
 * @date 2024-07-12
 */
public class Student implements Serializable {

    private static final long serialVersionUID = -5401152417645129120L;

    public String sname;
    public Integer sage;
    public static Integer stuNo;
    public transient Character sex;

    public Student() {
    }

    public Student(String sname, Integer sage) {
        this.sname = sname;
        this.sage = sage;
    }
}
