package com.mg.thread;

import java.util.concurrent.Semaphore;

/**
 * Semaphore实现等待通知机制，多线程交替执行
 *
 * @author mg
 * @date 2024-12-18
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        FooBar fooBar = new FooBar();
        int n = 8;
        Thread thread1 = new Thread(()->{
            try {
                fooBar.foo(n);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();

        Thread thread2 = new Thread(()->{
            try {
                fooBar.bar(n);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread2.start();

    }
}

class FooBar {
    private final Semaphore fooSemaphore = new Semaphore(1);
    private final Semaphore barSemaphore = new Semaphore(0);

    public void foo(int n) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            fooSemaphore.acquire();
            System.out.print("foo");
            barSemaphore.release();
        }
    }

    public void bar(int n) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            barSemaphore.acquire();
            System.out.print("bar");
            fooSemaphore.release();
        }
    }

}