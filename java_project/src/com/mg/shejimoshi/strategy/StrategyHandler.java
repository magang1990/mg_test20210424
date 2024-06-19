package com.mg.shejimoshi.strategy;

import java.util.List;

/**
 * @author mg
 * @date 2023-07-28
 */
public interface StrategyHandler<T,R> {

    List<T> fromJson(R param);

}
