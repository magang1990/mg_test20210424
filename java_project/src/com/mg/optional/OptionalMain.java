package com.mg.optional;

import java.util.Optional;

/**
 * @author mg
 * @Date 2021-08-23
 * @Version 1.0
 */
public class OptionalMain {
	public static void main(String[] args){
	  	String str="niu";
	  	String str1=null;
	  	Integer i=6;
		System.out.println(Optional.ofNullable(i).orElse(8));


	}
}
