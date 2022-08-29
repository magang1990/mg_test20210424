package com.mg.shejimoshi.danli;

/**
 * @author mg
 * @Date 2021-06-26
 * @Version 1.0
 */
public class Test01 {
	public static void main(String[] args){
		EHan eHan = EHan.getEHan();
		System.out.println(eHan);
		EHan eHan2=EHan.getEHan();
		System.out.println(eHan2.equals(eHan));

		LanHan lanHan = LanHan.getLanHan();
		System.out.println(lanHan);
		LanHan lanHan2=LanHan.getLanHan();
		System.out.println(lanHan2);
		System.out.println(lanHan.equals(lanHan2));
	}

}
