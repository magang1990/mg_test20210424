package com.mg.system;

import java.util.Properties;

/**
 * @author mg
 * @date 2024-06-19
 */
public class Test01 {
    public static void main(String[] args) {
        //1. 获得当前系统的毫秒值
        Long t1=System.currentTimeMillis();
        //2.获得当前系统的纳秒值
        Long t2=System.nanoTime();
        //3.确定当前的系统属性。
        Properties p=System.getProperties();
        //4.获取指定键指示的系统属性。
        String s1=System.getProperty("sun.boot.library.path");
        //5.退出当前虚拟机
        //System.exit(0);
        //6.打印内容到控制台
        System.out.println(s1);
        //7.打印指定格式的内容到控制台
        System.out.printf("%.2f", 2.3445656);
        //8.打印“标准”错误输出流到控制台。
        System.err.println("标准错误输出流");
    }
}
