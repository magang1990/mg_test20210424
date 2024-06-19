package com.mg.test;

/**
 * @author mg
 * @date 2024-06-16
 */
public class Test05 {
    public static void main(String[] args) {
        //1.返回与当前 Java 应用程序相关的运行时对象。
        Runtime rt=Runtime.getRuntime();
        //2.返回 Java 虚拟机中的内存总量。
        System.out.println("虚拟机中的内存总量"+rt.totalMemory()/(1024*1024));
    }

}
