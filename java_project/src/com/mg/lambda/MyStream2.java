package com.mg.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author mg
 * @Date 2021-08-29
 * @Version 1.0
 */
public class MyStream2 {
	public static void main(String[] args){
		ArrayList<User> userList = new ArrayList<>();
		userList.add(new User("mg", 30, 15000));
		userList.add(new User("ml", 32, 8000));
		userList.add(new User("mch", 30, 15000));
		userList.add(new User("mg", 30, 25000));

		//查詢年齡超過30嵗的用戶
		Stream<User> userStream = userList.stream().filter(u -> u.getAge() > 30);
		userStream.forEach(u-> System.out.println(u));

		//去重
		System.out.println(userList.stream().distinct().count());

		//跳过
		Stream<User> skipStream = userList.stream().skip(1);
		//skipStream.forEach(e-> System.out.println(e));
		skipStream.forEach(System.out::println);

		//获取第一个
		Stream<User> limitStream = userList.stream().limit(1);
		limitStream.forEach(System.out::println);

		System.out.println("...............");
		Stream<String> mapStream = userList.stream().map(e -> e.getName());
		mapStream.forEach(System.out::println);

		System.out.println("...............");
		List<String> asList = Arrays.asList("a", "b", "c");
		Stream<String> mapStream2 = asList.stream().map(String::toUpperCase);
		mapStream2.forEach(System.out::println);

		//自然排序
		System.out.println("...............");
		Stream<Integer> sortedStream = userList.stream().map(User::getAge).sorted();
		sortedStream.forEach(System.out::println);

		System.out.println("...............");
		//自定义排序
		Stream<User> sortedStream2 = userList.stream().sorted((o1, o2) -> {
			if (o1.getAge() == o2.getAge()) {
				return o2.getSalary() - o1.getSalary();
			} else {
				return o1.getAge() - o2.getAge();
			}
		});
		sortedStream2.forEach(System.out::println);
	}

}
