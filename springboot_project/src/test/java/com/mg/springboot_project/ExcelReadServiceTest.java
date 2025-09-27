package com.mg.springboot_project;

import com.mg.springboot_project.dto.CityImportErrorResponse;
import com.mg.springboot_project.service.ExcelReadService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author mg
 * @date 2025/9/26
 */
@SpringBootTest
public class ExcelReadServiceTest {

    @Autowired
    private ExcelReadService excelReadService;

    @Test
    public void testReadExcel() {
        String filePath = "/Users/magang/Downloads/1.xlsx";
        List<CityImportErrorResponse> list = excelReadService.readExcelFile(filePath);
    }
}
