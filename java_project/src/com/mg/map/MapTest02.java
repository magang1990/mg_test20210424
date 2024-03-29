package com.mg.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author mg
 * @Date 2023-04-15
 * @Version 1.0
 *
 * map无论在foreach遍历还是在iterator遍历过程中，直接用map添加或删除均报ConcurrentModificationException异常
 * 必须用迭代器删除
 */
public class MapTest02 {
	public static void main(String[] args){
		HashMap<String, String> map = new HashMap<>();
		map.put("mg", "niu");
		map.put("ml", "niu2");

		map.forEach((k,v)->{
			if ("mg".equals(k)){
				//map.put("mc", "niu3");
				//map.remove(k);
			}
		});

		for (Map.Entry<String, String> entry : map.entrySet()) {
			//map.remove(entry.getKey());
		}

		Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, String> next = iterator.next();

			if ("mg".equals(next.getKey())){
				//map.put("mc", "niu3");
				//map.remove(next.getKey());
				//迭代器删除不报错
				//iterator.remove();
			}
			//map.remove(next.getKey());
		}

		map.entrySet().stream().forEach(e->{

		});

		//map.putIfAbsent("mg", "niuniu");
		System.out.println(map);

	}

}
