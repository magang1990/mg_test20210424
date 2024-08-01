package com.mg.stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * List集合的各种遍历方式耗时比较
 *
 * @author mg
 * @Date 2023-04-27
 * @Version 1.0
 */
public class ListStreamTest {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		/* 一万数据时
		普通for循环:4
		增强for循环:2
		forEach方法:118
		Iterator迭代器:1
		stream.forEach:6
		*/

		/* 一百万数据时
		普通for循环:17
		增强for循环:27
		forEach方法:171
		Iterator迭代器:29
		stream.forEach:39
		*/

		/* 一千万数据时
		普通for循环:68
		增强for循环:106
		forEach方法:226
		Iterator迭代器:97
		stream.forEach:83
		*/

		int total = 10000000;
		for (int i = 0; i < total; i++) {
			list.add(i);
		}

		//方法一，普通for循环
		long start1 = System.currentTimeMillis();
		for (int i = 0; i < list.size(); i++) {
			System.currentTimeMillis();
		}
		long end1 = System.currentTimeMillis();
		System.out.println("普通for循环:" + (end1 - start1));

		//方法二，增强for循环
		long start2 = System.currentTimeMillis();
		for (Integer integer : list) {
			System.currentTimeMillis();
		}
		long end2 = System.currentTimeMillis();
		System.out.println("增强for循环:" + (end2 - start2));

		//方法三，forEach方法
		long start3 = System.currentTimeMillis();
		list.forEach(e -> {
			System.currentTimeMillis();
		});
		long end3 = System.currentTimeMillis();
		System.out.println("forEach方法:" + (end3 - start3));

		//方法四，Iterator迭代器
		long start4 = System.currentTimeMillis();
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			Integer next = iterator.next();
			System.currentTimeMillis();
		}
		long end4 = System.currentTimeMillis();
		System.out.println("Iterator迭代器:" + (end4 - start4));

		//方法五，stream.forEach
		long start5 = System.currentTimeMillis();
		list.stream().forEach(e -> {
			System.currentTimeMillis();
		});
		long end5 = System.currentTimeMillis();
		System.out.println("stream.forEach:" + (end5 - start5));

	}
}
