package com.mg.arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author mg
 * @date 2023-07-12
 */
public class ArraysTest {
    public static void main(String[] args) {
        String[] strings = {"a", "c", "b"};
        Arrays.sort(strings);
        System.out.println(Arrays.toString(strings));

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        String[] arrays = s.split("\\s");
        Arrays.sort(arrays);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrays.length; i++) {
            sb.append(arrays[i]);
            sb.append(" ");
        }
        String sbString=sb.toString();
        System.out.println(sbString.substring(0,sbString.length()-1));
    }
}
