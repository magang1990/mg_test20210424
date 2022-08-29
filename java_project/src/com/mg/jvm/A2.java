package com.mg.jvm;

/**
 * @author mg
 * @Date 2021-05-22
 * @Version 1.0
 */
public class A2 {

	static {
		System.out.println("A2 static");
	}

	public A2(){
		System.out.println("A2 construct");
	}
}

class B extends A2{

	static {
		System.out.println("B static");
	}

	public B(){
		System.out.println("B construct");
	}

	public static void main(String[] args){
		 //B b = new B();
		A2 a2= new B();
		a2=new B();

		ClassLoader classLoader = a2.getClass().getClassLoader();
		System.out.println(classLoader);
		System.out.println(classLoader.getParent());
		System.out.println(classLoader.getParent().getParent());
	}
}


