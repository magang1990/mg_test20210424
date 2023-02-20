package com.mg.switchtest;

/**
 * @author mg
 * @Date 2022-10-26
 * @Version 1.0
 */
public class Test01 {
	public static void main(String[] args) {
		String s="b";
		switch (s){
			case "a":
				System.out.println("xiao a");
				break;
			case "b":
				System.out.println("xiao b");
				//break;
			default:
				System.out.println("no answer");
		}

	}

}
