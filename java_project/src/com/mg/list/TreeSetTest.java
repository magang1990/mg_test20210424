package com.mg.list;

import java.util.TreeSet;

/**
 * @author mg
 * @date 2024-07-06
 */
public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("b");
        treeSet.add("a");
        System.out.println(treeSet);

        TreeSet<Student> treeSet2 = new TreeSet<>();
        treeSet2.add(new TreeSetTest().new Student("a",1));
        treeSet2.add(new TreeSetTest().new Student("a",2));
        System.out.println(treeSet2);
    }

    public class Student implements Comparable{
        private String userName;
        private Integer userAge;

        public Student(String userName, Integer userAge) {
            this.userName = userName;
            this.userAge = userAge;
        }

        @Override
        public int compareTo(Object o) {
            Student stu2=(Student) o;
            if (!this.userName.equals(stu2.userName)) {
                return this.userName.compareTo(stu2.userName);
            }else {
                if (this.userAge>stu2.userAge) {
                    return -1;
                }else if(this.userAge<stu2.userAge) {
                    return 1;
                }else {
                    return 0;
                }
            }
        }

        @Override
        public String toString() {
            return "Student{" +
                    "userName='" + userName + '\'' +
                    ", userAge=" + userAge +
                    '}';
        }
    }
}
