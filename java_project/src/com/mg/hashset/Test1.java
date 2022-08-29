package com.mg.hashset;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author mg
 * @Date 2021-06-03
 * @Version 1.0
 */
public class Test1 {
	public static void main(String[] args){
		HashSet<String> sets=new HashSet<>(2);
		sets.add("A");
		sets.add("B");
		sets.add("C");
		sets.add("A");
		System.out.println(sets);

		Iterator<String> iterator = sets.iterator();
		while (iterator.hasNext()){
			String s = iterator.next();
			System.out.println(s);
		}


	}
}
