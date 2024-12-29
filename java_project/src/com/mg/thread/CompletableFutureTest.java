package com.mg.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author mg
 * @date 2024-10-20
 */
public class CompletableFutureTest {
    public static void main(String[] args) {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("future1完成！");
            return "future1完成！";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("future2完成！");
            return "future2完成！";
        });

        CompletableFuture<Void> combindFuture = CompletableFuture.allOf(future1, future2);

        try {
            // 这一步是必要的，调用 join() 或 get() 来等待所有任务完成
            combindFuture.get(3, TimeUnit.SECONDS);
            //combindFuture.join();
            // 上述阻塞主线程方法后，在所有任务完成后，调用 get() 获取每个 CompletableFuture 的结果。
            //String s1 = future1.get(6, TimeUnit.SECONDS);
            //String s2 = future2.get();
            //String s2 = future2.get(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }


        System.out.println("niu");

    }
}
