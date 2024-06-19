package com.mg.shejimoshi.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mg
 * @date 2023-07-28
 */
public class AppListStrategy implements  StrategyHandler<AppList, OperationContext>{

    @Override
    public List<AppList> fromJson(OperationContext param) {
        // List<AppList> appLists = JSONUtil.readValue(sb.toString(), new TypeReference<>() {});
        List<AppList> appLists=new ArrayList<>();
        appLists.add(new AppList("小程序"));
        return appLists;
    }

}
