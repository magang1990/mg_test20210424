package com.mg.springboot_project.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gang.ma2.o
 * @date 2023/8/30
 */
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CityImportErrorResponse {

    /**
     * 城市编码
     */
    @ColumnWidth(20)
    @ExcelProperty(value = "城市编码")
    private  String cityCode;
    
    /**
     * 城市名称 text
     */
    @ColumnWidth(20)
    @ExcelProperty(value = "城市名称")
    private  String name;

    /**
     * 城市等级
     */
    @ColumnWidth(10)
    @ExcelProperty(value = "城市等级")
    private  String cityLevel;

    /**
     * 城市优先级
     */
    @ColumnWidth(10)
    @ExcelProperty(value = "城市优先级")
    private  String cityPriority;

    /**
     * 常住人口
     */
    @ColumnWidth(10)
    @ExcelProperty(value = "常住人口（万人）")
    private String residentPopulation;

    /**
     * GDP
     */
    @ColumnWidth(10)
    @ExcelProperty(value = "GDP（亿元）")
    private String gdp;

    /**
     * 三产占比（%）
     */
    @ColumnWidth(10)
    @ExcelProperty(value = "三产比重（%）")
    private String tertiaryIndustryPercentage;

    /**
     * 蔚来月均销量预估
     */
    @ColumnWidth(10)
    @ExcelProperty(value = "蔚来月均销量预估（台/月）")
    private String estimatedMonthlySalesOfNIO;

    /**
     * 蔚来年均销量预估
     */
    @ColumnWidth(10)
    @ExcelProperty(value = "蔚来年均销量预估（台/月）")
    private String estimatedAnnualSalesOfNIO;

    /**
     * 蔚来累计保有量预估
     */
    @ColumnWidth(10)
    @ExcelProperty(value = "蔚来累计保有量预估（台）")
    private String estimatedAccumulatedOwnershipOfNIO;

    /**
     * 蔚来用户数
     */
    @ColumnWidth(10)
    @ExcelProperty(value = "蔚来用户数（人）")
    private String NIOUserCount;

    /**
     * 高端车月均销量
     */
    @ColumnWidth(10)
    @ExcelProperty(value = "高端车月均销量（台/月）")
    private String monthlySalesOfLuxuryCars;

    /**
     * 高端新能源月均销量
     */
    @ColumnWidth(10)
    @ExcelProperty(value = "高端新能源月均销量（台/月）")
    private String monthlySalesOfHighEndNewEnergyVehicles;

    /**
     * 高端新能源累计保有量
     */
    @ColumnWidth(10)
    @ExcelProperty(value = "高端新能源累计保有量（台）")
    private String accumulatedOwnershipOfHighEndNewEnergyVehicles;

    /**
     * 总部规划NH数
     */
    @ColumnWidth(10)
    @ExcelProperty(value = "NH（个）")
    private String headquarterPlanningNHCount;

    /**
     * 总部规划NS数
     */
    @ColumnWidth(10)
    @ExcelProperty(value = "NS（个）")
    private String headquarterPlanningNSCount;

    /**
     * 总部规划Popup数
     */
    @ColumnWidth(10)
    @ExcelProperty(value = "NS-Popup（个）")
    private String headquarterPlanningPopupCount;

    /**
     * 总部规划MEET数
     */
    @ColumnWidth(10)
    @ExcelProperty(value = "NIO MEET（个）")
    private String headquarterPlanningMEETCount;

    /**
     * 总部规划路演数
     */
    @ColumnWidth(10)
    @ExcelProperty(value = "路演（个）")
    private String headquarterPlanningRoadshowCount;

    /**
     * 总部规划NDC数
     */
    @ColumnWidth(10)
    @ExcelProperty(value = "NDC（个）")
    private String headquarterPlanningNDCCount;

    /**
     * 总部规划NDS数
     */
    @ColumnWidth(10)
    @ExcelProperty(value = "NDS（个）")
    private String headquarterPlanningNDSCount;

    /**
     * 总部规划NSC数
     */
    @ColumnWidth(10)
    @ExcelProperty(value = "NSC（个）")
    private String headquarterPlanningNSCCount;

    /**
     * 总部规划ASC专营数
     */
    @ColumnWidth(10)
    @ExcelProperty(value = "ASC-专（个）")
    private String headquarterPlanningASCExclusiveCount;

    /**
     * 总部规划ASC兼营数
     */
    @ColumnWidth(10)
    @ExcelProperty(value = "ASC-兼（个）")
    private String headquarterPlanningASCConcurrentCount;

    /**
     * 总部规划换电站数
     */
    @ColumnWidth(10)
    @ExcelProperty(value = "换电站（个）")
    private String headquarterPlanningBatterySwapStationCount;

    /**
     * GDP全国排名
     */
    @ColumnWidth(10)
    @ExcelProperty(value = "GDP全国排名")
    private String gdpNationalRanking;

    /**
     * 高端车累计保有量（万辆）
     */
    @ColumnWidth(10)
    @ExcelProperty(value = "高端车累计保有量（台）")
    private String accumulatedOwnershipOfLuxuryCars;

    /**
     * 错误原因
     */
    @ColumnWidth(50)
    @ExcelProperty(value = "错误原因")
    private String errMsg;

}
