package com.mg.thread;

/**
 * @author mg
 * @Date 2022-10-07
 * @Version 1.0
 */
public class Test01 {
	public static void main(String[] args){
		MyThread thread1 = new MyThread();
		//thread1.run();
		thread1.start();
		MyThread thread2 = new MyThread();
		//thread2.run();
		thread2.start();
		System.out.println("niu".hashCode());
	}

}

class MyThread extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
}
