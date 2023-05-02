package com.mg.list;

import java.util.ArrayList;

/**
 * @author mg
 * @Date 2021-07-01
 * @Version 1.0
 */
public class ListTest {
	public static void main(String[] args){
		//List<String> list = Arrays.asList("a", "b", "c", "d");
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		System.out.println(list);

//		for (int i = 0; i < list.size(); i++) {
//			if (list.get(i) .equals("b")) {
//				list.remove("b");
//			}
//		}
//		for (int i = 0; i < list.size(); i++) {
//				list.remove("b");
//		}



		ArrayList<User> list1 = new ArrayList<>();
		for (User user : list1) {
			User user1=new User();
			user1.setUserName("mg");
			user1.setUserAge(30);
			list1.add(user1);
		}
		System.out.println(list1);
	}


}
