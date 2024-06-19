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

    @Transactional(rollbackFor = Throwable.class)
    public void save1(Long id) {
        //studentMapper.deleteByPrimaryKey(id);
        int num = studentMapper.deleteByPrimaryKey(id);
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*if (num==0) {
            throw new RuntimeException("请重新刷新");
        }*/
        studentMapper.insertSelective(new Student("mc", 2));
    }

}
