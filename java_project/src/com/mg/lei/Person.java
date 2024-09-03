package com.mg.lei;

/**
 * @author mg
 * @date 2024-08-30
 */
public class Person extends PersonAbstract {

    @Override
    public void play() {
        System.out.println("这是非抽象类的play()方法");
    }
}
