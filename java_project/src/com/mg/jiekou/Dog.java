package com.mg.jiekou;

/**
 * @author mg
 * @Date 2021-05-26
 * @Version 1.0
 */
public class Dog implements Animl {

	@Override
	public void eat() {
		System.out.println("吃狗粮");
	}

	@Override
	public String aName(int aId) {
		if (aId == 1) {
			return "wangcai";
		}
		return "laifu";
	}
}
