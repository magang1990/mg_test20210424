package com.mg.springboot_project;

import com.mg.springboot_project.dao.StudentMapper;
import com.mg.springboot_project.entity.Student;
import com.mg.springboot_project.service.impl.TransactionalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author mg
 * @date 2023-06-30
 */
@SpringBootTest
public class TransactionalTest {

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    TransactionalService transactionalService;

    @Test
    @Transactional(propagation = Propagation.MANDATORY, rollbackFor = Throwable.class)
    public void run(){
        studentMapper.deleteByPrimaryKey(168L);
        Student student = studentMapper.selectByPrimaryKey(168L);
        transactionalService.saveStudent();
    }

    @Test
    @Transactional(rollbackFor = Throwable.class)
    public void run2() throws InterruptedException {
        studentMapper.deleteByPrimaryKey(168L);
        Thread.sleep(20000);
        studentMapper.insert(new Student(3L, "mc", 2));
    }

    @Test
    @Transactional(rollbackFor = Throwable.class)
    public void run3(){
        studentMapper.deleteByPrimaryKey(168L);
        studentMapper.insert(new Student(3L, "mc", 2));
    }

}
