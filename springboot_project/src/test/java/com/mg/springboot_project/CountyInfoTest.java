package com.mg.springboot_project;

import cn.hutool.core.collection.CollectionUtil;
import com.mg.springboot_project.dao.CountyInfoMapper;
import com.mg.springboot_project.entity.CountyInfo;
import com.mg.springboot_project.response.CountyInfoStatusCount;
import com.mg.springboot_project.response.CountyInfoStatusStatistics;
import com.mg.springboot_project.service.CountyInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mg
 * @date 2024-08-06
 */
@SpringBootTest
public class CountyInfoTest {

    @Autowired
    CountyInfoMapper countyInfoMapper;

    @Autowired
    CountyInfoService countyInfoService;

    /**
     * group by统计数据和count(if(函数统计百万数据耗时差不多
     * 多字段分组，或者需要统计多维度数据，例如总条数，总和等，则用GROUP BY统计，后续需要处理数据在Java后端处理
     * 仅仅是统计单字段不同状态数量建议还是count(if(函数统计
     *  GROUP BY和count(if(的字段加上索引后效率提高，尽管该字段区分度不高。
     */
    @Test
    public void run() {
        long start1 = System.currentTimeMillis();
        List<CountyInfoStatusStatistics> list = countyInfoMapper.countyInfoStatusStatistics();
        long end1 = System.currentTimeMillis();
        long time1 = (end1 - start1) / 1000;// 3秒，status加索引后减少到1秒
        System.out.println("group by统计数据共耗时：" + (end1 - start1) / 1000 + "秒");

        long start2 = System.currentTimeMillis();
        CountyInfoStatusCount countyInfoStatusCount=countyInfoMapper.countyInfoStatusCount();
        long end2 = System.currentTimeMillis();
        long time2 = (end1 - start1) / 1000;// 3秒，status加索引后减少到1秒
        System.out.println("count(if(函数统计数据共耗时：" + (end2 - start2) / 1000 + "秒");
    }

    @Test
    public void countyBatchSave() {
        long start = System.currentTimeMillis();
        List<CountyInfo> countyInfos = new ArrayList<>(1000);
        // 添加一百万数据
        for (int i = 1; i <= 1000000; i++) {

            CountyInfo countyInfo = new CountyInfo()
                    .setName("中国" + i)
                    .setPeopleNumber(new BigDecimal("140000.08"))
                    .setStatus(this.getStatus(i))
                    .setGdpRank(2)
                    .setCreateBy("mg")
                    .setUpdateBy("mg");
            countyInfos.add(countyInfo);
            // 防止内存溢出，每1000条执行一次批量插入操作
            if (countyInfos.size() >= 1000) {
                countyInfoService.insertBatch(countyInfos);
                // 清空集合
                countyInfos.clear();
            }
        }

        // 处理剩余数据。不足1000条的时候，最后一次插入
        if (CollectionUtil.isNotEmpty(countyInfos)) {
            countyInfoService.insertBatch(countyInfos);
        }
        long end = System.currentTimeMillis();
        System.out.println("插入一百万数据共耗时：" + (end - start) / 1000 + "秒");// 不到5分钟

    }

    private int getStatus(int num) {
        int status;
        if (num % 3 == 0) {
            status = 1;
        } else if (num % 5 == 0) {
            status = 2;
        } else {
            status = 0;
        }

        return status;
    }

}
