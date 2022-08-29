package com.mg.test;

import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author mg
 * @Date 2021-06-21
 * @Version 1.0
 */
public class Test01 {
	public static void main(String[] args) {
		//生成10万个16位的订单号，前8位为当前时间如：“20180428”，后8位为递增。如：
		//20180428nnnnnnn1
		//20180428nnnnnnn2
		//20180428nnnnnn10
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String dateString = sdf.format(new Date());
		for (int i = 1; i <= 10; i++) {
			String si = String.valueOf(i);
			int x = 8 - si.length();
			StringBuilder sb = new StringBuilder(dateString);
			for (int i1 = 0; i1 < x; i1++) {
				sb.append("n");
			}
			sb.append(si);
			System.out.println(sb.toString());
		}

		//有1,2,3,4这四个数字，能组成多少个互不相同且不重复数字的三位数？都是多少？
		int num = 0;
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				for (int k = 1; k <= 4; k++) {
					if (i != j && j != k && i != k) {
						num+=1;
						System.out.println("不重复数："+(i*100+j*10+k));//要先运算，再拼接
					}
				}
			}
		}
		System.out.println("这样的数字的个数："+num);

		//根据文件夹路径，如：c：\abc下有多少个文件（包含文件夹）?
		File file =new File("c:/abc");
		if (file.exists()) {
//			File[] childrenFiles = file.listFiles();
//			for (File childrenFile : childrenFiles) {
//				if (file1.getName().endsWith(".txt")) {
//					System.out.println(file1.getName());
//				}
//			}
			File[] childrenFiles = file.listFiles(new FileFilter() {
				@Override
				public boolean accept(File pathname) {
					if (pathname.getName().endsWith(".txt")) {
						return true;
					}
					return false;
				}
			});
			for (File childrenFile : childrenFiles) {
				System.out.println(childrenFile.getName());
			}


			System.out.println(childrenFiles.length);
		} else {
			System.out.println("该文件夹不存在！");
		}
	}
}
