package com.mg.test;

import java.util.*;

/**
 * @author mg
 * @Date 2022-05-14
 * @Version 1.0
 */
public class Test03 {
	/**
	 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，
	 * 并返回它们的数组下标。
	 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
	 * 你可以按任意顺序返回答案。
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		int[] ints = twoSum(new int[]{1, 2, 3, 7, 4}, 4);
		int[] ints2 = twoSum(new int[]{1, 2, 3, 7, 4}, 4);
		int ints3 = toMax(new int[]{1, 2, 3, 7, 4});
		System.out.println(Arrays.toString(ints));
		System.out.println(Arrays.toString(ints2));
		System.out.println( ints3);
	}

	public static int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[]{i, j};
				}
			}
		}
		return new int[0];
	}

	public static int[] twoSum2(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target-nums[i])) {
				return new int[]{map.get(target-nums[i]),i};
			}
			map.put(nums[i], i);
		}
		return new int[0];
	}

	public static int toMax(int[] nums) {
		List<Integer> integers = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j]-nums[i]<0) {
					continue;
				}
				integers.add(nums[j]-nums[i]);
			}
		}

		if (integers.size()==0) {
			return 0;
		}

		Collections.sort(integers);
		return integers.get(integers.size()-1);
	}
}
