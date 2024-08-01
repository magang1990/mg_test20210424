package com.mg.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Builder就是基于建造者模式支持链式操作（调用builder()生成内部类实例，比较耗内存）
 * @Accessors(chain = true)使已有的setter方法返回this（对象本身）
 *
 * @author mg
 * @date 2024-07-31
 */
public class BuilderAndAccessorsTest {
    public static void main(String[] args) {
        People people = new People().setName("mg").setAge(18);
        System.out.println(people);
        Student student = new Student("class1","13","women");
        Student student1 = Student.builder().className("class2").classNo("14").build();

    }

}

@Data
@Accessors(chain = true)
class People{
    private String name;
    private Integer age;
    private String mobile = "110";
}

@Data
@Builder//@Data和@Builder一起用：我们发现没有了默认的无参构造方法。如果手动添加无参数构造方法（此时全参构造方法没了），手动添加全参构造方法。
@NoArgsConstructor
@AllArgsConstructor
class Student extends People{
    private String className;
    private String classNo;
    @Builder.Default// @Builder修饰的类属性默认值会失效，必须在属性上添加此注解
    private String sex= "man";
}
