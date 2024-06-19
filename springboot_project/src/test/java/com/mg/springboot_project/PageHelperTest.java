package com.mg.springboot_project;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mg.springboot_project.dao.StudentMapper;
import com.mg.springboot_project.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author mg
 * @date 2023-08-13
 */
@SpringBootTest
public class PageHelperTest {

    @Autowired
    StudentMapper studentMapper;

    @Test
    public void run() {
        PageHelper.startPage(1,5).setOrderBy("code");
        List<Student> list= studentMapper.selectAll();
        PageInfo<Student> pageInfo = new PageInfo<>(list);

    }

}
