package com.mg.shejimoshi.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mg
 * @date 2023-07-28
 */
public class LocationInfoStrategy implements StrategyHandler<LocationInfo, OperationContext> {

    @Override
    public List<LocationInfo> fromJson(OperationContext param) {
        // List<LocationInfo> appLists = JSONUtil.readValue(sb.toString(), new TypeReference<>() {});
        List<LocationInfo> appLists = new ArrayList<>();
        appLists.add(new LocationInfo(172));
        return appLists;
    }
}
