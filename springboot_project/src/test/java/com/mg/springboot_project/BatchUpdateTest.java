package com.mg.springboot_project;

import com.mg.springboot_project.dao.StudentMapper;
import com.mg.springboot_project.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

}
