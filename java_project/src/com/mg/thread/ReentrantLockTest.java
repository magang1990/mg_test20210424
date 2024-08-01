package com.mg.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mg
 * @date 2024-07-15
 */
public class ReentrantLockTest {
    public static void main(String[] args) {
        Lock lock=new ReentrantLock();
        //上锁
        lock.lock();
        //释放此锁。
        lock.unlock();

    }
}
