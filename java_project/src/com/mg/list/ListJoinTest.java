package com.mg.list;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author mg
 * @date 2023-07-17
 */
public class ListJoinTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        /*List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);*/

        //List<String> list=new ArrayList<>();

        String[] arr = {"a", "b", "c"};
        //int[] s={1,2,3};

        // 方法一，常规遍历集合或数组，然后截取掉最后的分隔符
        // 集合
        StringBuilder sbList = new StringBuilder();
        for (String s1 : list) {
            sbList.append(s1);
            sbList.append(",");
        }
        String substring1 = sbList.toString().substring(0, sbList.length() - 1);//"a,b,c"
        // 数组
        StringBuilder sbArray = new StringBuilder();
        for (String s1 : arr) {
            sbArray.append(s1);
            sbArray.append(",");
        }
        String substring2 = sbArray.toString().substring(0, sbArray.length() - 1);//"a,b,c"

        // 方法二，String类的join方法。可处理数组和集合。
        // 集合或数组为null时，报NullPointerException异常。list为空集合时，返回结果为空字符串。
        // 集合或数组中元素为null时，拼接null（"null,null,null"）。数组只声明，未赋值值时，默认值（null）拼接（"null,null,null"）。
        // 集合或数组中元素为非String类型时，直接报参数类型错误。
        // 分隔符delimiter为null时，报NullPointerException异常。
        // 集合
        String joinList2 = String.join(",", list);
        System.out.println(joinList2);
        // 数组
        String joinArray2 = String.join(",", arr);
        System.out.println(joinArray2);

        // 方法三，steram的收集中，Collectors的joining方法。可处理数组和集合。
        // 集合或数组为null时，报NullPointerException异常。list为空集合时，返回结果为空字符串。
        // 集合或数组中元素为null时，拼接null（"null,null,null"）。数组只声明，未赋值值时，默认值（null）拼接（"null,null,null"）。
        // 集合或数组中元素为非String类型时，直接报参数类型错误。
        // 分隔符delimiter为null时，报NullPointerException异常。
        // 集合
        String joinList3 = list.stream().collect(Collectors.joining(","));
        System.out.println(joinList3);
        // 数组
        String joinArray3 = Arrays.stream(arr).collect(Collectors.joining(","));
        System.out.println(joinArray3);

        // 非String类型,先转化为String类型
        List<Integer> list2 = Arrays.asList(1, 2, 3);
        String collect = list2.stream().map(String::valueOf).collect(Collectors.joining());//"123"
        String collect1 = list2.stream().map(String::valueOf).collect(Collectors.joining(","));//"1,2,3"
        String collect2 = list2.stream().map(String::valueOf).collect(Collectors.joining(",", "start-", "-end"));//"start-1,2,3-end"

        // 对象类型集合
        List<User> list3 = Arrays.asList(new User("mayun", 59),
                new User("mayun", 1),
                new User("leijun", 54));
        Map<String, String> map = list3.stream().collect(
                Collectors.groupingBy(User::getUserName,
                        Collectors.mapping(e -> String.valueOf(e.getUserAge()), Collectors.joining(","))));//{mayun=59,1, leijun=54}

        // 方法四，需要导入lang3包 lang3的StringUtils工具类的join方法。可处理数组和集合。
        // 集合或数组为null时，返回结果为null。list为空集合时，返回结果为空字符串。
        // 集合或数组中元素为null时，拼接空字符串（ , , ）。数组只声明，未赋值值时，空字符串拼接（ , , ）。
        // 集合中元素为非String类型时，正常拼接。数组中元素为非String类型时，separator连接字符必须为char类型。
        // 分隔符delimiter为null时，直接无分隔符拼接（abc）。
        // 集合
        String joinList4 = StringUtils.join(list, ",");//"a,b,c"
        System.out.println(joinList4);
        // 数组
        String joinArray4 = StringUtils.join(arr, ",");//"a,b,c"
        System.out.println(joinArray4);
        //System.out.println(StringUtils.join(arr, ",".charAt(0)));

    }
}
