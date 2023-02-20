package com.mg.intergertest;

/**
 * @author mg
 * @Date 2022-10-06
 * @Version 1.0
 */
public class Test01 {
	public static void main(String[] args) {
		Integer i = 127;
		Integer i2 = 128;
		/*Integer i3 = new Integer(127);
		Integer i4 = new Integer(128);*/
		int i5 = 127;
		int i6 = 128;
		Integer i7 = 127;
		Integer i8 = 128;
		System.out.println(i == i7);
		System.out.println(i2 == i8);

		Integer integer = Integer.valueOf(128);

	}

}
