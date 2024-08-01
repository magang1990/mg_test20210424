package com.mg.springboot_project;

import com.mg.springboot_project.dao.StudentMapper;
import com.mg.springboot_project.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

/**
 * @author mg
 * @date 2023-09-06
 */
@SpringBootTest
public class BatchUpdateTest {

    @Autowired
    StudentMapper studentMapper;

    @Test
    public void run() {
        List<Student> list= studentMapper.selectAll();
        for (Student student : list) {
            student.setAge(student.getAge()+1);
        }

        studentMapper.batchUpdateStudent(list);

    }

    /**
     * 单个参数（简单数据类型，对象，集合）可以不加@Param
     */
    @Test
    public void queryByCodes() {
        List<Student> list= studentMapper.queryByCodes(Collections.singletonList(1L));
    }

    /**
     * mybatis3.4.2之前，mapper传多参数。①加@Param注解；②xml中取值#{0}，#{1}或#{param1}，#{param2}
     * 从3.4.2开始，mapper传多参数。①加@Param注解；②xml中取值直接#{参数名}或#{param1}，#{param2}
     */
    @Test
    public void query() {
        //List<Student> list= studentMapper.queryStudent(2L, "mg", 35);
        List<Student> list2= studentMapper.query2(1L, "mg", Collections.singletonList(35L));

    }

}
