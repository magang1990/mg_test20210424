package com.mg.springboot_project.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.excel.EasyExcel;
import com.mg.springboot_project.dto.CityImportErrorResponse;
import com.mg.springboot_project.service.ExcelReadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author mg
 * @date 2025/9/25
 */
@Service
public class ExcelReadServiceImpl implements ExcelReadService {

    /**
     * 读取Excel文件
     */
    public List<CityImportErrorResponse> readExcelFile(MultipartFile file) {
        CityDataImportListener listener = new CityDataImportListener(CollectionUtil.newArrayList("城市名称"));
        try {
            EasyExcel.read(file.getInputStream(), CityImportErrorResponse.class, listener)
                    .sheet()
                    .doRead();
        } catch (IOException e) {
            throw new RuntimeException("读取Excel文件失败", e);
        }
        return listener.getErrList();
    }

    /**
     * 读取指定路径的Excel文件
     */
    public List<CityImportErrorResponse> readExcelFile(String filePath) {
        CityDataImportListener listener = new CityDataImportListener(CollectionUtil.newArrayList("城市名称"));
        EasyExcel.read(filePath, CityImportErrorResponse.class, listener)
                .sheet()
                .doRead();
        return listener.getErrList();
    }
}
