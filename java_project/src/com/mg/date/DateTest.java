package com.mg.date;

import java.util.Date;

/**
 * @author mg
 * @date 2023-06-26
 */
public class DateTest {
    public static void main(String[] args) {
        Date currentDate = new Date();
        // 返回January 1, 1970, 00:00:00距今的毫秒数
        long time = currentDate.getTime();
        System.out.println(time);

    }

}
