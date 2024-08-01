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

    /**
     * 单个参数（简单数据类型，对象，集合）可以不加@Param
     *
     * @param list 参数集合
     * @return 集合
     */
    List<Student> queryByCodes(List<Long> list);

    /**
     * 从mybatis3.4.2开始，多个单属性参数可以不加@Param
     *
     * @param code
     * @param name
     * @return
     */
    List<Student> queryStudent(Long code, String name, Integer age);

    List<Student> query2(Long code, String name, List<Long> list);

}