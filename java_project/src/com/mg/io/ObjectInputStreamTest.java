package com.mg.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * @author mg
 * @date 2024-07-12
 */
public class ObjectInputStreamTest {
    public static void main(String[] args) throws Exception {
        //1.创建对象输入流
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("C:" + File.separator + "Users\\37076\\Desktop\\c.txt"));
        //2.读取文件中的内容
        //存入多个对象时，第三种：将多个对象存入集合，将集合序列化
        ArrayList<Student> ob=(ArrayList<Student>) ois.readObject();
        for (int i = 0; i < ob.size(); i++) {
            System.out.println(ob.get(i).sname+"====="+ob.get(i).sage);
        }

        //存入多个对象时，第二种：作标记，标记存入的对象的个数
//     int count=ois.readInt();
//     for (int i = 0; i < count; i++) {
//         Object ob1=ois.readObject();
//         if (ob1 instanceof Student) {
//            Student stu1=(Student) ob1;
//            System.out.println(stu1.sname+"====="+stu1.sage+"====="+stu1.stuNo+"====="+stu1.sex);
//         }
//     }

//     Object ob1=ois.readObject();
        //存入多个对象时，第一种：作标记，标记已经读到最后一个对象
//     while (ob1!=null) {
//
//         if (ob1 instanceof Student) {
//            Student stu1=(Student) ob1;
//            System.out.println(stu1.sname+"====="+stu1.sage+"====="+stu1.stuNo+"====="+stu1.sex);
//         }
//         ob1=ois.readObject();
//     }

        //3.关流
        ois.close();
    }
}
