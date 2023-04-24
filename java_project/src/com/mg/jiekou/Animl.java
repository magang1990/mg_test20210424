package com.mg.jiekou;

public interface Animl {

	void eat();
	String aName(int aId);

	public default void aAge(){

	}//JDK1.8后允许接口有默认的方法

}
