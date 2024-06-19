package com.mg.suanfa;

import java.util.Arrays;

/**
 * @author mg
 * @Date 2021-05-09
 * @Version 1.0
 */
public class SuanFaTest {
	public static void main(String[] args) {
		/**
		 * 1.生成10个75-100之间(包含75和100)的随机整数，将其存放到数组中，并遍历输出数组的数据
		 */
		int[] num = new int[10];

		for (int i = 0; i < num.length; i++) {
			num[i] = (int) (Math.random() * 26 + 75);
		}

		for (int n : num) {
			System.out.print(n + "\t");
		}
		System.out.println();
		System.out.println(Arrays.toString(num));

		/**
		 * 2.求该数组的数据之和和平均数（平均数保留两位小数点）
		 */
		int sum = 0;
		for (int n : num) {
			sum = sum + n;
		}
		System.out.println("数组各数据之和：" + sum);

		double avg = sum / 10.0;
		String s = String.format("%.2f", avg);
		System.out.println("数组各数据之和平均数：" + s);

		/**
		 * 3.求该数组的最大值和最小值
		 */
		int max = num[0];
		int min = num[0];
		for (int i = 0; i < num.length; i++) {
			if (num[i] > max) {
				max = num[i];
			}

			if (num[i] < min) {
				min = num[i];
			}
		}
		System.out.println("该数组最大值是：" + max + ",最小值：" + min);


		/**
		 * 4.请任选冒泡、选择、插入或其他排序算法，对上述的数组进行排序，请注明你采用的排序算法
		 */
		//冒泡
		for (int i = 0; i < num.length - 1; i++) {
			for (int j = 0; j < num.length - i - 1; j++) {
				if (num[j] > num[j + 1]) {
					int tem = num[j + 1];
					num[j + 1] = num[j];
					num[j] = tem;
				}
			}
		}

		for (int i : num) {
			System.out.print(i + "\t");
		}
		System.out.println();

		//选择排序
		int[] num2 = {6, 5, 1, 3, 4, 9};
		for (int i = 0; i < num2.length - 1; i++) {
			for (int j = i + 1; j < num2.length; j++) {
				if (num2[i] > num2[j]) {
					int tem = num2[i];
					num2[i] = num2[j];
					num2[j] = tem;
				}
			}
		}
		System.out.println(Arrays.toString(num2));

		int[] nums={1,8,6,4,5,3};
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
	}
}
