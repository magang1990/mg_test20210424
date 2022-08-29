package com.mg.zhengze;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author mg
 * @Date 2021-05-23
 * @Version 1.0
 */
public class RegexTest {

	public static void main(String[] args) {
		String phone = "13125169793";
		System.out.println(phone.matches("1[3578]\\d{9}"));

		Pattern pattern = Pattern.compile("1[3578]\\d{9}");
		Matcher matcher = pattern.matcher("13125169793");
		boolean result = matcher.matches();
		System.out.println(result);

	}
}
