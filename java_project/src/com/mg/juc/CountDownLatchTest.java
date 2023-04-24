package com.mg.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author mg
 * @Date 2023-04-05
 * @Version 1.0
 * 一等多。一个线程等待多个线程。多个线程执行完毕后，一个线程再继续自己的工作
 */
public class CountDownLatchTest {
	public static void main(String[] args) throws InterruptedException {
		/*CountDownLatch latch = new CountDownLatch(1);
		try {
			long start = System.currentTimeMillis();
			boolean await = latch.await(8, TimeUnit.SECONDS);
			long end = System.currentTimeMillis();
			System.out.println("时间差："+(end-start));
			System.out.println(await);
			//Thread.sleep(9000);
			System.out.println(await);
			//latch.await();
			System.out.println("niu");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		latch.countDown();
		System.out.println("end");*/

		CountDownLatch latch = new CountDownLatch(3);

		for (int i = 1; i <= 3; i++) {
			int finalI=i;
			new Thread(()->{
				try {
					//Thread.sleep((long) (Math.random()*10000));
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("用户"+finalI+"已经参团");
				latch.countDown();
			}).start();
		}

		System.out.println("等待三人参团中");
		//latch.await();
		boolean await = latch.await(15, TimeUnit.SECONDS);
		System.out.println(""+latch.getCount());
		//await加参数等待时间后，倒数计数器还不为0时，await为false，为0时await为true
		System.out.println("await="+await);
		System.out.println("三人用户已经全部参团，出发");

	}
}
