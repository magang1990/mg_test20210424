package com.mg.shejimoshi.danli;

/**
 * @author mg
 * @Date 2021-06-26
 * @Version 1.0
 */
public class LanHan {
	private String lName;
	private Integer lAge;

	public LanHan() {
	}

	public LanHan(String lName, Integer lAge) {
		this.lName = lName;
		this.lAge = lAge;
	}

	private static LanHan lanhan=null;
	public synchronized static LanHan getLanHan(){
		return new LanHan("mc", 29);
	}
}
