package com.mg.suanfa;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 示例 2:
 * 输入: nums = [0]
 * 输出: [0]
 *
 * @author mg
 * @date 2024-12-18
 */
public class SuanFaTest02 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        System.out.println(Arrays.toString(moveZero(nums)));
    }

    public static int[] moveZero(int[] nums) {
        int nextIndex = 0;//记录值不为0的最后一个元素下一个位置。
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[nextIndex];
                nums[nextIndex] = temp;
                nextIndex++;
            }
        }
        return nums;
    }
}
