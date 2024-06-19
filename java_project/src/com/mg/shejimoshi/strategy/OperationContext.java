package com.mg.shejimoshi.strategy;

import com.alibaba.fastjson2.JSONObject;

/**
 * @author mg
 * @date 2023-07-28
 */
public class OperationContext {

    private Integer type;

    private JSONObject param;

    public OperationContext() {
    }

    public OperationContext(Integer type, JSONObject param) {
        this.type = type;
        this.param = param;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public JSONObject getParam() {
        return param;
    }

    public void setParam(JSONObject param) {
        this.param = param;
    }
}
