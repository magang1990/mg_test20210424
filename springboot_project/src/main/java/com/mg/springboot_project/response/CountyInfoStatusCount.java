package com.mg.springboot_project.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author mg
 * @date 2024-08-07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CountyInfoStatusCount {

    /**
     * 总量
     */
    private Integer total;

    /**
     * 低收入总数据量
     */
    private Integer lowCount;

    /**
     * 中等收入总数据量
     */
    private Integer middleCount;

    /**
     * 高收入总数据量
     */
    private Integer highCount;

}
