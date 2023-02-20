package com.mg.thread;

/**
 * @author mg
 * @Date 2022-10-09
 * @Version 1.0
 */
public class ThreadLocalTest {

	private static ThreadLocal<Object> tl =new ThreadLocal<>();

	public static void main(String[] args){
		Task task = new Task();
		new Thread(task).start();
		new Thread(task).start();
	}

	static class Task implements Runnable{

		@Override
		public void run() {
			Object o = tl.get();
			if (o==null) {
				tl.set(new Object());
				System.out.println(Thread.currentThread().getName()+":"+tl.get());
			}
		}
	}

}
