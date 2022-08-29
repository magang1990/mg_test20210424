package com.mg.test;

/**
 * @author mg
 * @Date 2021-07-01
 * @Version 1.0
 */
public class Test02 {
	public static void main(String[] args){
		Test02 test02 = new Test02();
		test02.first();
	}

	public void first(){
		int i=5;
		Value v = new Value();
		v.i=25;
		second(v,i);
		System.out.print(v.i);
	}

	private void second(Value v, int i) {
		i=0;
		v.i=20;
		Value val = new Value();
		v=val;
		System.out.print(v.i+" "+i);
	}
}

class Value{
	public int i=15;
}

