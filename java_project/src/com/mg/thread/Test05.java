package com.mg.thread;

/**
 * @author mg
 * @Date 2022-10-08
 * @Version 1.0
 */
public class Test05 {
	public static void main(String[] args){
		Runnable2 runnable2 = new Runnable2();
		Thread t1= new Thread(runnable2);
		Thread t2 = new Thread(runnable2);
		t1.start();
		t2.start();
	}
}

class Runnable2 implements Runnable {
	int num=18;
	@Override
	public void run() {
		/*for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}*/
		/*for (int i = 0; i < 18; i++) {
			System.out.println(Thread.currentThread().getName()+":"+num--);
		}*/

		while(num>=1){
			System.out.println(Thread.currentThread().getName()+":"+num--);
		}

		/*for (int i = num; i > 0; i--) {
			//System.out.println(Thread.currentThread().getName()+":"+i);
		}*/
	}
}
