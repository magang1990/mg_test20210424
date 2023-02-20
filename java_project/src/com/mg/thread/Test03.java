package com.mg.thread;

/**
 * @author mg
 * @Date 2022-10-07
 * @Version 1.0
 * 当程序的用户线程执行结束后，守护线程也会自动结束
 */
public class Test03 {
	public static void main(String[] args){
		//创建并开启守护线程
		DaemonThread daemonThread = new DaemonThread();
		daemonThread.setDaemon(true);
		daemonThread.start();

		//用户线程
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 3; i++) {
					System.out.println("用户线程");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
}

class DaemonThread extends Thread{

	@Override
	public void run() {
		while(true){
			System.out.println("守护线程");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}