package com.mg.stream;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author mg
 * @Date 2023-04-26
 * @Version 1.0
 */
public class DistinctByKeyTest {
	public static void main(String[] args) {
		List<User> userList = new ArrayList<>();
		userList.add(new User("mg", 30, 15000));
		userList.add(new User("ml", 32, 8000));
		userList.add(new User("ml", 35, 18000));
		userList.add(new User("mch", 30, 15000));
		userList.add(new User("mg", 30, 25000));
		userList.add(new User("mg", 30, 25000));

		//方法一，重写User的hashCode()和equals(Object obj)方法。通过调用stream的distinct()方法
		System.out.println("重写hashCode()和equals(Object obj)：" + userList.stream().distinct().collect(Collectors.toList()));

		//方法二，通过distinctByKey自定义方法，根据一个属性去重(会稍微占内存)
		List<User> list = userList.stream().filter(distinctByKey(User::getName)).collect(Collectors.toList());
		System.out.println("distinctByKey方法去重后：" + list);

		//方法三，通过stream的分组map，根据一个或多个属性分组去重
		//Map<String, User> userMap = userList.stream().collect(Collectors.toMap(User::getName, e -> e, (v1, v2) -> v1));
		Map<String, User> userMap = userList.stream().collect(Collectors.toMap(e -> e.getName() + ";" + e.getAge(), e -> e, (v1, v2) -> v1));
		System.out.println("通过转换map去重：" + userMap.values());

		//方法四，通过stream的Collectors.collectingAndThen，根据一个或多个属性分组去重
		List<User> collect = userList.stream().collect(Collectors.collectingAndThen(
				Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(User::getName))),
				ArrayList::new));
		/*List<User> collect = userList.stream().collect(Collectors.collectingAndThen(
				Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(e -> e.getName() + ";" + e.getAge()))),
				ArrayList::new));*/
		System.out.println("通过Collectors.collectingAndThen去重：" + collect);
	}

	private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
		Map<Object, Boolean> seen = new ConcurrentHashMap<>();
		return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;

		//!= null时，找出去重后抛弃的重复数据
		//return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) != null;
	}

}
