package com.mg.arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author mg
 * @Date 2023-04-16
 * @Version 1.0
 */
public class ListTest02 {
	public static void main(String[] args){
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");

		/*for (int i = 0; i < list.size(); i++) {
			if ("b".equals(list.get(i))){
				list.remove(i);
				list.remove("c");
				list.add("d");
			}
		}*/

		/*for (String s : list) {
			//list.remove(s);
			//list.remove("c");
			list.add("d");
		}*/

		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String s = iterator.next();
			System.out.println("iterator遍历：s="+s);
			//iterator.remove();
			//list.add("e");
			if ("b".equals(s)){
				//iterator.remove();
				//list.remove(s);
				list.remove(1);
			}
		}

		System.out.println(list);

	}
}