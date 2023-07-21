package com.mg.springboot_project.dao;

import com.mg.springboot_project.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StudentMapper {
    int deleteByPrimaryKey(Long code);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long code);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}