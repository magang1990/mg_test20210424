package com.mg.uuid;

import java.util.UUID;

/**
 * @author mg
 * @date 2024-10-27
 */
public class UuidTest {
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString();
        String replace = s.replace("-", "");
    }
}
