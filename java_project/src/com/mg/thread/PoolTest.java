package com.mg.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author mg
 * @Date 2022-10-09
 * @Version 1.0
 */
public class PoolTest {
	public static void main(String[] args){
		Task2 task2 = new Task2();
		ExecutorService service = Executors.newSingleThreadExecutor();
		service.submit(task2);
		//OOM 内存溢出
		//关键点：线程数，队列长度
	}
}

class Task2 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}
	}
}