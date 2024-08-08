package com.mg.springboot_project.dao;

import com.mg.springboot_project.entity.CountyInfo;
import com.mg.springboot_project.response.CountyInfoStatusCount;
import com.mg.springboot_project.response.CountyInfoStatusStatistics;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CountyInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CountyInfo record);

    int insertSelective(CountyInfo record);

    CountyInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CountyInfo record);

    int updateByPrimaryKey(CountyInfo record);

    void insertBatchSize(@Param("list") List<CountyInfo> countyInfos);

    List<CountyInfoStatusStatistics> countyInfoStatusStatistics();

    CountyInfoStatusCount countyInfoStatusCount();

}