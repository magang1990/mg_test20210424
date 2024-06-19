package com.mg.shejimoshi.strategy;

import com.alibaba.fastjson2.JSONObject;

import java.util.List;

/**
 * @author mg
 * @date 2023-07-28
 */
public class MainTest {
    public static void main(String[] args) {
        OperationContext context1 = new OperationContext(1, new JSONObject());
        OperationContext context2 = new OperationContext(2, new JSONObject());
        List list1 = ContextRouter.INSTANCE.get(context1);
        List list2 = ContextRouter.INSTANCE.get(context2);
    }

}
