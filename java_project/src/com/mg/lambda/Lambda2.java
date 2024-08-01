package com.mg.lambda;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author mg
 * @Date 2021-08-29
 * @Version 1.0
 */
public class Lambda2 {
	public static void main(String[] args) {
		//Runnable接口，无参（匿名内部类）
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("run方法");
			}
		};

		new Thread(runnable).start();

		// Lambda表达式
		Runnable runnable2 = () -> System.out.println("Lambda表达式");
		new Thread(runnable2).start();

		new Thread(() -> System.out.println("Lambda表达式!!!!!!")).start();

		//Comparator比较器接口，有参数
		Comparator<String> comparator1=new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length()-o2.length();
			}
		};
		TreeSet<String> treeSet1 = new TreeSet<>(comparator1);

		Comparator<String> comparator2=(o1,o2)->o1.length()-o2.length();

		TreeSet<String> treeSet3 = new TreeSet<>((o1,o2)->o1.length()-o2.length());

	}
}
