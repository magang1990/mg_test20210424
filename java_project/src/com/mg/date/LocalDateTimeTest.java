package com.mg.date;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author mg
 * @date 2024-11-27
 */
public class LocalDateTimeTest {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime = now.minusDays(1);
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
