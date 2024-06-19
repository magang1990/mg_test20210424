package com.mg.arrays;

/**
 * 动态参数
 *
 * @author mg
 * @date 2024-05-17
 */
public class ArraysTest3 {
    public static void main(String[] args) {
        System.out.println(sum(1, 2));
        int[] nums = {1, 2, 3};
        System.out.println(sum(nums));
        System.out.println(sum2(nums));
    }

    public static int sum(int... nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public static int sum2(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

}
