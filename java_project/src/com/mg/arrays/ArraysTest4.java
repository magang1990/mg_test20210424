package com.mg.arrays;

/**
 * 二维数组
 *
 * @author mg
 * @date 2024-06-15
 */
public class ArraysTest4 {
    public static void main(String[] args) {
        String[][] strings = new String[][]{{"a", "b"}, {"a1"}};
        String[][] strings2 = {{"a", "b"}, {"a1"}};
        /*for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length; j++) {
                System.out.println(strings[i][j]);
            }
        }*/
        /*for (String[] string : strings) {
            for (String s : string) {
                System.out.println(s);
            }
        }*/

        int num = 10;
        int[][] nums = new int[num][];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = new int[i + 1];
            for (int j = 0; j < nums[i].length; j++) {
                if (j == 0 || j == nums[i].length - 1) {
                    nums[i][j] = 1;
                } else {
                    nums[i][j] = nums[i][j - 1] + nums[i - 1][j];
                }
                System.out.print(nums[i][j] + "\t");
            }
            System.out.println("\n");
        }

    }
}
