package com.mg.meiju;

/**
 * @author mg
 * @Date 2021-08-01
 * @Version 1.0
 */
public class MeiJuMain {
	public static void main(String[] args){
		System.out.println(MeiJuEnum.ARTIFICIAL.getValue());
		MeiJuEnum artEnumObj = MeiJuEnum.valueOf("ARTIFICIAL");
		System.out.println(artEnumObj);
		System.out.println(artEnumObj.getKey());
		System.out.println(artEnumObj.getValue());
	}

}
