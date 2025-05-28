package com.mg.stream;

import cn.hutool.core.collection.CollectionUtil;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 并行流测试
 * 结果普通流耗时是并行流遍历次数倍
 *
 * @author mg
 * @date 2025/5/28
 */
public class ParallelSteamTest {
    public static void main(String[] args) {
        List<Integer> list = CollectionUtil.newArrayList(1, 2, 3, 4, 5);

        long startParallel = System.currentTimeMillis();
        List<User> userList = list.parallelStream().map(ParallelSteamTest::buildUser).collect(Collectors.toList());
        long endParallel = System.currentTimeMillis();
        System.out.println("并行流循环调用耗时=" + (endParallel - startParallel));

        long startStream = System.currentTimeMillis();
        List<User> userList2 = list.stream().map(ParallelSteamTest::buildUser).collect(Collectors.toList());
        long endStream = System.currentTimeMillis();
        System.out.println("普通流循环调用耗时=" + (endStream - startStream));
        //并行流循环调用耗时=231
        //普通流循环调用耗时=1023
    }

    public static User buildUser(Integer age) {
        User user = new User();
        try {
            Thread.sleep(200);//模拟耗时的数据库或者第三方接口查询

            user.setName("mg" + age);
            user.setAge(age);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return user;
    }

}
