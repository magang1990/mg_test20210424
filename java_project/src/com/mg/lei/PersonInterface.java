package com.mg.lei;

/**
 * @author mg
 * @date 2024-06-16
 */
public interface PersonInterface {

    void play();

    default void play2(){
        System.out.println("PersonInterface接口默认实现方法play2()");
    }

}
