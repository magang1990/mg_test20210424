package com.mg.debug;

import java.util.Arrays;

/**
 * @author mg
 * @Date 2022-08-29
 * @Version 1.0
 */
public class DeBugTest {

	public static void run() {
		String s = "mg";
		System.out.println(s);
	}

	public static void method() {
		IService iService = new ServiceImpl();
		iService.execute();
		String s="niu";
		int length = s.length();
		System.out.println(length);
	}

	//异常断点，全局捕获
	public static void exception() {
		String s = null;
		s.length();
		System.out.println(s);
	}

	//字段断点，读写监控
	public static void field() {
		Person person = new Person("mg",31);
		person.setAge(32);
		System.out.println(person);
	}

	// stream
	public static void stream() {
		Arrays.asList("mg","ml","maj").stream()
				.filter(e->e.startsWith("m"))
				.map(e->e+"nb")
				.forEach(System.out::println);
	}

	public static void main(String[] args) {
		//run();
		method();
		//exception();
		//field();
		//stream();
	}

}
