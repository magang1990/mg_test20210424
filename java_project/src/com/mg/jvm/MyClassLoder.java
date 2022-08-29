package com.mg.jvm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author mg
 * @Date 2021-05-27
 * @Version 1.0
 */
public class MyClassLoder extends ClassLoader {

	//指定路径加载类
	private String classPath;

	public MyClassLoder(String classPath) {
		this.classPath = classPath;
	}

	//破坏双亲委派机制，指定自定义类加载器优先加载。重写loadClass方法
	@Override
	protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
		synchronized (getClassLoadingLock(name)) {
			// First, check if the class has already been loaded
			Class<?> c = findLoadedClass(name);
			if (c == null) {
				long t0 = System.nanoTime();

				if (name.startsWith("com.mg.jvm")) {
					c=findClass(name);
				}else {
					c=this.getParent().loadClass(name);
				}
			}
			if (resolve) {
				resolveClass(c);
			}
			return c;
		}
	}

	//自定义类加载器，继承ClassLoader类并重写findClass方法
	@Override
	protected Class<?> findClass(String className) throws ClassNotFoundException {
		//根据类全名获取对应字节数组
		byte[] data = loadByte(className);
		//通过JDK提供的API，将字节数组转化为class对象
		return defineClass(className, data, 0, data.length);
	}

	private byte[] loadByte(String className) {
		//将类全名转换为完整路径
		className = className.replaceAll("\\.", "/");
		StringBuilder stringBuilder = new StringBuilder(classPath);
		stringBuilder.append(className);
		stringBuilder.append(".class");
		//采用文件字节流读取文件内容，并将其转化为字节数组
		FileInputStream fis=null;
		try {
			fis= new FileInputStream(stringBuilder.toString());
			//创建字节数组，用于存放字节内容
			byte[] data = new byte[fis.available()];
			fis.read(data);
			return data;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		//返回字节数组
		return null;
	}
}
