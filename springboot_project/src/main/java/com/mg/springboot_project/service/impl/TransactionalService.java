package com.mg.springboot_project.service.impl;

import com.mg.springboot_project.dao.StudentMapper;
import com.mg.springboot_project.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author mg
 * @date 2023-06-30
 */
@Service
public class TransactionalService {

    @Autowired
    StudentMapper studentMapper;

    @Transactional(rollbackFor = Throwable.class)
    public void saveStudent() {
        studentMapper.insert(new Student(3L, "mc", 2));
        int i = 1 / 0;
    }

}
