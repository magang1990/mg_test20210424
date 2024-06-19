package com.mg.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mg
 * @date 2024-06-06
 */
public class Test04 {
    public static void main(String[] args) {

        int flag = 1;
        intShow(flag);
        System.out.println("方法后flag=" + flag);
        Integer num = 128;
        integerShow(num);
        System.out.println("方法后num=" + num);

        User user = new User();
        user.setName("mg");
        user.setAge(1);
        objectShow(user, "mg1", 11);
        System.out.println("方法后user=" + user);

        Map<String, String> map = new HashMap<>();
        map.put("niu", "a");
        map.put("bi", "b");
        mapShow(map, "a1", "b1");
        System.out.println("方法后map=" + map);

        String s = "hello";
        stringShow(s);
        System.out.println("方法后s=" + s);

        StringBuilder sb = new StringBuilder("nihao");
        stringbuiderShow(sb);
        System.out.println("方法后sb=" + sb);
    }

    private static void stringbuiderShow(StringBuilder sb) {
        sb.append("1");
        System.out.println("方法中sb=" + sb);
    }

    private static void stringShow(String s) {
        s = s + 1;
        System.out.println("方法中s=" + s);
    }

    private static void mapShow(Map<String, String> map, String a1, String b1) {
        map.put("niu", a1);
        map.put("bi", b1);
        System.out.println("方法中map=" + map);
    }

    private static void objectShow(User user, String mg1, int i) {
        user.setName(mg1);
        user.setAge(i);
        System.out.println("方法中user=" + user);
    }

    private static void intShow(int flag) {
        flag++;
        System.out.println("方法中flag=" + flag);
    }

    private static void integerShow(Integer num) {
        num++;
        System.out.println("方法中num=" + num);
    }

}

class User {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
