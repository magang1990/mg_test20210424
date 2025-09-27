package com.mg.springboot_project.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;

/**
 * @author gang.ma2.o
 * @date 2023/11/22
 */
@Data
public class TestDto {

    @ColumnWidth(20)
    @ExcelProperty(value = "key", order = 1)
    private String id;

    @ColumnWidth(20)
    @ExcelProperty(value = "名称", order = 2)
    private String name;

}
