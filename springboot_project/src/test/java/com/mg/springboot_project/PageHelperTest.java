package com.mg.springboot_project;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mg.springboot_project.dao.StudentMapper;
import com.mg.springboot_project.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

/**
 * @author mg
 * @date 2023-08-13
 */
@SpringBootTest
public class PageHelperTest {

    @Autowired
    StudentMapper studentMapper;

    /**
     * PageHelper.startPage和需要分页的查询语句之间不可以有其他select查询语句，不然就给第一个查询语句分页了
     * 可以有其他非查询代码
     *
     * PageHelper.startPage给分页的查询代码不可以含有limit，不然sql会拼接两个limit
     */
    @Test
    public void run() {
        PageHelper.startPage(1,5).setOrderBy("code");
        String s = "niubi";

        List<Student> list= studentMapper.selectAll();
        String s2 = "niubi2";
        List<Student> list0= studentMapper.queryByCodes(Collections.singletonList(1L));

        PageInfo<Student> pageInfo = new PageInfo<>(list);

    }

}
