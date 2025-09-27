package com.mg.springboot_project.service;

import com.mg.springboot_project.dto.CityImportErrorResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author mg
 * @date 2025/9/25
 */
public interface ExcelReadService {

    List<CityImportErrorResponse> readExcelFile(MultipartFile file);

    List<CityImportErrorResponse> readExcelFile(String filePath);

}
