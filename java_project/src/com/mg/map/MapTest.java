package com.mg.map;

import java.util.*;

/**
 * @author mg
 * @Date 2021-05-23
 * @Version 1.0
 */
public class MapTest {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();//没有设置容量时默认16,0.75f加载因子，容量达到0.75则按两倍扩容。
        String put = map.put("human", "mg");
        map.put("animl", "naiyou");
        String put1 = map.put("human", "ml");
        String put2 = map.put("human", "ml");
        int num =1 << 4;

        System.out.println(map.get("human"));
        System.out.println(map);

        HashMap<Long, User> uMap = new HashMap<>();
        User user = new User("mg", 30);
        uMap.put(1L, user);
        System.out.println(uMap);
        user.setAge(18);
        System.out.println(uMap);


        //遍历map方法一
        System.out.println("方法一key" + "-----" + "value");
        for (Map.Entry<String, String> mEntry : map.entrySet()) {
            String key = mEntry.getKey();
            String value = mEntry.getValue();
            System.out.println(key + "\t" + value);
        }

        //遍历map方法二（只有所有key值)
        System.out.println("方法二key" + "-----" + "value");
        for (String s : map.keySet()) {
            System.out.println(s + "\t" + map.get(s));
        }

        //遍历map方法三,迭代器（此方法中可以删除entry，唯一一种）
        System.out.println("方法三key" + "-----" + "value");
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }

        //遍历map方法四，values()方法（只有所有value值）
        for (String value : map.values()) {
            System.out.println(value);
        }

        //遍历map方法五，Lambda 表达式
        map.forEach((k, v) -> {
            System.out.println("key=" + k + ",value=" + v);
        });

        //遍历map方法五，stream的Lambda 表达式
        map.entrySet().stream().forEach((entry) -> {
            System.out.println("key=" + entry.getKey() + ",value=" + entry.getValue());
        });

        LinkedHashMap<String, String> hmap1 = new LinkedHashMap<>();
        //向LinkedHashMap集合中添加元素
        hmap1.put("aa", "张三1");
        hmap1.put("bb", "张三2");
        hmap1.put("aa", "张三3");
        hmap1.put("cc", "张三4");

        //第一种：遍历LinkedHashMap集合
        Set<String> keys = hmap1.keySet();
        for (String k : keys) {
            System.out.println(k + "*********" + hmap1.get(k));
        }

        hmap1.forEach((key, value) -> {
            System.out.print(key + "-" + value + "\t");
            System.out.print(key + "-" + value + "\t");
        });
    }

}
