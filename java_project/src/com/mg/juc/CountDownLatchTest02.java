package com.mg.juc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * @author mg
 * @Date 2023-04-05
 * @Version 1.0
 * 多等一
 */
public class CountDownLatchTest02 {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(1);

		for (int i = 1; i <= 10; i++) {
			int finalI = i;
			new Thread(() -> {
				System.out.println("用户"+finalI+"已到达");
				try {
					latch.await();
					System.out.println("用户"+finalI+"开始抢购商品");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}).start();
		}

		System.out.println("管理员等待时间是否到8点");
		Thread.sleep(15000);
		latch.countDown();
		System.out.println("时间到了，开门做生意");

	}
}
