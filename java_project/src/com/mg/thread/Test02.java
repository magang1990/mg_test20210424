package com.mg.thread;

import java.util.concurrent.*;

/**
 * @author mg
 * @Date 2022-10-07
 * @Version 1.0
 */
public class Test02 {
	public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
		MyRunnable runnable = new MyRunnable();
		new Thread(runnable).start();

		MyCallable callable = new MyCallable(1,10);
		FutureTask<Long> futureTask = new FutureTask<>(callable);
		new Thread(futureTask).start();
		//Long l = futureTask.get();
		Long l = futureTask.get(2, TimeUnit.SECONDS);
		System.out.println(l);
	}
}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("子线程启动......");
	}
}

class MyCallable implements Callable<Long> {

	private int start;

	private int end;

	public MyCallable(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public Long call() throws Exception {
		long sum = 0;
		for (int i = start; i <= end; i++) {
			sum += i;
		}
		Thread.sleep(3000);
		return sum;
	}
}
