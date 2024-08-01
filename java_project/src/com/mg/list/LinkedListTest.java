package com.mg.list;

import java.util.LinkedList;
import java.util.List;

/**
 * @author mg
 * @date 2023-07-11
 */
public class LinkedListTest {
    public static void main(String[] args) {
        List<String> linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.add(0, "a");
        linkedList.add(null);
        //linkedList.add(null);
        linkedList.remove(null);
        System.out.println(linkedList);
    }
}
