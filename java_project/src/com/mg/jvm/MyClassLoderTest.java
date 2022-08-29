package com.mg.jvm;

/**
 * @author mg
 * @Date 2021-05-27
 * @Version 1.0
 */
public class MyClassLoderTest {

	public static void main(String[] args) throws ClassNotFoundException {
		MyClassLoder myClassLoder = new MyClassLoder("C:\\Users\\37076\\Desktop\\version1\\");
		Class<?> aClass = myClassLoder.loadClass("com.mg.jvm.Cat");

		System.out.println(aClass.getClassLoader());
		System.out.println(aClass.getClassLoader().getParent());
		System.out.println(aClass.getClassLoader().getParent().getParent());

		MyClassLoder myClassLoder2 = new MyClassLoder("C:\\Users\\37076\\Desktop\\version2\\");
		Class<?> aClass2 = myClassLoder.loadClass("com.mg.jvm.Cat");

		System.out.println(aClass2.getClassLoader());
		System.out.println(aClass2.getClassLoader().getParent());
		System.out.println(aClass2.getClassLoader().getParent().getParent());
	}

}
