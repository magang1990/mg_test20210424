package com.mg.date;

import java.util.Calendar;

/**
 * @author mg
 * @Date 2023-04-24
 * @Version 1.0
 */
public class CalendarTest {
	public static void main(String[] args) {
		//根据当前系统时区和语言环境获取日历对象
		Calendar calendar = Calendar.getInstance();
		//Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+14"));
		//获取日历年月日
		System.out.println("当前年份：" + calendar.get(Calendar.YEAR));
		System.out.println("当前月份：" + (calendar.get(Calendar.MONTH) + 1));
		System.out.println("当前日：" + calendar.get(Calendar.DATE));
		System.out.println("当前日：" + calendar.get(Calendar.DAY_OF_MONTH));
		//设置指定日历
		calendar.set(Calendar.MONTH, 0);
		System.out.println("指定月份：" + (calendar.get(Calendar.MONTH) + 1));
		System.out.println(calendar);
		
	}
}
