package com.mg.zifuchuan;

/**
 * @author mg
 * @date 2024-07-09
 */
public class FormatTest {
    public static void main(String[] args) {
        //String s = String.format("%05d", 8);
        String s = String.format("%5d", 8);//用空字符串左补齐5位数长度字符
        System.out.println(s);
        double v = Math.log10(19);
        String replace = String.format("%5s", 80).replace(" ", "*");
        System.out.println("replace="+replace);

    }
}
