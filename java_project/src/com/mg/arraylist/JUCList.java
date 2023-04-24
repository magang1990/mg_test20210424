package com.mg.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author mg
 * @Date 2023-04-05
 * @Version 1.0
 * 线程安全的ArrayList
 */
public class JUCList {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		//Collections.synchronizedList(list)适用于写多读少
		List<String> list2 = Collections.synchronizedList(list);
		//CopyOnWriteArrayList适用于写少读多
		List<String> list3 = new CopyOnWriteArrayList<>(list);
		System.out.println(list);
		System.out.println(list2);
		System.out.println(list3);
	}
}
