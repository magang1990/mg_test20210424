package com.mg.shejimoshi.danli;

/**
 * @author mg
 * @Date 2021-06-26
 * @Version 1.0
 */
public class EHan {
	private String eName;
	private Integer eAge;

	public EHan() {
	}

	public EHan(String eName, Integer eAge) {
		this.eName = eName;
		this.eAge = eAge;
	}

	private static EHan ehan=new EHan("mg", 30);
	public static EHan getEHan(){
		return ehan;
	}
}
