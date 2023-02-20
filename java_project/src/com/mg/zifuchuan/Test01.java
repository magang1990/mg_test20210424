package com.mg.zifuchuan;

/**
 * @author mg
 * @Date 2023-02-17
 * @Version 1.0
 */
public class Test01 {
	public static void main(String[] args) {
		String s1 = "niubi";
		String s2 = "niu";
		String s3 = "bi";
		String s4 = s2 + s3;
		System.out.println(s1 == s4);//false
		final String s5 = "niu";
		final String s6 = "bi";
		String s7 = s5 + s6;
		System.out.println(s1 == s7);//true
	}
}
