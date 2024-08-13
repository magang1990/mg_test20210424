package com.mg.springboot_project;

import cn.hutool.core.collection.CollectionUtil;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mg
 * @date 2024-08-13
 */
@SpringBootTest
public class ListTest {

    /**
     * guava和Hutool的集合工具根据一定数量分割集合
     */
    @Test
    public void run4(){
        //List<Integer> integers = Lists.newArrayList(1, 2, 3, 4, 5);
        //List<Integer> integers = null;
        List<Integer> integers = new ArrayList<>();
        List<List<Integer>> split = CollectionUtil.split(integers, 2);//传参集合为null或空集合时，返回的是空集合
        List<List<Integer>> partition = Lists.partition(integers, 2);//传参集合为null时，报空指针异常；传参集合为空集合时，返回的是空集合
    }

}
