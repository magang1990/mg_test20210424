package com.mg.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author mg
 * @date 2023-07-06
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        /*ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("asset-pool-%d").build();*/
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                4,
                10,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(200),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        threadPoolExecutor.execute(new MyRunNable());
        threadPoolExecutor.shutdown();

    }


}

class MyRunNable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
