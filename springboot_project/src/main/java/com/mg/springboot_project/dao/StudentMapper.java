package com.mg.springboot_project.dao;

import com.mg.springboot_project.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {
    int deleteByPrimaryKey(Long code);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long code);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> selectAll();

    void batchUpdateStudent(@Param("list") List<Student> list);

}