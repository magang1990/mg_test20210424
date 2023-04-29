package com.mg.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author mg
 * @Date 2021-08-07
 * @Version 1.0
 */
public class SimpleDateFormatTest {
	public static void main(String[] args){
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyMM");
		System.out.println(sdf.format(date));

	}
}
