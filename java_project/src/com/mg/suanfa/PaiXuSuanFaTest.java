package com.mg.suanfa;

import java.util.Arrays;

/**
 * @author mg
 * @date 2024-05-17
 */
public class PaiXuSuanFaTest {
    public static void main(String[] args) {
        //int[] nums = {18, 1, 2, 3, 9, 6, 4, 17, 19, 20, 16, 15, 5, 7, 8, 10, 14, 13, 11, 12};
        int[] nums = new int[1000];
        for (int i = 0; i < nums.length; i++) {
            //nums[i]=(int) (Math.random() * 1000 + 1);
            nums[nums.length - i - 1] = i + 1;
        }
        long start = System.currentTimeMillis();
        // 法一，冒泡排序（效率比较低）
        bubbleSort(nums);

        // 法二，插入排序
        insertionSort(nums);

        // JDK自带工具排序
         Arrays.sort(nums);
        long end = System.currentTimeMillis();
        System.out.println("排序之后的数组：" + Arrays.toString(nums));
        System.out.println("当前排序算法用时：" + (end - start));
    }

    private static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    private static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = false;
                }
            }

            if (flag) {
                break;
            }
        }
    }
}
