package com.mg.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * @author mg
 * @date 2024-07-12
 */
public class ObjectOutputStreamTest {
    public static void main(String[] args) throws Exception {
        //1.创建对象输出流
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("C:" + File.separator + "Users\\37076\\Desktop\\c.txt"));
        //2.用对象输出流的对象调方法，将对象写入到文件中

        //第一种：存的是字符串对象
//     String s1=new String("人之所以是高级动物，是因为人会思考，犯困时会自我调节");
//     oos.writeObject(s1);

        //第二种：存入一个自定义的对象
//     Student stu1=new Student("张三", 11);
//     stu1.stuNo=11;
//     stu1.sex='男';

        //第三种：存入多个对象
        Student stu1=new Student("杨光学", 50);
        Student stu2=new Student("刘清文", 80);
        Student stu3=new Student("李国梁", 79);
        //存入多个对象时，第三种：将多个对象存入集合，将集合序列化
        ArrayList<Student> stuList=new ArrayList<>();
        stuList.add(stu1);
        stuList.add(stu2);
        stuList.add(stu3);

        oos.writeObject(stuList);


        //存入多个对象时，第二种：作标记，标记存入的对象的个数
//     oos.writeInt(3);
//     oos.writeObject(stu1);
//     oos.writeObject(stu2);
//     oos.writeObject(stu3);
        //存入多个对象时，第一种：作标记，标记已经读到最后一个对象
        //oos.writeObject(null);

        System.out.println("写入成功");
        //3.关流
        oos.close();
    }

}
