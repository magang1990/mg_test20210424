package com.mg.springboot_project.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.mg.springboot_project.dto.CityImportErrorResponse;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @author gang.ma2.o
 * @date 2023/8/30
 */
public class CityDataImportListener extends AnalysisEventListener<CityImportErrorResponse> {


    @Getter
    private final List<CityImportErrorResponse> errList = CollectionUtil.newArrayList();

    private final List<String> heads;

    public CityDataImportListener(List<String> heads) {
        this.heads = heads;
    }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        if (headMap.size() > heads.size() || !heads.containsAll(headMap.values())) {
            throw new RuntimeException("导入模版错误");
        }
    }

    @Override
    public void invoke(CityImportErrorResponse cityImportErrorResponse, AnalysisContext analysisContext) {
        if (BeanUtil.isEmpty(cityImportErrorResponse)) {
            return;
        }

        StringBuilder errMsg = new StringBuilder();
        // 校验城市编码是否为空
        /*if (StringUtils.isBlank(cityImportErrorResponse.getCityCode())) {
            errMsg.append(String.format(Constants.FILED_IS_BLANK, heads.get(0))).append(StrPool.LF);
        }*/

        if (StringUtils.isNotBlank(errMsg)) {
            cityImportErrorResponse.setErrMsg(errMsg.toString());
        }

        errList.add(cityImportErrorResponse);

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        if (errList.size() == 0) {
            throw new RuntimeException("识别数据为空");
        }

        // 10000条限制
        //BusinessApolloProperties businessApolloProperties = SpringUtil.getBean(BusinessApolloProperties.class);
        if (errList.size() > 10000) {
            throw new RuntimeException("导出数量超过限制");
        }

    }


}
