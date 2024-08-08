package com.mg.springboot_project.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.mg.springboot_project.dao.CountyInfoMapper;
import com.mg.springboot_project.entity.CountyInfo;
import com.mg.springboot_project.service.CountyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mg
 * @date 2024-08-06
 */
@Service
public class CountyInfoServiceImpl implements CountyInfoService {

    @Autowired
    private CountyInfoMapper countyInfoMapper;

    @Override
    public void insertBatch(List<CountyInfo> countyInfos) {
        if (CollectionUtil.isEmpty(countyInfos)) {
            return;
        }

        // 数据库每500条插入一次
        List<List<CountyInfo>> split = CollectionUtil.split(countyInfos, 500);
        //List<List<CountyInfo>> partition = Lists.partition(countyInfos, 500);

        split.forEach(list -> countyInfoMapper.insertBatchSize(list));
    }

}
