package com.mg.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 测试线程池下InheritableThreadLocal子线程获取主线程线程新变量失效的场景
 *
 * @author mg
 * @date 2024-10-20
 */
public class TestInheritableThreadLocal {

    private static final InheritableThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    // 固定大小的线程池，保证线程复用
    private static final ExecutorService executorService = Executors.newFixedThreadPool(1);

    public static void main(String[] args) {
        threadLocal.set("main线程 变量1");
        // 正常取到 main线程 变量1
        executorService.execute(() -> System.out.println(threadLocal.get()));

        threadLocal.set("main线程 变量2");
        // 线程复用再取还是 main线程 变量1
        executorService.execute(() -> System.out.println(threadLocal.get()));
    }
}
