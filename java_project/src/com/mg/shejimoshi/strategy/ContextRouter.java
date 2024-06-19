package com.mg.shejimoshi.strategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mg
 * @date 2023-07-28
 */
public class ContextRouter  {

    /**
     * 单例
     */
    public static final ContextRouter INSTANCE = new ContextRouter();

    /**
     * 品类到状态路由
     */
    private static final Map<Integer, StrategyHandler> CTNRTYPE_HANDLER_MAP =
            new HashMap<>();

    static {
        CTNRTYPE_HANDLER_MAP.put(1, new AppListStrategy());
        CTNRTYPE_HANDLER_MAP.put(2, new LocationInfoStrategy());
    }

    public List get(OperationContext param){
        return CTNRTYPE_HANDLER_MAP.get(param.getType()).fromJson(param);
    }

}
