package com.mg.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 流式编程。对集合数组的操作
 * 关注的做什么，而不是怎么做
 * @author mg
 * @Date 2021-08-29
 * @Version 1.0
 */
public class MyStream {
	public static void main(String[] args){
		//传统方式
		ArrayList<String> strlist = new ArrayList<>();
		strlist.add("m");
		strlist.add("mg");
		strlist.add("maaijiao");

		int count=0;
		for (String s : strlist) {
			if (s.length() > 3) {
				count++;
			}
		}
		System.out.println(count);

		//Stream方式
		long count2 = strlist.stream().filter(s -> s.length() > 9).count();
		System.out.println(count2);

		//数组
		int[] arrays=new int[]{1,2,3};
		IntStream stream = Arrays.stream(arrays);
		long count3 = stream.filter(i -> i > 1).count();
		System.out.println(count3);
	}
}
