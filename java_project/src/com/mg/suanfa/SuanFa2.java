package com.mg.suanfa;

import java.util.Arrays;

/**
 * @author mg
 * @Date 2021-05-10
 * @Version 1.0
 */
public class SuanFa2 {
	public static void main(String[] args) {

		System.out.println("1-200间所有的素数：");
		int num = 0;
		for (int i = 2; i <= 200; i++) {
			boolean flag = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					flag = false;
					break;
				}
			}

			if (flag == true) {
				System.out.print(i + "\t");
				num++;
			}
		}
		System.out.println("\n" + "质素个数：" + num);


		//1.返回第一个参数的第二个参数次幂的值。
		Double num1 = Math.pow(2, 3);
		System.out.println(num1);
		//2.返回最小的（最接近负无穷大）double 值，该值大于等于参数，并等于某个整数。
		Double num2 = Math.ceil(25.1);
		System.out.println(num2);
		//3.返回最大的（最接近正无穷大）double 值，该值小于等于参数，并等于某个整数。
		Double num3 = Math.floor(25.1);
		System.out.println(num3);
		//4. 四舍五入
		Long num4 = Math.round(25.1);
		System.out.println(num4);
		//5.返回两个值中较大的一个。
		Integer num5 = Math.max(22, 13);
		System.out.println(num5);
		//6.返回两个 值中较小的一个。
		Integer num6 = Math.min(22, 13);
		System.out.println(num6);
		//7.生成0到1之间的随机数
		double num7 = Math.random();
		System.out.println(num7);
		//8.总结生成随机数的公式(int)(Math.random()*(max-min+1))+min;
		//75-100之间的随机数
		int num8 = (int) (Math.random() * 26 + 75);
		System.out.println(num8);

		int[] nums={1,8,6,4,5,3};
		for (int i = 0; i < nums.length-1; i++) {
			for (int j = 0; j < nums.length-1-i; j++) {
				if (nums[j] > nums[j+1]) {
					int tem=nums[j];
					nums[j]=nums[j+1];
					nums[j+1]=tem;
				}
			}
		}
		System.out.println(Arrays.toString(nums));

		int[] nums2={1,8,6,4,5,3};
		for (int i = 0; i < nums2.length-1; i++) {
			for (int j = i+1; j < nums2.length; j++) {
				if (nums2[i] > nums2[j]) {
					int tem=nums2[i];
					nums2[i]=nums2[j];
					nums2[j]=tem;
				}
			}
		}
		System.out.println(Arrays.toString(nums2));
	}
}
