package com.mg.arraylist;

import java.util.*;

/**
 * @author mg
 * @Date 2021-05-06
 * @Version 1.0
 */
public class MgList {
	public static void main(String[] args) {
		List<String> list1 = Arrays.asList("a","a", "b", "c");
		List<String> list2 = Arrays.asList("a", "b");
		List<String> list3 = new ArrayList<>();

		//方法一
		for (int i = 0; i < list1.size(); i++) {
			for (int j = 0; j < list2.size(); j++) {
				if (list1.get(i).equals(list2.get(j))){
					list3.add(list1.get(i));
				}
			}
		}
		System.out.println(list3);

		//方法二
		for (String s1 : list1) {
			for (String s2 : list2) {
				if (s1.equals(s2)){
					list3.add(s1);
				}
			}
		}
		System.out.println(list3);

		//方法三
		HashSet<String> set3 = new HashSet<>();
		for (String s1 : list1) {
			for (String s2 : list2) {
				if (s1.equals(s2)){
					set3.add(s1);
				}
			}
		}
		System.out.println(set3);

		//方法四
		Set<String> set = new HashSet<>();
		for (String a : list1) {
			set.add(a);
		}
		for (String b : list2) {
			if(set.contains(b)){
				list3.add(b);
			}
		}
		System.out.println(list3);

		//方法五
		ArrayList list = new ArrayList<>(list1);
		boolean result = list.retainAll(list2);
		if (result){
			System.out.println(list);
		} else {
			System.out.println("list1与list2没有相同元素！");
		}

	}
}
