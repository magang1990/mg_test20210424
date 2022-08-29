package com.mg.lambda;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author mg
 * @Date 2021-08-15
 * @Version 1.0
 */
public class LambdaMain {
	public static void main(String[] args){

		Runnable runnable1=new Runnable() {
			@Override
			public void run() {
				System.out.println("runnable1");
			}
		};
		new Thread(runnable1).start();

		Runnable runnable2=()-> System.out.println("lambda的runnable2");
		new Thread(runnable2).start();

		new Thread(()-> System.out.println("lambda的runnable2")).start();

		Comparator<String> comparator1=new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length()-o2.length();
			}
		};
		TreeSet<String> treeSet1=new TreeSet<>(comparator1);

		Comparator<String> comparator2=((o1, o2) -> o1.length()-o2.length());
		TreeSet<String> treeSet2=new TreeSet<>(comparator2);

		TreeSet<String> treeSet3=new TreeSet<>((o1, o2) -> o1.length()-o2.length());
	}
}
