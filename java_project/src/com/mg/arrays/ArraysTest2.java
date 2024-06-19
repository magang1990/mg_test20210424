package com.mg.arrays;

/**
 * @author mg
 * @date 2024-03-16
 */
public class ArraysTest2 {
    public static void main(String[] args) {
        /*int[] nums = new int[3];
        Integer[] nums2 = new Integer[3];
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(nums2));*/

        int[] nums3 = {3, 1, 8, 9, 10, 2};
        int min = nums3[0];
        int max = nums3[0];
        for (int i = 1; i < nums3.length; i++) {
            if (min > nums3[i]) {
                min = nums3[i];
            }

            if (max < nums3[i]) {
                max = nums3[i];
            }
        }
        System.out.println("nums3数组最小值min=" + min);
        System.out.println("nums3数组最小值max=" + max);
    }
}
