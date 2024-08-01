package com.mg.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author mg
 * @date 2024-07-12
 */
public class FileInputStreamTest {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("C:" + File.separator + "Users\\37076\\Desktop\\a.txt");
            //调用流对象的方法读取文件中的内容,如果一个字节一个字节的读，读取的是这个字节所对应的unicode字符编码
            int content = fileInputStream.read();
            while (content != -1) {
                //将读取的Unicode字符编码强转成Char
                System.out.println((char)content);
                content=fileInputStream.read();
            }
            System.out.println("已读取完毕！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
