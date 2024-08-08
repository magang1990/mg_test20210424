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
public class CountyInfoStatusStatistics {

    /**
     * 国家收入状态 0，低收入；1，中等收入；2，高收入
     */
    private Integer status;

    /**
     * 当前国家收入状态的总数据量
     */
    private Integer count;

}
