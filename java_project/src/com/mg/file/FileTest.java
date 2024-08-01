package com.mg.file;

import java.io.File;

/**
 * @author mg
 * @date 2024-07-09
 */
public class FileTest {
    public static void main(String[] args) {
        File file1=new File("C:"+ File.separator+"Users\\37076\\Desktop\\a.txt");
        System.out.println("文件存放的绝对路径:"+file1.getAbsolutePath());
        System.out.println("文件存放的相对路径:"+file1.getPath());
        System.out.println("文件名 :"+file1.getName());
        System.out.println("文件是否可写  "+file1.canWrite());
        System.out.println("文件是否可读:"+file1.canRead());
        System.out.println("文件是否为隐藏文件:"+file1.isHidden());
        System.out.println("文件的长度:"+file1.length());
        System.out.println("文件的最后修改时间 :"+file1.lastModified());

        System.out.println("是否是文件："+file1.isFile());
        File file2=new File("C:"+ File.separator+"Users\\37076\\Desktop\\b");
        System.out.println("是否是文件夹："+file2.isDirectory());
        if (file2!=null&&file2.exists()) {
            file2.delete();
        }



    }
}
