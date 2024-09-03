package com.mg.lei;

/**
 * @author mg
 * @date 2024-06-16
 */
public class InnerTest {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.setName("mg");

        Outer.Inner1 inner1 = new Outer().new Inner1();
        Outer outer1 = new Outer();
        outer1.setName("mgOuter");
        Outer.Inner1 inner11 = outer1.new Inner1();
        inner11.setName("mgInner");
        System.out.println(inner11.show1());
        System.out.println(inner11.show2());

        PersonAbstract personAbstract = new PersonAbstract() {
            @Override
            public void play() {
                System.out.println("这是抽象类匿名内部类的实现方法");
            }
        };
        personAbstract.play();

        Person person = new Person() {
            @Override
            public void play() {
                System.out.println("这是非抽象类匿名内部类的实现方法");
            }
        };
        person.play();

        //使用Lambda表达式必须是函数式接口，即该接口所有方法只含有一个抽象方法的接口
        PersonInterface personInterface1 = () -> System.out.println("这是接口匿名内部类的实现方法");
        personInterface1.play2();
        PersonInterface personInterface = new PersonInterface() {
            @Override
            public void play() {
                System.out.println("这是接口匿名内部类的实现方法");
            }
        };
        personInterface.play();

    }
}
