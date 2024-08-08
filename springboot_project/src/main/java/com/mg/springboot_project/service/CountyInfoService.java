package com.mg.springboot_project.service;

import com.mg.springboot_project.entity.CountyInfo;

import java.util.List;

/**
 * @author mg
 * @date 2024-08-06
 */
public interface CountyInfoService {

    /**
     * 批量添加
     *
     * @param countyInfos
     */
    void insertBatch(List<CountyInfo> countyInfos);

}
