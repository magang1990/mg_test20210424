package com.mg.lei;

import lombok.Data;

/**
 * @author mg
 * @date 2024-06-16
 */
@Data
public class Outer {

    private String name;

    private static final Integer AGE=1;

    /**
     * 成员内部类-实例内部类
     */
    @Data
    public class Inner1{
        private String name;
        private String sex;

        public String show1() {
            return name;
        }

        public String show2() {
            return Outer.this.name;
        }
    }

    /**
     * 成员内部类-静态内部类
     */
    public static class Inner2{
        private String code;
    }

    private Inner1 i1=new Inner1();
    private Inner2 i2=new Inner2();

    public void run() {
        Inner1 inner1 = new Inner1();
        Inner2 inner2 = new Inner2();

        /**
         * 局部内部类
         */
        class JuBuInner{
            private String niu;
        }
    }

}
