package com.mg.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author mg
 * @date 2023-06-29
 *
 * list,有序，可重复。
 * set,无序，可重复。
 * 有序是按照添加顺序存储，无序是不按照添加顺序存储。
 */
public class SetTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("c");
        list.add("b");
        list.add("b");
        list.add("a");
        list.remove("b");

        Set<String> sets = new HashSet<>();
        sets.add("c");
        sets.add("b");
        sets.add("b");
        sets.add("a");
        sets.remove("b");

        System.out.println("list=" + list);
        System.out.println("sets=" + sets);
    }

}
