package com.mg.thread;

/**
 * @author mg
 * @Date 2022-10-08
 * @Version 1.0
 */
public class Test06 {
	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(10);
		Object o = new Object();
		//开启一个子线程来唤醒阻塞的线程
		new Thread(()->{
			try {
				//确保主线程先启动
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (o){
				o.notify();
			}
		}).start();

		System.out.println("加油");
		synchronized (o){
			o.wait();
			//o.wait(1000);
		}

		System.out.println("niubi");
	}
}
