package com.mg.thread;

/**
 * @author mg
 * @Date 2022-10-08
 * @Version 1.0
 * 线程6种状态：new,runnable,blocked ,waiting,timed waiting,terminated
 */
public class Test04 {
	public static void main(String[] args) throws InterruptedException {
		/*Thread thread = new Thread(new Task());
		System.out.println(thread.getState());//new
		thread.start();
		System.out.println(thread.getState());//runnable
		//让主线程休眠,确保主线程运行结束
		thread.sleep(10);
		System.out.println(thread.getState());//terminated*/

		BlockTask blockTask = new BlockTask();
		Thread t1= new Thread(blockTask);
		Thread t2 = new Thread(blockTask);
		t1.start();
		t2.start();
		//从严谨的角度来说，t1线程不一定会先执行，此处假设t1先执行
		System.out.println(t1.getState());//runnable
		//确保t1线程获取到锁
		Thread.sleep(10);
		System.out.println(t2.getState());//blocked
		Thread.sleep(10);
		System.out.println(t1.getState());//timed waiting
		Thread.sleep(1000);
		System.out.println(t1.getState());//waiting

	}
}

class Task implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}
	}
}

class BlockTask implements Runnable {

	@Override
	public void run() {
		synchronized (this){
			//另一个线程会进入blocked状态
			try {
				//目的让线程进入timed waiting状态
				Thread.sleep(1000);
				//进入waiting状态
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
