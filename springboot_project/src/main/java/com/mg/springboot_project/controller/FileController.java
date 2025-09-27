package com.mg.springboot_project.controller;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelUtil;
import com.alibaba.excel.EasyExcel;
import com.google.common.net.HttpHeaders;
import com.mg.springboot_project.dto.CityImportErrorResponse;
import com.mg.springboot_project.dto.TestDto;
import com.mg.springboot_project.dto.TestQuest;
import com.mg.springboot_project.service.ExcelReadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author mg
 * @date 2025/9/25
 */
@Slf4j
@RestController
@RequestMapping("/file")
public class FileController {

    private final static String EXCEL_SHEET_NAME = "sheet";

    @Autowired
    private ExcelReadService excelReadService;

    /**
     * 传入集合数据导出excel文件
     *
     * @param request
     * @param response
     */
    @PostMapping("/export")
    public void export(@RequestBody @Validated TestQuest request, HttpServletResponse response) {
        List<TestDto> key = request.getKey();

        try {
            String fileName = StrUtil.format("既有店全部字段", DateUtil.format(new Date(), DatePattern.PURE_DATETIME_PATTERN));
            response.reset();
            response.setContentType(ExcelUtil.XLSX_CONTENT_TYPE);
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + URLEncoder.encode(fileName, CharsetUtil.UTF_8));
            EasyExcel.write(response.getOutputStream(), TestDto.class)
                    .sheet(EXCEL_SHEET_NAME)
                    .doWrite(key);

        } catch (Exception e) {
            log.error("FileController.export 导出异常", e);
        }

    }

    @PostMapping("/upload")
    public List<CityImportErrorResponse> uploadExcel(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return Collections.emptyList();
        }

        List<CityImportErrorResponse> list = null;
        try {
            list = excelReadService.readExcelFile(file);
        } catch (Exception e) {
            log.error("FileController.uploadExcel 导入解析excel文件异常", e);
        }

        return list;
    }

}
