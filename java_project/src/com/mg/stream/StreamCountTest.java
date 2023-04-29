package com.mg.stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author mg
 * @Date 2023-04-27
 * @Version 1.0
 *
 * Stream用于统计计数的各种方式
 *
 * 部分类似的方法Stream有mapToInt，mapToLong，mapToDouble；
 * Collectors类求和有summingInt，summingLong，summingDouble；
 * Collectors类一次性统计所有方法summarizingInt，summarizingLong，summarizingDouble
 */
public class StreamCountTest {
	public static void main(String[] args) {
		List<User> userList = new ArrayList<>();
		userList.add(new User("mg", 30, 15000));
		userList.add(new User("ml", 32, 8000));
		userList.add(new User("mch", 30, 15000));
		userList.add(new User("mg", 31, 25000));

		//总数
		long count1 = userList.stream().count();
		Long count2 = userList.stream().collect(Collectors.counting());
		long count3 = userList.stream().mapToInt(User::getAge).count();
		Map<String, Long> countMap = userList.stream().collect(Collectors.groupingBy(User::getName, Collectors.counting()));
		System.out.println("Stream聚合的count()方法：" + count1);
		System.out.println("Stream收集collect里面的Collectors类的counting()方法：" + count2);
		System.out.println("Stream的mapToInt的count()方法：" + count3);
		System.out.println("Stream分组后Collectors类的counting()方法：" + countMap);

		//最大值，最小值
		/*User user = userList.stream().max(Comparator.comparing(User::getAge)).orElse(new User());
		System.out.println(user.getAge());*/
		Integer max1 = userList.stream().max(Comparator.comparing(User::getAge)).map(User::getAge).orElse(0);
		Integer min1 = userList.stream().min(Comparator.comparing(User::getAge)).map(User::getAge).orElse(0);
		Integer max2 = userList.stream().map(User::getAge).collect(Collectors.maxBy(Integer::compare)).orElse(0);
		Integer min2 = userList.stream().map(User::getAge).collect(Collectors.minBy(Integer::compare)).orElse(0);
		Integer max3 = userList.stream().map(User::getAge).reduce(Integer::max).orElse(0);//orElse中other是默认值
		Integer min3 = userList.stream().map(User::getAge).reduce(Integer::min).orElse(0);//orElse中other是默认值
		//reduce中identity初始值，也参与比较,故比较大小的时候慎用
		Integer max4 = userList.stream().map(User::getAge).reduce(0, Integer::max);
		Integer min4 = userList.stream().map(User::getAge).reduce(0, Integer::min);
		int max5 = userList.stream().mapToInt(User::getAge).max().orElse(0);
		int mmin5 = userList.stream().mapToInt(User::getAge).min().orElse(0);
		Map<String, Integer> maxMap = userList.stream().collect(Collectors.toMap(User::getName, User::getAge, Integer::max));
		Map<String, Integer> minMap = userList.stream().collect(Collectors.toMap(User::getName, User::getAge, Integer::min));
		System.out.println("Stream聚合的max方法：" + max1);
		System.out.println("Stream收集collect里面的Collectors类的maxBy方法：" + max2);
		System.out.println("Stream规约reduce的默认值：" + max3);
		System.out.println("Stream规约reduce的初始值：" + max4);
		System.out.println("Stream的mapToInt的max()方法：" + max5);
		System.out.println("Stream收集collect分组后取最大value存值：" + maxMap);


		//平均值
		Double avg1 = userList.stream().collect(Collectors.averagingInt(User::getAge));
		double avg2 = userList.stream().mapToInt(User::getAge).average().orElse(0);
		Map<String, Double> avgMap = userList.stream().collect(
				Collectors.groupingBy(User::getName, Collectors.averagingInt(User::getAge)));
		System.out.println("Stream收集collect里面的Collectors类的averagingInt方法：" + avg1);
		System.out.println("Stream的mapToInt的average()：" + avg2);
		System.out.println("Stream收集collect分组后Collectors类的averagingInt方法：" + avgMap);

		//求和
		int sum1 = userList.stream().mapToInt(User::getAge).sum();
		Integer sum2 = userList.stream().collect(Collectors.summingInt(User::getAge));
		Map<String, Integer> sumMap1 = userList.stream().collect(
				Collectors.groupingBy(User::getName, Collectors.summingInt(User::getAge)));
		Map<String, Integer> sumMap2 = userList.stream().collect(Collectors.toMap(User::getName, User::getAge, Integer::sum));
		System.out.println("Stream的mapToInt的sum()方法：" + sum1);
		System.out.println("Stream收集collect里面的Collectors类的summingInt方法：" + sum2);
		System.out.println("Stream收集collect分组后Collectors类的summingInt方法：" + sumMap1);
		System.out.println("Stream收集collect分组后取value之和存值：" + sumMap2);

		//统计所有
		IntSummaryStatistics statistics = userList.stream().collect(Collectors.summarizingInt(User::getAge));
		Map<String, IntSummaryStatistics> statisticsMap = userList.stream().collect(
				Collectors.groupingBy(User::getName, Collectors.summarizingInt(User::getAge)));
		System.out.println("Stream收集collect分组后Collectors类的summarizingInt方法：" + statistics);
		System.out.println("Stream收集collect分组后Collectors类的summarizingInt方法获取的总数count：" + statistics.getCount());
		System.out.println("Stream收集collect分组后取value所有统计存值：" + statisticsMap);
	}
}
